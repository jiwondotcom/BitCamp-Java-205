package study_0531;

import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		//주어진 인덱스에 객체를 차례대로 추가한다.
		list.add("짱구");
		list.add("철수");
		list.add("훈이");
		list.add(2, "유리");
		list.add("짱아");
		
		int size = list.size(); 
		// 저장된 총 객체 수를 변수 size에 저장
		System.out.println("총 객체수: " + size);
		System.out.println();
		
		String skill = list.get(2); // 2번 인덱스의 객체를 얻는다.
		// skill이라는 변수에 저장
		System.out.println("3: " + skill); // 훈이
		System.out.println();
		 
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			// 변수 str에 객체를 나열한 것을 저장
			System.out.println(i + ": " + str);
		}
		
		System.out.println();
		
		list.remove(1); // 1번 인덱스인 "철수" 삭제
		list.remove(1); // 1번 인덱스인 "유리" 삭제
		list.remove("훈이");
		
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
			
		}
		
	}

}
