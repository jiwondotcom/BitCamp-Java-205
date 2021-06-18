package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeptManager {

	// 전체 리스트 출력 메소드
	// DAO에서 데이터 리스트를 받고 출력 처리 해준다.
	void deptList() {
		// Connection 객체 생성 -> 트렌젝션 처리
		Connection conn = null;
		
		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
	
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

	// 데이터 입력
	
	// 데이터 수정
	
	// 데이터 삭제
	
	
	
	
	
	
	
	
	
	
}
