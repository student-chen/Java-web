package msc.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import msc.vo.*;
import msc.dbc.*;
public class MscDAO {
	public Score CalAll(String sid) throws Exception{
		Score sco=new Score();
		String sql="SELECT SUM(credit),SUM(scorejd) FROM sc WHERE sid='"+sid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				sco.setTocredit(rs.getDouble("SUM(credit)")); 
				sco.setToscorejd(rs.getDouble("SUM(scorejd)"));
			}
			rs.close();
			dbc.close();
		}catch (Exception e){
			throw new Exception("查询中出现错误！！！");
		}finally{
			stmt.close();
		}
		return sco;
		
	}
	public double CalToScorejd(String sid) throws Exception{
		double tscorejd=0;
		double scorejd=0;
		String sql="SELECT credit*scorejd FROM sc WHERE sid='"+sid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				scorejd=rs.getDouble("credit*scorejd");
				tscorejd=tscorejd+scorejd;
			}
			rs.close();
			dbc.close();
		}catch (Exception e){
			throw new Exception("查询中出现错误！！！");
		}finally{
			stmt.close();
		}
		return tscorejd;
		
	}
	
	public void AddScore(String sid,double tcredit,double tcreditjd )throws Exception{
		String sql="UPDATE student set tcredit="+tcredit+",tcreditjd="+tcreditjd+" WHERE sid='"+sid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("添加中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
	public Vector SelectMajor()throws Exception{
		Vector all=new Vector();
		String sql="SELECT DISTINCT smajor FROM student";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String smajor=rs.getString("smajor");
				all.addElement(smajor);
			}
			rs.close();
			dbc.close();
		}catch(Exception e){
			throw new Exception("查询中出现错误！！！");
		}finally{
			stmt.close();
		}
		return all;
		
	}
	
	
	public double CalAvg(String smajor) throws Exception{
		double avgscore=0;
		String sql="SELECT AVG(tcredit) FROM student WHERE smajor='"+smajor+"';";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				avgscore=rs.getDouble("AVG(tcredit)");
			}
			rs.close();
			dbc.close();
		}catch (Exception e){
			throw new Exception("查询中出现错误！！！");
		}finally{
			stmt.close();
		}
		return avgscore;
		
	}
	public void AddOCredit(String sid,double ocredit)throws Exception{
		String sql="UPDATE student set ocredit="+ocredit+" WHERE sid='"+sid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("添加中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
	public void AddEgrade(String sid,double egrade,double acredit)throws Exception{
		String sql="UPDATE student set egrade="+egrade+",acredit="+acredit+" WHERE sid='"+sid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("添加中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
	public Vector SelectClass()throws Exception{
		Vector all=new Vector();
		String sql="SELECT DISTINCT sclass FROM student";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String smajor=rs.getString("sclass");
				all.addElement(smajor);
			}
			rs.close();
			dbc.close();
		}catch(Exception e){
			throw new Exception("查询中出现错误！！！");
		}finally{
			stmt.close();
		}
		return all;
		
	}
	public void AddRank(String sid,int classpm,int majorpm,int con)throws Exception{
		String sql=null;
		if(con==1){
			sql="UPDATE student set majorpm="+majorpm+" WHERE sid='"+sid+"';";
		}else{
			sql="UPDATE student set classpm="+classpm+" WHERE sid='"+sid+"';";
		}
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("添加中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
	public double CountStudent() throws Exception{
		double snum=0;
		String sql="SELECT COUNT(sid) FROM student;";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				snum=rs.getDouble("COUNT(sid)");
			}
			rs.close();
			stmt.close();
			
		}catch (Exception e){e.printStackTrace();
			throw new Exception("查询中出现错误！！！");
		}finally{
			dbc.close();
		}
		return snum;
	}
	public double Countteacher() throws Exception{
		double snum=0;
		String sql="SELECT COUNT(tid) FROM teacher;";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				snum=rs.getDouble("COUNT(tid)");
			}
			rs.close();
			dbc.close();
		}catch (Exception e){e.printStackTrace();
			throw new Exception("查询中出现错误！！！");
		}finally{
			stmt.close();
		}
		return snum;
	}
	public double CountCourse() throws Exception{
		double snum=0;
		String sql="SELECT COUNT(cno) FROM course;";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				snum=rs.getDouble("COUNT(cno)");
			}
			rs.close();
			dbc.close();
		}catch (Exception e){
			throw new Exception("查询中出现错误！！！");
		}finally{
			stmt.close();
		}
		return snum;
	}

}
