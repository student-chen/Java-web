<%@ page contentType="text/html; charset=gb2312"%>
<%
	if(session.getAttribute("user")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}else{
		session.invalidate();
	}
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss.css">

<meta http-equiv="refresh" content="2;url=${pageContext.request.contextPath}/login.jsp">
</head>
<body>
<table width="200" height="100%" border="0" align="center" cellspacing="0">
  <tr>
    <td height="172" colspan="3" align="center" valign="middle">
    <img src="${pageContext.request.contextPath}/imgs/loading.gif"></td>
  </tr>
</table>
</body>
</html>
 