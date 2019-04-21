<%@ page language="java" import="com.tsinghuait.st0717.hospitalsystem.service.NurseService,
	com.tsinghuait.st0717.hospitalsystem.service.PostService,java.util.*" pageEncoding="gbk"%>
<jsp:directive.page import="com.tsinghuait.st0717.hospitalsystem.dto.Nurse;"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <title>护士信息表</title>
   <script>
  function on(obj)	{
  		     var to=obj.value;
  		     window.location.href="nurseServlet?opertion=1";
  		}
</script>
<%
		String sql="select * from post";
		PostService ps=new PostService();
		request.setAttribute("postlistSelected",ps.selectRowsPost(sql));
 %>
  <%
		String sql2="select * from nurse";
		NurseService ns=new NurseService();
		request.setAttribute("loginPasswordSelected", ns.selectNurse(sql2));
 %>
 <%
 	String id=request.getParameter("id");
 	int ids=0;
 	if(id!=null){
 		ids=Integer.parseInt(id);
 	}
 	String sql3="select *from nurse where id="+ids+"";
 	NurseService nurseService=new NurseService();
 	ArrayList arr=(ArrayList)nurseService.selectNurse(sql3);
 	Iterator iter=arr.iterator();
  %>
</head>
  <body>
  <form action="<%=request.getContextPath()%>/nurseServlet?opertion=3" method="post">
    <div>
      <center>
      <table class="table">
      <tr>
      <th colspan="4" valign="center" background="imgs/color/color_qianse.jpg">护士信息修改</th>
      </tr>
       <%
 		if(iter.hasNext()){
 			Nurse dto=(Nurse)iter.next();
       %>
        <tr>
	        <th>职工号:</th>
	        <td>
	        	<input type="hidden" name="id" value="<%=dto.getId() %>">
	       	    <input type="text" name="staffNo" value="<%=dto.getStaffNo()%>">
	       	</td>
       	</tr>
        <tr>
	        <th>姓名:</th>
	        <td><input type="text" name="name" value="<%=dto.getName()%>"></td>
        </tr>
        <tr>
        	<th>性别:</th>
        	<td>  <input type="text" name="sex" value="<%=dto.getSex()%>" ></td>
       </tr>
        <tr><th>职称:</th><td><input type="text" name="post" value="<%=dto.getPost()%>" ></td></tr>
        <tr><td colspan="12" background="imgs/color/color_qianse.jpg"></td></tr>
        <%} %>
        <tr><td colspan="3" align="center">
        <input type="submit" value="提交" class="buttonClass">
        <input type="reset" value="取消" class="buttonClass" onclick="window.location.href='<%=request.getContextPath()%>/nurseServlet?opertion=4'"></td></tr>
      </table>
      </center>
      </div>
    </form>
   </body>
</html>
