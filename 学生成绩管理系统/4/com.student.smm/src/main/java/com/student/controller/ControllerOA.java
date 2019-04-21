package com.student.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.biz.OAUserdaoBiz;
import com.student.pojo.OAClass;
import com.student.pojo.OAStudent;
import com.student.pojo.PagerMySQL;
import com.student.pojo.TeacherOA;
import com.student.pojo.UserLog;
import com.student.pojo.UserOA;
import com.student.pojo.poi.ExcelTemplate;


@Controller
public class ControllerOA {
	private OAUserdaoBiz oaUserdaoBiz;
	@Resource(name = "oaUserdaoBiz")
	public void setBiz(OAUserdaoBiz oaUserdaoBiz) {
		this.oaUserdaoBiz = oaUserdaoBiz;
	}
	//登录
	@RequestMapping("/logindos")
	public ModelAndView oaLogin(HttpServletRequest request,UserOA userOA,Model model,HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		UserOA userOAs=oaUserdaoBiz.OaLogin(userOA);	
		String pwd = userOA.getPassword();
		session.setAttribute("password", pwd);
		if(userOAs!=null){
			session.setAttribute("id",userOAs.getId());
			session.setAttribute("userOA", userOA);		
			modelAndView.addObject("userOA",userOAs);
			modelAndView.addObject("mainpage",null);
			modelAndView.setViewName("/LogOAselect");
		}else{		
			request.setAttribute("error","请输入正确的用户名或密码!");		
			modelAndView.setViewName("/login.jsp");
		}
		return modelAndView;		
	}
	//按班级查询所有学生
	@RequestMapping("AllStduentclass")
	public String AllStudent(String one,String two,Model model,Integer id,
	    @RequestParam(value = "pageNo", defaultValue = "1") Integer curPage,
		@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize){  
		PageHelper.startPage(curPage, pageSize);
		List<OAStudent> list=oaUserdaoBiz.AllclassStudent(one,two,id);
		PageInfo<OAStudent> pageInfo = new PageInfo<OAStudent>(list);
		PagerMySQL<OAStudent> pager = new PagerMySQL<OAStudent>(
				curPage, pageSize, new Long(pageInfo.getTotal()).intValue());
		pager.setEntitiesList(list);
		if (one!= null && two!=null) {
			model.addAttribute("huixianName", one);
			model.addAttribute("huixianNames", two);
		}
		model.addAttribute("pagerBooks", pager);
		model.addAttribute("mainPage", "/AllStudent.jsp");
		return "/AllStudent.jsp";
	}
	//Student信息查询
	@RequestMapping("StudentOAselect")
	public String getSelectMess(String text1,String text2,Model model,HttpSession session,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer curPage,
			@RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize){       
		 PageHelper.startPage(curPage, pageSize);
		List<OAStudent> list=oaUserdaoBiz.getSelectMess(text1, text2);
		PageInfo<OAStudent> pageInfo = new PageInfo<OAStudent>(list);
		PagerMySQL<OAStudent> pager = new PagerMySQL<OAStudent>(
				curPage, pageSize, new Long(pageInfo.getTotal()).intValue());
		pager.setEntitiesList(list);
		if (text1!= null && text2!=null) {
			model.addAttribute("huixianName", text1);
			model.addAttribute("huixianNames", text2);
		}
		model.addAttribute("pagerBooks", pager);
		session.setAttribute("ggsmd", list);
		model.addAttribute("mainPage", "/Student.jsp");
		return "/Student.jsp";
	}
	//删除
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(Integer[] id,Model model){
		ModelAndView modelAndView=new ModelAndView();
		int num=oaUserdaoBiz.deleteStudent(id);
		if(num==1){
			model.addAttribute("deletes","删除成功√");
			modelAndView.setViewName("/StudentOAselect");
		}
		return modelAndView;	
	}
	//删除
		@RequestMapping("/delet")
		public String getdelete(Model model,Integer[] id) 
		{
			int num=oaUserdaoBiz.deleteStudent(id);
			if(num==1){		
				return "/StudentOAselect";
			}else{
				return "/StudentOAselect";
			}
		}
	//添加
	@RequestMapping("saveStudent")
	public ModelAndView saveStudent(OAStudent oaStudent,Model model){
		ModelAndView modelAndView=new ModelAndView();
		int rets=oaUserdaoBiz.saveStudent(oaStudent); 		    
	    	if(rets==1){
	    		modelAndView.addObject("oaUserdaoBiz", oaUserdaoBiz);
	    		model.addAttribute("mywo","保存成功");
	    		modelAndView.setViewName("/StudentOAselect");
	    	}
			return modelAndView;	    		    	
}   
	//修改传值
	/*@RequestMapping("Select")
	public ModelAndView getFinan(Integer id) {
		ModelAndView view = new ModelAndView();
		OAStudent list=oaUserdaoBiz.getupdate(id);
		if (list != null) {
			view.addObject("list", list);
			view.setViewName("/StudentUpdate.jsp");
		}
		return view;
	}*/
	 //修改Student
    @RequestMapping("Studentupdate")
    public String Studentupdate(Model model,Integer id,int sid,String name,String sex,String age,String tel,String grade){   		
    OAStudent bizz=new OAStudent();
    bizz.setId(id);
    bizz.setSid(sid);
    bizz.setName(name);
    bizz.setSex(sex);
    bizz.setAge(age);
    bizz.setTel(tel);
    bizz.setGrade(grade);
    int ret=oaUserdaoBiz.updateStudent(bizz);
	if(ret==1){
		model.addAttribute("mywo","修改成功");
		return "/StudentOAselect";
	} 	
	return "/StudentOAselect";  	
    }
   //Class班级查询
  	@RequestMapping("ClassOAselect")
  	public String ClassSelect(String text3,String text4,Model model,HttpSession session,
  			@RequestParam(value = "pageNo", defaultValue = "1") Integer curPage,
  			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){       
  		 PageHelper.startPage(curPage, pageSize);
  		List<OAClass> list=oaUserdaoBiz.ClassSelect(text3, text4);
  		PageInfo<OAClass> pageInfo = new PageInfo<OAClass>(list);
  		PagerMySQL<OAClass> pager = new PagerMySQL<OAClass>(
  				curPage, pageSize, new Long(pageInfo.getTotal()).intValue());
  		pager.setEntitiesList(list);
  		if (text3!= null && text4!=null) {
  			model.addAttribute("huixianName", text3);
  			model.addAttribute("huixianNames", text4);
  		}
  		session.setAttribute("ggsmd", list);
  		model.addAttribute("pagerBooks", pager);
  		model.addAttribute("mainPage", "/Class.jsp");
  		return "/Class.jsp";
  	}
  //删除
  	@RequestMapping("deleteClass")
  	public ModelAndView deleteClass(Integer[] id,Model model){
  		ModelAndView modelAndView=new ModelAndView();
  		int num=oaUserdaoBiz.deleteClass(id);
  		if(num==1){
  			model.addAttribute("deletes","删除成功√");
  			modelAndView.setViewName("/ClassOAselect");
  		}
  		return modelAndView;	
  	}
  //删除
  		@RequestMapping("/deletss")
  		public String getdeletes(Model model,Integer[] id) 
  		{
  			int num=oaUserdaoBiz.deleteClass(id);
  			if(num==1){		
  				return "/ClassOAselect";
  			}else{
  				return "/ClassOAselect";
  			}
  		}
  	//添加
  	@RequestMapping("saveClass")
  	public ModelAndView saveClass(OAClass oaClass,Model model){
  		ModelAndView modelAndView=new ModelAndView();
  		int rets=oaUserdaoBiz.saveClass(oaClass);	    
  	    	if(rets==1){
  	    		modelAndView.addObject("biz", rets);
  	    		model.addAttribute("mywo","保存成功");
  	    		modelAndView.setViewName("/ClassOAselect");
  	    	}
  			return modelAndView;	    		    	
  }   
  	//修改传值
/*  	@RequestMapping("Selects")
  	public ModelAndView getFinans(Integer id) {
  		ModelAndView view = new ModelAndView();
  		OAClass list=oaUserdaoBiz.getupdateOAClass(id);
  		if (list != null) {
  			view.addObject("list", list);
  			view.setViewName("/ClassUpdate.jsp");
  		}
  		return view;
  	}*/
  	 //修改Student
    @RequestMapping("Classupdate")
      public String Classupdate(Model model,Integer id,String classid,String classname,String classexplain){   		
      OAClass bizz=new OAClass();
      bizz.setId(id);
      bizz.setClassid(classid);
      bizz.setClassname(classname);
      bizz.setClassexplain(classexplain);
      int ret=oaUserdaoBiz.updateClass(bizz);
  	if(ret==1){
  		model.addAttribute("mywo","修改成功√");
  		return "/ClassOAselect";
  	} 	
  	return "/ClassOAselect";  	
      }
    //教師表出查詢
     @RequestMapping("TeacherSelect")
        public String getSelect(String text5,String text6,Model model,HttpSession session,
    	 @RequestParam(value = "pageNo", defaultValue = "1") Integer curPage,
		 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){       
		 PageHelper.startPage(curPage, pageSize);
		List<TeacherOA> list=oaUserdaoBiz.TeacherSelect(text5, text6);
		PageInfo<TeacherOA> pageInfo = new PageInfo<TeacherOA>(list);
		PagerMySQL<TeacherOA> pager = new PagerMySQL<TeacherOA>(
				curPage, pageSize, new Long(pageInfo.getTotal()).intValue());
		pager.setEntitiesList(list);
		if (text5!= null && text6!=null) {
			model.addAttribute("huixianName", text5);
			model.addAttribute("huixianNames", text6);
		}
		session.setAttribute("ggsmd", list);
		model.addAttribute("pagerBooks", pager);
		model.addAttribute("mainPage", "/Teacher.jsp");
		return "/Teacher.jsp";
	}
     //删除
   	@RequestMapping("deleteTeacher")
   	public ModelAndView deleteTeacher(Integer[] tid,Model model){
   		ModelAndView modelAndView=new ModelAndView();
   		int num=oaUserdaoBiz.deleteTeacher(tid);
   		if(num==1){
   			model.addAttribute("deletes","删除成功√");
   			modelAndView.setViewName("/TeacherSelect");
   		}
   		return modelAndView;	
   	}
    //删除
		@RequestMapping("/deletTeachers")
		public String deleteTeachers(Model model,Integer[] tid) 
		{
			int num=oaUserdaoBiz.deleteTeacher(tid);
			if(num==1){		
				return "/TeacherSelect";
			}else{
				return "/TeacherSelect";
			}
		}
	 	//添加
	  	@RequestMapping("saveTeacher")
	  	public ModelAndView saveTeacher(TeacherOA teacherOA,Model model){
	  		ModelAndView modelAndView=new ModelAndView();
	  		int rets=oaUserdaoBiz.saveTeacher(teacherOA);    
	  	    	if(rets==1){
	  	    		modelAndView.addObject("biz", rets);
	  	    		model.addAttribute("mywo","保存成功");
	  	    		modelAndView.setViewName("/TeacherSelect");
	  	    	}
	  			return modelAndView;	    		    	
	  }  
	  	 //修改Student
	    @RequestMapping("Teacherupdate")
	      public String Teacherupdate(Model model,Integer tid,String tname,String tcard,String tsex,String tlesson,String ttext){   		
	      TeacherOA bizz=new TeacherOA();
	      bizz.setTid(tid);
	      bizz.setTname(tname);
	      bizz.setTcard(tcard);
	      bizz.setTsex(tsex);
	      bizz.setTlesson(tlesson);
	      bizz.setTtext(ttext);
	      int ret=oaUserdaoBiz.updateTeacher(bizz);
	  	  if(ret==1){
	  		model.addAttribute("mywo","修改成功√");
	  		return "/TeacherSelect";
	  	} 	
	  	return "/TeacherSelect";  	
	      }
	  //修改密码
	    @RequestMapping("OAUserupdates")
	      public String Classupdate(Model model,int id,String password){   		
	      UserOA bizz=new UserOA();
	      bizz.setId(id);
	      bizz.setPassword(password);
	      int ret=oaUserdaoBiz.UserOAs(bizz);
	  	if(ret==1){
	  		return "/login.jsp";
	  	} 	
	  	else{
	  		return "/PasswordUpdate.jsp";
	  	}
	    }
	    /**
		 * 下载
		 * 
		 * @param model
		 * @param session
		 * @return
		 */	
		@RequestMapping("xiazai")
		public String xiazai(Model model, HttpSession session) {
			List<OAStudent> list = (List<OAStudent>) session
					.getAttribute("ggsmd");
			ExcelTemplate et = ExcelTemplate.getInstance().readTemplateByClasspath(
					"/excel/Students"
					+ ".xls");
			for (OAStudent kcb : list) {
				et.createNewRow();
				et.createCell(kcb.getSid());
				et.createCell(kcb.getName());
				et.createCell(kcb.getSex());
				et.createCell(kcb.getAge());
				et.createCell(kcb.getTel());
				et.createCell(kcb.getGrade());
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", "测试用例标题");
			map.put("date", new Date().toString());
			map.put("dept", "学生基本信息");
			et.replaceFinalData(map);
			et.insertSer();
			et.writeToFile("E:\\test1.xls");
			model.addAttribute("msg", "导出成功");
			return "StudentOAselect";
		}
		  /**
				 * 下载
				 * 
				 * @param model
				 * @param session
				 * @return
				 */	
				@RequestMapping("xiazais")
				public String xiazais(Model model, HttpSession session) {
					List<OAClass> list = (List<OAClass>) session
							.getAttribute("ggsmd");
					ExcelTemplate et = ExcelTemplate.getInstance().readTemplateByClasspath(
							"/excel/Class"
							+ ".xls");
					for (OAClass kcb : list) {
						et.createNewRow();
						et.createCell(kcb.getClassid());
						et.createCell(kcb.getClassname());
						et.createCell(kcb.getClassexplain());
					}
					Map<String, String> map = new HashMap<String, String>();
					map.put("title", "测试用例标题");
					map.put("date", new Date().toString());
					map.put("dept", "班级基本信息");
					et.replaceFinalData(map);
					et.insertSer();
					et.writeToFile("E:\\test2.xls");
					model.addAttribute("msg", "导出成功");
					return "ClassOAselect";
				}
				  /**
				 * 下载
				 * 
				 * @param model
				 * @param session
				 * @return
				 */	
				@RequestMapping("xiazaiss")
				public String xiazaiss(Model model, HttpSession session) {
					List<TeacherOA> list = (List<TeacherOA>) session
							.getAttribute("ggsmd");
					ExcelTemplate et = ExcelTemplate.getInstance().readTemplateByClasspath(
							"/excel/teacher"
							+ ".xls");
					for (TeacherOA kcb : list) {
						et.createNewRow();
						et.createCell(kcb.getTname());
						et.createCell(kcb.getTsex());
						et.createCell(kcb.getTcard());
						et.createCell(kcb.getTadd());
						et.createCell(kcb.getTlesson());
						et.createCell(kcb.getTtext());
					}
					Map<String, String> map = new HashMap<String, String>();
					map.put("title", "测试用例标题");
					map.put("date", new Date().toString());
					map.put("dept", "老师基本信息");
					et.replaceFinalData(map);
					et.insertSer();
					et.writeToFile("E:\\test3.xls");
					model.addAttribute("msg", "导出成功");
					return "TeacherSelect";
				}
				@RequestMapping("/Savazhuce")
				public ModelAndView Savezhuce(UserOA userOA,Model model){
					ModelAndView modelAndView=new ModelAndView();
					int rets=oaUserdaoBiz.SavaZhuce(userOA);
					if(rets==1){
						modelAndView.addObject("biz", rets);
		  	    		model.addAttribute("zhuce","注册成功");
		  	    		modelAndView.setViewName("/login.jsp");
					}
					return modelAndView;
				}
				//Log信息查询
				@RequestMapping("LogOAselect")
				public String getSelectLog(String text7,String text8,Model model,HttpSession session,
						@RequestParam(value = "pageNo", defaultValue = "1") Integer curPage,
						@RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize){       
					 PageHelper.startPage(curPage, pageSize);
					List<UserLog> list=oaUserdaoBiz.UserLogs(text7, text8);
					PageInfo<UserLog> pageInfo = new PageInfo<UserLog>(list);
					PagerMySQL<UserLog> pager = new PagerMySQL<UserLog>(
							curPage, pageSize, new Long(pageInfo.getTotal()).intValue());
					pager.setEntitiesList(list);
					if (text7!= null && text8!=null) {
						model.addAttribute("huixianName", text7);
						model.addAttribute("huixianNames", text8);
					}
					model.addAttribute("pagerBooks", pager);
					session.setAttribute("ggsmd", list);
					model.addAttribute("mainPage", "/index.jsp");
					return "/index.jsp";
				}
				//下拉框查询班级
				@RequestMapping("Allclass")
				public ModelAndView getAllclass(){
					List<OAClass> list=new ArrayList<OAClass>();
					list=oaUserdaoBiz.getAllClass();
					ModelAndView modelAndView=new ModelAndView();
					modelAndView.addObject("list",list);
					modelAndView.setViewName("Student.jsp");				
					return modelAndView;					
				} 



	    
}
