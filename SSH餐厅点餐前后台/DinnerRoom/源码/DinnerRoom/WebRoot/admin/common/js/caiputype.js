layui.use('table', function() {
	var table = layui.table;
	// 执行渲染
	table.render({
		elem : '#tabs' // 指定原始表格元素选择器（推荐id选择器）
		,
		url : "getallMenuType",
		id : "rolad",
		height : 400 // 容器高度
		,
		page : true,
		limits : [ 10, 30, 90, 150 ],
		limit : 10 // 默认采用60
		,
		cols : [ [ {
			checkbox : true,
			fixed : false
		}, {
			field : 'id',
			sort : true,
			title : 'ID'
		}, {
			field : 'typeName',
			title : '菜肴类型名称'
		}, {
			title : '操作',
			width : 178,
			align : 'center',
			toolbar : '#bar'
		} ] ]
	// 设置表头
	});

	$("#addcaiputype").click(function() {
		var type_name = $("#type_name").val();
		if (!type_name) {
			layer.msg('请填写要添加的菜肴类型');
			return;
		}
		layer.confirm('菜肴类型：' + type_name + '<br/>确定添加么？', function(index) {
			$.post("addMenuType", "type_name=" + type_name, function(res) {
				if (res == -1) {
					layer.msg('添加类型已经存在！');
					return;
				}
				if (res > 0) {
					// 执行重载
					table.reload('rolad', {
						url : "getallMenuType",
						method : 'post',
						page : {
							curr : 1
						// 重新从第 1 页开始
						}
					});
					layer.msg('添加成功！');
				} else {
					// 执行重载
					table.reload('rolad', {
						url : "getallMenuType",
						method : 'post',
						page : {
							curr : 1
						// 重新从第 1 页开始
						}
					});
					layer.msg('添加失败！');
				}
			});
		});
	});
	// 监听表格复选框选择
	table.on('checkbox(tab)', function(obj) {
		console.log(obj);
	});
	// 监听工具条
	table.on('tool(tab)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.confirm('真的删除' + data.typeName + '么', function(index) {
				$.post("delmenuType", "delid=" + data.id, function(res) {
					if (res == -1) {
						layer.msg('该类型存在数据，不可删除！');
						return;
					}
					if (res == 1) {
						// 执行重载
						table.reload('rolad', {
							url : "getallMenuType",
							method : 'post',
							page : {
								curr : 1
							// 重新从第 1 页开始
							}
						});
						layer.msg('删除成功！');
					} else {
						// 执行重载
						table.reload('rolad', {
							url : "getallMenuType",
							method : 'post',
							page : {
								curr : 1
							// 重新从第 1 页开始
							}
						});
						layer.msg('删除失败！');
					}
				});
			});
		}
	});
});