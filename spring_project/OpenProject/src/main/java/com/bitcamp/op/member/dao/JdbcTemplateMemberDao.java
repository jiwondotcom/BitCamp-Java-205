package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;

@Repository
public class JdbcTemplateMemberDao {

	
	@Autowired
	private JdbcTemplate template;
	
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
		
	
	

	// 멤버 리스트 생성-출력
	public List<Member> getMemberList(Connection conn) throws SQLException {
		
		List<Member> list = null;

		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select * from memberinfo;";
			
			rs = stmt.executeQuery(sql);
		
			list = new ArrayList<Member>();
		
		while(rs.next()) {
			list.add(new Member(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getTimestamp(6)));
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
	public int insertMember(Member member) throws SQLException {
		
		int resultCnt = 0;
		
		String sql1 = "insert into memberinfo (userID, userPW, userName, userPhoto) values (?, ?, ?, ?)";
		String sql2 = "insert into memberinfo (userID, userPW, userName) values (?, ?, ?)";
		
		// photo가 있을 시
		if(member.getUserPhoto() != null) {
			resultCnt = template.update(sql1,
										member.getUserID(),
										member.getUserPW(),
										member.getUserName(),
										member.getUserPhoto());
		
		// photo가 없을 시
		} else {
			resultCnt = template.update(sql2,
										member.getUserID(),
										member.getUserPW(),
										member.getUserName());
		}
		
		return resultCnt;
		
	}
	
	
	// DB 처리 : 새로운 데이터 삽입 insert
	public int insertMember1(final Member member) throws SQLException {
		
		int resultCnt = 0;
		
		// 자동 증가한 컬럼의 값을 저장할 객체
		KeyHolder holder = new GeneratedKeyHolder();
		
		template.update(
						new PreparedStatementCreator() {
							
							@Override
							public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
								
								final String sql1 = "insert into memberinfo (userID, userPW, userName, userPhoto) values (?, ?, ?, ?)";   
								PreparedStatement pstmt = conn.prepareStatement(sql1, new String[] {"index"});
								pstmt.setString(1, member.getUserID());
								pstmt.setString(2, member.getUserPW());
								pstmt.setString(3, member.getUserName());
								pstmt.setString(4, member.getUserPhoto());
								
								return pstmt;
							}
						},
						holder);
		
		
		Number index = holder.getKey();
		member.setIndex(index.intValue());
		
		
		return resultCnt;
	
	}
	
	
	
	
	
/*	
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
*/	
	
	
	
	

/*
	// 위에서 전달받은 (selectByIndex) 회원번호에 해당되는 데이터를 수정 (회원 비밀번호, 회원 이름)
	public int updateMember(Connection conn, EditInfo editInfo) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "update memberinfo set `USERID`=?, `USERPW`=?, `USERNAME`=? where `INDEX`=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, editInfo.getUserID());
			pstmt.setString(2, editInfo.getUserPW());
			pstmt.setString(3, editInfo.getUserName());
			pstmt.setInt(4, editInfo.getIndex());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	
		return resultCnt;
		
	}
	
*/
	
	
	public Member selectByIdPw(String userID, String userPW) {
		
		// String sql = "select * from memberinfo where `userID` = ? and `userPW` = ?";
		List<Member> list = template.query("select * from memberinfo where `userID` = ? and `userPW` = ?", new MemberRowMapper(), userID, userPW);
		// Member member = list.isEmpty() ? null : list.get(0); 
		// null 또는 객체 하나를 가져온다. (첫번째 인덱스 값)
				
		
		return list.isEmpty() ? null : list.get(0);
		
	}

	
	
	// ID 중복여부 확인을 위한 ID값으로 검색 -> 개수 반환
	public int selectByID(String userID) throws SQLException {
		
		// String sql = "select count(*) from memberinfo where userID = ?";
		// int cnt = template.queryForObject(sql, Integer.class, userID);
		
		return template.queryForObject("select count(*) from memberinfo where userID = ?", Integer.class, userID);
	}

	
	
	
	
	private Member makeMember(ResultSet rs) throws SQLException {

		Member member = new Member();
		member.setIndex(rs.getInt("index"));
		member.setUserID(rs.getString("userid"));
		member.setUserPW(rs.getString("userpw"));
		member.setUserName(rs.getString("username"));
		member.setUserPhoto(rs.getString("userPhoto"));
		member.setRegDate(rs.getTimestamp("regdate"));
		
		
		return member;
		
	}

	
}
