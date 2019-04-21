package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.UsersDao;
import cn.dinner.entity.Users;
import cn.dinner.service.Usersservice;
import cn.dinner.util.Page;
import cn.dinner.util.UserCond;

@Service
@Transactional
public class UsersserviceImpl implements Usersservice {
	@Autowired
	private UsersDao usersDao;

	// 封装
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Users> getAllUsers(Page page,UserCond cond) {
		return usersDao.getAllUsers(page,cond);
	}

	@Override
	@Transactional(readOnly = true)
	public Users LoginUser(String loginName) {
		return usersDao.LoginUser(loginName);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delUser(Integer id) {
		return usersDao.delUser(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateUser(Users user) {
		return usersDao.UpdateUser(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int addUser(Users user) {
		return usersDao.addUser(user);
	}

	@Override
	@Transactional(readOnly = true)
	public Users getOneuser(Integer id) {
		return usersDao.getOneuser(id);
	}

	@Override
	@Transactional(readOnly = true)
	public int flagLoginName(String loginName) {
		return usersDao.flagLoginName(loginName);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpUserPwd(Integer uid, String pwd) {
		return usersDao.UpUserPwd(uid, pwd);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateUserOnline(String loginName,Integer onlineNo) {
		return usersDao.UpdateUserOnline(loginName,onlineNo);
	}
}
