package com.sevenEleven.javaBean.teacher;
import java.util.List;
import java.sql.ResultSet;
public interface Using {
	public List GetRecord(ResultSet rs);
	public List GetRecord(String strSQL);
	public int ExecuteUpdate(String strSQL);
	public void Close();
	public boolean CheckBool(String strSQL);
	public ResultSet GetResult(String strSQL);
	
}