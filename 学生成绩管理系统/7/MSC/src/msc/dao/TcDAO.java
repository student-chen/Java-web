package msc.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import msc.dbc.DataBaseConnection;
import msc.vo.*;
public class TcDAO {
	public void InsertCourse(String tid,String cno,int cteachno,String clocation,String ctime,int cmax) throws Exception{
		String sql="INSERT INTO tc(tid,cno,cteachno,clocation,ctime,cmax,csel,sub) VALUES('"+tid+"','"+cno+"',"+cteachno+",'"+clocation+"','"+ctime+"',"+cmax+",0,0);";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
	 
		try{
			stmt=dbc.getConnection().createStatement();
			System.out.println("&&&&&&&&&&&&&&");
			stmt.executeUpdate(sql);
			System.out.println("********************");
			stmt.close();
		}catch (Exception e){
			throw new Exception("插入中出现错误！！！");
		}finally {
			dbc.close();
			
		}
	}
	public void DeletebyID(String tid,String cno) throws Exception{
		String sql="DELETE FROM tc WHERE tid='"+tid+"' and cno='"+cno+"';";
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
	
	public Vector SelectSelf(String tid,String con)throws Exception{
		Vector all=new Vector();
		String sql="SELECT tc.cno,course.cname,course.credit,tc.cteachno,tc.clocation,tc.ctime,tc.cmax,tc.csel from tc,course where course.cno=tc.cno and tc.tid='"+tid+"' ";
		if(con.equals("1")){
			sql=sql+" and tc.sub!='2';";
		}else if(con.equals("2")){
			sql=sql+" and tc.sub='2';";
		}
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Tc cou=new Tc();
				cou.setCno(rs.getString("tc.cno"));
				cou.setCname(rs.getString("course.cname"));
				cou.setCredit(rs.getDouble("course.credit"));
				cou.setClocation(rs.getString("tc.clocation"));
				cou.setCteachno(rs.getInt("tc.cteachno"));
				cou.setCtime(rs.getString("tc.ctime"));
				cou.setCmax(rs.getInt("tc.cmax"));
				cou.setCsel(rs.getInt("tc.csel"));
				all.addElement(cou);
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
	public Vector SelectScore(String tid)throws Exception{
		Vector all=new Vector();
		String sql="SELECT tc.cno,course.cname,course.credit,tc.csel from tc,course where tc.tid='"+tid+"' and course.cno=tc.cno;";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Tc cou=new Tc();
				cou.setCno(rs.getString("tc.cno"));
				cou.setCname(rs.getString("course.cname"));
				cou.setCredit(rs.getDouble("course.credit"));
				cou.setCsel(rs.getInt("tc.csel"));
				all.addElement(cou);
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
	public String SelectTid(String cno,int cteachno)throws Exception{
		String sql="SELECT tid from tc where cno='"+cno+"' and cteachno="+cteachno+";";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		String tid=null;
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				tid=rs.getString("tid");
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			throw new Exception("查询中出现错误！！！");
		} finally {
			dbc.close();
		}
		return tid;
	}
	public String SelectCtime(String cno,int cteachno)throws Exception{
		String sql="SELECT ctime from tc where cno='"+cno+"' and cteachno="+cteachno+";";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		String tid=null;
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				tid=rs.getString("ctime");
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			throw new Exception("查询中出现错误！！！");
		} finally {
			dbc.close();
		}
		return tid;
	}
	public void AddCsel(String tid,String cno)throws Exception{
		String sql="UPDATE tc set csel=csel+1 WHERE tid='"+tid+"' and cno='"+cno+"';";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("更新出错！！！");
		}finally{
			dbc.close();
		}
	}
	public void DelCsel(String tid,String cno)throws Exception{
		String sql="UPDATE tc set csel=csel-1 WHERE tid='"+tid+"' and cno='"+cno+"';";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("更新出错！！！");
		}finally{
			dbc.close();
		}
	}
	public String SelectSub(String tid,String cno)throws Exception{
		String sub=null;
		String sql="SELECT sub FROM tc WHERE tid='"+tid+"' and cno='"+cno+"'";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=null;
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				sub=rs.getString("sub");
		    	}
			rs.close();
			stmt.close();
		}catch (Exception e){
			throw new Exception("更新出错！！！");
		}finally{
			dbc.close();
		}
		return sub;
	}
	public void UpdateSub(String tid,String cno,String con)throws Exception{
		String sql="UPDATE tc set sub='"+con+"' WHERE tid='"+tid+"' and cno='"+cno+"';";
		Statement stmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception("更新出错！！！");
		}finally{
			dbc.close();
		}
	}

}
