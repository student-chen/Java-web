package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Medicalcourses;
public class MedicalcoursesService {
	/**
	 * 数据库  科别表 medicalcourses 查询
	 * */
	//查询
	public ResultSet selectMedicalcourses(String sql){
		ResultSet rs=null;
		rs=new SQLConnection().executeQuery(sql);
		return rs;		
	}
	 //对科别中的表进行  添加,修改,删除 
	public int executeUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	
	//便历科别表
	public ArrayList selectRowsMedicalcourses(String sql){
		ArrayList<Medicalcourses> arr=null;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		if(rs!=null){
			arr=new ArrayList<Medicalcourses>();
			try {
				while(rs.next()&&rs!=null){
					Medicalcourses dto=new Medicalcourses();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					dto.setType(rs.getByte("type"));
					arr.add(dto);
				}
			} catch (SQLException e) {
				System.out.println("数据库  科别表 medicalcourses 便历操作失败");
				e.printStackTrace();
			}
		}
		return arr;
	}	
	/**
	 * 分页技术
	 * 
	 */
	int rowsPages=0;//总行数
	int pageCount=1;//显示页数
	public ArrayList selectRowsMedicalcourses(String sql,int page,int pageSize){
		ArrayList<Medicalcourses> arr=null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			  if(rs!=null){
				 arr=new ArrayList<Medicalcourses>();
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
						Medicalcourses dto=new Medicalcourses();
						dto.setId(rs.getInt("id"));
						dto.setName(rs.getString("name"));
						dto.setType(rs.getByte("type"));
						arr.add(dto);
						i++;
				}while(rs.next()&&i<pageSize);
			  }
			} catch (SQLException e) {
				System.out.println("数据库  科别表 medicalcourses 便历操作失败");
				e.printStackTrace();
		}
		return arr;
	}	
//	查询科别名称 
	public int selectNameMed(String name){
		String sql="select * from medicalcourses where name='"+name+"'";
		ResultSet rs=new SQLConnection().executeQuery(sql);
		int num=0;
		try {
			while(rs!=null&&rs.next()){
				Medicalcourses dto=new Medicalcourses();
				dto.setId(rs.getInt("id"));				
				num=dto.getId();
			}
		} catch (SQLException e) {
			System.out.println("从数据库中科别表读取科别的ID出现错误..."+rs);
			e.printStackTrace();
		}
		return num;
	}
//	添加科别表信息
    public int insertMedicalcourses(String name,String type){
    	int num=0;
    	num=new SQLConnection().executeUpdate("insert into medicalcourses values('"+name+"','"+type+"')");
    	return num;
    }
    
    //删除科别表信息
    public int deleteById(String id){
    	int num=0;
    	num=new SQLConnection().executeUpdate("delete from medicalcourses where id="+id);
    	return num;
    }
   //修改科别表信息
    public int updateById(String sql){ 
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
	public int deleteDoctorBatch(String ids[]){
		int refrenceRows=0;
		for (int i=0;i<ids.length;i++)
		{
			refrenceRows=this.deleteById(ids[i]);
		}
		return refrenceRows;
	}
}