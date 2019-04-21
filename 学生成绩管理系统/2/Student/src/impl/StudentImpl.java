package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.IStudent;
import entity.Student;

public class StudentImpl implements IStudent {
	private SimpleDateFormat sdf;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public int add(Student student) {
		int i = 0;
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("INSERT INTO student (ope_id,stu_no,stu_name,stu_sex,stu_birth,stu_pic,cla_id) VALUES (?,?,?,?,?,?,?)");
			pst.setInt(1, student.getOperator().getId());
			pst.setString(2, student.getNo());
			pst.setString(3, student.getName());
			pst.setString(4, student.getSex());
			pst.setString(5, student.getBirth());
			pst.setString(6, student.getPic());
			pst.setInt(7, student.getClasses().getId());
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return i;
	}

	public void delete(Student student) {
		try {
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM student WHERE stu_id = ?");
			pst.setInt(1, student.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void update(Student student) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("UPDATE student SET ope_id = ?,stu_no = ?,stu_name = ?,stu_sex = ?,stu_birth = ?,stu_pic = ?,cla_id = ? WHERE stu_id = ?");
			pst.setInt(1, student.getOperator().getId());
			pst.setString(2, student.getNo());
			pst.setString(3, student.getName());
			pst.setString(4, student.getSex());
			pst.setString(5, student.getBirth());
			pst.setString(6, student.getPic());
			pst.setInt(7, student.getClasses().getId());
			pst.setInt(8, student.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public List<Student> query(String type, String value) {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			conn = DB.getConn();
			if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE stu_id = ? order by stu_id");
				pst.setString(1, value);
			} else if (type.equals("ope_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE ope_id = ? order by stu_id");
				pst.setString(1, value);
			} else if (type.equals("stu_no")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE stu_no = ? order by stu_id");
				pst.setString(1, value);
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE stu_name LIKE ? order by stu_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE cla_id = ? order by stu_id");
				pst.setString(1, value);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?) order by stu_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("maj_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?)) order by stu_id");
				pst.setString(1, "%" + value + "%");
			}

			else if (type.equals("tec_stu_all")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE cla_id IN (SELECT cla_id FROM classes WHERE cla_tec = ?) OR cla_id IN(";
				sql += "SELECT cla_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name = ?)) order by stu_id";
				pst = conn.prepareStatement(sql);
				pst.setString(1, value);
				pst.setString(2, value);
			} else if (type.equals("tec_stu_no")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_no = ?)OR stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND stu_no = ?)order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			}

			else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_name LIKE ?)OR stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND stu_name LIKE ?) order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");
			} else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ? AND cla_name LIKE ?)OR cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND cla_name LIKE ?) order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");

			} else if (type.equals("tec_maj_name")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?))";
				sql += "OR cla_id IN (SELECT cla_id FROM classes WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?)) order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM student order by stu_id");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setOperator(new OperatorImpl().query("ope_id",
						rs.getString(2)).get(0));
				student.setNo(rs.getString(3));
				student.setName(rs.getString(4));
				student.setSex(rs.getString(5));
				student.setBirth(sdf.parse(rs.getString(6)));
				String pic = rs.getString(7);
				if (pic == null || pic.equals(""))
					student.setPic("../images/person.png");
				else
					student.setPic(rs.getString(7));
				student.setClasses(new ClassesImpl().query("cla_id",
						rs.getString(8)).get(0));
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Student> query(String type, String value, int currentPage) {
		currentPage = (currentPage - 1) * 10;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			conn = DB.getConn();
			if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE stu_id = ? order by stu_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("ope_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE ope_id = ? order by stu_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_no")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE stu_no = ? order by stu_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE stu_name LIKE ? order by stu_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE cla_id = ? order by stu_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?) order by stu_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("maj_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?)) order by stu_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("tec_stu_all")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE cla_id IN (SELECT cla_id FROM classes WHERE cla_tec = ?) OR cla_id IN(";
				sql += "SELECT cla_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name = ?))order by stu_id limit ?,10";
				pst = conn.prepareStatement(sql);
				pst.setString(1, value);
				pst.setString(2, value);
				pst.setInt(3, currentPage);
			} else if (type.equals("tec_stu_no")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_no LIKE ?)OR stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND stu_no = ?) order by stu_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
				pst.setInt(5, currentPage);
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_name LIKE ?)OR stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND stu_name LIKE ?) order by stu_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");
				pst.setInt(5, currentPage);
			} else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ? AND cla_name LIKE ?)OR cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND cla_name LIKE ?) order by stu_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");
				pst.setInt(5, currentPage);

			} else if (type.equals("tec_maj_name")) {
				String sql = "";
				sql += "SELECT * FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?))";
				sql += "OR cla_id IN (SELECT cla_id FROM classes WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?)) order by stu_id limit ?,10";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");
				pst.setInt(5, currentPage);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM student order by stu_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setOperator(new OperatorImpl().query("ope_id",
						rs.getString(2)).get(0));
				student.setNo(rs.getString(3));
				student.setName(rs.getString(4));
				student.setSex(rs.getString(5));
				student.setBirth(sdf.parse(rs.getString(6)));
				String pic = rs.getString(7);
				if (pic == null || pic.equals(""))
					student.setPic("../images/person.png");
				else
					student.setPic(rs.getString(7));
				student.setClasses(new ClassesImpl().query("cla_id",
						rs.getString(8)).get(0));
				list.add(student);
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
			if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM student WHERE stu_id = ?");
				pst.setString(1, value);
			} else if (type.equals("ope_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM student WHERE ope_id = ?");
				pst.setString(1, value);
			} else if (type.equals("stu_no")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM student WHERE stu_no = ?");
				pst.setString(1, value);
			} else if (type.equals("stu_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM student WHERE stu_name LIKE ?");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM student WHERE cla_id = ?");
				pst.setString(1, value);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?)");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("maj_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?))");
				pst.setString(1, "%" + value + "%");
			}

			else if (type.equals("tec_stu_all")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM student WHERE cla_id IN (SELECT cla_id FROM classes WHERE cla_tec = ?) OR cla_id IN(";
				sql += "SELECT cla_id FROM cla2sub WHERE tec_id IN(SELECT tec_id FROM teacher WHERE tec_name = ?))order by stu_id";
				pst = conn.prepareStatement(sql);
				pst.setString(1, value);
				pst.setString(2, value);
			} else if (type.equals("tec_stu_no")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM student WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_no = ?)OR stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND stu_no = ?) order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, values[1]);
				pst.setString(3, values[0]);
				pst.setString(4, values[1]);
			} else if (type.equals("tec_stu_name")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM student WHERE stu_id IN (SELECT stu_id FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND stu_name LIKE ?)OR stu_id IN(";
				sql += "SELECT stu_id FROM student WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND stu_name LIKE ?) order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");
			} else if (type.equals("tec_cla_name")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM student WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ? AND cla_name LIKE ?)OR cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND cla_name LIKE ?) order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");

			} else if (type.equals("tec_maj_name")) {
				String sql = "";
				sql += "SELECT COUNT(*) FROM student WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_id IN(";
				sql += "SELECT cla_id FROM classes WHERE cla_tec = ?)AND maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?))";
				sql += "OR cla_id IN (SELECT cla_id FROM classes WHERE cla_id IN(SELECT cla_id FROM cla2sub WHERE tec_id IN(";
				sql += "SELECT tec_id FROM teacher WHERE tec_name = ?))AND maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?)) order by stu_id";
				pst = conn.prepareStatement(sql);
				String[] values = value.split("_");
				pst.setString(1, values[0]);
				pst.setString(2, "%" + values[1] + "%");
				pst.setString(3, values[0]);
				pst.setString(4, "%" + values[1] + "%");
			} else {
				pst = conn.prepareStatement("SELECT COUNT(*) FROM student");
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