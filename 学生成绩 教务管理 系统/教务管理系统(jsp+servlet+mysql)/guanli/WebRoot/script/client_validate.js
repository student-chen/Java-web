//是否为空校验
function isEmpty(s) {
	var lll=trim(s);
	if( lll == null || lll.length == 0 )
		return true;
	else
		return false;
}

//删除字符串左边的空格
function ltrim(str) { 
	if(str.length==0)
		return(str);
	else {
		var idx=0;
		while(str.charAt(idx).search(/\s/)==0)
			idx++;
		return(str.substr(idx));
	}
}

//删除字符串右边的空格
function rtrim(str) { 
	if(str.length==0)
		return(str);
	else {
		var idx=str.length-1;
		while(str.charAt(idx).search(/\s/)==0)
			idx--;
		return(str.substring(0,idx+1));
	}
}

//删除字符串左右两边的空格
function trim(str) { 
	return(rtrim(ltrim(str)));
}

/*日期相比较*/
function compareDate(date1, date2) {
	if (trim(date1) == trim(date2))  	
		return 0;
	if (trim(date1) > trim(date2))  	
		return 1;
	if (trim(date1) < trim(date2))  	
		return -1;
}

//校验是否是Email
function isEmail(eml) {
	if(trim(eml)!='') {
	  var re=new RegExp("@[\\w]+(\\.[\\w]+)+$");
	  return(re.test(eml));
	}
	else
	  return(true);
}

//是否是电话号
function isTel(tel) {
	var charcode;
	for (var i=0; i<tel.length; i++)	
	{
		charcode = tel.charCodeAt(i);
		if (charcode < 48 && charcode != 45 || charcode > 57)	
			return false;
	}
	return true;
}

//校验是否是实数
function isNumber(num) {
	var re=new RegExp("^-?[\\d]*\\.?[\\d]*$");
	if(re.test(num))
		return(!isNaN(parseFloat(num)));
	else
		return(false);
}

//校验是否是整数
function isInteger(num)	{
	var re=new RegExp("^-?[\\d]*$");
	if(re.test(num))
		return(!isNaN(parseInt(num)));
	else
		return(false);
}