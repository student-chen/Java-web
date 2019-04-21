/**
 * 
 */
package com.bjsxt.drp.business.usermgr.dao;
import com.bjsxt.drp.business.usermgr.model.File;

import java.sql.Connection;
import java.util.List;

public interface FileDao {

	
	/**
	 * 上传文件
	 */ 
	public void addFile(Connection conn,File file);
	
	/**
	 * 删除文件
	 */
	public void delFile(Connection conn,String []file_name);
	
	/**
	 * 查询所有的文件
	 */
	public List findAllFile();
}
