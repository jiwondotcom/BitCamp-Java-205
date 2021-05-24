package ch01;

public class Calculator {

		void plus(int n1, int n2) {
			System.out.println(n1 + n2);
		}
		void minus(int n1, int n2) {
			System.out.println(n1 - n2);
		}
		void multi(int n1, int n2) {
			System.out.println(n1 * n2);
		}
		void div(int n1, int n2) {
			System.out.println(n1 / n2);
		}
		
		public static void main(String[] args) {
			
			Calculator cal = new Calculator();
			cal.plus(3, 5);
			cal.minus(2, 1);
			cal.multi(6, 3);
			cal.div(20, 2);

		}

}
