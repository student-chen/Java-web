package msc.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import msc.dbc.DataBaseConnection;
import msc.vo.Teacher;

public class TeacherDAO {
	public void InsertTeacher(String tid,String tname,String tcode) throws Exception{
		String sql="INSERT INTO teacher(tid,tname,tcode) VALUES('"+tid+"','"+tname+"','"+tcode+"');";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
	 
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("插入中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
	public void DeletebyID(String tid) throws Exception{
		String sql="DELETE FROM teacher WHERE tid='"+tid+"';";
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
	public Vector Select(String tid,String tname)throws Exception{
		Vector all=new Vector();
		String sql1="SELECT * FROM teacher WHERE tid LIKE '%"+tid+"%';";
		String sql2="SELECT * FROM teacher WHERE tname LIKE '%"+tname+"%';";
		String sql3="SELECT * FROM teacher WHERE tid LIKE '"+tid+"' and tname LIKE '%"+tname+"%';";
		String sql4="SELECT * FROM teacher;";
		String sql=null;
		if(tid!=""){
			if(tname!=""){
				sql=sql3;
			}else{
				sql=sql1;
			}
		}else{
			if(tname!=""){
				sql=sql2;
			}else{
				sql=sql4;
			}
		}
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Teacher tea=new Teacher();
				tea.setTid(rs.getString("tid"));
				tea.setTname(rs.getString("tname"));
				tea.setTcode(rs.getString("tcode"));
				all.addElement(tea);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			throw new Exception("查询中出现错误！！！");
		} finally {
			dbc.close();
		}
		return all;
	}
	public void UpdatebyID(String tid,String tname,String tcode) throws Exception{
		String sql="UPDATE teacher set tname='"+tname+"',tcode='"+tcode+"'  WHERE tid='"+tid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("修改中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
	public void Changecode(String tid,String tcode) throws Exception{
		String sql="UPDATE teacher set tcode='"+tcode+"'  WHERE tid='"+tid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("修改中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}

}
