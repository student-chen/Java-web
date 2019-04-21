var path="";
var groupid="";
var name="";
var mid="";
var ids='';
var wth='';
$(function(){
	var heg=$(window).height();
	wth=$(window).width();
	if(wth<=1000){
		heg=4000;
	}
	$("#divbody").css("height",heg);
	path=$("#path").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	groupid=$("#id").val();
	name=$("#name").val();
	if($.inArray("查询用户权限设计",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("修改用户权限设计",ids)!=-1){
		getAllByPage();
	}
	onClick();
	sub();
});
function check(obj){
	if(obj.parent().find("td:eq(0) input").val()==14){
		var text1=obj.parent().find("td:eq(3)").text();
		if(obj.text()==text1){
			obj.parent().find("td:eq(2) input").prop("checked",true);
			obj.parent().find("td:eq(2) input").prop("disabled",true);
		}
		if(obj.parent().find("td:eq(3) input").prop("checked")==false){
			obj.parent().find("td:eq(2) input").prop("disabled",false);
		}
	}else if(obj.parent().find("td:eq(0) input").val()==18){
		var text1=obj.parent().find("td:eq(1)").text();
		if(obj.text()==text1){
			obj.parent().find("td:eq(0) input").prop("checked",true);
			obj.parent().find("td:eq(0) input").prop("disabled",true);
		}
		if(obj.parent().find("td:eq(1) input").prop("checked")==false){
			obj.parent().find("td:eq(0) input").prop("disabled",false);
		}
	}else if(obj.parent().find("td:eq(0) input").val()==10||obj.parent().find("td:eq(0) input").val()==32){
		var text1=obj.parent().find("td:eq(1)").text();
		var text2=obj.parent().find("td:eq(2)").text();
		var text3=obj.parent().find("td:eq(3)").text();
		if(obj.text()==text1||obj.text()==text2||obj.text()==text3){
			obj.parent().find("td:eq(0) input").prop("checked",true);
			obj.parent().find("td:eq(0) input").prop("disabled",true);
		}
		if(obj.parent().find("td:eq(2) input").prop("checked")==false 
				&& obj.parent().find("td:eq(1) input").prop("checked")==false 
				&& obj.parent().find("td:eq(3) input").prop("checked")==false){
			obj.parent().find("td:eq(0) input").prop("disabled",false);
		}
	}else{
		var text1=obj.parent().find("td:eq(1)").text();
		var text2=obj.parent().find("td:eq(2)").text();
		if(obj.text()==text1||obj.text()==text2){
			obj.parent().find("td:eq(0) input").prop("checked",true);
			obj.parent().find("td:eq(0) input").prop("disabled",true);
		}
		if(obj.parent().find("td:eq(2) input").prop("checked")==false && obj.parent().find("td:eq(1) input").prop("checked")==false){
			obj.parent().find("td:eq(0) input").prop("disabled",false);
		}
	}
}
function onClick(){
	$("td").click(function(){
		check($(this));
	})
}

function getAllByPage()
{
	$("#divbody").append("<div class='container' style='width:100%'><div class='row'><div class='col-md-6 col-sm-12' id='left'>" +
			"</div>" +
			"<div class='col-md-6 col-sm-12' id='right'></div></div></div>");
	$.ajax({
		url:path+"action.do?method=all",
		type:'post',
		data:'',
		dataType: 'json',
		async: false,
		success: function(mydata){
			var str2="";
			var str1="";
			$.each(mydata,function(index,xx){
					var str="";
					if(mid==xx.module.moduleid){
						if(xx.actionid==18 || xx.actionid==46 ||xx.actionid==61){
							str+="</tr><tr class='active'><td colspan='4'>"+xx.module.modulename+"</td></tr>";
							str+="<tr><td><div class='inline-block vertical-top'>&nbsp;&nbsp;&nbsp;"+xx.actionname+"&nbsp;&nbsp;&nbsp;</div>";
							str+="<div class='custom-checkbox'>";
							str+="<input type='checkbox' value='"+xx.actionid+"' id='inlineCheckbox"+xx.actionid+"' class='checkbox-grey'>";
							str+="<label for='inlineCheckbox"+xx.actionid+"' id='Checkbox"+xx.actionid+"'></label></div></td>";	
						}else{
							str+="<td><div class='inline-block vertical-top'>&nbsp;&nbsp;&nbsp;"+xx.actionname+"&nbsp;&nbsp;&nbsp;</div>";
							str+="<div class='custom-checkbox'>";
							str+="<input type='checkbox' value='"+xx.actionid+"' id='inlineCheckbox"+xx.actionid+"' class='checkbox-grey'>";
							str+="<label for='inlineCheckbox"+xx.actionid+"' id='Checkbox"+xx.actionid+"'></label></div></td>";	
						}
					}else{
						str+="</tr><tr class='active'><td colspan='4'>"+xx.module.modulename+"</td></tr>";
						str+="<tr><td><div class='inline-block vertical-top'>&nbsp;&nbsp;&nbsp;"+xx.actionname+"&nbsp;&nbsp;&nbsp;</div>";
						str+="<div class='custom-checkbox'>";
						str+="<input type='checkbox' value='"+xx.actionid+"' id='inlineCheckbox"+xx.actionid+"' class='checkbox-grey'>";
						str+="<label for='inlineCheckbox"+xx.actionid+"' id='Checkbox"+xx.actionid+"'></label></div></td>";
					}
					mid=xx.module.moduleid;
					if(mid>10){
						str1+=str;
					}else{
						str2+=str;
					}
			})
			$("#left").append("<table class='table table-bordered' id='tabl'>"+str2+"</table>");
			$("#right").append("<table class='table table-bordered' id='tabr'>"+str1+"</table>");
			$(".checkbox-grey").each(function(){
				var aid=$(this).val();
				$.ajax({
					url:path+"aGroup.do?method=allmg",
					type:'post',
					data:{actionid:aid,groupid:groupid},
					dataType: 'json',
					async: false,
					success: function(mydata){
						if(mydata!=0){
							$("#inlineCheckbox"+aid).attr("checked","checked");
						}
					}
				})
			})
			$(".checkbox-grey:checked").each(function(){
				check($(this).parent().parent());
			})
			$("#tabl tr:odd").each(function(){
				if($(this).find("td").length<4){
					var size=4-$(this).find("td").length;
					for (var i = 0; i < size; i++) {
						$(this).append("<td style='text-align:center;'>---</td>");
					}
				}
			})
			$("#tabr tr:odd").each(function(){
				if($(this).find("td").length<4){
					var size=4-$(this).find("td").length;
					for (var i = 0; i < size; i++) {
						$(this).append("<td style='text-align:center;'>---</td>");
					}
				}
			})
		}
	})
}

function sub(){
	if(wth<=1000){
		$("#left").css({"padding":"0px"});
		$("#right").css({"padding":"0px"});
	}
	$("body").on("click","#save",function(){
		$(".checkbox-grey:checked").each(function(){
			var aid=$(this).val();
			$.ajax({
				url:path+"aGroup.do?method=allmg",
				type:'post',
				data:{actionid:aid,groupid:groupid},
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
				url:path+"aGroup.do?method=allmg",
				type:'post',
				data:{actionid:aid,groupid:groupid},
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
		window.location.href=path+"limit/agroup.jsp"; 
	})
}


function del(aid){
	$.ajax({
		url:path+"aGroup.do?method=del",
		type:'post',
		data:{actiongroupid:aid},
		dataType: 'json',
		success: function(mydata){
			parent.layer.msg("保存成功!", {
				icon : 1
			});
			window.location.href=path+"limit/agroup.jsp"; 
		}
	})
}

function add(aid){
	$.ajax({
		url:path+"aGroup.do?method=add",
		type:'post',
		data:{actionid:aid,groupid:groupid},
		dataType: 'json',
		success: function(mydata){
			parent.layer.msg("保存成功!", {
				icon : 1
			});
			window.location.href=path+"limit/agroup.jsp"; 
		}
	})
}



