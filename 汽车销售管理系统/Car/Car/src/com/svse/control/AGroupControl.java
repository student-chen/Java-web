package com.svse.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.AGroupEntity;
import com.svse.service.AGroupService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("aGroup.do")
public class AGroupControl {

	@Autowired
	private AGroupService agserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addsort(AGroupEntity AGroup) {
		this.agserv.addAGroup(AGroup);
		return 1;
	}

	// 添加
	@RequestMapping(params = "method=del")
	@ResponseBody
	public int delsort(int actiongroupid) {
		this.agserv.delAGroup(actiongroupid);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppsort(AGroupEntity AGroup) {
		this.agserv.uppAGroup(AGroup);
		return 1;
	}

	@RequestMapping(params = "method=alls")
	@ResponseBody
	public List<AGroupEntity> getAll() {
		List<AGroupEntity> ar = this.agserv.getAll();
		return ar;
	}

	@RequestMapping(params = "method=allmg")
	@ResponseBody
	public int getAllmg(int actionid, int groupid) {
		AGroupEntity a = new AGroupEntity();
		a = this.agserv.getAllByMid(actionid, groupid);
		if (a != null) {
			return a.getActiongroupid();
		} else {
			return 0;
		}
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.agserv.Count();
		// 分页查询
		
		List<AGroupEntity> ar = this.agserv.getAll(offset, limit);
		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);

		return obj;
	}

}
