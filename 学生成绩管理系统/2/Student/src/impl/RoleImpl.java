package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.IRole;
import entity.Role;

public class RoleImpl implements IRole
{
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public void add(Role role)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("INSERT INTO role (rol_name) VALUES (?)");
			pst.setString(1, role.getName());
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
	}

	public void delete(Role role)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM role WHERE rol_id = ?");
			pst.setInt(1, role.getId());
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
	}

	public void update(Role role)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("UPDATE role SET rol_name = ? WHERE rol_id = ?");
			pst.setString(1, role.getName());
			pst.setInt(2, role.getId());
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
	}

	public List<Role> query(String type, String value)
	{
		ArrayList<Role> list = new ArrayList<Role>();
		try
		{
			conn = DB.getConn();
			if (type.equals("rol_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM role WHERE rol_id = ? order by rol_id");
				pst.setString(1, value);
			} else if (type.equals("rol_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM role WHERE rol_name like ? order by rol_id");
				pst.setString(1, "%" + value + "%");
			} else
			{
				pst = conn.prepareStatement("SELECT * FROM role order by rol_id");
			}
			rs = pst.executeQuery();
			while (rs.next())
			{
				Role role = new Role();
				role.setId(rs.getInt(1));
				role.setName(rs.getString(2));
				list.add(role);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public List<Role> query(String type, String value, int currentPage)
	{
		currentPage = (currentPage - 1) * 10;
		ArrayList<Role> list = new ArrayList<Role>();
		try
		{
			conn = DB.getConn();
			if (type.equals("rol_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM role WHERE rol_id = ? order by rol_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("rol_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM role WHERE rol_name like ? order by rol_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else
			{
				pst = conn.prepareStatement("SELECT * FROM role order by rol_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next())
			{
				Role role = new Role();
				role.setId(rs.getInt(1));
				role.setName(rs.getString(2));
				list.add(role);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
		return list;
	}

	public int getCountPage(String type, String value)
	{
		int countPages = 0;
		try
		{
			conn = DB.getConn();
			if (type.equals("rol_id"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM role WHERE rol_id = ?");
				pst.setString(1, value);
			} else if (type.equals("rol_name"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM role WHERE rol_name like ?");
				pst.setString(1, "%" + value + "%");
			} else
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM role");
			}
			rs = pst.executeQuery();
			while (rs.next())
			{
				countPages = rs.getInt(1);
				countPages = countPages % 10 == 0 ? countPages / 10 : countPages / 10 + 1;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
		return countPages;
	}

}
