<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>出错啦！~</title>
</head>
<body background="images/bg.jpg">
<table align=center bordercolor=#e3f1d1 cellpadding=0 cellspacing=0 border=1>
<tr><th><li><%=request.getAttribute("errorMSG") %></li></th></tr>
<tr><th><input type="button" value="返回" onclick="window.history.go(-1)"></th></tr>
</table>
</body>
</html>