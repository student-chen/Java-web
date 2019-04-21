package msc.dao;
import java.sql.*;
import java.util.Vector;

import msc.vo.*;
import msc.dbc.DataBaseConnection;
public class StudentDAO {
	public void InsertStudent(String sid,String sname,String smajor,String sclass,String scode) throws Exception{
		String sql="INSERT INTO student(sid,sname,smajor,sclass,scode) VALUES('"+sid+"','"+sname+"','"+smajor+"','"+sclass+"','"+scode+"');";
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
	public void DeletebyID(String sid) throws Exception{
		String sql="DELETE FROM student WHERE sid='"+sid+"';";
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
	public Vector Select(String sid,String sclass,String smajor)throws Exception{
		Vector all=new Vector();
		String sql1="SELECT * FROM student WHERE";
		String sql=null;
		if(sid!="")
		{
			sql=sql1+" sid LIKE '%"+sid+"%'";
			if(sclass!="")
			{
				sql=sql+" and sclass LIKE '%"+sclass+"%'";
			}
			if(smajor!="")
			{
				sql=sql+" and smajor LIKE '%"+smajor+"%'";
			}
		}
		else
		{
			if(sclass!="")
			{
				sql=sql1+" sclass LIKE '%"+sclass+"%'";
				if(smajor!="")
				{
					sql=sql+" and smajor LIKE '%"+smajor+"%'";
				}
			}
			else
			{
				if(smajor!="")
				{
					sql=sql1+" smajor LIKE '%"+smajor+"%'";
				}
				else
				{
					sql="SELECT * FROM student";
				}
			}
		}
		sql=sql+" ORDER BY egrade DESC;";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Student stu=new Student();
				stu.setSid(rs.getString("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setSmajor(rs.getString("smajor"));
				stu.setSclass(rs.getString("sclass"));
				stu.setTcredit(rs.getDouble("tcredit"));
				stu.setTcreditjd(rs.getDouble("tcreditjd"));
				stu.setOcredit(rs.getDouble("ocredit"));
				stu.setAcredit(rs.getDouble("acredit"));
				stu.setEgrade(rs.getDouble("egrade"));
				stu.setMajorpm(rs.getInt("majorpm"));
				stu.setClasspm(rs.getInt("classpm"));
				stu.setScode(rs.getString("scode"));
				all.addElement(stu);
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
	public String SelectBySid(String sid) throws Exception{
		String sname=null;
		String sql="select sname from student where sid='"+sid+ "';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try {
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				
				sname=rs.getString("sname");
				
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("查询中出错！！！");
		}finally{
			dbc.close();
		}
		return sname;
		
	}
	public void UpdatebyID(String sid,String sname,String smajor,String sclass,String scode) throws Exception{
		String sql="UPDATE student set sname='"+sname+"',smajor='"+smajor+"',sclass='"+sclass+"',scode='"+scode+"'  WHERE sid='"+sid+"';";
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
	public void Changecode(String sid,String scode) throws Exception{
		String sql="UPDATE student set scode='"+scode+"'  WHERE sid='"+sid+"';";
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
