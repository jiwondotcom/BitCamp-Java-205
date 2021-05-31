package study_0528;

import java.util.Scanner;

public class FriendBook {
	public static void main(String[] args) {

		// 30명의 친구 정보를 저장 -> 값을 입력받는다.
		FriendInfoHandler handler = new FriendInfoHandler(30);
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		System.out.println("----------------------");
		System.out.println("메뉴 번호를 선택하세요");
		System.out.println("1. 고딩친구 정보 입력");
		System.out.println("2. 대딩친구 정보 입력");
		System.out.println("3. 전체 정보 출력");
		System.out.println("4. 기본 정보 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("----------------------");
		
		System.out.print("메뉴를 선택하세요 >>");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
		case 2:
			handler.addFriend(choice);
			break;
			
		case 3:
			handler.showAllData();
			break;
			
		case 4:
			handler.showAllBasicData();
			break;
			
		case 5:
			System.out.println("프로그램 종료");
			return;
		}
		
		}
	}

}
