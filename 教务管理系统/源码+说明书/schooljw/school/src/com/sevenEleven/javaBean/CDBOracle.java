package com.sevenEleven.javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CDBOracle {

	Connection con = null;

	Statement stmt = null;

	String sql = "";

	ResultSet rs = null;

	@SuppressWarnings("unused")
	//private static final String DRIVE = "com.microsoft.jdbc.sqlserver.SQLServerDriver";// 驱动
	private static final String DRIVE = "sun.jdbc.odbc.JdbcOdbcDriver";// 驱动

	@SuppressWarnings("unused")
	private final String USERNAME = "sa";

	@SuppressWarnings("unused")
	private final String PASSWORD = "sa";

	@SuppressWarnings("unused")
	//private static final String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=school";// 连接字符串
	private static final String url = "jdbc:odbc:school";// 连接字符串

	public void DBConn() { // 加载驱动方法

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

			//String strUrl = url;
			
			con = DriverManager.getConnection(this.url);
			//con = DriverManager.getConnection(strUrl, this.USERNAME,this.PASSWORD);

		}

		catch (Exception e) {

			con = null;
		}
		return con;

	}

	public void dropConnection() { // 关闭连接

		try {

			closeStmt();

			con.close();

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

		int i = 0;

		stmt = null;

		rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement();

			i = stmt.executeUpdate(sql);

			stmt.close();

			con.close();

		}

		catch (SQLException ex) {

			System.err.println("DBConn:executeUpdate(0:" + ex.getMessage());

		}

		return i;

	}

	public void execute(String sql) { // 执行sql语句

		stmt = null;

		rs = null;

		try {

			con = getConnection();

			stmt = con.createStatement();

			stmt.execute(sql);

			stmt.close();

			con.close();

		}

		catch (SQLException ex) {

			System.err.println("DBConn:excute():" + ex.getMessage());

		}

	}

	public void closeConn() { // 关闭sql连接

		try {

			stmt.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void closeStmt() { // 关闭sql连接

		try {

			con.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
