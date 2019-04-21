package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.ReceiptService;

public class ReceiptServlet extends BaseServltes {
	RequestDispatcher rd=null;
	private ReceiptService receiptService;
	public ReceiptServlet(){
		receiptService=new ReceiptService();
	}
	/**
	 * 查看收据
	 * 
	 * */
	public RequestDispatcher search(HttpServletRequest request,
			HttpServletResponse response) {
		String sql="select * from receipt where isFinished=0";
		request.setAttribute("receiptlist", receiptService.searchPostsByName(sql));
		rd=request.getRequestDispatcher("view_zhouxiaoli/receiptsList.jsp");
		return rd;
	}
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String isFinished=arg0.getParameter("isFinished");
		String sql="delect from receipt where isFinished=1";
		ReceiptService receiptService=new ReceiptService();
		arg0.setAttribute("receiptList",receiptService.selectReceipt(sql));
		return arg0.getRequestDispatcher("view_zhouxiaoli/receiptList.jsp");
	}
	protected RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0, arg1);	
	}
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String isFinished=arg0.getParameter("isFinished");
		String sql="select * from receipt";
		if ("true".equals(isFinished)){
			sql = "select * from receipt where isFinished=1";
		} else if ("false".equals(isFinished)){
			sql = "select * from receipt where isFinished=0";
		}
		ReceiptService receiptService=new ReceiptService();
		arg0.setAttribute("receiptList",receiptService.selectReceipt(sql));
		return arg0.getRequestDispatcher("view_zhouxiaoli/receiptList.jsp");
	}
	protected RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String isFinish=arg0.getParameter("isFinsh");
		String sql="";
		if(isFinish==null||isFinish==""||isFinish.equals("null")){
			sql="select * from receipt where isFinished=0";
		}else if(isFinish=="1"||isFinish.equals("1")){
			 sql="select * from receipt where isFinished=1";
		}else{
			 sql="select * from receipt where isFinished=0";
		}
		ReceiptService receiptservice=new ReceiptService();
		arg0.setAttribute("receiptList",receiptservice.selectReceipt(sql));   
		RequestDispatcher rd=arg0.getRequestDispatcher("view_zhouxiaoli/receiptList.jsp");
		return rd;
	}
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String payMoney=arg0.getParameter("payMoney");
		String id=arg0.getParameter("id");
		float money=0f;
		int ids=0;
		if(payMoney!=null){
			money=Integer.parseInt(payMoney);
		}
		if(id!=null){			
			ids=Integer.parseInt(id);
		}
		String sql="update receipt set pay="+money+",isFinished=1 where id="+ids+"";
		System.out.println("update_sql:"+sql);
		ReceiptService receiptService=new ReceiptService();
		int num=receiptService.execteUpdate(sql);
		if(num==0){
			System.out.println("添加收据失败....");
		}else{
			System.out.println("添加收据成功");
		}  
		String sql1="select * from receipt where isFinished=0";
		arg0.setAttribute("receiptList",receiptService.selectReceipt(sql1));   
		RequestDispatcher rd=arg0.getRequestDispatcher("view_zhouxiaoli/receiptList.jsp");
		return rd;
	}
}