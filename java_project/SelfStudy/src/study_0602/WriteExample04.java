package study_0602;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample04 {
	public static void main(String[] args) throws Exception{
		
		Writer writer = new FileWriter("C:/Temp/test7.txt");
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		writer.write(a); // 한 문자씩 출력
		writer.write(b);
		writer.write(c);
		
		writer.flush();
		writer.close();

	}

}
