package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;


public class DiagnosisService {
	SQLConnection ssd=new SQLConnection();
	ResultSet rs=null;
   public int selectDoctorID(String sql)
   {
	   int doctorID=0;
	   rs=ssd.executeQuery(sql);
	   try
	   {
		   if(rs!=null)
		   {
			   while(rs.next())
			   {
				  doctorID=rs.getInt("id");
			   }
		   }
	   }
	   catch (SQLException e) 
	   {
		System.out.println("查询医生ID不成功");
		e.printStackTrace();
	   }
	   return doctorID;
    }
   public int selectPatientID(String sql)
   {
	   int patientID=0;
	   rs=ssd.executeQuery(sql);
	   try
	   {
		   if(rs!=null)
		   {
			   while(rs.next())
			   {
			   patientID=rs.getInt("oid");
			   }
		   }
		   else
		   {
			   System.out.println("ID为空");
		   }
	   }
	   catch (SQLException e) 
	   {
		System.out.println("查询病人ID不成功");
		e.printStackTrace();
	   }
	   return patientID;
    }
   public boolean insertDiagnosis(String sql)
   {
	   boolean flag=false;
	   int i=ssd.executeUpdate(sql);
	   try{
		   if(i>0)
		   {
			   flag=true;
		   }
		   System.out.println("插入"+i);
	   } 
	   catch (Exception e)
	   {
		System.out.print("添加诊断书不成功");
		e.printStackTrace();
	   }
	   return flag;
   }
   public boolean updateDiagnosis(String sql)
   {
	   boolean flag=false;
	   int i=ssd.executeUpdate(sql);
	   try{
		   if(i>0)
		   {
			   flag=true;
		   }
		   System.out.println("修改"+i);
	   } 
	   catch (Exception e)
	   {
		System.out.print("添加诊断书不成功");
		e.printStackTrace();
	   }
	   return flag;
   }
}
