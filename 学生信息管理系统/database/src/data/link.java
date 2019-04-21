package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class link {
	private static final String jdbcUrl = "jdbc:mysql://localhost/database?useUnicode=true&&characterEncoding=utf-8";
	private static final String user = "onya";
	private static final String passwd = "960906";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(jdbcUrl, user, passwd);
		return conn;
	}
}
