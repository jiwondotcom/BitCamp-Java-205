package study_0602;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample02 {
	public static void main(String[] args) throws Exception{

		InputStream is = new FileInputStream ("C:/Temp/test2.db");
		
		byte[] array = new byte[100]; // 길이가 100인 배열 생성
		
		while (true) {
			int readByteNum = is.read(array); // 배열 길이만큼 읽기
			if (readByteNum == -1) { // 파일 끝에 도달했을 경우
				break;
			}
			for (int i = 0; i < readByteNum; i++) { //읽은 바이트 수만큼 반복하면서 배열에 저장된 바이트를 출력
				System.out.println(array[i]);
			}
		}
		is.close(); // 입력 스트림을 닫음
	}

}
