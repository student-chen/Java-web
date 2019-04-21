package com.sevenEleven.javaBean.teacher;
import java.util.List;
public interface Doing {
	public List GetTeacherInfo(String teacherID);
	public String GetTeacherName(String teacherID);
	public String GetTeacherID(String teacherNUM);
	public String GetTeacherSkill(String teacherID);
	public boolean CheckTeacherLogin(String userID,String userPWD);
	public boolean UpdateTeacherInfo(String teacherID,String teacherNAME,String teacherPWD);
	public String MM(String str);
	public List GetMyStudent(String teacherID);
	public void RefuseStudent(String teacherID,String studentID);
	public List GetLesstionTable(String teacherID);
	public boolean IsRequire(String teacherID);
	public boolean IsTeacherStu(String teacherID,String studentID);
	public List GetStuResult(String studentID,String teacherID);
	public boolean DelStudenFromClass(String studentID);
	public boolean AddStudentScore(String teacherID,String studentID,String Scored,String score);
	public void Close();
}
