package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLServerDBManager;
import com.tsinghuait.st0717.hospitalsystem.dto.Post;
import com.tsinghuait.st0717.hospitalsystem.dto.Receipt;
import com.tsinghuait.st0717.hospitalsystem.dto.Stat;

public class ReceiptService {
	/**
	 * 按作者姓名查找
	 * 
	 * @return 装dto对象的collection集合
	 * 
	 * @forword 作者列表
	 */

	/**
	 * 返回总行数，分页
	 * */
	public Collection searchPostsById(String sql) {
		Collection<Post> col = null;
		ResultSet rs = SQLServerDBManager.execQuery(sql);
		if (rs != null) {
			col = new ArrayList<Post>();
			try {
				while (rs.next()) {
					Post dto = new Post();
					dto.setId(rs.getInt("id"));
					dto.setName(rs.getString("name"));
					col.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return col;
	}

	/**
	 * 分页技术
	 * 
	 */
	public Collection searchPostsByName(String sql) {
		Collection<Receipt> col = null;
		ResultSet rs = SQLServerDBManager.execQuery(sql);
		try {
			col=new ArrayList<Receipt>();
			while(rs.next())
			{
				Receipt dto=new Receipt();
				dto.setId(rs.getInt("id"));
				dto.setItems(rs.getString("items"));
				dto.setPay(rs.getFloat("pay"));
				dto.setPayee(rs.getString("payee"));
				dto.setPayeeId(rs.getInt("payeeId"));
				dto.setPdate(rs.getDate("pdate"));
				dto.setIsFinished(rs.getByte("isFinished"));
				col.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return col;
	}

//	查看病人信息
	public ArrayList selectReceipt(String sql){
		ArrayList<Receipt> arr=null;	
      try 
		 {
		   ResultSet rs=new SQLConnection().executeQuery(sql);
		 if(rs!=null)
		{
			arr=new ArrayList<Receipt>();
		      int i=0;
		      while(rs.next()){
		    	  Receipt dto=new Receipt();
  				  dto.setId(rs.getInt("id"));
  				  dto.setItems(rs.getString("items"));
  				  dto.setPay(rs.getFloat("pay"));
  				  dto.setPayee(rs.getString("payee"));
  				  dto.setPayeeId(rs.getInt("payeeId"));
  				  dto.setPdate(rs.getDate("pdate"));
  				  dto.setIsFinished(rs.getInt("isFinished"));
  				  arr.add(dto);
  				  i++;
				}
			 }	
		}	catch(Exception e)
		       {
			e.printStackTrace();
		       }
		return arr;
	}
	//修改
	public int execteUpdate(String sql){
		int num=0;
		num=new SQLConnection().executeUpdate(sql);
		return num;
	}
	//删除
	public int deletePatientByID(String id)
	{
		SQLConnection sq=new SQLConnection();
		return sq.executeUpdate("delete from receipt where isFinished=1");	
	}
	int rowsCount=0;//总行数
	int pageCount=1;//显示页数
	public int getPageCount() {
		return pageCount;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public Collection searchReceiptsByName(String sql, int page, int pageSize) {
		Collection<Stat> col = null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			if (rs != null && rs.next()) {
			   col = new ArrayList<Stat>();
				// 得到数据总条数
				rs.last();
				System.out.println(rs.getRow());
				rowsCount = rs.getRow();

				// 当前显示页
				pageCount = (rowsCount / pageSize)
						+ (rowsCount % pageSize == 0 ? 0 : 1);
				System.out.println(pageCount + "页数");
				int rowStartIndex = (page - 1) * pageSize + 1;
				rs.absolute(rowStartIndex);
				int i = 0;
				do {
					Stat dto=new Stat();
					//dto.setId(rs.getInt("id"));
					dto.setItems(rs.getString("items"));
					dto.setPay(rs.getFloat("pay"));
					dto.setPayee(rs.getString("payee"));
					//dto.setPayeeId(rs.getInt("payeeId"));
					dto.setName(rs.getString("name"));
					dto.setPdate(rs.getDate("pdate"));
					dto.setIsFinished(rs.getByte("isFinished"));
					col.add(dto);
					i++;
				} while (rs.next() && i < pageSize);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return col;
	}
}
