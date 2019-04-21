var flag=false;
var olds="";
var idss='';
$(function() {
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	if($.inArray("查询员工管理",ids)!=-1){
		findAll();
		switch1();
		switch2();
	}else{
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("增加员工管理",ids)==-1){
		$("#addMaster").remove();
	}
	getAdd();
});


/****************************生成树******************************/
function findAll() {
	$.ajax({
		url : $("#path").val() + "master.do?method=all",
		type : "post",
		dataType : "json",
		async : false,
		success : function(data) {
			//datas = data;
			loadData(data);
		}
	});
}

function loadData(datas) {

	var zTreeObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	function setFontCss(treeId, treeNode) {
		return treeNode.zjjs==null ? {color:"red"} : {};
	};

	var setting = {
		view : {
			selectedMulti : false,
			fontCss: setFontCss

		},
		
		edit : {
			enable : true,
			editNameSelectAll : true,
			showRemoveBtn : false,
			renameTitle : '重命名'
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "zjid",  //这里是自己要修改的
				pIdKey : "sjid", //这里是自己要修改的
				rootPId : 0
			}
		},
		callback : {
			beforeRename : beforeRename, // 编辑结束时触发，用来验证输入的数据是否符合要求（调用下面的一个方法）
			onRename : onRename, // 编辑后触发，用于操作后台
			onDrop : drop, // 拖拽
			beforeDblClick: beforeDblClick,
			onDblClick : OnDblClicks, // 双击
			onRightClick: myOnRightClick,
			beforeDrag : beforeDrags, // 拖拽之前
			beforeEditName : beforeEditName,
		  // 点击编辑时触发，用来判断该节点是否能编辑
			beforeDrop: myBeforeDrop
		}
	};
	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	var treeNodes = datas;
	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($(".ztree"), setting, treeNodes);
	});
}

/******************************修改节点名称不能少于3个字符*******************************/
function beforeRename(treeId, treeNode, newName, isCancel) {
	var name=newName;
	var old=treeNode.name;
	olds=old;
	if(newName=""){
		layer.msg("名称不能为空!", {
			icon : 1
		});
		return false;
	}
}
/*********************完毕 ******************/

/********************************修改节点名称************************************/
function onRename(e, treeId, treeNode, isCancel) {
		$.ajax({
			url : $("#path").val() + "master.do?method=upps",
			type : "post",
			data : {
				"mid" : treeNode.mid,
				"mrealname" : treeNode.name,
			},
			async : false,
			success : function(data) {
				layer.msg("修改成功!", {
					icon : 1
				});
				flag=false;
			}
		})
}


/***********************************修改完毕 ******************************/

/**************************不能修改根节点名称**********************/
function beforeEditName(treeId, treeNode) {
	if($.inArray("修改员工管理",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 2
		});
		return false;
	}
	if (treeNode.zjid == "0") {

		layer.msg("不准编辑管理员", {
			icon : 1
		});

		return false;
	}
	if(treeNode.zjjs!=null){
		layer.msg("不准编辑部门", {
			icon : 1
		});
		return false;
	}
	return true;
}
/***************************不能修改根节点名称完毕*****************************/

function myBeforeDrop(treeId, treeNodes, targetNode, moveType) {
	if($.inArray("修改员工管理",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 2
		});
		return false;
	}else{
		if(targetNode.zjjs==null){
			layer.msg("不可移动到员工下！", {
				icon : 2
			});
			return false;
		}else{
			return true;
		}
	}
		
};

/*******************************拖拽方法******************************************/
function drop(event, treeId, treeNodes, targetNode, moveType) {
	var id = treeNodes[0].mid; // 获得被拖拽的节点id
	var targetId = targetNode.pid; // 获得目标id
	$.ajax({
		url : $("#path").val() + "master.do?method=uppss",
		type : "post",
		data : {
			"mid" : id,
			"pid" : targetId
		},
		async : false,
		success : function(data) {
			layer.msg("移动成功!", {
				icon : 1
			});
		}

	});
};
/*****************************拖拽完毕***********************************/

/*****************************打开与关闭**********************************/
function switch1() {
	$("#switch1").click(function() {
		$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
	});
}
function switch2() {
	$("#switch2").click(function() {
		$.fn.zTree.getZTreeObj("treeDemo").expandAll(false);
	});
}
/******************************************************/

function myOnRightClick(event, treeId, treeNode) {
	window.location.href=$("#path").val()+"master/tpart/one.jsp?id="+treeNode.mid; 
};
/******************************修改**************************/
function bindUpdate(id) {

	var index = layer.open({
		type : 2,
		title : '修改员工',
		fix : false,
		shadeClose : true,
		maxmin : true,
		area : [ '410px', '550px' ],
		content : $("#path").val() + "master/tpart/update.jsp?id=" + id,
		skin : 'layui-layer-lan',
		shift : 4, // 0-6的动画形式，-1不开启,
		success : function(layero, index) {
			layer.style(index, {
				top : '50px',
			});
		},
		end : function() {
			findAll();
			$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
		}
	});
}
function beforeDblClick(treeId, treeNode) {
	if($.inArray("修改员工管理",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 2
		});
		return false;
	}else{
		return true;
	}
};
function OnDblClicks(event, treeId, treeNode) {
	if (treeNode.zjid == "0") {
		return false;
	}
	if (treeNode.zjjs != null) {
		return false;
	}
	bindUpdate(treeNode.mid);
};
/**********************************修改****************************************/

function getAdd() {
	$("#addMaster").click(function() {
		var index = layer.open({
			type : 2,
			title : '添加员工',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '420px', '550px' ],
			content : path + "master/tpart/add.jsp",
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			success : function(layero, index) {
					layer.style(index, {
						top : '50px',
					});
				},
			end : function() {
				 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	             parent.layer.close(index);
	         	findAll();
			}
		});
	});
}

/******************************不能把根节点移到任何一个节点下******************************/
function beforeDrags(treeId, treeNodes) {

	return false;
};


