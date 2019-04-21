<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.bjsxt.drp.business.usermgr.manager.FileManager" %>
<%@ page import="com.bjsxt.drp.business.usermgr.model.File" %>
<%@ taglib prefix="bean"  uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic"  uri="http://struts.apache.org/tags-logic" %> 
<HTML><HEAD><TITLE>教务在线</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<STYLE type=text/css>
TD {
	FONT-SIZE: 12px; COLOR: #000000
}
INPUT {
	FONT-SIZE: 12px; COLOR: #000000
}
SELECT {
	FONT-SIZE: 12px; COLOR: #000000
}
TD.nav {
	FILTER: DropShadow( Color=#ffffff, OffX=1, OffY=1)
}
TD.nav A {
	COLOR: #000000; TEXT-DECORATION: none
}
TD.nav A:hover {
	COLOR: #000000
}
p1 {
	FONT-SIZE: 12px
}
p2 {
	FONT-SIZE: 12px; LINE-HEIGHT: 130%
}
p3 {
	FONT-SIZE: 14px
}
p4 {
	FONT-SIZE: 14px; LINE-HEIGHT: 130%
}
p5 {
	FONT-SIZE: 12px; LINE-HEIGHT: 180%
}
p6 {
	LINE-HEIGHT: 240%
}
p7 {
	COLOR: #404642; LINE-HEIGHT: 150%
}
.text {
	COLOR: #3c3c3c; LINE-HEIGHT: 180%
}
.text1 {
	FONT-SIZE: 14px; COLOR: #3c3c3c; LINE-HEIGHT: 180%
}
A:link {
	COLOR: #000000
}
A:visited {
	COLOR: #000000
}
A:hover {
	COLOR: #000000
}
.STYLE2 {color: #316AC5}
</STYLE>

<META content="MSHTML 6.00.2800.1106" name=GENERATOR></HEAD>
<BODY leftMargin=0 background=images/bgbg.gif topMargin=0 
marginheight="0" marginwidth="0">

<% List fileList=(List)FileManager.getInstance().findAllUserList();  
    File file=null;
%>

<TABLE width=780 height="122" border=0 align=center cellPadding=0 cellSpacing=0>
  <TBODY>
  <TR>
   
    <TD width="780" height="122"><!--TABLE cellSpacing=0 cellPadding=0 align=right border=0>
        <TBODY>
        <TR>
          <TD>&nbsp;</TD>
      </TR></TBODY></TABLE-->	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="778" height="150">
      <param name="movie" value="images/top11.swf">
      <param name="quality" value="high">
      <embed src="images/top11.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="778" height="150"></embed>
    </object></TD>
    <TD width=10 ><BR></TD></TR></TBODY></TABLE>

<TABLE cellSpacing=0 cellPadding=0 width="778" align=center border=0 height="324">
  <TBODY>
  <TR>
    <TD width=1 height="324" bgColor=#615f64></TD>
    <TD vAlign=top  background=images/.jpg  width=150>
	
      </TD>
    <TD vAlign=top align=left width=475>
      <TABLE height="493" cellSpacing=0 cellPadding=0 width="470" border=0>
        <TBODY>
        
       
        <TR>
          <TD width="470" height="493" vAlign=top bgColor=#ffffff><BR>
            <TABLE width="470" border=0 align=center cellPadding=0 cellSpacing=0>
              <TBODY>
              <TR>
                <TD width=35><IMG height=24 src="images/qcorner.gif" 
                  width=35 border=0></TD>
                <TD width=290 
background=images/qline2.gif><strong>下载专区</strong></TD>
                <TD width=251 
            background=images/qline3.gif></TD>
              </TR></TBODY></TABLE><BR>
              <table width="72%" height="441" 
border=0 align=center cellpadding=0 cellspacing=0>
                <tbody>
                  <tr>
                  <% for(int i=0;i<fileList.size();i++){
                     file=(File)fileList.get(i);
                      %>
                        <td>
                          <a href=<%=file.file_path%>><%=file.file_name%></a>
                         </td>
                    
                  <%} %>
                  <%--
                 
                  <logic:notEmpty name="fileList">
                     <logic:iterate id="file" name="fileList">
                    	 <td>
                           <bean:write name="file" property="file_name"/>
                         </td>
                      
                         <td>
                            11
                         </td>
                     
                     </logic:iterate> 
                  </logic:notEmpty>
                    
                  --%></tr>
                </tbody>
              </table></TD>
        </TR>
       </TBODY></TABLE>
      <B><BR></B></TD>
<TD width=152 bgColor=><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="158" height="498">
  <param name="movie" value="images/baner.swf">
  <param name="quality" value="high">
  <embed src="images/baner.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="158" height="498"></embed>
</object></TD>
</TR></TBODY></TABLE>

      
   
	<center>
	  <table width="780" height="31" border="0">
        <tr>
          <td width="767" background="images/but_bg.gif"><center>版权所有：软件学院   崔念龙实习制作</center></td>
        </tr>
      </table>
	
	</center>
</body>
</html>
