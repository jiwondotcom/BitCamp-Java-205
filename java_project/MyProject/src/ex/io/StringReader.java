package ex.io;

import java.io.*;

public class StringReader {
	public static void main(String[] args) {
		
		
		try {
			
			BufferedReader in = new BufferedReader(new FileReader("String.txt"));
			
			// 임시변수
			String str = null;
			
			while(true) {
				str = in.readLine();
			
			if (str == null ) {
				break;
			}
				System.out.println(str);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			}
	
	}


