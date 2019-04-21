/**
 * 退出确认框
 * 
 * @param url
 * @param content
 * @param index
 */
function exit(url, content) {
	$.messager.confirm('提示信息',content, function(r){
		if(r){
			window.location = url;
		}
	});
}

/**
 * 清空textbox
 * @param idVal
 * @param nameVal
 */
function clearText(idVal,nameVal){
	$("#"+nameVal).textbox('setValue', '');
	$("#"+idVal).val("");
}

function changeDate(value, row, index){
	if(value == "" || value == null){
		return "";
	}else{
		var dateChange = new Date(value);
    	return dateChange.Format('yyyy-MM-dd');
	}
	
}
function changeDateTime(value, row, index){
	if(value == "" || value == null){
		return "";
	}else{
		var dateChange = new Date(value);
    	return dateChange.Format('yyyy-MM-dd hh:mm:ss');
	}
	
}
Date.prototype.Format = function(fmt)   
{ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}  
