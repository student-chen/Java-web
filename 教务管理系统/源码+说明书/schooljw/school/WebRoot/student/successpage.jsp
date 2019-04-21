<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<html>
<head>
<style type="text/css">
A:visited{TEXT-DECORATION: none; COLOR: #000000}
A:active{TEXT-DECORATION: none}
A:hover{TEXT-DECORATION: underline}
A:link{text-decoration: none; COLOR: #000000;
}
body{
	margin-left: 1px;
	margin-top: 0px;
	margin-right: 1px;
	margin-bottom: 0px;
}
BODY{FONT-FAMILY: Verdana,宋体; FONT-SIZE: 10pt;SCROLLBAR-HIGHLIGHT-COLOR: buttonface;SCROLLBAR-SHADOW-COLOR: buttonface;SCROLLBAR-3DLIGHT-COLOR: buttonhighlight;SCROLLBAR-TRACK-COLOR: #eeeeee;SCROLLBAR-DARKSHADOW-COLOR: buttonshadow}}
th{background-image: url(images/tabletitlebg1.gif);FONT-FAMILY: 宋体; FONT-SIZE: 10pt}
TD{FONT-FAMILY: 宋体; FONT-SIZE: 10pt}
DIV{FONT-FAMILY: 宋体; FONT-SIZE: 10pt}
FORM{FONT-FAMILY: 宋体; FONT-SIZE: 10pt}
OPTION{FONT-FAMILY: 宋体; FONT-SIZE: 10pt}
P{FONT-FAMILY: 宋体; FONT-SIZE: 10pt}
BR{FONT-FAMILY: 宋体; FONT-SIZE: 10pt}
INPUT{font-family: 宋体; font-size: 10pt;BORDER-TOP-WIDTH: 1px; PADDING-RIGHT: 1px; PADDING-LEFT: 1px; BORDER-LEFT-WIDTH: 1px; FONT-SIZE: 9pt; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 1px; BORDER-BOTTOM-COLOR: #cccccc; PADDING-BOTTOM: 1px; BORDER-TOP-COLOR: #cccccc; PADDING-TOP: 1px; HEIGHT: 18px; BORDER-RIGHT-WIDTH: 1px; BORDER-RIGHT-COLOR: #cccccc}
textarea{border-width: 1; border-color: #000000; font-family: 宋体; font-size: 9pt; font-style: bold;}
select{border-width: 1; border-color: #000000;  font-family: 宋体; font-size: 9pt; font-style: bold;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<%String location=(String)request.getAttribute("location");
if (location!=null){%>
<meta http-equiv="refresh" content="3;url=<%=location%>"><%}%>
<LINK href="../res/css/main.css" rel=stylesheet>
<title>成功消息</title>
</head>
<body background="images/bg.jpg">
<!--<jsp:include page="/leader.html" flush="false" />-->
<table align=center bordercolor=#e3f1d1 cellpadding=0 cellspacing=0 border=1>
<tr><th><li><%=request.getAttribute("successMSG") %></li></th></tr>
<%if (location!=null){%>
<tr><td>
<script>
l=Array(6,7,8,9,'a','b','b','c','d','e','f')
t="<table height=3 width=100% cellspacing=0 cellpadding=0><tr>"
for(x=0;x<40;x++)
{
	t+="<td id=a_mo"+x+"></td>"
}
document.write(t+"</tr></table>")

function f1(y)
{
	for(i=0;i<40;i++)
	{
		c=(i+y)%20;if(c>10)c=20-c
		document.all["a_mo"+(40-i-1)].bgColor="'#00"+l[c]+l[c]+"00'"
	}y++
	setTimeout('f1('+y+')',40)
}
f1(1)
</script>
</td></tr>
<tr><th><li>3秒钟后自动跳转</li></th></tr>
<tr><th><li><a href="<%=location%>">确定</a></li></th></tr>
<%}%>
</table>
</body>
</html>