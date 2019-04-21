<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="msc.vo.*;"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<jsp:useBean id="scdao" scope="page" class="msc.dao.ScDAO"></jsp:useBean>
		<title></title>

<script language="JavaScript">
 <!-- Hide 
function delalert(value)
 { 
    if (value == true) 
       alert("打上勾表示删除,小心哟!");  
 }
// -->
</script>
	</head>

	<body bgcolor="#8dd8f8">
		<%
			request.setCharacterEncoding("utf-8");
			String sid = (String) session.getAttribute("id");
			//String canchoose = (String) session.getAttribute("canchoose");
			if (true) {
				Vector all = scdao.SelectSelf(sid);
				int i = all.size();
				Tc cou[] = new Tc[i];
		%>
		<div align="center">
			<font size="5" color="#000080" face="华文楷体"><b>课程信息如下：<br>
					<br> </b> </font>
		</div>
		<form name="formdelcou" action="sc_slt?n=<%=i%>" method="post"
			onsubmit="return isValid(this);">
			<table border="1" cellspacing="0" cellpadding="0" align="center">

				<tr align="center">
					<td width="100">
						课序号
					</td>
					<td>
						课程名
					</td>
					<td width="80">
						课程学分
					</td>
					<td width="80">
						教学班号
					</td>
					<td width="80">
						上课地点
					</td>
					<td width="100">
						上课时间
					</td>
					<td width="80">
						任课教师
					</td>
					<td width="60">
						删除
					</td>
				</tr>
				<%
					for (int j = 0; j < i; j++) {
							cou[j] = (Tc) all.elementAt(j);
							String rcno = cou[j].getCno();
							String rcname = cou[j].getCname();
							double rcredit = cou[j].getCredit();
							int rcteachno = cou[j].getCteachno();
							String rclocation = cou[j].getClocation();
							String rctime = cou[j].getCtime();
							String rtname = cou[j].getTname();
				%>
				<tr align="center">
					<td><%=rcno%></td>
					<td><%=rcname%></td>
					<td><%=rcredit%></td>
					<td><%=rcteachno%></td>
					<td><%=rclocation%></td>
					<td><%=rctime%></td>
					<td><%=rtname%>
					</td>
					<td>
						<input type="checkbox" name="cno<%=j%>" value="<%=rcno%>"
							onClick="return delalert(this.checked)" />
					</td>
				</tr>
				<%
					}
						if (i == 0) {
				%>
				<tr>
					<th colspan="8">
						无课程信息！
					</th>
				</tr>
				<%
					} else
				%>
				<tr>
					<td height="15" colspan="8">
						<input type="hidden" name="action" value="delete">
						<input type="hidden" name="sid" value=<%=sid%>>
					</td>
				</tr>
				<tr>
					<td colspan="4" height="25">
						<input type="reset" value="重&nbsp&nbsp置" />
					</td>
					<td colspan="4">
						<input type="submit" value="提 交" />
					</td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<br>
		<%
			} else {
		%><div align="center">
			<font size="5" color="#ff0000"><strong>非选课时期，不能删除课程课！
			</strong> </font>
		</div>
		<%
			}
		%>
	</body>
</html>
