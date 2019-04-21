package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.Page;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_updateOrDeleteTestServlet
 * 
 */
public class Cexam_updateOrDeleteTestServlet extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5540700906168746917L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_updateOrDeleteTestServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Cexam exam = new Cexam();
		// 分页问题:
		// 1.如何判定第一次访问.用session不行.但request中不能把对象连传.用分类的麻烦
		// 2.javaScipt提交菜单的问题,提交不了.
		// 3.curPage 这个当前页变题的提取的问题,当用javaScipe提交就没有问题.
		// 如何实现:用JavaScipt,但是判断是否为初使行还有待解决,还是用两个
		// request.getSession().getAttribute("teacher");
		// 初使化,显示第一页
//必修课选择题的显示
		Page choose1Page = new Page();
		List choose1List = null;
		int maxChoose1RowCount = exam.getLengthOfChoose1Table();// choose1表共有多少行
		choose1Page.setCurPage(1); // 为course1Page这个Bean设置当前页为1
		choose1Page.setRowsPerPage(15); // 为course1Page这个Bean设置每页为15条数据.
		choose1Page.setFormName("choose1Form"); // 为course1Page这个Bean设置FormName
		choose1Page.setMaxRowCount(maxChoose1RowCount); // 为course1Page这个Bean设置记录中共有多少行.
		
		if (maxChoose1RowCount % 15 == 0) {// 为course1Page这个Bean设置最大页数.
			choose1Page.setMaxPage(maxChoose1RowCount / 15 );//当总页数能整除每页数据条数时
		} else {
			choose1Page.setMaxPage(maxChoose1RowCount / 15 + 1);//否则
		}
		choose1Page.setTarget("CflushExam_updateOrDeleteTestServlet");// 为choose1Page这个Bean要跳转的servlet,就是本页.
		choose1List = exam.getChoose1Table(1, 15); // 取出初使化的当前页面要显示的记录.
		request.getSession().setAttribute("choose1Page", choose1Page);
		request.setAttribute("choose1List", choose1List);
		request.setAttribute("choose1ToString",choose1Page.toString());
		request.setAttribute("choose1PageStr", choose1Page.getPageStr());
		//选修选择题
		int maxChoose2RowCount = exam.getLengthOfChoose2Table();
		List choose2List = exam.getChoose2Table(1,maxChoose2RowCount);
		request.setAttribute("choose2List", choose2List);
		//必修填空题
		int maxText1RowCount = exam.getLengthOfText1Table();
		List text1List = exam.getText1Table(1,maxText1RowCount);
		request.setAttribute("text1List", text1List);
		//选修填空题
		int maxText2RowCount = exam.getLengthOfText2Table();
		List text2List = exam.getText2Table(1,maxText2RowCount);
		request.setAttribute("text2List", text2List);
//		//选修课选择题的显示
//		Page choose2Page = new Page();
//		List choose2List = null;
//		int maxChoose2RowCount = exam.getLengthOfChoose2Table();// choose2表共有多少行
//		choose2Page.setCurPage(1); // 为course2Page这个Bean设置当前页为1
//		choose2Page.setRowsPerPage(15); // 为course2Page这个Bean设置每页为15条数据.
//		choose2Page.setFormName("choose2Form"); // 为course2Page这个Bean设置FormName
//		choose2Page.setMaxRowCount(maxChoose2RowCount); // 为course2Page这个Bean设置记录中共有多少行.
//		
//		if (maxChoose2RowCount % 15 == 0) {// 为course2Page这个Bean设置最大页数.
//			choose2Page.setMaxPage(maxChoose2RowCount / 15 );//当总页数能整除每页数据条数时
//		} else {
//			choose2Page.setMaxPage(maxChoose2RowCount / 15 + 1);//否则
//		}
//		choose2Page.setTarget("CflushExam_updateOrDeleteTestServlet");// 为choose2Page这个Bean要跳转的servlet,就是本页.
//		choose2List = exam.getChoose2Table(1, 15); // 取出初使化的当前页面要显示的记录.
//		request.getSession().setAttribute("choose2Page", choose2Page);
//		request.setAttribute("choose2List", choose2List);
//		request.setAttribute("choose2ToString",choose2Page.toString());
//		request.setAttribute("choose2PageStr", choose2Page.getPageStr());
////		必修课填空题的显示
//		Page text1Page = new Page();
//		List text1List = null;
//		int maxText1RowCount = exam.getLengthOfText1Table();
//		text1Page.setCurPage(1); 
//		text1Page.setRowsPerPage(15); 
//		text1Page.setFormName("text1Form"); 
//		text1Page.setMaxRowCount(maxText1RowCount); 
//		
//		if (maxText1RowCount % 15 == 0) {
//			text1Page.setMaxPage(maxText1RowCount / 15 );
//		} else {
//			text1Page.setMaxPage(maxText1RowCount / 15 + 1);
//		}
//		text1Page.setTarget("CflushExam_updateOrDeleteTestServlet");
//		text1List = exam.getText1Table(1, 15); 
//		request.getSession().setAttribute("text1Page", text1Page);
//		request.setAttribute("text1List", text1List);
//		request.setAttribute("text1ToString",text1Page.toString());
//		request.setAttribute("text1PageStr", text1Page.getPageStr());
////		选修课填空题的显示
//		Page text2Page = new Page();
//		List text2List = null;
//		int maxText2RowCount = exam.getLengthOfText2Table();
//		text2Page.setCurPage(1); 
//		text2Page.setRowsPerPage(15); 
//		text2Page.setFormName("text2Form"); 
//		text2Page.setMaxRowCount(maxText2RowCount); 
//		
//		if (maxText2RowCount % 15 == 0) {
//			text2Page.setMaxPage(maxText2RowCount / 15 );
//		} else {
//			text2Page.setMaxPage(maxText2RowCount / 15 + 1);//否则
//		}
//		text2Page.setTarget("CflushExam_updateOrDeleteTestServlet");
//		text2List = exam.getText2Table(1, 15); 
//		request.getSession().setAttribute("text2Page", text2Page);
//		request.setAttribute("text2List", text2List);
//		request.setAttribute("text2ToString",text2Page.toString());
//		request.setAttribute("text2PageStr", text2Page.getPageStr());
		// 初使化跳转
		request.getRequestDispatcher("exam_updateOrDeleteTest.jsp").forward(
				request, response);
	}
}