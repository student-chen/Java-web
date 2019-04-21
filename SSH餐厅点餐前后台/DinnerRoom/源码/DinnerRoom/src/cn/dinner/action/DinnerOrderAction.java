package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.entity.DinnerOrder;
import cn.dinner.service.DinnerNoticeservice;
import cn.dinner.service.DinnerOrderservice;
import cn.dinner.util.DinnerOrderCond;
import cn.dinner.util.Page;

public class DinnerOrderAction {

	@Autowired
	private DinnerOrderservice dinnerOrderservice;
	@Autowired
	private DinnerNoticeservice dinnerNoticeservice;

	// 分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject orderjson;
	//查询条件
	private Integer id;
	private Date startTime;
	private Date endTime;
	/**
	 * 多条件分页查询订单信息
	 * @return
	 */
	public String getAllOrderInfo(){
		DinnerOrderCond cond = new DinnerOrderCond();
		if(id!=null){
			cond.setId(id);
		}
		if(startTime!=null && !startTime.equals("")){
			cond.setStartTime(startTime);
		}
		if(endTime!=null && !endTime.equals("")){
			cond.setEndTime(endTime);
		}
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<DinnerOrder> orderlist = dinnerOrderservice.getAllDinnerOrder(pageUtil, cond);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data",orderlist);
		orderjson = JSONObject.fromObject(map);
		return "success";
	}
	
	//删除条件
	private Integer delid;
	/**
	 * 删除订单信息
	 * @return
	 * @throws IOException 
	 */
	public void delOrderInfo() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int resNotice = dinnerNoticeservice.delNotice(delid);
		if(resNotice>0){
			int resOrder = dinnerOrderservice.delOrderInfo(delid);
			if(resOrder>0){
				out.print(1);
			}else{
				out.print(-1);
			}
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

	public JSONObject getOrderjson() {
		return orderjson;
	}

	public void setOrderjson(JSONObject orderjson) {
		this.orderjson = orderjson;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getDelid() {
		return delid;
	}

	public void setDelid(Integer delid) {
		this.delid = delid;
	}

	public DinnerNoticeservice getDinnerNoticeservice() {
		return dinnerNoticeservice;
	}

	public void setDinnerNoticeservice(DinnerNoticeservice dinnerNoticeservice) {
		this.dinnerNoticeservice = dinnerNoticeservice;
	}

}
