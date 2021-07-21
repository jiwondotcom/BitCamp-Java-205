package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;
import member.domain.Member;

public class MemberDao {
	
	// 싱글톤 패턴
	// 1. 인스턴스 생성을 막는다.
	private MemberDao() {}
	
	// 2. 클래스 내부에서 인스턴스를 생성한다.
	private static MemberDao dao = new MemberDao();
	
	// 3. 외부에서 참조값을 반환 받을 수 있는 메소드 필요
	public static MemberDao getInstance() {
		return dao == null ? new MemberDao() : dao;
	}
	
	
	// 멤버 리스트 생성-출력
	public List<Member> getMemberList(Connection conn) throws SQLException {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = null;
		
		try {
		stmt = conn.createStatement();
		String sql = "select * from member;";
		rs = stmt.executeQuery(sql);
		
		list = new ArrayList<Member>();
		
		while(rs.next()) {
			list.add(makeMember(rs));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;

	}
	
	
	
	
	
	// DB 처리 : 새로운 데이터 삽입 insert
	public int insertMember(Connection conn, Member member) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserID());
			pstmt.setString(2, member.getUserPW());
			pstmt.setString(3, member.getUserName());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
		
	}
	
	
	
	
	private Member makeMember (ResultSet rs) throws SQLException {
		
		Member member = new Member();
		member.setUserID(rs.getString("userID"));
		member.setUserPW(rs.getString("userPW"));
		member.setUserName(rs.getString("userName"));
		
		
		return member;
		
	}
}
