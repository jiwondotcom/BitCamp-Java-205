package study_0602;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample05 {
	public static void main(String[] args) throws Exception {

		Writer writer = new FileWriter("C:/Temp/test8.txt");
		
		char[] array = { 'A', 'B', 'C', 'D', 'E', 'F' };
		
		writer.write(array);
		
		writer.flush();
		writer.close();
		
	}

}
