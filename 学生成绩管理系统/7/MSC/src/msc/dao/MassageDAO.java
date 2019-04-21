package msc.dao;

import java.sql.*;
import java.util.Vector;

import msc.dbc.DataBaseConnection;
import msc.vo.*;

public class MassageDAO {

	public void InsertMassage(String id,String name,String content,String date) throws Exception{
		String sql = "INSERT INTO record (id,name,content,date) VALUES ('"+id+"','"+name+"','"+content+"','"+date+"');";
		Statement stmt = null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			System.out.println("##############");
			stmt.close();			
		}catch (Exception e) {
			throw new Exception("插入中出错！！！");
		}finally{
		dbc.close();
		}
	}
	
	public Vector SearchMassage()throws Exception{
		Vector all=new Vector();
		String sql="SELECT * FROM record ORDER BY mid desc";		
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		
		try {
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
				while (rs.next()) {
					Massage msg=new Massage();
					msg.setMid(rs.getInt("mid"));
					msg.setId(rs.getString("id"));
					msg.setName(rs.getString("name"));
					msg.setContent(rs.getString("content"));
					msg.setDate(rs.getString("date"));
					all.addElement(msg);
				}
    			rs.close();
    			stmt.close();
		} catch (Exception e) {
			throw new Exception("查询中出现错误！！！");
		}finally{
		dbc.close();
		}
		return all;
	}
	public void DeletebyMid(int mid) throws Exception{
		String sql="DELETE FROM record WHERE mid="+mid+";";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("删除中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
}
