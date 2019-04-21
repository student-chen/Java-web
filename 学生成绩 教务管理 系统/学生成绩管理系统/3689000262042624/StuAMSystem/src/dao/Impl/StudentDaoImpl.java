package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.PageBean;
import model.Student;
import dao.StudentDao;
import db.DBCon;

public class StudentDaoImpl implements StudentDao {

	private DBCon dbCon = new DBCon();
	private Student student;
	private PageBean pageBean;

	public int addStu(Student student) {
		String sql = "insert into student(stu_num,stu_name,stu_sex,stu_age,stu_class,major,department) values('"
				+ student.getStuNum()
				+ "','"
				+ student.getStuName()
				+ "','"
				+ student.getStuSex()
				+ "',"
				+ student.getStuAge()
				+ ",'"
				+ student.getStuClass()
				+ "','"
				+ student.getMajor()
				+ "','"
				+ student.getDepartment() + "')";
		int rs = dbCon.query(sql);

		return rs;
	}

	public int deleteStu(String stuNum) {
		String sql = "delete from student where stu_num='" + stuNum + "'";
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editStu(Student student) {
		String sql = "update student set stu_name='" + student.getStuName()
				+ "',stu_sex='" + student.getStuSex() + "',stu_age="
				+ student.getStuAge() + ",stu_class='" + student.getStuClass()
				+ "',major='" + student.getMajor() + "',department='"
				+ student.getDepartment() + "' where stu_num='"
				+ student.getStuNum() + "'";
		int rs=dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int stuID = rs.getInt("stu_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuSex = rs.getString("stu_sex");
				int stuAge = rs.getInt("stu_age");
				String stuClass = rs.getString("stu_class");
				String major = rs.getString("major");
				String department = rs.getString("department");
				student = new Student(stuID, stuNum, stuName, stuSex, stuAge,
						stuClass, major, department);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List findOne(String stuNum) {
		List<Student> list = new ArrayList<Student>();
		String sql="select * from student where stu_num='"+stuNum+"'";
		ResultSet rs=dbCon.find(sql);
		try {
			while(rs.next()){
				int stuID = rs.getInt("stu_id");
				String stunum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuSex = rs.getString("stu_sex");
				int stuAge = rs.getInt("stu_age");
				String stuClass = rs.getString("stu_class");
				String major = rs.getString("major");
				String department = rs.getString("department");
				student = new Student(stuID, stunum, stuName, stuSex, stuAge,
						stuClass, major, department);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//pageNo当前页码，pageCount每页显示总条数
	public PageBean stuListPage(int pageNo, int pageCount) {
		int totalCount=0;
		List<Student> list = new ArrayList<Student>();
		String sql="select * from student limit "+((pageNo-1)*pageCount)+","+pageCount;
		String sqlCount="select count(*) from student";
		
		try {
			ResultSet rs=dbCon.find(sql);
			while(rs.next()){
				int stuID = rs.getInt("stu_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuSex = rs.getString("stu_sex");
				int stuAge = rs.getInt("stu_age");
				String stuClass = rs.getString("stu_class");
				String major = rs.getString("major");
				String department = rs.getString("department");
				student = new Student(stuID, stuNum, stuName, stuSex, stuAge,
						stuClass, major, department);
				list.add(student);
			}
			rs=dbCon.find(sqlCount);
			while(rs.next()){
				totalCount=rs.getInt(1); 
			}
			pageBean=new PageBean(list ,  totalCount,  pageNo,  pageCount);
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		return pageBean;
	}

}
