package slipp.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/api/users/find")
public class ApiFindUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		if(userId == null){
			resp.sendRedirect("/");
			return;
		}
		
		UserDAO userDao = new UserDAO();
		try {
			User user = userDao.findByUserId(userId);
			if(user == null){
				return;
			}
			
			final GsonBuilder builder = new GsonBuilder();
			builder.excludeFieldsWithoutExposeAnnotation();
			final Gson gson = builder.create();

			String jsonData = gson.toJson(user);
			resp.setContentType("application/json;charset=UTF-8");	//이게 없으면 Response Header에 아무런 content type 정보가 없음! 그래서 json의 contenttype으로 설정해서 보내주는 것!

			PrintWriter out = resp.getWriter();
			out.print(jsonData);
		} catch (SQLException e){
		}
	}
}
