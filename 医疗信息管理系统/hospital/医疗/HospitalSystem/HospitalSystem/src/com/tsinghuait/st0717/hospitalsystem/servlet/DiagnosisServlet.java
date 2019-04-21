package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.tsinghuait.st0717.hospitalsystem.service.DiagnosisService;
import com.tsinghuait.st0717.hospitalsystem.service.PatientService;

public class DiagnosisServlet extends BaseServltes {
	protected RequestDispatcher delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name=(String)request.getSession().getAttribute("doctorLoginTree");
		System.out.println("Login_patientMcName:"+name);
		PatientService patientService=new PatientService();
		String sql="select * from patient where isfinished=0 and mcName='"+name+"'";
	    request.setAttribute("diagnoPatient",patientService.selePatient(sql));			
		RequestDispatcher rd=request.getRequestDispatcher("view_linli/diagnosisPatient.jsp");
		return rd;
	}

	@Override
	protected RequestDispatcher insert(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		DiagnosisService ds=new DiagnosisService();
		   RequestDispatcher rd=null;
		   String Type=request.getParameter("type");
	       String patientName=request.getParameter("patientName");
	       int patientID=Integer.parseInt((String)request.getParameter("diaoid"));
	       String doctorName=request.getParameter("doctorName");
	       String sql2="select id from doctor where name='"+doctorName+"'";
	       int doctorID=ds.selectDoctorID(sql2);
	       System.out.println(doctorID);
	       String symptom=request.getParameter("symptom");
           System.out.println(symptom);
	       String sqla="insert into diagnosis values ('"+Type+"','"+symptom+"',"+doctorID+","+patientID+")";
	       String sqlb="update patient set isfinished=1 where oid="+patientID;
	       boolean flag1=ds.insertDiagnosis(sqla);
	       boolean flag2=ds.updateDiagnosis(sqlb);
	       if(flag1==false||flag2==false)
	       {
	    	   rd=request.getRequestDispatcher("/diagnosisServlet?opertion=4&name="+patientName+"&id="+patientID);
	  	     JOptionPane.showMessageDialog(null,"诊断书添加失败，请确认您的信息是否准确");
	       }    
			request.getSession().setAttribute("locationURL", "patientServlet?isfinished=1");
	        rd=request.getRequestDispatcher("/submits.jsp");
	       JOptionPane.showMessageDialog(null,"诊断书添加成功");
		   return rd ;
	}

	@Override
	protected RequestDispatcher select(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String p=request.getParameter("name");
		String patientName=new String(p.getBytes("iso-8859-1"));
		System.out.println(patientName);
		request.setAttribute("patientName",patientName);
		String id=request.getParameter("id");
		int oid=Integer.parseInt(id);
		request.setAttribute("doid",oid);
		RequestDispatcher rd=request.getRequestDispatcher("view_linli/addDiagnosis.jsp");
		return rd;
	}

	@Override
	protected RequestDispatcher update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
