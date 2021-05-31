package study_0528;

import java.util.Scanner;

// 저장 데이터(객체)를 배열로 저장하고 관리하는 기능을 가진 클래스
public class FriendInfoHandler {

	Friend[] friends;
	int numOfFriend; // 배열 Friend의 입력 / index 역할, 정보의 개수를 담는 변수 선언
	
	
	public FriendInfoHandler(int num) {
		// 배열의 사이즈를 담기 위한 num -> 배열의 인스턴스 생성
		this.friends = new Friend[num];
		this.numOfFriend = 0;
	}
	
	public void addFriend(int choice) { 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.println("번호를 입력해주세요 : ");
		String phoneNumber = sc.nextLine();
		System.out.println("주소를 입력해주세요 : ");
		String address = sc.nextLine();
		
		if (choice == 1) { // 고등학교 친구 선택
			System.out.println("직업을 입력해주세요 : ");
			String work = sc.nextLine();
			
			// 인스턴스 생성
			addFriendInfo(new HighFriend(name, phoneNumber, address, work));
			// HighFriend hFriend = new HighFriend(name, phoneNumber, address, work);
			// 배열에 요소를 추가
			// friends[numOfFriend] = hFriend;
			// numOfFriend++;
			
		} else { // choice == 2 : 대학교 친구 선택
			System.out.println("전공을 입력해주세요 : ");
			String major = sc.nextLine();
			
			// 인스턴스 생성
			addFriendInfo(new UnivFriend(name, phoneNumber, address, major));
			
		}
	}
	
	// Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장해주는 메소드
	public void addFriendInfo(Friend f) {
		// 배열에 요소 추가
		friends[numOfFriend++] = f;
		System.out.println("정보가 추가되었습니다.");
	}

	// 모든 데이터를 출력하는 메소드
	public void showAllData() {
			System.out.println("친구의 모든 정보를 출력합니다.");
			System.out.println("----------------");
			
			if (numOfFriend > 0) { 
			for (int i = 0; i > numOfFriend; i++) {
				friends[i].showData();
				System.out.println("-----------------");
				}
			} else {
				System.out.println("입력된 정보가 없습니다");
				System.out.println("-----------------");
			}
		}
			
			
	public void showAllBasicData() {
		System.out.println("친구의 기본정보를 출력합니다.");
		System.out.println("-------------------");
			
		if (numOfFriend > 0) {
			for (int i = 0; i < numOfFriend; i++) {
				friends[i].showBasicInfo();
				}
		} else {
			System.out.println("입력된 정보가 없습니다.");
			System.out.println("-----------------");
		}
	}

}
