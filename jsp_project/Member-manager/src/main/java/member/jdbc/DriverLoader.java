package member.jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DriverLoader extends HttpServlet{

//	init() : 컨테이너가 서블릿 객체를 만들때 실행되는 요소
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 데이터베이스 드라이버 로드

		String params = config.getInitParameter("driver");
		
		try {
			if(params != null) {
				Class.forName(params);
				System.out.println("드라이버 로드 성공!");
			} else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("드라이버 로드 성공!");
			}
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
 	}

}
	}
