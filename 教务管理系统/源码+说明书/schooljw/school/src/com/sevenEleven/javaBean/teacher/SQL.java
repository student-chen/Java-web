package com.sevenEleven.javaBean.teacher;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class SQL {
	private Connection conn;
	private Statement smtp;
	private ResultSet rs;
	
	public SQL(){
		try {
			//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			//this.conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=school","sa","sa");
			this.conn = DriverManager.getConnection("jdbc:odbc:school");
			smtp = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public int ExeUpdate(String strSQL){
		int count = 0;
		try {
			count = smtp.executeUpdate(strSQL);
		} catch (SQLException e) {
			e.printStackTrace();
			return count;
		} catch (Exception e){
			return count;
		}
		return count;
	}
	
	public ResultSet ExeSelect(String strSQL){
		try {
			rs = smtp.executeQuery(strSQL);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e){
			return null;
		}
		return rs;
	}
	
	public void Close(){
		try {
			if (rs!=null)
			rs.close();
			if (smtp!=null)
			smtp.close();
			if (conn!=null)
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} catch (Exception e){
			return;
		}
	}

}
