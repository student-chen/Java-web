package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.dto.PagePagination;
import com.tsinghuait.st0717.hospitalsystem.service.MedicalcoursesService;
public class MedicalcoursesServlets extends BaseServltes{
	//删除科别表信息
	protected RequestDispatcher delete(HttpServletRequest request, HttpServletResponse arg1) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		MedicalcoursesService ds=new MedicalcoursesService();
		RequestDispatcher rd=null;
		if(id==null){
			String idl=request.getParameter("doctorid");
			String []ids=idl.split(";");			
			System.out.println("idl:"+idl+"\n ids[]:"+ids.toString());			
		    int num=ds.deleteDoctorBatch(ids);		    
		    System.out.println("num:"+num);
			rd=request.getRequestDispatcher("view_ludan/medicalcoursesList.jsp");
		}else{
			ds.deleteById(id);
			System.out.println("删除成功...");
			rd=request.getRequestDispatcher("view_ludan/medicalcoursesList.jsp");
		}
		return rd;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		RequestDispatcher rd=this.select(arg0, arg1);
		return rd;
	}
	//添加科别表信息
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String name=arg0.getParameter("name");
		String type=arg0.getParameter("type");
		System.out.println("name:"+name);
		System.out.println("type:"+type);
		MedicalcoursesService service=new MedicalcoursesService();
		int num=service.insertMedicalcourses(name, type);
		if(num==0){
			System.out.println("添加失败.....");
			arg0.getRequestDispatcher("view_ludan/addMedicalcourses.jsp").forward(arg0, arg1);
		}	
		arg0.getSession().setAttribute("locationURL", "medicalcoursesServlets?opertion=4");
        RequestDispatcher rd=arg0.getRequestDispatcher("/submits.jsp");
		/*RequestDispatcher rd=arg0.getRequestDispatcher("/medicalcoursesServlets?opertion=4");
		return rd;*/
        return rd;
	}
	//查询科别表信息
	protected RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String name=null;	
		String type=arg0.getParameter("type");
		int page=1;
		int pageSize=10;
		String pag=arg0.getParameter("page");
		if(pag!=null){
			page=Integer.parseInt(pag);
		}
		String sql="";
		if(arg0.getParameter("name")!=null){
			name=arg0.getParameter("name");
		}else{
			name="";
		}
		System.out.println("type;"+type);
		if(type==null||type==""){
			sql="select * from medicalcourses where name like '%"+name+"%'";			
		}else if(type=="1"||type.equals("1")){
			sql="select * from medicalcourses where name like '%"+name+"%' and type=1";
		}else{
			sql="select * from medicalcourses where name like '%"+name+"%' and type=0";
		}
		System.out.println("sql:"+sql);
		MedicalcoursesService dao=new MedicalcoursesService();
		arg0.setAttribute("medicalcoursesList", dao.selectRowsMedicalcourses(sql,page,pageSize));
		arg0.setAttribute("typeCordoba",type);

		PagePagination pf=new PagePagination();	
		pf.setCurrentType(type);
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
		arg0.setAttribute("page", pf);
		RequestDispatcher rd=arg0.getRequestDispatcher("view_ludan/medicalcoursesList.jsp");
		return rd;
	} 
	//修改科别表信息
	protected RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		String id=request.getParameter("id");	
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		System.out.println("update_type:"+type);
		int ids=0;
		if(id!=null){
			ids=Integer.parseInt(id);
		}
		if(type.equals("内科")||type==null||type==""||type=="内科"){
			type="1";
		}else{
			type="0";
		}
		MedicalcoursesService service=new MedicalcoursesService();
		String sql="update medicalcourses set name='"+name+"',type='"+type+"' where id="+ids+"";
		System.out.println("update_sql:"+sql);
		int num=service.updateById(sql);
		if(num==0){
			System.out.println("数据修改失败!");
			request.getRequestDispatcher("/updateMedicalcourses.jsp").forward(request, response);
		}
		else{
			System.out.println("数据修改成功!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("view_ludan/medicalcoursesList.jsp");
        return rd;
	}
}