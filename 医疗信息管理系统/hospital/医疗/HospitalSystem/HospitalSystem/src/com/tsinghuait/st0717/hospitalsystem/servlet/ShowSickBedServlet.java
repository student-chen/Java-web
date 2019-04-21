package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.SickBedService;
//用于显示超连接的病床信息
public class ShowSickBedServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	String id=request.getParameter("id");
	int idd=1;
	if(id!=null){
		idd=Integer.parseInt(id); 
	}
	String sql="select sickbed.id,sickbed.bedNo,sickbed.type,sickbed.isUseable,nurse.name from sickbed,nurse_sickbed,nurse where nurse_sickbed.nurse_id=nurse.id and nurse_sickbed.sickbed_id=sickbed.id and sickbed.id="+idd+"";
	  System.out.println("sql:"+sql);
	  SickBedService  sickBed=new SickBedService();
	  request.setAttribute("sickbed",sickBed.selectSickBed(sql));
	  request.setAttribute("showNurseList",sickBed.showNurse(idd));
	  request.getRequestDispatcher("view_wujirui/listSickBed.jsp").forward(request, response);
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doGet(request, response);  
 }
}    
