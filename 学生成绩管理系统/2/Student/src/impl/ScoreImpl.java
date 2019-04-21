package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.IScore;
import entity.Score;

public class ScoreImpl implements IScore {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public void add(Score score) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("INSERT INTO score (sco_daily,sco_exam,sco_count,stu_id,sub_id,cla2sub_id,cla_id) VALUES (?,?,?,?,?,?,?)");
			pst.setDouble(1, score.getDaily());
			pst.setDouble(2, score.getExam());
			pst.setDouble(3, score.getDaily() + score.getExam());
			pst.setInt(4, score.getStudent().getId());
			pst.setInt(5, score.getSubject().getId());
			pst.setInt(6, score.getCla2sub().getId());
			pst.setInt(7, score.getCla2sub().getClasses().getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DB.close(conn, pst, rs);
		}
	}

	public void delete(Score score) {
		try {
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM score WHERE sco_id = ?");
			pst.setInt(1, score.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void update(Score score) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("UPDATE score SET sco_daily = ?,sco_exam = ?,sco_count = ? WHERE sco_id = ?");
			pst.setDouble(1, score.getDaily());
			pst.setDouble(2, score.getExam());
			pst.setDouble(3, score.getCount());
			pst.setInt(4, score.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public List<Score> query(String type, String value) {
		ArrayList<Score> list = new ArrayList<Score>();
		try {
			conn = DB.getConn();
			if (type.equals("sco_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE sco_id = ? order by sco_id");
				pst.setString(1, value);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? order by sco_id");
				pst.setString(1, value);
			} else if (type.equals("stu_no")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE stu_no = ?) order by sco_id");
				pst.setString(1, value);
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE stu_name LIKE ?) order by sco_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE sub_id IN (SELECT sub_id FROM `subject` WHERE sub_name LIKE ?) order by sco_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?)) order by sco_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE sub_id = ? order by sco_id");
				pst.setString(1, value);
			} else if (type.equals("stu_sub_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? AND sub_id IN(SELECT sub_id FROM `subject` WHERE sub_name like ?) order by sco_id");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("stu_tec_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? AND cla2sub_id IN(SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name Like ?)) order by sco_id");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("stu_all")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? order by sco_id");
				pst.setString(1, value);
			}

			// 班主任查找本班同学成绩
			else if (type.equals("cla_tec_stu_all")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))order by sco_id";
				pst = conn.prepareStatement(sql);
				pst.setString(1, value);
			} else if (type.equals("tec_stu_all")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?)) order by sco_id";
				pst = conn.prepareStatement(sql);
				pst.setString(1, value);
				pst.setString(2, value);
			} else if (type.equals("tec_stu_no")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_no = ?)OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE stu_no = ?)order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_name = ?)OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE stu_name= ?)order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			} else if (type.equals("tec_sub_name")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))AND sub_id IN (SELECT sub_id FROM subject WHERE sub_name =?) OR (cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND sub_id IN(";
				sql += "SELECT sub_id FROM subject WHERE sub_name= ?))order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			} else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))AND cla_id IN (SELECT cla_id FROM classes WHERE cla_name =?) OR (cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_name= ?))order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM score order by sco_id");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Score score = new Score();
				score.setId(rs.getInt(1));
				score.setDaily(rs.getDouble(2));
				score.setExam(rs.getDouble(3));
				score.setCount(rs.getDouble(4));
				score.setStudent(new StudentImpl().query("stu_id",
						rs.getString(5)).get(0));
				score.setSubject(new SubjectImpl().query("sub_id",
						rs.getString(6)).get(0));
				list.add(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Score> query(String type, String value, int currentPage) {
		currentPage = (currentPage - 1) * 10;
		ArrayList<Score> list = new ArrayList<Score>();
		try {
			conn = DB.getConn();
			if (type.equals("sco_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE sco_id = ? order by sco_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? order by sco_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_no")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE stu_no = ?) order by sco_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE stu_name LIKE ?) order by sco_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE sub_id IN (SELECT sub_id FROM `subject` WHERE sub_name LIKE ?) order by sco_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?)) order by sco_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE sub_id = ? order by sco_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);

			} else if (type.equals("stu_sub_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? AND sub_id IN(SELECT sub_id FROM `subject` WHERE sub_name like ?) order by sco_id limit ?,10");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setInt(3, currentPage);
			} else if (type.equals("stu_tec_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? AND cla2sub_id IN(SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name Like ?)) order by sco_id limit ?,10");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setInt(3, currentPage);
			} else if (type.equals("stu_all")) {
				pst = conn
						.prepareStatement("SELECT * FROM score WHERE stu_id = ? order by sco_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("tec_stu_all")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?)) order by sco_id limit ?,10";
				pst = conn.prepareStatement(sql);
				pst.setString(1, value);
				pst.setString(2, value);
				pst.setInt(3, currentPage);
			} else if (type.equals("tec_stu_no")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_no = ?)OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE stu_no = ?)order by sco_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
				pst.setInt(5, currentPage);
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_name = ?)OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE stu_name= ?)order by sco_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
				pst.setInt(5, currentPage);
			}

			else if (type.equals("tec_sub_name")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))AND sub_id IN (SELECT sub_id FROM subject WHERE sub_name =?) OR (cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND sub_id IN(";
				sql += "SELECT sub_id FROM subject WHERE sub_name= ?))order by sco_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
				pst.setInt(5, currentPage);
			}

			else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT * FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))AND cla_id IN (SELECT cla_id FROM classes WHERE cla_name =?) OR (cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_name= ?))order by sco_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
				pst.setInt(5, currentPage);

			} else {
				pst = conn
						.prepareStatement("SELECT * FROM score order by sco_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Score score = new Score();
				score.setId(rs.getInt(1));
				score.setDaily(rs.getDouble(2));
				score.setExam(rs.getDouble(3));
				score.setCount(rs.getDouble(4));
				score.setStudent(new StudentImpl().query("stu_id",
						rs.getString(5)).get(0));
				score.setSubject(new SubjectImpl().query("sub_id",
						rs.getString(6)).get(0));
				list.add(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public int getCountPage(String type, String value) {
		int countPages = 0;
		try {
			conn = DB.getConn();
			if (type.equals("sco_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE sco_id = ?");
				pst.setString(1, value);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE stu_id = ?");
				pst.setString(1, value);
			} else if (type.equals("stu_no")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE stu_no = ?)");
				pst.setString(1, value);
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE stu_name LIKE ?)");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE sub_id IN (SELECT sub_id FROM `subject` WHERE sub_name LIKE ?)");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?))");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE sub_id = ?");
				pst.setString(1, value);
			} else if (type.equals("stu_sub_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE stu_id = ? AND sub_id IN(SELECT sub_id FROM `subject` WHERE sub_name like ?)");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("stu_tec_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE stu_id = ? AND cla2sub_id IN(SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name Like ?)) order by sco_id");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("stu_all")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM score WHERE stu_id = ?");
				pst.setString(1, value);
			} else if (type.equals("tec_stu_all")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?)) order by sco_id";
				pst = conn.prepareStatement(sql);
				pst.setString(1, value);
				pst.setString(2, value);
			} else if (type.equals("tec_stu_no")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_no = ?)OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE stu_no = ?)order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_name = ?)OR cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE stu_name= ?)order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			}

			else if (type.equals("tec_sub_name")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))AND sub_id IN (SELECT sub_id FROM subject WHERE sub_name =?) OR (cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND sub_id IN(";
				sql += "SELECT sub_id FROM subject WHERE sub_name= ?))order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			}

			else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM score WHERE stu_id IN(SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?))AND cla_id IN (SELECT cla_id FROM classes WHERE cla_name =?) OR (cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name=?))AND cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_name= ?))order by sco_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			} else {
				pst = conn.prepareStatement("SELECT COUNT(*) FROM score");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				countPages = rs.getInt(1);
				countPages = countPages % 10 == 0 ? countPages / 10
						: countPages / 10 + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return countPages;
	}
}
