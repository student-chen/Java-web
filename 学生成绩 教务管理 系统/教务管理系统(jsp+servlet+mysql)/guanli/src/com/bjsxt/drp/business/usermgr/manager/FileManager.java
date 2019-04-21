/**
 * 
 */
package com.bjsxt.drp.business.usermgr.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.drp.business.usermgr.dao.FileDao;
import com.bjsxt.drp.business.usermgr.factory.FileDaoFactory;
import com.bjsxt.drp.business.usermgr.model.File;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.business.util.DB;
/**
 * 对文件完成增删查的管理类，采用单例模式实现
 * @author cash
 *
 */
public class FileManager {
	private static FileManager instance=new FileManager();
	
	private FileDao fileDao;
	
	private FileManager(){
           fileDao=FileDaoFactory.getInstance().createFileDao();		
	}

	public static FileManager getInstance() {
		return instance;
	}
	
	/**
	 * 上传文件
	 * @param File file对象
	 */
	public void addUser(File file) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			fileDao.addFile(conn, file);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 查询所有文件
	 * @return file对象列表
	 */
	public List findAllUserList() {
		List fileList = new ArrayList();
		try {
			fileList = fileDao.findAllFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fileList;
	} 
	
	/**
	 * 根据file_name的集合进行删除
	 * @param file_name file_name的集合
	 */
	public void deleteUsers(String[] file_name) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			fileDao.delFile(conn, file_name);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
	
	

}
