package com.sevenEleven.javaBean;


import java.util.List;

public class Page {

	
	private int curPage; 
	private int maxPage; 
	private int maxRowCount;  
	private int rowsPerPage;   
	@SuppressWarnings("unchecked")
	private List data;          
	private String formName = "";  
	private String target = "";               
	private static int ROWS_PER_PAGE = 15; 
		
	
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
	@SuppressWarnings("unchecked")
	public void setData(List data)
	{
		this.data = data;
	}
	
	@SuppressWarnings("unchecked")
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
	 * ���ǰ̨��ҳҳ����ƺ���ط�ҳ��Ϣ����ȡǰ̨ҳ���ύ�?��ҳ����Ϣ�� HTML ���� @param aUrl - ǰ̨��ҳҳ���·�����
	 * @return - ǰ̨ҳ���ύ�?��ҳ����Ϣ�� HTML ����
	 */
	public String getPageStr(String aUrl) {        
		String strFirstPage = "��ҳ";        
		String strLastPage = "ĩҳ";        
		String strNextPage = "��һҳ";        
		String strPrevPage = "��һҳ";        
		String strCurrentPage = "ҳ��";        
		String strGoto = "ת����";  
		
		
		StringBuffer strPages = new StringBuffer();        // ��ת�ű�
		
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
		strPages.append("<b>�� <font color=#930909>"+this.getMaxRowCount()+ "</font> ����¼</b>&nbsp;\r\n\t");
					    
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
			   strPages.append("\r\n\t\t\t<option selected value=" + i + ">�� "+ i + " ҳ</option>");            
		   } 
		   else 
		   {                
			   strPages.append("\r\n\t\t\t<option value=" + i + ">�� " + i + " ҳ</option>");            
		   }        
		}
	   
	   strPages.append("\r\n\t\t</select>\r\n\t");        
	   strPages.append("\t<font color=black><b>"+ strCurrentPage+ "��</b></font><font color=#930909><b>"+ getCurPage()+ "</b></font>\r\n\t\t<font color=black><b>/</b></font>\r\n\t\t<font color=#930909><b>"+ getMaxPage()+ "</b></font><font color=black><b> ҳ </b></font>");        
	   strPages.append("\r\n\t<td>\r\n<tr>\r\n</form>\r\n</table>");    
	   
	   return strPages.toString();    
	   }

       /*
		 * ���Page ��� target ���Ժͷ�ҳ�����Ϣ����ȡǰ̨ҳ���ύ�?��ҳ����Ϣ�� HTML ���� ʹ�ø÷���֮ǰ���������� Page
		 * ��� target���� return - ǰ̨ҳ���ύ�?��ҳ����Ϣ�� HTML ����
		 */

       public String getPageStr() 
       {        
    	   return this.getPageStr(target);    
       }
       
       // ��ӡ Page ����ĵ�ǰ��Ϣ
       public String toString() 
       {        
    	   return "��ǰ�ǵ� " + curPage + " ҳ;���� " + maxPage + " ҳ,�� " + maxRowCount+ " ����¼(��);ÿҳ " + rowsPerPage + " ����¼(��)";    
       }


	
       
       
}
