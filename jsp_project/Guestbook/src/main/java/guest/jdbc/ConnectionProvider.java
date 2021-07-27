package guest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		
		String jdbcUrl = "";
		String user = "";
		String pw = "";

		Connection conn = null;
		conn = DriverManager.getConnection(jdbcUrl, user, pw);
		
		
		
	}

}
