package com.sevenEleven.javaBean.admin_test;

public class CTimeClassUnit {
	private String time;   
	private String standardTime; 
	private String c_id;      
	private String t_id;      
	private String l1_id;     
   public CTimeClassUnit(){
	   time = null;
	   standardTime = null;
	   c_id = null;
	   t_id = null;
	   l1_id = null;
   }
	public static void main(String[] args) {
		

	}


	public String getC_id() {
		return c_id;
	}


	public void setC_id(String c_id) {
		this.c_id = c_id;
	}


	public String getL1_id() {
		return l1_id;
	}


	public void setL1_id(String l1_id) {
		this.l1_id = l1_id;
	}




	public String getT_id() {
		return t_id;
	}


	public void setT_id(String t_id) {
		this.t_id = t_id;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getStandardTime() {
		return standardTime;
	}


	public void setStandardTime(String standardTime) {
		this.standardTime = standardTime;
	}

}
