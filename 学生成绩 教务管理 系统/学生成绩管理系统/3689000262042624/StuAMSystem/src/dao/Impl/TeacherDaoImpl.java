package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PageBean;
import model.Student;
import model.Teacher;
import dao.TeacherDao;
import db.DBCon;

public class TeacherDaoImpl implements TeacherDao{
	
	private DBCon dbCon = new DBCon();
	private Teacher teacher;
	private PageBean pageBean;

	public int addTea(Teacher teacher) {
		String sql = "insert into teacher(tea_num,tea_name,tea_sex,tea_age,tea_course,major,department) values('"
				+ teacher.getTeaNum()
				+ "','"
				+ teacher.getTeaName()
				+ "','"
				+ teacher.getTeaSex()
				+ "',"
				+ teacher.getTeaAge()
				+ ",'"
				+ teacher.getTeaCourse()
				+ "','"
				+ teacher.getMajor()
				+ "','"
				+ teacher.getDepartment() + "')";
		int rs = dbCon.query(sql);

		return rs;
	}

	public int deleteTea(String teaNum) {
		String sql = "delete from teacher where tea_num='" + teaNum + "'";
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editTea(Teacher teacher) {
		String sql = "update teacher set tea_name='" + teacher.getTeaName()
				+ "',tea_sex='" + teacher.getTeaSex() + "',tea_age="
				+ teacher.getTeaAge() + ",tea_course='" + teacher.getTeaCourse()
				+ "',major='" + teacher.getMajor() + "',department='"
				+ teacher.getDepartment() + "' where tea_num='"
				+ teacher.getTeaNum() + "'";
		int rs=dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<Teacher> list=new ArrayList<Teacher>();
		String sql="select * from teacher";
		ResultSet rs=dbCon.find(sql);
		try {
			while (rs.next()) {
				int teaID = rs.getInt("tea_id");
				String teaNum = rs.getString("tea_num");
				String teaName = rs.getString("tea_name");
				String teaSex = rs.getString("tea_sex");
				int teaAge = rs.getInt("tea_age");
				String teaCourse = rs.getString("tea_course");
				String major = rs.getString("major");
				String department = rs.getString("department");
				teacher = new Teacher(teaID, teaNum, teaName, teaSex, teaAge,
						teaCourse, major, department);
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List findOne(String teaNum) {
		List<Teacher> list=new ArrayList<Teacher>();
		String sql="select * from teacher where tea_num='"+teaNum+"'";
		ResultSet rs=dbCon.find(sql);
		try {
			while (rs.next()) {
				int teaID = rs.getInt("tea_id");
				String teanum = rs.getString("tea_num");
				String teaName = rs.getString("tea_name");
				String teaSex = rs.getString("tea_sex");
				int teaAge = rs.getInt("tea_age");
				String teaCourse = rs.getString("tea_course");
				String major = rs.getString("major");
				String department = rs.getString("department");
				teacher = new Teacher(teaID, teanum, teaName, teaSex, teaAge,
						teaCourse, major, department);
				list.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public PageBean teaListPage(int pageNo, int pageCount) {
		List<Teacher> list=new ArrayList<Teacher>();
		int totalCount=0;
		String sql="select * from teacher limit "+((pageNo-1)*totalCount)+","+totalCount;
		String sqlCount="select count(*) from teacher";
		ResultSet rs=dbCon.find(sql);
		try {
			while(rs.next()){
				int teaID = rs.getInt("tea_id");
				String teanum = rs.getString("tea_num");
				String teaName = rs.getString("tea_name");
				String teaSex = rs.getString("tea_sex");
				int teaAge = rs.getInt("tea_age");
				String teaCourse = rs.getString("tea_course");
				String major = rs.getString("major");
				String department = rs.getString("department");
				teacher = new Teacher(teaID, teanum, teaName, teaSex, teaAge,
						teaCourse, major, department);
				list.add(teacher);
			}
			rs=dbCon.find(sqlCount);
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		pageBean=new PageBean(list,totalCount,pageNo,pageCount);
		return pageBean;
	}

}
