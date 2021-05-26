package study_0526;

public class StudentMain {

	public static void main(String[] args) {

		// 변수 10개를 저장할 수 있는 공간을 만들었다.
		// Student 타입의 인스턴스 주소를 가지는 변수
		// 참조변수 타입 : 주소값 저장
		Student[] students = new Student[10];

		// student 타입의 참조변수 s1와 같다. = students[0]
		students[0] = new Student("홍길동1", 100, 0, 30);
		students[1] = new Student("홍길동2", 80, 90, 50);
		students[2] = new Student("홍길동3", 30, 80, 40);
		students[3] = new Student("홍길동4", 90, 70, 20);
		students[4] = new Student("홍길동5", 20, 60, 30);
		students[5] = new Student("홍길동6", 40, 50, 80);
		students[6] = new Student("홍길동7", 50, 40, 90);
		students[7] = new Student("홍길동8", 60, 30, 90);
		students[8] = new Student("홍길동9", 0, 20, 70);
		students[9] = new Student("홍길동0", 30, 10, 20);
	
	// 배열에 저장된 Student 타입의 인스턴스 메소드를 이용해서 모든 데이터를 출력한다.
	
		// \t = tab 너비만큼 간격이 떨어진다.
		System.out.println("이름\t 국어 \t 영어 \t 수학 \t 총점\t 평균 \t");
		System.out.println("============================================");
		for(int i = 0; i < students.length; i++) {
			System.out.print(students[i].getName());
			System.out.print("  \t");
			System.out.print(students[i].getKor());
			System.out.print("\t");
			System.out.print(students[i].getEng());
			System.out.print("\t");
			System.out.print(students[i].getMath());
			System.out.print("\t");
			System.out.print(students[i].getSum());
			System.out.print("\t");
			System.out.println(students[i].getAvg());
		}
	
	}

}
