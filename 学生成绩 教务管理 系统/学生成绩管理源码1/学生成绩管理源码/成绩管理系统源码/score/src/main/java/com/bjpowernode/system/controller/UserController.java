package com.bjpowernode.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;
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
import com.bjpowernode.system.entity.base.RoleEntity;
import com.bjpowernode.system.entity.base.UserEntity;
import com.bjpowernode.system.service.SystemService;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController{

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private SystemService systemService;
	
	
	/**
	 * 登陆页
	 * @param 
	 * @param model
	 * @return
	 */
	@RequestMapping(params="goUser")
    public ModelAndView goUser(HttpServletRequest request){
        return new ModelAndView("system/user");
    }
	
	@RequestMapping(params="checkRemote")
    @ResponseBody
	public void checkRemote(HttpServletRequest request, HttpServletResponse response, String signcode) throws Exception {
		UserEntity user = this.systemService.findUniqueByProperty(UserEntity.class, "username", signcode);
		String flag = "true";
		if(user != null){
			flag = "false";
		}
        response.setCharacterEncoding("utf-8");  
        response.getWriter().write(flag);  
		
	}
	
	@RequestMapping(params="save")
    @ResponseBody
	public AjaxJson save(HttpServletRequest request, HttpServletResponse response, UserEntity user, String roleid) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("保存成功！");
		j.setSuccess(true);
		try{
			Md5Hash md5Hash = new Md5Hash(user.getPassword());
			user.setPassword(md5Hash.toHex());
			user.setRoles(getRoleList(roleid));
			this.systemService.save(user);
		}catch(Exception e){
			j.setMsg("保存失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="update")
    @ResponseBody
	public AjaxJson update(HttpServletRequest request, HttpServletResponse response, UserEntity user, String roleid) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("更新成功！");
		j.setSuccess(true);
		try{
			UserEntity t = this.systemService.get(UserEntity.class, user.getId());
			user.setRoles(getRoleList(roleid));
			user.setPassword(t.getPassword());
			user.setUsername(t.getUsername());
			BeanUtils.copyProperties(t, user);
			this.systemService.update(t);
		}catch(Exception e){
			j.setMsg("更新失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	private List<RoleEntity> getRoleList(String roleid){
		if(roleid == null){
			return null;
		}
		String[] ids = roleid.split(",");
		List<RoleEntity> roleList = new ArrayList<RoleEntity>();
		for(String id:ids){
			RoleEntity re = this.systemService.get(RoleEntity.class, id);
			roleList.add(re);
		}
		return roleList;
	}
	
	@RequestMapping(params="delete",method=RequestMethod.POST)
    @ResponseBody
	public AjaxJson delete(HttpServletRequest request, HttpServletResponse response, String ids) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("删除成功！");
		j.setSuccess(true);
		try{
			for(String id:ids.split(",")){
				UserEntity user = new UserEntity();
				user.setId(id);
				this.systemService.delete(user);
			}
		}catch(Exception e){
			j.setMsg("删除失败！");
			j.setSuccess(false);
		}
		 return j;
		
	}
	
	@RequestMapping(params="queryRole",method=RequestMethod.POST)
    @ResponseBody
	public AjaxJson queryRole(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		AjaxJson j = new AjaxJson();
		j.setMsg("成功！");
		j.setSuccess(true);
		try{
			UserEntity user = this.systemService.get(UserEntity.class, id);
			String roleId = "";
			for(RoleEntity re:user.getRoles()){
				roleId += (re.getId() + ",");
			}
			if(roleId.length()>0){
				roleId = roleId.substring(0, roleId.length()-1);
			}
			j.setObj(roleId);
		}catch(Exception e){
			j.setMsg("失败！");
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
		DetachedCriteria condition = DetachedCriteria.forClass(UserEntity.class);
		Pagination<?> pagination = systemService.getPageData(condition,Integer.parseInt(page), Integer.parseInt(rows));
		
		JSONObject jobj = new JSONObject();
		jobj.put("total", pagination.getTotalCount());
		jobj.put("rows", pagination.getDatas());

        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jobj.toString());
		
	}
	
}
