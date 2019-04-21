package com.tsinghuait.st0717.hospitalsystem.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsinghuait.st0717.hospitalsystem.dto.PagePagination;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class PatientListServlet extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		return this.select(request, response);
	}
	//按科别号查询病人的信息
	protected RequestDispatcher executeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return this.select(request, response);	
	}
	//按是否处理查询病人的信息
	protected RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		return this.select(request, response);
	}
	//模糊查看病人信息
	protected RequestDispatcher select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("num");
		String sql="";
		System.out.println("num:"+num);
		if(num==null||num==""||num.equals("null")){
			sql="select * from patient";	
		}else if(num=="1"||num.equals("1")){
			num="1";
			sql="select * from patient";	
		}else if(num=="2"||num.equals("2")){
			num="2";
			sql = "select * from patient where mcId=1";
		}else if(num=="3"||num.equals("3")){
				num="3";
				sql = "select * from patient where mcId=0";
		}else if(num=="4"||num.equals("4")){
			num="4";
			sql="select * from patient where isfinished=1";			
		}else if(num=="5"||num.equals("5")){
				num="5";
				sql="select * from patient where isfinished=0";
		}else{
			sql="select * from patient";
		}
		System.out.println("patientList_sql:"+sql);
		int page=1;
		int pageSize=5;
		String pag=request.getParameter("page");
		if(pag!=null){
			page=Integer.parseInt(pag);
		}
		PatientService dao=new PatientService();
		request.setAttribute("patientList",dao.selectPatientDTO(sql,page,pageSize));   
		PagePagination pf=new PagePagination();
		
		pf.setCurrentType(num);//记住当前的处理关键字
		System.out.println("numpf:"+pf.getCurrentType());
		pf.setPageNum(dao.getRowsPages());
		pf.setPageCount(dao.getPageCount());		
		if(page<dao.getPageCount()){	//下一页 的值
			pf.setNextPage(page+1);
		}else{
			pf.setNextPage(dao.getPageCount());
		}
		if(page>1){			//上一页的值
			pf.setPriorPage(page-1);
		}else{
			pf.setPriorPage(1);
		}
		pf.setLastPage(dao.getPageCount());			
		if(page>=pf.getLastPage()){	//判断它是否大于最后一页
			page=pf.getLastPage();
		}	
		pf.setPageSize(page);
		request.setAttribute("page", pf);
		System.out.println("curretyn:"+pf.getCurrentType());
		RequestDispatcher rd=request.getRequestDispatcher("view_zhouxiaoli/patientList.jsp");
		return rd;
	}
	//修改病人信息
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse response) throws ServletException, IOException 
	{
		String oid=arg0.getParameter("oid");
		if(oid==null){
			oid="0";
		}
		int id=Integer.parseInt(oid);
		String sql="select *from patient where oid = "+id+"";
		System.out.println("Patient_sql:"+sql);
		PatientService patientService=new PatientService();
		arg0.setAttribute("patientSelect",patientService.selePatient(sql));
		RequestDispatcher rd=arg0.getRequestDispatcher("view_zhouxiaoli/patientsSelect.jsp");
		return rd;
	}	 
}