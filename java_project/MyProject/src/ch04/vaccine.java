package ch04;

import java.util.Scanner;

//① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
//- 매개변수로 태어난 해(년도)를 전달받습니다.
//- 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
//- 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.
//② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
//- 매개변수로 태어난 해(년도)를 전달받습니다.
//- 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
//- 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
//- 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.


public class vaccine {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
		
	System.out.println("< 독감 예방접종 대상 여부 조회 >");
	System.out.print("■ 태어난 년도를 입력해주세요(YYYY)\n");
	System.out.print(": ");
	int birthYear = scanner.nextInt();
	int age = 2021 - birthYear + 1;
	
		if (age < 15 || age >= 65) {
			System.out.println(">> 무료 예방 접종이 가능합니다.");
		} else {
			System.out.println(">> 무료 예방 접종 대상이 아닙니다.");
		}
		
		System.out.println();
		System.out.println("==========================");
		System.out.println();
	
	
		System.out.println("< 건강검진 대상 여부 조회 >");
		System.out.println("1) 대한민국 성인의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.");
		System.out.println("2) 짝수 해에 태어난 사람은 올해 건강검진 대상입니다.");
		System.out.print("■ 태어난 년도를 입력해주세요(YYYY)\n");
		System.out.print(": ");
		int birthYear2 = scanner.nextInt();
		int age2 = 2021 - birthYear2 + 1;
	
		if (age > 20 && age2%2 == 0) {
			System.out.println(">> 올해 무료 건강검진 대상입니다.");
			}

		else {
			System.out.println(">> 올해 무료 건강검진 대상이 아닙니다.");
		}
		
		if (age2 > 40) {
			System.out.println(">> 40세 이상 - 무료 암 검사 대상입니다.");
		}
		else {
		}
}
	}


