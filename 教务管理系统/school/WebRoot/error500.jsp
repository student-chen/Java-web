<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>出错页面</title>
</head>
<body>
<h1><font color="red">登录失败!!!!!</font></h1>
${errorMessage}<br>
<p><input type="button" onclick="window.history.go(-1)" value="返回"></p>
</body>
</html>