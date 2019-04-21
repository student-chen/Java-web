package com.offcn.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.offcn.mapper.CtcMapper;
import com.offcn.pojo.Classes;
import com.offcn.pojo.Course;
import com.offcn.pojo.CtcKey;
import com.offcn.pojo.Teacher;
import com.offcn.service.ClassesService;
import com.offcn.service.CourseService;
import com.offcn.service.TeacherService;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
@Controller
@RequestMapping("/cou")
public class CourseController {
	@Resource
    CourseService courseService;
	@Resource
	TeacherService teacherService; 
	@Resource
	ClassesService classesService;
	
   /* @Resource
	CtcService ctcService;*/
    /* @Resource
     GradeService gradeService;*/

	 /*
     * 列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
        int size=3;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",courseService.getCourseCount());
        
        model.addAttribute("coulist", courseService.getCoursePager(pageNO, size));
        return "course/list";
     }


    /*
     * 删除单个对象Action
     */
    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        if(courseService.delete(id)>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }
        return "redirect:/cou/list?pageNO="+pageNO;
    }
    
    /*
     * 删除多个对象Action
     */
    @RequestMapping("/deletes")
    public String deletes(Model model,@RequestParam int[] id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        //执行删除
    	System.out.println("批量删除"+id.toString());
        int rows=courseService.deletes(id);
        if(rows>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除"+rows+"行记录成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/cou/list?pageNO="+pageNO;
    }
    
    /*
     * 添加
     */
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("entity", new Course());
        return "course/add";
    }
    
    /*
     * 添加保存
     */
    @RequestMapping("/addSave")
    public String addSave(Model model,@ModelAttribute("entity") @Valid Course entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "course/add";
           
        }else{
        	courseService.insert(entity);
             return "redirect:/cou/list";    
             
        }
    }

    
    /*
     * 编辑
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable int id){
        model.addAttribute("entity", courseService.getCourseId(id));
        return "course/edit";
    }
    
    /*
     * 编辑保存
     */
    @RequestMapping("/editSave")
    public String editSave(Model model,@ModelAttribute("entity") @Valid Course entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "/course/edit";
            
        }else{
        	courseService.update(entity);
            
            return "redirect:list";    
            
        }
       
    }
    
    //排课
   @RequestMapping("/setTeacher/{id}")
    public String setTeacher(Model model,@PathVariable int id){
    	Course course=courseService.getCourseId(id);
    	model.addAttribute("entity",course);
    	List<Teacher> tlist=teacherService.getAllTeacher();
    	List<Classes> clist=classesService.getAllClasses();
    	model.addAttribute("tlist", tlist);
    	model.addAttribute("clist", clist);
    	return "course/setct";
    }
   
    @RequestMapping("editSavect")
    public String editSavect(Model model,@ModelAttribute("entity") Course entity,RedirectAttributes redirectAttributes){
    	//Course course=entity;
    	String classid=entity.getClasses();
    	String[] classids=classid.split(",");
    	List<CtcKey> ctclist=new ArrayList<CtcKey>();
    	for(int i=0;i<classids.length;i++){
    		CtcKey c=new CtcKey();
    		c.setCouid(entity.getId());
    		c.setClaid(Integer.parseInt(classids[i]));
    		c.setTid(entity.getTeacher().getId());
    		ctclist.add(c);
    	}
    	try{
    	  courseService.insertBatch(ctclist);
    	}catch(Exception e){
    		redirectAttributes.addFlashAttribute("msg", "排课存在冲突，请核对后重新选！");
    	}
    	return "redirect:/cou/list";
    }
    
}
