package com.sevenEleven.javaBean.exam;

import java.util.ArrayList;
import java.util.List;

import com.sevenEleven.Beans.CchooseTestBean;
import com.sevenEleven.Beans.CtextTestBean;
import com.sevenEleven.javaBean.CDBConnection;



public class Cexam extends CDBConnection {
	private String id;

	private String countOfChoose1;

	private String countOfChoose2;

	private String countOfText;

	@SuppressWarnings("unchecked")
	public List findLesson1(String teacherNumber) { // ����ʦ�ұ��޿�
		if (!checkParameter(teacherNumber)) {
			teacherNumber = "null";
		}
		try {
			sql = "select distinct  a.T_SKILL  \"course\" from teacher a, lesson1 b where a.T_SKILL = b.L1_Name and a.T_number ="
					+ " '" + teacherNumber + "' ";
			if (con == null) {
				DBConn(); // ����
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
	public List findLesson2(String teacherNumber) { // ����ʦ��ѡ�޿�
		if (!checkParameter(teacherNumber)) {
			teacherNumber = "null";
		}
		try {
			// Clesson1Bean lesson2 = null;
			sql = "select distinct  a.T_SKILL  \"course\" from teacher a, lesson2 b where a.T_SKILL = b.L2_Name and a.T_number ="
					+ " '" + teacherNumber + "' ";
			if (con == null) {
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
				DBConn(); // ����
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
	 * @author Tim �ɿγ���õ���Ӧ�Ŀγ�ID
	 * 
	 */
	// ��lesson1 �õ����id
	public int getLesson1Id(String course) {
		try {
			int id = 0;
			sql = "select distinct L1_ID  from lesson1 where L1_NAME = " + " '"
					+ course + "' ";

			if (con == null) {
				DBConn(); // ����
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
	 * @author Tim �ɿγ���õ���Ӧ�Ŀγ�ID
	 * 
	 */
	// ��lesson2 �õ����id
	public int getLesson2Id(String course) {
		try {
			int id = 0;
			sql = "select distinct L2_ID  from lesson2 where L2_NAME = " + " '"
					+ course + "' ";

			if (con == null) {
				DBConn(); // ����
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
  
	// ���˷Ƿ��ַ�
	public boolean checkParameter(String para) {
		int flag = 0;
		flag += para.indexOf("'") + 1;
		flag += para.indexOf(";") + 1;
		flag += para.indexOf("=") + 1;
		flag += para.indexOf("|") + 1;
		flag += para.indexOf("<") + 1;
		flag += para.indexOf(">") + 1;
		if (flag != 0) {
			System.out.println("�ύ�˷Ƿ��ַ�!!!");
			return false;
		}
		return true;
	}
	/*
	 * @author Tim �õ���Choose1�ļ�¼������,
	 *  @return ��¼��������
	 * 
	 */
	public int getLengthOfChoose1Table(){
		int length = 0;
		try{
			sql = "select count(*) from Choose1";
		
		if (con == null) {
			DBConn(); // ����
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
	 * @author Tim �õ���Choose2�ļ�¼������,
	 *  @return ��¼��������
	 * 
	 */
	public int getLengthOfChoose2Table(){
		int length = 0;
		try{
			sql = "select count(*) from Choose2";
		
		if (con == null) {
			DBConn(); // ����
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
	 * @author Tim �õ���Text1�ļ�¼������,
	 *  @return ��¼��������
	 * 
	 */
	public int getLengthOfText1Table(){
		int length = 0;
		try{
			sql = "select count(*) from Text1";
		
		if (con == null) {
			DBConn(); // ����
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
	 * @author Tim �õ���Text2�ļ�¼������,
	 *  @return ��¼��������
	 * 
	 */
	public int getLengthOfText2Table(){
		int length = 0;
		try{
			sql = "select count(*) from Text2";
		
		if (con == null) {
			DBConn(); // ����
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
	
	@SuppressWarnings("unchecked")
	public List getChoose1Table(int first, int last) {

		try {
			sql = " SELECT TOP 10 * FROM Choose1 WHERE (CH_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " CH_ID FROM Choose1 ORDER BY CH_ID)) ORDER BY CH_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  Choose1 t order by CH_ID) select * from partdata where rowno between "
			//		+ Integer.toString(first) + "and " + Integer.toString(last);
			if (con == null) {
				DBConn(); // ����
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
	public CchooseTestBean getChoose1Table(String id) {
		try {
			sql = "select * from Choose1 where CH_ID =" + id;
			if (con == null) {
				DBConn(); 
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
	@SuppressWarnings("unchecked")
	public List getChoose2Table(int first,int last) {

		try {
			sql = " SELECT TOP 10 * FROM Choose2 WHERE (CH_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " CH_ID FROM Choose1 ORDER BY CH_ID)) ORDER BY CH_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  Choose2 t order by CH_ID ) select * from partdata where rowno between "
			//	+ Integer.toString(first) + "and " + Integer.toString(last);
			if (con == null) {
				DBConn(); // ����
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


	public CchooseTestBean getChoose2Table(String id) {
		try {
			sql = "select * from Choose2 where CH_ID =" + id;
			if (con == null) {
				DBConn();
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
	@SuppressWarnings("unchecked")
	public List getText1Table(int first,int last) {

		try {
			sql = " SELECT TOP 10 * FROM text1 WHERE (TEXT_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " TEXT_ID FROM text1 ORDER BY TEXT_ID)) ORDER BY TEXT_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  text1 t order by TEXT_ID) select * from partdata where rowno between "
				//+ Integer.toString(first) + "and " + Integer.toString(last);
			if (con == null) {
				DBConn(); // ����
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
	public CtextTestBean getText1Table(String id) {

		try {
			sql = "select * from Text1 where TEXT_ID =" + id;
			if (con == null) {
				DBConn(); 
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
	@SuppressWarnings("unchecked")
	public List getText2Table(int first,int last) {

		try {
			sql = " SELECT TOP 10 * FROM text2 WHERE (TEXT_ID NOT IN (SELECT TOP " + Integer.toString(first-1) + " TEXT_ID FROM text2 ORDER BY TEXT_ID)) ORDER BY TEXT_ID";
			//sql = "with partdata as (select rownum rowno,t.* from  text2 t order by TEXT_ID) select * from partdata where rowno between "
			//	+ Integer.toString(first) + "and " + Integer.toString(last);
			
			if (con == null) {
				DBConn(); // ����
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
	public CtextTestBean getText2Table(String id) {

		try {
			sql = "select * from Text2 where TEXT_ID =" + id;
			if (con == null) {
				DBConn(); 
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
