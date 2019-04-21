<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" session="true" %>
<%@ page import="java.util.List,java.util.Iterator" %>
<%@ page import="com.sevenEleven.Beans.CteacherBean" %>
<% 
String teacherID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
if (teacherID==null||teacherID==""){
	request.setAttribute("errorMSG","还没有登陆或登陆已超时");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}
List StudentRes=(List)request.getAttribute("StudentResult");
if (StudentRes==null){
	request.setAttribute("errorMSG","未获得结果,确认数据是否合法");
	request.getRequestDispatcher("error.jsp").forward(request,response);
	return;
}%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>学生成绩查询</title>
</head>
<body>
<form method="post" action="AddNorScore">
<table border=1 width=50% align=center>
<%
Iterator it=StudentRes.iterator();
if (it.hasNext()){
	List row=(List)it.next();%>
	
<tr><td>学生号</td><td>学生名</td><td>总分</td><td>考试分</td><td>平时分</td><td>打分</td></tr>
<tr><td><input type="text" name="s_id" readonly value="<%=row.get(0)%>"></td><td><%=row.get(1)%></td><td><%=row.get(2)==null?"未给总分":row.get(2)%></td><td><input type="text" name="Scored" value="<%=row.get(3)==null?"未给考试分":row.get(3)%>"></td><td><input type="text" name="stuScore" value="<%=row.get(4)==null?"未给平时分":row.get(4)%>" size=3></td><td align=center><input type=submit value="更新"></td></tr>
平时分占总分的百分比为:<input type = "text" name = "scorePersent" value="" />%
	<%
}else{%>
	<tr><td>没有此学生的成绩,没有考试或未给出成绩</td></tr>
<%}
%>
</table></form>
<div align=center border=0>
<input type="button" value="返回" onclick="window.location.href='ShowTeacherStudent.jsp'">
</div>

</body>
</html>