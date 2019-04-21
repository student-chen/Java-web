<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="msc.vo.*;"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<jsp:useBean id="scdao" scope="page" class="msc.dao.ScDAO"></jsp:useBean>
		<title></title>
		<SCRIPT Language="javascript">
 <!--
  function isValid()
  {	
  	if(formdelcou.cno.value == "")
  	{	
  		window.alert("课序号不能为空！"); 
 		document.formdelcou.elements(0).focus();
  		return  false;
  	}
  	if(formdelcou.cteachno.value == "")
  	{	
  		window.alert("教学班号不能为空！"); 
 		document.formdelcou.elements(0).focus();
  		return  false;
  	}
  	formdelcou.submit();
 }
  -->
  </SCRIPT>

		<script language="javascript">
   function   shuru(txt){   
     if(isNaN(txt)){   
          window.alert("请输入数字"); 
          document.formaddcou.elements(2).focus();    
          }  
    }  
   </script>
	</head>

	<body bgcolor="#8dd8f8">
		<%
			request.setCharacterEncoding("utf-8");
			String sid = (String) session.getAttribute("id");
			Vector all = scdao.SelectSelf(sid);
			int i = all.size();
			Tc cou[] = new Tc[i];
			if (true) {
		%>
		<div align="center">
			<font size="5" color="#000080" face="华文楷体"><b>已选课程信息如下：<br>
					<br>
			</b>
			</font>
		</div>
		<table border="1" cellspacing="0" cellpadding="0" align="center">

			<tr align="center">
				<td width="100">
					课序号
				</td>
				<td width="200">
					课程名
				</td>
				<td width="80">
					课程学分
				</td>
				<td width="100">
					任课教师
				</td>
			</tr>
			<%
				for (int j = 0; j < i; j++) {
						cou[j] = (Tc) all.elementAt(j);
						String rcno = cou[j].getCno();
						String rcname = cou[j].getCname();
						double rcredit = cou[j].getCredit();
						String rtname = cou[j].getTname();
			%>
			<tr align="center">
				<td><%=rcno%></td>
				<td><%=rcname%></td>
				<td><%=rcredit%></td>
				<td><%=rtname%></td>
			</tr>
			<%
				}
					if (i == 0) {
			%>
			<tr>
				<th colspan="4">
					无课程信息！
				</th>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<br>
		<br>
		<div align="center">
			<font color="#0000a0"><strong><font size="5"
					face="华文楷体">提交选课信息</font>
			</strong>
			</font>
		</div>
		<form name="formdelcou" action="sc_slt" method="post"
			onsubmit="return isValid(this);">
			<table border="1" width="450" align="center" cellspacing="0"
				cellpadding="0">
				<tr>
					<th height="25" colspan="2">
						请输入选择课程信息:
					</th>
				</tr>
				<tr>
					<td height="25">
						课程序号：
					</td>
					<td>
						<input type="text" name="cno" />
					</td>
				</tr>
				<tr>
					<td height="15"></td>
				</tr>
				<tr>
					<td height="25">
						教学班号：
					</td>
					<td>
						<input type="text" name="cteachno" onchange="shuru(this.value )" />
					</td>
				</tr>
				<tr height="15">
					<td>
						<input type="hidden" name="action" value="new">
					</td>
					<td>
						<input type="hidden" name="sid" value=<%=sid%>>
					</td>
				</tr>
				<tr>
					<td height="25">
						<input type="reset" value="重&nbsp&nbsp置" />
					</td>
					<td>
						<input type="submit" value="提&nbsp&nbsp交" />
					</td>
				</tr>
			</table>
		</form>
		<%
			} else {
		%><div align="center">
		</div>
		<%
			}
		%>
	</body>
</html>
