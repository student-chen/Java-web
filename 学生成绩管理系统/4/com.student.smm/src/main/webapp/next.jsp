<%@ page language="java"  pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
    <title>报警系统</title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- Latest compiled and minified CSS -->
   <script >
    $(document).ready(function () {
    	$(":input").attr("autocomplete","off");
    });
    </script>
</head>
<body>  
<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
		
			<h3 class="text-center">
				<div class="page-header">
  				<h1>请提供内容 <small></small></h1>
				</div>
			</h3>
			<form class="form-horizontal" role="form" action="<%=path %>/content/add.do" method="post">
				<div class="form-group">
					 <label for="  " class="col-sm-2 control-label">名称<span style="color: red;">*</span></label>
					<div class="col-sm-10">
						<input  class="form-control" id="name" name="name" />
					</div>
				</div>
				<div class="form-group">
					 <label for="  " class="col-sm-2 control-label">说明<span style="color: red;">*</span></label>
					<div class="col-sm-10">
						<input  class="form-control" id="explain" name="explain"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="  " class="col-sm-2 control-label">文字描述</label>
					<div class="col-sm-10">
						<input  class="form-control" id="describe" name="describe"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="  " class="col-sm-2 control-label">视频描述<span style="color: red;">*</span></label>
					<div class="col-sm-10">
						<input  class="form-control" id="video" name="video"/>
						<input  class="form-control" id="record_id" name="recordId" value="${ recordId}" type="hidden"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					  <h3 class="text-center">
						 <button type="submit" class="btn btn-default">提交</button>
					</h3>
					</div>
				</div>
				<div class="form-group">
					<h3 class="text-center">
				
							<div class="alert alert-danger" role="alert">请填写详细信息，以便我们及时处理</div>
					</h3>
					</div>
				
				</div>
			</form>
		</div>
		<div class="col-md-2 column">
		</div>
	</div>
</div>
	</body>
</html>			
			
