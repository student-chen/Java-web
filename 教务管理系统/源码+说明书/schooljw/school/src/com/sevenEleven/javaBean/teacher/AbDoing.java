package com.sevenEleven.javaBean.teacher;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sevenEleven.javaBean.teacher.DBO;
import com.sevenEleven.javaBean.teacher.Using;
public class AbDoing implements Doing {
	private Using USE=DBO.DBOUsing();
	public List GetTeacherInfo(String teacherID){
		String strSQL="SELECT * FROM TEACHER WHERE T_ID ='"+teacherID+"'";
			return USE.GetRecord(strSQL);
	}
	
	public String MM(String str){
		return str.replace("'","¡®");
	}
	
	public boolean CheckTeacherLogin(String userID,String userPWD){
		return USE.CheckBool("SELECT T_ID FROM TEACHER WHERE T_NUMBER ='"+MM(userID)+"' AND T_PASSWORD ='"+MM(userPWD)+"'");
	}
	
	public boolean UpdateTeacherInfo(String teacherID,String teacherNAME,String teacherPWD){
		if (USE.ExecuteUpdate("UPDATE TEACHER SET T_NAME ='"+MM(teacherNAME)+"',T_PASSWORD ='"+MM(teacherPWD)+"' WHERE T_ID ='"+MM(teacherID)+"'")==1)
			return true;
		return false;
	}
	
	public List GetMyStudent(String teacherID){
		if (this.IsRequire(teacherID)){
		//	return USE.GetRecord("SELECT C_ID, S_ID,S_NAME FROM STUDENT WHERE C_ID IN (3120,3121,3122) GROUP BY C_ID,S_ID,S_NAME");
			return USE.GetRecord("SELECT S_ID,S_NAME FROM STUDENT WHERE C_ID IN (SELECT C_ID FROM LESSON1_LIST WHERE T_ID = '"+teacherID+"') ORDER BY C_ID");//Ìí¼ÓGROUP BY
		}else{
			return USE.GetRecord("SELECT STUDENT.S_ID,S_NAME FROM S_LIST_AFTER_L2,STUDENT WHERE S_LIST_AFTER_L2.T_ID ='"+MM(teacherID)+"' AND STUDENT.S_ID = S_LIST_AFTER_L2.S_ID");
		}
	}
	
	public void RefuseStudent(String teacherID,String studentID){
		USE.ExecuteUpdate("DELETE FROM S_LIST_AFTER_L2 WHERE T_ID ='"+MM(teacherID)+"' AND S_ID ='"+MM(studentID));
	}
	
	public List GetLesstionTable(String teacherID){
		String strSQL="";
		if (IsRequire(teacherID)){
			strSQL="SELECT B.L1_NAME,C.CR_NAME,A.TIME_ID,D.C_NAME FROM LESSON1_LIST A,LESSON1 B,CLASSROOM C,CLASS D WHERE A.T_ID ='"+teacherID+"' AND B.L1_ID = A.L1_ID AND C.CR_ID = A.CR_ID AND A.C_ID = D.C_ID";
			return USE.GetRecord(strSQL);
		}else{
			strSQL="SELECT B.L2_NAME,C.CR_NAME,A.TIME_ID FROM LESSON2_LIST A,LESSON2 B,CLASSROOM C WHERE A.T_ID ='"+teacherID+"' AND B.L2_ID = A.L2_ID AND C.CR_ID = A.CR_ID";
			return USE.GetRecord(strSQL);
			}
	}
	
	public boolean IsRequire(String teacherID){
		String strSQL="SELECT COUNT(T_SKILL) FROM TEACHER A,LESSON1 B WHERE A.T_ID ='"+MM(teacherID)+"' AND A.T_SKILL = B.L1_NAME";
		ResultSet rs=USE.GetResult(strSQL);
		try {
			rs.next();
			return !rs.getString(1).equals("0");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String GetTeacherID(String teacherNUM){
		ResultSet rs = USE.GetResult("SELECT T_ID FROM TEACHER WHERE T_NUMBER ='"+MM(teacherNUM)+"'");
		try {
			if (rs.next())
				return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} catch (Exception e){
			e.printStackTrace();
			return "";
		}
		return "";
	}
	
	public String GetTeacherName(String teacherID){
		ResultSet rs=USE.GetResult("SELECT T_NAME FROM TEACHER WHERE T_ID ='"+MM(teacherID)+"'");
		try {
			if (rs.next())
				return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} catch (Exception e){
			e.printStackTrace();
			return "";
		}
		return "";
	}
	
	public boolean IsTeacherStu(String teacherID,String studentID){
		ResultSet rs=USE.GetResult("SELECT S_ID FROM STUDENT WHERE C_ID IN (SELECT C_ID FROM LESSON1_LIST A,LESSON2_LIST B WHERE A.T_ID = '"+MM(teacherID)+"' OR B.T_ID ='"+MM(teacherID)+"') AND S_ID ='"+MM(studentID)+"'" );
		try {
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public List GetStuResult(String studentID,String teacherID){
		if (this.IsRequire(MM(teacherID))){
			return USE.GetRecord("SELECT * FROM RESULT1 WHERE S_ID ='"+MM(studentID)+"' AND L1_ID = (SELECT L1_ID FROM LESSON1 WHERE L1_NAME ='"+MM(GetTeacherSkill(MM(teacherID)))+"')");
		}else{
			return USE.GetRecord("SELECT * FROM RESULT2 WHERE S_ID ='"+MM(studentID)+"' AND L2_ID = (SELECT L2_ID FROM LESSON2 WHERE L2_NAME ='"+MM(GetTeacherSkill(MM(teacherID)))+"')");
		}
	}
	
	public String GetTeacherSkill(String teacherID){
		ResultSet rs=USE.GetResult("SELECT T_SKILL FROM TEACHER WHERE T_ID ='"+MM(teacherID)+"'");
		try {
			if (rs.next())
				return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		} catch (Exception e){
			e.printStackTrace();
			return "";
		}
		return "";
	}
	
	public boolean DelStudenFromClass(String studentID){
		USE.ExecuteUpdate("DELETE FROM RESULT2 A WHERE A.S_ID='"+MM(studentID)+"'");
		USE.ExecuteUpdate("DELETE FROM S_LIST_AFTER_L2 WHERE S_ID ='"+MM(studentID)+"'");
			return true;
	}
	
	public boolean AddStudentScore(String teacherID,String studentID,String ScoreAll,String score){
		if (this.IsRequire(MM(teacherID))){
			 USE.ExecuteUpdate("UPDATE RESULT1 SET D_MARK ='"+MM(score)+"' WHERE S_ID ='"+MM(studentID)+"' AND L1_ID= (SELECT L1_ID FROM LESSON1 WHERE L1_NAME ='"+GetTeacherSkill(MM(teacherID))+"')");
			return USE.ExecuteUpdate("UPDATE RESULT1 SET R_MARK ='"+MM(ScoreAll)+"' WHERE S_ID='" + MM(studentID)+"' AND L1_ID= (SELECT L1_ID FROM LESSON1 WHERE L1_NAME ='"+GetTeacherSkill(MM(teacherID))+"')")==1?true:false;
		}else{
			 USE.ExecuteUpdate("UPDATE RESULT2 SET D_MARK ='"+MM(score)+"' WHERE S_ID ='"+MM(studentID)+"' AND L2_ID= (SELECT L2_ID FROM LESSON2 WHERE L2_NAME ='"+GetTeacherSkill(MM(teacherID))+"')");
		    return  USE.ExecuteUpdate("UPDATE RESULT2 SET D_MARK ='"+MM(score)+"' WHERE S_ID ='"+MM(studentID)+"' AND L2_ID= (SELECT L2_ID FROM LESSON2 WHERE L2_NAME ='"+GetTeacherSkill(MM(teacherID))+"')")==1?true:false;

		}
	}
	
	public void Close(){
		USE.Close();
	}
}
