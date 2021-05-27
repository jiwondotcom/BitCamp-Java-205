package ch07;

public class PersonMain {
	public static void main(String[] args) {

	Male m = new Male("짱구", 2015, "서울");
	Female f = new Female ("유리", 2016, "바나나");

	
	m.maleInfo();
	m.living();
	System.out.println("=====================");
	f.femaleInfo();
	f.eating();

}

	}

