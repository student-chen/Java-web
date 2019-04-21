package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;

import model.PageBean;

public class ServletStuSum extends HttpServlet{
	
	private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo=1;
		int pageCount=2;
		
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
	
		
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		
	
		PageBean list=studentServiceImpl.stuListPage(pageNo, pageCount);
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/stuScore.jsp").forward(request, response);
	}

}
