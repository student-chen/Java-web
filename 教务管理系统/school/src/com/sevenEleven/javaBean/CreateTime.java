package com.sevenEleven.javaBean;


public class CreateTime extends CDBConnection{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(22);
		@SuppressWarnings("unused")
		String roomNumber = new String();
		CreateTime ct = new CreateTime();
		String time = new String();
//		for(int i = 1; i < 7; i++){ 
//			for(int j = 1; j < 7; j++){  
//				for(int k =1; k < 16; k++){   
//					
//						if(k > 9){
//							roomNumber =  Integer.toString(i) + "��" + Integer.toString(j) + Integer.toString(k)+ "��";
//						}else{
//							roomNumber = Integer.toString(i) + "��" + Integer.toString(j) +  Integer.toString(0) +  Integer.toString(k) +"��";
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
				DBConn();
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
				DBConn(); 
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
