package cn.dinner.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.entity.DinnerNotice;
import cn.dinner.service.DinnerNoticeservice;

public class DinnerNoticeAction {
	@Autowired
	private DinnerNoticeservice dinnerNoticeservice;
	
	//查询条件
	private Integer id;
	private JSONArray noticejson;
	/**
	 * 查询小票
	 * @return
	 */
	public String getAlldinnerNoticeByid(){
		List<DinnerNotice> noticeList = dinnerNoticeservice.getAllDinnerNoticeByID(id);
		noticejson = JSONArray.fromObject(noticeList);
		return "success";
	}

	//封装
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JSONArray getNoticejson() {
		return noticejson;
	}

	public void setNoticejson(JSONArray noticejson) {
		this.noticejson = noticejson;
	}

	public DinnerNoticeservice getDinnerNoticeservice() {
		return dinnerNoticeservice;
	}

	public void setDinnerNoticeservice(DinnerNoticeservice dinnerNoticeservice) {
		this.dinnerNoticeservice = dinnerNoticeservice;
	}
	
}
