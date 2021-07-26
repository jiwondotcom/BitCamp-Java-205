package jdbc.util;

import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class jdbcListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
		try {
		ServletContext context = sce.getServletContext();
		String drivers = context.getInitParameter("jdbcdriver");
		
		StringTokenizer tokenizer = new StringTokenizer(drivers, ",");
		while(tokenizer.hasMoreTokens()) {
			String jdbcDriver = tokenizer.nextToken();
			// 드라이버 로드
			Class.forName(jdbcDriver);
		}
		} catch(Exception e) {
			
		}
	}

	
	
	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
