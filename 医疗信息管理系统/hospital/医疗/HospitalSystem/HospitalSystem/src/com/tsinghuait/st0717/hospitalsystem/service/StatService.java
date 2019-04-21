package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Stat;

public class StatService {
	private int rowsCount = 0;
	private int pageCount = 0;
	public Collection searchReceiptByDate(String sql,int page,int pageSize) {
		Collection<Stat> col=null;
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
					Stat dto = new Stat();
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
	// 返回显示页的显示行
	public int getPageCount() {
		return pageCount;
	}

	// 返回所有行
	public int getRowsCount() {
		return this.rowsCount;
	}
}
