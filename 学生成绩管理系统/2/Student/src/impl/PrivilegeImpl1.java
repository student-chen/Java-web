package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.IPrivilege;
import entity.Privilege;
import entity.Role;

public class PrivilegeImpl1 implements IPrivilege {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public void add(Privilege privilege) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("INSERT INTO privilege (pri_name,pri_url,men_id) VALUES (?,?,?)");
			pst.setString(1, privilege.getName());
			pst.setString(2, privilege.getUrl());
			pst.setString(3, privilege.getMenu_name());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void delete(Privilege privilege) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("DELETE FROM privilege WHERE pri_id = ?");
			pst.setInt(1, privilege.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public void update(Privilege privilege) {
		try {
			conn = DB.getConn();
			pst = conn
					.prepareStatement("UPDATE privilege SET pri_name = ?, pri_url = ?, men_id = ? WHERE pri_id = ?");
			pst.setString(1, privilege.getName());
			pst.setString(2, privilege.getUrl());
			pst.setString(3, privilege.getMenu_name());
			pst.setInt(4, privilege.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
	}

	public List<Privilege> query(String type, String value) {
		ArrayList<Privilege> list = new ArrayList<Privilege>();
		try {
			conn = DB.getConn();
			if (type.equals("pri_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE pri_id = ? order by pri_id");
				pst.setString(1, value);
			} else if (type.equals("pri_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE pri_name like ? order by pri_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("pri_url")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE pri_url = ? order by pri_id");
				pst.setString(1, value);
			} else if (type.equals("men_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE men_id = ? order by pri_id");
				pst.setString(1, value);
			} else if (type.equals("rol_id")) {

				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE rol_id=? order by pri_id");
				pst.setString(1, value);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM privilege order by pri_id");
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Privilege privilege = new Privilege();
				Role role = new Role();
				privilege.setId(rs.getInt("pri_id"));
				privilege.setName(rs.getString("pri_name"));
				privilege.setUrl(rs.getString("pri_url"));
				privilege.setMenu_name(rs.getString("menu_name"));
				role.setId(rs.getInt("rol_id"));
				privilege.setRole(role);
				list.add(privilege);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Privilege> query(String type, String value, int currentPage) {
		currentPage = (currentPage - 1) * 10;
		ArrayList<Privilege> list = new ArrayList<Privilege>();
		try {
			conn = DB.getConn();
			if (type.equals("pri_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE pri_id = ? order by pri_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("pri_name")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE pri_name like ? order by pri_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("pri_url")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE pri_url = ? order by pri_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("rol_id")) {
				pst = conn
						.prepareStatement("SELECT * FROM privilege WHERE pri_id IN (SELECT pri_id FROM rol2pri WHERE rol_id = ?) order by pri_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else {
				pst = conn
						.prepareStatement("SELECT * FROM privilege order by pri_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				Privilege privilege = new Privilege();
				Role role = new Role();
				privilege.setId(rs.getInt("pri_id"));
				privilege.setName(rs.getString("pri_name"));
				privilege.setUrl(rs.getString("pri_url"));
				privilege.setMenu_name(rs.getString("menu_name"));
				role.setId(rs.getInt("rol_id"));
				privilege.setRole(role);
				list.add(privilege);
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
			if (type.equals("pri_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM privilege WHERE pri_id = ?");
				pst.setString(1, value);
			} else if (type.equals("pri_name")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM privilege WHERE pri_name like ?");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("pri_url")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM privilege WHERE pri_url = ?");
				pst.setString(1, value);
			} else if (type.equals("men_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM privilege WHERE men_id = ?");
				pst.setString(1, value);
			} else if (type.equals("rol_id")) {
				pst = conn
						.prepareStatement("SELECT COUNT(*) FROM privilege WHERE pri_id IN (SELECT pri_id FROM rol2pri WHERE rol_id = ?)");
				pst.setString(1, value);
			} else {
				pst = conn.prepareStatement("SELECT COUNT(*) FROM privilege");
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
