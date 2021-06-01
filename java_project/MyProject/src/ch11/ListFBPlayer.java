package ch11;

import java.util.*;

// 01.
// 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서
// 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.

public class ListFBPlayer {
	public static void main(String[] args) {

		List<FootballPlayer> players = new ArrayList<FootballPlayer>();
		
		// 데이터 저장
		players.add(new FootballPlayer ("Kwon", 3, "A", 25));
		players.add(new FootballPlayer ("Kang", 5, "B", 26));
		players.add(new FootballPlayer ("Choi", 2, "A", 28));
		players.add(new FootballPlayer ("Dong", 4, "B", 25));
		players.add(new FootballPlayer ("Kwon", 3, "B", 25));
	
		
		// 정렬
		Iterator<FootballPlayer> itr = players.iterator();
		
		while(itr.hasNext()) { // hasNext(): 가져올 객체가 있을시 true를 리턴한다.
			System.out.println(itr.next());
		}
			
	}
	
	
}
