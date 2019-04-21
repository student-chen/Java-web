package msc.slt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import msc.dao.*;
import msc.vo.*;

public class msc_slt extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("calscore".equalsIgnoreCase(action)) {
			doAddScore(request,response);
			doAddOCredit(request,response);
		} 
		if("calegrade".equalsIgnoreCase(action)){
			doCalegrade(request,response);
		}
		if("rankbygrade".equalsIgnoreCase(action)){
			doRank(request,response);
		}
	}

	
	public void doAddScore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		StudentDAO sdao=new StudentDAO();
		Vector all=new Vector();
		try {
			all=sdao.Select("", "", "");
			int n=all.size();
			Student stu[]=new Student[n];
			for(int i=0;i<n;i++){
				stu[i]=(Student)all.elementAt(i);
				String sid=stu[i].getSid();
				
				MscDAO mdao=new MscDAO();
				Score sco=mdao.CalAll(sid);
				
	    		mdao.AddScore(sid, sco.getTocredit(), sco.getToscorejd());
			}
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>  成绩汇总完成！<br></font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		out.flush();
		out.close();
	}
	
	public void doAddOCredit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
        MscDAO mdao=new MscDAO();
		try {
			Vector major=mdao.SelectMajor();
			int n=major.size();
			String smajor[]=new String[n];
			for(int i=0;i<n;i++)
			{
				smajor[i]=(String)major.elementAt(i);
				StudentDAO sdao=new StudentDAO();
				double avgcredit=mdao.CalAvg(smajor[i]);
				Vector student=sdao.Select("", "", smajor[i]);
				int j=student.size();
				Student stu[]=new Student[j];
				for(int k=0;k<j;k++)
				{
					stu[k]=(Student)student.elementAt(k);
					double ocredit=0;
					double com=stu[k].getTcredit()-avgcredit;
					if(com>0)
					{
						ocredit=com;
					}
					mdao.AddOCredit(stu[k].getSid(), ocredit);
				}
				
			}
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>  超选学分计算完成！<br></font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
		
	}
	private void doCalegrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
	
		StudentDAO sdao=new StudentDAO();
		try {
			Vector all=sdao.Select("", "", "");
		
			int n=all.size();
			Student stu[]=new Student[n];
			
			for(int i=0;i<n;i++){
				
				stu[i]=(Student)all.elementAt(i);
				double tscorejd=stu[i].getTcreditjd()*70;
				double tcredit=stu[i].getTcredit()*4;
				double egrade=0;
				if(tcredit!=0){
					egrade=tscorejd/tcredit+stu[i].getOcredit()*0.4;
				}
				MscDAO mdao=new MscDAO();
				double tcreditjd=mdao.CalToScorejd(stu[i].getSid());
				double acreditjd=0;
				if(stu[i].getTcredit()!=0){
					acreditjd=tcreditjd/stu[i].getTcredit();
				}
				mdao.AddEgrade(stu[i].getSid(), egrade,acreditjd);
				
			}
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>  智育成绩计算完成！<br></font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
		out.close();
		
		
	}
	private void doRank(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		MscDAO mdao=new MscDAO();
		try {
			Vector major=mdao.SelectMajor();
			int n=major.size();
			String smajor[]=new String[n];
			for(int i=0;i<n;i++)
			{
				smajor[i]=(String)major.elementAt(i);
				StudentDAO sdao=new StudentDAO();
				Vector student1=sdao.Select("", "", smajor[i]);
				int j=student1.size();
				Student stu1[]=new Student[j];
				for(int k=0;k<j;k++)
				{
					stu1[k]=(Student)student1.elementAt(k);
					if(stu1[k].getEgrade()==0){
						mdao.AddRank(stu1[k].getSid(), 0, 0,1);
					}else{
				    	mdao.AddRank(stu1[k].getSid(), 0, k+1,1);
					}
				}
				Vector Class=mdao.SelectClass();
				int m=Class.size();
				String sclass[]=new String[m];
				for(int l=0;l<m;l++){
					sclass[l]=(String)Class.elementAt(l);
					Vector student2=sdao.Select("", sclass[l], smajor[i]);
					int a=student2.size();
					Student stu2[]=new Student[a];
					for(int b=0;b<a;b++)
					{
						stu2[b]=(Student)student2.elementAt(b);
						if(stu2[b].getEgrade()==0){
							mdao.AddRank(stu2[b].getSid(), 0, 0,0);
						}else{
							mdao.AddRank(stu2[b].getSid(), b+1, 0,0);
						}
						
					}
				}
			}
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>  排名完成！<br></font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
		
	}

	public void init() throws ServletException {
		// Put your code here
	}
	public void destroy() {
		super.destroy(); 
	}

}
