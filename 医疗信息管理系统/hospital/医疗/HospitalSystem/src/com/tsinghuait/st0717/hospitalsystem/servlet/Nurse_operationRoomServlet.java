package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.Nurse_operationRoomService;

public class Nurse_operationRoomServlet extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0,arg1);
	}
	protected RequestDispatcher executeQuery(HttpServletRequest request, HttpServletResponse arg1) throws ServletException, IOException {
		RequestDispatcher rd=this.select(request, arg1);
		return rd;
	}
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0,arg1);
	}
	//通过护士编号查询手术室的编号
	protected RequestDispatcher select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("name");
		String sql="select id from nurse where name='"+name+"'";
		Nurse_operationRoomService ns=new Nurse_operationRoomService();
		int id=ns.execteUpdate(sql);

		String sql1="select operationRoom_id from nurse_opertionRoom where nurse_id='"+id+"'";
		int operationRoom_id=ns.execte(sql1);
		
		String sql2="select orNo from operationRoom where id='"+id+"'";
		String orNo=ns.execteOrNO(sql2);
		System.out.println("operationRoom_sql:"+sql1+"\n id:"+id+"　operationRoom_id:"+operationRoom_id);
		ArrayList al=new ArrayList();
		al.add(id);
		al.add(name);
		al.add(operationRoom_id);
		al.add(orNo);
		System.out.println("al:"+al);
		request.setAttribute("nurse_operationRoomList",al);
		RequestDispatcher rd=request.getRequestDispatcher("view_zhouxiaoli/nurse_operationRoomList.jsp");
 		return rd;		
	}
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0,arg1);
	}
}