<%@ page  contentType="text/html; charset=GB2312" %>
<html>
<head>
<title>认证错误</title>

<style type="text/css">
<!--
.14bold {	FONT-WEIGHT: bold; FONT-SIZE: 14px
}
.C-D63004 {	COLOR: #d63004
}
.border_FFBA00 {	BORDER-RIGHT: #ffba00 1px solid; BORDER-TOP: #ffba00 1px solid; BORDER-LEFT: #ffba00 1px solid; BORDER-BOTTOM: #ffba00 1px solid; BACKGROUND-COLOR: #ffffe6
}
-->
</style>
</head>
	<body>
	
<% if(request.getSession().getAttribute("username")== null){
%>
	<script>
		top.location.href="Admin_Login.jsp";
	</script>    
<%}
%>
	
	<P>&nbsp;</P>
	<P>&nbsp;</P>
	<P>&nbsp;</P>
	<TABLE class=border_FFBA00 cellSpacing=0 cellPadding=0 width=580 align=center 
border=0>
      <TBODY>
        <TR>
          <TD class="C-D63004 14bold" vAlign=center align=center height=188> <SPAN 
      class=14bold><B><BR>
                  <BR>
            登录失败，现正在转向登录页...</B></SPAN> <br>
          <strong><%=request.getSession().getAttribute("username")%></strong></TD>
        </TR>
      </TBODY>
    </TABLE>
	<P>&nbsp;</P>
	<%
		String url="Admin_Login.jsp";
	%>
	<script>
		setTimeout("top.location.href='<%=url%>'",2000);
	</script>
	</body>
</html>
