package ch11;

import java.util.*;

// 02.
// 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면
// 같은 선수라 판단하고 입력이 되지 않도록 Set<E> 컬렉션을 이용해서
// 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.

public class SetFBPlayer {
	public static void main(String[] args) {

		Set<FootballPlayer> players = new HashSet<FootballPlayer>();
		
		// 데이터 저장
		players.add(new FootballPlayer ("Kwon", 3, "A", 25));
		players.add(new FootballPlayer ("Kang", 5, "B", 26));
		players.add(new FootballPlayer ("Choi", 2, "A", 28));
		players.add(new FootballPlayer ("Dong", 4, "B", 25));
		players.add(new FootballPlayer ("Kwon", 3, "B", 25));
		players.add(new FootballPlayer ("Kwon", 3, "A", 25)); // 중복 요소 삭제
		
		// 정렬
		Iterator<FootballPlayer> itr = players.iterator();
		// 저장된 객체를 한번씩 가져오는 반복자를 리턴한다.
		
		while(itr.hasNext()) { // hasNext(): 가져올 객체가 있을시 true를 리턴한다.
				System.out.println(itr.next()); // next(): 1개의 객체를 가져온다. 
		}
		}
		
		
	}

