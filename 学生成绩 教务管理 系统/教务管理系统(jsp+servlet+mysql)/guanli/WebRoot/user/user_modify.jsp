<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>   
<HTML><HEAD><TITLE>教务在线</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<STYLE type=text/css>
TD {
	FONT-SIZE: 12px; COLOR: #000000
}
INPUT {
	FONT-SIZE: 12px; COLOR: #000000
}
SELECT {
	FONT-SIZE: 12px; COLOR: #000000
}
TD.nav {
	FILTER: DropShadow( Color=#ffffff, OffX=1, OffY=1)
}
TD.nav A {
	COLOR: #000000; TEXT-DECORATION: none
}
TD.nav A:hover {
	COLOR: #000000
}
p1 {
	FONT-SIZE: 12px
}
p2 {
	FONT-SIZE: 12px; LINE-HEIGHT: 130%
}
p3 {
	FONT-SIZE: 14px
}
p4 {
	FONT-SIZE: 14px; LINE-HEIGHT: 130%
}
p5 {
	FONT-SIZE: 12px; LINE-HEIGHT: 180%
}
p6 {
	LINE-HEIGHT: 240%
}
p7 {
	COLOR: #404642; LINE-HEIGHT: 150%
}
.text {
	COLOR: #3c3c3c; LINE-HEIGHT: 180%
}
.text1 {
	FONT-SIZE: 14px; COLOR: #3c3c3c; LINE-HEIGHT: 180%
}
A:link {
	COLOR: #000000
}
A:visited {
	COLOR: #000000
}
A:hover {
	COLOR: #000000
}
.STYLE2 {color: #316AC5}
</STYLE>

<META content="MSHTML 6.00.2800.1106" name=GENERATOR></HEAD>
<BODY leftMargin=0 background="images/qback1.gif" topMargin="0" 
marginheight="0" marginwidth="0">
<% if(request.getSession().getAttribute("username")== null){
%>
	<script>
		top.location.href="Admin_Login.jsp";
	</script>    
<%}
%>
<TABLE width=720 height="122" border=0 align=center cellPadding=0 cellSpacing=0>
  <TBODY>
  <TR>
   
    <TD width="720" height="122"><img src="images/top.jpg" width="760" height="122">
	<!--TABLE cellSpacing=0 cellPadding=0 align=right border=0>
        <TBODY>
        <TR>
          <TD>&nbsp;</TD>
      </TR></TBODY></TABLE-->	  </TD>
    <TD width=10 ><BR></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=761 align=center border=0>
  <TBODY>
  <TR>
    <!--TD width=1 bgColor=#615f64><BR></TD-->
    <TD width=150 bgcolor = "#8BA9E5" height=37>
	  <span class="STYLE2">
	  <FONT color=#0000ff 
      size=2>
      <MARQUEE onmouseover=this.stop() onmouseout=this.start() 
      scrollDelay=200><A>当前位置：<A 
      href="http://localhost:8080/jiaowu/Admin.jsp">后台管理首页</A></A></MARQUEE></FONT>
	  
	 
	  </span></TD>
    <TD width=703 bgcolor = "#8BA9E5"> <SCRIPT language=javaScript>      
<!--      
now = new Date(),hour = now.getHours()      
if(hour < 6){document.write("凌晨好!")}      
else if (hour < 9){document.write("&nbsp; <font color=black style='font-size: 9pt'>早上好!")}      
else if (hour < 12){document.write("&nbsp; <font color=black style='font-size: 9pt'>上午好!")}      
else if (hour < 14){document.write("&nbsp; <font color=black style='font-size: 9pt'>中午好!")}      
else if (hour < 17){document.write("&nbsp; <font color=black style='font-size: 9pt'>下午好!")}      
else if (hour < 19){document.write("&nbsp; <font color=black style='font-size: 9pt'>傍晚好!")}      
else if (hour < 22){document.write("&nbsp; <font color=black style='font-size: 9pt'>晚上好!")}      
else {document.write("&nbsp; <font color=black style='font-size: 9pt'>夜里好!")}      
// -->      
              </SCRIPT>
	  <SCRIPT language=JavaScript>    
<!---   
today=new Date();   
var hours = today.getHours();   
var minutes = today.getMinutes();   
var seconds = today.getSeconds();   
var timeValue = "<FONT COLOR=black>" + ((hours >12) ? hours -12 :hours); timeValue += ((minutes < 10) ? "<BLINK><FONT COLOR=black>:</FONT></BLINK>0" : "<BLINK><FONT COLOR=black>:</FONT></BLINK>") + minutes+"</FONT></FONT>";   
timeValue += (hours >= 12) ? "<FONT COLOR=blue><I><B>pm</B></I></FONT>" : "<FONT COLOR=blue><B><I>am</I></B></FONT>";   
function initArray(){   
this.length=initArray.arguments.length   
for(var i=0;i<this.length;i++)   
this[i+1]=initArray.arguments[i]  }   
var d=new initArray("<font color=RED>星期日","<font color=black>星期一","<font color=black>星期二","<font color=black>星期三","<font color=black>星期四","<font color=black>星期五","<font color=red>星期六"); document.write("<font color=black>今天是&nbsp; ",today.getYear(),"<font color=black>年","<font color=black>",today.getMonth()+1,"<font color=black>月","<font color=black>",today.getDate(),"<font color=black>日 </FONT>&nbsp; ",d[today.getDay()+1]," ",timeValue);  //-->   
              </SCRIPT></TD>
    <td width="2"></TD></TR></TBODY></TABLE>
<TABLE cellSpacing="0" cellPadding="0" width="759" align="center" border="0">
  <TBODY>
  <TR>
    <TD width="758"><IMG height="10" src="images/qleft1.jpg" width="273" border="0"></TD>

  </TR></TBODY></TABLE>
<TABLE cellSpacing="0" cellPadding="0" width="760" align="center" border="0">
  <TBODY>
  <TR>
    <TD width=1 height="309" bgColor=#615f64></TD>
    <TD vAlign=top  background="images/cc.jpg"  width=204>
	<!--IMG height=337 src="images/qleft3.jpg" width=204 border=0-->
	<font size=2 color=black><center>
	<p>
    <img src="images/jt.gif" />登陆管理
    <hr>
    <p>
    <a href="user/list.do" >用户管理</a>  
    <p>
    <p>
    <img src="images/jt.gif" />文件管理
    <hr>
    <p>
    <a href="file/file_upload.jsp" >上传文件</a>  
    <p>
    <a href="file/list.do" >文件管理</a></center>
	</font>
    </TD>
    <TD vAlign=top align=left width=553>
      <TABLE height=319 cellSpacing=0 cellPadding=0 width=520 border=0>
        <TBODY>
        
       
        <TR>
          <TD height="319" vAlign=top bgColor=#ffffff><BR>
            <TABLE cellSpacing=0 cellPadding=0 align=center border=0>
              <TBODY>
              <TR>
                <TD width=35><IMG height=24 src="images/qcorner.gif" 
                  width=35 border=0></TD>
                <TD width=290 
background=images/qline2.gif><B>后台管理简介</B></TD>
              <TD width=140 
            background=images/qline3.gif></TD></TR></TBODY></TABLE><BR>
              <table width="90%" height="270" 
border=0 align=center cellpadding=0 cellspacing=0>
                <tbody>
                  <tr>
                    <td height="270" class=text><p>
					<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>修改用户</title>
		<link rel="stylesheet" href="../style/drp.css">
		<script src="../script/client_validate.js"></script>
		<script type="text/javascript">
	
	function goBack() {
		window.self.location ="list.do"
	}
	
	function modifyUser() {
		if (document.getElementById("userName").value == "") {
			alert("用户名称不能为空！");
			return;
		}
		if (document.getElementById("password").value.length < 6) {
			alert("用户密码不能小于6个字符！");
			return;
		}
		with (document.getElementById("userForm")) {
			method = "post";
			action = "modify.do";
			submit();
		}
	}	
</script>

	</head>

	
		<form name="userForm" id="userForm">
			<div align="center">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td width="522" class="p1" height="25" nowrap>
							<img src="../images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>系统管理&gt;&gt;用户维护&gt;&gt;修改</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								用户代码:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="userId" type="text" class="text1" id="userId" value="<bean:write name="user" property="userId"/>"
								size="10" maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>用户名称:&nbsp;
							</div>
						</td>
						<td>
							<input name="userName" type="text" class="text1" id="userName" value="<bean:write name="user" property="userName"/>"
								size="20" maxlength="20">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>密码:&nbsp;
							</div>
						</td>
						<td>
							<label>
								<input name="password" type="password" class="text1" value="<bean:write name="user" property="password"/>"
									id="password" size="20" maxlength="20">
							</label>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								联系电话:&nbsp;
							</div>
						</td>
						<td>
							<input name="contactTel" type="text" class="text1" value="<bean:write name="user" property="contactTel"/>"
								id="contactTel" size="20" maxlength="20">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								email:&nbsp;
							</div>
						</td>
						<td>
							<input name="email" type="text" class="text1" id="email"  value="<bean:write name="user" property="email"/>"
								size="20" maxlength="20">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="button"
						id="btnModify" value="修改" onclick="modifyUser()">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="返回" onclick="goBack()" />
				</div>
			</div>
		</form>
					<br>                    
                        </p>
                      </td>
                  </tr>
                </tbody>
              </table></TD>
        </TR>
       </TBODY></TABLE>
      <B><BR></B></TD>
<TD width=2 bgColor=#615f64></TD>
  </TR></TBODY></TABLE>

      
   
	<center>
	  <p>商丘职业技术学院-软件学院 </p>
	 </center>
</body>
</html>
