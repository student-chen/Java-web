package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.dto.PagePagination;
import com.tsinghuait.st0717.hospitalsystem.service.DoctorPostService;
import com.tsinghuait.st0717.hospitalsystem.service.MedicalcoursesService;
import com.tsinghuait.st0717.hospitalsystem.service.NursePostService;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class TopQueryServlet extends BaseServltes{
	/**
	 * 1.查看医生护士的部分信息（select方法）
	 * 2.对科室表进行查询，返回到挂号页面的科室下列表中（executeQuery方法）
	 * 3.对挂号的病人信息进行保存(insert方法 )
	 * */
	protected RequestDispatcher delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String oid=arg0.getParameter("oid");
		if(oid==null){
			oid="0";
		}
		int id=Integer.parseInt(oid);
		String sql="select *from patient where oid = "+id+"";
		System.out.println("Patient_sql:"+sql);
		PatientService patientService=new PatientService();
		arg0.setAttribute("patientDoctorHref",patientService.selePatient(sql));
		RequestDispatcher rd=arg0.getRequestDispatcher("view/patientSelect.jsp");
		return rd;
	}
	/*
	 * 对科室表进行查询，返回到挂号页面的科室下列表中
	 * */
	protected RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String type=arg0.getParameter("type");
		String sql1="";
		System.out.println("type:"+type);
		if(type.equals("1")||type=="1"){
			sql1="select *from medicalcourses where type=1 order by name";
		}else{
			sql1="select *from medicalcourses where type=0 order by name";			
		}		
		System.out.println("sql1====="+sql1);
		MedicalcoursesService medicalcoursesService=new MedicalcoursesService();
		arg0.setAttribute("medicalcoursesNameSelected",medicalcoursesService.selectRowsMedicalcourses(sql1));
		arg0.setAttribute("type",type);
		RequestDispatcher rd=arg0.getRequestDispatcher("/view/patientRegister.jsp");
		return rd;
	}
	//挂号信息提交
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException,IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		String mcid=arg0.getParameter("mcid");//得不到值
		String mcName=arg0.getParameter("mcName");
		String patientNo=new String(arg0.getParameter("patientNo").trim().getBytes("iso-8859-1"),"gbk");
		String name=arg0.getParameter("name");
		String sex=arg0.getParameter("sex");
		String age=arg0.getParameter("age");
		String address=arg0.getParameter("address");
		String isfinished=arg0.getParameter("isfinished");
		int mid=0,p_age=0;
		int pisfinished=0;
		if(mcid==null||mcid.equals("null")){
			mcid="0";
		}
		mid=Integer.parseInt(mcid);
		if(age==null||age.equals("null")){
			age="0";
		}
		p_age=Integer.parseInt(age);
		if(isfinished==null||isfinished.equals("null")||isfinished=="是"||isfinished.equals("是")){		
			isfinished="0";
		}else{
			isfinished="1";
		}
		pisfinished=Integer.parseInt(isfinished);
		String sql="insert into patient values('"+patientNo+"','"+name+"','"+sex+"','"+address+"',"+p_age+","+pisfinished+","+mid+",'"+mcName+"')";
		System.out.println("TopQueryServlet--sql:"+sql);	
		PatientService patientService=new PatientService();
		int num=patientService.execteUpdate(sql);
		if(num==0){
			JOptionPane.showMessageDialog(null,"挂号失败！！!");
			System.out.println("挂号失败！！");
			arg0.getRequestDispatcher("/patientRegister.jsp").include(arg0, arg1);
			return null;
		}else{
			JOptionPane.showMessageDialog(null,"挂号成功,请前往相应科室请求医生的帮助!");
		}
		arg0.getSession().setAttribute("locationURL", "topQueryServlet?opertion=0&type=0");
        RequestDispatcher rd=arg0.getRequestDispatcher("/submits.jsp");
		//RequestDispatcher rd=arg0.getRequestDispatcher("topQueryServlet?opertion=0&type=0");
		return rd;
	}
	//对表头处理
	protected RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		String scoutSort=new String(arg0.getParameter("scoutSort").trim().getBytes("ISO-8859-1"),"gbk");	
		String name=arg0.getParameter("hospitalname");
		DoctorPostService doctorPostService=new DoctorPostService();
		String sql="select *from viewDoctorPost where "+scoutSort+" like '"+name+"'";
		System.out.println("sql:"+sql);
		arg0.setAttribute("doctorPostServiceNurse",doctorPostService.selectViewDoctorPost(sql,1,100));
		RequestDispatcher rd=arg0.getRequestDispatcher("/doctorNursePost.jsp");
		return rd;
	}
	//对护士信息查看
	protected RequestDispatcher update(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		int page=1;
		int pageSize=5;
		String name=arg0.getParameter("name");
		String scoutSort=arg0.getParameter("scoutSort");
		if(scoutSort==null||scoutSort.equals("null")||scoutSort==""){
			scoutSort="name";
		}
		if(name==null||name.equals("null")||name==""){
			name="";
		}
		if(arg0.getParameter("page")!=null){
			page=Integer.parseInt(arg0.getParameter("page"));
			System.out.println("page:========="+page);
		}
		String sql="select * from viewNursePost where "+scoutSort+" like '%"+name+"%'";
		System.out.println("sql:"+sql);
		NursePostService nursePostService=new NursePostService();
		arg0.setAttribute("viewNursePost",nursePostService.selectViewNursePost(sql, page, pageSize));
		
		PagePagination pf=new PagePagination();
		pf.setPageNum(nursePostService.getRowsPages());
		pf.setPageCount(nursePostService.getPageCount());
		if(page<nursePostService.getPageCount()){
			pf.setNextPage(page+1);
		}else{
			pf.setNextPage(nursePostService.getPageCount());
		}
		if(page>1){	//上一页的值
			pf.setPriorPage(page-1);
		}else{
			pf.setPriorPage(1);			
		}
		pf.setLastPage(nursePostService.getPageCount());
		if(page>=pf.getLastPage()){///判断它是否大于最后一页
			page=pf.getLastPage();
		}
		pf.setPageSize(page);
		arg0.setAttribute("page",pf);
		RequestDispatcher rd=arg0.getRequestDispatcher("/nurseList.jsp");
		return rd;
	}	
}