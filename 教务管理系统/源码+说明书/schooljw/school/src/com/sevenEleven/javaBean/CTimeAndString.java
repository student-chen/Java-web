package com.sevenEleven.javaBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CTimeAndString {

	/**
	 * @param args
	 */
	/*** 取得系统时间  ***/
	public String getCurrentlyTime(){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = f.format(new Date());
		return time;
		
	}
	/*** 取得两个日期的天数  ***/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
