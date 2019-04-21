 /* setInterval(function () {
        	layui.use('table', function() {
        		var table = layui.table;
        		//间隔5s刷新表格--调用重载事件
                table.reload('rolad', {
                	url : "getHouchuInfo",
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
        $(function() {
        layui.use('table', function() {
            var table = layui.table;
            //执行渲染
            table.render({
                elem : '#tabs', //指定原始表格元素选择器（推荐id选择器）
                url : "getHouchuInfo",
                id : "rolad",
                page : true,
                limits : [10, 30, 90, 150, 300 ],
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
    				title : '操作',
    				align : 'center',
    				toolbar : '#bar'
    			} ] ]
            });
            
            //监听工具条
            table.on('tool(tab)', function(obj) {
                var data = obj.data;
                if (obj.event === 'del') {
                    layer.confirm('配餐已经上齐？', function(index) {
                    	$.post("updateIsfull","updateid="+data.id,function(res){
                    		if(res==1){
                    			layer.msg('提交成功！');
                            	table.reload('rolad', {
                                	url : "getHouchuInfo",
                                	method: 'post',
                                	page : {
                                		curr : 1 //重新从第 1 页开始
                                	}
                                });
                    		}else{
                    			layer.msg('提交失败！');
                            	table.reload('rolad', {
                                	url : "getHouchuInfo",
                                	method: 'post',
                                	page : {
                                		curr : 1 //重新从第 1 页开始
                                	}
                                });
                    		}
                    	});
                    });
                } else if (obj.event === 'edit') {
                	//订单详情
                	$.post("getnoticeByid","id="+data.id,function(res){
                		if(res.length>0){
    	            		var str = "<table width='100%' border='1' style='border: 1px solid #C0C0C0;text-align: center;'>";
    	            		str += "<tr>";
    	            		str += "<td width='10%'>";
    	            		str += "<b>订单编号</b>";
    	            		str += "</td>";
    	            		str += "<td>";
    	            		str += "<b>菜名</b>";
    	            		str += "</td>";
    	            		str += "<td>";
    	            		str += "<b>数量</b>";
    	            		str += "</td>";
    	            		str += "<td>";
    	            		str += "<b>备注</b>";
    	            		str += "</td>";
    	            		str += "</tr>";
    	            		$.each(res,function(index,dom){
    	            			str += "<tr>";
    	                		str += "<td width='10%'>";
    	                		str += "<b>"+dom.orderId+"</b>";
    	                		str += "</td>";
    	                		str += "<td>";
    	                		str += "<b>"+dom.menuName+"</b>";
    	                		str += "</td>";
    	                		str += "<td>";
    	                		str += "<b>"+parseFloat(dom.menunum)+"</b>";
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
        });