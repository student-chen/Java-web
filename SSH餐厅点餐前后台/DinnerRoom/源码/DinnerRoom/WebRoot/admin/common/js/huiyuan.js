layui.use('table', function() {
		var table = layui.table;
		//执行渲染
		table.render({
			elem : '#tabs', //指定原始表格元素选择器（推荐id选择器）
			url : "getallMember",
			id : "rolad",
			height : 400, //容器高度
			page : true,
			limits : [ 10, 30, 90, 150, 300 ],
			limit : 10 //相当于pagesize
			,cols : [ [ {
				checkbox : true,
				fixed : false
			}, {
				field : 'id',
				sort : true,
				title : 'ID'
			}, {
				field : 'name',
				title : '姓名'
			},{
				field : 'memberType',
				title : '会员类型',
				templet : '#memberType'
			},{
				field : 'phone',
				title : '电话'
			},{
				field : 'mcode',
				sort : true,
				title : '会员积分'
			}, {
				title : '操作',
				width : 178,
				align : 'center',
				toolbar : '#bar'
			} ] ]
		//设置表头
		});
		//重载表格（多条件查询）
		$("#search").click(function() {
			//执行重载
			table.reload('rolad', {
				url : "getallMember",
				method: 'post',
				page : {
					curr : 1 //重新从第 1 页开始
				},
				where : {
					phone : $("#phone").val(),
					mtype : $("#mtype").val()
				}
			});
		});
		//监听表格复选框选择
		table.on('checkbox(tab)', function(obj) {
			console.log(obj);
		});
		//监听工具条
		table.on('tool(tab)', function(obj) {
			var data = obj.data;
			if (obj.event === 'del') {
				layer.confirm('真的删除'+data.name+'么', function(index) {
					$.post("delMember","delid="+data.id,function(res){
						if(res==1){
							//执行重载
							table.reload('rolad', {
								url : "getallMember",
								method: 'post',
								page : {
									curr : 1 //重新从第 1 页开始
								}
							});
							layer.msg('删除成功！');
						}else{
							layer.msg('删除失败！');
						}
					});
				});
			} else if (obj.event === 'edit') {
				location.href='showUpMember?upid='+data.id+'';
				//layer.alert('编辑行：<br>' + JSON.stringify(data));
			}
		});
	});