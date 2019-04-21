package msc.dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import msc.dbc.DataBaseConnection;
import msc.vo.*;
public class ScDAO {
	public Vector ScSelect(String cno,String cname,double credit,int cteachno,String clocation,String ctime,String tname)throws Exception{
		Vector all=new Vector();
		String sql="SELECT tc.cno, course.cname, course.credit, tc.cteachno, tc.clocation, tc.ctime, tc.cmax, tc.csel, teacher.tname FROM tc,course,teacher where tc.cno=course.cno and tc.tid=teacher.tid";
		if(cno!="")
		{
			sql=sql+" and tc.cno LIKE '%"+cno+"%'";
		}
		if(cname!="")
		{
			sql=sql+" and course.cname LIKE '%"+cname+"%' ";
		}
		if(credit!=0)
		{
			sql=sql+" and course.credit='"+credit+"'";
		}
		if(cteachno!=0)
		{
			sql=sql+" and tc.cteachno='"+cteachno+"' ";
		}
		if(clocation!="")
		{
			sql=sql+" and tc.clocation LIKE '%"+clocation+"%' ";
		}
		if(ctime!="")
		{
			sql=sql+" and tc.ctime LIKE '%"+ctime+"%' ";
		}
		if(tname!="")
		{			
			sql=sql+" and teacher.tname LIKE '%"+tname+"%' ";
		}
		sql=sql+";";
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
				cou.setCteachno(rs.getInt("tc.cteachno"));
				cou.setClocation(rs.getString("tc.clocation"));
				cou.setCtime(rs.getString("tc.clocation"));
				cou.setCtime(rs.getString("tc.ctime"));
				cou.setCmax(rs.getInt("tc.cmax"));
				cou.setCsel(rs.getInt("tc.csel"));
				cou.setTname(rs.getString("teacher.tname"));
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
	public Vector SelectSelf(String sid)throws Exception{
		Vector all=new Vector();
		String sql="SELECT sc.cno, course.cname, sc.credit, tc.cteachno, tc.clocation, tc.ctime, teacher.tname FROM sc,tc,course,teacher where sc.sid='"+sid+"' and sc.cno=course.cno and sc.cno=tc.cno  and sc.tid=tc.tid and tc.tid=teacher.tid;";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Tc cou=new Tc();
				cou.setCno(rs.getString("sc.cno"));
				cou.setCname(rs.getString("course.cname"));
				cou.setCredit(rs.getDouble("sc.credit"));
				cou.setCteachno(rs.getInt("tc.cteachno"));
				cou.setClocation(rs.getString("tc.clocation"));
				cou.setCtime(rs.getString("tc.clocation"));
				cou.setCtime(rs.getString("tc.ctime"));
				cou.setTname(rs.getString("teacher.tname"));
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
	public Vector SelectStudent(String cno,String tid)throws Exception{
		Vector all=new Vector();
		String sql="SELECT sc.sid, student.sname, sc.credit, sc.pscore, sc.lscore,sc.escore FROM sc,student where sc.cno='"+cno+"' and sc.tid='"+tid+"' and sc.sid=student.sid ORDER BY sc.escore DESC;";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Sc cou=new Sc();
				cou.setSid(rs.getString("sc.sid"));
				cou.setSname(rs.getString("student.sname"));
				cou.setCredit(rs.getDouble("sc.credit"));
				cou.setPscore(rs.getDouble("sc.pscore"));
				cou.setLscore(rs.getDouble("sc.lscore"));
				cou.setEscore(rs.getDouble("sc.escore"));
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
	
	public Vector SelectCourse(String sid)throws Exception{
		Vector all=new Vector();
		String sql="SELECT sc.cno,course.cname, sc.tid, sc.credit, sc.pscore, sc.lscore,sc.escore FROM sc,course where sc.sid='"+sid+"' and sc.cno=course.cno;";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		try{
			stmt = dbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Sc cou=new Sc();
				cou.setCno(rs.getString("sc.cno"));
				cou.setCname(rs.getString("course.cname"));
				cou.setTid(rs.getString("sc.tid"));
				cou.setCredit(rs.getDouble("sc.credit"));
				cou.setPscore(rs.getDouble("sc.pscore"));
				cou.setLscore(rs.getDouble("sc.lscore"));
				cou.setEscore(rs.getDouble("sc.escore"));
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
	public void Insert(String sid,String cno,String tid,double credit) throws Exception{
		String sql="INSERT INTO sc(sid,cno,tid,credit) VALUES('"+sid+"','"+cno+"','"+tid+"','"+credit+"');";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
	 
		try{
			stmt=dbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (Exception e){
			throw new Exception(e);
		}finally {
			dbc.close();
			
		}
	}
	public void DeletebyID(String sid,String cno) throws Exception{
		String sql="DELETE FROM sc WHERE sid='"+sid+"' and cno='"+cno+"';";
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
	public void DeletebyTID(String tid) throws Exception{
		String sql="DELETE FROM sc WHERE tid='"+tid+"';";
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
	public void DeletebyTidCno(String tid,String cno) throws Exception{
		String sql="DELETE FROM sc WHERE tid='"+tid+"' and cno='"+cno+"';";
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
	public Score GetMaxMinAvg(String cno,String tid)throws Exception{
		Score sco=new Score();
		String sql="SELECT AVG(escore),MAX(escore),MIN(escore) FROM sc WHERE cno='"+cno+"' and tid='"+tid+"';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				sco.setAvscore(rs.getDouble("AVG(escore)"));
				sco.setMaxscore(rs.getDouble("MAX(escore)"));
				sco.setMinscore(rs.getDouble("MIN(escore)"));
			}
			rs.close();
			stmt.close();
		}catch (Exception e){
			e.getMessage();
		}finally{
			dbc.close();
		}
		return sco;
		
	}
	public void UpdateScore(String sid,String cno,String tid,double pscore,double lscore )throws Exception{
		double escore=pscore*0.3+lscore*0.7;
		double scorejd=calxfjd(escore);
		String sql="UPDATE sc set pscore="+pscore+",lscore="+lscore+",escore="+escore+",scorejd="+scorejd+" WHERE sid='"+sid+"' and cno='"+cno+"' and tid='"+tid+"';";
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
	public boolean Check(String sid,String ctime)throws Exception{
		boolean b = false;
		String sql="SELECT tc.ctime FROM tc,sc WHERE  sc.cno=tc.cno and sc.sid='"+sid+"' and tc.ctime='"+ctime+"';";
		Statement stmt=null;
		DataBaseConnection dbc=null;
		dbc=new DataBaseConnection();
		
		try{
			stmt=dbc.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				b=true;
			}else{
				b=false;
			}
			rs.close();
			stmt.close();
		}catch (Exception e){
			e.getMessage();
		}finally{
			dbc.close();
		}
		return b;
		
	}
	public double calxfjd(double escore){
		double scorejd=0;
		if(escore>=90&&escore<=100){
			scorejd=4.0;
		}else if(escore>=85&&escore<90){
			scorejd=3.7;
		}else if(escore>=82&&escore<85){
			scorejd=3.3;
		}else if(escore>=78&&escore<82){
			scorejd=3.0;
		}else if(escore>=75&&escore<78){
			scorejd=2.7;
		}else if(escore>=72&&escore<75){
			scorejd=2.3;
		}else if(escore>=68&&escore<72){
			scorejd=2.0;
		}else if(escore>=66&&escore<68){
			scorejd=1.7;
		}else if(escore>=64&&escore<66){
			scorejd=1.3;
		}else if(escore>=60&&escore<64){
			scorejd=1.0;
		}else{
			scorejd=0;
		}
		return scorejd;
		
	}

}
