<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" session="true" %>
    
<%@ page import="com.sevenEleven.javaBean.teacher.DBO,com.sevenEleven.javaBean.teacher.Doing,java.util.List,java.util.Iterator" %>
<%@ page import="com.sevenEleven.Beans.CteacherBean" %>
<% 
String teacherID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
if (teacherID==null||teacherID==""){
	request.setAttribute("errorMSG","还没有登陆或登陆已超时");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}
Doing DB=DBO.DBODoing();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>老师课表</title>
</head>
<body>
<table border=1 align=center width=50%>
<%
List teaLessonTAB=DB.GetLesstionTable(teacherID);
Iterator it=teaLessonTAB.iterator();
if (it.hasNext()){
	while (it.hasNext()){
		List rows=(List)it.next();%>
		<tr><td>时间<%=rows.get(2)%></td><td>课程<%=rows.get(0)%></td><td>教室<%=rows.get(1)%></td><%=DB.IsRequire(teacherID)?"<td>"+rows.get(3)+"班级</td>":""%></tr>
		<%
	}
	
	
}else{%>
<tr><td>没有你的课表</td></tr>
	<%
}
DB.Close();
%>
</table>
<div align=center><input type="button" onclick="window.location.href='info_teacher.jsp'" value="返回"></div>
</body>
</html>