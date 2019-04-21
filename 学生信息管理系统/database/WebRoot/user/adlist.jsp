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
	if (!type.equals("3")) {
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
<img src="images/bg04.jpg" height="100%" width="100%"/>    
</div>
您好！<%=session.getAttribute("username") %>管理员!
	<%
		List<user> users = (List<user>) request.getAttribute("users");
	%>
	<table class="imagetable">
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th colspan="3">身份</th>
			<th>属性</th>
		</tr>
		<%
			for (user usr : users) {
		%>
		<tr>
			<td><%=usr.getId()%></td>
			<td><%=usr.getUsername()%></td>
			<td><%=usr.getPassword()%></td>
			<%
				if (usr.getType().equals("1")) {
			%>
			<td>学生</td>
			<%
				} else if (usr.getType().equals("2")) {
			%>
			<td>老师</td>
			<%
				} else if (usr.getType().equals("3")) {
			%>
			<td>管理员</td>
			<%
				}
			%>
			<td><a href="update?id=<%=usr.getId()%>">修改</a> <%
 	if (!usr.getType().equals("3")) {
 %><a href="delete?id=<%=usr.getId()%>">删除</a> <%
 	;
 		}
 %>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<p>
		共<%=users.size()%>条记录, <a href="add.jsp">新增用户</a> <a
			href="../index.jsp">退出</a>
	</p>
</body>
</html>
