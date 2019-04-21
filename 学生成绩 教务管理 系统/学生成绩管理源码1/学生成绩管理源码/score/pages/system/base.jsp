<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link rel="stylesheet" type="text/css" href="plug-in/easyui-1.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="plug-in/easyui-1.4.1/themes/icon.css">
<script type="text/javascript" src="plug-in/jquery/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="plug-in/easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="plug-in/easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="plug-in/easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/system/validform.js"></script>
<script type="text/javascript" src="js/system/curdtools.js"></script>
<!--  
<script type="text/javascript" src="js/system/forbiddenutil.js"></script>
-->