package firstWeb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET로 요청");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("	<head><title>NowServlet</title></head>");
		writer.println("<body>");
		writer.println("<h1>" + new Date() + "</h1>");
		writer.println("</body>");
		writer.println("</html>");
	
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST로 요청");
	}

	
	
}
