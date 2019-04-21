package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Sickbed;

public class InHospitalService {
	SQLConnection sc=new SQLConnection();
	 public Collection selectbedNo(String sql)
	    {
	    	ResultSet rs=null;
	    	ArrayList <Sickbed> conn=null;
	    	try {
	    	    rs=sc.executeQuery(sql);
	    	    if (rs != null)
				{
					conn = new ArrayList<Sickbed>();
					while(rs.next()&&rs!=null){
						Sickbed sb=new Sickbed();
	                  sb.setBedNo(rs.getString("bedNo"));
				      conn.add(sb);
				  }
		       }
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return conn;
	    }
	 public int returnId(String sql)
	    {
	    	ResultSet rs=null;
	    	int id=0;
	    	try
	    	{
	    		rs=sc.executeQuery(sql);
	    		if(rs!=null)
	    		{
	    		   while(rs.next())
	    		   {
	    		   id=rs.getInt("id");	
	    		   }
	    		}
	    		else
	    		{
	    			System.out.println("为空");
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("返回ID有异常");
	    		e.printStackTrace();
	    	}
	    	return id;
	    }
	 public int returnSickbedId(String sql)
	    {
	    	ResultSet rs=null;
	    	int id=0;
	    	try
	    	{
	    		rs=sc.executeQuery(sql);
	    		if(rs!=null)
	    		{
	    		   while(rs.next())
	    		   {
	    		   id=rs.getInt("sinkbedId");	
	    		   }
	    		}
	    		else
	    		{
	    			System.out.println("为空");
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("返回sickbedId有异常");
	    		e.printStackTrace();
	    	}
	    	return id;
	    }
	  public boolean insertInHospital(String sql)
	    {
	 	   boolean flag=false;
	 	   int i=sc.executeUpdate(sql);
	 	   try{
	 		   if(i!=0)
	 		   {
	 			   flag=true;
	 		   }
	 		   else{
	 			   System.out.println("插入住院不成功 \n"+i);
	 		   }
	 	   } 
	 	   catch (Exception e)
	 	   {
	 		System.out.print("添加住院不成功");
	 		e.printStackTrace();
	 	   }
	 	   return flag;
	    }
	  public boolean updateInHospital(String sql)
	    {
	 	   boolean flag=false;
	 	   int i=sc.executeUpdate(sql);
	 	   try{
	 		   if(i>0)
	 		   {
	 			   flag=true;
	 		   }
	 		   System.out.println("修改不成功"+i);
	 	   } 
	 	   catch (Exception e)
	 	   {
	 		System.out.print("修改不成功2");
	 		e.printStackTrace();
	 	   }
	 	   return flag;
	    }
	  
	  
	  public int getdate(String startdate,String enddate){
			int time=0;
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-DD");
			try {
				Date dstart = sf.parse(startdate);
				Date dend = sf.parse(enddate);
				long x = dend.getTime() - dstart.getTime();
				time=(int)x/1000/60/60/24;
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return time;
	  }
}
