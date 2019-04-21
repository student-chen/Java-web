package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;
  //用于显示手术室超连接的信息
public class ShowNurseServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");	  
		int ids=1;
		if(id!=null){
			ids=Integer.parseInt(id);
		}
		String sql="select operationRoom.orNo as orNo,operationRoom.address as address,operationRoom.info as info,nurse.name as name,operationRoom.isUseable as isUseable from nurse_opertionRoom,operationRoom,nurse where nurse_opertionRoom.nurse_id=nurse.id and nurse_opertionRoom.operationRoom_id=operationRoom.id and operationRoom.id="+id+"";
		System.out.println("ShowNurseServlet_sql:"+sql);		
		OperationRoomWuJiRuiService operationRoomService=new OperationRoomWuJiRuiService(); 
	   request.setAttribute("showList",operationRoomService.getNurseListNameCollection(sql));
	   request.setAttribute("nurseNameList", operationRoomService.nurseNameList(ids));
	   request.getRequestDispatcher("/view_wujirui/listOperationRoom.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            this.doGet(request, response);  
	     }

}
