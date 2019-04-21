<%@ page language="java" contentType="text/html; charset=gb2312"
	import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>Insert title here</title>
</head>
<body>
<%List lists = (List) request.getAttribute("info");
			Iterator it = lists.iterator();
			List listColumn = new LinkedList();
			while (it.hasNext()) {
				listColumn = (List) it.next();
			}
%>
<table cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td>
		<table border="0">
			<tr>
				<td>姓名:<%=listColumn.get(2)%></td>
			</tr>
			<tr>
				<td>学号:<%=listColumn.get(3)%></td>
			</tr>
			<tr>
				<td>班级编号:<%=listColumn.get(1)%></td>
			</tr>
			<tr>
			 <td>班级名称:<%=listColumn.get(5) %></td>
			 </tr>
			 <tr>
			 <td>班级类型:<%=listColumn.get(6) %></td>
		</table>
		</td>
	</tr>
</body>
</html>
