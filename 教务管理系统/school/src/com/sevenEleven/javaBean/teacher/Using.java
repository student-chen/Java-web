package com.sevenEleven.javaBean.teacher;
import java.sql.ResultSet;
import java.util.List;
public interface Using {
	@SuppressWarnings("unchecked")
	public List GetRecord(ResultSet rs);
	@SuppressWarnings("unchecked")
	public List GetRecord(String strSQL);
	public int ExecuteUpdate(String strSQL);
	public void Close();
	public boolean CheckBool(String strSQL);
	public ResultSet GetResult(String strSQL);
	
}