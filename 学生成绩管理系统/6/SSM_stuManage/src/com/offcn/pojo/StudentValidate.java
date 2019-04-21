package com.offcn.pojo;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidate implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		Student student=(Student) arg0;
		if(student.getClassid()<0){
			arg1.rejectValue("classis", "required", "kkkkkk");
		}
	}

}
