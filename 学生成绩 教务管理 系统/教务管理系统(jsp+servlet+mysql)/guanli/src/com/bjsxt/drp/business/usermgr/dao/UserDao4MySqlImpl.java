package com.bjsxt.drp.business.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.business.util.DB;

/**
 * 用户增删改查Dao层MySql实现
 * 
 */
public class UserDao4MySqlImpl implements UserDao {

	/**
	 * 增加用户
	 * @param conn
	 * @param user user对象 
	 */
	public void addUser(Connection conn, User user) {
		String sql = "insert into t_user(user_id, user_name, password, contact_tel, email, create_date) "
				+ "values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getContactTel());
			pstmt.setString(5, user.getEmail());
			pstmt.setTimestamp(6, new Timestamp(user.getCreateDate().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
		}
	}

	/**
	 * 根据userId的集合删除用户
	 * @param conn
	 * @param userIdList  userId的集合
	 */
	public void deleteUsers(Connection conn, String[] userIdList) {
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < userIdList.length; i++) {
			sbfSql.append("'")
				.append(userIdList[i])
				.append("'")
				.append(",");
		}
		String sql = "delete from t_user where user_id in (" + sbfSql.substring(0, sbfSql.length()-1) + ")";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
	}

	/**
	 * 查询所有用户
	 * @return user对象列表
	 */
	public List findAllUserList() {
		String sql ="select * from t_user where user_id <> 'root' order by user_id ";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List userList = new ArrayList();
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setContactTel(rs.getString("contact_tel"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getTimestamp("create_date"));
				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeRs(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return userList;
	}

	/**
	 * 根据用户id查询用户
	 * @param userId 用户id
	 * @return user对象
	 */
	public User findUserById(String userId) {
		String sql = "select * from t_user where user_id=?"; 
		User user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try  {
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setContactTel(rs.getString("contact_tel"));
				user.setEmail(rs.getString("email"));
				user.setCreateDate(rs.getTimestamp("create_date"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeRs(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return user;
	}

	/**
	 * 修改用户
	 * @param conn
	 * @param user user对象
	 */
	public void modifyUser(Connection conn, User user) {
		String sql = "update t_user set user_name=?, password=?, contact_tel=?, email=? where user_id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getContactTel());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getUserId());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStmt(pstmt);
		}		
	}

}
