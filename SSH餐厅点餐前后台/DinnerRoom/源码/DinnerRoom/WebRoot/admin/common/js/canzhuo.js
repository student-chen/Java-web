layui.use('table', function() {
	var table = layui.table;
	// 执行渲染
	table.render({
		elem : '#tabs', // 指定原始表格元素选择器（推荐id选择器）
		url : "getTable",
		id : "rolad",
		page : true,
		limits : [ 10, 30, 90 ],
		limit : 10, // 相当于pagesize
		cols : [ [ {
			field : 'id',
			sort : true,
			title : '序列'
		}, {
			field : 'tableNum',
			title : '座位号'
		}, {
			field : 'tablePernum',
			title : '可坐人数'
		}, {
			title : '操作',
			width : 178,
			align : 'center',
			toolbar : '#bar'
		} ] ]
	// 设置表头
	});
	// 监听表格复选框选择
	table.on('checkbox(tab)', function(obj) {
		console.log(obj);
	});
	// 监听工具条
	table.on('tool(tab)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.confirm('真的删除' + data.tableNum + '号餐桌吗？', function(index) {
				$.post("deltable", "delid=" + data.id, function(res) {
					if (res > 0) {
						table.reload('rolad', {
							url : "getTable",
							method : 'post',
							page : {
								curr : 1
							// 重新从第 1 页开始
							}
						});
						layer.msg('删除成功！');
					} else {
						layer.msg('删除失败！');
					}
				});
			});
		} else if (obj.event === 'edit') {
			location.href = 'getTableUpInfo?upid=' + data.id + '';
			// layer.alert('编辑行：<br>' + JSON.stringify(data));
		}
	});
});