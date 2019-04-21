package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import com.tsinghuait.st0717.hospitalsystem.service.OperatingRoomService;

public class OperatingRoomServlet extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String id=arg0.getParameter("id");
		int ids=0;
		if(id!=null){
			ids=Integer.parseInt(id);
		}
		String sql="delete from operationRoom where id='"+ids+"'";
		OperatingRoomService operatingRoomService=new OperatingRoomService();
		int num=operatingRoomService.exectUpdate(sql);
		RequestDispatcher rd=null;
		if(num==0){
			JOptionPane.showMessageDialog(null,"护士手术表删除失败！！!");
			rd=arg0.getRequestDispatcher("view_zhouxiaoli/nurseAllSickbedList.jsp");
		}else{
			JOptionPane.showMessageDialog(null,"护士手术表删除成功！！!");
			rd=arg0.getRequestDispatcher("operatingRoomServlet?opertion=4");
		}
		return rd;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest request, HttpServletResponse arg1) throws ServletException, IOException
	{
		String sql="select * from operationRoom";
		OperatingRoomService operatingRoomservice=new OperatingRoomService();
		request.setAttribute("operatingRoomList",operatingRoomservice.selectOperationRoom(sql));
		return request.getRequestDispatcher("view_zhouxiaoli/operatingRoomList.jsp");
	}
	//按手术室的空闲程度查询
	protected RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isUseable=request.getParameter("isUseable");
		String sql="select * from operationRoom";
		if ("true".equals(isUseable)){
			sql = "select * from operationRoom where isUseable=1";
		} 
		else if("false".equals(isUseable)){
			sql="select * from operationRoom where isUseable=0";
		}
		OperatingRoomService or=new OperatingRoomService();
		request.setAttribute("operatingRoomList", or.selectOperationRoom(sql));
		return request.getRequestDispatcher("view_zhouxiaoli/operatingRoomList.jsp");
	}
	//查看手术室的信息
	protected RequestDispatcher select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sql="select * from operationRoom where isUseable=1";
		OperatingRoomService operatingRoomservice=new OperatingRoomService();
		request.setAttribute("operatingRoomList",operatingRoomservice.selectOperationRoom(sql));
		return request.getRequestDispatcher("view_zhouxiaoli/nurseAllSickbedList.jsp");
	}
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String orNo=arg0.getParameter("orNo");
		String address=arg0.getParameter("address");
		String info=arg0.getParameter("info");
		String isUseable=arg0.getParameter("r");
		String sql="insert into operationRoom(orNo,address,info,isUseable) values('"+orNo+"','"+address+"','"+info+"',"+isUseable+")";
		OperatingRoomService operatingRoomService=new OperatingRoomService();
		System.out.println("operationRoom_update_sql:"+sql);
		int num=operatingRoomService.exectUpdate(sql);
		RequestDispatcher rd=null;
		if(num==0){
			JOptionPane.showMessageDialog(null,"护士手术表添加失败！！!");
			arg0.getSession().setAttribute("locationURL", "view_zhouxiaoli/operatingRoom.jsp");
			//rd=arg0.getRequestDispatcher("view_zhouxiaoli/operatingRoom.jsp");
		}else{
			JOptionPane.showMessageDialog(null,"护士手术表添加成功！！!");
			arg0.getSession().setAttribute("locationURL", "operatingRoomServlet?opertion=0");
			//rd=arg0.getRequestDispatcher("operatingRoomServlet?opertion=0");
		}
		return rd=arg0.getRequestDispatcher("/submits.jsp");
	}
}