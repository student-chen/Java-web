package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.ActionsEntity;
import com.svse.service.ActionsService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("action.do")
public class ActionControl {
	@Autowired
	private ActionsService aserv;

	// 全查询
	@RequestMapping(params = "method=allaction")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.aserv.Count();
		// 分页查询
		List<ActionsEntity> ar = this.aserv.getAll(offset,limit);
		
		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}

	@RequestMapping(params = "method=all")
	@ResponseBody
	public List<ActionsEntity> getAll() {
		List<ActionsEntity> ar=this.aserv.getAll();
		return ar;
	}
	
	@RequestMapping(params = "method=allm")
	@ResponseBody
	public List<ActionsEntity> getAll(int moduleid) {
		List<ActionsEntity> ar=this.aserv.getAll(moduleid);
		return ar;
	}

}
