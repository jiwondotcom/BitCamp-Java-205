package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import guest.domain.Message;
import guest.domain.MessageRequest;
import guest.jdbc.JdbcUtil;

public class MessageDao {
	
	// 싱글톤 처리
	private MessageDao() {}
	
	private static MessageDao dao = new MessageDao();

	public static MessageDao getInstance() {
		return dao;
	}
	
	
	
	public int writeMessage(Connection conn, Message message) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into guestbook_message (guestName, password, message) "
				+ "values (?, ?, ?);";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			resultCnt = pstmt.executeUpdate();
		
		} finally {
			// close 처리
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}


	// 전체 게시물의 개수 카운트
	public int selectAllCount(Connection conn) throws SQLException {
	
		int totalCount = 0;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select count(*) from guestbook_message;";
			
			rs = stmt.executeQuery(sql);
			
			if(rs != null) {
				totalCount = rs.getInt(1);
			}
				
				
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		
		return totalCount;
	}

	
}
