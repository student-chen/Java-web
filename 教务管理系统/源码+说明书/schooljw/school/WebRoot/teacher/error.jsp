<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>出错</title>
</head>
<body>
<div align=center>
<li><%=request.getAttribute("errorMSG")==null?"":request.getAttribute("errorMSG")%></li>
<p><input type="button" onclick="info_teacher.jsp" value="返回"></p>
</div>
</body>
</html>