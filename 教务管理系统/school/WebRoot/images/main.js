function movefocus(){
  if(window.event.keyCode==13)
  {
      fullwin();
  }
 }

//--------------------------------------------------
function fullwin(){
  if (form.username.value=="")
   {
    alert("????????");
	document.form.username.focus();
	document.form.username.select();
	return false;  
   }
  else
   {
    if (form.password.value=="")
    {
    alert("???????");
	document.form.password.focus();
	document.form.password.select();
	return false;  
    }
   }
  }