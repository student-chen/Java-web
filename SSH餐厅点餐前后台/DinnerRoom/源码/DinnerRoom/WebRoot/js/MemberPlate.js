function check() {
		var memberType = $("#memberType").val();
		var name = $("#name").val();
		var phone = $("#mphone").val();
		var regphone = /^1[3|4|5|8|9|6|7][0-9]\d{8}$/;
		if (memberType == -1) {
			layer.msg('请选择会员类型！');
			return false;
		} else if (!name) {
			layer.msg('请输入会员名字！');
			return false;
		} else if (!phone) {
			layer.msg('请输入手机号！');
			return false;
		} else if (!regphone.test(phone)) {
			layer.msg('手机号格式有误！');
			return false;
		} else {
			return true;
		}
	}
	$(function() {
		$.post("QTgetMemberType", "1", function(res) {
			var memberTypestr = "<option value='-1' selected>请选择会员类型</option>";
			$.each(JSON.parse(res), function(index, dom) {
				memberTypestr += "<option value='"+dom.id+"'>" + dom.typeName
						+ "</option>";
			});
			$("#memberType").append(memberTypestr);
		});
		layui.use('table', function() {
			var table = layui.table;
			//执行渲染
			table.render({
				elem : '#tabs', //指定原始表格元素选择器（推荐id选择器）
				url : "getMember",
				id : "rolad",
				//height : 400, //容器高度
				page : true,
				limits : [ 10, 30, 90, 150, 300 ],
				limit : 10 //相当于pagesize
				,
				cols : [ [ {
					checkbox : true,
					fixed : false
				}, {
					field : 'id',
					sort : true,
					title : 'ID'
				}, {
					field : 'name',
					title : '姓名'
				}, {
					field : 'memberType',
					title : '会员类型',
					templet : '#member'
				}, {
					field : 'phone',
					title : '电话'
				}, {
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
					url : "getMember",
					method : 'post',
					page : {
						curr : 1
					//重新从第 1 页开始
					},
					where : {
						phone : $("#phone").val()
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
					layer.confirm('真的删除' + data.name + '么', function(index) {
						$.post("QTdelMember", "delid=" + data.id,
								function(res) {
									if (res == 1) {
										//执行重载
										table.reload('rolad', {
											url : "getMember",
											method : 'post',
											page : {
												curr : 1
											//重新从第 1 页开始
											}
										});
										layer.msg('删除成功！');
									} else {
										layer.msg('删除失败！');
									}
								});
					});
				} else if (obj.event === 'edit') {
					$("#memberType").val(data.memberType.id);
					$("#name").val(data.name);
					$("#mphone").val(data.phone);
					$("#mid").val(data.id);
					$("#mcode").val(data.mcode);
					$('#myModal').modal();
				}
			});
		});
		//刷新
		$("#refresh").click(function() {
			location.reload();//刷新当前页面
		});
		// 在模态框关闭时执行一些动作（清空模态框内的信息）
		$('#myModal').on('hidden.bs.modal', function() {
			$("#memberType").val(-1);
			$("#name").val("");
			$("#mphone").val("");
			$("#mid").val("");
			$("#mcode").val("");
		});
		$("#sub").click(
				function() {
					var mid = $("#mid").val();
					if (!check()) {
						return;
					}
					var memberType = $("#memberType").val();
					var name = $("#name").val();
					var mphone = $("#mphone").val();
					var mcode = $("#mcode").val();
					if (mid == "") {
						$.post("QTAddMember","memberType=" + memberType + "&name=" + name + "&mphone=" + mphone,function(res) {
							if(res==-1){
								layer.msg('手机号已存在！');
								return;
							}
							if(res==-2){
								layer.msg('添加失败！');
								return;
							}
							if(res==1){
								layer.open({
			                        title: '提示！',
			                        content: '添加成功！',
			                        btn: ['确定'],
			                        yes:function(index, layero){
			                        	location.reload();//刷新当前页面
			                        }
			                    });
							}
						});
						//alert("添加");
					} else {
						$.post("QTupdateMember", "mid=" + mid + "&memberType=" + memberType+ "&name=" + name + "&mphone=" + mphone+"&mcode="+mcode,function(res) {
							if(res==1){
								layer.open({
			                        title: '提示！',
			                        content: '修改成功！',
			                        btn: ['确定'],
			                        yes:function(index, layero){
			                        	location.reload();//刷新当前页面
			                        }
			                    });
							}else{
								layer.msg('修改失败！');
							}
						});
						//alert("修改");
					}
				});
	});