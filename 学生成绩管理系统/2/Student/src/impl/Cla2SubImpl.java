package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.ICla2Sub;
import entity.Cla2Sub;

public class Cla2SubImpl implements ICla2Sub {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public int add(Cla2Sub cla2Sub) {
		int i = 0;
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("INSERT INTO cla2sub (cla_id,sub_id,tec_id) VALUES (?,?,?)");
			pst.setInt(1, cla2Sub.getClasses().getId());
			pst.setInt(2, cla2Sub.getSubject().getId());
			pst.setInt(3, cla2Sub.getTeacher().getId());
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return i;
	}

	public void delete(Cla2Sub cla2Sub) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("DELETE FROM cla2sub WHERE cla2sub_id = ?");
			pst.setInt(1, cla2Sub.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void update(Cla2Sub cla2Sub) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("UPDATE cla2sub SET cla_id = ?, sub_id = ?,tec_id = ? WHERE cla2sub_id = ?");
			pst.setInt(1, cla2Sub.getClasses().getId());
			pst.setInt(2, cla2Sub.getSubject().getId());
			pst.setInt(3, cla2Sub.getTeacher().getId());
			pst.setInt(4, cla2Sub.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public Cla2Sub findCla2sub(int cla_id, int tec_id, int sub_id) {
		Cla2Sub cla2sub = new Cla2Sub();
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("SELECT * FROM cla2sub WHERE sub_id = ? AND cla_id = ? AND tec_id = ? order by cla2sub_id");
			pst.setInt(1, sub_id);
			pst.setInt(2, cla_id);
			pst.setInt(3, tec_id);
			rs = pst.executeQuery();
			if (rs.next()) {
				cla2sub.setId(rs.getInt(1));
				cla2sub.setClasses(new ClassesImpl().query("cla_id",
						rs.getString(2)).get(0));
				cla2sub.setSubject(new SubjectImpl().query("sub_id",
						rs.getString(3)).get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cla2sub;
	}

	public List<Cla2Sub> query(String type, String value) {
		List<Cla2Sub> list = new ArrayList<Cla2Sub>();
		try {
			conn = DB.getConn();
			if (type.equals("cla2sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where cla2sub_id = ? order by cla2sub_id");
				pst.setString(1, value);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_id = ?) order by cla2sub_id");
				pst.setString(1, value);
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where cla_id = ? order by cla2sub_id");
				pst.setString(1, value);
			} else if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where sub_id = ? order by cla2sub_id");
				pst.setString(1, value);
			} else if (type.equals("tec_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where tec_id = ? order by cla2sub_id");
				pst.setString(1, value);
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub WHERE sub_id IN(SELECT sub_id FROM `subject` WHERE sub_name LIKE ?) order by cla2sub_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?) order by cla2sub_id");
				pst.setString(1, "%" + value + "%");
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub order by cla2sub_id");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Cla2Sub cla2Sub = new Cla2Sub();
				cla2Sub.setId(rs.getInt(1));
				cla2Sub.setClasses(new ClassesImpl().query("cla_id",
						rs.getString(2)).get(0));
				cla2Sub.setSubject(new SubjectImpl().query("sub_id",
						rs.getString(3)).get(0));
				cla2Sub.setTeacher(new TeacherImpl().query("tec_id",
						rs.getString(4)).get(0));
				list.add(cla2Sub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Cla2Sub> query(String type, String value, int currentPage) {
		currentPage = (currentPage - 1) * 10;
		List<Cla2Sub> list = new ArrayList<Cla2Sub>();
		try {
			conn = DB.getConn();
			if (type.equals("cla2sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where cla2sub_id = ? order by cla2sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_id = ?) order by cla2sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			}

			else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where cla_id = ? order by cla2sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where sub_id = ? order by cla2sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("tec_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub where tec_id = ? order by cla2sub_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub WHERE sub_id IN(SELECT sub_id FROM `subject` WHERE sub_name LIKE ?) order by cla2sub_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?) order by cla2sub_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM cla2sub order by cla2sub_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Cla2Sub cla2Sub = new Cla2Sub();
				cla2Sub.setId(rs.getInt(1));
				cla2Sub.setClasses(new ClassesImpl().query("cla_id",
						rs.getString(2)).get(0));
				cla2Sub.setSubject(new SubjectImpl().query("sub_id",
						rs.getString(3)).get(0));
				cla2Sub.setTeacher(new TeacherImpl().query("tec_id",
						rs.getString(4)).get(0));
				list.add(cla2Sub);
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
			if (type.equals("cla2sub_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM cla2sub where cla2sub_id = ?");
				pst.setString(1, value);
			} else if (type.equals("stu_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM student WHERE stu_id = ?) order by cla2sub_id");
				pst.setString(1, value);
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM cla2sub where cla_id = ?");
				pst.setString(1, value);
			} else if (type.equals("sub_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM cla2sub where sub_id = ?");
				pst.setString(1, value);
			} else if (type.equals("tec_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM cla2sub where tec_id = ?");
				pst.setString(1, value);
			} else if (type.equals("sub_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM cla2sub WHERE sub_id IN(SELECT sub_id FROM `subject` WHERE sub_name LIKE ?)");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM cla2sub WHERE cla_id IN(SELECT cla_id FROM classes WHERE cla_name LIKE ?)");
				pst.setString(1, "%" + value + "%");
			} else {
				pst = conn.prepareStatement("SELECT COUNT(*) FROM cla2sub");
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
