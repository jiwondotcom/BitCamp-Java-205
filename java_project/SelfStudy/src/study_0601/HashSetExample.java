package study_0601;

import java.util.*;

// String 객체를 중복없이 저장하는 HashSet
public class HashSetExample {
	public static void main(String[] args) {

		Set<String> set = new HashSet<String>();
		// <E>타입 파라미터를 생략하면 왼쪽 Set에 지정된 타입을 따라간다.
		
		set.add("짱구");
		set.add("철수");
		set.add("훈이");
		set.add("유리");
		set.add("짱아");
		
		int size = set.size();
		System.out.println("총 객체수: " + size);
		
		Iterator<String> iterator = set.iterator(); // 저장된 객체를 한번씩 가져오는 반복자를 리턴한다.
			// while 조건문의 값이 true일 경우, 객체수 만큼 루핑한다.
			while (iterator.hasNext()) { // hasNext(): 가져올 객체가 있을시 true를 리턴한다.
			String element = iterator.next(); // next(): 1개의 객체를 가져온다. => element에 저장
			System.out.println("\t" + element);
			}
			
			set.remove("철수"); // remove(): 1개의 객체를 삭제한다.
			set.remove("훈이"); // 동일
			
			System.out.println("총 객체수: " + set.size()); // size(): 저장된 객체의 수 얻기
			
			
		iterator = set.iterator(); // 저장된 객체를 한번씩 가져오는 반복자를 리턴한다.
			for(String element : set) {
				System.out.println("\t" + element); // 객체수만큼 루핑한다 (향상된 for문)
			}

			set.clear(); // clear(): 모든 객체를 제거하고 비운다.
			if (set.isEmpty()) { // 만약 컬렉션이 비어있을 경우,
				System.out.println("비어 있음"); // 해당 문구를 출력한다.
			}
	
	}
	
}
