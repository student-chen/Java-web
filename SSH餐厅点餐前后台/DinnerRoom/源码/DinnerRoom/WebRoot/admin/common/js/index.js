		function ShowMain(url) {
	        $("#AdminMain").removeAttr("src");
	        $("#AdminMain").attr("src",url);
	    }
		$(function () {
			//JavaScript代码区域
		    layui.use('element', function(){
		        var element = layui.element;
				//alert(element)
		    });
			$("#outSys").click(function () {
                layer.open({
                    time: 10000, //10s后自动关闭
                    title: '提示信息',
                    content: '是否退出系统？',
                    btn: ['是', '否'],
                    yes: function(index, layero){
                    	$.cookie("user", "", {expires: -1,path: '/'});
                        location.href='outSys?logname='+$("#OutloginName").val();+'';
                    }
                });
            });
        });