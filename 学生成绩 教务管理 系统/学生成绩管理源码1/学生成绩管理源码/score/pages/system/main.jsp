<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/pages/system/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta HTTP-EQUIV="pragma" CONTENT="no-cache"> 
	<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
	<meta HTTP-EQUIV="expires" CONTENT="0"> 
	<title>home</title>
	
</head>
<body  class="easyui-layout">

<!-- 顶部-->
<div region="north" border="false" title="" style="BACKGROUND: #A8D7E9; height: 50px; padding: 1px; overflow: hidden;">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td align="left" style="vertical-align: text-bottom"><img src="image/common/name.png">
		</td>
		<td align="right" nowrap>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr style="height: 25px;" align="right">
				<td style="" colspan="2">
				<div style="background: url(image/common/top_bg.jpg) no-repeat right center; float: right;">
				<div style="float: left; line-height: 25px; margin-left: 70px;"><span style="color: #386780">当前用户:</span> <span style="color: #FFFFFF">${username }</span>&nbsp;&nbsp;&nbsp;&nbsp; <span
					style="color: #386780">其他:</span> <span style="color: #FFFFFF">${roleName }</span></div>
				<div style="float: left; margin-left: 18px;">
				<div style="right: 0px; bottom: 0px;"><a href="javascript:void(0);" class="easyui-menubutton" menu="#layout_north_zxMenu" iconCls="icon-exit" style="color: #FFFFFF">注销</a></div>
				<div id="layout_north_zxMenu" style="width: 100px; display: none;">
					<div class="menu-sep"></div>
					<div onclick="exit('loginController.do?logout','确定退出该系统吗 ?');">退出系统</div>
				</div>	
				</div>
				</div>
				</td>
			</tr>
			<tr style="height: 80px;">
				<td colspan="2">
				<ul class="shortcut">
					<!-- 动态生成并赋值过来 -->
					${primaryMenuList }
				</ul>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
	
	<div data-options="region:'west',split:true,title:'导航菜单'" style="width:150px;padding:10px;">
		<ul id="subMenus" class="easyui-tree" 
			data-options="url:'loginController.do?getTreeMenu',
						method:'get',animate:true,
						onClick: function(node){
							openTab(node.text, node.attributes.href);
						}">
			
		</ul>
	</div>
	
	 <div data-options="region:'east',split:true,collapsed:true,title:'小工具'" style="width:280px;padding:10px;">
	 	<div class="easyui-calendar" style="width:250px;height:250px;"></div>
	 	
	 </div>
	
	
	<div data-options="region:'center',title:'首页'">
		<div id="main-tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
			<div class="easyui-tab" title="首页" href="loginController.do?home" style="padding: 2px; overflow: hidden;"></div>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/admin/logout"><i class="icon-key"></i> Log Out</a>
	
	<!-- 底部 -->
	<div region="south" border="false" style="height: 25px; overflow: hidden;">
	<div align="center" style="color: #CC99FF; padding-top: 2px">&copy; 版权所有 <span class="tip"><a href="http://www.bjpowernode.com" title=" 北京动力节点教育科技有限公司"> 北京动力节点教育科技有限公司</a>  </span></div>
</div>
<div id="mm" class="easyui-menu" style="width: 150px;">
<div id="mm-tabupdate">刷新</div>
<div id="mm-tabclose">关闭</div>
<div id="mm-tabcloseall">全部关闭</div>
<div id="mm-tabcloseother">除此之外全部关闭</div>
<div class="menu-sep"></div>
<div id="mm-tabcloseright">当前页右侧全部关闭</div>
<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
</div>
</body>
	<script type="text/javascript">
	

		$(document).ready(function() {
			
		})
		
		
		
		function openTab(title, url) {
			if("/" != url){
				var mainTabs = $("#main-tabs");
				if (mainTabs.tabs('exists', title)) {
					mainTabs.tabs('select', title);
					var iframeContext = mainTabs.tabs('getTab', title).find("iframe");
					if(iframeContext){
						iframeContext[0].src = url
					} 
				} else {
					mainTabs.tabs('add', {
						title : title,
						content : createFrame(url),
						closable : true
					});
				}
			}

		}

		function createFrame(url) {
			var s = '<iframe name="mainFrame" scrolling="auto" frameborder="no" border="0" marginwidth="0" marginheight="0"  allowtransparency="yes" src="'
					+ url + '" style="width:100%;height:99%;"></iframe>';
			return s;
		}
		
		
	</script>
</html>