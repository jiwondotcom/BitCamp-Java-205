package ex_0601;

import java.util.*;

public class TreeSetTest {
	public static void main(String[] args) {
		
		// TreeSet : 트리알고리즘을 이용해서 저장 -> 정렬(오름차순, 내림차순)
		// 		   : 중복은 저장되지 않는다.
		// 		   : (정렬의 기준은 프로그래머 정의 기능)

		TreeSet<Integer> treeSet = new TreeSet<>();
		
		// 데이터 저장
		treeSet.add(1);
		treeSet.add(5);
		treeSet.add(4);
		treeSet.add(2);	
		treeSet.add(1); // 중복은 저장되지않는다.
		treeSet.add(3);
		treeSet.add(2); // 중복은 저장되지않는다.
		
		// 정렬
		Iterator<Integer> itr = treeSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
