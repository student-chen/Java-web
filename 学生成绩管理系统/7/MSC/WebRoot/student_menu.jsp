<%@ page language="java" import="java.util.*;" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title></title>
		<link rel="stylesheet" type="text/css" href="image/mystyle1.css">
	</head>

	<body>
		<SCRIPT Language="javascript">
 <!--
  function isValid()
  {	
  	if(changecode.oldpa.value == "")
  	{	
  		window.alert("原密码不能为空！"); 
 		document.changecode.elements(0).focus();
  		return  false;
  	}
  	if(changecode.newpa.value == "")
  	{
  		window.alert("新密码不能为空！");
  		document.changecode.elements(1).focus();
  		return  false; 
  	}
  	if(changecode.confpa.value == "")
  	{
  		window.alert("密码确认不能为空！");
  		document.changecode.elements(2).focus();
  		return  false; 
  	}
  	changecode.submit();
 }
  -->
  </SCRIPT>
		<%
			request.setCharacterEncoding("utf-8");
			String id = (String) session.getAttribute("id");
			String kind = (String) session.getAttribute("kind");
		%>
		<table width="1024" height="661" bgcolor="#1fa0eb" align="center"
			cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<div align="center">
					</div>
					<table width="1024" height="660" bgcolor="#ffffff" align="center"
						cellspacing="0" cellpadding="0">
						<tr>
							<td>
								<table width="1016" height="652" bgcolor="#8dd8f8"
									align="center">
									<tr height="100">
										<td></td>
									</tr>
									<tr>
										<td>
											<form name="changecode"	action="menu_slt?id=<%=id%>&kind=<%=kind%>" method="post" onsubmit="return isValid(this);">
												<table align="center" border="1">
													<tr align="center">
														<th colspan="2">
															<font face="华文楷体" color="#0000a0"><strong><font
																	size="5">修改登录密码</font>
															</strong>
															</font>
														</th>
													</tr>
													<tr>
														<td>
															原 密 码：
														</td>
														<td>
															<input type="text" name="oldpa" />
														</td>
													</tr>
													<tr>
														<td>
															新 密 码：
														</td>
														<td>
															<input type="text" name="newpa" />
														</td>
													</tr>
													<tr>
														<td>
															密码确认：
														</td>
														<td>
															<input type="text" name="confpa" />
															<input type="hidden" name="action" value="changecode" />
														</td>
													</tr>
													<tr>
														<td>
															<input type="reset" value="重置" />
														</td>
														<td>
															<input type="submit" value="修改" />
														</td>
													</tr>
												</table>
											</form>
										</td>
									</tr>

									<tr height="100">
										<td></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
