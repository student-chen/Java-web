<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>

  <SCRIPT Language="javascript">
 <!--
  function isValid2()
  {	
  	if(formaddcouxls.filepath.value == "")
  	{	
  		window.alert("请选择文件"); 
 		
  		return  false;
  	}
  	formaddcouxls.submit();
 }
  -->
  </SCRIPT>		
   
  </head>
<body bgcolor="#8dd8f8">
<%
    request.setCharacterEncoding("utf-8");
    String cno=request.getParameter("cno");
    String tid=request.getParameter("tid");
 %>
<br/><br/><div align="center"><strong><font size="5" face="楷体" color="#0000ff"><font color="#000080">导入成绩</font><br></font></strong></div>
          <br/>                    
    <form name="formaddcouxls" action="jxl_slt" method="post" onsubmit="return isValid2(this);">
    <input type="hidden" name="cno" value="<%=cno %>">
    <input type="hidden" name="tid" value="<%=tid %>">
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr height="25"><th colspan="2">从Excel导入学生成绩<input type="hidden" name="action" value="subsc"></th></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr height="25"><td>请选择路径：</td><td><input type="file" name="filepath" /></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr height="25"><td height="25"><input type="reset" value="重&nbsp&nbsp置"/></td><td><input type="submit" value="提&nbsp&nbsp交"/></td></tr>
    </table>
    </form><div align="center">
    <strong><font color="#ff0000">提示：从Excel导入学生成绩必须符合课学号、姓名、平时成绩、期末成绩四列的格式！
  </font></strong></div>
  </body>
</html>
