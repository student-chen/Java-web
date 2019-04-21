package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.ITeacher;
import entity.Teacher;

public class TeacherImpl implements ITeacher {
	private SimpleDateFormat sdf;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public int add(Teacher teacher) {
		int i = 0;
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("INSERT INTO teacher (ope_id,tec_name,tec_birth,tec_sex,tec_major,tec_phone) VALUES (?,?,?,?,?,?)");
			pst.setInt(1, teacher.getOperator().getId());
			pst.setString(2, teacher.getName());
			pst.setString(3, teacher.getBirth());
			pst.setString(4, teacher.getSex());
			pst.setString(5, teacher.getMajor());
			pst.setString(6, teacher.getPhone());
			i = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return i;
	}

	public void delete(Teacher teacher) {
		try {
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM teacher WHERE tec_id = ?");
			pst.setInt(1, teacher.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void update(Teacher teacher) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("UPDATE teacher SET ope_id = ?,tec_name = ?,tec_birth= ?,tec_sex= ?,tec_major= ?,tec_phone = ? WHERE tec_id = ?");
			pst.setInt(1, teacher.getOperator().getId());
			pst.setString(2, teacher.getName());
			pst.setString(3, teacher.getBirth());
			pst.setString(4, teacher.getSex());
			pst.setString(5, teacher.getMajor());
			pst.setString(6, teacher.getPhone());
			pst.setInt(7, teacher.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public List<Teacher> query(String type, String value) {
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			conn = DB.getConn();
			if (type.equals("ope_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE ope_id = ? order by tec_id");
				pst.setString(1, value);
			} else if (type.equals("tec_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_id = ? order by tec_id");
				pst.setString(1, value);
			} else if (type.equals("tec_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_name LIKE ? order by tec_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_name IN (SELECT cla_tec FROM classes WHERE cla_id in(SELECT cla_id FROM student WHERE stu_id = ?)) order by tec_id ");
				pst.setString(1, value);
			}

			else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_name = (SELECT cla_tec FROM classes WHERE cla_name = ?)OR tec_name IN (SELECT tec_name FROM teacher WHERE tec_id IN(SELECT tec_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name = ?))) order by tec_id");
				pst.setString(1, value);
				pst.setString(2, value);
			} else if (type.equals("tec_major")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_major LIKE ? order by tec_id");
				pst.setString(1, "%" + value + "%");
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM teacher order by tec_id");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setOperator(new OperatorImpl().query("ope_id",
						rs.getString(2)).get(0));
				teacher.setName(rs.getString(3));
				teacher.setBirth(sdf.parse(rs.getString(4)));
				teacher.setSex(rs.getString(5));
				teacher.setMajor(rs.getString(6));
				teacher.setPhone(rs.getString(7));
				list.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Teacher> query(String type, String value, int currentPage) {
		currentPage = (currentPage - 1) * 10;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		try {
			conn = DB.getConn();
			if (type.equals("ope_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE ope_id = ? order by tec_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("tec_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_id = ? order by tec_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("tec_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_name LIKE ? order by tec_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_name IN (SELECT cla_tec FROM classes WHERE cla_id in(SELECT cla_id FROM student WHERE stu_id = ?)) order by tec_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			}

			else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_name = (SELECT cla_tec FROM classes WHERE cla_name = ?)OR tec_name IN (SELECT tec_name FROM teacher WHERE tec_id IN(SELECT tec_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name = ?))) order by tec_id limit ?,10");
				pst.setString(1, value);
				pst.setString(2, value);
				pst.setInt(3, currentPage);
			} else if (type.equals("tec_major")) {
				pst = conn
						.prepareStatement("SELECT * FROM teacher WHERE tec_major LIKE ? order by tec_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM teacher order by tec_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setOperator(new OperatorImpl().query("ope_id",
						rs.getString(2)).get(0));
				teacher.setName(rs.getString(3));
				teacher.setBirth(sdf.parse(rs.getString(4)));
				teacher.setSex(rs.getString(5));
				teacher.setMajor(rs.getString(6));
				teacher.setPhone(rs.getString(7));
				list.add(teacher);
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
			if (type.equals("ope_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM teacher WHERE ope_id = ?");
				pst.setString(1, value);
			} else if (type.equals("tec_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM teacher WHERE tec_id = ?");
				pst.setString(1, value);
			} else if (type.equals("tec_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM teacher WHERE tec_name LIKE ?");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM teacher WHERE tec_name IN (SELECT cla_tec FROM classes WHERE cla_id in(SELECT cla_id FROM student WHERE stu_id = ?)) order by tec_id");
				pst.setString(1, value);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM teacher WHERE tec_name = (SELECT cla_tec FROM classes WHERE cla_name = ?)OR tec_name IN (SELECT tec_name FROM teacher WHERE tec_id IN(SELECT tec_id FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name = ?))) order by tec_id");
				pst.setString(1, value);
				pst.setString(2, value);
			} else if (type.equals("tec_major")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM teacher WHERE tec_major LIKE ?");
				pst.setString(1, "%" + value + "%");
			} else {
				pst = conn.prepareStatement("SELECT COUNT(*) FROM teacher");
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
