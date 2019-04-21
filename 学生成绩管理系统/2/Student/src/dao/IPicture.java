package dao;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

import entity.Student;

public interface IPicture
{
	// 更新学生信息是检查是否更新了照片
	public void check(ServletConfig servletConfig, HttpServletRequest request, HttpServletResponse response, SmartUpload sm, Student student);

	// 上传照片
	public void upload(File file, Student student);

	// 删除旧照片
	public void delete(ServletConfig servletConfig, HttpServletRequest request, HttpServletResponse response, Student student);

}
