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
		member.setUserID(rs.getString("userid"));
		member.setUserPW(rs.getString("userpw"));
		member.setUserName(rs.getString("username"));
		member.setUserPhoto(rs.getString("userPhoto"));
		member.setRegDate(rs.getTimestamp("regdate"));
		
		return member;
	}

}


