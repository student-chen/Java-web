package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tsinghuait.st0717.hospitalsystem.service.SickBedService;

public class updateSickBedServlet extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    this.doGet(request,response);	
	}
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	String id=request.getParameter("id");//接受JSP页面中修改超连接传过来的ID
	int iddd=1;
	if(id!=null){
		iddd=Integer.parseInt(id);
	}		
	String sql="select * from sickbed where id="+id+"";
	SickBedService sickService=new SickBedService();
	request.setAttribute("sickBedList",sickService.selectSickBed(sql));
	request.setAttribute("updatesickbedNurse",sickService.showNurse(iddd));
	request.getRequestDispatcher("view_wujirui/updateSickBed.jsp").forward(request, response);	
  }
}

