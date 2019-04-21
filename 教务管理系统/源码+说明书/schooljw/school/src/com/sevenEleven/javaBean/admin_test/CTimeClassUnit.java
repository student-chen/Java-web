package com.sevenEleven.javaBean.admin_test;

public class CTimeClassUnit {

	/**
	 * 时间片断类,作为排课的最小单位,为一个班排课,
	 * 就是为这个班的每一节课找到教室和(老师-课程)
	 * 所在这个类上的字段是要准备存储到表中的数据
	 */
	private String time;   //时间片断
	
	private String standardTime; //标准时间
	
	private String c_id;      //教室的id
	
	private String t_id;       //老师的id
	
	private String l1_id;       //必修课程的id
	
   public void CTimeClassUnit(){
	   time = null;
	   standardTime = null;
	   c_id = null;
	   t_id = null;
	   l1_id = null;
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
