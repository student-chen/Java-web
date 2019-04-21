<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>统计收费</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/LightBlue_Css.css"/>
     <script>
	    function toDate(){
			with(document.all){
				vYear=parseInt(year.options[year.selectedIndex].text)
				vMonth=parseInt(month.options[month.selectedIndex].text)
				day.length=0;
				/*根据年和月的值生成一个日期对象调用getDate()函数得到天数*/	
				for(i=0;i<(new Date(vYear,vMonth,0)).getDate();i++){
					day.options[day.length++].value=day.length;/*设置每一个天数的值和文本*/
					day.options[day.length-1].text=day.length;
			}
		}
		 toDay();/*调用toDay()函数对年龄的有效性进行验证*/
		}
		/*下面这个toDay()函数就是验证年龄的有效性的*/
		function toDay(){
		if(document.form1.yearName.value=="1900"){
			/*如果年份是1900，就清空，这是可选的，因为上面的年龄设的是从1970开始的，
			但是加上这一步，可以让大家学习下面这个清空年龄框的值*/
			document.all("studentAge").value="";
		}
		else{
			/*如果年份不是1900，就先得到当前计算机日期中的年份，然后减去用户输入的年份，
			如果小于就说明年龄是无效的，否则就是有效的，并用这个年龄值作为学生的年龄。*/
			vDay=parseInt(document.all.day.options[document.all.day.selectedIndex].value)
			nD=new Date().getYear();/*得到当前计算机的年份*/
			with(document.all){
				vYear=parseInt(year.options[year.selectedIndex].text) /*得到用户输入的年份*/
				ss = nD-vYear;/*两者相减*/
				if(ss <= 0)/*如果小于0，就说明年龄无效*/
				{
					///document.all("studentAge").value="无效年龄";
				}
				else
				{
					///document.all("studentAge").value=ss;
				} 
			}
		}
	}
	window.onload=toDate;
	</script>
	<script>
    function toDate1()
    {
		with(document.all)
		{
			vYear=parseInt(year1.options[year1.selectedIndex].text)
			vMonth=parseInt(month1.options[month1.selectedIndex].text)
			day1.length=0;
			/*根据年和月的值生成一个日期对象调用getDate()函数得到天数*/	
			for(i=0;i<(new Date(vYear,vMonth,0)).getDate();i++){
				day1.options[day1.length++].value=day1.length;/*设置每一个天数的值和文本*/
				day1.options[day1.length-1].text=day1.length;
		}
	}
	 toDay1();/*调用toDay()函数对年龄的有效性进行验证*/
	}
	/*下面这个toDay()函数就是验证年龄的有效性的*/
	function toDay1(){
	if(document.form1.yearName1.value=="1900"){
		/*如果年份是1900，就清空，这是可选的，因为上面的年龄设的是从1970开始的，
		但是加上这一步，可以让大家学习下面这个清空年龄框的值*/
		document.all("studentAge").value="";
	}
	else{
		/*如果年份不是1900，就先得到当前计算机日期中的年份，然后减去用户输入的年份，
		如果小于就说明年龄是无效的，否则就是有效的，并用这个年龄值作为学生的年龄。*/
		vDay=parseInt(document.all.day1.options[document.all.day1.selectedIndex].value)
		nD=new Date().getYear();/*得到当前计算机的年份*/
		with(document.all){
			vYear=parseInt(year.options[year1.selectedIndex].text) /*得到用户输入的年份*/
			ss = nD-vYear;/*两者相减*/
			if(ss <= 0)/*如果小于0，就说明年龄无效*/
			{
				///document.all("studentAge").value="无效年龄";
			}
			else{
				///document.all("studentAge").value=ss;
			} 
		}
		}
	}
	window.onload=toDate1;
	</script>
  </head>
  <body>
  <form action="<%=request.getContextPath()%>/StatServlet" name="form1" method=post>
   <table class="simple textCss"> 
      <tr>
        <th align="right" width="30%"> 起始日期：</th>
        <td>
        <select id=year name="yearName" onchange=toDate()>
			<script>
				for(i=1990;i<=2010;i++)document.write("<option>"+i+"</option>")
			</script> 
		</select>年
		<select id=month name="monthName" onchange=toDate()>
			<script>
				for(i=1;i<=12;i++)document.write("<option>"+i+"</option>")
			</script>
		</select>月
		<select id=day name="dayName" onchange=toDay()>
			<option value="1" selected>1</option>
		</select>日
		</td>
      </tr>
      <tr>
       <th align="right" width="30%"> 截止日期：</th>
       <td>
         <select id=year1 name="yearName1" onchange=toDate1()>
			<script>
				for(i=1990;i<=2010;i++)
					document.write("<option>"+i+"</option>")
			</script> 
		</select>年
		<select id=month1 name="monthName1" onchange=toDate1()>
			<script>
				for(i=1;i<=12;i++)
					document.write("<option>"+i+"</option>")
			</script>
		</select>月
		<select id=day1 name="dayName1" onchange=toDay1()>
		</select>日
        </td>
      </tr>
      <tr>
        <td align="center" colspan="2">
          	<input type="submit" value="统计" class="buttonClass">&nbsp;&nbsp;&nbsp;
          	<input type="button" value="退出" class="buttonClass" onclick="window.location.href='${pageContext.request.contextPath}/receiptLiuHaiQingServlet?operation=0'">
        </td>
      </tr>
   </table>
   </form>
  </body>
</html>