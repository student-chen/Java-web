package com.sevenEleven.Beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

/*
 * 一个分页的类，分页的存储过程，分页的jsp示例一个分页的存储过程一个调用存储过程的包装类调用分页的类的jsp示例
 *基本思路：先调用存储过程从数据库中取出一部分数据，放入集合中进行缓存，然后从中取出一部分显示在一页中，
 *当要取下一页数据时，先从缓存中取数据，如果缓存中的数据不足，然后在调用存储过程从数据库中取数据
 */
public class CbestPageBean {

	private int curDbPage = 1;// 从数据库中读取的是第几个页面的数据（按照一次读rowsPerGetDB条记录）

	private int maxDbPage;// 数据库中共有多少个页面可共读取（按照一次读rowsPerGetDB条记录）

	private int sumRows;// 数据库中的总记录数

	private int curPage = -1;

	/*
	 * 当前显示的页面，-1表示从数据库中取出第一个页面的数据 -2 表示从数据库中取出当前页面的前一个页面的数据 -3
	 * 表示从数据库中取出当前页面的后一个页面的数据 -4 表示从数据库中取出最后一个页面的数据
	 * 正数说明是从缓存数组中取出相应的页面，不是从数据库中取数据，这个数字大小在1到multiple之间
	 */
	private int maxPage;// 如果按照每页显示的数据行数，则共可以显示的页面数

	private int displayPageNumber;// 当前一共可以显示的页面

	private int multiple = 10; // 一次从数据库中取出的数据是每页显示的数据的倍数

	private int rowsPerPage = 20;// 每页显示的数据行数

	private int rowsPerGetDB = 200;// 一次从数据库中读取的记录，应等于rowsPerPage与multiple之积

	private int pageSumFromDBVector;// 当前实际从数据库中读取的数据可供显示的页面数

	private Vector pageData;// 存放一次要显示的数据

	private Vector dataFromDB;// 一次从数据库中读取的数据

	// 获得数据需要的参数
	private Connection conn;// 数据库连接对象

	private int i_desc = 1;// 按升序还是降序排列数据，0 升序，1降序

	private String s_WhereCondition = "";// 条件

	private String s_OrderFieldName = "pubDate";// 排序字段，不能为空！

	private String s_TableName = "rss";// 从那个表中取数据

	private String s_FieldsName = "title,link,author,category,pubDate,description"; // 要查询的数据列，*

	// 为全部数据，

	private int i_FieldsCount = 6; // 要取出数据列的个数

	public CbestPageBean() {
		pageData = new Vector();
		dataFromDB = new Vector();
	}

	public void setConnection(Connection con) {
		conn = con;
	}

	public void setTableName(String s) {
		this.s_TableName = s;
		// 取出字段个数
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("Select  count( *)   From   Syscolumns C, Sysobjects N where N.id=C.id and N.name='"
							+ this.s_TableName + "'");
			rs.next();
			i_FieldsCount = rs.getInt(1);
			rs.close();
			stmt.close();
		} catch (SQLException e) {

			System.out.println("获得表的字段个数错误" + e.toString());
		}

	}

	public void setFieldsName(String s) {
		this.s_FieldsName = s;
		java.util.StringTokenizer st = new StringTokenizer(s, ",");
		this.i_FieldsCount = st.countTokens();
	}

	public void setWhereCondition(String s) {
		this.s_WhereCondition = s;
		this.getSumPage();// 重新设置了查询数据的条件，所有要重新计算总行数、总页数。

	}

	public void setOrderFieldName(String s) {
		this.s_OrderFieldName = s;
	}

	public void setDesc(int i) {
		this.i_desc = i;
	}

	public void setCurDbPage(int curDbPage) {
		// 如果设置数据页，采取向前翻一个数据页，标记-2是让取当前页面的前一页数据
		// 所以要先加上一页！取出的数据才刚好是要取的数据。
		this.curPage = -2;
		this.curDbPage = curDbPage + 1;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerGetDB = rowsPerPage * multiple;
		this.rowsPerPage = rowsPerPage;
		this.getSumPage();// 重新设置了每页显示的行数，所有要重新计算总页数。
	}

	public void setMultiple(int multiple) {
		this.rowsPerGetDB = rowsPerPage * multiple;
		this.multiple = multiple;
	}

	public int getCurDbPage() {
		return curDbPage;
	}

	public int getMaxDbPage() {
		return maxDbPage;
	}

	public int getSumRows() {
		return sumRows;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getDisplayPageNumber() {
		return displayPageNumber;
	}

	public int getMultiple() {
		return multiple;
	}

	public int getPageSumFromDBVector() {
		return pageSumFromDBVector;
	}

	// 得到每页的数据
	public Vector getPageData() {
		pageData.clear();
		// 需要从数据库中取数据(最前的数据)
		if (this.curPage == -1) {
			this.curDbPage = 1;
			getDataFromDB();
			this.curPage = 1;
		}
		// 需要从数据库中取数据(向前取数据)
		if (this.curPage == -2) {
			if (this.curDbPage > 1)
				this.curDbPage = this.curDbPage - 1;
			else
				this.curDbPage = 1;
			getDataFromDB();
			this.curPage = 1;
		}
		// 需要从数据库中取数据(向后取数据)
		if (this.curPage == -3) {
			if (this.curDbPage < this.maxDbPage)
				this.curDbPage = this.curDbPage + 1;
			else
				this.curDbPage = this.maxDbPage;
			getDataFromDB();
			this.curPage = 1;
		}
		// 需要从数据库中取数据(最后的数据)
		if (this.curPage == -4) {
			this.curDbPage = this.maxDbPage;
			getDataFromDB();
			this.curPage = 1;
		}

		// 本次数据的起始页码
		this.displayPageNumber = (this.curDbPage - 1) * this.multiple;
		// 还需要判断如果数据不够的处理！
		int i_vectorsize = dataFromDB.size();
		int rows = (this.curPage - 1) * this.rowsPerPage;
		int i_shouldsize = rows + this.rowsPerPage;
		if (i_vectorsize < i_shouldsize)
			i_shouldsize = i_vectorsize;

		for (int i = rows; i < i_shouldsize; i++) {
			pageData.add(this.dataFromDB.get(i));
		}
		return pageData;
	}

	// 从数据库得到数据
	private Vector getDataFromDB() {
		dataFromDB.clear();
		CallableStatement proc = null;
		try {
			proc = conn
					.prepareCall("{call GetRecordFromPage(?,?,?,?,?,?,?,?)}");
			proc.setString(1, this.s_TableName);
			proc.setString(2, this.s_FieldsName);
			proc.setString(3, this.s_OrderFieldName);
			proc.setInt(4, this.rowsPerGetDB);
			proc.setInt(5, this.curDbPage);
			proc.setInt(6, 0);
			proc.setInt(7, this.i_desc);
			proc.setString(8, this.s_WhereCondition);
			ResultSet rs = proc.executeQuery();
			while (rs.next()) {
				Object[] obj = new Object[this.i_FieldsCount];
				for (int i_count = 1; i_count <= this.i_FieldsCount; i_count++) {
					obj[i_count - 1] = rs.getObject(i_count);
				}
				dataFromDB.add(obj);
			}
			rs.close();
			proc.close();
		} catch (SQLException ex) {
			System.out.println("调用存储过程获得数据错误:" + ex.toString());
		}
		// 判断一下从数据库中取出来的数据总数，计算出当前从数据库中取出的数据能够显示页数！
		int i_V_size = dataFromDB.size();
		if ((i_V_size % this.rowsPerPage) == 0)
			this.pageSumFromDBVector = i_V_size / this.rowsPerPage;
		else
			this.pageSumFromDBVector = i_V_size / this.rowsPerPage + 1;
		this.getSumPage();// 每次从数据库中取数据，最好调用一下这个函数，以便得到数据库中最新的行数
		return dataFromDB;
	}

	// 获得满足条件的记录总数
	private void getDataSumCount() {
		CallableStatement proc = null;
		this.sumRows = 0;
		try {
			proc = conn
					.prepareCall("{call GetRecordFromPage(?,?,?,?,?,?,?,?)}");
			proc.setString(1, this.s_TableName);
			proc.setString(2, "");
			proc.setString(3, "");
			proc.setInt(4, 0);
			proc.setInt(5, 0);
			proc.setInt(6, 1);
			proc.setInt(7, 0);
			proc.setString(8, this.s_WhereCondition);
			ResultSet rs = proc.executeQuery();
			while (rs.next()) {
				this.sumRows = rs.getInt(1);
			}
			rs.close();
			proc.close();

		} catch (SQLException ex) {
			System.out.println("调用存储过程获得总行数错误：" + ex.toString());
		}
	}

	// 计算总页数
	private void countMaxPage() {
		// 计算从数据库中可以取数据的总页数
		if (this.sumRows % this.rowsPerGetDB == 0) {
			this.maxDbPage = this.sumRows / this.rowsPerGetDB;
		} else {
			this.maxDbPage = this.sumRows / this.rowsPerGetDB + 1;
		}

		// 计算从数据库中的数据可以显示的总页数
		if (this.sumRows % this.rowsPerPage == 0) {
			this.maxPage = this.sumRows / this.rowsPerPage;
		} else {
			this.maxPage = this.sumRows / this.rowsPerPage + 1;
		}

	}

	// 返回总页数
	private void getSumPage() {
		getDataSumCount();
		countMaxPage();
	}

	// 关闭数据库连接
	public void ColseConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
	}

	public CbestPageBean(int curDbPage, int maxDbPage, int sumRows,
			int curPage, int maxPage, int displayPageNumber, int multiple,
			int rowsPerPage, int rowsPerGetDB, int pageSumFromDBVector,
			Vector pageData, Vector dataFromDB, Connection conn, int i_desc,
			String whereCondition, String orderFieldName, String tableName,
			String fieldsName, int fieldsCount) {
		super();
		// TODO Auto-generated constructor stub
		this.curDbPage = curDbPage;
		this.maxDbPage = maxDbPage;
		this.sumRows = sumRows;
		this.curPage = curPage;
		this.maxPage = maxPage;
		this.displayPageNumber = displayPageNumber;
		this.multiple = multiple;
		this.rowsPerPage = rowsPerPage;
		this.rowsPerGetDB = rowsPerGetDB;
		this.pageSumFromDBVector = pageSumFromDBVector;
		this.pageData = pageData;
		this.dataFromDB = dataFromDB;
		this.conn = conn;
		this.i_desc = i_desc;
		s_WhereCondition = whereCondition;
		s_OrderFieldName = orderFieldName;
		s_TableName = tableName;
		s_FieldsName = fieldsName;
		i_FieldsCount = fieldsCount;
	}

}
