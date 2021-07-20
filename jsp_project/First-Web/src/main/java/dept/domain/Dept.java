package dept.domain;

public class Dept {
	
	// Beans 빈즈 형태
	private int deptno;
	private String dname;
	private String loc;
	
	
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	
	
	// 기본 생성자 생성
	public Dept() {}

	
	
				//deptno
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}


	
	
	
	
	// 변수 일괄 출력 : toString (데이터 확인용)
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
}
