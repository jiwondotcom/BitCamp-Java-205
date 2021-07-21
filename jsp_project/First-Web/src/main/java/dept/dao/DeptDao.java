package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dept.domain.Dept;
import jdbc.util.JdbcUtil;

public class DeptDao {

	
	// 싱글톤 패턴
	// 1. 인스턴스 생성을 막는다.
	private DeptDao() {}
	
	// 2. 클래스 내부에서 인스턴스를 생성한다.
	private static DeptDao dao = new DeptDao();
	
	// 3. 외부에서 참조값을 반환 받을 수 있는 메소드가 필요
	public static DeptDao getInstance() {
		return dao == null ? new DeptDao() : dao;
	}
	
	
	public List<Dept> getDeptList(Connection conn) throws SQLException{
		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Dept> list = null;
		
		try {
		// 3. Statement객체 생성
		stmt = conn.createStatement();
		String sql = "select * from dept;";
		rs=stmt.executeQuery(sql);
	
		list = new ArrayList<Dept>();
		
		while(rs.next()) {
			list.add(new Dept(rs.getInt(1),
							  rs.getString(2),
							  rs.getString(3)));
		}
		
		} catch(SQLException e) {
 			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		
		return list;
		
	}
	
	
	
	
	// DB 처리 : 새로운 데이터 삽입 insert
	public int insertDept(Connection conn, Dept dept) {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into dept values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	

	
	
	// DB 처리 : 기존 데이터 삭제 delete
	public int deleteDept (Connection conn, Dept dept) {
		 int resultCnt = 0;
		 PreparedStatement pstmt = null;
		 
		 String sql = "delete from dept where deptno = ?";
		 
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		 
		 
		 return resultCnt;
		
	}
	
	
	
	
}
