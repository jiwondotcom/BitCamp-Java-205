package member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {

	String jdbcUrl = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
    String user = "root";
    String pw = "1234";

    return DriverManager.getConnection(jdbcUrl, user, pw);
     
	}
}
