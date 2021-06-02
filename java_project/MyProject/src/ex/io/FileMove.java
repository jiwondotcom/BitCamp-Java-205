package ex.io;

import java.io.File;

public class FileMove {
	public static void main(String[] args) {

		
//		File myFile = new File ("D:\\MyJava", "origin.pdf");
		File myFile = new File ("D:\\MyJava\\origin.pdf");
		System.out.println(myFile);
	
//			if (myFile.exists() == false) {
//				System.out.println("파일이 준비되어 있지 않습니다.");
		if (!myFile.exists()) {
			System.out.println("파일이 준비되어 있지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		// 새로운 폴더 생성 : 경로 생성 -> 생성
		File newDir = new File("C:\\yourJava"); // 경로 생성
		System.out.println("1. exist ?? ==> " + newDir.exists());
		
		if (!newDir.exists()) {
		//폴더 생성
		newDir.mkdir();
		System.out.println("1. exist ?? ==> " + newDir.exists());
	}
		
		System.out.println(myFile.getName()); // 파일의 이름을 가져온다.
		
		
		// 이동할 경로와 파일 이름 // 해당경로에 아직 파일이 존재하지않는다.
		File newFile = new File(newDir, myFile.getName());
		
		myFile.renameTo(newFile);
		
		if(newFile.exists()) {
			System.out.println("파일 이동 성공");
		} else {
			System.out.println("파일 이동 실패");
		}

}
	}