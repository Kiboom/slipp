package slipp.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/update")
public class UpdateUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 로그인 안한 사용자가 함부로 접근 못하게 세션 체크함. */
		HttpSession session = request.getSession();
		String userId = SessionUtils.getStringValue(session, LoginServlet.SESSION_USER_ID);
		if(userId == null){
			response.sendRedirect("/");
			return;
		}
		

		/* 사용자가 업데이트 하기 위해 전달했던 유저 아이디와, 현재 로그인을 한 세션에 들어있는 유저아이디가 같은지 비교해줘야! 안그러면 임의로 다른 유저를 변경할 수 있게됨 */
		String sessionUserId = request.getParameter("userId");
		if(sessionUserId.equals(userId)){
			response.sendRedirect("/"); 	// 악의적으로 다른 사용자의 정보를 조작하는 걸 방지하기 위한 것.
			return;
		}
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user = new User(userId, password, name, email);
		UserDAO userDAO = new UserDAO();
		try{
			userDAO.updateUser(user);
		}catch (SQLException e){
		}
		
		response.sendRedirect("/");
	}
}
