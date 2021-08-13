package com.bitcamp.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.op.member.domain.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Member member = new Member();
	
		member.setIndex(rs.getInt("index"));
		member.setUserID(rs.getString("userID"));
		member.setUserPW(rs.getString("userPW"));
		member.setUserName(rs.getString("userName"));
		member.setUserPhoto(rs.getString("userPhoto"));
		member.setRegDate(rs.getTimestamp("regDate"));
		
		return member;
	}

}


