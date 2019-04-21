<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加课程页面</title>
<style type="text/css">
.style {
	text-align: center
}
</style>
  </head>
  
  <body>
    <center>
		<form action="../adminaddcourse.action" method="post">
			<table border="1px" width="400px" class="style"
				style="margin-top: 80px;">
				<tr>
					<td colspan="9" background="../skin/images/frame/wbg.gif"
						style="height: 25px; text-align: center">
						<strong>添加课程</strong>
					</td>
				</tr>
				<tr>
					<td>
						课程名：
					</td>
					<td>
					<input type="text" value="${requestScope.selectedcouse.CName}" name="newcourse.CName"/>
						
					</td>
				</tr>
				<tr>
					<td>
						学时：
					</td>
					<td>
					<input type="text" value="${requestScope.selectedcouse.CHour}" name="newcourse.CHour"/>
						
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="提交"/>
					</td>
				</tr>

			</table>
			</form>
		</center>
  </body>
</html>
