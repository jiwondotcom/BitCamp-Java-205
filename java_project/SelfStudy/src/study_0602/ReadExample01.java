package study_0602;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample01 {
	public static void main(String[] args) throws Exception {
		
		InputStream is = new FileInputStream ("C:/Temp/test1.db");
		
		while(true) {
			int data = is.read(); // 1바이트씩 읽기
			if(data == -1) {
				break;
			}
			System.out.println(data);
		}
		is.close();
	}

}
