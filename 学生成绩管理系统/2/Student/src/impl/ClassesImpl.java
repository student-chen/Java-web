package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.IClasses;
import entity.Classes;

public class ClassesImpl implements IClasses
{
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public Classes add(Classes classes)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("INSERT INTO classes (cla_name,maj_id,cla_tec) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, classes.getName());
			pst.setInt(2, classes.getMajor().getId());
			pst.setString(3, classes.getTecName());
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next())
			{
				classes = query("cla_id", rs.getString(1)).get(0);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
		return classes;
	}

	public void delete(Classes classes)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM classes WHERE cla_id = ?");
			pst.setInt(1, classes.getId());
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
	}

	public void update(Classes classes)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("UPDATE classes SET cla_name = ?,maj_id = ?,cla_tec= ? WHERE cla_id = ?");
			pst.setString(1, classes.getName());
			pst.setInt(2, classes.getMajor().getId());
			pst.setString(3, classes.getTecName());
			pst.setInt(4, classes.getId());
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
	}

	public List<Classes> query(String type, String value)
	{
		ArrayList<Classes> list = new ArrayList<Classes>();
		try
		{
			conn = DB.getConn();
			if (type.equals("cla_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE cla_id = ? order by cla_id");
				pst.setString(1, value);
			} else if (type.equals("cla_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE cla_name like ? order by cla_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("maj_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE maj_id = ? order by cla_id");
				pst.setString(1, value);
			} else if (type.equals("maj_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?) order by cla_id");
				pst.setString(1, "%" + value + "%");
			}else if (type.equals("cla_tec"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE cla_tec  LIKE ? order by cla_id");
				pst.setString(1, "%" + value + "%");
			}
			else
			{
				pst = conn.prepareStatement("SELECT * FROM classes order by cla_id");
			}
			rs = pst.executeQuery();
			while (rs.next())
			{
				Classes classes = new Classes();
				classes.setId(rs.getInt(1));
				classes.setName(rs.getString(2));
				classes.setMajor(new MajorImpl().query("maj_id", rs.getString(3)).get(0));
				classes.setTecName(rs.getString(4));
				list.add(classes);
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

	public List<Classes> query(String type, String value, int currentPage)
	{
		currentPage = (currentPage - 1) * 10;
		ArrayList<Classes> list = new ArrayList<Classes>();
		try
		{
			conn = DB.getConn();
			if (type.equals("cla_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE cla_id = ? order by cla_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE cla_name like ? order by cla_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("maj_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE maj_id = ? order by cla_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("maj_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?) order by cla_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("cla_tec"))
			{
				pst = conn.prepareStatement("SELECT * FROM classes WHERE cla_tec = ? order by cla_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			}else
			{
				pst = conn.prepareStatement("SELECT * FROM classes order by cla_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next())
			{
				Classes classes = new Classes();
				classes.setId(rs.getInt(1));
				classes.setName(rs.getString(2));
				classes.setMajor(new MajorImpl().query("maj_id", rs.getString(3)).get(0));
				classes.setTecName(rs.getString(4));
				list.add(classes);
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
			if (type.equals("cla_id"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM classes WHERE cla_id = ?");
				pst.setString(1, value);
			} else if (type.equals("cla_name"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM classes WHERE cla_name like ?");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("maj_id"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM classes WHERE maj_id = ?");
				pst.setString(1, value);
			} else if (type.equals("maj_name"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM classes WHERE maj_id IN(SELECT maj_id FROM major WHERE maj_name LIKE ?)");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("cla_tec"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM classes WHERE cla_tec = ?");
				pst.setString(1, value);
			} else
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM classes");
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
