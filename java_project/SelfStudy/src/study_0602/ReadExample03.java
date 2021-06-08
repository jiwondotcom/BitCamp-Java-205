package study_0602;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample03 {
	public static void main(String[] args) throws Exception {
		
		InputStream is = new FileInputStream("C:/Temp/test3.db");
		
		byte[] array = new byte[5]; // 길이가 5인 배열 생성
		
		int readByteNum = is.read(array, 2, 3); // 입력스트림으로부터 3byte를 읽고, 
												// array[2], array[3], array[4]에 각각 저장한다. 10,20,30
		
		if (readByteNum != -1) { // 읽을 바이트가 있다면
			for(int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
		}
		
		is.close();
	}

}
