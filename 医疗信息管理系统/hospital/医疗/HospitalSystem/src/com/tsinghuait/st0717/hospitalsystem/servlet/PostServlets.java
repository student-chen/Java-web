package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tsinghuait.st0717.hospitalsystem.service.PostService;
public class PostServlets extends BaseServltes{
    //删除职称表信息        
	protected RequestDispatcher delete(HttpServletRequest request, HttpServletResponse arg1) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		PostService ds=new PostService();
		RequestDispatcher rd=null;
		if(id==null){
			String idl=request.getParameter("doctorid");
			String []ids=idl.split(";");			
			System.out.println("idl:"+idl+"\n ids[]:"+ids.toString());			
		    ds.deleteDoctorBatch(ids);
		    
			rd=request.getRequestDispatcher("view_ludan/postList.jsp");
		}else{
			ds.deleteById(id);
			System.out.println("删除成功...");
			rd=request.getRequestDispatcher("view_ludan/postList.jsp");
		}
		return rd;
	}     
	//遍历职称表信息
	protected RequestDispatcher executeQuery(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		PostService service=new PostService();
		ResultSet rs=service.selectPost("select * from post");
		if(rs!=null){
			System.out.println("查询成功....");
		}else{
			System.out.println("查询失败....");
		}
		RequestDispatcher rd=arg0.getRequestDispatcher("view_ludan/postList.jsp");
		return rd;
	}
     //添加职称表信息
	protected RequestDispatcher insert(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		RequestDispatcher rd=null;
		String name=arg0.getParameter("name");
		System.out.println("name:"+name);
		if(name.equals("")||name==null){
			rd=arg0.getRequestDispatcher("/addPost.jsp");
			arg0.setAttribute("URLEcoding","postServlets?opertion=4");
			System.out.println(name);
		}
			PostService service=new PostService();
			int num=service.insertPost(name);
			if(num==0){
				System.out.println("添加失败...");
				arg0.getSession().setAttribute("locationURL", "view_ludan/addPost.jsp");
				//rd=arg0.getRequestDispatcher("view_ludan/addPost.jsp");
			}else{
				//arg0.setAttribute("locationURL","postServlets?opertion=1");
				//rd=arg0.getRequestDispatcher("postServlets?opertion=4");	
				arg0.getSession().setAttribute("locationURL", "postServlets?opertion=4");
			}			
			return rd=arg0.getRequestDispatcher("/submits.jsp");
	}
	//查询职称表信息
	protected RequestDispatcher select(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String name=null;	
		if(arg0.getParameter("name")!=null){
			name=arg0.getParameter("name");
		}
		String sql="select * from post where name like '%"+name+"%'";
		PostService service=new PostService();
		arg0.setAttribute("postList", service.selectRowsPost(sql));		
		RequestDispatcher rd=arg0.getRequestDispatcher("view_ludan/postList.jsp");
		return rd;
	}
	//修改职称表信息
	protected RequestDispatcher update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		String ids=request.getParameter("id");	
		int id=0;
		if(ids!=null)
		{
			id=Integer.parseInt(ids);
		}
		System.out.println("id:"+id);
		String name=request.getParameter("name");
		
		PostService service=new PostService();
		String sql="update post set name='"+name+"'where id="+id;
		System.out.println("sql:"+sql);
		int num=service.updateById(sql);
		if(num==0){
			System.out.println("数据修改失败！");
			request.getRequestDispatcher("/updatePost.jsp").forward(request,response);
		}else{
			System.out.println("数据修改成功!");
		}	
		 RequestDispatcher rd=request.getRequestDispatcher("view_ludan/postList.jsp");
        return rd;
	}
}