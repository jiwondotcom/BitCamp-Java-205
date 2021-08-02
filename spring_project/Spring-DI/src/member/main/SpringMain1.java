package member.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.domain.RegRequest;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class SpringMain1 {

	static ApplicationContext ctx;

	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printMenu();
			
			String command = sc.nextLine();
		
			// 프로그램의 종료 분기
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램 종료");
				return;
			}
			
			if(command.startsWith("new")) {
				String[] values = command.split(" ");
				// values[0] => abc@gamil.com
				// values[1] => abc
				// values[2] => 1234 
				// .....
				processNewMember(values);
				continue;
			}
			
			
			if(command.startsWith("change")) {
				String[] values = command.split(" ");
				processChangePW(values);
			}
		}
		
	}
	
	private static void processChangePW(String[] values) {
		// MemberRegService를 이용해서 패스워드를 변경한다.
		
		// ChangePasswordService service = new ChangePasswordService(new MemberDao());
		// ChangePasswordService service = assembler.getPasswordService();
		ChangePasswordService service = ctx.getBean("ChangePasswordService", ChangePasswordService.class);
		
		try {
			service.changePassword(values[1], values[2], values[3]);
			
			System.out.println("비밀번호를 변경완료했습니다.");
			
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	
	private static void processNewMember(String[] values) {
		// MemberRegService를 이용해서 정보를 저장한다.
		
		// MemberRegService service = new MemberRegService(new MemberDao());
		// MemberRegService service = assembler.getRegService();
		MemberRegService service = ctx.getBean("regService", MemberRegService.class);
		
		RegRequest request = new RegRequest();
	
		request.setEmail(values[1]);
		request.setName(values[2]);
		request.setPassword(values[3]);
		request.setConfirmPassword(values[4]);

		
		if(!request.isPasswordEqualToConfirmPassword()) {
			// 같을때  true, 다를때 false
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return; 
		} 
		
		
		try {
			service.regMember(request);
			System.out.println("정상적으로 등록되었습니다.");
	
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
	}

	static void printMenu() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("=================================");
		System.out.println(">>>>>>>>>> 회원 등록 <<<<<<<<<<");
		System.out.println("new 이메일 이름 비밀번호 비밀번호 확인");
		System.out.println("new abc@gmail.com abc 1234 1234");
		System.out.println(">>>>>>>>>> 회원 수정 <<<<<<<<<<");
		System.out.println("change 이메일 현재 비밀번호 새로운 비밀번호");
		System.out.println("change abc@gmail.com 1234 0000");
		System.out.println("=================================");
	
	}
	
	
}
