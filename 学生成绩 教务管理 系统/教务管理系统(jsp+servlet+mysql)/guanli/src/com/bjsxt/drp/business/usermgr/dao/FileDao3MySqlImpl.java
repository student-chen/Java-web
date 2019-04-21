/**
 * 
 */
package com.bjsxt.drp.business.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import com.bjsxt.drp.business.usermgr.model.File;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.business.util.DB;

/**
 * @author cash
 *
 */
public class FileDao3MySqlImpl implements FileDao {

	/* (non-Javadoc)
	 * @see com.bjsxt.drp.business.usermgr.dao.FileDao#addFile(java.sql.Connection, com.bjsxt.drp.business.usermgr.model.File)
	 */
	public void addFile(Connection conn, File file) {
		String sql = "insert into t_file(file_name,file_path,file_date) "
			+ "values(?, ?, ?)";
	PreparedStatement pstmt = null;
	try {
System.out.println("cash1");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, file.getFile_name());
		pstmt.setString(2, file.getFile_path());
        pstmt.setDate(3, file.getFile_date());
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DB.closeStmt(pstmt);
	}

	}

	/* (non-Javadoc)
	 * @see com.bjsxt.drp.business.usermgr.dao.FileDao#delFile(java.sql.Connection, com.bjsxt.drp.business.usermgr.model.File)
	 */
	public void delFile(Connection conn, String []file_name) {
		StringBuffer sbfSql = new StringBuffer();
		for (int i = 0; i < file_name.length; i++) {
			sbfSql.append("'")
				.append(file_name[i])
				.append("'")
				.append(",");
		}
		String sql = "delete from t_file where file_name in (" + sbfSql.substring(0, sbfSql.length()-1) + ")";
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

	/* (non-Javadoc)
	 * @see com.bjsxt.drp.business.usermgr.dao.FileDao#findAllFile(java.sql.Connection, com.bjsxt.drp.business.usermgr.model.File)
	 */
	public List findAllFile() {
		String sql ="select * from t_file where file_name <> 'root' order by file_name ";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List fileList = new ArrayList();
		try {
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				File file = new File();
				file.setFile_name(rs.getString("file_name"));
				file.setFile_path(rs.getString("file_path"));
				file.setFile_date(java.sql.Date.valueOf( rs.getString("file_date")));
				fileList.add(file);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeRs(rs);
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
		return fileList;
	
	}

}
