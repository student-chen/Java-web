<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/pages/system/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>教师</title>
</head>
<body>
	<table id="dg" class="" title="列表" style="width: 700px; height: 300px">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'teachernum',width:80">工号</th>
				<th data-options="field:'teachername',width:80">教师姓名</th>
				<th data-options="field:'phone',width:80">电话</th>
				<th data-options="field:'tittle',width:80">职称</th>
				<th data-options="field:'starttime',width:80" formatter="changeDate">入职时间</th>
				<th data-options="field:'createTime',width:80" formatter="changeDateTime">创建时间</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton add" iconCls="icon-add" onclick="create()" plain="true">新增</a> 
		<a href="#" class="easyui-linkbutton edit" iconCls="icon-edit" onclick="edit()" plain="true">修改</a> 
		<a href="#" class="easyui-linkbutton remove" iconCls="icon-remove" onclick="del()" plain="true">删除</a>
		<div>
			教师工号: <input class="easyui-textbox" id="paramTeachernum">
			教师姓名: <input class="easyui-textbox" id="paramTeacherName">
			<a href="#" class="easyui-linkbutton" onclick="doSearch()" iconCls="icon-search">查找</a>
			<a href="#" class="easyui-linkbutton" onclick="doReset()" iconCls="icon-redo">重置</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="数据参数" data-options="modal:true" style="width: 480px; height: 450px;" closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm">
			<table cellpadding="5">
				<tr>
					<td><input type="hidden" id="id" name="id" /></td>
				</tr>
				<tr>
	    			<td>工号:</td>
	    			<td><input class="easyui-textbox" id="teachernum" type="text" name="teachernum" validtype="checkTeachernum" maxlength="15" required="true" missingMessage="工号必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>教师姓名:</td>
	    			<td><input class="easyui-textbox" type="text" id="teachername" name="teachername" maxlength="30" required="true" missingMessage="名称必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>职称:</td>
	    			<td><input class="easyui-textbox" type="text" id="tittle" name="tittle" maxlength="30" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td><input class="easyui-textbox" type="text" id="phone" name="phone" maxlength="30" validtype="mobile"></input></td>
	    		</tr>
	    		<tr>
	    			<td>入职时间:</td>
	    			<td><input class="easyui-datebox" id="starttime" editable="false" type="text" name="starttime"  ></input></td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="dlg-update" class="easyui-dialog" title="数据参数" data-options="modal:true" style="width: 480px; height: 450px;" closed="true" buttons="#update-buttons">
		<form method="post" id="fm-update">
			<table cellpadding="5">
				
				<tr>
					<td><input type="hidden" id="id" name="id" /></td>
				</tr>
				<tr>
	    			<td>工号:</td>
	    			<td><input class="easyui-textbox" id="teachernum" type="text" name="teachernum" readonly="readonly" maxlength="15" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>教师姓名:</td>
	    			<td><input class="easyui-textbox" type="text" id="teachername" name="teachername" maxlength="30" required="true" missingMessage="名称必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>职称:</td>
	    			<td><input class="easyui-textbox" type="text" id="tittle" name="tittle" maxlength="30" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td><input class="easyui-textbox" type="text" id="phone" name="phone" maxlength="30" validtype="mobile"></input></td>
	    		</tr>
	    		<tr>
	    			<td>入职时间:</td>
	    			<td><input class="easyui-datebox" id="starttime" editable="false" type="text" name="starttime"  ></input></td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="save()" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#dlg').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	
	<div id="update-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="update()" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#dlg-update').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	
	<script type="text/javascript">
	$(function() {  
		loadDataGrid();
    });  	
	function loadDataGrid(queryConditon){
		 $('#dg').datagrid({  
	            title : '教师信息',  
	            iconCls : 'icon-ok',  
	            pageSize : 5,
	            pageList : [ 5, 10, 15, 20 ],
	            nowrap : true,
	            striped : true,
	            collapsible : true,  
	            toolbar:"#toolbar", 
	            url:'teacherController.do?datagrid',
	            loadMsg : '数据装载中......',  
	            singleSelect:false,
	            fitColumns:true,  
	            checkOnSelect:true,
	            selectOnCheck:true,
	            fit:true,
	            remoteSort : false,  
	            pagination : true,  
	            rownumbers : true,
	            queryParams:queryConditon
	        });   
	}
		var url;
		function create(){
			$('#dlg').dialog('open').dialog('setTitle','新建');
			$('#fm').form('clear');
			url = 'teacherController.do?save';
		}
		function edit(){
			var row = $('#dg').datagrid('getSelections');
			if (row.length == 1){
				$('#dlg-update').dialog('open').dialog('setTitle','编辑');
				$('#fm-update').form('clear');
				$('#fm-update').form('load',row[0]);
				url = 'teacherController.do?update';
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
		
		function update(){
			$('#fm-update').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						$('#dlg-update').dialog('close');		
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
		
		function doSearch(){
			var queryCondition = {'teachername':$('#paramTeacherName').val(),'teachernum': $('#paramTeachernum').val()};
			loadDataGrid(queryCondition);
		}
		function doReset(){
			$('#paramTeacherName').textbox('setValue','');
			$('#paramTeachernum').textbox('setValue','');
			loadDataGrid(null);
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
							url : 'teacherController.do?delete',
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