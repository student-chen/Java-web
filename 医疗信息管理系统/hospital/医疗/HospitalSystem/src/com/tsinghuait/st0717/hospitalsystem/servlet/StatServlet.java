package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.dto.PageFairy;
import com.tsinghuait.st0717.hospitalsystem.service.StatService;

public class StatServlet extends HttpServlet {
	int page=1;
	int pageSize=2;
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		PageFairy pf=new PageFairy();
		int year=Integer.parseInt(request.getParameter("yearName"));
		int month=Integer.parseInt(request.getParameter("monthName"));
		int day=Integer.parseInt(request.getParameter("dayName"));
		int year1=Integer.parseInt(request.getParameter("yearName1"));
		int month1=Integer.parseInt(request.getParameter("monthName1"));
		int day1=Integer.parseInt(request.getParameter("dayName1"));
		if(year>year1)
		{
			response.getWriter().print("<script>alert('year')</script>");
		}
		else if(year==year1)
		{
			if(month>month1)
			{
				response.getWriter().print("<script>alert('month')</script>");
			}
			else if(month==month1)
			{
				if(day>=day1)
				{
					response.getWriter().print("<script>alert('day')</script>");
				}
				else
				{
					String sql = "select * from stat where (pdate between '" + year
					+ "-" + month + "-" + day + "' and '" + year1 + "-"
					+ month1 + "-" + day1 + "')";
					StatService statService = new StatService();
					request.setAttribute("Statsptlist", statService.searchReceiptByDate(sql,page,pageSize));
					request.getRequestDispatcher("view_liuhaiqing/StatList.jsp").forward(request,response);
				}
			}
			else
			{
				String sql = "select * from stat where (pdate between '" + year
				+ "-" + month + "-" + day + "' and '" + year1 + "-"
				+ month1 + "-" + day1 + "')";
				StatService statService = new StatService();
				request.setAttribute("Statsptlist", statService
						.searchReceiptByDate(sql,page,pageSize));
				request.getRequestDispatcher("view_liuhaiqing/StatList.jsp").forward(request,
						response);
			}
		}
		else{
			String sql = "select * from stat where (pdate between '" + year
			+ "-" + month + "-" + day + "' and '" + year1 + "-"
			+ month1 + "-" + day1 + "')";
			System.out.print(sql);
			StatService statService = new StatService();
			request.setAttribute("Statsptlist", statService
					.searchReceiptByDate(sql,page,pageSize));
			request.getRequestDispatcher("view_liuhaiqing/StatList.jsp").forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	public void init() throws ServletException {		
	}
}