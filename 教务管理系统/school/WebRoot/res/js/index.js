function check(){
var post = document.form.username.value;
    var pass = document.form.password.value;
  if (post=="")
   {

    alert("用户名不能为空");
    document.form.username.focus();
	document.form.username.select();
  return false;  
   }
  else if(pass=="")
    {
    alert("密码不能为空");
	document.form.password.focus();
	document.form.password.select();
	return false;  
    }
   else if(!post.match(/^[0-9a-z]*$/i))
	{
		alert("用户名非法字符");
		document.form.username.focus();
	    document.form.username.select();
		return false;
	}
	else if(!pass.match(/^[0-9a-z]*$/i))
	{
	    alert("密码非法字符");
		document.form.password.focus();
	    document.form.password.select();
		return false;
	}
	
  }
  //----------------------------------------//
