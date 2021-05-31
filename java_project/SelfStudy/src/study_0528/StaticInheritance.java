package study_0528;

class StaticInheritance {
	public static void main(String[] args) {
		
		Adder ad = new Adder(); // Adder메소드 호출
		AdderFriend af = new AdderFriend(); // AdderFriend메소드 호출
		
		ad.add(1); // 0 + num = val = 1
		af.friendAdd(3); // 1 + 3 = 4 = val
		AdderFriend.val += 5; // 4 + 5 = 9 = val
		
		af.showVal(); // val의 값 9 출력
		
		}
	}
