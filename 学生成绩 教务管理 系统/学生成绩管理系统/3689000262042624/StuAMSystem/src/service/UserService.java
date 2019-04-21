package service;

import java.util.List;

import model.User;

public interface UserService {
	/*
	 * 登录验证、查询密码、查询信息
	 */
	User login(User user);
	/*
	 * 修改密码
	 */
	int editPwd(User user);
	/*
	 * 添加
	 */
	int addUser(User user);
	/*
	 * 查询所有账号信息
	 */
	List findAll();
	/*
	 * 查询一个账号信息
	 */
	List selectOneUser(int userID);
	/*
	 * 修改所有账号信息
	 */
	int editUser(User user);

}
