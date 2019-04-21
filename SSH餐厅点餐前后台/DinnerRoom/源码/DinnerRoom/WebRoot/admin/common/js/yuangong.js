layui.use('table', function() {
		var table = layui.table;
		//执行渲染
		table.render({
			elem : '#tabs', //指定原始表格元素选择器（推荐id选择器）
			url : "getallusers",
			id : "rolad",
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
				field : 'ULoginname',
				title : '登录名'
			},{
				field : 'UPwd',
				title : '登录密码'
			},{
				field : 'UName',
				title : '姓名'
			},{
				field : 'USex',
				sort : true,
				title : '性别'
			},{
				field : 'UPhone',
				title : '电话'
			},{
				field : 'UIdcard',
				title : '身份证号'
			},{
				field : 'UAddress',
				title : '地址'
			},{
				field : 'URole',
				title : '权限',
				templet : '#quanxian'
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
				url : "getallusers",
				method: 'post',
				page : {
					curr : 1 //重新从第 1 页开始
				},
				where : {
					name : $("#name").val(),
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
				if(data.id==1){
					layer.msg('管理员禁止删除');
					return;
				}
				layer.confirm('真的删除员工<'+data.UName+'>吗？', function(index) {
					$.post("deluser","delid="+data.id,function(res){
						if(res==1){
							//执行重载
							table.reload('rolad', {
								url : "getallusers",
								method: 'post',
								page : {
									curr : 1 //重新从第 1 页开始
								}
							});
							layer.msg('删除成功！');
						}else{
							//执行重载
							table.reload('rolad', {
								url : "getallusers",
								method: 'post',
								page : {
									curr : 1 //重新从第 1 页开始
								}
							});
							layer.msg('删除失败！');
						}
					});
				});
			} else if (obj.event === 'edit') {
				location.href='getoneUser?uid='+data.id+'';
			}
		});
	});