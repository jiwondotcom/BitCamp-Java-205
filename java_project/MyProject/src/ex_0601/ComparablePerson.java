package ex_0601;

import java.util.*;

public class ComparablePerson {
	public static void main(String[] args) {

		TreeSet<Person> set = new TreeSet<>();
		
		// 데이터 저장
		set.add(new Person("짱구", 5));
		set.add(new Person("짱아", 2));
		set.add(new Person("흰둥", 1));

		// 정렬
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().showData(); 
		}
	}

}

class Person implements Comparable<Person> { // Person타입과 비교
	
	String name;
	int age;
	
	public Person(String name, int age) {
	this.name = name;
	this.age= age;
}

	
	public void showData() { 
		System.out.printf("%s, %d \n", this.name, this.age);
	
}

	@Override
	public int compareTo(Person o) {
//		if (this.age > o.age) {
//			return 10000; // 양수 반환
//		} else if (this.age < o.age) {
//			return -10000; // 음수 반환
//		} else {
//			return 0; // 크지도 작지도 않을 경우(같을 경우) 0 반환
//		}
		
//		return this.age - o.age; // 오름차순
		return o.age - this.age; // 내림차순
	}


}