package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;
public class OperationRoomWuJiRuiServlet extends BaseServltes{
	/**
	 *    吴吉瑞    
	 * 该类实现对手术室表的增、删、改、查 
	 */	
	//删除信息
	protected RequestDispatcher delete(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		   arg0.setCharacterEncoding("gbk");
		   arg1.setCharacterEncoding("gbk");
		     String id=arg0.getParameter("id");
		     String deletesql="delete from operationRoom where id="+id+"";
		     String deletenurse_opsql="delete from nurse_opertionRoom where operationRoom_id="+id+"";
		     OperationRoomWuJiRuiService operationRoom=new OperationRoomWuJiRuiService();
	       if(operationRoom.executeUpdate(deletesql)>0&&operationRoom.executeUpdate(deletenurse_opsql)>0){
	    	   JOptionPane.showMessageDialog(null,"已删除！");	  
	       }else{
	    	   JOptionPane.showMessageDialog(null,"未删除！");
	       }
	       this.select(arg0, arg1);
	      RequestDispatcher rd=arg0.getRequestDispatcher("view_wujirui/showOprtionRoom.jsp");
		return rd;
	}  
	protected RequestDispatcher executeQuery(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {	
		return this.select(arg0, arg1);
	}
	//添加手术信息
	protected RequestDispatcher insert(HttpServletRequest arg0,	HttpServletResponse arg1) throws ServletException, IOException {
		     arg0.setCharacterEncoding("gbk");
		     arg1.setCharacterEncoding("gbk");
		     OperationRoomWuJiRuiService opRoom=new OperationRoomWuJiRuiService();
		      String orNo=arg0.getParameter("orNo");
		      String address=arg0.getParameter("address");
		      String info=arg0.getParameter("info");
		      String [] nurseList=arg0.getParameterValues(("nurseName"));  
		      for (int i = 0; i < nurseList.length; i++) {		    	  
		    	  System.out.println("nurseList:"+nurseList[i]);
			  }   
		     int isUseable=Integer.parseInt(arg0.getParameter("kongxian"));
		       //int id=new OperationRoomWuJiRuiService().returnid();//获取operationRoom中的最后一条数据的ID
		      // int idss=id+1;
		      String addsql="insert into operationRoom(orNo,address,info,isUseable) values('"+orNo+"','"+address+"','"+info+"',"+isUseable+")";  
		      if(opRoom.executeUpdate(addsql)>0){
				  JOptionPane.showMessageDialog(null,"添加成功");
		      }else{
				  JOptionPane.showMessageDialog(null,"添加失败");
		      }//先向数据库中添加一条手术室（operationRoom）信息
		     
		      int id=new OperationRoomWuJiRuiService().returnid();//获取operationRoom中的最后一条数据的ID
		      //用于向nurse_opertionRoom中循环插入数据  
		      for(int j=0;j<nurseList.length;j++){      
		      String addnursesql="insert into nurse_opertionRoom(nurse_id,operationRoom_id) values("+nurseList[j]+","+id+")";   
			      if(opRoom.executeUpdate(addnursesql)>0){
			    	  arg1.getWriter().println("添加成功！");
			       }else{
				       arg1.getWriter().println("添加失败！");
					} 
		      }         
		      System.out.println("operationRoom_add_sql:"+addsql);  

		      arg1.setContentType("text/html;charset=gbk");
					    
				//arg0.getSession().setAttribute("locationURL", "view_wujirui/showOprtionRoom.jsp");
			   // RequestDispatcher rd=arg0.getRequestDispatcher("/submits.jsp");
		     this.select(arg0, arg1);
		     RequestDispatcher rd=arg0.getRequestDispatcher("view_wujirui/showOprtionRoom.jsp");
			 return rd;
	}	        
	//查询手术表 
	protected RequestDispatcher select(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		String name=arg0.getParameter("orNo");
		String isUseable=arg0.getParameter("isUseable");		
		if(isUseable==null||isUseable==""||isUseable.equals("null")){
			isUseable ="1";
		}	   
		System.out.println("isUseable:"+isUseable+"\n name:"+name);
		String sql="";
		if(name==null){	
			sql="select * from operationRoom where orNo like '%"+name+"%'";
		}
		if(name!=null){
			if(isUseable=="0"||isUseable.equals("0")){
			    sql="select * from operationRoom where isUseable=0 and orNo like '%"+name+"%'";  	
			}else if(isUseable=="1"||isUseable.equals("1")){
				sql="select * from operationRoom where isUseable=1 and orNo like '%"+name+"%'";
			}else{
				sql = "select * from operationRoom where orNo like '%"+name+"%'";
			}
		}		
		System.out.println("sql:"+sql);
	     OperationRoomWuJiRuiService operationRoomService=new OperationRoomWuJiRuiService();
		arg0.setAttribute("operationRoomList",operationRoomService.selectOperationRoom(sql));	
		arg0.setAttribute("isUseableType",isUseable.toString());
		RequestDispatcher rd=arg0.getRequestDispatcher("/view_wujirui/showOprtionRoom.jsp");
		return rd;
	}
	//修改
	protected RequestDispatcher update(HttpServletRequest arg0,
			HttpServletResponse arg1) throws ServletException, IOException {
		   arg0.setCharacterEncoding("gbk");
		   arg1.setCharacterEncoding("gbk");
		   OperationRoomWuJiRuiService operationSer=new OperationRoomWuJiRuiService();
           String id=arg0.getParameter("id");  
	       String orNo=arg0.getParameter("orNo");
           String address=arg0.getParameter("address");
           String info=arg0.getParameter("info");   
           int isUseable=Integer.parseInt(arg0.getParameter("isUseable"));
		      String [] updatenurseList=arg0.getParameterValues(("updateNurseName"));  
		      for (int i = 0; i < updatenurseList.length; i++) {		    	  
		    	  System.out.println("nurseList:"+updatenurseList[i]);
			} 

           String updatesql="update operationRoom set orNo='"+orNo+"',address='"+address+"',info='"+info+"',isUseable="+isUseable+" where id="+id+"";
           System.out.println("update_sql:"+updatesql);  
           // 首先将原来的nurse_operationRoom中的负责该的护士全部删除
           String dele="delete from nurse_opertionRoom where operationRoom_id="+id+"";
             if(new OperationRoomWuJiRuiService().executeUpdate(dele)>0){
            	 System.out.println("dddddddddddddd已删除，等待重新添加！1");
             }else{
            	 System.out.println("not dddddddddddddddd未删除！1");
             }
                  //重新添加护士信息
             for (int k=0;k<updatenurseList.length;k++){
                 String insertsql="insert into nurse_opertionRoom(nurse_id,operationRoom_id) values("+updatenurseList[k]+","+id+")";
                         if(operationSer.executeUpdate(insertsql)>0){
                      	   System.out.println("已将原护士修改了！2");
                         }else{
                      	   System.out.println("未修改 ！2");
                         }
                    }
           if(new OperationRoomWuJiRuiService().executeUpdate(updatesql)>0){
            
            	 JOptionPane.showMessageDialog(null,"已修改！");
             }else{
            
            	 JOptionPane.showMessageDialog(null,"未修改！");
             }
		   this.select(arg0, arg1);
         RequestDispatcher rd=arg0.getRequestDispatcher("view_wujirui/showOprtionRoom.jsp");
		  return rd;
	} 
}
