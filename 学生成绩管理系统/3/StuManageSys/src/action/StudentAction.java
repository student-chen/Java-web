package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import models.Course_teacher;
import models.Student;
import models.Student_course;
import service.IStudentService;

import com.opensymphony.xwork2.ActionContext;

public class StudentAction implements ServletResponseAware{
	private HttpServletRequest request = null;
	private javax.servlet.http.HttpServletResponse response;
	private Student newstudent;
    private IStudentService studentservice;
	public IStudentService getStudentservice() {
		return studentservice;
	}

	public void setStudentservice(IStudentService studentservice) {
		this.studentservice = studentservice;
	}

	public Student getNewstudent() {
		return newstudent;
	}

	public void setNewstudent(Student newstudent) {
		this.newstudent = newstudent;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String execute() throws Exception {
		ActionContext.getContext().getSession().put("student", newstudent);
		studentservice.updateStuInfo(newstudent);
		System.out.print(newstudent.getStuName());
		return "success";
	}
	
	public String showcourse(){
		List<Course_teacher> course_teachers= studentservice.getAllCourse();
		if(course_teachers!=null){
			ActionContext.getContext().getSession().put("ct", course_teachers);
			return "success";
		}
		else
			return "fail";
	}
	
	public String selectcourse() throws IOException{
		String ctid=ServletActionContext.getRequest().getParameter("ctid");
		Student student=(Student)ActionContext.getContext().getSession().get("student");
		if(studentservice.selectCourse(Integer.parseInt(ctid), student)){
			 response.setContentType("text/html;charset=gb2312");
			 PrintWriter out = response.getWriter();
			 out.print("<script>alert('选定成功！')</script>");
			 out.print("<script>window.location.href='/stuManage/student/courselist.jsp'</script>");
			 out.flush();
             out.close();
			return null;
		}
		else
		{
			response.setContentType("text/html;charset=gb2312");
			 PrintWriter out = response.getWriter();
			 out.print("<script>alert('对不起你已经选过该课程！')</script>");
			 out.print("<script>window.location.href='/stuManage/student/courselist.jsp'</script>");
			 out.flush();
            out.close();
			return null;
		}
		
		
	}
	
	public String selectcourseresult(){
		Student student=(Student)ActionContext.getContext().getSession().get("student");
		List<Student_course> studentcourses= studentservice.selectcourseResult(student);
		if(studentcourses!=null){
			ActionContext.getContext().getSession().put("sc", studentcourses);
			return "success";
		}
		else	
	     	return "fail";
	}
	
	public String deletecourse(){
		String ctid=ServletActionContext.getRequest().getParameter("ctid");
		Student student=(Student)ActionContext.getContext().getSession().get("student");
		if(studentservice.deletecourse(ctid, student)){
			List<Student_course> studentcourses= studentservice.selectcourseResult(student);
			ActionContext.getContext().getSession().put("sc", studentcourses);
			return "success";
		}		
		else
			return "fail";
	}

	public void setServletResponse(HttpServletResponse response) {
		   this.response = response;
		}
}
