package msc.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import msc.dbc.DataBaseConnection;
import msc.vo.Course;

public class CourseDAO {
	public void InsertCourse(String cno,String cname,double credit) throws Exception{
		String sql="INSERT INTO course(cno,cname,credit) VALUES('"+cno+"','"+cname+"',"+credit+");";
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
	public void DeletebyID(String cno) throws Exception{
		String sql="DELETE FROM course WHERE cno='"+cno+"';";
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
	public Vector Select(String cno,String cname,double credit)throws Exception{
		Vector all=new Vector();
		String sql1="SELECT * FROM course WHERE ";
		String sql=null;
		if(cno!="")
		{
			sql=sql1+"cno LIKE '%"+cno+"%'";
			if(cname!="")
			{
				sql=sql+"and cname LIKE '%"+cname+"%'";
			}
			if(credit!=0)
			{
				sql=sql+"credit='"+credit+"'";
			}
		}else
		{
			if(cname!="")
			{
				sql=sql1+"cname LIKE '%"+cname+"%'";
				if(credit!=0)
				{
					sql=sql+"and credit='"+credit+"'";
				}
			}else
			{
				if(credit!=0)
				{
					sql=sql1+"credit='"+credit+"'";
				}else
				{
					sql="SELECT * FROM course";
				}
				
			}
		}
		sql=sql+";";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Course cou=new Course();
				cou.setCno(rs.getString("cno"));
				cou.setCname(rs.getString("cname"));
				cou.setCredit(rs.getDouble("credit"));
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
	public void UpdatebyID(String cno,String cname,double credit) throws Exception{
		String sql="UPDATE course set cname='"+cname+"',credit="+credit+"  WHERE cno='"+cno+"';";
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
