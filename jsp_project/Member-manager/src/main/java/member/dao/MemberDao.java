package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.domain.Member;
import member.util.JdbcUtil;

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
		String sql = "select * from memberinfo;";
		rs = stmt.executeQuery(sql);
		
		list = new ArrayList<Member>();
		
		while(rs.next()) {
			list.add(makeMember(rs));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		
		return list;

	}
	
	
	
	
	// DB 처리 : 새로운 데이터 삽입 insert
	public int insertMember(Connection conn, Member member) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into memberinfo values (default, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserID());
			pstmt.setString(2, member.getUserPW());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getRegDate());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
		
	}
	
	
	
	// DB 처리 : 기존 데이터 삭제 delete
	public int deleteMember (Connection conn, int index) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from memberinfo where `index`=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return resultCnt;
	}
	
	
	
	// 회원번호를 전달받아 선택처리
	public Member selectByIndex (Connection conn, int index) {
		
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from memberinfo where `index` = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = makeMember(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return member;
	
	}
	
	
	
	// 위에서 전달받은 (selectByIndex) 회원번호에 해당되는 데이터를 수정 (회원 비밀번호, 회원 이름)
	public int updateMember(Connection conn, Member member) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "update memberinfo set `USERID`=?, `USERPW`=?, `USERNAME`=? where `INDEX`=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserID());
			pstmt.setString(2, member.getUserPW());
			pstmt.setString(3, member.getUserName());
			pstmt.setInt(4, member.getIndex());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	
		return resultCnt;
		
	}
	
	
	
	private Member makeMember(ResultSet rs) throws SQLException {

		Member member = new Member();
		member.setIndex(rs.getInt("index"));
		member.setUserID(rs.getString("userid"));
		member.setUserPW(rs.getString("userpw"));
		member.setUserName(rs.getString("username"));
		member.setRegDate(rs.getString("regdate"));
		
		
		return member;
		

	}

	
	
}
