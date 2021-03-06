package dept.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class DeptDaoTest {

	
	public static Connection conn;
	public static DeptDao dao;
	public static Dept dept;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("테스트 완료");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// Dept리스트 생성 test
	@Test
	public void testGetDeptList() throws SQLException {
		List<Dept> list = dao.getDeptList(conn);
		assertNotNull("Dept리스트 생성 확인", list);
	}
	
	// Insert Test
	@Test
	public void testInsertDept() {
		int resultCnt = dao.insertDept(conn, new Dept(70, "CS팀", "원주"));
		assertSame("Dept가 insert되었는지 확인", resultCnt, 1);
	}
	
	
	// Delete Test
	@Test
	public void testDeleteDept() {
		int resultCnt = dao.deleteDept(conn, 50);
		assertSame("Dept가 delete되었는지 확인", resultCnt, 1);
	}
	
	
	// Update Test
	@Test
	public void testUpdateDept() {
		int resultCnt = dao.updateDept(conn, new Dept(2, "개발팀2", "서울"));
		assertSame("Dept가 update되었는지 확인", resultCnt, 1);
	}
	
	
	// SelectByDeptno Test
	@Test
	public void testSelectByDeptno() {
		dept = dao.selectByDeptno(conn, 30);
		assertNotNull("Dept가 select되었는지 확인", dept);
	}
	

}
