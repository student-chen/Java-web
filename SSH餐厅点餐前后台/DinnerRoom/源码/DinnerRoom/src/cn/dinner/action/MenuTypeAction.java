package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;

import cn.dinner.entity.Menu;
import cn.dinner.entity.MenuType;
import cn.dinner.service.MenuTypeservice;
import cn.dinner.service.Menuservice;
import cn.dinner.util.Page;

public class MenuTypeAction {
	private Menuservice menuservice;
	private MenuTypeservice menuTypeservice;
	private List<MenuType> mtlist;

	/**
	 * 获取数据
	 * 
	 * @return success
	 */
	public String getAlltype(){
		mtlist = menuTypeservice.getAllMenuType();
		return "success";
	}
	
	// 分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject menutypejson;
	/**
	 * 分页获取数据
	 * 
	 * @return success
	 */
	public String getAllMenuType(){
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<MenuType> menuTypeList = menuTypeservice.getAllMenuTypeBypage(pageUtil);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data", menuTypeList);
		JsonConfig config = new JsonConfig();  
		config.setJsonPropertyFilter(new PropertyFilter() {
			                     @Override
			                     public boolean apply(Object arg0, String arg1, Object arg2) {
			                         if (arg1.equals("menuList")) {
			                             return true;
			                        } else {
			                            return false;
			                        }
			                    }
			                });
		menutypejson = JSONObject.fromObject(map,config);
		return "success";
	}
	//添加条件
	private String type_name;
	/*
	 * 添加菜肴类型
	 */
	public void AddMenuType() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int isflag = menuTypeservice.getOneByname(type_name);
		if(isflag==0){
			MenuType mt = new MenuType();
			mt.setTypeName(type_name);
			int res = menuTypeservice.addMenuType(mt);
			out.print(res);
		}else{
			out.print(-1);
		}
		
	}
	//删除条件
	private Integer delid;
	/**
	 * 删除方法
	 * @return
	 * @throws IOException 
	 */
	public void delMenuType() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		List<Menu> menuList = menuservice.getMenuByTypeId(delid);
		if(menuList.size()==0){
			int res = menuTypeservice.delMenuType(delid);
			out.print(res);
		}else{
			out.print(-1);
		}
		
	}
	//封装
	public MenuTypeservice getMenuTypeservice() {
		return menuTypeservice;
	}
	public void setMenuTypeservice(MenuTypeservice menuTypeservice) {
		this.menuTypeservice = menuTypeservice;
	}
	public List<MenuType> getMtlist() {
		return mtlist;
	}
	public void setMtlist(List<MenuType> mtlist) {
		this.mtlist = mtlist;
	}
	public Page getPageUtil() {
		return pageUtil;
	}
	public void setPageUtil(Page pageUtil) {
		this.pageUtil = pageUtil;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public JSONObject getMenutypejson() {
		return menutypejson;
	}
	public void setMenutypejson(JSONObject menutypejson) {
		this.menutypejson = menutypejson;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public Integer getDelid() {
		return delid;
	}
	public void setDelid(Integer delid) {
		this.delid = delid;
	}
	public Menuservice getMenuservice() {
		return menuservice;
	}
	public void setMenuservice(Menuservice menuservice) {
		this.menuservice = menuservice;
	}
	
}
