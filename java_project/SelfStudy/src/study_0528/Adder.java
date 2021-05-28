package study_0528;

class Adder {
	public static int val = 0;
	public void add(int num) {
		val += num; // var+num값을 var에 입력
	}
}

class AdderFriend extends Adder {
	public void friendAdd(int num) {
		val += num;
	}
	public void showVal() { // val값을 출력해주는 메소드
		System.out.println(val);
	}
}
