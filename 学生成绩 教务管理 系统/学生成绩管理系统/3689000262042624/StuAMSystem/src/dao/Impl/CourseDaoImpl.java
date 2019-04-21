package dao.Impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.PageBean;
import dao.CourseDao;
import db.DBCon;

public class CourseDaoImpl implements CourseDao {

	private DBCon dbCon = new DBCon();
	private Course course;
	private PageBean pageBean;

	public int addCos(Course course, String courseDate) {
		System.out.println(courseDate);
		// Date courseDate=(Date) course.getCourseDate();
		// DateFormat
		// data=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
		String sql = "insert into course(course_name,course_credit,course_hours,course_teacher,coursedate) values('"
				+ course.getCourseName()
				+ "',"
				+ course.getCourseCredit()
				+ ","
				+ course.getCourseHours()
				+ ",'"
				+ course.getCourseTeacher() + "',DATE('" + courseDate + "'))";
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteCos(int courseID) {
		String sql = "delete from course where course_id=" + courseID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editCos(Course course, String courseDate) {
		String sql = "update course set course_name='" + course.getCourseName()
				+ "',course_credit=" + course.getCourseCredit()
				+ ",course_hours=" + course.getCourseHours()
				+ ",course_teacher='" + course.getCourseTeacher()
				+ "',coursedate=DATE('" + courseDate + "') where course_id="
				+ course.getCourseID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int courseID = rs.getInt("course_id");
				String courseName = rs.getString("course_name");
				int courseCredit = rs.getInt("course_credit");
				int courseHours = rs.getInt("course_hours");
				String courseTea = rs.getString("course_teacher");
				Date courseDate = rs.getDate("coursedate");
				course = new Course(courseID, courseName, courseCredit,
						courseHours, courseTea, courseDate);
				list.add(course);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(int courseID) {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course where course_id=" + courseID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int courseid = rs.getInt("course_id");
				String courseName = rs.getString("course_name");
				int courseCredit = rs.getInt("course_credit");
				int courseHours = rs.getInt("course_hours");
				String courseTea = rs.getString("course_teacher");
				Date courseDate = rs.getDate("coursedate");
				course = new Course(courseid, courseName, courseCredit,
						courseHours, courseTea, courseDate);
				list.add(course);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public Course selectOneCos(Course cours) {
		String sql = "select * from course where course_name='"
				+ cours.getCourseName() + "' and course_teacher='"
				+ cours.getCourseTeacher() + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int courseid = rs.getInt("course_id");
				String courseName = rs.getString("course_name");
				int courseCredit = rs.getInt("course_credit");
				int courseHours = rs.getInt("course_hours");
				String courseTea = rs.getString("course_teacher");
				Date courseDate = rs.getDate("coursedate");
				course = new Course(courseid, courseName, courseCredit,
						courseHours, courseTea, courseDate);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return course;
	}

	public PageBean courseListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from course";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int courseID = rs.getInt("course_id");
				String courseName = rs.getString("course_name");
				int courseCredit = rs.getInt("course_credit");
				int courseHours = rs.getInt("course_hours");
				String courseTea = rs.getString("course_teacher");
				Date courseDate = rs.getDate("coursedate");
				course = new Course(courseID, courseName, courseCredit,
						courseHours, courseTea, courseDate);
				list.add(course);
			}
			rs=dbCon.find(sqlCount);
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
			pageBean=new PageBean(list,totalCount,pageNo,pageCount);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return pageBean;
	}

}
