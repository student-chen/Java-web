package com.sevenEleven.javaBean.exam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sevenEleven.Beans.CchooseTestBean;
import com.sevenEleven.Beans.CtextTestBean;
import com.sevenEleven.javaBean.CDBConnection;

public class CTakeExam extends CDBConnection {

	@SuppressWarnings("unused")
	private String id;

	@SuppressWarnings("unused")
	private String countOfChoose1;

	@SuppressWarnings("unused")
	private String countOfChoose2;

	@SuppressWarnings("unused")
	private String countOfText;

	@SuppressWarnings("unchecked")
	public List makeCompulsoryTestPaper(String id, String countOfChoose1,
			String countOfChoose2, String countOfText) {
		int i; // iΪlist���index
		List list = new ArrayList();
		// id = "1003";

		try {
			sql = "select top " + countOfChoose1 + "* from choose1 where l1_id=" + id + "and ch_type =1";
			if (con == null) {
				DBConn(); 
			}
			rs = executeQuery(sql);
			for (i = 0; rs.next(); i++) {
				CchooseTestBean choose = new CchooseTestBean();
				choose.setCh_id(Integer.toString(rs.getInt("CH_ID")));
				choose.setL_id(rs.getInt("L1_ID"));
				choose.setCh_question(rs.getString("CH_QUESTION"));
				choose.setKeya(rs.getString("KEYA"));
				choose.setKeyb(rs.getString("KEYB"));
				choose.setKeyc(rs.getString("KEYC"));
				choose.setKeyd(rs.getString("KEYD"));
				choose.setAnswer(rs.getString("CH_ANSWER"));
				choose.setType(rs.getInt("CH_TYPE"));
				list.add(i, choose);
			
			}
			this.dropConnection();
			sql =  "select top " + countOfChoose2 + "* from choose1 where l1_id=" + id + "and ch_type =2";

			if (con == null) {
				DBConn();
			}
			rs = executeQuery(sql);

			for (i = 0 + Integer.parseInt(countOfChoose1); rs.next(); i++) {
				CchooseTestBean choose = new CchooseTestBean();
				choose.setCh_id(Integer.toString(rs.getInt("CH_ID")));
				choose.setL_id(rs.getInt("L1_ID"));
				choose.setCh_question(rs.getString("CH_QUESTION"));
				choose.setKeya(rs.getString("KEYA"));
				choose.setKeyb(rs.getString("KEYB"));
				choose.setKeyc(rs.getString("KEYC"));
				choose.setKeyd(rs.getString("KEYD"));
				choose.setAnswer(rs.getString("CH_ANSWER"));
				choose.setType(rs.getInt("CH_TYPE"));
				list.add(i, choose);
			}
			this.dropConnection();
			sql =  "select top " + countOfText + "* from text1 where l1_id=" + id ;

			if (con == null) {
				DBConn(); 
			}
			rs = executeQuery(sql);

			for (i = 0 + Integer.parseInt(countOfChoose1)
					+ Integer.parseInt(countOfChoose2); rs.next(); i++) {
				CtextTestBean text = new CtextTestBean();
				text.setText_id(Integer.toString(rs.getInt("TEXT_ID")));
				text.setL_id(rs.getInt("L1_ID"));
				text.setText_question(rs.getString("TEXT_QUESTION"));
				text.setText_answer(rs.getString("TEXT_ANSWER"));
				list.add(i, text);
			}
			this.dropConnection();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List makeElectiveTestPaper(String id, String countOfChoose1,
			String countOfChoose2, String countOfText) {
		int i; 
		List list = new ArrayList();
		try {
			sql =  "select top " + countOfChoose1 + "* from choose2 where l2_id=" + id + "and ch_type =1";
			if (con == null) {
				DBConn(); 
			}
			rs = executeQuery(sql);
			for (i = 0; rs.next(); i++) {
				CchooseTestBean choose = new CchooseTestBean();
				choose.setCh_id(Integer.toString(rs.getInt("CH_ID")));
				choose.setL_id(rs.getInt("L2_ID"));
				choose.setCh_question(rs.getString("CH_QUESTION"));
				choose.setKeya(rs.getString("KEYA"));
				choose.setKeyb(rs.getString("KEYB"));
				choose.setKeyc(rs.getString("KEYC"));
				choose.setKeyd(rs.getString("KEYD"));
				choose.setAnswer(rs.getString("CH_ANSWER"));
				choose.setType(rs.getInt("CH_TYPE"));
				list.add(i, choose);
			}
			this.dropConnection();
			sql =  "select top " + countOfChoose2 + "* from choose2 where l2_id=" + id + "and ch_type =2";
			if (con == null) {
				DBConn(); 
			}
			rs = executeQuery(sql);
			for (i = 0 + Integer.parseInt(countOfChoose1); rs.next(); i++) {
				CchooseTestBean choose = new CchooseTestBean();
				choose.setCh_id(Integer.toString(rs.getInt("CH_ID")));
				choose.setL_id(rs.getInt("L2_ID"));
				choose.setCh_question(rs.getString("CH_QUESTION"));
				choose.setKeya(rs.getString("KEYA"));
				choose.setKeyb(rs.getString("KEYB"));
				choose.setKeyc(rs.getString("KEYC"));
				choose.setKeyd(rs.getString("KEYD"));
				choose.setAnswer(rs.getString("CH_ANSWER"));
				choose.setType(rs.getInt("CH_TYPE"));
				list.add(i, choose);
			}
			this.dropConnection();
			sql = "select top " + countOfText + "* from text2 where l2_id=" + id ;
			if (con == null) {
				DBConn(); 
			}
			rs = executeQuery(sql);
			for (i = 0 + Integer.parseInt(countOfChoose1)
					+ Integer.parseInt(countOfChoose2); rs.next(); i++) {
				CtextTestBean text = new CtextTestBean();
				text.setText_id(Integer.toString(rs.getInt("TEXT_ID")));
				text.setL_id(rs.getInt("L2_ID"));
				text.setText_question(rs.getString("TEXT_QUESTION"));
				text.setText_answer(rs.getString("TEXT_ANSWER"));
				list.add(i, text);
			}
			this.dropConnection();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List getStudentComperationCourse(String ClassId , String studentId) {
		List list = new ArrayList();
		try {
			sql = "select distinct l1.l1_name as courseName,l1.l1_id as courseId from lesson1  l1,lesson1_list  l1_list where(l1.l1_id= l1_list.l1_id and l1_list.c_id = "
					+ ClassId + " )"
					+ "and l1.l1_id not in (select l1_id from result1 where s_id ="
					+ studentId + " )";
			if (con == null) {
				DBConn(); 
			}
			rs = executeQuery(sql);
			while (rs.next()) {
				List listColumn = new ArrayList();
				listColumn.add(rs.getString("courseId"));
				listColumn.add(rs.getString("courseName"));
				boolean add = list.add(listColumn);
				if (!add) {
					return null;
				} else {
					continue;
				}
			}
			this.dropConnection();
			return list;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return null;

	}
	@SuppressWarnings("unchecked")
	public List getStudentElectiveCourse(String studentId) {
		List list = new ArrayList();
		try {
			sql = "select distinct l2.l2_name as courseName,l2.l2_id as courseId from lesson2  l2,s_list_after_l2 l2_list where(l2.l2_id = l2_list.l2_id and l2_list.s_id = "
					+ studentId + " )"
			+ "and l2.l2_id not in (select l2_id from result2 where s_id ="
			+ studentId + " )";
			if (con == null) {
				DBConn();
			}
			rs = executeQuery(sql);
			while (rs.next()) {
				List listColumn = new ArrayList();
				listColumn.add(rs.getString("courseId"));
				listColumn.add(rs.getString("courseName"));
				boolean add = list.add(listColumn);
				if (!add) {
					return null;
				} else {
					continue;
				}
			}
			this.dropConnection();
			return list;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return null;

	}
	public String getStudentClass(String classId) {
		String myClass = null;
		try {
			sql = "select c_name as name from class where c_id = " + classId;
			if (con == null) {
				DBConn(); 
			}
			rs = this.executeQuery(sql);
			if (!rs.next()) {
				return null;
			} else {
				myClass = rs.getString("name");
			}
			this.dropConnection();
			return myClass;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			myClass = null;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			myClass = null;
		}
		return myClass;

	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CTakeExam exam = new CTakeExam();
		System.out.print(exam.getStudentClass("30162"));
	}

}
