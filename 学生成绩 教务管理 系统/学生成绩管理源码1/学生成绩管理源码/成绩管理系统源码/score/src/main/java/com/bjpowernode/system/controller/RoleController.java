package com.bjpowernode.system.controller;

import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.common.controller.BaseController;
import com.bjpowernode.common.util.AjaxJson;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.entity.base.RoleEntity;
import com.bjpowernode.system.service.SystemService;

@Controller
@RequestMapping("/roleController")
public class RoleController extends BaseController{

	private static final Logger logger = Logger.getLogger(RoleController.class);
	
	@Autowired
	private SystemService systemService;
	
	
	/**
	 * 登陆页
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(params="goRole")
    public ModelAndView goRole(HttpServletRequest request){
        return new ModelAndView("system/role");
    }
	
	private List<ResourceEntity> getResources(String resourceids){
		if(resourceids == null){
			return null;
		}
		String[] resources = resourceids.split(",");
		List<ResourceEntity> resList = new ArrayList<ResourceEntity>();
		for(int i=0; i<resources.length; i++){
			ResourceEntity res = new ResourceEntity();
			res = this.systemService.get(ResourceEntity.class, resources[i]);
			resList.add(res);
		}
		return resList;
	}
	
	@RequestMapping(params="save")
    @ResponseBody
	public AjaxJson save(HttpServletRequest request, HttpServletResponse response, RoleEntity role,String resourceids) throws Exception {
		AjaxJson j = new AjaxJson();
		
		role.setResource(getResources(resourceids));
		j.setMsg("保存成功！");
		j.setSuccess(true);
		try{
			this.systemService.save(role);
		}catch(Exception e){
			j.setMsg("保存失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="update")
    @ResponseBody
	public AjaxJson update(HttpServletRequest request, HttpServletResponse response, RoleEntity role, String resourceids) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("更新成功！");
		j.setSuccess(true);
		try{
			role.setResource(getResources(resourceids));
			this.systemService.update(role);
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
				RoleEntity role = new RoleEntity();
				role.setId(id);
				this.systemService.delete(role);
			}
		}catch(Exception e){
			j.setMsg("删除失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="queryResource",method=RequestMethod.POST)
    @ResponseBody
	public AjaxJson queryResource(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("成功！");
		j.setSuccess(true);
		try{
			RoleEntity re = this.systemService.get(RoleEntity.class, id);
			String resourceId = "";
			for(ResourceEntity res:re.getResource()){
				if(res.getResources() == null || res.getResources().size() == 0){
					resourceId += (res.getId() + ",");
				}
				
			}
			if(resourceId.length()>0){
				resourceId = resourceId.substring(0, resourceId.length()-1);
			}
			j.setObj(resourceId);
		}catch(Exception e){
			j.setMsg("失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="dropdown")
    @ResponseBody
	public void dropdown(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DetachedCriteria condition = DetachedCriteria.forClass(RoleEntity.class);
		Pagination<?> pagination = systemService.getPageData(condition,0, 0);
		List<RoleEntity> list= (List<RoleEntity>)pagination.getDatas();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(RoleEntity re : list){
			sb.append("{");
			sb.append("\"id\":");
			sb.append("\"");
			sb.append(re.getId());
			sb.append("\"");
			sb.append(",");
			sb.append("\"text\":");
			sb.append("\"");
			sb.append(re.getName());
			sb.append("\"");
			sb.append("},");
		}
		String dropdown = sb.substring(0, sb.length()-1);
		dropdown += "]"; 
        response.setCharacterEncoding("utf-8");//指定为utf-8  
        response.getWriter().write(dropdown);//转化为JSOn格式  
		
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
		DetachedCriteria condition = DetachedCriteria.forClass(RoleEntity.class);
		Pagination<?> pagination = systemService.getPageData(condition,Integer.parseInt(page), Integer.parseInt(rows));
		JSONObject jobj = new JSONObject();
		jobj.put("total", pagination.getTotalCount());
		jobj.put("rows", pagination.getDatas());

        response.setCharacterEncoding("utf-8");  
        response.getWriter().write(jobj.toString());  
		
	}
	
}
