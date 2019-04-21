package com.bjpowernode.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjpowernode.common.controller.BaseController;
import com.bjpowernode.common.util.AjaxJson;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.service.SystemService;

@Controller
@RequestMapping("/resourceController")
public class ResourceController extends BaseController{

	private static final Logger logger = Logger.getLogger(ResourceController.class);
	
	@Autowired
	private SystemService systemService;
	
	
	/**
	 * 登陆页
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(params="goResource")
    public ModelAndView goResource(HttpServletRequest request){
        return new ModelAndView("system/resource");
    }
	
	@RequestMapping(params="save")
    @ResponseBody
	public AjaxJson save(HttpServletRequest request, HttpServletResponse response, ResourceEntity resource,String parentid) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("保存成功！");
		j.setSuccess(true);
		try{
			ResourceEntity patentRes = new ResourceEntity();
			patentRes.setId(parentid);
			resource.setParentResource(patentRes);
			this.systemService.save(resource);
		}catch(Exception e){
			j.setMsg("保存失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="update")
    @ResponseBody
	public AjaxJson update(HttpServletRequest request, HttpServletResponse response, ResourceEntity resource, String parentid) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("更新成功！");
		j.setSuccess(true);
		try{
			ResourceEntity patentRes = new ResourceEntity();
			patentRes.setId(parentid);
			resource.setParentResource(patentRes);
			this.systemService.update(resource);
		}catch(Exception e){
			j.setMsg("更新失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="delete",method=RequestMethod.POST)
    @ResponseBody
	public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("删除成功！");
		j.setSuccess(true);
		try{
			for(String id:ids.split(",")){
				ResourceEntity resource = new ResourceEntity();
				resource.setId(id);
				this.systemService.delete(resource);
			}
		}catch(Exception e){
			j.setMsg("删除失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="datagrid")
    @ResponseBody
	public void datagrid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String page = request.getParameter("page");//easyui datagrid 分页 页号
		String rows = request.getParameter("rows");//easyui datagrid 分页 页数
		if(page == null){
			page = "0";
		}
		if(rows == null){
			rows = "0";
		}
		DetachedCriteria condition = DetachedCriteria.forClass(ResourceEntity.class);
		Pagination<?> pagination = systemService.getPageData(condition,Integer.parseInt(page), Integer.parseInt(rows));
		List<ResourceEntity> list= (List<ResourceEntity>)pagination.getDatas();
		String resourceJson = systemService.getTreeJson(list);

        response.setCharacterEncoding("utf-8");//指定为utf-8  
        response.getWriter().write(resourceJson);//转化为JSOn格式  
		
	}
	
	@RequestMapping(params="treeDropdown")
    @ResponseBody
	public void treeDropdown(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if(page == null){
			page = "0";
		}
		if(rows == null){
			rows = "0";
		}
		DetachedCriteria condition = DetachedCriteria.forClass(ResourceEntity.class);
		Pagination<?> pagination = systemService.getPageData(condition,Integer.parseInt(page), Integer.parseInt(rows));
		List<ResourceEntity> list= (List<ResourceEntity>)pagination.getDatas();
		String retJson = systemService.getTreeJson(list);
		String resourceJson = retJson.replaceAll("\"name\"", "\"text\"");
        response.setCharacterEncoding("utf-8"); 
        response.getWriter().write(resourceJson);  
		
	}
}
