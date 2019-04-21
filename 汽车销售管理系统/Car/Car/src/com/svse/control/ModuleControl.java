package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.dao.ModuleDAOI;
import com.svse.entity.ModuleEntity;
import com.svse.service.ModuleService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("module.do")
public class ModuleControl {
	@Autowired
	private ModuleService mserv;

	// 全查询
	@RequestMapping(params = "method=allmodule")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.mserv.Count();
		// 分页查询
		List<ModuleEntity> ar = this.mserv.getAllModule(offset,limit);
		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);

		return obj;
	}

	@RequestMapping(params = "method=all")
	@ResponseBody
	public List<ModuleEntity> getAll() {
		return this.mserv.getAllModule();
	}

}
