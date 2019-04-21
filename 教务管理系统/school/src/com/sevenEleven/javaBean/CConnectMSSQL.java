package com.sevenEleven.javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CConnectMSSQL {
	private Connection conn;

	private ResultSet rs;

	public CConnectMSSQL() {
		getConn();
	}

	private Connection getConn() {
		try {
			
			//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			
			//String url="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=school";
			String url = "jdbc:odbc:school";
			//String user = "sa";
			//String password = "sa";
			//conn = DriverManager.getConnection(url, user, password);
			conn = DriverManager.getConnection(url);

		} catch (InstantiationException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return conn;
	}

	public List getNestedListFromResultSet(String sql) {
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				// System.out.println(rs.getObject(1));
				listColumn = new LinkedList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					listColumn.add(rs.getObject(i));
				}
				
				listRow.add(listColumn);
				
			}
			closeConn();
			return listRow;
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			
		}
		return listRow;
	}

	public void closeConn() throws SQLException {
		if (rs != null)
			rs.close();
		if (conn != null)
			conn.close();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CConnectMSSQL ccon = new CConnectMSSQL();
		List list = ccon.getNestedListFromResultSet("select * from student");
		System.out.print(list);
	}

}
