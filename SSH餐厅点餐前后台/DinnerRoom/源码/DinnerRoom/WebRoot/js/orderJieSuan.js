function Format(datetime) {
		var date = new Date(datetime);
		var y = date.getFullYear();
		var mouth = date.getMonth()+1;
		var d = date.getDate();
		var H = date.getHours();
		var min = date.getMinutes();
		var s = date.getSeconds();
		return y+"年"+mouth+"月"+d+"日  "+H+"："+min+"："+s;
	}
    layui.use('table', function() {
		var table = layui.table;
		//执行渲染
		table.render({
			elem : '#tabs', //指定原始表格元素选择器（推荐id选择器）
			url : "OrderJieSuan",
			id : "rolad",
			page : true,
			limits : [ 8, 30, 90, 150, 300 ],
			limit : 8 //相当于pagesize
			,cols : [ [ {
				field : 'id',
				sort : true,
				title : '订单号'
			}, {
				field : 'tableId',
				title : '餐桌号'
			},{
				field : 'ordertime',
				title : '订单时间',
				templet: '<div>{{ Format(d.ordertime.time)}}</div>'
			},{
				field : 'usercode',
				title : '下单人员编号'
			},{
				field : 'personnum',
				title : '餐桌人数'
			},{
				field : 'price',
				title : '订单总金额'
			},{
				field : 'ispay',
				title : '是否支付',
				templet : '#ispaytmp'
			},{
				title : '操作',
				align : 'center',
				toolbar : '#bar'
			} ] ]
		//设置表头
		});
		//刷新
		$("#refresh").click(function() {
			location.reload();//刷新当前页面
		});
		//重载表格（多条件查询）
		$("#search").click(function() {
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();
			if(startTime=="" && endTime!=""){
				layer.msg('请选择开始时间');
				return;
			}
			if(startTime!="" && endTime==""){
				layer.msg('请选择结束时间');
				return;
			}
			if(new Date(startTime)>new Date(endTime)){
				layer.msg('开始时间需小于结束时间');
				return;
			}
			//执行重载
			table.reload('rolad', {
				url : "OrderJieSuan",
				method: 'post',
				page : {
					curr : 1 //重新从第 1 页开始
				},
				where : {
					ispay : $("#ispay").val(),
					startTime : startTime,
					endTime : endTime
				}
			});
		});
		//监听工具条
        table.on('tool(tab)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
            	//订单详情
            	$.post("getnoticeByid","id="+data.id,function(res){
            		if(res.length>0){
            			var sumAllPrice = 0;
	            		var str = "<table width='100%' style='border: 1px solid #C0C0C0;text-align: center;'>";
	            		str += "<tr>";
	            		str += "<td width='10%'>";
	            		str += "<b>订单编号</b>";
	            		str += "</td>";
	            		str += "<td>";
	            		str += "<b>菜名</b>";
	            		str += "</td>";
	            		str += "<td>";
	            		str += "<b>单价</b>";
	            		str += "</td>";
	            		str += "<td>";
	            		str += "<b>数量</b>";
	            		str += "</td>";
	            		str += "<td>";
	            		str += "<b>总价</b>";
	            		str += "</td>";
	            		str += "<td>";
	            		str += "<b>备注</b>";
	            		str += "</td>";
	            		str += "</tr>";
	            		$.each(res,function(index,dom){
	            			var menuPrice = parseFloat(dom.menuPrice);
	            			var menunum = parseFloat(dom.menunum);
	            			var sumprice = parseFloat(menuPrice*menunum);
	            			str += "<tr>";
	                		str += "<td width='10%'>";
	                		str += "<b>"+dom.orderId+"</b>";
	                		str += "</td>";
	                		str += "<td>";
	                		str += "<b>"+dom.menuName+"</b>";
	                		str += "</td>";
	                		str += "<td>";
	                		str += "<b>"+menuPrice+"</b>";
	                		str += "</td>";
	                		str += "<td>";
	                		str += "<b>"+menunum+"</b>";
	                		str += "</td>";
	                		str += "<td>";
	                		str += "<b>"+sumprice+"</b>";
	                		str += "</td>";
	                		str += "<td>";
	                		str += "<b>"+dom.remark+"</b>";
	                		str += "</td>";
	                		str += "</tr>";
	                		sumAllPrice += sumprice;
	            		});
	            		str += "</table>";
	            		if(data.ispay==0){
		            		str += "<div class='text-center' style='color: red;font:20px/25px 宋体;margin-top:10px;'>";
		            		str += "<b>￥订单所花费："+sumAllPrice+"元</b>";
		            		str += "</div>";
		            		layer.open({
		                        title: '订单详情',
		                        area: ['450px', 'auto'],
		                        content: str,
		                        offset: 't',
		                        btn: ['结算','关闭'],
		                        yes:function(index, layero){
		                        	layer.open({
				                        title: '输入会员手机号！',
				                        content: "<b>会员手机号：<input type='text' id='mphone' value='' placeholder='非会员可不填' autocomplete='off' class='layui-input'></b>",
				                        offset: 't',
				                        btn: ['确定'],
				                        yes:function(index, layero){
				                        	var mphone = $("#mphone").val();
				                        	$.post("JieSuan","oid="+data.id+"&sumPrice="+sumAllPrice+"&tabnum="+data.tableId+"&mphone="+mphone,function(res){
				                        		if(res==-2){
				                            		layer.msg('不存在该手机号！');
				                            		return;
				                            	}
				                        		if(res==1){
				                            		layer.open({
								                        title: '提示！',
								                        content: '订单结算成功',
								                        offset: 't',
								                        btn: ['确定'],
								                        yes:function(index, layero){
								                        	location.reload();//刷新当前页面
								                        }
								                    });
				                            	}else{
				                            		layer.msg('结算时发生错误！');
				                            	}
			                            	});
				                        }
				                    });
		                        }
		                    });
	            		}else{
	            			layer.open({
		                        title: '订单详情',
		                        area: ['450px', 'auto'],
		                        content: str,
		                        offset: 't',
		                        btn: ['关闭']
		                    });
	            		}
            		}else{
	            		layer.msg('无详细信息');
            		}
            	});
            }
        });
	});
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#startTime' //指定元素
        });
        laydate.render({
            elem: '#endTime' //指定元素
        });
    });