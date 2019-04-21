package com.tsinghuait.st0717.hospitalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

public class SQLServerDBManager {

	/**
	 * 该方法用于连接SQL Server数据库
	 * 
	 * @param url:
	 *            连接数据库的url
	 * @param username:
	 *            数据库访问用户名
	 * @param password:
	 *            数据库访问密码
	 */
	public static Connection getConnection(String url, String username,
			String password) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 该方法用户查询数据库并返回ResultSet类型的结果集
	 * 
	 * @param sql:数据库查询语句
	 * @param id:
	 *            要查找数据的ID
	 */
	public static ResultSet execQuery(String sql) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Collection execQuery(int id) {
		Collection coll = null;
		return coll;
	}

	/**
	 * 该方法用于修改对应的数据信息
	 * 
	 * @param sql:用于修改数据的sql语句
	 * @return int :影响的行数
	 */
	public int updateData(String sql) {
		int refrenceRows = 0;
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn.createStatement();
			refrenceRows = stmt.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return refrenceRows;
	}

	/**
	 * 该方法用于删除对应的数据信息
	 * 
	 * @param sql:用于删除数据的sql语句
	 */
	public int deleteData(String sql) {
		int refrenceRows = 0;
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn.createStatement();
			refrenceRows = stmt.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return refrenceRows;
	}

	/**
	 * 该方法用于存储数据信息
	 * 
	 * @param sql:用于存储数据的sql语句
	 */
	public static void saveData(String sql) {
		try {
			Connection conn = getConnection(
					"jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital",
					"sa", "sa");
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
