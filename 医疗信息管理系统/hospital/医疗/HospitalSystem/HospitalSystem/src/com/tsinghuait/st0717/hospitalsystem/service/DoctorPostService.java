package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.ViewDoctorPostMedicalcoursesDTO;
public class DoctorPostService {
	/**
	 * 对医生进行联合查询
	 * */
	//测试  对护士部门 viewNursePost视图 的查看
	int rowsPages=0;//总行数
	int pageCount=1;//显示页数	
	//对医生视图表查询
	public ArrayList selectViewDoctorPost(String sql,int page,int pageSize){
		ArrayList<ViewDoctorPostMedicalcoursesDTO> arr=null;
			try {
				Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs=st.executeQuery(sql);
				if(rs!=null){
					arr=new ArrayList<ViewDoctorPostMedicalcoursesDTO>();
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
				while(rs.next()&&i<pageSize){
					ViewDoctorPostMedicalcoursesDTO dto=new ViewDoctorPostMedicalcoursesDTO();
					dto.setId(rs.getInt("id"));
					dto.setWorkNum(rs.getString("workNum"));
					dto.setName(rs.getString("name"));
					dto.setPostName(rs.getString("postName"));
					dto.setSex(rs.getString("sex"));
					dto.setBirthday(rs.getDate("birthday"));
					dto.setInfo(rs.getString("info"));
					dto.setMcName(rs.getString("mcName"));
					dto.setLoginName(rs.getString("loginName"));
					dto.setLoginPassword(rs.getString("loginPassword"));
					dto.setIsActive(rs.getInt("isActive"));
					arr.add(dto);
					i++;
				}
			  }
			} catch (SQLException e) {
				System.out.println("对医生视图表的操作有误！");
				e.printStackTrace();
			}
		return arr;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getRowsPages() {
		return rowsPages;
	}
	public int exectUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
}
