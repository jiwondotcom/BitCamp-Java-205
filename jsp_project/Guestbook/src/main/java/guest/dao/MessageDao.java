package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
		return 0;
	}

	
	// 싱글톤 처리
}
