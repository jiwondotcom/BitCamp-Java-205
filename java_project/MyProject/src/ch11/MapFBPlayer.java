package ch11;

//4.축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.

import java.util.*;

public class MapFBPlayer {
	public static void main(String[] args) {

		HashMap <Integer, FootballPlayer> players = new HashMap<>();
		
		players.put(3, new FootballPlayer ("Kwon", 3, "A", 25));
		players.put(5, new FootballPlayer ("Kang", 5, "B", 26));
		players.put(2, new FootballPlayer ("Choi", 2, "A", 28));
		players.put(4, new FootballPlayer ("Dong", 4, "B", 25));
		players.put(3, new FootballPlayer ("Kwon", 3, "B", 25));
		
		Set<Integer> set = players.keySet();
		
		Iterator<Integer> itr = set.iterator(); 
		while(itr.hasNext()) {
			System.out.println(players.get(itr.next())); // key값들을 가져온다.
		}
	}

}
