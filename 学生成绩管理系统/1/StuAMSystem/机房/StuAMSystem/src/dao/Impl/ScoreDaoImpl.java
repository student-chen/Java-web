package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.PageBean;
import model.Score;
import model.ScoreCou;
import model.ScoreSum;
import dao.ScoreDao;
import db.DBCon;

public class ScoreDaoImpl implements ScoreDao {

	private Score score = null;
	private ScoreCou scoreCou = null;
	private PageBean pageBean = null;
	private ScoreSum scoreSum = null;

	private DBCon dbCon = new DBCon();

	public int addScore(Score score) {
		String sql = "insert into score(stu_num,stu_name,stu_class,course_name,score_grade,major) values('"
				+ score.getStuNum()
				+ "','"
				+ score.getStuName()
				+ "','"
				+ score.getStuClass()
				+ "','"
				+ score.getCourseName()
				+ "',"
				+ score.getScoreGrade() + ",'" + score.getMajor() + "')";
		int rs = dbCon.query(sql);
		return rs;
	}

	public int deleteScore(int scoreID) {
		String sql = "delete from score where score_id=" + scoreID;
		int rs = dbCon.query(sql);
		return rs;
	}

	public int editCos(Score score) {
		String sql = "update score set stu_num='" + score.getStuNum()
				+ "',stu_name='" + score.getStuName() + "',stu_class='"
				+ score.getStuClass() + "',course_name='"
				+ score.getCourseName() + "',score_grade="
				+ score.getScoreGrade() + ",major='" + score.getMajor()
				+ "' where score_id=" + score.getScoreID();
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int scoreID = rs.getInt("score_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuClass = rs.getString("stu_class");
				String courseName = rs.getString("course_name");
				double scoreGrade = rs.getDouble("score_grade");
				String major = rs.getString("major");
				Score score = new Score(scoreID, stuNum, stuName, stuClass,
						courseName, scoreGrade, major);
				list.add(score);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List findOne(String stuNum) {
		List<ScoreCou> list = new ArrayList<ScoreCou>();
		String sql = "select score.course_name,course_credit,course_hours,course_teacher,major,coursedate,score_grade "
				+ "from score,course where score.course_name=course.course_name and stu_num='"
				+ stuNum + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {

				String courseName = rs.getString("course_name");
				int courseCredit = rs.getInt("course_credit");
				int courseHours = rs.getInt("course_hours");
				String courseTea = rs.getString("course_teacher");
				String major = rs.getString("major");
				Date courseDate = rs.getDate("coursedate");
				double scoreGrade = rs.getDouble("score_grade");

				ScoreCou scoreCou = new ScoreCou(courseName, courseCredit,
						courseHours, courseTea, major, courseDate, scoreGrade);
				list.add(scoreCou);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List selectScore(int scoreID) {
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score where score_id=" + scoreID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int scoreid = rs.getInt("score_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuClass = rs.getString("stu_class");
				String courseName = rs.getString("course_name");
				double scoreGrade = rs.getDouble("score_grade");
				String major = rs.getString("major");
				Score score = new Score(scoreid, stuNum, stuName, stuClass,
						courseName, scoreGrade, major);
				list.add(score);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public Score selectScoreInfo(Score scor) {
		String sql = "select * from score where stu_num='" + scor.getStuNum()
				+ "' and course_name='" + scor.getCourseName() + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int scoreid = rs.getInt("score_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuClass = rs.getString("stu_class");
				String courseName = rs.getString("course_name");
				double scoreGrade = rs.getDouble("score_grade");
				String major = rs.getString("major");
				score = new Score(scoreid, stuNum, stuName, stuClass,
						courseName, scoreGrade, major);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return score;
	}

	public PageBean scoreListPage(int pageNo, int pageCount, String stuNum) {
		int totalCount = 0;
		List<ScoreCou> list = new ArrayList<ScoreCou>();
		String sql = "select score.course_name,course_credit,course_hours,course_teacher,major,coursedate,score_grade "
				+ "from score,course where score.course_name=course.course_name and stu_num='"
				+ stuNum
				+ "' limit "
				+ ((pageNo - 1) * pageCount)
				+ ","
				+ pageCount;
		String sqlCount = "select count(*) from score,course where score.course_name=course.course_name and stu_num='"
				+ stuNum + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {

				String courseName = rs.getString("course_name");
				int courseCredit = rs.getInt("course_credit");
				int courseHours = rs.getInt("course_hours");
				String courseTea = rs.getString("course_teacher");
				String major = rs.getString("major");
				Date courseDate = rs.getDate("coursedate");
				double scoreGrade = rs.getDouble("score_grade");

				ScoreCou scoreCou = new ScoreCou(courseName, courseCredit,
						courseHours, courseTea, major, courseDate, scoreGrade);
				list.add(scoreCou);
			}
			rs = dbCon.find(sqlCount);
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}

			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		return pageBean;
	}

	public PageBean scoreListPage(int pageNo, int pageCount) {
		int totalCount = 0;
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score limit " + ((pageNo - 1) * pageCount)
				+ "," + pageCount;
		String sqlCount = "select count(*) from score";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int scoreID = rs.getInt("score_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuClass = rs.getString("stu_class");
				String courseName = rs.getString("course_name");
				double scoreGrade = rs.getDouble("score_grade");
				String major = rs.getString("major");
				score = new Score(scoreID, stuNum, stuName, stuClass,
						courseName, scoreGrade, major);
				list.add(score);
			}
			rs = dbCon.find(sqlCount);
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}

			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		return pageBean;
	}

	public List findStuOne(String stuNum, String courseName) {
		List<ScoreCou> list = new ArrayList<ScoreCou>();
		String sql = "select score.course_name,course_credit,course_hours,course_teacher,major,coursedate,score_grade "
				+ "from score,course where score.course_name=course.course_name and stu_num='"
				+ stuNum + "' and course.course_name='" + courseName + "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {

				String coursename = rs.getString("course_name");
				int courseCredit = rs.getInt("course_credit");
				int courseHours = rs.getInt("course_hours");
				String courseTea = rs.getString("course_teacher");
				String major = rs.getString("major");
				Date courseDate = rs.getDate("coursedate");
				double scoreGrade = rs.getDouble("score_grade");

				scoreCou = new ScoreCou(coursename, courseCredit, courseHours,
						courseTea, major, courseDate, scoreGrade);
				list.add(scoreCou);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public PageBean selectScoreSum(int pageNo, int pageCount) {
		int totalCount = 0;
		int i = 1;
		List<ScoreSum> list = new ArrayList<ScoreSum>();
		String sql = "select score.stu_num,score.stu_name,score.stu_class,score.major, sum(score.score_grade) as total,avg(score.score_grade) as avg "
				+ "from score group by score.stu_num order by total DESC limit "
				+ ((pageNo - 1) * pageCount) + "," + pageCount;
		String sqlCount = "select count(*) from (select stu_num from score group by score.stu_num ) as a";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int number = i;
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuClass = rs.getString("stu_class");
				String major = rs.getString("major");
				double total = rs.getDouble("total");
				double avg = rs.getDouble("avg");
				scoreSum = new ScoreSum(number, stuNum, stuName, stuClass,
						major, total, avg);
				list.add(scoreSum);
				i++;
			}
			rs = dbCon.find(sqlCount);
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}
			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		return pageBean;
	}

	public PageBean selectStuScore(int pageNo, int pageCount, Score score) {
		int totalCount = 0;
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score where stu_num like '%"
				+ score.getStuNum() + "%' and course_name like '%"
				+ score.getCourseName() + "%' and stu_name like '%"
				+ score.getStuName() + "%' and stu_class like '%"
				+ score.getStuClass() + "%' and major like '%"
				+ score.getMajor() + "%' limit " + ((pageNo - 1) * pageCount)
				+ "," + pageCount;
		String sqlCount = "select count(*) from score where stu_num like '%"
				+ score.getStuNum() + "%' and course_name like '%"
				+ score.getCourseName() + "%' and stu_name like '%"
				+ score.getStuName() + "%' and stu_class like '%"
				+ score.getStuClass() + "%' and major like '%"
				+ score.getMajor() + "%'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int scoreID = rs.getInt("score_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuClass = rs.getString("stu_class");
				String courseName = rs.getString("course_name");
				double scoreGrade = rs.getDouble("score_grade");
				String major = rs.getString("major");
				score = new Score(scoreID, stuNum, stuName, stuClass,
						courseName, scoreGrade, major);
				list.add(score);
			}
			rs = dbCon.find(sqlCount);
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}

			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		return pageBean;
	}

	public PageBean selectTeaScore(int pageNo, int pageCount, String teaName,
			Score score) {
		int totalCount = 0;
		List<Score> list = new ArrayList<Score>();
		String sql = "select score.score_id,score.stu_num,score.stu_name,score.stu_class,score.course_name,score.score_grade,score.major from score,course where score.course_name=course.course_name and course.course_teacher='"
				+ teaName
				+ "'  and score.stu_name like '%"
				+ score.getStuName()
				+ "%' and score.stu_class like '%"
				+ score.getStuClass()
				+ "%' and score.stu_num like '%"
				+ score.getStuNum()
				+ "%' limit "
				+ ((pageNo - 1) * pageCount)
				+ "," + pageCount;
		String sqlCount = "select count(*) from score,course where score.course_name=course.course_name and course.course_teacher='"
				+ teaName 
				+ "'  and score.stu_name like '%"
				+ score.getStuName()
				+ "%' and score.stu_class like '%"
				+ score.getStuClass()
				+ "%' and score.stu_num like '%"
				+ score.getStuNum()
				+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int scoreID = rs.getInt("score_id");
				String stuNum = rs.getString("stu_num");
				String stuName = rs.getString("stu_name");
				String stuClass = rs.getString("stu_class");
				String courseName = rs.getString("course_name");
				double scoreGrade = rs.getDouble("score_grade");
				String major = rs.getString("major");
				score = new Score(scoreID, stuNum, stuName, stuClass,
						courseName, scoreGrade, major);
				list.add(score);
			}
			rs = dbCon.find(sqlCount);
			while (rs.next()) {
				totalCount = rs.getInt(1);
			}

			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			dbCon.close();
			e.printStackTrace();
		}
		return pageBean;
	}

}
