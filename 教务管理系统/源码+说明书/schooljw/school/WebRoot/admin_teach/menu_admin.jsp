<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<STYLE type=text/css>
BODY {
	 BACKGROUND: #cccccc; MARGIN: 0px; FONT: 9pt 宋体
}
  TABLE {
	 BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; 

BORDER-BOTTOM: 0px
}
  TD {
	 FONT: 12px 宋体
}
 IMG {
	 BORDER-RIGHT: 0px; BORDER-TOP: 0px; VERTICAL-ALIGN: bottom; 

BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
A {
	FONT: 12px 宋体; COLOR: #000000; TEXT-DECORATION: none
}
A:hover {
	COLOR: #428eff; TEXT-DECORATION: underline
}
.sec_menu {
	BORDER-RIGHT: white 1px solid; OVERFLOW: hidden; BORDER-LEFT: 

white 1px solid; BORDER-BOTTOM: white 1px solid
}
.menu_title {
	
}
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 8px; COLOR: #215dc6; POSITION: relative; 

TOP: 2px
}
.menu_title2 {
	
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 8px; COLOR: #428eff; POSITION: relative; 

TOP: 2px
}
.STYLE1 {color: #FFFFFF}
</STYLE>

<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</SCRIPT>

<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
</HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<TR>
	<TD valign="top">
	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD bgColor=000000 height=25>&nbsp;<A href="#" target=""
					class="STYLE1"><B><font color="red">${adminTeach.a_name}</font>教管</B></A> | <A href="../ClogoutServlet" target="_parent" class="STYLE1"><B>退出</B></A></TD>
			</TR>
		</TBODY>
	</TABLE>
	<BR>
	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(1)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><B><SPAN>学生管理</SPAN></B></TD>
			</TR>
			<TR>
				<TD id=submenu1>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎<A
								href="ShowAllListServlet?action=studentinfo" target="mainFrame">
							显示学生 </A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="RegisterTurnServlet?action=studentregister"
								target=mainFrame>注册学生 </A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>◎ <A
								href="ChangeTurnServlet?action=change_student_info"
								target=mainFrame>修改学生</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>◎ <A
								href="DelTurnServlet?action=del_student" target=mainFrame>注销学生</A></TD>
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
	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(6)
					onmouseout="this.className='menu_title';" bgColor=#f6f8fe height=25><SPAN>教师管理</SPAN></TD>
			</TR>
			<TR>
				<TD id=submenu6>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="ShowAllListServlet?action=teacherinfo" target=mainFrame>显示老师

							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="RegisterTurnServlet?action=teacherregister"
								target=mainFrame>注册老师</A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>◎ <A
								href="ChangeTurnServlet?action=change_teacher_info"
								target=mainFrame>修改老师</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>◎ <A
								href="DelTurnServlet?action=del_teacher" target=mainFrame>注销老师</A></TD>
						</TR>
						<TR>
							<TD bgColor=#000000 height=20>◎ <A href="" target=mainFrame
								class="STYLE1">扩展功能</A></TD>
						</TR>

					</TBODY>
				</TABLE>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	&nbsp;

	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(3)
					onmouseout="this.className='menu_title';" bgColor=#fafbfe height=25><SPAN>班级管理</SPAN></TD>
			</TR>
			<TR>
				<TD id=submenu3>
				<DIV class=sec_menu style="WIDTH: 158px">
				<Form method=post action="">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="ShowAllListServlet?action=classinfo" target=mainFrame>显示班级

							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="RegisterTurnServlet?action=classregister" target=mainFrame>注册班级</A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>◎ <A
								href="ChangeTurnServlet?action=change_class_info"
								target=mainFrame>修改班级</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>◎ <A
								href="DelTurnServlet?action=del_class" target=mainFrame>注销班级</A></TD>
						</TR>
						<TR>
							<TD bgColor=#000000 height=20>◎ <A href="http://www.i2030.org"
								target=mainFrame class="STYLE1">扩展功能 </A></TD>
						</TR>
					</TBODY>
				</TABLE>
				</form>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	&nbsp;&nbsp;

	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(2)
					onmouseout="this.className='menu_title';" bgColor=#ffffff height=25><SPAN>课程管理</SPAN></TD>
			</TR>
			<TR>
				<TD id=submenu2>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="ShowAllListServlet?action=lesson1_info" target=mainFrame>显示必修课程

							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="ShowAllListServlet?action=lesson2_info" target=mainFrame>显示选修课程

							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="RegisterTurnServlet?action=lesson1register"
								target=mainFrame>注册必修课程</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="RegisterTurnServlet?action=lesson2register"
								target=mainFrame>注册选修课程</A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>◎ <A
								href="ChangeTurnServlet?action=change_lesson1_info"
								target=mainFrame>修改必修课程</A></TD>
						</TR>
						<TR>
							<TD bgColor=#808080 height=20>◎ <A
								href="ChangeTurnServlet?action=change_lesson2_info"
								target=mainFrame>修改选修课程</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>◎ <A
								href="DelTurnServlet?action=del_lesson1" target=mainFrame>注销必修课程</A></TD>
						</TR>
						<TR>
							<TD bgColor=#696969 height=20>◎ <A
								href="DelTurnServlet?action=del_lesson2" target=mainFrame>注销选修课程</A></TD>
						</TR>
						<TR>
							<TD bgColor=#000000 height=20>◎ <A href="http://www.i2030.org"
								target=mainFrame class="STYLE1">扩展功能 </A></TD>
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
	&nbsp;&nbsp;

	<TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
		<TBODY>
			<TR>
				<TD class=menu_title id=menuTitle1
					onmouseover="this.className='menu_title2';" onclick=showsubmenu(8)
					onmouseout="this.className='menu_title';" bgColor=#ffffff height=25><SPAN>排课管理</SPAN></TD>
			</TR>
			<TR>
				<TD id=submenu8>
				<DIV class=sec_menu style="WIDTH: 158px">
				<TABLE cellSpacing=0 cellPadding=0 width=150 align=center>
					<TBODY>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="SchemeTurnServlet?action=showscheme" target=mainFrame>显示所有排课(必修)</A></TD>
						</TR>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="SchemeTurnServlet?action=makescheme" target=mainFrame>按日排课提交器(必修)
							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="SchemeTurnServlet?action=makeweekscheme" target=mainFrame>按周排课查看器(必修)
							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#COCOCO height=20>◎ <A
								href="SchemeTurnServlet?action=makeonescheme" target=mainFrame>按次排课提交器(必修) 
							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="SchemeTurnServlet?action=makeonelesson2listscheme"
								target=mainFrame>按次排课提交器(选修)
							</A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="SchemeTurnServlet?action=showlesson2listscheme"
								target=mainFrame>查看所有排课(选修) </A></TD>
						</TR>
						<TR>
							<TD bgColor=#A9A9A9 height=20>◎ <A
								href="SchemeTurnServlet?action=makeweeklesson2listscheme"
								target=mainFrame>按周排课查看器(选修) </A></TD>
						</TR>
						<TR>
							<TD bgColor=#000000 height=20>◎ <!--<a href="" onMouseover="alert('为什么把鼠标放到这里?');
alert('我不是说过不允许的吗？');
alert('写封信给我说声对不起!');
alert('其实，你能这么做我很高兴!!');
alert('你想看自动排课对不？!!');
alert('自动排课很简单的，业务流程而已');
alert('直接找我聊吧!!!');
alert('MSN：gongbo2006@gmail.com');
document.bgColor='black';
document.fgColor='White';
" class="STYLE1">自动排课</a>--><A
								href="CautoMakeScheme_getAllClasses"
								target=mainFrame class="STYLE1">自动排课 </A></TD>
						</TR>

					</TBODY>
				</TABLE>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
