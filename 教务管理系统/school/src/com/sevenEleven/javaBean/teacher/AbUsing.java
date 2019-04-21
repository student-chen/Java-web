package com.sevenEleven.javaBean.teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
public abstract class AbUsing implements Using {
	private SQL DB=new SQL();
	@SuppressWarnings("unchecked")
	public List GetRecord(ResultSet rs){
		List rows=new LinkedList();
		try {
			while (rs.next()){
				List row=new LinkedList();
				for (int i=0;i<rs.getMetaData().getColumnCount();i++){
					row.add(rs.getString(i+1));
				}
				rows.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return rows;
	}
	
	@SuppressWarnings("unchecked")
	public List GetRecord(String strSQL){
		return GetRecord(DB.ExeSelect(strSQL));
	}
	
	public void Close(){
		DB.Close();
	}
	
	public int ExecuteUpdate(String strSQL){
		return DB.ExeUpdate(strSQL);
	}
	
	public boolean CheckBool(String strSQL){
		try {
			if (DB.ExeSelect(strSQL).next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	public ResultSet GetResult(String strSQL){
		return DB.ExeSelect(strSQL);
	}

}
