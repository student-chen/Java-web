<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" session="true" %>
<%@ page import="com.sevenEleven.javaBean.teacher.DBO,com.sevenEleven.javaBean.teacher.Doing,java.util.List,java.util.Iterator" %>
<%@ page import="com.sevenEleven.Beans.CteacherBean" %>
<% 
String teacherID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
if (teacherID==null||teacherID==""){
	request.setAttribute("errorMSG","没有登陆或登陆已超时");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}
Doing DB=DBO.DBODoing();
List allStudent=DB.GetMyStudent(teacherID);
Iterator it=allStudent.iterator();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>查看学生</title>
</head>
<body>
<table border="1" width=50% align=center>
<%if (it.hasNext()){%>
<%while (it.hasNext()){ List rows=(List)it.next();%>
<tr><td align=center><%=rows.get(1)%></td><td align=center><a href="StuResult?s_id=<%=rows.get(0)%>">成绩</a></td><%=DB.IsRequire(teacherID)?"":"<td><a href=DelStuFromClass?s_id="+rows.get(0)+" onclick='return confirm(\"确认删除此学生所有信息?\")'>删除</a></td>"%></tr>
<%}}else{%>
<tr><td align=center>没有你的学生</td></tr>
<%}
DB.Close();%>
</table>
<div align=center><input type="button" onclick="window.location.href='info_teacher.jsp'" value="返回"></div>
</body>
</html>