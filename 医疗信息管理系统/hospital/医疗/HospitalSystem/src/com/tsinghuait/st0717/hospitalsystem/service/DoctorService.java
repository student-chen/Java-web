package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Doctor;
import com.tsinghuait.st0717.hospitalsystem.dto.Post;

public class DoctorService {	
	//对医生的查询
	/**
	 * 返回总行数，分页
	 * */
	int rowsPages=0;//总行数
	int pageCount=1;//显示页数
	public ArrayList<Doctor> selectDoctor(String sql,int page,int pageSize){
		ArrayList<Doctor> arr=null;
		try {
		Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery(sql);
		  if(rs!=null){
			 arr=new ArrayList<Doctor>();
				//取得总纪录数
				rs.last();
				rowsPages=rs.getRow();
				pageCount=(rowsPages/pageSize)+(rowsPages%pageSize==0?0:1);		
				if(page>=pageCount){
					page=pageCount;
				}
				int indexCount=(page-1)*pageSize+1;
				rs.absolute(indexCount);
				int i=0;
				do{
					Doctor dto=new Doctor();
					dto.setId(rs.getInt("id"));
					dto.setStaffNo(rs.getString("staffNo"));
					dto.setName(rs.getString("name"));
					dto.setPostid(rs.getInt("postid"));
					dto.setPost(rs.getString("post"));
					dto.setSex(rs.getString("sex"));
					dto.setBirthday(rs.getDate("birthday"));
					dto.setInfo(rs.getString("info"));
					dto.setMcId(rs.getInt("mcId"));
					dto.setMcName(rs.getString("mcName"));
					dto.setLoginName(rs.getString("loginName"));
					dto.setLoginPassword(rs.getString("loginPassword"));
					dto.setIsActive(rs.getInt("isActive"));
					arr.add(dto);
					i++;
				}while(rs.next()&&i<pageSize);
		      }
			} catch (SQLException e) {
				System.out.println("对医生表的操作有误！");
				e.printStackTrace();
			}
		return arr;
	}
	public ArrayList<Doctor> selectDoctor(String sql){
		ArrayList<Doctor> arr=null;
		try {
		Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery(sql);
		  if(rs!=null){
			arr=new ArrayList<Doctor>();
				while(rs!=null&&rs.next()){
					Doctor dto=new Doctor();
					dto.setId(rs.getInt("id"));
					dto.setStaffNo(rs.getString("staffNo"));
					dto.setName(rs.getString("name"));
					dto.setPostid(rs.getInt("postid"));
					dto.setPost(rs.getString("post"));
					dto.setSex(rs.getString("sex"));
					dto.setBirthday(rs.getDate("birthday"));
					dto.setInfo(rs.getString("info"));
					dto.setMcId(rs.getInt("mcId"));
					dto.setMcName(rs.getString("mcName"));
					dto.setLoginName(rs.getString("loginName"));
					dto.setLoginPassword(rs.getString("loginPassword"));
					dto.setIsActive(rs.getInt("isActive"));
					arr.add(dto);
				}
		      }
			} catch (SQLException e) {
				System.out.println("对医生表的操作有误！");
				e.printStackTrace();
			}
		return arr;
	}
	public int DoctorUpdate(String sql)
	{
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	public int DoctorDelete(String id)
	{
		int num=0;
		num=new SQLConnection().executeUpdate("delete from doctor where id="+id);
		return num;
	}	
	public int deleteDoctorBatch(String ids[])
	{
		int refrenceRows=0;
		for (int i=0;i<ids.length;i++)
		{
			refrenceRows=this.DoctorDelete(ids[i]);
		}
		return refrenceRows;
	}
	
	public int DoctorInsert(String sql)
	{
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	
	//查询职称表名称 
	public int selectNamePost(String postName){
		System.out.println("postName:"+postName);
		String sql="select * from post where name='"+postName+"'";
		ResultSet rs=new SQLConnection().executeQuery(sql);
		int num=0;
		try {
			while(rs!=null&&rs.next()){
				Post dto=new Post();
				dto.setId(rs.getInt("id")); 
				num=dto.getId();				
			}
		} catch (SQLException e) {
			System.out.println("从数据库中POST表读取职称的ID出现错误..."+rs);
			e.printStackTrace();
		}
		return num;
	}	
	
	public int updatedoctorpassword(String sql)
	{
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getRowsPages() {
		return rowsPages;
	}
	
	
	public boolean doctorNameResultSet(String sql){
		boolean flag=false;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		try {
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return flag;
	}
}