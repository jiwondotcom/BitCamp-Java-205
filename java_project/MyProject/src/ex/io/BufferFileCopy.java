package ex.io;

import java.io.*;

public class BufferFileCopy {
	public static void main(String[] args) throws IOException {

		try {
			
		// 1. 파일을 바이너리 데이터를 읽어올 스트림 생성 : FileInputStream
		InputStream in = new FileInputStream("origin.pdf");
		// 2. 파일을 쓰기 위한 스트림 생성 : FileOutputStream
		OutputStream out = new FileOutputStream("copy2.pdf");
			
		// 카피한 데이터의 크기
		int copyByte = 0;
		// 파일에서 읽어올 바이트 데이터 배열
		byte[] buf = new byte[1024]; // 1kb 사이즈의 배열
		// 읽어온 데이터 배열의 개수
		int readLen = 0;
		
		while(true) {
			
			readLen = in.read(buf); // 완료시점 -> -1 반환
			
			// 탈출의 조건 : 파일의 모든 데이터를 잃은 경우
			if(readLen == -1) {
				break;
			}
			out.write(buf, 0, readLen);
			copyByte++;
		}
			
			//스트림 닫기
			in.close();
			out.close();
			
			System.out.println("복사완료! 복사된 바이트의 사이즈 : " + copyByte + "byte");

		} catch (FileNotFoundException e) {
		e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
