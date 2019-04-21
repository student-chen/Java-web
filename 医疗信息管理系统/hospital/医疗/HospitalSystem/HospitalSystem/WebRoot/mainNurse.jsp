<%@ page language="java" pageEncoding="gb2312"%>
<html>
  <head>
    <title>护士主页面</title>
   <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
    <script language="javascript">
		window.moveTo(0,0);
		window.resizeTo(screen.availWidth,screen.availHeight);
	</script>
	<title>ERP系统</title>
  </head>
 	
<frameset id="superman" rows="70,*,20" cols="*" framespacing="2" frameborder="no" border="2">
  <frame src="${pageContext.request.contextPath}/top.jsp" name="topFrame" scrolling="NO" noresize>
  <frame src="${pageContext.request.contextPath}/centerNurse.jsp" name="mainFrame"> 
  <frame src="${pageContext.request.contextPath}/foot.jsp"  name="bottomFrame" scrolling="NO" noresize>
</frameset>
<noframes>
<body>
	你的浏览器不支持框架！！！
</body>
</noframes>
</html>
 