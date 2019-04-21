package com.svse.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.MasterAEntity;
import com.svse.service.MasterAService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("mastera.do")
public class MasterAControl {

	@Autowired
	private MasterAService maserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addsort(MasterAEntity MasterA) {
		this.maserv.addMasterA(MasterA);
		return 1;
	}

	// 添加
	@RequestMapping(params = "method=del")
	@ResponseBody
	public int delsort(int actiongroupid) {
		this.maserv.delMasterA(actiongroupid);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppsort(MasterAEntity MasterA) {
		this.maserv.uppMasterA(MasterA);
		return 1;
	}

	@RequestMapping(params = "method=alls")
	@ResponseBody
	public List<MasterAEntity> getAll() {
		List<MasterAEntity> ar = this.maserv.getAll();
		return ar;
	}

	@RequestMapping(params = "method=allmg")
	@ResponseBody
	public int getAllmg(int mid, int groupid) {
		MasterAEntity a = new MasterAEntity();
		a = this.maserv.getAllByMid(mid, groupid);
		if (a != null) {
			return a.getMgroupid();
		} else {
			return 0;
		}
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.maserv.Count();
		// 分页查询
		
		List<MasterAEntity> ar = this.maserv.getAll(offset, limit);
		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);

		return obj;
	}

}
