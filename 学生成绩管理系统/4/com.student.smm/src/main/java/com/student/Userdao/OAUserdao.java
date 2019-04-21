package com.student.Userdao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.student.pojo.OAClass;
import com.student.pojo.OAStudent;
import com.student.pojo.TeacherOA;
import com.student.pojo.UserLog;
import com.student.pojo.UserOA;
public interface OAUserdao {
	//OA页面登录
	/*public UserOA OaLogin(@Param("username")String username,@Param("password")String password);*/
	public UserOA OaLogin(UserOA userOA);
	//Student信息查询
	public List<OAStudent> getSelectMess(@Param("text1")String text1,@Param("text2")String text2);
	//Student信息删除
	int deleteStudent(@Param("id")Integer id);
	//Student信息添加
	int saveStudent(OAStudent oaStudent);
	//修改传值
    public OAStudent getupdate(@Param("id")Integer id);
    //修改Student
    int updateStudent(OAStudent id);
    //Class班级查询
  	public List<OAClass> ClassSelect(@Param("text3")String text3,@Param("text4")String text4);
    //Class班级删除
  	int deleteClass(@Param("id")Integer id);
  	//Class班级添加
  	int saveClass(OAClass oaClass);
  	//Class班级修改传值
    public OAClass getupdateOAClass(@Param("id")Integer id);
    //Class班级修改
    int updateClass(OAClass id);
    //教师表查询
    public List<TeacherOA> TeacherSelect(@Param("text5")String text5,@Param("text6")String text6);
    //教师表删除
    int deleteTeacher(@Param("tid")Integer tid);
    //教师表添加
  	int saveTeacher(TeacherOA teacherOA);
  	//教师表修改传值
    public TeacherOA getupdateOATeacher(@Param("id")Integer id);
    //教师表修改
    int updateTeacher(TeacherOA id);
    //密码修改
    int UserOAs(UserOA id);
    //用户注册
    int SavaZhuce(UserOA userOA);
    //日志查询
    public List<UserLog> UserLogs(@Param("text7")String text7,@Param("text8")String text8);
    //按班级查询所有学生
    public List<OAStudent> AllclassStudent(@Param("textone")String one,@Param("texttwo")String two,@Param("id")Integer id);
    //下拉框班级查询
    List<OAClass> getAllClass();
}
