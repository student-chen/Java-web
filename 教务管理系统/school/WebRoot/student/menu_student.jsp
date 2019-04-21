<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!------------------- javaScript ---------------->
<script type="text/javascript" language="javascript" src="../res/js/menu.js" charset="GBK">
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
					class="STYLE1"><B><font color="red">${student.s_name}</font>同学</B></A> | <A href="../ClogoutServlet" target="_parent" class="STYLE1"><B>退出</B></A></TD>
			</TR>
		</TBODY>
	</TABLE>
	<BR>
	<!-- 学生信息 -->					
				<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(1)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>学生信息</SPAN></B></TD>
			</TR>
			<TR>
				<TD id=submenu1>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎<A
								href="Cstudent_showInfoServlet" target="mainFrame">
							我的信息 </A></TD>
						</TR>
						<TR>
							<TD bgColor=#COCOCO height=20>◎<A
								href=Cstudent_updateInfoServlet target="mainFrame">
							修改信息 </A></TD>
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
	</TABLE>&nbsp;&nbsp;
<!-- 课表查询 -->
			<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(2)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>课表查询</SPAN></B></TD>
			</TR>
			<TR>
				<TD id=submenu2>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎<A
								href="CourseTable" target="mainFrame">
							必修课课表 </A></TD>
						</TR>
						
						<TR>
							<TD bgColor=#000000 height=20>◎ <A href="PersonalL2Info"
								target=mainFrame class="STYLE1">选修课查询 </A></TD>
						</TR>

					</TBODY>
				</TABLE>
						</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>&nbsp;&nbsp;
				
<!-- 成绩查询 -->
			<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(3)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>成绩查询</SPAN></B></TD>
			</TR>
			<TR>
				<TD id=submenu3>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎<A
								href="Result" target="mainFrame">
							必修课成绩查询 </A></TD>
						</TR>
						
						<TR>
							<TD bgColor=#000000 height=20>◎ <A href="Result2"
								target=mainFrame class="STYLE1">选修课成绩查询 </A></TD>
						</TR>

					</TBODY>
				</TABLE>
						</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>&nbsp;&nbsp;
<!-- 选报查询 -->
			<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(4)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>选报查询</SPAN></B></TD>
			</TR>
			<TR>
				<TD id=submenu4>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎<A
								href="L2CourseTable" target="mainFrame">
							选报课程 </A></TD>
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
	</TABLE>&nbsp;&nbsp;
<!-- 考试管理 -->	
	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(5)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>考试管理</SPAN></B></TD>
			</TR>
			<TR>
				<TD id=submenu5>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎<A
								href="Cexam_getStudentCourseTocompulsoryPage  " target="mainFrame">
							必修考试 </A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="Cexam_getStudentCourseToElectivePage   "
								target=mainFrame>选修考试</A></TD>
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
	

	

	

	
