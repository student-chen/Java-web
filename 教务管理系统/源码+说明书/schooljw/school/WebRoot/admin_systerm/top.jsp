<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<STYLE TYPE="text/css">
<!--
td { color: black; font-size: 20px; font-family: impact }
-->
</STYLE>
<body>
<table width="778" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="190" nowrap bgcolor="#FFFFFF">
		<div align="center"><font color="#3300CC"><img src="img/_platform.gif"
			width="179" height="29"></font></div>
		</td>
		<td width="60%" class="BODY">
		<p>
			<c:out value="${adminSysterm.a_name}" />
			系统管理员 ：您好！ 您的位置： <span class="tbody">综合信息平台界面</span></p>
		</td>
		<td width="20%" bgcolor="#FFFFFF">
	</tr>
</table>
</body>
</html>
