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
	if (!type.equals("2")) {
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
	<form method="POST" action="nscore">
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
			<tr>
				<%
					for (student stu : st) {
				%>
				<td><%=stu.getId()%></td>
				<td><%=stu.getUsername()%></td>
				<%
					for (int i = 0; i < cs.size(); i++) {
				%>
				<td><input type="int" name="score[<%=stu.getId()%>][<%=i%>]"
					value="<%if (stu.getScore()[i] >= 0 && stu.getScore()[i] <= 100) {%><%=stu.getScore()[i]%><%;
					} else {%><%=stu.getScore()[i]%><%;
					}%>">
				</td>
				<%
					}
				%>
			</tr>
			<tr>
				<%
					}
					for (int i = 0; i < cs.size(); i++) {
				%>
				<td  colspan="2" >
				<%
					}
				%>
				
				<td align="center"><input type="submit" value="提交" /></td>
			</tr>

		</table>
	</form>
	<p>
		共<%=st.size()%>条记录, <a href="../index.jsp">退出</a> <a href="tclist">返回</a>
	</p>
</body>
</html>
