package cn.dinner.dao;

import java.util.List;

import cn.dinner.entity.Users;
import cn.dinner.util.Page;
import cn.dinner.util.UserCond;

public interface UsersDao {
	//登陆
	Users LoginUser(String loginName);
	//查询所有用户信息
	List<Users> getAllUsers(Page page,UserCond cond);
	//删除
	int delUser(Integer id);
	//修改
	int UpdateUser(Users user);
	//添加
	int addUser(Users user);
	//根据id获取对象
	Users getOneuser(Integer id);
	//判断登录名是否存在
	int flagLoginName(String loginName);
	//修改登录用户密码
	int UpUserPwd(Integer uid,String pwd);
	//修改用户在线状态
	int UpdateUserOnline(String loginName,Integer onlineNo);
}
