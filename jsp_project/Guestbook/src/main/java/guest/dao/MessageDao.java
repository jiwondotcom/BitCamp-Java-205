package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import guest.domain.Message;
import guest.domain.MessageRequest;

public class MessageDao {

	public int writeMessage(Connection conn, MessageRequest requestMessage) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into guestbook_message (guestName, password, message) "
				+ "values (?, ?, ?);";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			resultCnt = pstmt.executeUpdate();
		
		} finally {
			// close 처리 예정
		}
		
		return 0;
	}

	
	// 싱글톤 처리
}
