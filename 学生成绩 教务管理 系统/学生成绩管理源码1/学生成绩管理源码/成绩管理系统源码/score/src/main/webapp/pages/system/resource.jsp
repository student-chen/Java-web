<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/pages/system/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>菜单</title>
</head>
<body>
	<table id="dg" class=""  title="列表" style="width: 700px; height: 300px" >
		<thead>
			<tr>
				<th data-options="field:'name',width:80">菜单名称</th>
				<th data-options="field:'description',width:80">菜单描述</th>
				<th data-options="field:'href',width:80">菜单地址</th>
				<th data-options="field:'orderNo',width:80">排序</th>
				<th data-options="field:'resourceType',width:80">菜单类型</th>
				<th data-options="field:'parentResource',width:80" hidden="true">上级菜单</th>
				<th data-options="field:'parentid',width:80" hidden="true">上级菜单</th>
				
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton add" iconCls="icon-add" onclick="create()" plain="true">新增</a> 
		<a href="#" class="easyui-linkbutton edit" iconCls="icon-edit" onclick="edit()" plain="true">修改</a> 
		<a href="#" class="easyui-linkbutton remove" iconCls="icon-remove" onclick="del()" plain="true">删除</a>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="数据参数" data-options="modal:true" style="width: 400px; height: 350px;" closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm">
			<table cellpadding="5">
				<tr>
					<td><input type="hidden" name="id" /></td>
				</tr>
	    		<tr>
	    			<td>菜单名称:</td>
	    			<td><input class="easyui-textbox" type="text"  name="name" maxlength="10"  required="true" missingMessage="姓名必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>上级菜单:</td>
	    			<td><input class="easyui-combotree" id="parentid" name="parentid" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单描述:</td>
	    			<td><input class="easyui-textbox" validtype="" type="text" name="description"  maxlength="20" required="false" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单地址:</td>
	    			<td><input class="easyui-textbox" validtype="" type="text" name="href"  maxlength="100" required="false" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>排序:</td>
	    			<td><input class="easyui-textbox" validtype="" type="text" name="orderNo"  maxlength="20" required="false" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单类型:</td>
	    			<td><input class="easyui-textbox" validtype="" type="text" name="resourceType"  maxlength="20" required="false" ></input></td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="save()" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#dlg').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	
	<script type="text/javascript">
	
	$(function() {  
		loadDataGrid();
    });  	
	function loadDataGrid(){
		 $('#dg').treegrid({  
	            title : '资源信息',  
	            iconCls : 'icon-ok',  
	            //width : 600,  
	           // pageSize : 5,//默认选择的分页是每页5行数据  
	            //pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合  
	            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
	            striped : true,//设置为true将交替显示行背景。  
	            collapsible : true,//显示可折叠按钮  
	            toolbar:"#toolbar",//在添加 增添、删除、修改操作的按钮要用到这个  
	            url:'resourceController.do?datagrid',//url调用Action方法  
	            idField: 'id',
	            treeField:'name',
	            loadMsg : '数据装载中......',  
	            singleSelect:true,//为true时只能选择单行  
	            fitColumns:true,//允许表格自动缩放，以适应父容器  
	            checkOnSelect:true,
	            selectOnCheck:true,
	            fit:true,
	            //sortName : 'xh',//当数据表格初始化时以哪一列来排序  
	            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。  
	            remoteSort : false,  
	             //frozenColumns : [ [ {  
	             //   field : 'ck',  
	             //   checkbox : true  
	            //} ] ],   
	          //  pagination : true,//分页  
	            rownumbers : true//行数  
	        });   
	}
		
		function treeload(pid){
			$('#parentid').combotree({
				url:'resourceController.do?treeDropdown',
				method:'get',
				required:true,
				onLoadSuccess:function(){
					$('#parentid').combotree('setValue',pid);
				}
			});
			
		}
	
		
		var url;
		function create(){
			$('#dlg').dialog('open').dialog('setTitle','新建');
			treeload();
			$('#fm').form('clear');
			url = 'resourceController.do?save';
		}
		function edit(){
			var row = $('#dg').treegrid('getSelections');
			if (row.length == 1){
				$('#dlg').dialog('open').dialog('setTitle','编辑');
				$('#fm').form('clear');
				treeload(row[0]._parentId);
				$('#fm').form('load',row[0]);
				url = 'resourceController.do?update';
			}else{
				$.messager.show({
					title: '提示信息',
					msg: '请选择一行数据再进行编辑！'
				});
			}
		}
		function save(){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						$('#dlg').dialog('close');
						$('#dg').treegrid('reload');	
						$.messager.show({
							title: '提示信息',
							msg: result.msg
						});
					} else {
						$.messager.show({
							title: '提示信息',
							msg: result.msg
						});
					}
				}
			});
		}
		function del(){
			var rows = $('#dg').treegrid('getSelections');
			var ids = [];
			if (rows.length > 0){
				$.messager.confirm('提示信息','确定删除?',function(r){
					if (r){
						for ( var i = 0; i < rows.length; i++) {
							ids.push(rows[i].id);
						}
						$.ajax({
							url : 'resourceController.do?delete',
							type : 'post',
							data : {
								ids : ids.join(',')
							},
							cache : false,
							success : function(result) {
								if (result.success){
									$('#dg').treegrid('reload');
									$.messager.show({	
										title: '提示信息',
										msg: result.msg
									});
								} else {
									$.messager.show({	
										title: '提示信息',
										msg: result.msg
									});
								}
							}
						});
					}
				});
			}else{
				$.messager.show({	
					title: '提示信息',
					msg: '请至少选择一条数据后再进行删除'
				});
			}
		}
		
		function lookProperty(obj){
			ob=eval(obj);
			var Property="";
			for(var i in ob){
				Property+="属性："+i+"<br/>";
			}
		  }
	</script>
	
</body>
</html>