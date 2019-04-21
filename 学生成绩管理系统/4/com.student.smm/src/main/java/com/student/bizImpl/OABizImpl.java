package com.student.bizImpl;

import java.util.List;

import com.student.Userdao.OAUserdao;
import com.student.biz.OAUserdaoBiz;
import com.student.pojo.OAClass;
import com.student.pojo.OAStudent;
import com.student.pojo.TeacherOA;
import com.student.pojo.UserLog;
import com.student.pojo.UserOA;

public class OABizImpl implements OAUserdaoBiz {
	private OAUserdao oaUserdao;
	public void setOaUserdao(OAUserdao oaUserdao) {
		this.oaUserdao = oaUserdao;
	}
	//登录
	@Override
	/*public UserOA OaLogin(String username, String password) {
		return this.oaUserdao.OaLogin(username, password);
	}*/
	public UserOA OaLogin(UserOA userOA) {
		return this.oaUserdao.OaLogin(userOA);
	}
	//查询
	@Override
	public List<OAStudent> getSelectMess(String text1, String text2) {
		return this.oaUserdao.getSelectMess(text1, text2);
	}
	//删除
		@Override
		public int deleteStudent(Integer[] id) {
			int num=0;
			for(int i=0; i<id.length;i++){
				num=oaUserdao.deleteStudent(id[i]);
			}
			return num;
		}
		//添加
		@Override
		public int saveStudent(OAStudent oaStudent) {
			return this.oaUserdao.saveStudent(oaStudent);
		}
		//修改传值
		@Override
		public OAStudent getupdate(Integer id) {
			return this.oaUserdao.getupdate(id);
		}
		//删除Student
		@Override
		public int updateStudent(OAStudent id) {
			return this.oaUserdao.updateStudent(id);
		}
		//班级查询
		@Override
		public List<OAClass> ClassSelect(String text3, String text4){
			return this.oaUserdao.ClassSelect(text3, text4);
		} 
	    //班级删除
		@Override
		public int deleteClass(Integer[] id) {
			int num=0;
			for(int i=0; i<id.length;i++){
				num=oaUserdao.deleteClass(id[i]);
			}
			return num;
		}
		//班级添加
		@Override
		public int saveClass(OAClass oaClass) {
			return this.oaUserdao.saveClass(oaClass);
		}
		//修改传值
		@Override
		public OAClass getupdateOAClass(Integer id) {
			return this.oaUserdao.getupdateOAClass(id);
		}
		//班级修改
		@Override
		public int updateClass(OAClass id) {
			return this.oaUserdao.updateClass(id);
		}
		//教室表查询
		@Override
		public List<TeacherOA> TeacherSelect(String text5, String text6) {
			return this.oaUserdao.TeacherSelect(text5, text6);
		}
		@Override
		public int deleteTeacher(Integer[] tid) {
			int num=0;
			for(int i=0; i<tid.length;i++){
				num=oaUserdao.deleteTeacher(tid[i]);
			}
			return num;
		}
		@Override
		public int saveTeacher(TeacherOA teacherOA) {
			return this.oaUserdao.saveTeacher(teacherOA);
		}
		@Override
		public TeacherOA getupdateOATeacher(Integer id) {
			return this.oaUserdao.getupdateOATeacher(id);
		}
		@Override
		public int updateTeacher(TeacherOA id) {
			return this.oaUserdao.updateTeacher(id);
		}
		@Override
		public int UserOAs(UserOA id) {
			return this.oaUserdao.UserOAs(id);
		}
		@Override
		public List<OAStudent> AllclassStudent(String one, String two,Integer id) {
			return this.oaUserdao.AllclassStudent(one, two,id);
		}
		@Override
		public int SavaZhuce(UserOA userOA) {
			// TODO Auto-generated method stub
			return this.oaUserdao.SavaZhuce(userOA);
		}
		@Override
		public List<UserLog> UserLogs(String text7, String text8) {
			// TODO Auto-generated method stub
			return this.oaUserdao.UserLogs(text7, text8);
		}
		@Override
		public List<OAClass> getAllClass() {
			return this.getAllClass();
		}
}
