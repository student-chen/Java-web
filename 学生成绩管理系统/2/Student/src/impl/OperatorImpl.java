package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DB;
import dao.IOperator;
import entity.Operator;

public class OperatorImpl implements IOperator
{
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	public Operator add(Operator operator)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("INSERT INTO operator (ope_name,ope_pwd,rol_id) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, operator.getName());
			pst.setString(2, operator.getPwd());
			pst.setInt(3, operator.getRole().getId());
			pst.executeUpdate();
			rs = pst.getGeneratedKeys();
			if (rs.next())
			{
				operator = query("ope_id", rs.getString(1)).get(0);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
		return operator;
	}

	public void delete(Operator operator)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("DELETE FROM operator WHERE ope_id = ?");
			pst.setInt(1, operator.getId());
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
	}

	public void update(Operator operator)
	{
		try
		{
			conn = DB.getConn();
			pst = conn.prepareStatement("UPDATE operator SET ope_name = ?, ope_pwd = ?,rol_id = ? WHERE ope_id = ?");
			pst.setString(1, operator.getName());
			pst.setString(2, operator.getPwd());
			pst.setInt(3, operator.getRole().getId());
			pst.setInt(4, operator.getId());
			pst.executeUpdate();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			DB.close(conn, pst, rs);
		}
	}

	public List<Operator> query(String type, String value)
	{
		ArrayList<Operator> list = new ArrayList<Operator>();
		try
		{
			conn = DB.getConn();
			if (type.equals("ope_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM operator WHERE ope_id = ? order by ope_id");
				pst.setString(1, value);
			} else if (type.equals("ope_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM operator WHERE ope_name like ? order by ope_id");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("rol_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM operator WHERE rol_id = ? order by ope_id");
				pst.setString(1, value);
			} else
			{
				pst = conn.prepareStatement("SELECT * FROM operator order by ope_id");
			}
			rs = pst.executeQuery();
			while (rs.next())
			{
				Operator operator = new Operator();
				operator.setId(rs.getInt(1));
				operator.setName(rs.getString(2));
				operator.setPwd(rs.getString(3));
				operator.setRole(new RoleImpl().query("rol_id", rs.getString(4)).get(0));
				list.add(operator);
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

	public List<Operator> query(String type, String value, int currentPage)
	{
		currentPage = (currentPage - 1) * 10;
		ArrayList<Operator> list = new ArrayList<Operator>();
		try
		{
			conn = DB.getConn();
			if (type.equals("ope_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM operator WHERE ope_id = ? order by ope_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else if (type.equals("ope_name"))
			{
				pst = conn.prepareStatement("SELECT * FROM operator WHERE ope_name like ? order by ope_id limit ?,10");
				pst.setString(1, "%" + value + "%");
				pst.setInt(2, currentPage);
			} else if (type.equals("rol_id"))
			{
				pst = conn.prepareStatement("SELECT * FROM operator WHERE rol_id = ? order by ope_id limit ?,10");
				pst.setString(1, value);
				pst.setInt(2, currentPage);
			} else
			{
				pst = conn.prepareStatement("SELECT * FROM operator order by ope_id limit ?,10");
				pst.setInt(1, currentPage);
			}
			rs = pst.executeQuery();
			while (rs.next())
			{
				Operator operator = new Operator();
				operator.setId(rs.getInt(1));
				operator.setName(rs.getString(2));
				operator.setPwd(rs.getString(3));
				operator.setRole(new RoleImpl().query("rol_id", rs.getString(4)).get(0));
				list.add(operator);
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
			if (type.equals("ope_id"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM operator WHERE ope_id = ?");
				pst.setString(1, value);
			} else if (type.equals("ope_name"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM operator WHERE ope_name like ?");
				pst.setString(1, "%" + value + "%");
			} else if (type.equals("rol_id"))
			{
				pst = conn.prepareStatement("SELECT COUNT(*) FROM operator WHERE rol_id = ?");
				pst.setString(1, value);
			} else
				pst = conn.prepareStatement("SELECT COUNT(*) FROM operator");
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
