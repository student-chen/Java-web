<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!------------------- javaScript ---------------->
<script type="text/javascript" language="javascript"
	src="../res/js/menu.js" charset="GBK">
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>studentMenu</title>
<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
<LINK href="../res/css/menu.css" rel=stylesheet>
</HEAD>

<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<TD valign="top">
<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
	<TBODY>
		<TR>
			<TD bgColor=000000 height=25>&nbsp;<A href="#" target=""
				class="STYLE1"><B><font color="red">${teacher.t_name}</font>老师</B></A>
			| <A href="../ClogoutServlet" target="_parent" class="STYLE1"><B>退出</B></A></TD>
		</TR>
	</TBODY>
</TABLE>
<BR>
<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
	<TBODY>
		<TR>
			<TD class=menu_title id=menuTitle1
				onmouseover="this.className='menu_title2';" onclick=showsubmenu(1)
				onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>老师功能</SPAN></B></TD>
		</TR>
		<TR>
			<TD id=submenu1>
			<DIV class=sec_menu style="WIDTH: 158px"><!-- 老师功能 -->
			<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
				<TBODY>
					<TR>
						<TD bgColor=#COCOCO height=20>◎<A href="UpdateTeacherInfo.jsp  "
							target="mainFrame"> 修改资料 </A></TD>
					</TR>
					<TR>
						<TD bgColor=#A9A9A9 height=20>◎ <A
							href="ShowTeacherStudent.jsp     " target=mainFrame>查看学生</A></TD>
					</TR>
					<TR>
						<TD bgColor=#A9A9A9 height=20>◎ <A
							href="ShowTeacherLessonTable.jsp      " target=mainFrame>查看课表</A></TD>
					</TR>
					<TR>
						<TD bgColor=#000000 height=20>◎ <A href="http://www.i2030.org"
							target=mainFrame class="STYLE1">扩展功能</A></TD>
					</TR>


				</TBODY>
			</TABLE>
			</DIV>
			</TD>
		</TR>
	</TBODY>
</TABLE>
&nbsp;&nbsp; <!-- 考试功能 -->
<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
	<TBODY>
		<TR>
			<TD class=menu_title id=menuTitle2
				onmouseover="this.className='menu_title2';" onclick=showsubmenu(2)
				onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>考试管理</SPAN></B></TD>
		</TR>
		<TR>
			<TD id=submenu2>
			<DIV class=sec_menu style="WIDTH: 158px">
			<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
				<TBODY>
					<TR>
						<TD bgColor=#COCOCO height=20>◎<A href="Cexam_addtestServlet  "
							target="mainFrame"> 增加必修课试题 </A></TD>
					</TR>
					<TR>
						<TD bgColor=#A9A9A9 height=20>◎ <A
							href="Cexam_addtest2Servlet     " target=mainFrame>增加选修课试题</A></TD>
					</TR>
					<TR>
						<TD bgColor=#A9A9A9 height=20>◎ <A
							href="Cexam_updateOrDeleteTestServlet      " target=mainFrame>修改及删除试题</A></TD>
					</TR>
					<TR>
						<TD bgColor=#000000 height=20>◎ <A href="http://www.i2030.org"
							target=mainFrame class="STYLE1">扩展功能 </A></TD>
					</TR>


				</TBODY>
			</TABLE>
			</DIV>
			</TD>
		</TR>
	</TBODY>
</TABLE>
&nbsp;