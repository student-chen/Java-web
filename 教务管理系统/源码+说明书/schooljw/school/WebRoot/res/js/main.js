//--------------------------------------------------
//暂没用到 
function movefocus(){
  if(window.event.keyCode==13)
  {
      fullwin();
  }
 }

//--------------------------------------------------
function fullwin(){
  if (FormWelcome.userid.value=="")
   {
    alert("用户名不能为空！");
	document.FormWelcome.userid.focus();
	document.FormWelcome.userid.select();
	return false;  
   }
  else
   {
    if (FormWelcome.pswd.value=="")
    {
    alert("密码不能为空！");
	document.FormWelcome.pswd.focus();
	document.FormWelcome.pswd.select();
	return false;  
    }
   }
  }