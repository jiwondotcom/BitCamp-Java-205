package ch02;

public class Person {

	String name;
	String memberPhoneNum = "000-0000-0000";
	String perNum1 = "990101-2000000";
	long perNum2 = 9901012000000L;

	
	// �ν��Ͻ� �������� �����͸� ����ϴ� �޼ҵ�
	void showData() {
		System.out.println("ȸ�� �̸� : " + name);
		System.out.println("ȸ���� �ֹι�ȣ1 : " + perNum1);
		System.out.println("ȸ���� �ֹι�ȣ2 : " + perNum2);
	}

	
	public static void main (String[] args) {
		
		// Person �ν��Ͻ� ����
		Person person = new Person();
		
		System.out.println("�̸� : " + person.name);
		person.name = "¯��";
		person.showData();

	}
}
