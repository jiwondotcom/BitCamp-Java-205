package service;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	// GreetingCommandImple
	// 메소드가 추상메소드
	// public abstract
	String getPage(HttpServletRequest request);
	
	
	
}
