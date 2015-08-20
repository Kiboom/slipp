package slipp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="HelloWorld", urlPatterns={"/helloworld", "/hello"})
public class HelloWorldServlet extends HttpServlet{
	private String name;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		name = req.getParameter("name");
		System.out.println("Request Success!");
		resp.getWriter().print(name + "Hello World from Servlet!");
	}
	
	ArrayList<Integer> a = new ArrayList<Integer>();
}
