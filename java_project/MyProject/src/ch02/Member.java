package ch02;

// ch02.Member
public class Member {
	public static void main(String[] args) {
	
	//�ν��Ͻ� ����
	String name = "Ȳ¯��";
	int age = 5;
	double height = 171.4;
	boolean hasBook = false;
	
	System.out.println("�̸��� " + name); // String + String
	System.out.println("Ű�� " + height + "cm �Դϴ�."); // String + double + String
	System.out.println("���̴� " + age + "�� �Դϴ�."); // String + int + String
	System.out.println("JAVAå�� ���� ���� : " + hasBook); // String + boolean
	// String + anyType -> String + String
	
	if(hasBook == true) {
		System.out.println("�����ϰ� �ֽ��ϴ�.");
	} else { 
		System.out.println("�����ϰ� ���� �ʽ��ϴ�.");
	}

	
	// ���� ����
	// �������� Ÿ�� �ĺ� �̸�
	// ������ Ÿ�� -> ���� �ٷ��� �ϴ� �������� Ư¡�� ���ؼ� ����
	// �⺻�� Ÿ�� 8���� -> ������, �Ǽ���, boolean, ������ 
	// ������ (byte, short, integer) - ǥ���� �� �ִ� ������ ������ ������
		
	// �޼ҵ� �ȿ��� ���� �Ǵ� ���� -> ��������

		
	
	}

}