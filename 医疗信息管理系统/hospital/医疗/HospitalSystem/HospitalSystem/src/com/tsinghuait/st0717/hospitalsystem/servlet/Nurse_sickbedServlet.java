package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.Nurse_sickbedService;

public class Nurse_sickbedServlet extends BaseServltes{
	protected RequestDispatcher executeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=this.select(request,response);
		return rd;
	}
	//按护士姓名查询其编号
	protected RequestDispatcher select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String sql="select * from nurse where name = '"+name+"'";
		System.out.println("nurse_sql:"+sql);
		Nurse_sickbedService ns=new Nurse_sickbedService();
		int id=ns.execteUpdate(sql);
		
		String sql1="select sickbed_id from nurse_sickbed where nurse_id="+id+"";
		int bedId=ns.execte(sql1);
		System.out.println("sickbed_sql:"+sql1+"\n id:"+id+"　bedId:"+bedId);
		ArrayList arr=new ArrayList();
		arr.add(id);
		arr.add(name);
		arr.add(bedId);	
		request.setAttribute("MybedList",arr);
		RequestDispatcher rd=request.getRequestDispatcher("view_zhouxiaoli/nurse_sickbedList.jsp");
		return rd;
	}
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0,arg1);
	}
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0,arg1);
	}
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0,arg1);
	}
}
