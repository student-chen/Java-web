<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/pages/system/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>成绩管理</title>
</head>
<body>
	<table id="dg" class="" title="列表" style="width: 700px; height: 300px">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'studentEntity.studentnum',width:80" formatter="stuNumValue">学号</th>
				<th data-options="field:'studentEntity.name',width:80" formatter="objValue">学生姓名</th>
				<th data-options="field:'coursename',width:80">课程名称</th>
				<th data-options="field:'score',width:80">分数</th>
				<th data-options="field:'term',width:80">学期</th>
				<th data-options="field:'classname',width:80">班级名称</th>
				<th data-options="field:'teacherEntity.teachername',width:80" formatter="teacherValue">教师姓名</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton add" iconCls="icon-add" onclick="create()" plain="true">新增</a> 
		<a href="#" class="easyui-linkbutton edit" iconCls="icon-edit" onclick="edit()" plain="true">修改</a> 
		<a href="#" class="easyui-linkbutton remove" iconCls="icon-remove" onclick="del()" plain="true">删除</a>
		<a href="#" class="easyui-linkbutton save" iconCls="icon-save" onclick="upload()" plain="true">excel导入</a>
		<a href="#" class="easyui-linkbutton back" iconCls="icon-back" onclick="exportExcel()" plain="true">excel导出</a>
		<div>
			学生姓名: <input class="easyui-textbox" id="paramName">
			教师姓名: <input class="easyui-textbox" id="paramTeachername">
			课程名称: <input class="easyui-textbox" id="paramCourse">
			学期: <input class="easyui-textbox" id="paramTerm">
			<a href="#" class="easyui-linkbutton" onclick="doSearch()" iconCls="icon-search">查找</a>
			<a href="#" class="easyui-linkbutton" onclick="doReset()" iconCls="icon-redo">重置</a>
			
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="数据参数" data-options="modal:true" style="width: 450px; height: 400px; top: 100px" closed="true" buttons="#dlg-buttons">
		<form method="post" id="fm">
			<table cellpadding="5">
				<tr>
					<td><input type="hidden" id="id" name="id" /></td>
				</tr>
	    		<tr>
	    			<td>学生:</td>
	    			<td>
	    				<input type="hidden" name="studentid" id="studentid"></input>
	    				<input class="easyui-textbox" readonly="readonly" required="true"  type="text" name="name" id="name"></input>
	    				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="openWin('studentdg','学生信息');" >选择</a>
	    				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="clearText('studentid','studentname');" >清空</a>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>课程名称:</td>
	    			<td><input class="easyui-textbox" id="coursename" type="text" name="coursename" maxlength="10" required="true" missingMessage="课程名称必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>分数:</td>
	    			<td><input class="easyui-textbox" id="score" type="text" name="score" maxlength="10" validtype="intOrFloat" required="true" missingMessage="成绩必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>学期:</td>
	    			<td><input class="easyui-textbox" id="term" type="text" name="term" maxlength="10" required="true" missingMessage="学期名称必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>班级:</td>
	    			<td><input class="easyui-textbox" id="classname" type="text" name="classname" maxlength="10" required="true" missingMessage="班级必须填写"></input></td>
	    		</tr>
	    		<tr>
	    			<td>教师:</td>
	    			<td>
	    				<input type="hidden" name="teacherid" id="teacherid"></input>
	    				<input class="easyui-textbox" readonly="readonly" required="true"  type="text" name="teachername" id="teachername"></input>
	    				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="openTeacherWin('teacherdg','教师信息');" >选择</a>
	    				<a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="clearText('teacherid','teachername');" >清空</a>
	    			</td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="save()" iconCls="icon-ok">保存</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#dlg').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	
	<div id="teacherdg" class="easyui-dialog" title="数据" style="width: 350px; height: 450px; top: 80px;" data-options="modal:true" closed="true" buttons="#dlgTeacher-buttons">
		<table id="teachertable" class="" title="列表" style="width: 700px; height: 300px">
			<thead>
				<tr>
					<th data-options="field:'teachernum',width:80">工号</th>
					<th data-options="field:'teachername',width:80">教师姓名</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="teachertoolbar">
		<div>
			教师姓名: <input class="easyui-textbox" id="paramTeacherName">
			<br/>
			<a href="#" class="easyui-linkbutton" onclick="teacherSearch()" iconCls="icon-search">查找</a>
			<a href="#" class="easyui-linkbutton" onclick="teacherReset()" iconCls="icon-redo">重置</a>
		</div>
	</div>
	<div id="dlgTeacher-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="afterTeacherSelect('teachertable','teacherdg','teacherid','teachername')" iconCls="icon-ok">确定</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#teacherdg').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	
	<div id="studentdg" class="easyui-dialog" title="数据" style="width: 350px; height: 450px; top: 80px;" data-options="modal:true" closed="true" buttons="#dlgClass-buttons">
		<table id="studenttable" class="" title="列表" style="width: 700px; height: 300px">
			<thead>
				<tr>
					<th data-options="field:'studentnum',width:80">学号</th>
					<th data-options="field:'name',width:80">学生姓名</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="studenttoolbar">
		<div>
			学生姓名: <input class="easyui-textbox" id="paramStudentName">
			<br/>
			<a href="#" class="easyui-linkbutton" onclick="studentSearch()" iconCls="icon-search">查找</a>
			<a href="#" class="easyui-linkbutton" onclick="studentReset()" iconCls="icon-redo">重置</a>
		</div>
	</div>
	<div id="dlgClass-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="afterSelect('studenttable','studentdg','studentid','name')" iconCls="icon-ok">确定</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#studentdg').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	
	<div id="dlg-upload" class="easyui-dialog" title="excel导入" data-options="modal:true" style="width: 350px; height: 130px; top: 80px;" closed="true"  buttons="#upload-buttons">
		<form method="post" id="fm-upload" enctype="multipart/form-data" >
			<table>
	    		<tr>
	    			<td>上传excel:</td>
	    			<td><input class="easyui-filebox"  style="width:240px" accept="application/vnd.ms-excel" id="scoreExcel" name="scoreExcel" data-options="prompt:'请选择文件...'"></input></td>
	    		</tr>
	    	</table>
		</form>
	</div>
	
	<div id="upload-buttons">
		<a href="#" class="easyui-linkbutton  save" onclick="uploadExcel()" iconCls="icon-ok">上传</a> 
		<a href="#" class="easyui-linkbutton cancel" onclick="javascript:$('#dlg-upload').dialog('close')" iconCls="icon-cancel">取消</a>
	</div>
	<script type="text/javascript">
	$(function() {  
		loadDataGrid();
    });  	
	 function afterSelect(targetDg,targetDlg,valueId,valueName){
	    	var row = $("#"+targetDg).datagrid('getSelections');
	    	if (row.length >= 1){
	    		var ids;
	    		var names;
	    		for(var i=0;i<row.length;i++){
	    			if(ids == null){
	    				ids = row[i].id;
	    			}else{
	    				ids = ids+","+row[i].id;
	    			}
	    			if(names == null){
	    				names = row[i].name;
	    			}else{
	    				names = names+","+row[i].name;
	    			}
	    		}
	    		$("#"+valueId).val(ids);
	    		$("#"+valueName).textbox('setValue',names);
	    		$("#"+targetDlg).dialog('close');	
	    	}else{
	    		$.messager.show({
	    			title: '提示信息',
	    			msg: '您未选择任何数据！'
	    		});
	    	}
	    }
	 
	 function afterTeacherSelect(targetDg,targetDlg,valueId,valueName){
	    	var row = $("#"+targetDg).datagrid('getSelections');
	    	if (row.length >= 1){
	    		var ids;
	    		var names;
	    		for(var i=0;i<row.length;i++){
	    			if(ids == null){
	    				ids = row[i].id;
	    			}else{
	    				ids = ids+","+row[i].id;
	    			}
	    			if(names == null){
	    				names = row[i].teachername;
	    			}else{
	    				names = names+","+row[i].teachername;
	    			}
	    		}
	    		$("#"+valueId).val(ids);
	    		$("#"+valueName).textbox('setValue',names);
	    		$("#"+targetDlg).dialog('close');	
	    	}else{
	    		$.messager.show({
	    			title: '提示信息',
	    			msg: '您未选择任何数据！'
	    		});
	    	}
	    }
	 
	 function loadTeacherGrid(queryConditon){
		 $('#teachertable').datagrid({  
	            title : '教师信息',  
	            iconCls : 'icon-ok',  
	            pageSize : 5,
	            pageList : [ 5, 10, 15, 20 ],
	            nowrap : true,
	            striped : true,
	            collapsible : true,  
	            toolbar:"#teachertoolbar", 
	            url:'teacherController.do?datagrid',
	            loadMsg : '数据装载中......',  
	            singleSelect:true,
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
	 function loadStudentGrid(queryConditon){
		 $('#studenttable').datagrid({  
	            title : '学生信息',  
	            iconCls : 'icon-ok',  
	            pageSize : 5,
	            pageList : [ 5, 10, 15, 20 ],
	            nowrap : true,
	            striped : true,
	            collapsible : true,  
	            toolbar:"#studenttoolbar", 
	            url:'studentController.do?datagrid',
	            loadMsg : '数据装载中......',  
	            singleSelect:true,
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
	function loadDataGrid(queryConditon){
		 $('#dg').datagrid({  
	            title : '成绩信息',  
	            iconCls : 'icon-ok',  
	            pageSize : 5,
	            pageList : [ 5, 10, 15, 20 ],
	            nowrap : true,
	            striped : true,
	            collapsible : true,  
	            toolbar:"#toolbar", 
	            url:'scoreController.do?datagrid',
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
	function upload(){
		$('#dlg-upload').dialog('open').dialog('setTitle','excel导入');
		$('#fm-upload').form('clear');
	}
		var url;
		function create(){
			$('#dlg').dialog('open').dialog('setTitle','新建');
			$('#fm').form('clear');
			url = 'scoreController.do?save';
		}
		function edit(){
			var row = $('#dg').datagrid('getSelections');
			if (row.length == 1){
				$('#dlg').dialog('open').dialog('setTitle','编辑');
				$('#fm').form('clear');
				$('#id').val(row[0].id);
				$('#name').textbox('setValue',row[0].studentEntity.name);
				$('#studentid').val(row[0].studentEntity.id);
				$('#teachername').textbox('setValue',row[0].teacherEntity.teachername);
				$('#teacherid').val(row[0].teacherEntity.id);
				$('#score').textbox('setValue',row[0].score);
				$('#term').textbox('setValue',row[0].term);
				$('#classname').textbox('setValue',row[0].classname);
				$('#coursename').textbox('setValue',row[0].coursename);
				url = 'scoreController.do?update';
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
		
		function doSearch(){
			var queryCondition = {'name':$('#paramName').val(),'teachername':$('#paramTeachername').val(),'coursename': $('#paramCourse').val(),'term': $('#paramTerm').val()};
			loadDataGrid(queryCondition);
		}
		function doReset(){
			$('#paramName').textbox('setValue','');
			$('#paramTeachername').textbox('setValue','');
			$('#paramCourse').textbox('setValue','');
			$('#paramTerm').textbox('setValue','');
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
							url : 'scoreController.do?delete',
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
		
		function exportExcel(){
			var params = "";
			if($('#paramName').val() != ""){
				params = params + "&name=" + $('#paramName').val();	
			}
			if($('#paramTeachername').val() != ""){
				params = params + "&teachername=" + $('#paramTeachername').val();	
			}
			if($('#paramCourse').val() != ""){
				params = params + "&coursename=" + $('#paramCourse').val();	
			}
			if($('#paramTerm').val() != ""){
				params = params + "&term=" + $('#paramTerm').val();	
			}
			
			window.location.href = "scoreController.do?exportExcel"+ encodeURI(encodeURI(params));
		}
		
		function uploadExcel(){
			$('#fm-upload').form('submit',{
				url: "scoreController.do?uploadScore",
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						$('#dlg-upload').dialog('close');		
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
		
	    function objValue(value, row, index){
	    	return row['studentEntity']['name'];
	    }
	    function stuNumValue(value, row, index){
	    	return row['studentEntity']['studentnum'];
	    }
	    function teacherValue(value, row, index){
	    	return row['teacherEntity']['teachername'];
	    }
	    function studentSearch(){
			var queryCondition = {'name':$('#paramStudentName').val()};
			loadStudentGrid(queryCondition);
		}
		function studentReset(){
			$('#paramStudentName').textbox('setValue','');
			loadStudentGrid(null);
		}
		
		function teacherSearch(){
			var queryCondition = {'teachername':$('#paramTeacherName').val()};
			loadTeacherGrid(queryCondition);
		}
		function teacherReset(){
			$('#paramTeacherName').textbox('setValue','');
			loadTeacherGrid(null);
		}
		function openWin(dgrid,dtittle){
	    	$('#'+dgrid).dialog('open').dialog('setTitle',dtittle);
	    	loadStudentGrid();
	    }
		function openTeacherWin(dgrid,dtittle){
	    	$('#'+dgrid).dialog('open').dialog('setTitle',dtittle);
	    	loadTeacherGrid();
	    }
	</script>
	
</body>
</html>