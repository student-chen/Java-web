package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.dinner.entity.DiningTable;
import cn.dinner.service.DiningTableservice;
import cn.dinner.util.Page;
import net.sf.json.JSONObject;

public class DiningTableAction {
	
	private DiningTableservice diningTableservice;
	
	//分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject diningTablejson;
	/**
	 * 分页获取餐桌信息
	 * @return
	 */
	public String getAllTable(){
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<DiningTable> tlist = diningTableservice.getdiningTableByPage(pageUtil);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data", tlist);
		diningTablejson = JSONObject.fromObject(map);
		return "success";
	}

	//删除条件
	private Integer delid;
	/**
	 * 删除餐桌
	 * @return
	 * @throws IOException 
	 */
	public void delDinnerTable() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = diningTableservice.delDiningTable(delid);
		out.print(res);
	}
	//修改条件
	private Integer upid;
	private DiningTable diningTable;
	private String tablenum;
	private Integer tablePernum;
	/**
	 * 获取修改信息
	 * @return
	 */
	public String getTableUpdateInfo(){
		diningTable = diningTableservice.getOneTable(upid);
		return "success";
	}
	/**
	 * 修改餐桌信息
	 * @return
	 * @throws IOException 
	 */
	public void UpdateTable() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		DiningTable dt = new DiningTable(upid,tablenum,tablePernum,0);
		int res = diningTableservice.UpdateDiningTable(dt);
		if(res>0){
			out.print("<script>alert('修改成功');location.href='canzhuo.jsp';</script>");
		}else{
			out.print("<script>alert('修改失败');location.href='getTableUpInfo?upid="+upid+"';</script>");
		}
	}
	/**
	 * 添加餐桌
	 * @return
	 * @throws IOException 
	 */
	public void addTable() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int flag = diningTableservice.flagTableNum(tablenum);
		if(flag==0){
			DiningTable dt = new DiningTable(tablenum,tablePernum,0);
			int res = diningTableservice.addDiningTable(dt);
			out.print(res);
		}else{
			out.print(-1);
		}
	}
	//封装
	public DiningTableservice getDiningTableservice() {
		return diningTableservice;
	}

	public void setDiningTableservice(DiningTableservice diningTableservice) {
		this.diningTableservice = diningTableservice;
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

	public DiningTable getDiningTable() {
		return diningTable;
	}
	public void setDiningTable(DiningTable diningTable) {
		this.diningTable = diningTable;
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

	public JSONObject getDiningTablejson() {
		return diningTablejson;
	}

	public void setDiningTablejson(JSONObject diningTablejson) {
		this.diningTablejson = diningTablejson;
	}
	public Integer getDelid() {
		return delid;
	}
	public void setDelid(Integer delid) {
		this.delid = delid;
	}

	public Integer getUpid() {
		return upid;
	}

	public void setUpid(Integer upid) {
		this.upid = upid;
	}
	public String getTablenum() {
		return tablenum;
	}
	public void setTablenum(String tablenum) {
		this.tablenum = tablenum;
	}
	public Integer getTablePernum() {
		return tablePernum;
	}
	public void setTablePernum(Integer tablePernum) {
		this.tablePernum = tablePernum;
	}
	
}
