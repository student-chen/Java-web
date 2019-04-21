package dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UsRole;
import model.User;
import dao.UserDao;
import db.DBCon;

public class UserDaoImpl implements UserDao {
	private DBCon dbCon = new DBCon();
	private User user;
	private UsRole usRole;

	public User login(User user) {
		String sql = "select *from user where user_num='" + user.getUserNum()
				+ "'";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int userID = rs.getInt("user_id");
				String userNum = rs.getString("user_num");
				String userName = rs.getString("user_name");
				String pwd = rs.getString("password");
				String phone = rs.getString("phone");
				int roleID = rs.getInt("role_id");
				user = new User(userID, userNum, userName, pwd, phone, roleID);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}

	public int editPwd(User user) {
		String sql = "update user set password='" + user.getPassword()
				+ "' where user_num='" + user.getUserNum() + "'";
		int rs = dbCon.query(sql);
		return rs;
	}

	public int addUser(User user) {
		String sql = "insert into user(user_num,user_name,password,phone,role_id) values('"
				+ user.getUserNum()
				+ "','"
				+ user.getUserName()
				+ "','"
				+ user.getPassword()
				+ "',"
				+ user.getPhone()
				+ ","
				+ user.getRoleID() + ")";
		int rs = dbCon.query(sql);
		return rs;
	}

	public List findAll() {
		List<UsRole> list = new ArrayList<UsRole>();
		String sql = "select user_id,user_num,user_name,password,phone,role_name from user,role where user.role_id=role.role_id";
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int userID = rs.getInt("user_id");
				String userNum = rs.getString("user_num");
				String userName = rs.getString("user_name");
				String pwd = rs.getString("password");
				String phone = rs.getString("phone");
				String roleName = rs.getString("role_name");
				usRole = new UsRole(userID, userNum, userName, pwd, phone,
						roleName);
				list.add(usRole);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public List selectOneUser(int userID) {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user where user_id=" + userID;
		ResultSet rs = dbCon.find(sql);
		try {
			while (rs.next()) {
				int userid = rs.getInt("user_id");
				String userNum = rs.getString("user_num");
				String userName = rs.getString("user_name");
				String pwd = rs.getString("password");
				String phone = rs.getString("phone");
				int roleID = rs.getInt("role_id");
				user = new User(userID, userNum, userName, pwd, phone, roleID);
				list.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	public int editUser(User user) {
		String sql = "update user set user_name='" + user.getUserName()
				+ "',password=" + user.getPassword() + ",phone='"
				+ user.getPhone() + "' where user_num='" + user.getUserNum()
				+ "'";
		int rs = dbCon.query(sql);
		return rs;
	}

}
