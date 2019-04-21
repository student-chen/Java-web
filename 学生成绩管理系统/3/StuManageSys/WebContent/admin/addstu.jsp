<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加学生页面</title>
<style type="text/css">
.style {
	text-align: center
}
</style>
  </head>
  
  <body>
   <center>
		<form action="../adminaddstu.action" method="post">
			<table border="1px" width="400px" class="style"
				style="margin-top: 80px;">
				<tr>
					<td colspan="9" background="../skin/images/frame/wbg.gif"
						style="height: 25px; text-align: center">
						<strong>添加学生</strong>
					</td>
				</tr>
				<tr>
					<td>
						姓名：
					</td>
					<td>
					<input type="text"  name="newstudent.stuName"/>
						
					</td>
				</tr>
				<tr>
					<td>
						性别：
					</td>
					<td>
					<input type="text" name="newstudent.stuSex"/>
						
					</td>
				</tr>
				<tr>
					<td>
						家庭住址：
					</td>
					<td>
					<input type="text" name="newstudent.stuAddress"/>
						
					</td>
				</tr>
				<tr>
					<td>
						联系电话：
					</td>
					<td>
					<input type="text" name="newstudent.stuPhone"/>
						
					</td>
				</tr>
				<tr>
					<td>
						邮箱：
					</td>
					<td>
					<input type="text" name="newstudent.stuEmail"/>
						
					</td>
				</tr>
				<tr>
					<td>
						所学专业：
					</td>
					<td>
					<input type="text" name="newstudent.stuSp"/>
						
					</td>
				</tr>
				<tr>
					<td>
						班级：
					</td>
					<td>
					<input type="text" name="newstudent.stuClass"/>
						
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
