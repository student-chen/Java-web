var flag = false;
var olds = "";
var idss = '';
$(function() {
	var str = $("#actionids").val();
	if (str != null) {
		ids = str.split("、");
	} else {
		ids = "";
	}
	if ($.inArray("查询岗位结构", ids) != -1) {
		findAll();
		switch1();
		switch2();
	} else {
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href = path + "main/main.jsp";
	}

});

/** **************************生成树***************************** */
function findAll() {
	$.ajax({
		url : $("#path").val() + "gw.do?method=all",
		type : "post",
		dataType : "json",
		async : false,
		success : function(data) {
			// datas = data;
			loadData(data);
		}
	});
}

function loadData(datas) {

	var zTreeObj;
	// zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
	function setFontCss(treeId, treeNode) {
		return treeNode.zjjs == null ? {
			color : "red"
		} : {};
	}
	;

	var setting = {
		view : {
			selectedMulti : false,
			fontCss : setFontCss

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
				idKey : "zjid", // 这里是自己要修改的
				pIdKey : "sjid", // 这里是自己要修改的
				rootPId : 0
			}
		},
		callback : {
			beforeRename : beforeRename, // 编辑结束时触发，用来验证输入的数据是否符合要求（调用下面的一个方法）
			onRename : onRename, // 编辑后触发，用于操作后台
			onDrop : drop, // 拖拽
			beforeDblClick : beforeDblClick,
			onDblClick : OnDblClicks, // 双击
			beforeDrag : beforeDrags, // 拖拽之前
			beforeEditName : beforeEditName,
			// 点击编辑时触发，用来判断该节点是否能编辑
			beforeDrop : myBeforeDrop
		}
	};
	// zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
	var treeNodes = datas;
	$(document).ready(function() {
		zTreeObj = $.fn.zTree.init($(".ztree"), setting, treeNodes);
	});
}

/** ****************************修改节点名称不能少于3个字符****************************** */
function beforeRename(treeId, treeNode, newName, isCancel) {
	var name = newName;
	var old = treeNode.name;
	var pid = treeNode.getParentNode().pid;
	olds = old;
	if (newName = "") {
		layer.msg("名称不能为空!", {
			icon : 1
		});
		return false;
	}
	$.ajax({
		url : $("#path").val() + "gw.do?method=repeat",
		type : 'post',
		data : {
			name : name,
			old : old,
			pid : pid
		},
		dataType : 'json',
		async : false,
		success : function(mydata) {
			if (mydata == 1) {
				layer.msg("名称已存在!", {
					icon : 1
				});
				flag = false;
			} else {
				flag = true;
			}
		}
	})
	return flag;
}
/** *******************完毕 ***************** */

/** ******************************修改节点名称*********************************** */
function onRename(e, treeId, treeNode, isCancel) {
	var pid = treeNode.getParentNode().pid;
	$.ajax({
		url : $("#path").val() + "gw.do?method=upps",
		type : "post",
		data : {
			"gid" : treeNode.gid,
			"gname" : treeNode.name,
			"gremark" : treeNode.gremark,
			"pid" : pid
		},
		async : false,
		success : function(data) {
			layer.msg("修改成功!", {
				icon : 1
			});
			flag = false;
		}
	})
}

/** *********************************修改完毕 ***************************** */

/** ************************不能修改根节点名称********************* */
function beforeEditName(treeId, treeNode) {
	if ($.inArray("修改组织结构", ids) == -1) {
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
	if (treeNode.zjjs != null) {
		layer.msg("不准编辑部门", {
			icon : 1
		});
		return false;
	}
	return true;
}
/** *************************不能修改根节点名称完毕**************************** */

/** *****************************拖拽方法***************************************** */
function drop(event, treeId, treeNodes, targetNode, moveType) {
	var id = treeNodes[0].gid; // 获得被拖拽的节点id
	var targetId = targetNode.pid; // 获得目标id

	$.ajax({
		url : $("#path").val() + "gw.do?method=uppss",
		type : "post",
		data : {
			"gid" : id,
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
/** ***************************拖拽完毕********************************** */
function myBeforeDrop(treeId, treeNodes, targetNode, moveType) {
	var ff = false;
	for (var i = 0; i < treeNodes.length; i++) {
		var pid = targetNode.pid;
		var name = treeNodes[i].name;
		$.ajax({
			url : $("#path").val() + "gw.do?method=repeat",
			type : 'post',
			data : {
				name : name,
				pid : pid
			},
			dataType : 'json',
			async : false,
			success : function(mydata) {
				if (mydata == 1) {
					if ($.inArray("修改组织结构", ids) == -1) {
						layer.msg("你没有权限!", {
							icon : 2
						});
					} else {
						layer.msg("该部门下岗位已存在！", {
							icon : 2
						});
					}
					ff = false;
				} else {
					if (targetNode.zjjs == null) {
						if ($.inArray("修改组织结构", ids) == -1) {
							layer.msg("你没有权限!", {
								icon : 2
							});
						} else {
							layer.msg("不可移动到岗位下！", {
								icon : 2
							});
						}
						ff = false;
					} else {
						if ($.inArray("修改组织结构", ids) == -1) {
							layer.msg("你没有权限!", {
								icon : 2
							});
							ff = false;
						} else {
							ff = true;
						}
					}
				}
			}
		})

	}
	return ff;
};

/** ***************************打开与关闭********************************* */
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
/** *************************************************** */

/** ****************************修改************************* */
function bindUpdate(id) {

	var index = layer.open({
		type : 2,
		title : '修改岗位',
		fix : false,
		shadeClose : true,
		maxmin : true,
		area : [ '400px', '350px' ],
		content : $("#path").val() + "station/tpart/update.jsp?id=" + id,
		skin : 'layui-layer-lan',
		shift : 4, // 0-6的动画形式，-1不开启
		end : function() {
			findAll();
			$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
		}
	});
}
function beforeDblClick(treeId, treeNode) {
	if ($.inArray("修改组织结构", ids) == -1) {
		layer.msg("你没有权限!", {
			icon : 2
		});
		return false;
	} else {
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
	bindUpdate(treeNode.gid);
};
/** ********************************修改*************************************** */

/** ****************************不能把根节点移到任何一个节点下***************************** */
function beforeDrags(treeId, treeNodes) {

	if (treeNodes[0].zjid == "0") {

		layer.msg("管理员不可降级", {
			icon : 1
		});
		return false;
	}
	for (var i = 0; i < treeNodes.length; i++) {
		if (treeNodes[i].zjjs != null) {
			layer.msg("部门不可拖", {
				icon : 1
			});
			return false;
		}
	}

	return true;
};

