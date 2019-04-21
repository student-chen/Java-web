package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.ISubject;
import entity.Subject;

public class SubjectImpl implements ISubject {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public int add(Subject subject) {
		int i = 0;
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("INSERT INTO subject (sub_name,sub_type,sub_times) VALUES (?,?,?)");
			pst.setString(1, subject.getName());
			pst.setString(2, subject.getType());
			pst.setInt(3, subject.getTimes());
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return i;
	}

	public void delete(Subject subject) {
		try {
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM subject WHERE sub_id = ?");
			pst.setInt(1, subject.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void update(Subject subject) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("UPDATE subject SET sub_name = ?,sub_type = ?,sub_times = ? WHERE sub_id = ?");
			pst.setString(1, subject.getName());
			pst.setString(2, subject.getType());
			pst.setInt(3, subject.getTimes());
			pst.setInt(4, subject.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public List<Subject> query(String type, String value) {
		ArrayList<Subject> list = new ArrayList<Subject>();
		try {
			conn = DB.getConn();
			if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject WHERE sub_id = ? order by sub_id");
				pst.setString(1, value);
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject WHERE sub_name like ? order by sub_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?) ORDER BY sub_id");
				pst.setString(1, value);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?)) order by sub_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_name LIKE ?)) order by sub_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject WHERE sub_id IN (SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_id = ?)) order by sub_id");
				pst.setString(1, value);
			} else if (type.equals("stu_all")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?)) order by sub_id");
				pst.setString(1, value);
			} else if (type.equals("stu_sub_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?)) AND sub_name LIKE ? order by sub_id");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("stu_tec_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?) AND tec_id IN(SELECT tec_id FROM teacher WHERE tec_name LIKE ?)) order by sub_id");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			}

			else if (type.equals("tec_stu_all")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id = ?) order by sub_id");
				pst.setString(1, value);
			}

			else if (type.equals("tec_sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id = ?) AND sub_name LIKE ? order by sub_id");
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT * FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?))) order by sub_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT * FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM student WHERE stu_name LIKE ?))) order by sub_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("tec_tec_name")) {
				String sql = "";
				sql += "SELECT * FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM classes WHERE cla_tec LIKE ?))) order by sub_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			}

			else if (type.equals("subject_able")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id NOT IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?) order by sub_id");
				pst.setString(1, value);
			} else if (type.equals("subject_unable")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?) order by sub_id");
				pst.setString(1, value);
			} else if (type.equals("sub_type")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject where sub_type = ? order by sub_id");
				pst.setString(1, value);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM subject order by sub_id");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setId(rs.getInt(1));
				subject.setName(rs.getString(2));
				subject.setType(rs.getString(3));
				subject.setTimes(rs.getInt(4));
				list.add(subject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Subject> query(String type, String value, int currentPage) {
		currentPage = (currentPage - 1) * 10;
		ArrayList<Subject> list = new ArrayList<Subject>();
		try {
			conn = DB.getConn();
			if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject WHERE sub_id = ? order by sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject WHERE sub_name like ? order by sub_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?) ORDER BY sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?)) order by sub_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_name LIKE ?)) order by sub_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			}

			else if (type.equals("tec_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name LIKE ?)) order by sub_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject WHERE sub_id IN (SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_id = ?)) order by sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_all")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?)) order by sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_sub_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?)) AND sub_name LIKE ? order by sub_id limit ?,10");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setInt(3, currentPage);
			} else if (type.equals("stu_tec_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?) AND tec_id IN(SELECT tec_id FROM teacher WHERE tec_name LIKE ?)) order by sub_id");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			}

			else if (type.equals("tec_stu_all")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id = ?) order by sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			}

			else if (type.equals("tec_sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id = ?) AND sub_name LIKE ? order by sub_id limit ?,10");
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setInt(3, currentPage);
			} else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT * FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?))) order by sub_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setInt(3, currentPage);
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT * FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM student WHERE stu_name LIKE ?))) order by sub_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setInt(3, currentPage);
			} else if (type.equals("tec_tec_name")) {
				String sql = "";
				sql += "SELECT * FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM classes WHERE cla_tec LIKE ?))) order by sub_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setInt(3, currentPage);
			} else if (type.equals("subject_able")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id NOT IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?) order by sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("subject_unable")) {
				pst = conn
						.prepareStatement("SELECT * FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?) order by sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("sub_type")) {
				pst = conn
						.prepareStatement("SELECT * FROM subject WHERE sub_type = ? order by sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM subject order by sub_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setId(rs.getInt(1));
				subject.setName(rs.getString(2));
				subject.setType(rs.getString(3));
				subject.setTimes(rs.getInt(4));
				list.add(subject);
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
			if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM subject WHERE sub_id = ?");
				pst.setString(1, value);
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM subject WHERE sub_name like ?");
				pst.setString(1, "%" + value + "%");
			}
			if (type.equals("sub_type")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM subject WHERE sub_type = ?");
				pst.setString(1, value);
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?)");
				pst.setString(1, value);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?))");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_name LIKE ?))");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("tec_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name LIKE ?))");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM subject WHERE sub_id IN (SELECT sub_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_id = ?))");
				pst.setString(1, value);
			} else if (type.equals("stu_all")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?))");
				pst.setString(1, value);
			} else if (type.equals("stu_sub_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?)) AND sub_name LIKE ?");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("stu_tec_name")) {
				String[] values = value.split("_");
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id IN (SELECT cla_id FROM student WHERE stu_id = ?) AND tec_id IN(SELECT tec_id FROM teacher WHERE tec_name LIKE ?)) order by sub_id");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			}

			else if (type.equals("tec_stu_all")) {
				pst = conn
						.prepareStatement("SELECT  COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id = ?) order by sub_id");
				pst.setString(1, value);
			}

			else if (type.equals("tec_sub_name")) {
				pst = conn
						.prepareStatement("SELECT  COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE tec_id = ?) AND sub_name LIKE ? order by sub_id");
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT  COUNT(*) FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?))) order by sub_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT  COUNT(*) FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM student WHERE stu_name LIKE ?))) order by sub_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			} else if (type.equals("tec_tec_name")) {
				String sql = "";
				sql += "SELECT  COUNT(*) FROM subject WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla2sub_id IN(";
				sql += "SELECT cla2sub_id FROM cla2sub WHERE tec_id = ? AND cla_id IN(SELECT cla_id FROM classes WHERE cla_tec LIKE ?))) order by sub_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
			}

			else if (type.equals("subject_able")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id NOT IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?)");
				pst.setString(1, value);
			} else if (type.equals("subject_unable")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM `subject` WHERE sub_id IN(SELECT sub_id FROM cla2sub WHERE cla_id = ?)");
				pst.setString(1, value);
			} else {
				pst = conn.prepareStatement("SELECT COUNT(*) FROM subject");
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
