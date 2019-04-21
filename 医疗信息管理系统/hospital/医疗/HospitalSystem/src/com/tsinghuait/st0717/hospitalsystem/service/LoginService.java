package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Doctor;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;

public class LoginService {
	/*
	 * 登录判断
	 * */
	public ResultSet loginSelect(String sql){
		ResultSet rs=null;
		rs=this.executeQuery(sql);
		return rs;
	}	
	/**
	 * 查询数据库中的表
	 * */
	public ResultSet executeQuery(String sql){
		ResultSet rs=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement();
			rs=st.executeQuery(sql);
			if(rs!=null&&rs.next()){
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
	
	//查询医生的科别
	public String selectDoctorMcName(String sql){
		ResultSet rs=new SQLConnection().executeQuery(sql);
		String mcName="";
		if(rs!=null){
			try {
				while(rs!=null&&rs.next()){
					Doctor dto=new Doctor();
					dto.setMcName(rs.getString("mcName"));
					mcName=dto.getMcName();
				}
			} catch (SQLException e) {
				System.out.println("loginServlet返回医生科别错误...");
				e.printStackTrace();
			}
		}
		return mcName;
	}
	
	//查询护士的科别
	public String seleceNursePost(String sql){
		ResultSet rs=new SQLConnection().executeQuery(sql);
		String mcName="";
		if(rs!=null){
			try {
				while(rs!=null&&rs.next()){
					Nurse dto=new Nurse();
					dto.setPost(rs.getString("post"));
					mcName=dto.getPost();
				}
			} catch (SQLException e) {
				System.out.println("loginServlet返回护士科别错误...");
				e.printStackTrace();
			}
		}
		return mcName;
	}
}
