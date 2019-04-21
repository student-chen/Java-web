$(function() {
		$("#refresh").click(function() {
			location.reload();//刷新当前页面
		});
		$("button[name='jz']").click(function() {
			var tabid = $(this).siblings("input[name='tabid']").val();
			layer.confirm('确定就坐？', function(index) {
				$.post("jiuzuo","tabid="+tabid,function(res){
					if(res==1){
						location.reload();//刷新当前页面
					}else{
						layer.msg('开桌失败');
					}
				});
			});
		});
	});