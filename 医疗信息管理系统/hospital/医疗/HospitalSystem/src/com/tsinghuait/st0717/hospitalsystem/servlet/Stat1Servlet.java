package com.tsinghuait.st0717.hospitalsystem.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsinghuait.st0717.hospitalsystem.dto.PageFairy;
import com.tsinghuait.st0717.hospitalsystem.service.Stat1Service;

public class Stat1Servlet extends BaseServlet {
	RequestDispatcher rd=null;
	private Stat1Service stat1Service;
	public Stat1Servlet()
	{
		stat1Service=new Stat1Service();
	}
	@Override
	public RequestDispatcher delete(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	@Override
	public RequestDispatcher save(HttpServletRequest request,
			HttpServletResponse response) {
		return null;
	}

	/**
	 * 
	 * 
	 * */
	public RequestDispatcher search(HttpServletRequest request,
			HttpServletResponse response) {
		String sta=request.getParameter("Stat");
		request.setAttribute("finish", sta);
		int Stat=0;
		if(sta!=null){
			Stat=Integer.parseInt(sta);
		}
		String sql="select * from stat where isFinished="+Stat;
		request.setAttribute("Statsptlist", stat1Service.searchReceiptsByName(sql));
		rd=request.getRequestDispatcher("view_liuhaiqing/StatList.jsp");
		return rd;
	}

}
