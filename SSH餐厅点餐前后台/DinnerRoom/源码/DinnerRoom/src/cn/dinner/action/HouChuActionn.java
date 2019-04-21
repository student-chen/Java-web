package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.entity.DinnerOrder;
import cn.dinner.service.DinnerOrderservice;
import cn.dinner.util.Page;

public class HouChuActionn {
	@Autowired
	private DinnerOrderservice dinnerOrderservice;
	// 分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject houchujson;

	public String houchu() {
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<DinnerOrder> orderlist = dinnerOrderservice.getAllDinnerOrderByhouchu(pageUtil);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data",orderlist);
		houchujson = JSONObject.fromObject(map);
		return "success";
	}
	//修改id
	private Integer updateid;
	/**
	 * 后厨上菜齐全事件
	 * @return
	 * @throws IOException 
	 */
	public void updateisFull() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = dinnerOrderservice.UpdateisFull(updateid);
		if(res>0){
			out.print(1);
		}else{
			out.print(-1);
		}
	}

	// 封装
	public DinnerOrderservice getDinnerOrderservice() {
		return dinnerOrderservice;
	}

	public void setDinnerOrderservice(DinnerOrderservice dinnerOrderservice) {
		this.dinnerOrderservice = dinnerOrderservice;
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

	public JSONObject getHouchujson() {
		return houchujson;
	}

	public void setHouchujson(JSONObject houchujson) {
		this.houchujson = houchujson;
	}

	public Integer getUpdateid() {
		return updateid;
	}

	public void setUpdateid(Integer updateid) {
		this.updateid = updateid;
	}

}
