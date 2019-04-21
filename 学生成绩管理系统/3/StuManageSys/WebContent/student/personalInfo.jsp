<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生个人信息</title>
	</head>

	<body>
		<div style="padding-top: 100px;">
			<center>
				<form action="../update.action" method="post">
					<table border="1px" width="300px">
						<tr>
							<td>
								学号：
							</td>
							<td>
								<input type="text" value="${sessionScope.student.getStuId()}" name="newstudent.stuId" readonly="readonly"/>
								
							</td>
						</tr>
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input type="text" value="${sessionScope.username}"
									name="newstudent.stuName" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td>
								性别：
							</td>
							<td>
								<input type="text" value="${sessionScope.student.getStuSex()}"
									name="newstudent.stuSex" />
							</td>
						</tr>
						<tr>
							<td>
								家庭住址：
							</td>
							<td>
								<input type="text" value="${sessionScope.student.getStuAddress()}"
									name="newstudent.stuAddress" />
							</td>
						</tr>
						<tr>
							<td>
								联系电话：
							</td>
							<td>
								<input type="text" value="${sessionScope.student.getStuPhone()}"
									name="newstudent.stuPhone" />
							</td>
						</tr>
						<tr>
							<td>
								所属学院：
							</td>
							<td>
								<input type="text" value="${sessionScope.student.getStuSp()}"
									name="newstudent.stuSp" readonly="readonly"/>
							</td>
						</tr>
						<tr>
							<td>
								班级：
							</td>
							<td>
								<input type="text" value="${sessionScope.student.getStuClass()}"
									name="newstudent.stuClass" readonly="readonly"/>
							</td>
						</tr>
						
						<tr>
							<td>
								邮箱：
							</td>
							<td>
								<input type="text" value="${sessionScope.student.getStuEmail()}"
									name="newstudent.stuEmail" />
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
