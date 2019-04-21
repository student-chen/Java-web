package com.sevenEleven.javaBean;

import com.sevenEleven.Beans.CchooseTestBean;

public class CreateTime extends CDBConnection{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(22);
		String roomNumber = new String();
		CreateTime ct = new CreateTime();
		String time = new String();
//		for(int i = 1; i < 7; i++){  //6栋楼
//			for(int j = 1; j < 7; j++){  //6层
//				for(int k =1; k < 16; k++){   //15间教室
//					
//						if(k > 9){
//							roomNumber =  Integer.toString(i) + "栋" + Integer.toString(j) + Integer.toString(k)+ "室";
//						}else{
//							roomNumber = Integer.toString(i) + "栋" + Integer.toString(j) +  Integer.toString(0) +  Integer.toString(k) +"室";
//						}
//						
//						ct.insertClassroom(roomNumber);
//						System.out.println(roomNumber);
//						roomNumber = "";
//						
//					
//				}
//			}
//		}
       for(int i = 0; i < 20; i++){
    	   for(int j = 0; j < 5; j++){
    		   for(int k = 0; k < 5; k++ ){
    			   if(i > 9){
    				   time = "A" + Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
    			   }else{
    				   time = "A" + Integer.toString(0) + Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
    			   }
    			   ct.insertTime(time);
    			   time = "";
    		   }
    	   }
       }
	}
	public  boolean insertClassroom(String classroom) {
		try {
			sql = "insert into classroom values ('" + classroom + "')";
	
			if (con == null) {
				DBConn(); // 连接
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public  boolean insertTime(String time) {
		try {
			sql = "insert into time values ('" + time + "')";
	
			if (con == null) {
				DBConn(); // 连接
			}
			if (this.executeUpdate(sql) != 0) {
				executeUpdate("commit");
				return true;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
