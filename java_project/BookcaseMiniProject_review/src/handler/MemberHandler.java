package handler;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberHandler {

	    Scanner sc = new Scanner(System.in);
	    ArrayList<Member> members = new ArrayList<Member>();
	    
	    // 공백이 입력되었을 시, 다시 입력받는 메소드
	    public void isEmpty(String string) {
	    	while(true) {
	    		if(string.equals("")) {
	    			System.out.println("공란입니다. 다시 입력해주세요.");
	    			string = sc.nextLine();
	    			continue; 
	    		} else {
	    			break;
	    		}
	    	}
	    }
	    
	    
	    
		public void joinMember() { // 회원가입 method
			System.out.println();
			System.out.println("회원가입을 시작합니다.");
			
			// ID 입력
			System.out.println("아이디 : ");
			String ID = sc.nextLine();
			isEmpty(ID); // 공란 체크
			boolean chk = true;
			if(members.size() > 0) {
				while(chk) {
					for(int i = 0; i < members.size(); i++) {
						if(members.get(i).getID().equals(ID)) {
							System.out.println("이미 존재하는 ID입니다.");
							System.out.println("확인 후 다시 입력해주세요.");
							System.out.println("아이디 : ");
							ID = sc.nextLine();
							isEmpty(ID);
							continue;
						}
					} chk = false;
				}
			}
			}
	}

