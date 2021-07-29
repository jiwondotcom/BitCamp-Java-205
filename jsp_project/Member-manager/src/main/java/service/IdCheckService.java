package service;

import java.sql.Connection;
import java.sql.SQLException;

import member.dao.MemberDao;
import member.util.ConnectionProvider;

public class IdCheckService {

	public String idCheck(String userID) {
		String result = "N";
		
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			int cnt = dao.selectByID(conn,userID);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}
