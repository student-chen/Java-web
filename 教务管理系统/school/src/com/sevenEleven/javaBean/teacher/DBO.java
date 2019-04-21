package com.sevenEleven.javaBean.teacher;
import com.sevenEleven.javaBean.teacher.Using;
import com.sevenEleven.javaBean.teacher.Doing;
public class DBO {
	static public Doing DBODoing(){
		return new SubDoing();
	}
	static public Using DBOUsing(){
		return new SubUsing();
	}
}
