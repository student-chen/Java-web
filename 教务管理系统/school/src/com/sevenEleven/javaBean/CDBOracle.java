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

	private static final String DRIVE = "sun.jdbc.odbc.JdbcOdbcDriver";// ��

	@SuppressWarnings("unused")
	private final String USERNAME = "sa";

	@SuppressWarnings("unused")
	private final String PASSWORD = "sa";

	private static final String url = "jdbc:odbc:school";

	public void DBConn() { 

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

	public Connection getConnection() { // �õ�����

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

	public void dropConnection() { // �ر�����

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

	public ResultSet executeQuery(String sql) { // ִ��sql��ѯ

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

	public int executeUpdate(String sql) { // ִ��sql�������

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

	public void execute(String sql) { // ִ��sql���

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

	public void closeConn() { // �ر�sql����

		try {

			stmt.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void closeStmt() { // �ر�sql����

		try {

			con.close();

		}

		catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
