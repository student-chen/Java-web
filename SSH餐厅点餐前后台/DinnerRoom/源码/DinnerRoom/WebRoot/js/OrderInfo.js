/* setInterval(function () {
    	layui.use('table', function() {
    		var table = layui.table;
    		//间隔5s刷新表格--调用重载事件
        	//执行重载
    		table.reload('rolad', {
    			url : "getAllOrderInfo",
    			method: 'post',
    			page : {
    				curr : 1 //重新从第 1 页开始
    			}
    		});
    	});
	},5000); */
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
			url : "getAllOrderInfo",
			id : "rolad",
			page : true,
			limits : [ 10, 30, 90, 150, 300 ],
			limit : 10 //相当于pagesize
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
				field : 'ispay',
				title : '是否支付',
				templet : '#ispay'
			},{
				field : 'isFull',
				title : '菜是否上齐',
				templet: '#isfull'
			},{
				title : '操作',
				align : 'center',
				toolbar : '#bar'
			} ] ]
		//设置表头
		});
		//监听工具条
        table.on('tool(tab)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
            	//订单详情
            	$.post("getnoticeByid","id="+data.id,function(res){
            		if(res.length>0){
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
	            		});
	            		str += "</table>";
	            		layer.open({
	                        title: '订单详情',
	                        area: ['450px', 'auto'],
	                        content: str,
	                        offset: 't',
	                        btn: ['关闭']
	                    });
            		}else{
	            		layer.msg('无详细信息');
            		}
            	});
            }
        });
	});