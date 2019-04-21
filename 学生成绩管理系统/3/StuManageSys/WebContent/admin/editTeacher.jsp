<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    <div style="padding-top: 100px;">
  <center>
     <form action="AdminChangeTeacher.action" method="post">
					<table border="1px" width="300px">
						<tr>
							<td>
								学工号：
							</td>
							<td>
								<input type="text" value="${requestScope.teacher.TId}" name="newteacher.TId" readonly="readonly"/>
								
							</td>
						</tr>
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input type="text" value="${requestScope.teacher.TName}"
									name="newteacher.TName" />
							</td>
						</tr>
						<tr>
							<td>
								手机：
							</td>
							<td>
								<input type="text" value="${requestScope.teacher.TPhone}"
									name="newteacher.TPhone" />
							</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input type="submit" value="更新" />
								<input type="button" value="取消" onclick="window.history.go(-1)"/>
							</td>
						</tr>
					</table>
				</form>
     </center>
     </div>
  </body>
</html>
