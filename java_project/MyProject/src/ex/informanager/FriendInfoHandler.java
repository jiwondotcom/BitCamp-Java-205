package ex.informanager;

import java.util.Scanner;

public class FriendInfoHandler {

	// 저장 데이터(객체)를 배열로 저장하고 관리하는 기능을 가진 클래스

	Friend[] friends;
	int numOfFriend; // 배열 Friend의 입력 / index 역할, 정보의 개수
	
	public FriendInfoHandler(int num) { // 배열의 사이즈를 받기 위한 num => 배열 인스턴스 생성 
//		super(); // object 클래스는 비어있다.
		this.friends = new Friend[num];
		this.numOfFriend = 0; // 0값은 생략이 가능하다. 명시적으로 입력.
	}

	
	// 데이터의 입력 처리
	// 사용자로부터 친구의 정보를 입력받아 => 인스턴스 생성 => 배열에 저장한다.
	public void addFriend(int choice) { // choice => 1(고등학교) or 2(대학교)
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요>> ");
		String name = sc.nextLine();
		System.out.print("전화번호를 입력해주세요>> ");
		String phoneNumber = sc.nextLine();
		System.out.print("주소를 입력해주세요>> ");
		String address = sc.nextLine();
		
		if(choice == 1) { // 1. 고등학교 친구
			System.out.print("직업을 입력해주세요>> ");
			String work = sc.nextLine();
			
			// 인스턴스 생성
			// HighFriend hFriend = new HighFriend(name, phoneNumber, address, work);
			addFriendInfo(new HighFriend(name, phoneNumber, address, work));
				// 배열에 요소 추가
				// friends[numOfFriend] = hFriend;
				// numOfFriend++;

//		} else if (choice == 2); // 2개뿐이라 else if 사용은 필요없다.
		} else { // 2. 대학친구
			System.out.print("전공을 입력해주세요>> ");
			String major = sc.nextLine();
				
			//b인스턴스 생성
			// UnivFriend uFriend = new UnivFriend(name, phoneNumber, address, major);
			addFriendInfo(new UnivFriend(name, phoneNumber, address, major));
				// 배열에 요소 추가
				// friends[numOfFriend] = uFriend;
				// numOfFriend++;
			}
		}
		
		// Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장해주는 메소드
		public void addFriendInfo(Friend f) {
			// 배열에 요소 추가
			friends[numOfFriend++] = f;
			System.out.println("\n▶정보가 추가되었습니다.\n");
		}

		
		// 모든 데이터를 출력하는 메소드
		public void showAllData() {
			System.out.println("\n▶친구의 모든 정보를 출력합니다.◀");
			System.out.println("---------------------------");
			if(numOfFriend > 0) { // 입력된 정보가 하나 이상은 있어야 함
			for (int i = 0; i < numOfFriend; i++) {
				friends[i].showData();
				System.out.println("---------------------------");
		}
			} else {
				System.out.println("▶입력된 정보가 없습니다.");
				System.out.println("---------------------------\n");
			}
	
		}
		
		public void showAllBasicData() {
			System.out.println("\n▶친구의 기본정보를 출력합니다◀");
			System.out.println("---------------------------");
			if(numOfFriend > 0) { // 입력된 정보가 하나 이상은 있어야 함
				for (int i = 0; i < numOfFriend; i++) {
					friends[i].showBasicInfo();
				}
			} else {
				System.out.println("▶입력된 정보가 없습니다.");
			}
			System.out.println("---------------------------\n");
			
		}
}