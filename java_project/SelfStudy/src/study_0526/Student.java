package study_0526;

public class Student {
	
	private String Name;
	private int kor;
	private int eng;
	private int math;
	
	
	public Student(String Name,
			int kor,
			int eng,
			int math) {
		this.Name = Name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	// 변수는 캡슐화를 합니다. getter/setter
	
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	// 총점
	int getSum() {
		return (this.kor + this.eng + this.math);
	}
	// 평균 (총점 나누기 과목의 개수)
	float getAvg() {
		return getSum() / 3f;
	}
//	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

