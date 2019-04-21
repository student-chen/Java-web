package com.sevenEleven.javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


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
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String ur1 = "jdbc:mysql://localhost:3306/school?characterEncoding=utf-8";
			String user1 = "root";
			String pwd1 = "";
			try {
				conn = DriverManager.getConnection(ur1, user1, pwd1);
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
