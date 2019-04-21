package servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletListFile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取上传文件的目录
		String uploadFilePath=this.getServletContext().getRealPath("/WEB-INF/upload");
		//存储要下载的文件名
		Map<String,String> fileNameMap=new HashMap<String, String>();
		/*
		 * 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
		 */
		//file既可以代表一个文件也可以代表一个目录
		listFile(new File(uploadFilePath),fileNameMap);
		//将map集合发送到listFile.jsp页面进行显示
		request.setAttribute("fileNameMap", fileNameMap);
		request.getRequestDispatcher("admin/fileList.jsp").forward(request, response);
	}

	private void listFile(File file, Map<String, String> fileNameMap) {
		//如果file代表的不是一个文件，而是一个目录
		if(!file.isFile()){
			//列出该目录下的所有文件和目录
			File files[]=file.listFiles();
			//遍历files数组
			for(File f:files){
				//递归
				listFile(f,fileNameMap);
			}
		}else{
			/**
             * 处理文件名，上传后的文件是以uuid_文件名的形式去重新命名的，去除文件名的uuid_部分
                file.getName().indexOf("_")检索字符串中第一次出现"_"字符的位置，
                	如果文件名类似于：9349249849-88343-8344_阿_凡_达.avi
                	那么file.getName().substring(file.getName().indexOf("_")+1)
                	处理之后就可以得到阿_凡_达.avi部分
             */
			String realName=file.getName().substring(file.getName().indexOf("_")+1);
			 //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
			fileNameMap.put(file.getName(), realName);

		}
		
	}

}
