package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import models.Admin;
import models.Course;
import models.Course_teacher;
import models.Student;
import models.Teacher;

import org.apache.struts2.ServletActionContext;

import service.IAdminService;

import com.opensymphony.xwork2.ActionContext;

public class AdminAction {
	private IAdminService adminservice;
	private HttpServletRequest request;
	private Teacher newteacher;

	public Teacher getNewteacher() {
		return newteacher;
	}

	public void setNewteacher(Teacher newteacher) {
		this.newteacher = newteacher;
	}
    private Admin newadmin;
    private Student newstudent;
    private Course newcourse;
    public Course getNewcourse() {
		return newcourse;
	}

	public void setNewcourse(Course newcourse) {
		this.newcourse = newcourse;
	}

	public Student getNewstudent() {
		return newstudent;
	}

	public void setNewstudent(Student newstudent) {
		this.newstudent = newstudent;
	}


	public Admin getNewadmin() {
		return newadmin;
	}

	public void setNewadmin(Admin newadmin) {
		this.newadmin = newadmin;
	}

	public IAdminService getAdminservice() {
		return adminservice;
	}

	public void setAdminservice(IAdminService adminservice) {
		this.adminservice = adminservice;
	}

	public String execute() {
		ActionContext.getContext().getSession().put("admin", newadmin);
		if(adminservice.updateAdminInfo(newadmin)){
			return "success";
		}
		else
			return "false";
	}
	
	public String showallstuInfo(){
		List<Student> allstudent=adminservice.getallstuInfo();
		request=ServletActionContext.getRequest();
		request.setAttribute("allstudent", allstudent);
		return "success";
	}
	
	public String admindeletestu(){
		String stuid=ServletActionContext.getRequest().getParameter("stuid");
		Student deletestudent=new Student();
		deletestudent.setStuId(Integer.parseInt(stuid));
		if(adminservice.admindeletestu(deletestudent)){
			List<Student> allstudent=adminservice.getallstuInfo();
			request=ServletActionContext.getRequest();
			request.setAttribute("allstudent", allstudent);
			return "success";
		}
		else
			return "false";
	}
	
	public String admingetSelectedStu(){
		String stuid=ServletActionContext.getRequest().getParameter("stuid");
		int realstuid=Integer.parseInt(stuid);
		Student selectedstudent=adminservice.admingetSelectedStu(realstuid);
		if(selectedstudent==null)
			return "fail";
		else{
			request=ServletActionContext.getRequest();
			request.setAttribute("selectedstudent", selectedstudent);
			return "success";
		}		
	}
	
	public String adminEditStu(){
		if(adminservice.adminEditStu(newstudent)){
			List<Student> allstudent=adminservice.getallstuInfo();
			request=ServletActionContext.getRequest();
			request.setAttribute("allstudent", allstudent);
			return "success";
		}		
		else
			return "fail";
	}
	
	public String adminAddStu(){
		if(adminservice.adminAddStu(newstudent)){
			return "success";
		}
		else
			return "fail";
	}
	
	public String showallcourse(){
		List<Course> allcourse=adminservice.getallCourseInfo();
		request=ServletActionContext.getRequest();
		request.setAttribute("allcourse", allcourse);
		return "success";
	}
	
	public String adminDeleteCourse(){
		String cid=ServletActionContext.getRequest().getParameter("cid");
		Course deletecourse=new Course();
		deletecourse.setCId(Integer.parseInt(cid));
		if(adminservice.adminDeleteCourse(deletecourse)){
			List<Course> allcourse=adminservice.getallCourseInfo();
			request=ServletActionContext.getRequest();
			request.setAttribute("allcourse", allcourse);
			return "success";
		}
		else
			return "fail";
	}
	
	public String admingetSelectedCourseInfo(){
		String cid=ServletActionContext.getRequest().getParameter("cid");
		int realcid=Integer.parseInt(cid);
		Course selectedcouse=adminservice.admingetSelectedCourseInfo(realcid);
		if(selectedcouse!=null){
			request=ServletActionContext.getRequest();
			request.setAttribute("selectedcouse", selectedcouse);
			return "success";
		}
		else
			return "fail";
	}
	
	public String adminEditCourse(){
		if(adminservice.adminEditCourse(newcourse)){
			List<Course> allcourse=adminservice.getallCourseInfo();
			request=ServletActionContext.getRequest();
			request.setAttribute("allcourse", allcourse);
			return "success";
		}
		else
			return "fail";
	}
	
	public String adminAddCourse(){
		if(adminservice.adminAddCourse(newcourse)){
			List<Course> allcourse=adminservice.getallCourseInfo();
			request=ServletActionContext.getRequest();
			request.setAttribute("allcourse", allcourse);
			return "success";
		}
		else
			return "fail";
	}

	public String manageTea() {
		List a = adminservice.manageTeacher();
		request = ServletActionContext.getRequest();
		// HttpSession session=request.getSession();
		request.setAttribute("teacherList", a);
		return "success";
	}

	public String deleteTea() { // 管理员删除教师
		request = ServletActionContext.getRequest();
		String tid = (String) request.getParameter("tid");
		Teacher a = new Teacher();
		a.setTId(Integer.parseInt(tid));
		boolean b = adminservice.deleteTeacher(a);
		if (b)
			return "success";
		return "fail";
	}

	public String adminEditTeacher() {
		request = ServletActionContext.getRequest();
		String tid = (String) request.getParameter("tid");
		Teacher a = adminservice.getOneTeacher(Integer.parseInt(tid));
		request.setAttribute("teacher", a);
		return "success";
	}

	public String UpdateTea() { // 管理员更改教师信息
		request = ServletActionContext.getRequest();
		String tid = (String) request.getParameter("tid");

		boolean b = adminservice.adminUpdateTeacher(newteacher);
		if (b)
			return "success";
		return "fail";
	}

	public String adminAddTeacher() {
		boolean b = adminservice.adminAddTeacher(newteacher);
		if (b)
			return "success";
		return "fail";
	}

	public String adminManageCTid() {           // 教师授课管理
		List a;
		try {
			a = adminservice.getAllCT();
		} catch (Exception e) {
			return "fail";
		}
		request = ServletActionContext.getRequest();
		request.setAttribute("allCT", a);
		return "success";
	}
	
	public String adminDeleteCTid(){         //删除教师授课
		request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
	    String ctid=request.getParameter("ctid");
	    Course_teacher c=new Course_teacher();
	    c.setCTId(Integer.parseInt(ctid));
	    boolean b=adminservice.deleteCT(c);
	    if (b)
			return "success";
		return "fail";
	    
	}
	
	public String adminManageSCid(){              //学生选课记录管理
		
		List a;
		try {
			a = adminservice.getAllSC();
		} catch (Exception e) {
			return "fail";
		}
		request = ServletActionContext.getRequest();
		request.setAttribute("allSC", a);
		return "success";
	}
	public String adminDeleteSC(){              //删除学生选课记录
		request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
	    String stuid=request.getParameter("stuid");
	    String ctid=request.getParameter("ctid");
	    boolean b=adminservice.deleteSC(Integer.parseInt(stuid), Integer.parseInt(ctid));
	    if (b)
			return "success";
		return "fail";
	}
	public String adminEditGrade(){               //编辑学生选课信息
		request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
	    String stuid=request.getParameter("stuid");
	    String ctid=request.getParameter("ctid");
	    String grade=request.getParameter("grade");
	    Student a=adminservice.getStudent(Integer.parseInt(stuid));
	    session.setAttribute("stuName", a.getStuName());
	    
	    session.setAttribute("stuid", stuid);
	    session.setAttribute("ctid", ctid);
	    request.setAttribute("grade", grade);
	    return "success";
	}
	public String adminChangeGrade(){            //确认修改学生信息
		request=ServletActionContext.getRequest();
	    HttpSession session=request.getSession();
	    String stuid=(String)session.getAttribute("stuid");
	    String ctid=(String)session.getAttribute("ctid");
	    String grade=(String)request.getParameter("newgrade");
	    boolean b=adminservice.updateGrade(Integer.parseInt(stuid), Integer.parseInt(ctid), Integer.parseInt(grade));
	    if (b)
			return "success";
		return "fail";
	}
}
