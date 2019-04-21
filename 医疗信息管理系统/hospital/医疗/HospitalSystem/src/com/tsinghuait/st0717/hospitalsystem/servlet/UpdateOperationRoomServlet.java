package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsinghuait.st0717.hospitalsystem.service.OperationRoomWuJiRuiService;

public class UpdateOperationRoomServlet extends HttpServlet{
	public void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		this.doGet(arg0, arg1);
	}
	public void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String id=arg0.getParameter("id");
		int ids=1;
		if(id!=null){
		    ids=Integer.parseInt(id);
		}
	    String sql="select * from operationRoom where id="+id+"";   
	    OperationRoomWuJiRuiService operationRoom=new OperationRoomWuJiRuiService();
	    arg0.setAttribute("showOperationRoom",operationRoom.selectOperationRoom(sql));
	     arg0.setAttribute("updatenurseNameList", operationRoom.nurseNameList(ids));
	    arg0.getRequestDispatcher("view_wujirui/updateOprationRoom.jsp").forward(arg0, arg1);
	}
}
