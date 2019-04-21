package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsinghuait.st0717.hospitalsystem.service.StayInHpService;

public class StayInHpservlets extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		RequestDispatcher rd=this.select(arg0, arg1);
		return rd;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		RequestDispatcher rd=this.select(arg0, arg1);
		return rd;
	}
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		RequestDispatcher rd=this.select(arg0, arg1);
		return rd;
	}
	protected RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		Object id=null;	
		if(arg0.getParameter("id")!=null)
		{
			id=arg0.getParameter("id");
		}
		String sql="select * from stayInHp where id="+id;
		StayInHpService service=new StayInHpService();
		try {
			arg0.setAttribute("patientList", service.selectRowsStay(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=arg0.getRequestDispatcher("/stayInHpList.jsp");
		return rd;
	}
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		RequestDispatcher rd=this.select(arg0, arg1);
		return rd;
	}
}
