package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Command;
import service.InvalidCommandImple;


public class FrontController extends HttpServlet{

	
	private Map<String, Command> commands = new HashMap<String, Command>();
	//			요청(uri), new GreetingCommandImple()
	// commands.put("/", new GreetingCommandImple())
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		// commands에 요청 문자열과 처리할 객체를 저장
		
		// commands.put("/", new GreetingCommandImple());
		// commands.put("/greeting.do", new GreetingCommandImple());
		// commands.put("/date.do", new DateCommandImple());
		// commands.put("/login.do", new DateCommandImple());
		
		
		// 설정파일의 경로 가져오기
		String configFile = config.getInitParameter("config");
		
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		// 설정 파일의 시스템 경로
		String configPath = config.getServletContext().getRealPath(configFile);
		
		System.out.println(configPath);
		
		
		try {
			fis = new FileInputStream(configPath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	Iterator<Object> itr = prop.keySet().iterator();
	
	while(itr.hasNext()) {
		String command = (String) itr.next();
		String commandClassName = prop.getProperty(command);
		
		// 클래스 이름으로 해당 클래스의 인스턴스 생성
		try {
			Class commandClass = Class.forName(commandClassName);
		
			Command commandObj = (Command)commandClass.newInstance(); 
		
			commands.put(command,commandObj);

			System.out.println(command + " = " + commandClassName);
			
		} catch (ClassNotFoundException e) {
 		e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
	
}

	}
		}
	
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 사용자의 요청 분석 : URI를 추출해서 사용
		String commandUri = request.getRequestURI();
		// http://localhost:8080/mvc/guest/list.do -> /mvc/guest/list.do
		
		if(commandUri.indexOf(request.getContextPath()) == 0) {
			commandUri = commandUri.substring(request.getContextPath().length());
			
		}
		
		
		// 결과 Data를 object타입 resultObject에 넣는다.
		// Object resultObj = null;
		
		// view 페이지
		// 사람들이 직접 default.jsp 페이지에 접속하는 것이 불가능하도록 WEB-INF 폴더 내에 넣는다. 
		// (데이터를 받아야만 / 무조건 controller을 통해서만 노출되는 페이지 방식으로 설정)
		String viewPage = "/WEB-INF/views/default.jsp";
		Command command = null;
		
		command = commands.get(commandUri);
		if(command == null) {
			command = new InvalidCommandImple();
		}
		
		viewPage = command.getPage(request);
		
		
		
		/*
		if(commandUri.equals("/greeting.do")) {
			command = new GreetingCommandImple();
		} else if (commandUri.equals("/date.do")) {
			command = new DateCommandImple(); 
		} else if (commandUri.equals("/")) { 		// http://localhost:8080/mvc/
			command = new GreetingCommandImple();
		} else {
			command = new InvalidCommandImple();
			
		}
		*/
		
		
		
		
		
		// 2. 요청을 처리 : 모델 선택, 실행 -> 요청을 처리할 수 있는 Service를 선택
		/*
		if(commandUri.equals("/greeting.do")) { // http://localhost:8080/mvc/greeting.do
			// 처리할 수 있는 서비스의 메소드를 실행
			
			// resultObj = "안녕하세요";
			// viewPage = "/WEB-INF/views/greeting.jsp";
			
			GreetingService service = new GreetingService();
			service.greeting(request);
			viewPage = service.greeting(request);
			
		} else if (commandUri.equals("/date.do")) {
			// resultObj = new Date();
			// viewPage = "/WEB-INF/views/date.jsp";
			
			DateService service = new DateService();
			viewPage = service.getDate(request);
		
		} else {
			// resultObj = "Invalid Type Request";
			
			InvalidService service = new InvalidService();
			viewPage = service.getPage(request);
		}
		*/
		
		// 3. 결과 데이터를 공유(전달)
		// request.setAttribute("result", resultObj);
		
		
		// 4. viewPage로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}
	

}
