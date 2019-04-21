<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>
</head>
<body>
<%List list = (List) request.getAttribute("result_1");
			Iterator it = list.iterator();
			List listColumn = new LinkedList();
			%>
<table width="383" height="38" border="1">
可以用试图得到任课老师等更多信息(这里简单化了)
<tr>
	
	<td width="89">学生姓名</td>
	<td width="59">必修课课名</td>
	<td width="53">成绩</td>
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