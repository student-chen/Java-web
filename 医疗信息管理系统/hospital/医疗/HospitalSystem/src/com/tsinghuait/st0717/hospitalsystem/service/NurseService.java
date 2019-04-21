package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;

public class NurseService {
	
	//对护士的查询
	/**
	 * 返回总行数，分页
	 * */
	int rowsPages=0;//总行数
	int pageCount=1;//显示页数	
	public ArrayList selectNurse(String sql,int page,int pageSize){
		ArrayList<Nurse> arr=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			  if(rs!=null){
				arr=new ArrayList<Nurse>();
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
					Nurse dto=new Nurse();
					dto.setId(rs.getInt("id"));
					dto.setStaffNo(rs.getString("staffNo"));
					dto.setName(rs.getString("name"));
					dto.setSex(rs.getString("sex"));
					dto.setPostid(rs.getInt("postid"));
					dto.setPost(rs.getString("post"));
					dto.setLoginName(rs.getString("loginName"));
					dto.setLoginPassword(rs.getString("loginPassword"));
                    arr.add(dto);
                    i++;
				}while(rs.next()&&i<pageSize);
			  }
			} catch (SQLException e) {
				System.out.println("对护士表的操作有误！");
				e.printStackTrace();
			}
		return arr;
	}	
	public ArrayList selectNurse(String sql){
		ArrayList<Nurse> arr=null;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		try {
			  if(rs!=null){
				arr=new ArrayList<Nurse>();
					while(rs!=null&&rs.next()){
					Nurse dto=new Nurse();
					dto.setId(rs.getInt("id"));
					dto.setStaffNo(rs.getString("staffNo"));
					dto.setName(rs.getString("name"));
					dto.setSex(rs.getString("sex"));
					dto.setPostid(rs.getInt("postid"));
					dto.setPost(rs.getString("post"));
					dto.setLoginName(rs.getString("loginName"));
					dto.setLoginPassword(rs.getString("loginPassword"));
                    arr.add(dto);
				}
			  }
			} catch (SQLException e) {
				System.out.println("对护士表的操作有误！");
				e.printStackTrace();
			}
		return arr;
	}
	public int NurseUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	public int NurseInsert(String sql){
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
	public int deleteNurseBatch(String[] ids){
		int num=0;
		for (int i=0;i<ids.length;i++)
		{
			num=this.NurseDelete(ids[i]);
		}
		return num;
	}
	public int NurseDelete(String id){
		int num=0;
		num=new SQLConnection().executeUpdate("delete from nurse where id="+id);
		return num;
	}
	
	public boolean nurseNameResultSet(String sql){
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
