package com.sevenEleven.javaBean.teacher;
import java.util.List;
public interface Doing {
	@SuppressWarnings("unchecked")
	public List GetTeacherInfo(String teacherID);
	public String GetTeacherName(String teacherID);
	public String GetTeacherID(String teacherNUM);
	public String GetTeacherSkill(String teacherID);
	public boolean CheckTeacherLogin(String userID,String userPWD);
	public boolean UpdateTeacherInfo(String teacherID,String teacherNAME,String teacherPWD);
	public String MM(String str);
	@SuppressWarnings("unchecked")
	public List GetMyStudent(String teacherID);
	public void RefuseStudent(String teacherID,String studentID);
	@SuppressWarnings("unchecked")
	public List GetLesstionTable(String teacherID);
	public boolean IsRequire(String teacherID);
	public boolean IsTeacherStu(String teacherID,String studentID);
	@SuppressWarnings("unchecked")
	public List GetStuResult(String studentID,String teacherID);
	public boolean DelStudenFromClass(String studentID);
	public boolean AddStudentScore(String teacherID,String studentID,String Scored,String score);
	public void Close();
}
