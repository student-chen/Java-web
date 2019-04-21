package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCon {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		/*由于我的电脑安装sqlserver后没有开放1433端口，故改用odbc方式连接sqlserver数据库*/
		//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
		//String url="jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=school"; 
		String url = "jdbc:odbc:school";
		//String user="sa"; 
		//String password="sa"; 
		try {
			 //Connection conn= DriverManager.getConnection(url,user,password);
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

				ResultSet	rs = stmt.executeQuery("select * from administrator");
				while(rs.next()){
					System.out.println(rs.getObject(1));
					System.out.println(rs.getObject(2));
					System.out.println(rs.getObject(3));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
