package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class PatientServlet extends HttpServlet{
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setCharacterEncoding("gbk");
		arg1.setCharacterEncoding("gbk");
		String isfinished=arg0.getParameter("isfinished");
		System.out.println("isfinished:"+isfinished);
		String sql="";
		String name=(String)arg0.getSession().getAttribute("doctorLoginTree");
		System.out.println("Login_patientMcName:"+name);
		PatientService patientService=new PatientService();
		if(isfinished.equals("0")||isfinished=="0"||isfinished==null||isfinished==""){
			sql="select *from patient where isfinished=0 and mcName='"+name+"'";
			arg0.setAttribute("patientSer",patientService.selePatient(sql));			
		}else{
			sql="select *from patient where isfinished=1 and mcName='"+name+"'";
			arg0.setAttribute("patientSerIsfinished",patientService.selePatient(sql));
		}
		System.out.println("sql_PatientServlet_sql:"+sql);
		arg0.setAttribute("isfinished", isfinished);
		arg0.getRequestDispatcher("/view/patientList.jsp").forward(arg0, arg1);
	}
	public void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		this.doGet(arg0, arg1);
	}
}