<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>教师个人信息</title>
  </head>
  
  <body>
  <div style="padding-top: 100px;">
  <center>
     <form action="../updateTeacher.action" method="post">
					<table border="1px" width="300px">
						<tr>
							<td>
								学工号：
							</td>
							<td>
								<input type="text" value="${sessionScope.teacher.getTId()}" name="newteacher.TId" readonly="readonly"/>
								
							</td>
						</tr>
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input type="text" value="${sessionScope.username}"
									name="newteacher.TName" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td>
								手机：
							</td>
							<td>
								<input type="text" value="${sessionScope.teacher.getTPhone()}"
									name="newteacher.TPhone" />
							</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="更新" />
							</td>
						</tr>
					</table>
				</form>
     </center>
     </div>
  </body>
</html>
