package service;

import models.Admin;
import models.Student;
import models.Teacher;

public interface ILoginUserService {
	public Teacher teacherLogin(String userid);
	public Student studentLogin(String userid);
	public Admin adminLogin(String userid);
}
