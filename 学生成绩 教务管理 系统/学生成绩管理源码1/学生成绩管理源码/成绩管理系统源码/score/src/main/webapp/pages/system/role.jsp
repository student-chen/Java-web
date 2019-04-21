<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/pages/system/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>角色</title>
</head>
<body>
	<table id="dg" class="" title="列表" style="width: 700px; height: 300px">
		<thead>
			<tr>
				<th data-options="field:'name',width:80">角色名称</th>
				<th data-options="field:'description',width:80">角色描述</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton add" iconCls="icon-add" onclick="create()" plain="true">新增</a> 
		<a href="#" class="easyui-linkbutton edit" iconCls="icon-edit" onclick="edit()" plain="true">修改</a> 
		<a href="#" class="easyui-linkbutton remove" iconCls="icon-remove" onclick="del()" plain="true">删除</a>
	</div>
	
	<div id="dlg" class="easyui-dialog" data-options="modal:true" title="数据参数" style="width: 400px; height: 280px;" closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm">
			<table cellpadding="5">
				<tr>
					<td><input type="hidden" name="id" /></td>
				</tr>
	    		<tr>
	    			<td>角色名称:</td>
	    			<td><input class="easyui-textbox" type="text"  name="name" maxlength="10"  required="true" missingMessage="姓名必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>描述:</td>
	    			<td><input class="easyui-textbox"  type="text" name="description"  maxlength="20"></input></td>
	    		</tr>
	    		<tr>
	    			<td>资源:</td>
	    			<td>
	    				<select id="resourceid" class="easyui-combotree" multiple style="width:180px;"></select>
					</td>
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
		resourceTree();
    });  	
	function loadDataGrid(){
		 $('#dg').datagrid({  
	            title : '角色信息',  
	            iconCls : 'icon-ok',  
	            pageSize : 5,  
	            pageList : [ 5, 10, 15, 20 ],  
	            nowrap : true,  
	            striped : true,  
	            collapsible : true,  
	            toolbar:"#toolbar",  
	            url:'roleController.do?datagrid',  
	            loadMsg : '数据装载中......',  
	            singleSelect:true,  
	            fitColumns:true,  
	            checkOnSelect:true,
	            selectOnCheck:true,
	            fit:true,
	            remoteSort : false,  
	            pagination : true,  
	            rownumbers : true
	        });   
	}
	
	function resourceTree(){
		$('#resourceid').combotree({
			url:'resourceController.do?treeDropdown',
			method:'get',
			required:false
			
		});
	}
	
		var url;
		function create(){
			$('#dlg').dialog('open').dialog('setTitle','新建');
			$('#fm').form('clear');
			url = 'roleController.do?save';
		}
		function edit(){
			var row = $('#dg').datagrid('getSelections');
			if (row.length == 1){
				$('#dlg').dialog('open').dialog('setTitle','编辑');
				$('#fm').form('clear');
				$('#fm').form('load',row[0]);
				url = 'roleController.do?update';
				$.ajax({
					url : 'roleController.do?queryResource',
					type : 'post',
					async:false,
					data : {
						id : row[0].id
					},
					cache : false,
					success : function(result) {
						if (result.success){
							$('#resourceid').combotree('setValues',result.obj);
						} else {
							$.messager.show({	
								title: '提示信息',
								msg: result.msg
							});
						}
					}
				});
			}else{
				$.messager.show({
					title: '提示信息',
					msg: '请选择一行数据再进行编辑！'
				});
			}
		}
		function save(){
			var nodes = $('#resourceid').combotree('getValues');
			var treeN = $('#resourceid').combotree('tree');
			var others = treeN.tree('getChecked', 'indeterminate');
			if(others != null && others.length>0){
				for(var i=0; i<others.length; i++){
					nodes.push(others[i].id);
				}
			}
			url = url +　'&resourceids='+nodes;
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						$('#dlg').dialog('close');		
						$('#dg').datagrid('reload');	
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
			var rows = $('#dg').datagrid('getSelections');
			var ids = [];
			if (rows.length > 0){
				$.messager.confirm('提示信息','确定删除?',function(r){
					if (r){
						for ( var i = 0; i < rows.length; i++) {
							ids.push(rows[i].id);
						}
						$.ajax({
							url : 'roleController.do?delete',
							type : 'post',
							data : {
								ids : ids.join(',')
							},
							cache : false,
							success : function(result) {
								if (result.success){
									$('#dg').datagrid('reload');
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
	
	</script>
	
</body>
</html>