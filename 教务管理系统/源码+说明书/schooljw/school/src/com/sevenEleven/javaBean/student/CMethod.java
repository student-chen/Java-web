package com.sevenEleven.javaBean.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class CMethod  {
	private Connection conn;
	private ResultSet res;

	public CMethod() {
		connection();
		// TODO Auto-generated constructor stub
	}

	public void connection() {
		// TODO Auto-generated method stub
		try {
			//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			//String ur1 = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=school";
			String url = "jdbc:odbc:school";
			String user1 = "sa";
			String pwd1 = "sa";
			try {
				//conn = DriverManager.getConnection(ur1, user1, pwd1);
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet query(String sql) {
		try {
			res = conn.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	
	

	public int Update(String sql) throws SQLException {
		int update = 0;
		try {
			update = conn.createStatement().executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return update;

	}
	
	public void closeConn() throws SQLException {
		if (res != null)
			res.close();
	}
}
