layui.use('form', function() {
	var form = layui.form;
});
layui.use('table', function() {
	var table = layui.table;
	// 执行渲染
	table.render({
		elem : '#tabs', // 指定原始表格元素选择器（推荐id选择器）
		url : "getallmenu",
		id : "rolad",
		height : 410, // 容器高度
		page : true,
		limits : [ 3, 10, 30, 90, 150, 300 ],
		limit : 3 // 相当于pagesize
		,
		cols : [ [ {
			checkbox : true,
			fixed : false
		}, /*
			 * { field : 'id', width : 80, sort : true, title : 'ID' },
			 */{
			field : 'MName',
			title : '菜名'
		}, {
			field : 'menuType',
			sort : false,
			title : '类型',
			templet : '#menuType'
		}, {
			field : 'MPrice',
			title : '价格'
		}, {
			field : 'imagePath',
			title : '图片',
			templet : '#img',
			style : 'width:118px;height:118px;'
		}, {
			field : 'remark',
			title : '说明'
		}, {
			title : '操作',
			width : 150,
			align : 'center',
			toolbar : '#bar'
		} ] ]
	// 设置表头
	});
	// 重载表格（多条件查询）
	$("#search").click(function() {
		// 执行重载
		table.reload('rolad', {
			url : "getallmenu",
			method : 'post',
			page : {
				curr : 1
			// 重新从第 1 页开始
			},
			where : {
				m_name : $("#m_name").val(),
				m_type : $("#m_type").val()
			}
		});
	});
	// 监听表格复选框选择
	table.on('checkbox(tab)', function(obj) {
		console.log(obj);
	});
	// 监听工具条
	table.on('tool(tab)',
			function(obj) {
				var data = obj.data;
				if (obj.event === 'del') {
					layer.confirm('真的删除' + data.MName + '么', function(index) {
						$.post("delmenu", "delid=" + data.id + "&imgpath="
								+ data.imagePath, function(res) {
							if (res > 0) {
								layer.msg('删除成功！');
								table.reload('rolad', {
									url : "getallmenu",
									method : 'post',
									page : {
										curr : 1
									// 重新从第 1 页开始
									}
								});
							} else {
								layer.msg('删除失败！');
							}
						});
					});
				} else if (obj.event === 'edit') {
					location.href = 'getUpdateMenuInfo?getUpMenuInfoid='
							+ data.id + '';
				}
			});
});