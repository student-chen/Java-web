package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.StayInHp;
public class StayInHpService{
//	查询
	public ResultSet selectStay(String sql){
		ResultSet rs=null;
		rs=new SQLConnection().executeQuery(sql);
		return rs;		
	}
	//遍历住院表
	public ArrayList selectRowsStay(String sql) throws SQLException{
		ArrayList<StayInHp> arr=null;
		ResultSet rs=new SQLConnection().executeQuery(sql);
		if(rs!=null)
		{
			arr=new ArrayList<StayInHp>();
			try
			{ 
				int i=0;
				while(rs.next()&&rs!=null)
				{		
					StayInHp dto=new StayInHp();
					dto.setId(rs.getInt("id"));
					dto.setPatientId(rs.getInt("patientId"));
					dto.setBedId(rs.getInt("bedId"));
					dto.setDays(rs.getInt("days"));
					arr.add(dto);
					i++;
				}
			}catch(Exception e)
			{
				System.out.println("对住院表的操作有误!");
				e.printStackTrace();
			}
			
		}
		return arr;
	}
	//对数据库操作
	public int execteUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
  //删除住院表信息
    public int deleteById(int oid)
    {
    	return new SQLConnection().executeUpdate("delete from patient where id"+oid);
    }
}
