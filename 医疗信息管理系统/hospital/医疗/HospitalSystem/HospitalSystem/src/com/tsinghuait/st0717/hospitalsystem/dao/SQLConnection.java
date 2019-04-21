package com.tsinghuait.st0717.hospitalsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SQLConnection {
	/**
	 * 连接数据库(用户查询图书信息,在SearchBookServlet中实现)
	 * */	
	Connection conn=null;
	public SQLConnection(){
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital","sa", "sa");
			
			//五楼 的驱动、配置数据源
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//conn=DriverManager.getConnection("jdbc:odbc:com","sa","sa");
			System.out.println("数据库连接成功!! ");	
		} catch (Exception e) {
			System.out.println("数据库连接失败--");
			e.printStackTrace();
		}	
	}
	public Connection getConnection(){
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;databaseName=Hospital","sa", "sa");
			
			//五楼 的驱动、配置数据源
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//conn=DriverManager.getConnection("jdbc:odbc:com","sa","sa");
			System.out.println("数据库连接成功!! ");	
		} catch (Exception e) {
			System.out.println("数据库连接失败--");
			e.printStackTrace();
		}	
		return conn;
	}
	/**
	 * 查询数据库中的表
	 * */
	public ResultSet executeQuery(String sql){
		ResultSet rs=null;
		try {
			Statement st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs!=null){
				System.out.println("查询数据成功！！"+rs);
			}else{
				System.out.println("查询数据失败！！"+rs);
				rs=null;
			}
		} catch (SQLException e) {
			System.out.println("查询数据库出现操作错误!!!"+e);
			rs=null;
		}
		return rs;
	}
	
	/**
	 * 对数据库中的表进行  添加,修改,删除  操作
	 * */
	public int executeUpdate(String sql){
		int num=0;
		try {
			Statement st=conn.createStatement();
			num=st.executeUpdate(sql);
			if(num!=0){
				System.out.println("对数据库操作成功!!"+num);
			}else{
				System.out.println("对数据库操作失败！！"+num);
				num=0;
			}
		} catch (SQLException e) {
			System.out.println("对数据库中的表进行操作时出现操作错误!!");
			e.printStackTrace();
		}
		return num;
	}
	/**
	 * 关闭数据库
	 * */
	public void getColse(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("数据库关闭失败，请稍候在关闭！！");
			e.printStackTrace();
		}
	}
}