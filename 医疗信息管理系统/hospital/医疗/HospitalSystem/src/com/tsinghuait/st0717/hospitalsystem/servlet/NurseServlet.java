package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.dto.PagePagination;
import com.tsinghuait.st0717.hospitalsystem.service.NurseService;
import javax.swing.JOptionPane;

public class NurseServlet extends BaseServltes{
	protected RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		NurseService ds=new NurseService();
		String sql="select n1.name from nurse as n1,nurse_opertionRoom as n2 where n1.id=n2.nurse_id and n1.id="+id;
		String sql2="select n1.name from nurse as n1,nurse_sickbed as n2 where n1.id=n2.nurse_id and n1.id="+id;
        System.out.println("delete_sql:"+sql);
		System.out.println("delete_sql2:"+sql2);
		boolean rs1=ds.nurseNameResultSet(sql);
		boolean rs2=ds.nurseNameResultSet(sql2);
		RequestDispatcher rd=null;
		if(rs1==true||rs2==true){
			//JOptionPane.showMessageDialog(null,"此护士正在工作,您还不能删除!");
			StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('此护士正在工作,您还不能删除!')</script>");
			request.setAttribute("alertMsg", sb.toString());
			rd=request.getRequestDispatcher("nurseServlet?opertion=4");
		}
		else
		{  
		if(id==null){
			String idl=request.getParameter("nurseid");
			String []ids=idl.split(";");
			ds=new NurseService();
		    ds.deleteNurseBatch(ids);
		    StringBuffer sb=new StringBuffer();
		    sb.append("<script=type/javascript>");
		    sb.append("alert(删除失败..)");
		    sb.append("</script>");
		    sb.toString();
		    JOptionPane.showMessageDialog(null,"删除成功..");
			rd=request.getRequestDispatcher("nurseServlet?opertion=4");
		}else{
			ds=new NurseService();
			ds.NurseDelete(id);
			StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('删除成功!')</script>");
			request.setAttribute("alertMsg", sb.toString());
			rd=request.getRequestDispatcher("nurseServlet?opertion=4");
		}
	}
		return rd;
	}
	protected RequestDispatcher executeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName=request.getParameter("loginName");
		String loginPassword1=request.getParameter("password");
		String sql2="update nurse set loginPassword='"+loginPassword1+"'where loginName='"+loginName+"'";
		  NurseService ns=new NurseService();
		  int num=ns.NurseUpdate(sql2);
			if(num==0)
			{
				JOptionPane.showMessageDialog(null,"修改密码失败..");
				request.getRequestDispatcher("view/updatedoctorpasssword.jsp").forward(request, response);
				return null;
			}
			else
			{
				StringBuffer sb=new StringBuffer();
				sb.append("<script>alert('修改密码成功!')</script>");
				request.setAttribute("alertMsg", sb.toString());
			    RequestDispatcher rd=request.getRequestDispatcher("/doctorServlet?opertion=4");
			    return rd;
			}
		}
	protected RequestDispatcher insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffNo=request.getParameter("staffNo");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String postName=request.getParameter("post");
		String temp[]=postName.split(",");
		int postid=Integer.parseInt(temp[0]);
		System.out.println("----"+postid);
		String post=temp[1];
		System.out.println("----"+post);
		String loginName=request.getParameter("loginName");
		String loginPassword=request.getParameter("loginPassword");
		String sql="insert into nurse values('"+staffNo+"','"+name+"','"+sex+"',"+postid+",'"+post+"','"+loginName+"','"+loginPassword+"')";
		NurseService ns=new NurseService();
		int isNum=ns.NurseInsert(sql);
	    if(isNum==0){
	    	JOptionPane.showMessageDialog(null,"添加护士信息失败..");
	    	request.getRequestDispatcher("view/nurseinsert.jsp").forward(request, response);
	    }
	    StringBuffer sb=new StringBuffer();
		sb.append("<script>alert('添加护士信息成功!')</script>");
		request.setAttribute("alertMsg", sb.toString());
		request.setAttribute("locationURL", "nurseServlet?opertion=4");
        RequestDispatcher rd=request.getRequestDispatcher("/submits.jsp");
		return rd;
	}
	protected RequestDispatcher select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");	
		String Scount=request.getParameter("Scount");
		int page=1;
		int pageSize=8;
		if(Scount==null){
			Scount="name";
		}
		System.out.println("nurse_name:"+name);
		String pag=request.getParameter("page");
		if(pag!=null){
			page=Integer.parseInt(pag);
		}
		if(name==null){
			name="";
		}
		//查看医生(写上护士医生、科别的联合表视图即可)
		String sql="select *from nurse where "+Scount+" like '%"+name+"%'";
		System.out.println("sql:"+sql);
		NurseService dao=new NurseService();
		request.setAttribute("nurseservice", dao.selectNurse(sql,page,pageSize));
		PagePagination pf=new PagePagination();	
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
		RequestDispatcher rd=request.getRequestDispatcher("/view/nurse.jsp");
		return rd;
	}
	protected RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=0;
		if(ids!=null){
			id=Integer.parseInt(ids);
		}
		String staffNo=request.getParameter("staffNo");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String post=request.getParameter("post");
	    String sql="update nurse set staffNo='"+staffNo+"',name='"+name+"',sex='"+sex+"',post='"+post+"'where id="+id;
	    System.out.println("update:sql"+sql);
	    NurseService ds=new NurseService();
	    int num=ds.NurseUpdate(sql);
	    RequestDispatcher rd=null;
	    if(num==0){
	    	JOptionPane.showMessageDialog(null,"修改失败..");
			rd=request.getRequestDispatcher("view/updatenursepasssword.jsp");
		}
	    else
	    {
	    	StringBuffer sb=new StringBuffer();
			sb.append("<script>alert('修改成功!')</script>");
			request.setAttribute("alertMsg", sb.toString());
			rd=request.getRequestDispatcher("/nurseServlet?opertion=4");
	    }
	    return rd;
	}	
}