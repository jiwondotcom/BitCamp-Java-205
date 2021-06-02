package ch11;

import java.util.*;

// 03.
// TreeSet<E>을 이용해서 팀 이름순으로 정렬,
// 같은 팀의 선수들은 이름 순으로 정렬하고,
// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.

public class TreeFPBPlayer {
	public static void main(String[] args) {

		// TreeSet : 트리알고리즘을 이용해서 저장 -> 정렬(오름차순, 내림차순)
				// 		   : 중복은 저장되지 않는다.
				// 		   : (정렬의 기준은 프로그래머 정의 기능)
		TreeSet<FootballPlayer> players = new TreeSet<FootballPlayer>();
		
		// 데이터 저장
		players.add(new FootballPlayer ("Kwon", 3, "A", 25));
		players.add(new FootballPlayer ("Lee", 5, "B", 26));
		players.add(new FootballPlayer ("Choi", 2, "A", 28));
		players.add(new FootballPlayer ("Dong", 4, "B", 25));
		players.add(new FootballPlayer ("Kwon", 6, "B", 25));
		players.add(new FootballPlayer ("Lee", 8, "B", 26));
		players.add(new FootballPlayer ("Choi", 1, "A", 28));
		players.add(new FootballPlayer ("Kwon", 6, "B", 25)); // 중복은 저장되지 않는다.
		players.add(new FootballPlayer ("Dong", 7, "B", 25));
		players.add(new FootballPlayer ("Kwon", 9, "B", 25));
		
		// 정렬
		Iterator <FootballPlayer> itr = players.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		
		}
	}

}
