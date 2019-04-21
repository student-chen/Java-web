package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import com.tsinghuait.st0717.hospitalsystem.dto.PagePagination;
import com.tsinghuait.st0717.hospitalsystem.service.DoctorService;
import com.tsinghuait.st0717.hospitalsystem.service.MedicalcoursesService;

public class DoctorServlet extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		DoctorService ds=new DoctorService();
		String sql="select d1.name from doctor as d1,operation as d2 where d1.id=d2.pkDoctorId and d1.id="+id;
		String sql2="select d1.name from doctor as d1,diagnosis as d2 where d1.id=d2.doctorId and d1.id="+id;
		System.out.println("sql"+sql);
		System.out.println("sql2"+sql2);
		boolean rs1=ds.doctorNameResultSet(sql);
		boolean rs2=ds.doctorNameResultSet(sql2);
		RequestDispatcher rd=null;
		if(rs1==true||rs2==true){
			StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('此医生正在工作,您还不能删除!')</script>");
			request.setAttribute("alertMsg", sb.toString());
			rd=request.getRequestDispatcher("doctorServlet?opertion=4");
		}
		else
		{
		if(id==null){
			String idl=request.getParameter("doctorid");
			String []ids=idl.split(";");
			
			System.out.println("idl:"+idl+"\n ids[]:"+ids.toString());
			
		    int num=ds.deleteDoctorBatch(ids);
		    
		    System.out.println("num:"+num);
		    JOptionPane.showMessageDialog(null,"删除成功..");
			rd=request.getRequestDispatcher("/doctorServlet?opertion=4");
		}else{
			ds.DoctorDelete(id);
			StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('删除成功!')</script>");
			request.setAttribute("alertMsg", sb.toString());
			rd=request.getRequestDispatcher("/doctorServlet?opertion=4");
			}
		}
		return rd;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName=(String)request.getSession().getAttribute("doctorName");
		String loginPassword1=request.getParameter("loginPassword1");
		String loginPassword2=request.getParameter("loginPassword2");
		System.out.println("loginName:"+loginName+"\n loginPassword1:"+loginPassword1+"\n loginPassword2:"+loginPassword2);
		String sql2="update doctor set loginPassword='"+loginPassword1+"'where loginName='"+loginName+"'";
		DoctorService ds=new DoctorService();
		int num=ds.DoctorUpdate(sql2);
		if(num==0){
			JOptionPane.showMessageDialog(null,"修改密码失败..");
			request.getRequestDispatcher("view/updatedoctorpasssword.jsp").forward(request, response);
			return null;
		}
		StringBuffer sb=new StringBuffer();
		sb.append("<script>alert('修改密码成功!')</script>");
		request.setAttribute("alertMsg", sb.toString());
		RequestDispatcher rd=request.getRequestDispatcher("/doctorServlet?opertion=4");
		return rd;
	}
	protected RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert:");
		String staffNo=request.getParameter("staffNo");
		String name=request.getParameter("name");
		String postName=request.getParameter("post");
		String temp[]=postName.split(",");
		int postid=Integer.parseInt(temp[0]);
		System.out.println("----"+postid);
		String post=temp[1];
		System.out.println("----"+post);
		String sex=request.getParameter("sex");
		String year=request.getParameter("checkbox1");
		String month=request.getParameter("checkbox2");
		String day=request.getParameter("checkbox3");
		String birthday=year+"-"+month+"-"+day;
		System.out.println("birthday:"+birthday);
		Date birth=Date.valueOf(birthday);
		
		String info=request.getParameter("info");
		String mcName=request.getParameter("mcName");
		String loginName=request.getParameter("loginName");
		String isact=request.getParameter("isActive");
	   Integer isActive=0;
		if(isact!=null){
			isActive=Integer.parseInt(isact);
		}
		int number=0;
		if(mcName!=null)
		{
			MedicalcoursesService ms=new MedicalcoursesService();
			number=ms.selectNameMed(mcName);
		}
	    String sql="insert into doctor values('"+staffNo+"','"+name+"',"+postid+",'"+post+"','"+
		sex+"','"+birth+"','"+info+"',"+number+",'"+mcName+"','"+loginName+"','123',"+isActive+")";
	    
	    DoctorService ds=new DoctorService();
	    int isNum=ds.DoctorInsert(sql);
	    if(isNum==0){
	    	JOptionPane.showMessageDialog(null,"添加医生信息失败..");
	    	request.getRequestDispatcher("view/doctorinsert.jsp").forward(request, response);
	    }
	    StringBuffer sb=new StringBuffer();
		sb.append("<script>alert('添加医生信息成功!')</script>");
		request.setAttribute("alertMsg", sb.toString());
		request.getSession().setAttribute("locationURL", "doctorServlet?opertion=4");
        RequestDispatcher rd=request.getRequestDispatcher("/submits.jsp");
		return rd;
	}

	protected RequestDispatcher select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");	
		String Scount=request.getParameter("Scount");
		int page=1;
		int pageSize=5;
		if(Scount==null){
			Scount="name";
		}
		String isActive=request.getParameter("isActive");
		String sql="";
		String pag=request.getParameter("page");
		if(pag!=null){
			page=Integer.parseInt(pag);
		}
		if(name==null){
			name="";
		}
		if(isActive==null||isActive==""){
			sql="select *from doctor where "+Scount+" like '%"+name+"%'";
		}
		else if(isActive=="0"||isActive.equals("0")){
			sql="select *from doctor where "+Scount+" like '%"+name+"%' and isActive=0";
		}else if(isActive=="1"||isActive.equals("1")){
			sql="select *from doctor where "+Scount+" like '%"+name+"%' and isActive=1";
		}else{
			sql="select *from doctor where "+Scount+" like '%"+name+"%'";
		}
		System.out.println("sql:"+sql);
		DoctorService dao=new DoctorService();
		request.setAttribute("doctorservice", dao.selectDoctor(sql, page, pageSize));
		request.setAttribute("isActiveType",isActive);

		PagePagination pf=new PagePagination();	
		pf.setIsActive(isActive);
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
		RequestDispatcher rd=request.getRequestDispatcher("view/doctor.jsp");
		return rd;
	}
	protected RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update\n\n\n\n\n");
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null){
			id=Integer.parseInt(ids);
		}
		String staffNo=request.getParameter("staffNo");
		String name=request.getParameter("name");
		String post=request.getParameter("post");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String info=request.getParameter("info");
		String mcName=request.getParameter("mcName");
		String isAct=request.getParameter("isActive");
		int isActive=0;
		if(isAct!=null){
			isActive=Integer.parseInt(isAct);
		}
	    String sql="update doctor set staffNo='"+staffNo+"',name='"+name+"',post='"+post+"',sex='"+sex+"',birthday="+birthday+",info='"+info+"',mcName='"+mcName+"',isActive="+isActive+" where id="+id;
		System.out.println("update_doctor_sql:"+sql);
	    DoctorService ds=new DoctorService();
		//request.setAttribute("doctorservice", ds.DoctorUpdate(sql));
	    int num=ds.DoctorUpdate(sql);
	    if(num==0){
	    	JOptionPane.showMessageDialog(null,"修改失败..");
			request.getRequestDispatcher("view/updatedoctorpassword.jsp").forward(request, response);
			return null;
		}
	    else
	    {
	    	StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('修改成功!')</script>");
			request.setAttribute("alertMsg", sb.toString());
		RequestDispatcher rd=request.getRequestDispatcher("/doctorServlet?opertion=4");
		return rd;
	    }
	}	
	
}
