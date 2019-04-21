<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,data.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	if (session.isNew()) {
		session.setAttribute("type", "0");
	}
	String type = session.getAttribute("type").toString();
	if (type == null) {
		type = "0";
	}
	if (!type.equals("1")) {
		request.getSession().setAttribute("type", 0);
		response.sendRedirect("test.jsp");
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>查询用户</title>

<style type="text/css">
table.imagetable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.imagetable th {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.imagetable td {
	background:#dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>

</head>
<body>
<div style="position:absolute; width:100%; height:100%; z-index:-1">    
<img src="images/bg-blue.jpg" height="100%" width="100%"/>    
</div>

您好！<%=session.getAttribute("username") %>同学!
	<table class="imagetable">
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<%
				List<course> cs = (List<course>) request.getAttribute("course");
				for (course crs : cs) {
			%>
			<th><%=crs.getCourse()%></th>
			<%
				}
				List<student> st = (List<student>) request.getAttribute("student");
			%>
		</tr>
		<%
			for (student stu : st) {
		%>
		<tr>
			<td><%=stu.getId()%></td>
			<td><%=stu.getUsername()%></td>
		<%
			for (int i=0;i<cs.size();i++) {
		%>
			<td><%=stu.getScore()[i]%></td>
		<%
			}
		%>
		</tr>
		<%
			}
		%>
	</table>
	<p>
		共<%=cs.size()%>条记录
		<a href="login.jsp">退出</a>
		<a href="update0?id=<%=session.getAttribute("id").toString()%>">修改</a>
	</p>
</body>
</html>
