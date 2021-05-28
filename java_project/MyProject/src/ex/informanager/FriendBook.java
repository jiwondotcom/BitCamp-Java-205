package ex.informanager;

import java.util.Scanner;

public class FriendBook {
	public static void main(String[] args) {

		FriendInfoHandler handler = new FriendInfoHandler(100);

		Scanner sc = new Scanner(System.in);
		
	while (true) { // 반복의 조건을 걸어준다. (탈출의 조건은 5번)
		
		System.out.println("********* 메뉴 선택 *********");
		System.out.println("1. 고등학교 친구 정보 입력");
		System.out.println("2. 대학교 친구 정보 입력");
		System.out.println("3. 전체 정보 출력");
		System.out.println("4. 기본 정보 출력");
		System.out.println("5. 프로그램 종료"); // 탈출의 조건 5번
		System.out.println("*************************");
		
		System.out.print("메뉴를 선택해주세요.\n>> ");
		int choice = sc.nextInt();

		switch(choice) {
		case 1 :
		case 2 :
			handler.addFriend(choice);
			break; // break를 걸지않으면 계속 실행이 된다. (case 3, 4, ...)
				// break를 만나 해당 switch문을 벗어난다.
		case 3 : 
			handler.showAllData();
			break;
			
		case 4 :
			handler.showAllBasicData();
			break;
			
		case 5 :
			System.out.println("▶프로그램을 종료합니다.");
			return; // System.exit; 으로도 가능하다.
			
		}
			}
	
	}

}
