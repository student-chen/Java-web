package com.sevenEleven.javaBean.student;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.sevenEleven.Beans.CstudentBean;

public class CUsMethod {
	CMethod method = null;

	public CUsMethod() {
		method = new CMethod();
	}

	private ResultSet result;

	public boolean Update(String userid, String password) {
		int source;
		String sql = "UPDATE STUDENT SET S_PASSWORD='" + password
				+ "' WHERE S_NUMBER='" + userid + "'";
		try {
			source = method.Update(sql);
			while (source != 0) {
				return true;
			}
			method.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean checkl1_l2(Object userid) {
		String sql = "select l1_name from checkl1l2 where s_number='" + userid
				+ "'";
		result = method.query(sql);
		try {
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean login(String userid, String password) {
		String sql = "SELECT S_NUMBER,S_PASSWORD FROM STUDENT where S_NUMBER='"
				+ userid + "' and S_PASSWORD='" + password + "'";

		result = method.query(sql);
		try {
			while (result.next()) {

				return true;

			}
			method.closeConn();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public void PersonalL2Info(Object sid, Object crid, Object tid,
			Object l2id, Object timeid) {
		String sql = "insert into s_list_after_l2 values('" + sid + "','"
				+ crid + "','" + tid + "','" + l2id + "','" + timeid + "')";
		try {
			method.Update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CstudentBean getinformation(Object userid) {
		String sql = "SELECT  * from stu_cla where  S_NUMBER='" + userid + "'";
		result = method.query(sql);
		CstudentBean student = new CstudentBean();
		try {
			while (result.next()) {
				student.setS_id(result.getLong("S_ID"));// S_ID
				student.setC_id(result.getLong("C_ID"));
				student.setS_name(result.getString("S_NAME"));// 姓名
				student.setS_number(result.getString("S_NUMBER"));// 用户名
				student.setS_password(result.getString("S_PASSWORD"));// 密码
				student.setC_name(result.getString("C_NAME"));// 班机名
				student.setC_type(result.getString("C_TYPE"));// 班级类型;
			}
			method.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student; // String sql="select
	}

	public List getNestedListFromResultSet(Object uid) {
		String sql = "select * from stu_cla where S_NUMBER='" + uid + "'";
		result = method.query(sql);

		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
			method.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public List getL2Id() {

		String sql = "select l2_id from lesson2_list ";
		result = method.query(sql);
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public int JudgePersonalL2(Object l2id, Object snumber) {
		String sql = "select * from personall2info where s_number='" + snumber
				+ "' and l2_id='" + l2id + "'";
		result = method.query(sql);
		try {
			if (result.next()) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;

	}

	public int judgeAmount(Object snumber) {
		int i = 0;

		String sql = "select count(*) from personall2info where s_number='"
				+ snumber + "'";
		result = method.query(sql);

		try {
			while (result.next()) {
				i = result.getInt(1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List getLesson1Info(Object cid) {
		String sql = "select lesson_lis.C_ID,class.C_NAME,lesson_lis.L1_ID,lesson1.L1_NAME,lesson_lis.T_ID,teacher.T_NAME,classroom.CR_NAME,lesson_lis.TIME_ID from (select * from lesson1_list where  C_ID='"
				+ cid
				+ "') lesson_lis,class,teacher,lesson1,classroom where (lesson_lis.C_ID = class.C_ID and lesson_lis.T_ID = teacher.T_ID and lesson_lis.CR_ID = classroom.CR_ID and lesson_lis.L1_ID = lesson1.L1_ID)";
		result = method.query(sql);
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public List getResult1(Object s_id) {
		String sql = "select student.S_NAME,lesson1.L1_NAME,result1.R_MARK from result1,student,lesson1 where result1.S_ID='" + s_id + "' and result1.S_ID = student.S_ID and result1.L1_ID = lesson1.L1_ID";
		result = method.query(sql);
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public List getResult2(Object s_id) {
		String sql = "select student.S_NAME,lesson2.L2_NAME,result2.R_MARK from result2,student,lesson2 where result2.S_ID='" + s_id + "' and result2.S_ID = student.S_ID and result2.L2_ID = lesson2.L2_ID";
		result = method.query(sql);
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public List getPersonall2Id(Object l2Id) {
		String sql = "select * from lesson2_list where L2_ID='" + l2Id + "'";
		result = method.query(sql);
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {

					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public List getLesson2Info() {
		String sql = "select lesson_lis.L2_ID,lesson2.L2_NAME,lesson_lis.T_ID,teacher.T_NAME,classroom.CR_NAME,lesson_lis.TIME_ID,lesson2.L2_NEED_ID,lesson1.L1_NAME from (select * from lesson2_list ) lesson_lis,teacher,lesson2,lesson1,classroom where ( lesson_lis.T_ID = teacher.T_ID and lesson_lis.CR_ID = classroom.CR_ID and lesson_lis.L2_ID = lesson2.L2_ID and lesson2.L2_NEED_ID = lesson1.L1_ID)";
		result = method.query(sql);
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {

					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public List GetPersonalL2Info(Object snumber) {
		String sql = "select s.S_ID,s.S_NAME,l2.L2_ID,l2.L2_NAME,t.T_ID,t.T_NAME,c.CR_NAME,lesson2_after_list.TIME_ID from (select * from s_list_after_l2 where s_id= (select S_ID from student where S_NUMBER = '" + snumber + "')) lesson2_after_list,student s,teacher t,lesson2 l2,classroom c where (lesson2_after_list.S_ID = s.S_ID and lesson2_after_list.CR_ID = c.CR_ID and lesson2_after_list.T_ID = t.T_ID and lesson2_after_list.L2_ID = l2.L2_ID) ";
		result = method.query(sql);
		List listColumn = null;
		List listRow = new LinkedList();
		try {
			while (result.next()) {
				listColumn = new LinkedList();
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					listColumn.add(result.getString(i));
				}
				listRow.add(listColumn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRow;
	}

	public ResultSet result() {
		return result;
	}

}
