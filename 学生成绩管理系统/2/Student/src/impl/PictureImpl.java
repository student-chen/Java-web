package impl;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

import dao.IPicture;
import entity.Student;

public class PictureImpl implements IPicture
{
	// 更新学生信息是检查是否更新了照片
	public void check(ServletConfig servletConfig, HttpServletRequest request, HttpServletResponse response, SmartUpload sm, Student student)
	{
		try
		{
			File file = sm.getFiles().getFile(0);
			if (!file.isMissing())
			{
				delete(servletConfig, request, response, student);
				upload(file, student);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// 删除旧照片
	public void delete(ServletConfig servletConfig, HttpServletRequest request, HttpServletResponse response, Student student)
	{
		String pic_old = student.getPic();
		if (pic_old != null && !pic_old.equals("") && !pic_old.equals("../images/person.png"))
		{
			String temp1 = new java.io.File(servletConfig.getServletContext().getRealPath(request.getRequestURI())).getParent();
			java.io.File of = new java.io.File(temp1.substring(0, temp1.length() - 8) + pic_old.substring(2));
			if (of.isFile())
				of.delete();
		}
	}

	// 上传新照片
	public void upload(File file, Student student)
	{
		try
		{
			String pic = "upload/" + student.getNo() + "." + file.getFileExt().toLowerCase();
			student.setPic("../" + pic);
			file.saveAs(pic);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
