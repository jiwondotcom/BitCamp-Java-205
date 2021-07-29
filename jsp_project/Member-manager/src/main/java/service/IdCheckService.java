package service;

import java.sql.Connection;
import java.sql.SQLException;

import member.dao.MemberDao;
import member.util.ConnectionProvider;

public class IdCheckService {

	// 싱글톤 처리
	private IdCheckService() {}
	private static IdCheckService service = new IdCheckService();
	public static IdCheckService getInstance() {
		return service;
	}

	
	public String idCheck(String userID) {
		// String result = "N";
		int cnt = 0;
		
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			cnt = dao.selectByID(conn, userID);
		
			// result = cnt > 0 ? "N" : "Y";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// cnt가 0보다 크면 N을 반환 / 작으면 Y를 반환
		return cnt > 0 ? "N" : "Y";
	}
}
