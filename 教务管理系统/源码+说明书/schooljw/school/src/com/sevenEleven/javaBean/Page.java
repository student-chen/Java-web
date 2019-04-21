package com.sevenEleven.javaBean;


import java.util.List;

public class Page {

	
	private int curPage; // 当前是第几页
	private int maxPage; // 一共有多少页
	private int maxRowCount;  // 一共有多少行
	private int rowsPerPage;   // 每页显示多少行
	private List data;           // 当前页面显示的数据
	private String formName = "";   // 提交的表单名称
	private String target = "";               // 显示分页的前台页面路径名称
	private static int ROWS_PER_PAGE = 15; // 默认每页显示记录数
		
	
	public Page() {        
		this.curPage = 1;        
		this.maxPage = 1;        
		this.maxRowCount = 0;        
		this.rowsPerPage = ROWS_PER_PAGE;   
		}
	

	public void setCurPage(int curPage)
	{
		this.curPage = curPage;
	}
	
	public int getCurPage()
	{
		return this.curPage;
	}	
	
	public void setMaxRowCount(int maxRowCount)
	{
		this.maxRowCount = maxRowCount;
	}
	
	public int getMaxRowCount()
	{
		return this.maxRowCount;
	}
	
	public void setRowsPerPage(int rowsPerPage)
	{
		if(rowsPerPage>0)
		   this.rowsPerPage = rowsPerPage;
		else
			this.rowsPerPage = ROWS_PER_PAGE;
	}
	
	public int getRowsPerPage()
	{
		return this.rowsPerPage;
	}
	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setData(List data)
	{
		this.data = data;
	}
	
	public List getData()
	{
		return this.data;
	}
	
	public void setFormName(String formName)
	{
		this.formName = formName;   
		
	}
	
	public String getFormName() 
	{
		return this.formName;   
	}
	
	public void setTarget(String target)
	{     
		this.target = target;   
	}
	
	public String getTarget()
	{
		return this.target;
	}
	
	/*
	 * 根据前台分页页面名称和相关分页信息，获取前台页面提交表单和页面信息的 HTML 代码 @param aUrl - 前台分页页面的路径名称
	 * @return - 前台页面提交表单和页面信息的 HTML 代码
	 */
	public String getPageStr(String aUrl) {        
		String strFirstPage = "首页";        
		String strLastPage = "末页";        
		String strNextPage = "下一页";        
		String strPrevPage = "上一页";        
		String strCurrentPage = "页次";        
		String strGoto = "转至：";  
		
		
		StringBuffer strPages = new StringBuffer();        // 跳转脚本
		
		strPages.append("<script language='JavaScript'>\r\n");       
		strPages.append("<!--\r\n");        
		strPages.append("function Jumping(){ \r\n\t");        
		strPages.append("document." + formName + ".submit();\r\n\t");        
		strPages.append("return ;\r\n");        
		strPages.append("}\r\n");       
		strPages.append("function gotoPage(pagenum){ \r\n\t");  
		strPages.append("document." +formName+ ".pageSize.value = pagenum;\r\n\t");		
		strPages.append("document." + formName + ".submit();\r\n\t");        
		strPages.append("return ;\r\n");        
		strPages.append("}\r\n");       
		strPages.append("-->\r\n");
		strPages.append("\r\n</script>\r\n");
		
		strPages.append("<table border=0 align=center>\r\n");        
		strPages.append("<form name="+formName+" action=" +aUrl+ " method=post>\r\n");        
		strPages.append("<tr>\r\n\t<td>\r\n\t\t");        
		strPages.append("<b>共 <font color=#930909>"+this.getMaxRowCount()+ "</font> 条记录</b>&nbsp;\r\n\t");
					    
		if (getMaxPage()==1 || getMaxRowCount() == 0) 
		{            
			strPages.append("\t<font face=webdings color=#930909>9</font><font color=#930909><b>"+ strFirstPage + "</b></font>\r\n\t");            
			strPages.append("\t<font face=webdings color=#930909>7</font><font color=#930909><b>"+ strPrevPage + "</b></font>\r\n\t");            
			strPages.append("\t<font color=#930909><b>"+ strNextPage+ "</b></font><font face=webdings color=#930909>8</font>\r\n\t");            
			strPages.append("\t<font color=#930909><b>"+ strLastPage+ "</b></font><font face=webdings color=#930909>:</font>\r\n\t");        
			
		}
	   else if(getMaxPage() > 1 && getCurPage() == 1) 
	   {            
		    strPages.append("\t<font face=webdings color=#930909>9</font><font color=#930909><b>"+ strFirstPage + "</b></font>\r\n\t");            
		    strPages.append("\t<font face=webdings color=#930909>7</font><font color=#930909><b>"+ strPrevPage + "</b></font>\r\n\t");            
		    strPages.append("\t<a href=\"javascript:gotoPage("+ (getCurPage() + 1) + ")\"><font color=black><b>" + strNextPage+ "</b></font></a><font face=webdings>8</font>\r\n\t");            
		    strPages.append("\t<a href=\"javascript:gotoPage(" + getMaxPage()+ ")\"><font color=black><b>" + strLastPage+ "</b></font></a><font face=webdings>:</font>\r\n\t");        
	   }
	   else if (getMaxPage() > 1 && getCurPage() < getMaxPage()) 
	   {            
		    strPages.append("\t<font face=webdings>9</font><a href=\"javascript:gotoPage(1)\"><font color=black><b>" + strFirstPage + "</b></font></a>\r\n\t");            
		    strPages.append("\t<font face=webdings>7</font><a href=\"javascript:gotoPage("+ (getCurPage() - 1) + ")\"><font color=black><b>" + strPrevPage + "</b></font></a>\r\n\t");            
		    strPages.append("\t<a href=\"javascript:gotoPage("+ (getCurPage() + 1) + ")\"><font color=black><b>" + strNextPage+ "</b></font></a><font face=webdings>8</font>\r\n\t");            
		    strPages.append("\t<a href=\"javascript:gotoPage(" + getMaxPage()+ ")\"><font color=black><b>" + strLastPage+ "</b></font></a><font face=webdings>:</font>\r\n\t");        
	   }
	   else if (getMaxPage() > 1 && getCurPage() == getMaxPage()) 
	   {            
		    strPages.append("\t<font face=webdings>9</font><a href=\"javascript:gotoPage(1)\"><font color=black><b>"+ strFirstPage + "</b></font></a>\r\n\t");            
		    strPages.append("\t<font face=webdings>7</font><a href=\"javascript:gotoPage("+ (getCurPage() - 1) + ")\"><font color=black><b>"+ strPrevPage + "</b></font></a>\r\n\t");            
		    strPages.append("\t<font color=#930909><b>"+ strNextPage+ "</b></font><font face=webdings color=#930909>8</font>\r\n\t");            
		    strPages.append("\t<font color=#930909><b>"+ strLastPage+ "</b></font><font face=webdings color=#930909>:</font>\r\n\t");        
	   }
	
	   strPages.append("\t<font color=black><b>"+ strGoto+ "</b></font>\r\n\t\t<select name='pageSize' onchange='Jumping()'>");        
	   for (int i = 1; i <= this.getMaxPage(); i++) 
	   {            
		   if (i == this.getCurPage()) 
		   {                
			   strPages.append("\r\n\t\t\t<option selected value=" + i + ">第 "+ i + " 页</option>");            
		   } 
		   else 
		   {                
			   strPages.append("\r\n\t\t\t<option value=" + i + ">第 " + i + " 页</option>");            
		   }        
		}
	   
	   strPages.append("\r\n\t\t</select>\r\n\t");        
	   strPages.append("\t<font color=black><b>"+ strCurrentPage+ "：</b></font><font color=#930909><b>"+ getCurPage()+ "</b></font>\r\n\t\t<font color=black><b>/</b></font>\r\n\t\t<font color=#930909><b>"+ getMaxPage()+ "</b></font><font color=black><b> 页 </b></font>");        
	   strPages.append("\r\n\t<td>\r\n<tr>\r\n</form>\r\n</table>");    
	   
	   return strPages.toString();    
	   }

       /*
		 * 根据Page 类的 target 属性和分页相关信息，获取前台页面提交表单和页面信息的 HTML 代码 使用该方法之前，必须设置 Page
		 * 类的 target属性 return - 前台页面提交表单和页面信息的 HTML 代码
		 */

       public String getPageStr() 
       {        
    	   return this.getPageStr(target);    
       }
       
       // 打印 Page 对象的当前信息
       public String toString() 
       {        
    	   return "当前是第 " + curPage + " 页;共有 " + maxPage + " 页,共 " + maxRowCount+ " 条记录(行);每页 " + rowsPerPage + " 条记录(行)";    
       }


	
       
       
}
