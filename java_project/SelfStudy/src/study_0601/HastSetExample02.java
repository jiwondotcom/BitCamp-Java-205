package study_0601;

import java.util.*;

public class HastSetExample02 {
	public static void main(String[] args) {
		
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("짱구", 5));
		set.add(new Member("짱구", 5));
		// 인스턴스는 다르지만 내부 데이터가 동일하므로 중복저장X, 객체를 1개만 저장한다.
		
		System.out.println("총 객체수: " + set.size());
	}

}
