package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.dto.PagePagination;
import com.tsinghuait.st0717.hospitalsystem.service.DoctorPostService;

public class DoctorPostServlets extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0, arg1);
	}
	//对医生分页 
	protected RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		int page=1;
		int pageSize=5;
		String isActive=arg0.getParameter("isActive");
		String sql="";
		PrintWriter out=arg1.getWriter();
		if(isActive!=null){
			if(isActive=="1"||isActive.equals("1")){
				sql="select *from viewDoctorPost where isActive=1";
			}else{
				sql="select *from viewDoctorPost where isActive=0";
			}
		}else{
			System.out.println("操作错误,一秒后自动刷新！！");
			out.print("<script>alert('操作错误,一秒后自动刷新!');</script>");
			arg1.setHeader("refresh","1;url=h");		
		}
		DoctorPostService doctorPostService=new DoctorPostService();
		System.out.println("sql==========:"+sql);
		arg0.setAttribute("doctorPostServiceNurse", doctorPostService.selectViewDoctorPost(sql,page,pageSize));
		
		PagePagination pf=new PagePagination();
		pf.setPageNum(doctorPostService.getRowsPages());
		pf.setPageCount(doctorPostService.getPageCount());
		if(page<doctorPostService.getPageCount()){
			pf.setNextPage(page+1);
		}else{
			pf.setNextPage(doctorPostService.getPageCount());
		}
		if(page>1){	//上一页的值
			pf.setPriorPage(page-1);
		}else{
			pf.setPriorPage(1);			
		}
		pf.setLastPage(doctorPostService.getPageCount());
		if(page>=pf.getLastPage()){///判断它是否大于最后一页
			page=pf.getLastPage();
		}
		pf.setPageSize(page);
		arg0.setAttribute("page",pf);
		RequestDispatcher rd=arg0.getRequestDispatcher("/doctorNursePost.jsp");
		return rd;
	}
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0, arg1);
	}

	protected RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		int page=1;
		int pageSize=5;
		String scoutSort=arg0.getParameter("scoutSort");
		if(scoutSort==null||scoutSort==""){
			scoutSort="name";
		}
		String name=arg0.getParameter("name");	
		if(name==null){
			name="";
		}
		if(arg0.getParameter("page")!=null){
			page=Integer.parseInt(arg0.getParameter("page"));
			System.out.println("page:"+page);
		}
		//查看医生、科别的联合表
		String sql="select *from viewDoctorPost where "+scoutSort+" like '%"+name+"%'";
		System.out.println("sql:"+sql);
		DoctorPostService doctorPostService=new DoctorPostService();
		arg0.setAttribute("doctorPostServiceNurse",doctorPostService.selectViewDoctorPost(sql,page,pageSize));
		
		PagePagination pf=new PagePagination();
		pf.setPageNum(doctorPostService.getRowsPages());
		pf.setPageCount(doctorPostService.getPageCount());
		if(page<doctorPostService.getPageCount()){
			pf.setNextPage(page+1);
		}else{
			pf.setNextPage(doctorPostService.getPageCount());
		}
		if(page>1){	//上一页的值
			pf.setPriorPage(page-1);
		}else{
			pf.setPriorPage(1);			
		}
		pf.setLastPage(doctorPostService.getPageCount());
		if(page>=pf.getLastPage()){///判断它是否大于最后一页
			page=pf.getLastPage();
		}
		pf.setPageSize(page);
		arg0.setAttribute("page",pf);
		RequestDispatcher rd=arg0.getRequestDispatcher("/doctorNursePost.jsp");
		return rd;
	}
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		return this.select(arg0, arg1);
	}	
}