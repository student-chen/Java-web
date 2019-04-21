<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" import="java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>
</head>
<body>
<%List list = (List) request.getAttribute("info");
			Iterator it = list.iterator();
			List listColumn = new LinkedList();
			%>
<table width="383" height="38" border="1">
<tr>
	<td width="76">学生ID</td>
	<td width="89">学生姓名</td>
	<td width="76">课程号</td>
	<td width="59">课程名</td>
	<td width="59">老师号</td>
	<td width="59">老师</td>
	<td width="53">教室</td>
	<td width="54">时间</td>
	</tr>
	<%
	while (it.hasNext()) 
	{ 
		listColumn = (List) it.next();%>
		<tr>	
	<%for(int i=0;i<listColumn.size();i++) {%>
	<td width="76"><%=listColumn.get(i)%></td>
	<%} %>
	</tr>
	<%}%>
</table>
</table>

</table>
</body>
</html>
