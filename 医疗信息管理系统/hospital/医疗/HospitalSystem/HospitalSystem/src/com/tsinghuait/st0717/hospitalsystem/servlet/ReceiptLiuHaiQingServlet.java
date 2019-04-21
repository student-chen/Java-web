package com.tsinghuait.st0717.hospitalsystem.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.dto.PageFairy;
import com.tsinghuait.st0717.hospitalsystem.service.ReceiptService;

public class ReceiptLiuHaiQingServlet extends BaseServlet {
	RequestDispatcher rd=null;
	private ReceiptService receiptService;
	public ReceiptLiuHaiQingServlet()
	{
		receiptService=new ReceiptService();
	}
	/**
	 * 删除
	 * 
	 * */
	public RequestDispatcher delete(HttpServletRequest request,
			HttpServletResponse response) {
		rd = request.getRequestDispatcher("receiptLiuHaiQingServlet?operation=0");
		return rd;
	}
	public RequestDispatcher save(HttpServletRequest request,
			HttpServletResponse response) {
		rd = request.getRequestDispatcher("receiptLiuHaiQingServlet?operation=0");
		return null;
	}

	/**
	 * 查看收据
	 * 
	 * */
	public RequestDispatcher search(HttpServletRequest request,
			HttpServletResponse response) {
		int page=1;
		int pageSize=2;
		if (request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		String sql = "select * from stat where isFinished=1";
		PageFairy pf=new PageFairy();
		
		request.setAttribute("receiptlist", receiptService.searchReceiptsByName(sql,page,pageSize));
		pf.setRowsCount(receiptService.getRowsCount());
		pf.setPageCount(receiptService.getPageCount());
		//下一页
		if(page<receiptService.getPageCount())
		{
			pf.setNextpage(page+1);
		}else
		{
			pf.setNextpage(receiptService.getPageCount());
		}
		//上一页
		if(page>1)
		{
			pf.setPriorPage(page-1);
		}else
		{
			pf.setPriorPage(1);
		}
		pf.setPage(page);
		request.setAttribute("pageFairy",pf);
		rd=request.getRequestDispatcher("view_liuhaiqing/receiptsList.jsp");
		return rd;
	}
}