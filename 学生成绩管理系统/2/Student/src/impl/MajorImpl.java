package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.IMajor;
import entity.Major;

public class MajorImpl implements IMajor {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public int add(Major major) {
		int i = 0;
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("INSERT INTO major (maj_name,maj_prin,maj_link,maj_phone) VALUES (?,?,?,?)");
			pst.setString(1, major.getName());
			pst.setString(2, major.getPrin());
			pst.setString(3, major.getLink());
			pst.setString(4, major.getPhone());
			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return i;
	}

	public void delete(Major major) {
		try {
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM major WHERE maj_id = ?");
			pst.setInt(1, major.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void update(Major major) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("UPDATE major SET maj_name = ? ,maj_prin= ?,maj_link= ?,maj_phone= ? WHERE maj_id = ?");
			pst.setString(1, major.getName());
			pst.setString(2, major.getPrin());
			pst.setString(3, major.getLink());
			pst.setString(4, major.getPhone());
			pst.setInt(5, major.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public List<Major> query(String type, String value) {
		ArrayList<Major> list = new ArrayList<Major>();
		try {
			conn = DB.getConn();
			if (type.equals("maj_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_id = ? order by maj_id");
				pst.setString(1, value);
			} else if (type.equals("maj_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_name like ? order by maj_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_id IN(SELECT maj_id FROM classes WHERE cla_id = ?) order by maj_id");
				pst.setString(1, value);
			} else if (type.equals("maj_prin")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_prin like ? order by maj_id");
				pst.setString(1, "%" + value + "%");
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM major order by maj_id");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Major major = new Major();
				major.setId(rs.getInt(1));
				major.setName(rs.getString(2));
				major.setPrin(rs.getString(3));
				major.setLink(rs.getString(4));
				major.setPhone(rs.getString(5));
				list.add(major);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Major> query(String type, String value, int currentPage) {
		currentPage = (currentPage - 1) * 10;
		ArrayList<Major> list = new ArrayList<Major>();
		try {
			conn = DB.getConn();
			if (type.equals("maj_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_id = ? order by maj_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("maj_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_name like ? order by maj_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_id IN(SELECT maj_id FROM classes WHERE cla_id = ?) order by maj_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("maj_prin")) {
				pst = conn
						.prepareStatement("SELECT * FROM major WHERE maj_prin like ? order by maj_id  limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM major order by maj_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Major major = new Major();
				major.setId(rs.getInt(1));
				major.setName(rs.getString(2));
				major.setPrin(rs.getString(3));
				major.setLink(rs.getString(4));
				major.setPhone(rs.getString(5));
				list.add(major);
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
			if (type.equals("maj_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM major WHERE maj_id = ? order by maj_id");
				pst.setString(1, value);
			} else if (type.equals("maj_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM major WHERE maj_name like ? order by maj_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM major WHERE maj_id IN(SELECT maj_id FROM classes WHERE cla_id = ?)");
				pst.setString(1, value);
			} else if (type.equals("maj_prin")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM major WHERE maj_prin like ? order by maj_id");
				pst.setString(1, "%" + value + "%");
			} else {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM major order by maj_id");
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
