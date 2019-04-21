package com.sevenEleven.javaBean.admin_test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sevenEleven.Beans.CclassBean;
import com.sevenEleven.Beans.Clesson1Bean;
import com.sevenEleven.javaBean.CDBConnection;

public class CmakeTeacherAndCourseTogether extends CDBConnection {

	@SuppressWarnings("unchecked")
	public List getAllClassIdAndClassName() throws SQLException {
		List classList = new ArrayList();
		try {
			sql = "select c_id as id, c_name as name,c_type as type from class ";
			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);
			while (rs.next()) {
				CclassBean myClass = new CclassBean();
				myClass.setId(rs.getLong("id"));
				myClass.setName(rs.getString("name"));
				myClass.setType(rs.getString("type"));
				classList.add(myClass);
			}
			dropConnection();
			return classList;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			classList = null;
		}
		return classList;
	}

	public boolean isExistInTable(String className, String phase) {
		try {
			sql = " select count(*) from lesson1_list where c_id =(select c_id from class where c_name ='"
					+ className + "') and time_id like '" + phase + "%'";
			if (con == null) {
				DBConn(); 
			}
			rs = executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					this.dropConnection();
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public List getAllLesson1Name() throws SQLException {
		List lesson1List = new ArrayList();
		try {
			sql = "select l1_id as id,l1_name as name from lesson1";
			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);
			while (rs.next()) {
				Clesson1Bean lesson1 = new Clesson1Bean();
				lesson1.setLessonId(rs.getInt("id"));
				lesson1.setLessonName(rs.getString("name"));
				lesson1List.add(lesson1);
			}
			dropConnection();
			return lesson1List;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			lesson1List = null;
		}
		return lesson1List;
	}
	@SuppressWarnings("unchecked")
	public List getTeacherAndLesson1ForClass(String className, String phase)
			throws SQLException {
		List t_l_c = new ArrayList();
		try {
			sql = " select tl1.t_l1_c_id ,teacher.t_name ,lesson1.l1_name ,  class.c_name from (select t_l1_c_id,t_id,l1_id,c_id  from teacherandlesson1forclass where c_id = ( select c_id from class  where c_name = '"
			+ className + "')) tl1,lesson1,teacher,class where((tl1.t_id=teacher.t_id) and (tl1.l1_id = lesson1.l1_id)and (tl1.c_id = class.c_id))";
			System.out.print(sql);
			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);
			while (rs.next()) {
				List rowList = new ArrayList();
				rowList.add(0, rs.getInt("id"));
				rowList.add(1, rs.getString("t_name"));
				rowList.add(2, rs.getString("l1_name"));
				rowList.add(3, rs.getString("c_name"));
				t_l_c.add(rowList);
			}
			dropConnection();
			return t_l_c;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			t_l_c = null;
		}
		return t_l_c;
	}
	@SuppressWarnings("unchecked")
	public List getAllCompulsoryTeacherIdAndName(String t_skill)
			throws SQLException {
		List teacherList = new ArrayList();
		try {
			sql = " select  t_id as id,t_name as name from teacher where t_skill = '"
					+ t_skill + "'";
			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);
			while (rs.next()) {
				String teacher = new String();
				teacher = rs.getString("name");
				teacherList.add(teacher);
			}
			dropConnection();
			return teacherList;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();

		}
		return teacherList;
	}
	public boolean insertIntoTableTeacherAndLesson1ForClass(String t_id,
			String l1_id, String c_id, String phase) {
		try {
			sql = "insert into teacherAndLesson1ForClass values(seq_teacherAndCourse_p.nextval, "
					+ t_id
					+ ", "
					+ l1_id
					+ ", "
					+ c_id
					+ ", "
					+ "'"
					+ phase
					+ "'" + " )";

			if (con == null) {
				DBConn(); 
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public String getLesson1IdFromLesson1Name(String lesson1Name)
			throws SQLException {
		String lessonId = null;
		try {

			sql = "select distinct l1_id as id from lesson1 where l1_name = '"
					+ lesson1Name + "' ";
			if (con == null) {
				DBConn();
			}
			rs = this.executeQuery(sql);
			if (rs.next()) {
				lessonId = String.valueOf(rs.getInt("id"));
			}
			dropConnection();
			return lessonId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lessonId;

	}
	public String getClassIdFromClassName(String className) throws SQLException {
		String classId = null;
		try {

			sql = "select distinct c_id as id from class where c_name = '"
					+ className + "' ";
			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);

			if (rs.next()) {
				classId = String.valueOf(rs.getInt("id"));
			}
			dropConnection();
			return classId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classId;

	}
	public String getTeacherIdFromTeacherName(String t_name)
			throws SQLException {
		String t_id = null;
		try {

			sql = "select distinct t_id as id from teacher where t_name = '"
					+ t_name + "' ";
			if (con == null) {
				DBConn();
			}
			rs = this.executeQuery(sql);
			if (rs.next()) {
				t_id = String.valueOf(rs.getInt("id"));
			}
			dropConnection();
			return t_id;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return t_id;

	}
	public boolean deleteTableTeacherAndLesson1ForClass(String id) {
		try {
			sql = "delete teacherAndLesson1ForClass where T_L1_C_ID =" + id;
			if (con == null) {
				DBConn();
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public boolean checkTableTeacherAndLesson1ForClass(String c_id,
			String l1_id, String t_id) {

		try {
			sql = "select count(*) from teacherAndLesson1ForClass where (((c_id ="
					+ c_id
					+ ")and(l1_id ="
					+ l1_id
					+ ")) OR ((t_id ="
					+ t_id
					+ ")and(c_id =" + c_id + ")))";

			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt(1) > 0) {
					return true;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public List getTeacherAndLesson1ToListForClass(String className,
			String phase, String time) throws SQLException {
		List t_l_c = new ArrayList();
		try {
			sql = " select t_id,l1_id from teacherandlesson1forclass where t_id not in(select t_id from lesson1_list where time_id = '"
					+ time
					+ "' ) and c_id = (select c_id from class where c_name = '"
					+ className
					+ "' and phase = '"
					+ phase
					+ "')";
			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);
			while (rs.next()) {
				CteacherAndLesson1ForClass t_l = new CteacherAndLesson1ForClass();
				t_l.setL1_id(rs.getInt("l1_id"));
				t_l.setTeacherId(rs.getInt("t_id"));
				t_l_c.add(t_l);
			}
			dropConnection();
			return t_l_c;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			t_l_c = null;
		}
		return t_l_c;
	}

	public static void main(String[] args) {
		CmakeTeacherAndCourseTogether xx = new CmakeTeacherAndCourseTogether();
		xx.isExistInTable("3120", "A");
	}
	@SuppressWarnings("unchecked")
	public List getAllClassroomWhichCanUsered(String time) {
		List classRoomList = new ArrayList();
		try {
			sql = "select cr_id as classroom_id from classroom where cr_id not in (select cr_id from lesson1_list where time_id = '"
					+ time + "' )";
			if (con == null) {
				DBConn();
			}
			rs = this.executeQuery(sql);
			while (rs.next()) {
              classRoomList.add(rs.getString("classroom_id"));
			}
			dropConnection();
			return classRoomList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
