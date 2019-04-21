<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/pages/system/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>学生</title>
</head>
<body>
	<table id="dg" class="" title="列表" style="width: 700px; height: 300px">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'studentnum',width:80">学号</th>
				<th data-options="field:'name',width:80">学生姓名</th>
				<th data-options="field:'sex',width:80" formatter="changeValue">性别</th>
				<th data-options="field:'birthday',width:80" formatter="changeDate">出生日期</th>
				<th data-options="field:'qq',width:80">qq</th>
				<th data-options="field:'mobile',width:80">电话</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton add" iconCls="icon-add" onclick="create()" plain="true">新增</a> 
		<a href="#" class="easyui-linkbutton edit" iconCls="icon-edit" onclick="edit()" plain="true">修改</a> 
		<a href="#" class="easyui-linkbutton remove" iconCls="icon-remove" onclick="del()" plain="true">删除</a>
		<div>
			学号: <input class="easyui-textbox" id="paramStudentnum">
			学生姓名: <input class="easyui-textbox" id="paramStudent">
			电话: <input class="easyui-textbox" id="paramMobile">
			qq: <input class="easyui-textbox" id="paramQq">
			<a href="#" class="easyui-linkbutton" onclick="studentSearch()" iconCls="icon-search">查找</a>
			<a href="#" class="easyui-linkbutton" onclick="studentReset()" iconCls="icon-search">清空</a>
		</div>
	</div>
	
	
	<div id="dlg" class="easyui-dialog" title="数据参数" data-options="modal:true" style="width: 480px; height: 430px;" closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm">
			<table cellpadding="5">
				<tr>
					<td><input type="hidden" id="id" name="id" /></td>
				</tr>
				<tr>
	    			<td>学号:</td>
	    			<td><input class="easyui-textbox" id="studentnum" type="text" name="studentnum" validtype="checkNum" maxlength="15" required="true" missingMessage="学号必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>学生姓名:</td>
	    			<td><input class="easyui-textbox" id="name" type="text" name="name" maxlength="10" required="true" missingMessage="姓名必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td>
						<select name="sex" id="sex">
							<option value="1" selected="selected">男</option>
							<option value="2">女</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>出生日期:</td>
	    			<td><input class="easyui-datebox" id="birthday" editable="false" maxlength="20" type="text" name="birthday"></input></td>
	    		</tr>
	    		<tr>
	    			<td>qq:</td>
	    			<td><input class="easyui-textbox" id="qq" validtype="qq" maxlength="15" type="text" name="qq" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td><input class="easyui-textbox" id="mobile" type="text" name="mobile" validtype="mobile" ></input></td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="dlg-update" class="easyui-dialog" title="数据参数" data-options="modal:true" style="width: 480px; height: 430px;" closed="true" buttons="#update-buttons">
		<form method="post" id="fm-update">
			<table cellpadding="5">
				<tr>
					<td><input type="hidden" id="id" name="id" /></td>
				</tr>
				<tr>
	    			<td>学号:</td>
	    			<td><input class="easyui-textbox" id="studentnum" type="text" name="studentnum" readonly="readonly" maxlength="20" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>学生姓名:</td>
	    			<td><input class="easyui-textbox" id="name" type="text" name="name" maxlength="10" required="true" missingMessage="姓名必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td>
						<select name="sex" id="sex">
							<option value="1" selected="selected">男</option>
							<option value="2">女</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>出生日期:</td>
	    			<td><input class="easyui-datebox" id="birthday" editable="false" maxlength="20" type="text" name="birthday"></input></td>
	    		</tr>
	    		<tr>
	    			<td>qq:</td>
	    			<td><input class="easyui-textbox" id="qq" validtype="qq" maxlength="15" type="text" name="qq" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>电话:</td>
	    			<td><input class="easyui-textbox" id="mobile" type="text" name="mobile" validtype="mobile" ></input></td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="update-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="update()" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#dlg-update').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="save()" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#dlg').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	<script type="text/javascript">
	$(function() {  
		loadDataGrid();
    });  	
	function studentSearch(){
		var queryCondition = {'studentnum':$('#paramStudentnum').val(),'name':$('#paramStudent').val(),'mobile': $('#paramMobile').val(),'qq': $('#paramQq').val(),'dormName': $('#paramDormName').val()};
		loadDataGrid(queryCondition);
	}
	function studentReset(){
		$('#paramStudentnum').textbox('setValue','');
		$('#paramStudent').textbox('setValue','');
		$('#paramMobile').textbox('setValue','');
		$('#paramQq').textbox('setValue','');
		$('#paramDormName').textbox('setValue','');
		loadDataGrid(null);
	}
	function openWin(dgrid,dtittle){
		$('#'+dgrid).dialog('open').dialog('setTitle',dtittle);
		loadClassGrid();
	}
	function loadDataGrid(queryConditon){
		 $('#dg').datagrid({  
	            title : '学生信息',  
	            iconCls : 'icon-ok',  
	            pageSize : 5,//默认选择的分页是每页5行数据  
	            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合  
	            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取  
	            striped : true,//设置为true将交替显示行背景。  
	            collapsible : true,//显示可折叠按钮  
	            toolbar:"#toolbar",//在添加 增添、删除、修改操作的按钮要用到这个  
	            url:'studentController.do?datagrid',//url调用Action方法  
	            loadMsg : '数据装载中......',  
	            singleSelect:false,//为true时只能选择单行  
	            fitColumns:true,//允许表格自动缩放，以适应父容器  
	            checkOnSelect:true,
	            selectOnCheck:true,
	            fit:true,
	            remoteSort : false,  
	            pagination : true,  
	            rownumbers : true,
	            queryParams:queryConditon
	        });   
	}
    function changeValue(value, row, index){
        if (value == "1") {
            return '男';
        }
        else {
            return '女';
        }
    }

		var url;
		function create(){
			$('#dlg').dialog('open').dialog('setTitle','新建');
			$('#fm').form('clear');
			url = 'studentController.do?save';
		}
		function edit(){
			var row = $('#dg').datagrid('getSelections');
			if (row.length == 1){
				$('#dlg-update').dialog('open').dialog('setTitle','编辑');
				$('#fm-update').form('clear');
				$('#fm-update').form('load',row[0]);
				url = 'studentController.do?update';
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
							url : 'studentController.do?delete',
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