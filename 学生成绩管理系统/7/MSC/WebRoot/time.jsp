<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'time.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="image/style1.css">
  </head>
  
  <body>
    <div align="center">
<font face="Arial, Helvetica, Sans Serif" size="2" color="grey" style="FILTER: blur(direction=135,strength=8)"><b><i>
<span id="clock">
<SCRIPT LANGUAGE="JavaScript">
var dayarray=new Array("星期天","星期一","星期二","星期三","星期四","星期五","星期六")
var montharray=new Array("1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月")
function getthedate(){
var mydate=new Date()
var year=mydate.getYear()
if (year < 1000)
year+=1900
var day=mydate.getDay()
var month=mydate.getMonth()
var daym=mydate.getDate()
if (daym<10)
daym="0"+daym
var hours=mydate.getHours()
var minutes=mydate.getMinutes()
var seconds=mydate.getSeconds()
var dn="AM"
if (hours>=12)
dn="PM"
if (hours>12){
hours=hours-12
}
{
 d = new Date();
 Time24H = new Date();
 Time24H.setTime(d.getTime() + (d.getTimezoneOffset()*60000) + 3600000);
 InternetTime = Math.round((Time24H.getHours()*60+Time24H.getMinutes()) / 1.44);
 if (InternetTime < 10) InternetTime = '00'+InternetTime;
 else if (InternetTime < 100) InternetTime = '0'+InternetTime;
}
if (hours==0)
hours=12
if (minutes<=9)
minutes="0"+minutes
if (seconds<=9)
seconds="0"+seconds
var cdate=year+"年"+montharray[month]+""+daym+"日    "+dayarray[day]+"   "+hours+":"+minutes+":"+seconds+"  "+dn+""
if (document.all)
document.all.clock.innerHTML=cdate
else if (document.getElementById)
document.getElementById("clock").innerHTML=cdate
else
document.write(cdate)
}
if (!document.all && !document.getElementById)
getthedate()
function goforit(){
if (document.all||document.getElementById)
setInterval("getthedate()",1000)
}
window.onload=goforit
</script>
</span>
</i></b></font>
</div>
  </body>
</html>
