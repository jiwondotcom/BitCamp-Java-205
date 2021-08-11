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

import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;

@Repository
public class JdbcTemplateMemberDao {

	@Autowired
	private JdbcTemplate template;
	
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
		
	
	

	// 硫ㅻ쾭 由ъ뒪�듃 �깮�꽦-異쒕젰
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

	
	
	
	// DB 泥섎━ : �깉濡쒖슫 �뜲�씠�꽣 �궫�엯 insert
	public int insertMember(Connection conn, Member member) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql1 = "insert into memberinfo (userID, userPW, userName) values (?, ?, ?)";
		String sql2 = "insert into memberinfo (userID, userPW, userName, userPhoto) values (?, ?, ?, ?)";
		
		try {
			
			if(member.getUserPhoto() == null) {
				pstmt = conn.prepareStatement(sql1);
				
				pstmt.setString(1, member.getUserID());
				pstmt.setString(2, member.getUserPW());
				pstmt.setString(3, member.getUserName());
			} else {
				pstmt = conn.prepareStatement(sql2);
				
				pstmt.setString(1, member.getUserID());
				pstmt.setString(2, member.getUserPW());
				pstmt.setString(3, member.getUserName());
				pstmt.setString(4, member.getUserPhoto());
			}
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			JdbcUtil.close(pstmt);
			
		}
		
		return resultCnt;
		
	}
	
	
/*	
	// DB 泥섎━ : 湲곗〈 �뜲�씠�꽣 �궘�젣 delete
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
	// �쐞�뿉�꽌 �쟾�떖諛쏆� (selectByIndex) �쉶�썝踰덊샇�뿉 �빐�떦�릺�뒗 �뜲�씠�꽣瑜� �닔�젙 (�쉶�썝 鍮꾨�踰덊샇, �쉶�썝 �씠由�)
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
	
	
	public Member selectByIdPw(Connection conn, String userID, String userPW) {
		
		/*
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// String sql = "select * from memberinfo where `userID` = ? and `userPW` = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userID);
			pstmt.setString(2, userPW);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = makeMember(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		*/
		
		// String sql = "select * from memberinfo where `userID` = ? and `userPW` = ?";
		List<Member> list = template.query("select * from memberinfo where `userID` = ? and `userPW` = ?", new MemberRowMapper(), userID, userPW);
		// Member member = list.isEmpty() ? null : list.get(0); 
		// null 또는 객체 하나를 가져온다. (첫번째 인덱스 값)
				
		
		return list.isEmpty() ? null : list.get(0);
		
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

	
	// ID 以묐났�뿬遺� �솗�씤�쓣 �쐞�븳 ID媛믪쑝濡� 寃��깋 -> 媛쒖닔 諛섑솚
	public int selectByID(Connection conn, String userID) throws SQLException {
		
		// String sql = "select count(*) from memberinfo where userID = ?";
		// int cnt = template.queryForObject(sql, Integer.class, userID);
		
		return template.queryForObject("select count(*) from memberinfo where userID = ?", Integer.class, userID);
	}

	
	
	
}
