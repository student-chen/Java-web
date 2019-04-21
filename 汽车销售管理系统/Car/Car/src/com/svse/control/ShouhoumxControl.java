package com.svse.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.MasterEntity;
import com.svse.entity.ShoumxEntity;
import com.svse.service.ShouhouService;
import com.svse.service.ShoumxService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("shoumx.do")
public class ShouhoumxControl {

	@Autowired
	private ShoumxService smserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int add(ShoumxEntity shoumx, HttpSession session) {
		//经办人
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		shoumx.setMid(m.getMid());
		//是否收费
		this.smserv.add(shoumx);
		return 1;
	}

	// 修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int upp(ShoumxEntity shoumx, HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		shoumx.setMid(m.getMid());
		ShoumxEntity shou=this.smserv.getOne(shoumx.getShouhoumxid());
		shoumx.setShouhouid(shou.getShouhouid());
		this.smserv.upp(shoumx);
		return 1;
	}
	// 全查询
	@RequestMapping(params = "method=alls")
	@ResponseBody
	public List<ShoumxEntity> alls() {
		// 共有多少条
		List<ShoumxEntity> ar = this.smserv.getAll();
		return ar;
	}
	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public ShoumxEntity one(int shouhoumxid) {
		ShoumxEntity shou=this.smserv.getOne(shouhoumxid);
		return shou;
	}
	// 分页查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset, int shouhouid) {
		// 共有多少条
		int count = this.smserv.count(shouhouid);
		List<ShoumxEntity> ar = this.smserv.getAll(offset, limit, shouhouid);
		JSONObject obj = new JSONObject();
		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}
}
