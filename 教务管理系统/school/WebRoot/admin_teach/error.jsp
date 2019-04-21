<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>错误页面</title>
</head>
<body>
<h2><font color="red">${warnMessage}</font></h2>
<br>
<p><input type="button" onclick="window.history.go(-1)" value="返回"></p>
</body>
</html>
