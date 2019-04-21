package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Nurse;
import com.tsinghuait.st0717.hospitalsystem.dto.Sickbed;
public class SickBedService {
	/*吴吉瑞
	 * 	
	 * 该类对病床表进行操作       
	 * **/	
	//查询病床表 
	public ArrayList selectSickBed(String sql){
	   	ArrayList<Sickbed> arrayList=null;
	   	try{
	   		ResultSet rs=new SQLConnection().executeQuery(sql);
		     if(rs!=null){
		    	  arrayList=new ArrayList<Sickbed>();
		    	  while(rs.next()&&rs!=null) {
		    		     Sickbed dto=new Sickbed(); 
		    		     dto.setId(rs.getInt("id"));
		                 dto.setBedNo(rs.getString("bedNo"));
		                 dto.setIsUseable(rs.getInt("isUseable"));
		                 dto.setType(rs.getString("type"));
		    			 arrayList.add(dto);
		    		 }	   		 
		    	   }
		 }catch(Exception e){
		      e.printStackTrace();
    }  	  
		return arrayList;	
	}
	
	public ArrayList showNurse(int id){
		ArrayList<Nurse> array=null;
		String sql="select nurse.name as name from nurse_sickbed,sickbed,nurse where nurse_sickbed.nurse_id=nurse.id and nurse_sickbed.sickbed_id=sickbed.id and sickbed.id="+id+"";
		ResultSet rs=new SQLConnection().executeQuery(sql);
		try{
			if(rs!=null){
				array=new ArrayList<Nurse>();
				while(rs!=null&&rs.next()){
					Nurse dto=new Nurse();
					dto.setName(rs.getString("name"));
					array.add(dto); 
				}
			}
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		return array;
	}
	
//	返回病床表的最后一行的	ID
	public int returnSickId(){
	   String selectId="select top 1 id from sickbed order by id  desc";
	    ResultSet rs=new SQLConnection().executeQuery(selectId);
		int id=0;
		    if(rs!=null){
		    	try {
		    		while(rs.next()){
		    			id=rs.getInt("id");
		    		}
				} catch (SQLException e) {	
					e.printStackTrace();
				}
		    }
		return id;
	}
	
	//删除   添加信息  修改 信息
	public int executeUpdate(String sql){
		int count=0;
		try{ 
			count=new SQLConnection().executeUpdate(sql);
		  if(count>0){
			  System.out.println(" 操作成功！");
		  }
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;	
	}
	
}
