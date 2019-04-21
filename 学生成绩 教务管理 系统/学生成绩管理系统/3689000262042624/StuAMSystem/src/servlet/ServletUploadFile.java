package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




@SuppressWarnings("serial")
public class ServletUploadFile extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 得到上传文件的保存目录，将上传的文件存放于服务器WEB-INF目录下，不允许外界直接访问，保证上传文件的安全性
				String savePath = this.getServletContext().getRealPath(
						"/WEB-INF/upload");

				// 上传时生成临时文件保存目录
				String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");

				File tempFile = new File(tempPath);
				if (!tempFile.exists()) {
					// 创建临时文件目录
					tempFile.mkdir();
				}

				// 消息提醒
				String message = "";
				try {
					// 使用Apache文件上传组件处理文件上传步骤
					// 1、创建一个DiskFileItemFactory工厂
					DiskFileItemFactory factory = new DiskFileItemFactory();

					// 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
					factory.setSizeThreshold(1024 * 100); // 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB

					// 设置上传时的临时保存目录
					factory.setRepository(tempFile);

					// 2，创建一个文件上传解析器
					ServletFileUpload upLoad = new ServletFileUpload(factory);


					// 解决上传文件中文乱码
					upLoad.setHeaderEncoding("utf-8");

					// 3、判断提交上来的数据是否是上传表单的数据
					if (!ServletFileUpload.isMultipartContent(request)) {

						// 按照传统方式获取数据
						return;
					}
					// 设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
					upLoad.setFileSizeMax(1024 * 1024);

					// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
					upLoad.setSizeMax(1024 * 1024 * 10);

					// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，
					// 每一个FileItem对应一个Form表单的输入项

				
					List<FileItem> list = upLoad.parseRequest(request);
					// List<FileItem> list=upLoad.parseRequest(request);
					// 如果fileitem中封装的是普通输入项的数据
					for (FileItem item : list) {
						if (item.isFormField()) {
							String name = item.getFieldName();
							/*// 解决普通输入项的数据中文乱码
							String value = item.getString("utf-8");
							System.out.println(name + "=" + value);*/
						} else {
							// 吐过fileitem中封装的是上传文件
							// 得到上传的文件名称
							String fileName = item.getName();
							
							if (fileName == null || fileName.trim().equals("")) {
								continue;
							}
							// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，
							// 如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
							// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
							fileName = fileName
									.substring(fileName.lastIndexOf("\\") + 1);
							// 得到上传文件扩展名
							String fileExtName = fileName.substring(fileName
									.lastIndexOf(".") + 1);
							// 如果需要限制上传的文件类型，那么可以通过文件扩展名来判断文件类型是否合法
							//System.out.println("上传文件扩展名是：" + fileExtName);
							// 获取item中的上传文件的输入流
							InputStream is = item.getInputStream();
							// 得到文件保存的名称
							String saveFileName = makeFileName(fileName);
							// 得到文件保存目录
							String realSavePath = makePath(saveFileName, savePath);
							// 创建一个文件输出流
							FileOutputStream fos = new FileOutputStream(realSavePath
									+ "\\" + saveFileName);
							// 创建一个缓冲区
							byte buffer[] = new byte[1024];
							// 判断输入流中的数据是否已经读完的标识
							int len = 0;
							// 循环将输入流读入到缓冲区中，（len=in.read(buffer)）>0就表示in里面还有数据
							while ((len = is.read(buffer)) > 0) {
								// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
								// + filename)当中
								fos.write(buffer, 0, len);
							}
							// 关闭输入流
							is.close();
							// 关闭输出流
							fos.close();
							// 删除处理文件上传时生成的临时文件
							// item.delete();
							message = "文件上传成功！";

						}

					}
				} catch (FileUploadBase.FileSizeLimitExceededException e) {
					e.printStackTrace();
					request.setAttribute("message", "单个文件超出最大值！！！");
					request.getRequestDispatcher("admin/fileLoadFail.jsp").forward(
							request, response);
					return;
					// e.printStackTrace();
				} catch (FileUploadBase.SizeLimitExceededException e) {
					e.printStackTrace();
					request.setAttribute("message", "上传文件的总的大小超出限制的最大值！！！");
					request.getRequestDispatcher("admin/fileLoadFail.jsp").forward(
							request, response);
					return;
				} catch (Exception e) {
					message = "文件上传失败！";
					e.printStackTrace();
				}
				request.setAttribute("message", message);
				request.getRequestDispatcher("admin/fileLoadFail.jsp").forward(
						request, response);
	}

	private String makePath(String saveFileName, String savePath) {
		// 得到文件名的hashCode的值，得到的就是fileName这个字符串对象在内存中的地址
		int hashCode = saveFileName.hashCode();
		int dir1 = hashCode & 0xf; // 0-15
		int dir2 = (hashCode & 0xf0) >> 4; // 0-15
		// 构造信息的保存目录
		String dir = savePath + "\\" + dir1 + "\\" + dir2;
		// file既可以代表文件也可以代表目录
		File file = new File(dir);
		// 如果目录不存在
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;

	}
	
	private String makeFileName(String fileName) {
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return UUID.randomUUID().toString() + "_" + fileName;

	}

}
