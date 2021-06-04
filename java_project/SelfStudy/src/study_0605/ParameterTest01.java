package study_0605;

class Data {
	int x;
}

class ParameterTest01 {
	public static void main(String[] args) {

		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d.x);
		System.out.println("After Change(d.x)");
		System.out.println("main() : x = " + d.x);
	}
	
	static void change(int x) {
		x = 1000;
		
		System.out.println("change() : x = " + x);
	}
	
}


//출력값 :
//main() : x = 10
//change() : x = 1000
//After change(d)
//main() : x = 10
