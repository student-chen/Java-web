package com.sevenEleven.javaBean.exam;

import java.util.ArrayList;
import java.util.List;


import com.sevenEleven.Beans.CchooseTestBean;
import com.sevenEleven.Beans.CtextTestBean;
import com.sevenEleven.javaBean.CDBConnection;

/**
 * @author Tim 
 * 关于老师对试题表的操作Bean
 */

public class Cexam extends CDBConnection {
	@SuppressWarnings("unchecked")
	/**
	 * @author Tim Something about exam find the teacher who came into this
	 *         system and his's course and make view in the page of
	 *         teacher\exam_addTest.jsp
	 */
	private String id;

	private String countOfChoose1;

	private String countOfChoose2;

	private String countOfText;

	public List findLesson1(String teacherNumber) { // 由老师找必修课
		if (!checkParameter(teacherNumber)) {
			teacherNumber = "null";
		}
		try {
			sql = "select distinct  a.T_SKILL  \"course\" from teacher a, lesson1 b where a.T_SKILL = b.L1_Name and a.T_number ="
					+ " '" + teacherNumber + "' ";
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			List list = new ArrayList();
			for (int i = 0; rs.next(); i++) {
				// rs.getCursorName().length();
				list.add(i, rs.getString("course"));
			}
			this.dropConnection();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @author Tim Something about exam find the teacher who came into this
	 * system and his's course and make view in the page of
	 * teacher\exam_addTest.jsp
	 */
	@SuppressWarnings("unchecked")
	public List findLesson2(String teacherNumber) { // 由老师找选修课
		if (!checkParameter(teacherNumber)) {
			teacherNumber = "null";
		}
		try {
			// Clesson1Bean lesson2 = null;
			sql = "select distinct  a.T_SKILL  \"course\" from teacher a, lesson2 b where a.T_SKILL = b.L2_Name and a.T_number ="
					+ " '" + teacherNumber + "' ";
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			List list = new ArrayList();
			for (int i = 0; rs.next(); i++) {
				// rs.getCursorName().length();
				list.add(i, rs.getString("course"));
			}
			this.dropConnection();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @author tim insert infomation of one test to the Table "Choose1"
	 * 
	 */
	public boolean insertIntoChoose1Table(CchooseTestBean test) {
		try {
			sql = "insert into choose1 values ("// + test.getCh_id() + ", "
					+ test.getL_id() + ", " + " '" + test.getCh_question()
					+ "' , '" + test.getKeya() + "' , '" + test.getKeyb()
					+ "' , '" + test.getKeyc() + "' , '" + test.getKeyd()
					+ "' , '" + test.getAnswer() + "' , " + test.getType()
					+ ") ";

			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author tim update infomation of one test to the Table "Choose1"
	 * 
	 */
	public boolean updateChoose1Table(CchooseTestBean choose) {
		try {

			sql = "update choose1 set CH_QUESTION= '" + choose.getCh_question()
					+ "' ," + "KEYA= '" + choose.getKeya() + "' ," + "KEYB= '"
					+ choose.getKeyb() + "' ," + "KEYC= '" + choose.getKeyc()
					+ "' ," + "KEYD= '" + choose.getKeyd() + "' ,"
					+ "CH_ANSWER= '" + choose.getAnswer() + "' "
					+ " WHERE CH_ID=" + choose.getCh_id();
			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author tim insert infomation of one test to the Table "Choose2" by the
	 * attribute of courseType
	 */
	public boolean insertIntoChoose2Table(CchooseTestBean test) {
		try {
			sql = "insert into choose2 values (" //+ test.getCh_id() + ", "
					+ test.getL_id() + ", " + " '" + test.getCh_question()
					+ "' , '" + test.getKeya() + "' , '" + test.getKeyb()
					+ "' , '" + test.getKeyc() + "' , '" + test.getKeyd()
					+ "' , '" + test.getAnswer() + "' , " + test.getType()
					+ ") ";

			if (con == null) {
				DBConn(); // 连接
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * @author tim update infomation of one test to the Table "Choose2" by the
	 * attribute of courseType
	 */
	public boolean updateChoose2Table(CchooseTestBean choose) {
		try {
			sql = "update choose2 set CH_QUESTION= '" + choose.getCh_question()
					+ "' ," + "KEYA= '" + choose.getKeya() + "' ," + "KEYB= '"
					+ choose.getKeyb() + "' ," + "KEYC= '" + choose.getKeyc()
					+ "' ," + "KEYD= '" + choose.getKeyd() + "' ,"
					+ "CH_ANSWER= '" + choose.getAnswer() + "' "
					+ " WHERE CH_ID=" + choose.getCh_id();

			if (con == null) {
				DBConn(); // 连接
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @author tim insert infomation of one test to the Table "text1" by the
	 *         attribute of courseType
	 */
	public boolean insertIntoText1Table(CtextTestBean text) {
		try {
			sql = "insert into text1 values ( " //+ text.getText_id() + ", "
					+ text.getL_id() + ", '" + text.getText_question()
					+ "' , '" + text.getText_answer() + "') ";

			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author tim update infomation of one test to the Table "text1" by the
	 * attribute of courseType
	 */
	public boolean updateText1Table(CtextTestBean text) {
		try {
			sql = "update text1 set TEXT_QUESTION= '" + text.getText_question()
					+ "' ," + "TEXT_ANSWER= '" + text.getText_answer() + "' "
					+ " WHERE TEXT_ID=" + text.getText_id();

			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author tim insert infomation of one test to the Table "text2" by the
	 * attribute of courseType
	 */
	public boolean insertIntoText2Table(CtextTestBean text) {
		try {
			sql = "insert into text2 values ( "// + text.getText_id() + ", "
					+ text.getL_id() + ", '" + text.getText_question()
					+ "' , '" + text.getText_answer() + "') ";

			if (con == null) {
				DBConn(); // 连接
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * @author tim update infomation of one test to the Table "text2" by the
	 * attribute of courseType
	 */
	public boolean updateText2Table(CtextTestBean text) {
		try {
			sql = "update text2 set TEXT_QUESTION= '" + text.getText_question()
					+ "' ," + "TEXT_ANSWER= '" + text.getText_answer() + "' "
					+ " WHERE TEXT_ID=" + text.getText_id();

			if (con == null) {
				DBConn(); // 连接
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * @author tim delete a item of this table
	 * 
	 */
	public boolean deleteItemOfChoose1Table(String id) {
		try {
			sql = "delete Choose1 where CH_ID =" + id;

			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author tim delete a item of this table
	 * 
	 */
	public boolean deleteItemOfChoose2Table(String id) {
		try {
			sql = "delete Choose2 where CH_ID =" + id;

			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author tim delete a item of this table
	 * 
	 */
	public boolean deleteItemOfText1Table(String id) {
		try {
			sql = "delete text1 where TEXT_ID =" + id;

			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author tim delete a item of this table
	 * 
	 */
	public boolean deleteItemOfText2Table(String id) {
		try {
			sql = "delete text2 where TEXT_ID =" + id;

			if (con == null) {
				DBConn(); // 连接
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

	/*
	 * @author Tim 由课程名得到对应的课程ID
	 * 
	 */
	// 由lesson1 得到它的id
	public int getLesson1Id(String course) {
		try {
			int id = 0;
			sql = "select distinct L1_ID  from lesson1 where L1_NAME = " + " '"
					+ course + "' ";

			if (con == null) {
				DBConn(); // 连接
			}
			rs = this.executeQuery(sql);

			for (int i = 0; rs.next(); i++) {
				id = rs.getInt("L1_ID");
			}
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	/*
	 * @author Tim 由课程名得到对应的课程ID
	 * 
	 */
	// 由lesson2 得到它的id
	public int getLesson2Id(String course) {
		try {
			int id = 0;
			sql = "select distinct L2_ID  from lesson2 where L2_NAME = " + " '"
					+ course + "' ";

			if (con == null) {
				DBConn(); // 连接
			}
			rs = this.executeQuery(sql);

			for (int i = 0; rs.next(); i++) {
				id = rs.getInt("L2_ID");
			}
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
  
	// 过滤非法字符
	public boolean checkParameter(String para) {
		int flag = 0;
		flag += para.indexOf("'") + 1;
		flag += para.indexOf(";") + 1;
		flag += para.indexOf("=") + 1;
		flag += para.indexOf("|") + 1;
		flag += para.indexOf("<") + 1;
		flag += para.indexOf(">") + 1;
		if (flag != 0) {
			System.out.println("提交了非法字符!!!");
			return false;
		}
		return true;
	}
	/*
	 * @author Tim 得到表Choose1的记录集条数,
	 *  @return 记录集的条数
	 * 
	 */
	public int getLengthOfChoose1Table(){
		int length = 0;
		try{
			sql = "select count(*) from Choose1";
		
		if (con == null) {
			DBConn(); // 连接
		}
		rs = executeQuery(sql);
		while(rs.next()){
		length = rs.getInt(1);
		}
		this.dropConnection();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return length;	
	}
	/*
	 * @author Tim 得到表Choose2的记录集条数,
	 *  @return 记录集的条数
	 * 
	 */
	public int getLengthOfChoose2Table(){
		int length = 0;
		try{
			sql = "select count(*) from Choose2";
		
		if (con == null) {
			DBConn(); // 连接
		}
		rs = executeQuery(sql);
		while(rs.next()){
		length = rs.getInt(1);
		}
		this.dropConnection();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return length;	
	}
	/*
	 * @author Tim 得到表Text1的记录集条数,
	 *  @return 记录集的条数
	 * 
	 */
	public int getLengthOfText1Table(){
		int length = 0;
		try{
			sql = "select count(*) from Text1";
		
		if (con == null) {
			DBConn(); // 连接
		}
		rs = executeQuery(sql);
		while(rs.next()){
		length = rs.getInt(1);
		}
		this.dropConnection();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return length;	
	}
	/*
	 * @author Tim 得到表Text2的记录集条数,
	 *  @return 记录集的条数
	 * 
	 */
	public int getLengthOfText2Table(){
		int length = 0;
		try{
			sql = "select count(*) from Text2";
		
		if (con == null) {
			DBConn(); // 连接
		}
		rs = executeQuery(sql);
		while(rs.next()){
		length = rs.getInt(1);
		}
		this.dropConnection();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return length;	
	}
	/*
	 * @author Tim 得到表Choose1的记录集,取出记录集中的数据从第first条到第last条
	 * 并封装在Bean里，再保存在List表中。
	 * 
	 */
	public List getChoose1Table(int first, int last) {

		try {
			sql = " SELECT TOP 10 * FROM Choose1 WHERE (CH_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " CH_ID FROM Choose1 ORDER BY CH_ID)) ORDER BY CH_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  Choose1 t order by CH_ID) select * from partdata where rowno between "
			//		+ Integer.toString(first) + "and " + Integer.toString(last);
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			List list = new ArrayList();
			for (int i = 0; rs.next(); i++) {
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
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @author Tim 由ID号得到表Choose1的一条记录并保存在Bean中。
	 * 
	 */
	public CchooseTestBean getChoose1Table(String id) {
		try {
			sql = "select * from Choose1 where CH_ID =" + id;
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);

			while (rs.next()) {
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
				return choose;
			}

			this.dropConnection();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/*
	 * @author Tim 得到表Choose2的记录集,取出记录集中的数据从第first条到第last条
	 * 并封装在Bean里，再保存在List表中。
	 * 
	 */
	public List getChoose2Table(int first,int last) {

		try {
			sql = " SELECT TOP 10 * FROM Choose2 WHERE (CH_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " CH_ID FROM Choose1 ORDER BY CH_ID)) ORDER BY CH_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  Choose2 t order by CH_ID ) select * from partdata where rowno between "
			//	+ Integer.toString(first) + "and " + Integer.toString(last);
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			List list = new ArrayList();
			for (int i = 0; rs.next(); i++) {
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
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @author Tim 由ID号得到表Choose2的一条记录并保存在Bean中。
	 * 
	 */
	public CchooseTestBean getChoose2Table(String id) {
		try {
			sql = "select * from Choose2 where CH_ID =" + id;
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);

			while (rs.next()) {
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
				return choose;
			}

			this.dropConnection();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/*
	 * @author Tim 得到表Text1的记录集,取出记录集中的数据从第first条到第last条
	 * 并封装在Bean里，再保存在List表中。
	 * 
	 */
	public List getText1Table(int first,int last) {

		try {
			sql = " SELECT TOP 10 * FROM text1 WHERE (TEXT_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " TEXT_ID FROM text1 ORDER BY TEXT_ID)) ORDER BY TEXT_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  text1 t order by TEXT_ID) select * from partdata where rowno between "
				//+ Integer.toString(first) + "and " + Integer.toString(last);
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			List list = new ArrayList();
			for (int i = 0; rs.next(); i++) {
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

	/*
	 * @author Tim 由ID号得到表text1的一条记录并保存在Bean中。
	 * 
	 */
	public CtextTestBean getText1Table(String id) {

		try {
			sql = "select * from Text1 where TEXT_ID =" + id;
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			while (rs.next()) {
				CtextTestBean text = new CtextTestBean();
				text.setText_id(Integer.toString(rs.getInt("TEXT_ID")));
				text.setL_id(rs.getInt("L1_ID"));
				text.setText_question(rs.getString("TEXT_QUESTION"));
				text.setText_answer(rs.getString("TEXT_ANSWER"));
				return text;
			}
			this.dropConnection();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/*
	 * @author Tim 得到表Text2的记录集,取出记录集中的数据从第first条到第last条
	 * 并封装在Bean里，再保存在List表中。
	 * 
	 */
	public List getText2Table(int first,int last) {

		try {
			sql = " SELECT TOP 10 * FROM text2 WHERE (TEXT_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " TEXT_ID FROM text2 ORDER BY TEXT_ID)) ORDER BY TEXT_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  text2 t order by TEXT_ID) select * from partdata where rowno between "
			//	+ Integer.toString(first) + "and " + Integer.toString(last);
			
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			List list = new ArrayList();
			for (int i = 0; rs.next(); i++) {
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

	/*
	 * @author Tim 由ID号得到表text2的一条记录并保存在Bean中。
	 * 
	 */
	public CtextTestBean getText2Table(String id) {

		try {
			sql = "select * from Text2 where TEXT_ID =" + id;
			if (con == null) {
				DBConn(); // 连接
			}
			rs = executeQuery(sql);
			while (rs.next()) {
				CtextTestBean text = new CtextTestBean();
				text.setText_id(Integer.toString(rs.getInt("TEXT_ID")));
				text.setL_id(rs.getInt("L2_ID"));
				text.setText_question(rs.getString("TEXT_QUESTION"));
				text.setText_answer(rs.getString("TEXT_ANSWER"));
				return text;
			}
			this.dropConnection();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/*
	 * 
	 * @param id 生成试卷的课程的ID号 @param countOfChoose1 生成试卷的单选题数 @param
	 * countOfChoose2 生成试卷的多选题数 @param countOfText 生成试卷的填空题数 @return List
	 * （单选题数，多选题数，填空题数，（单项选择题），（多项选择题），（填空题））
	 */
//	public List makeCompulsoryTestPaper(String countOfChoose1,
//			String countOfChoose2, String countOfText) {
//		int i; // i为list表的index
//		List list = new ArrayList();
//		id = "1003";
//
//		try {
//			// 提单选题
//			// ///用ＳＱＬ语句从表choose1中取出countOfChoose1个单选题！
//			sql = "select * from (select choose1.*,dbms_random.random num from choose1 order by num) where (ch_type=1 and rownum <= "
//					+ countOfChoose1 + " )";
//
//			if (con == null) {
//				DBConn(); // 连接
//			}
//			rs = executeQuery(sql);
//
//			for (i = 0; rs.next(); i++) {
//				CchooseTestBean choose = new CchooseTestBean();
//				choose.setCh_id(Integer.toString(rs.getInt("CH_ID")));
//				choose.setL_id(rs.getInt("L1_ID"));
//				choose.setCh_question(rs.getString("CH_QUESTION"));
//				choose.setKeya(rs.getString("KEYA"));
//				choose.setKeyb(rs.getString("KEYB"));
//				choose.setKeyc(rs.getString("KEYC"));
//				choose.setKeyd(rs.getString("KEYD"));
//				choose.setAnswer(rs.getString("CH_ANSWER"));
//				choose.setType(rs.getInt("CH_TYPE"));
//				list.add(i, choose);
//			}
//			this.dropConnection();
//
//			// 提多选题
//			// ///用ＳＱＬ语句从表choose1中取出countOfChoose1个单选题！
//			sql = "select * from (select choose1.*,dbms_random.random num from choose1 order by num) where (ch_type=2 and rownum <= "
//					+ countOfChoose2 + " )";
//
//			if (con == null) {
//				DBConn(); // 连接
//			}
//			rs = executeQuery(sql);
//
//			for (i = 0 + Integer.parseInt(countOfChoose1); rs.next(); i++) {
//				CchooseTestBean choose = new CchooseTestBean();
//				choose.setCh_id(Integer.toString(rs.getInt("CH_ID")));
//				choose.setL_id(rs.getInt("L1_ID"));
//				choose.setCh_question(rs.getString("CH_QUESTION"));
//				choose.setKeya(rs.getString("KEYA"));
//				choose.setKeyb(rs.getString("KEYB"));
//				choose.setKeyc(rs.getString("KEYC"));
//				choose.setKeyd(rs.getString("KEYD"));
//				choose.setAnswer(rs.getString("CH_ANSWER"));
//				choose.setType(rs.getInt("CH_TYPE"));
//				list.add(i, choose);
//			}
//			this.dropConnection();
//			// 提填空题
//			sql = "select * from (select text1.*,dbms_random.random num from text1 order by num) where  rownum <= "
//					+ countOfText;
//
//			if (con == null) {
//				DBConn(); // 连接
//			}
//			rs = executeQuery(sql);
//
//			for (i = 0 + Integer.parseInt(countOfChoose1)
//					+ Integer.parseInt(countOfChoose2); rs.next(); i++) {
//				CtextTestBean text = new CtextTestBean();
//				text.setText_id(Integer.toString(rs.getInt("TEXT_ID")));
//				text.setL_id(rs.getInt("L1_ID"));
//				text.setText_question(rs.getString("TEXT_QUESTION"));
//				text.setText_answer(rs.getString("TEXT_ANSWER"));
//				list.add(i, text);
//			}
//			this.dropConnection();
//			return list;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	public String getCountOfChoose1() {
		return countOfChoose1;
	}

	public void setCountOfChoose1(String countOfChoose1) {
		this.countOfChoose1 = countOfChoose1;
	}

	public String getCountOfChoose2() {
		return countOfChoose2;
	}

	public void setCountOfChoose2(String countOfChoose2) {
		this.countOfChoose2 = countOfChoose2;
	}

	public String getCountOfText() {
		return countOfText;
	}

	public void setCountOfText(String countOfText) {
		this.countOfText = countOfText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
