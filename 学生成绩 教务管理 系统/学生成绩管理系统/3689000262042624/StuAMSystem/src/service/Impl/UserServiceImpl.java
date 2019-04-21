package service.Impl;

import java.util.List;

import dao.Impl.UserDaoImpl;

import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDaoImpl userDaoImpl=new UserDaoImpl();

	public User login(User user) {
		
		User rs=userDaoImpl.login(user);
		return rs;
	}

	public int editPwd(User user) {
		
		int rs=userDaoImpl.editPwd(user);
		return rs;
	}

	public int addUser(User user) {
		
		int rs=userDaoImpl.addUser(user);
		return rs;
	}

	public List findAll() {
		
		List rs=userDaoImpl.findAll();
		return rs;
	}

	public List selectOneUser(int userID) {
		
		List rs=userDaoImpl.selectOneUser(userID);
		return rs;
	}

	public int editUser(User user) {
		
		int rs=userDaoImpl.editUser(user);
		return rs;
	}

}
