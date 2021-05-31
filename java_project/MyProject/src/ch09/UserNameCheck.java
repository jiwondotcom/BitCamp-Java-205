package ch09;

import java.util.Scanner;

// 사용자에게 이름을 입력 받아 입력 받은 문자열을 정상적인 문자열의 이름으로 표현하는지 판별하고,
// 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.

public class UserNameCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이   름 : ");
		String name = sc.nextLine();
		
		boolean Complete = true; // 입력이 정상적으로 완료되면 true
		
		if(!(name.isEmpty())) {
			for (int i = 0; i < name.length(); i++) {
				char A = name.charAt(i);
				if(A == ' ') {
					Complete = false; // 문자열에 공백이 있을 경우 false
				}
			}
			if (Complete == false) { // 입력 비정상
				System.out.println("공백이 없는지 확인해주세요.");
			} else { // 문자열에 공백이 없을시(false)
				System.out.println("정상적으로 입력되었습니다.");
			}
		} else { // name.isEmpty(): 컬렉션이 비어있을 경우
			System.out.println("이름을 입력해주세요.");
		}
		
	}
}