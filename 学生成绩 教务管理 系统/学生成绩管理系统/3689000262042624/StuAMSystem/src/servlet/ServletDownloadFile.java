package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDownloadFile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");*/
		//得到要下载的文件名
		String fileName=request.getParameter("fileName");
		fileName=new String(fileName.getBytes("iso8859-1"),"utf-8");
		//上传的文件都保存在/WEB—INF/upload目录下的子目录当中
		String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
		//通过文件名找出文件所在目录
		String path=findFileSavePathByFileName(fileName, fileSaveRootPath);
		//得到要下载的文件
		File file=new File(path+"\\"+fileName);
		//如果文件不存在
		if(!file.exists()){
			request.setAttribute("message", "文件不存在！！！");
			request.getRequestDispatcher("admin/fileLoadFail.jsp").forward(request, response);
			return ;
		}
		 
		/*
		 String realname = fileName.substring(fileName.indexOf("_")+1);
	        //设置响应头，控制浏览器下载该文件
	        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		*/
		//处理文件名
		String realName=fileName.substring(fileName.indexOf("_")+1);
		
		if ("FF".equals(getBrowser(request))) {  
            // 针对火狐浏览器处理方式不一样了  
			realName = new String(realName.getBytes("UTF-8"),  
                    "iso-8859-1") ;  
        }  
		else{
			realName=URLEncoder.encode(realName, "utf-8");
		}
	
		//设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;fileName="+realName);
	
		//读取要下载的文件，保存到文件输入流
		FileInputStream fis=new FileInputStream(path+"\\"+fileName);
		//创建输出流
		OutputStream os=response.getOutputStream();
		//创建缓冲区
		byte buffer[]=new byte[1024];
		int len=0;
		//循环将输入流中的内容读取到缓冲区当中
		while((len=fis.read(buffer))>0){
			os.write(buffer, 0, len);
		}
		
	
		fis.close();
		os.close();
		
		
	}

	private String findFileSavePathByFileName(String fileName,
			String fileSaveRootPath) {
		int hashCode=fileName.hashCode();
		int dir1=hashCode&0xf;
		int dir2=(hashCode&0xf0)>>4;
		String dir=fileSaveRootPath+"\\"+dir1+"\\"+dir2;
		File file=new File(dir);
		if(!file.exists()){
			file.mkdirs();
		}
		return dir;
	}
	
	// 以下为服务器端判断客户端浏览器类型的方法  
    private String getBrowser(HttpServletRequest request) {  
        String UserAgent = request.getHeader("USER-AGENT").toLowerCase();  
        if (UserAgent != null) {  
            if (UserAgent.indexOf("msie") >= 0)  
                return "IE";  
            if (UserAgent.indexOf("firefox") >= 0)  
                return "FF";  
            if (UserAgent.indexOf("safari") >= 0)  
                return "SF";  
        }  
        return null;  
    }  

}
