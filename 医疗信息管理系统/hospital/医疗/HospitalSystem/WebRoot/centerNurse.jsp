<%@ page contentType="text/html; charset=gb2312"%>
<HTML>
	<HEAD>
		<TITLE>框架</TITLE>
		<META content="text/html; charset=gbk" http-equiv=Content-Type>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss.css">
		<SCRIPT>
			var one="${pageContext.request.contextPath}/imgs/index7_03.gif";
			var secend="${pageContext.request.contextPath}/imgs/index7_04.gif"			
			function switcSysBar(){
			whichEl = eval("frmTitle");
			if (whichEl.style.display == "none")
			{
			centerimg.src=one
			eval("frmTitle.style.display=\"\";");
			}
			else
			{
			centerimg.src=secend
			eval("frmTitle.style.display=\"none\";");
			}
			}
			</SCRIPT><STYLE type=text/css>
			.navPoint {
				COLOR: white; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt
			}
		</STYLE>
		<META content="MSHTML 5.00.3700.6699" name=GENERATOR>
	</HEAD>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<BODY scroll=no style="MARGIN: 0px" bottommargin="1" leftmargin="1" topmargin="1" rightmargin="1">
		<TABLE border=0 cellPadding=0 cellSpacing=0 height="100%" width="100%">
			<TBODY>
				<TR>
					<TD rowspan="3" align=middle vAlign=center noWrap id=frmTitle>
						<IFRAME frameBorder=0 id=left name=left scrolling=auto
							src="${pageContext.request.contextPath}/nurseTree.jsp"
							style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 160px; Z-INDEX: 2">
						</IFRAME>
					</TD>
					<TD width="13" height="20" valign="bottom">
						<img src="${pageContext.request.contextPath}/imgs/index7_01.gif" width="13" height="20"
							align="absbottom">
					</TD>
					<TD rowspan="3" style="WIDTH: 98%">
						<img src="${pageContext.request.contextPath}/imgs/index7_12.gif" width="100%" height="9"
							align="top">
						<IFRAME frameBorder=0 id=main name=main scrolling=auto
							src="${pageContext.request.contextPath}/first.jsp" width="100%"height="95%">
						</IFRAME>
						<img src="${pageContext.request.contextPath}/imgs/index8_29.gif" width="100%" height="9"
							align="bottom">
					</TD>
				</TR>
				<TR>
					<TD height="100%" onclick="switchSysBar()"
						background="${pageContext.request.contextPath}/imgs/index0_02.gif">
						<img id="centerimg" src="${pageContext.request.contextPath}/imgs/index7_03.gif" width="13"
							height="100">
					</TD>
				  </TR>
				<TR>
					<TD width="13" height="19" valign="top">
						<img src="${pageContext.request.contextPath}/imgs/index7_05.gif" width="13" height="19">
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<SCRIPT>
if(window.screen.width<'1024'){switchSysBar()}
</SCRIPT>
	</BODY>
</HTML>
