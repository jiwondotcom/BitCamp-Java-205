package study_0602;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample07 {
	public static void main(String[] args) throws Exception {

		Writer writer = new FileWriter("C:/Temp/test10.txt");
		
		String str = "짱구";
		
		writer.write(str);
		
		writer.flush();
		writer.close();
		
	}

}
