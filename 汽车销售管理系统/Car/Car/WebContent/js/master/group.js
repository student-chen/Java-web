var path="";
var mid="";
$(function(){
	var heg=$(window).height();
	$("#divbody").css("height",heg);
	mid=$("#id").val();
	path=$("#path").val();
     //分页并查询
	getAllByPage();
	sub();
});


function sub(){
	$("body").on("click","#save",function(){
		$(".checkbox-grey:checked").each(function(){
			var aid=$(this).val();
			$.ajax({
				url:path+"mastera.do?method=allmg",
				type:'post',
				data:{mid:mid,groupid:aid},
				dataType: 'json',
				async: false,
				success: function(mydata){
					if(mydata==0){
						add(aid);
					}
				}
			})
		})
		$(".checkbox-grey:not(:checked)").each(function(){
			var aid=$(this).val();
			$.ajax({
				url:path+"mastera.do?method=allmg",
				type:'post',
				data:{mid:mid,groupid:aid},
				dataType: 'json',
				async: false,
				success: function(mydata){
					if(mydata!=0){
						del(mydata);
					}
				}
			})
		})
		parent.layer.msg("保存成功!", {
			icon : 1
		});
		window.location.href=path+"master/tpart/main.jsp"; 
	})
}


function del(id){
	alert("del"+"::");
	alert(id);
	$.ajax({
		url:path+"mastera.do?method=del",
		type:'post',
		data:{actiongroupid:id},
		dataType: 'json',
		success: function(mydata){
			parent.layer.msg("保存成功!", {
				icon : 1
			});
			window.location.href=path+"master/tpart/main.jsp"; 
		}
	})
}

function add(aid){
	alert("add");
	$.ajax({
		url:path+"mastera.do?method=add",
		type:'post',
		data:{mid:mid,groupid:aid},
		dataType: 'json',
		success: function(mydata){
			parent.layer.msg("保存成功!", {
				icon : 1
			});
			window.location.href=path+"master/tpart/main.jsp"; 
		}
	})
}

function getAllByPage()
{
      $('#tb_departments').bootstrapTable({
            url: path+'group.do?method=alls',
            method: 'get',    
            
            queryParams: function (params) {
                var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                   mid:mid  //从数据库第几条记录开始 
                };
             return temp;
            },//传递参数（*）
            dataType:'json',
            toolbar: "#toolbar",                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "groupid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            columns: [
            	{
                field: 'groupid',
                title: '组别编号',
                align : 'center'
            }, {
                field: 'groupname',
                title: '组别名称',
                align : 'center'
            },
             {
            	 title : '设置个人所在组',  
                 field : 'name',  
                 align : 'center',
             }]
      
        });
}




