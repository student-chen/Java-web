package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.OperatingRoom;
public class OperatingRoomService 
{
	public ArrayList selectOperationRoom(String sql){
		ArrayList<OperatingRoom> arr=null;	
      try 
		 {
		   ResultSet rs=new SQLConnection().executeQuery(sql);
		 if(rs!=null)
		{
			arr=new ArrayList<OperatingRoom>();
		      while(rs.next())
		      {
		    	  OperatingRoom dto=new OperatingRoom();
					dto.setId(rs.getInt("id"));
					dto.setOrNo(rs.getString("orNo"));
					dto.setType(rs.getString("address"));
					dto.setAddress(rs.getString("address"));
					dto.setInfo(rs.getString("info"));
					dto.setNurseList(rs.getString("nurseList"));
					dto.setIsUseable(rs.getInt("isUseable"));
					arr.add(dto);
				}
			 }	
		}	catch(Exception e)
		       {
			e.printStackTrace();
		       }
		return arr;
	}
	public ResultSet exectQuery(String sql){
		return new SQLConnection().executeQuery(sql);
	}
	public int exectUpdate(String sql){
		return new SQLConnection().executeUpdate(sql);
	}
}
