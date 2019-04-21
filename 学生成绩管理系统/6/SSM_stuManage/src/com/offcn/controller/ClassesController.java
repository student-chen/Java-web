package com.offcn.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;
import com.offcn.pojo.User;
import com.offcn.service.ClassesService;
import com.offcn.service.StudentService;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
@Controller
@RequestMapping("/cla")
public class ClassesController {
	@Resource
    ClassesService classesService;
	@Resource
	StudentService studentService;

	 /*
     * 列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
        int size=3;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",classesService.getClassesCount());
        
        model.addAttribute("clalist", classesService.getClassPager(pageNO, size));
        return "class/list";
     }


    /*
     * 删除单个对象Action
     */
    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        if(classesService.delete(id)>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/cla/list?pageNO="+pageNO;
    }
    
    /*
     * 删除多个对象Action
     */
    @RequestMapping("/deletes")
    public String deletes(Model model,@RequestParam int[] id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        //执行删除
    	System.out.println("批量删除"+id.toString());
        int rows=classesService.deletes(id);
        if(rows>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除"+rows+"行记录成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/cla/list?pageNO="+pageNO;
    }
    
    /*
     * 添加学生
     */
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("entity", new Classes());
        return "class/add";
    }
    
    /*
     * 添加保存
     */
    @RequestMapping("/addSave")
    public String addSave(Model model,@ModelAttribute("entity") @Valid Classes entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "class/add";
           
        }else{
        	classesService.insert(entity);
             return "redirect:/cla/list";    
             
        }
    }

    
    /*
     * 编辑
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable int id){
        model.addAttribute("entity", classesService.getCLassId(id));
        return "class/edit";
    }
    
    /*
     * 编辑保存
     */
    @RequestMapping("/editSave")
    public String editSave(Model model,@ModelAttribute("entity") @Valid Classes entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "/class/edit";
            
        }else{
        	classesService.update(entity);
            
            return "redirect:list";    
            
        }
       
    }
    
    @RequestMapping("search/{id}")
    public String search(@PathVariable int id,Model model) {
    	List<StudentExt> slist=studentService.getStuByCid(id);
    	model.addAttribute("slist", slist);
		return "class/stulist";
	}
    

    
    @RequestMapping("search1/{id}")
    public String search1(@PathVariable int id,Model model) {
    	/*List<StudentExt> slist=studentService.getStuByCid(id);
    	model.addAttribute("slist", slist);*/
    	Classes classes=classesService.getStuByid(id);
    	model.addAttribute("classes", classes);
		return "class/stulist1";
	}
    
}
