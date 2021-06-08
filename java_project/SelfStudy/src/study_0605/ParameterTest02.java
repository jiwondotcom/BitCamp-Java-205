package study_0605;

class ParameterTest02 {
	public static void main(String[] args) {

		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d);
		System.out.println("After Change(d)");
		System.out.println("main() : x = " + d.x);
	}
	
	
	static void change(Data d) {
		d.x = 1000;
		System.out.println("change() : x = " + d.x);
	}

}

// 출력값 :
//main() : x = 10
//change() : x = 1000
//After change(d)
//main() : x = 1000
