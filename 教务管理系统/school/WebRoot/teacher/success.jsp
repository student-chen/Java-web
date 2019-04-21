<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>成功消息</title>
<%String location=(String)request.getAttribute("location");
%>

</head>
<body>
<div align=center>
<li><%=request.getAttribute("successMSG")%>
<%if (location!=null){ %>
<li><a href="info_teacher.jsp">确定</a></li>
<%}%>
</div>
</body>
</html>