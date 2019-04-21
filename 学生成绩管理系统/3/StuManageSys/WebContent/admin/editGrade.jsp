<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="/struts-tags" prefix="s" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>


  </head>
  
  <body>
   <center>
   <br/><br/><br/><br/><br/>
     <form action="adminChangeGrade.action" method="post">
					<table border="1px" width="300px">
						
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input type="text" value="${sessionScope.stuName}"
									name="newteacher.TName" readonly="readonly"/>
							</td>
						</tr>
						
						<tr>
							<td>
								成绩：
							</td>
							<td>
								<input type="text" value="${requestScope.grade}"
									name="newgrade" />
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
  </body>
</html>
