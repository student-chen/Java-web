package com.sevenEleven.javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CDBConnection {


	 protected static Connection con = null;

    Statement stmt = null;

	 protected String sql = "";

	protected ResultSet rs = null;

	/** ************************************************************ */

	//private static final String DRIVE = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
    /*由于本人电脑安装sqlserver后没有开放1433端口，故使用odbc方式连接数据库*/
	private static final String DRIVE = "sun.jdbc.odbc.JdbcOdbcDriver";

	private final String USERNAME = "sa";

	private final String PASSWORD = "sa";

	//private static final String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=school";
    private static final String url = "jdbc:odbc:school";

	public static void DBConn() { // 加载驱动

		try {

			Class.forName(DRIVE).newInstance();

		}

		catch (ClassNotFoundException e) {

			System.err.println("DBConn():" + e.toString());

		}

		catch (Exception e) {

			System.err.println("DBConn():" + e.toString());

		}

	}

	public Connection getConnection() { // 得到连接

		try {
			
			//con = DriverManager.getConnection(strUrl, this.USERNAME,this.PASSWORD);
			
			con = DriverManager.getConnection(this.url);

		}

		catch (Exception e) {

			con = null;
		}
		return con;

	}

	public void dropConnection() { // 关闭连接

		try {
			closeRs();

			closeStmt();

             closeConn();
		}

		catch (Exception ignored) {

		}

		finally {

			con = null;

		}

	}

	public ResultSet executeQuery(String sql) { // 执行sql查询

		ResultSet rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_READ_ONLY);

			rs = stmt.executeQuery(sql);

		}

		catch (SQLException ex) {

			System.err.println("DBConn.executeQuery():" + ex.getMessage());

		}

		return rs;

	}

	public int executeUpdate(String sql) { // 执行sql更新语句

		int b = 0;

		stmt = null;

		rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement();

			b = stmt.executeUpdate(sql);

			stmt.close();

	

		}

		catch (SQLException ex) {

			System.err.println("DBConn:executeUpdate(0:" + ex.getMessage());

		}

		return b;

	}

	public void execute(String sql) { // 执行sql语句

		stmt = null;

		rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement();

			stmt.execute(sql);

			stmt.close();


		}

		catch (SQLException ex) {

			System.err.println("DBConn:excute():" + ex.getMessage());

		}

	}

	public void closeStmt() { // 关闭sql连接

		try {

			stmt.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void closeConn() { // 关闭sql连接

		try {

			con.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}
	public void closeRs() { // 关闭sql连接

		try {

			rs.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}
	

}
