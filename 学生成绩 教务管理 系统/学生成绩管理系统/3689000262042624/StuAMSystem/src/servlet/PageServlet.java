package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;

import dao.Impl.EmpBiz;

public class PageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		EmpBiz biz=new EmpBiz();
		int pageNo=1;
		int pageCount=3;
		int totalPage=0;
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
		String totalPageStr=request.getParameter("totalPage");
		if(totalPageStr!=null){
			totalPage=Integer.parseInt(totalPageStr);
		}
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
			
			if(pageNo==0){
				pageNo=1;
			}else if(pageNo>totalPage  || pageNo==totalPage){
				pageNo=totalPage;
			}
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		
		PageBean pageBean=biz.listEmps(pageNo, pageCount);
		request.setAttribute("list", pageBean);
		request.getRequestDispatcher("admin/userAllInfo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}
