package com.tsinghuait.st0717.hospitalsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.tsinghuait.st0717.hospitalsystem.dao.SQLConnection;
import com.tsinghuait.st0717.hospitalsystem.dto.Stat;

public class Stat1Service {
	private int rowsCount = 0;
	private int pageCount = 0;
	public Collection searchReceiptsByName(String sql) {
		Collection<Stat> col = null;
		try {
			Statement st=new SQLConnection().getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery(sql);
			if (rs != null) {
				col = new ArrayList<Stat>();
				 while (rs.next()){
					Stat dto = new Stat();
					dto.setItems(rs.getString("items"));
					dto.setPay(rs.getFloat("pay"));
					dto.setPayee(rs.getString("payee"));
					dto.setName(rs.getString("name"));
					dto.setPdate(rs.getDate("pdate"));
					dto.setIsFinished(rs.getByte("isFinished"));
					col.add(dto);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(rowsCount + "ÐÐ");
		return col;
	}
}
