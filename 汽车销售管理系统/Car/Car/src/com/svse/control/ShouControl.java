package com.svse.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.CardetailEntity;
import com.svse.entity.MasterEntity;
import com.svse.entity.ShouEntity;
import com.svse.service.ShouhouService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("shou.do")
public class ShouControl {

	@Autowired
	private ShouhouService cserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addShou(ShouEntity shou) {
		this.cserv.add(shou);
		return 1;
	}

	// 修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppShou(ShouEntity shou) {
		ShouEntity s = this.cserv.getOne(shou.getShouhouid());
		this.cserv.upp(s);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset, HttpSession session, int gid) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		JSONObject obj = new JSONObject();
		if (gid == 1) {
			// 共有多少条
			int count = this.cserv.counts();
			List<ShouEntity> ar = this.cserv.getAlls(offset, limit);
			obj.put("rows", ar);
			obj.put("total", count);
		} else {
			// 共有多少条
			int count = this.cserv.count(m.getMid());
			List<ShouEntity> ar = this.cserv.getAll(offset, limit, m.getMid());
			obj.put("rows", ar);
			obj.put("total", count);
		}

		return obj;
	}

	@RequestMapping(params = "method=allShou")
	@ResponseBody
	public List<ShouEntity> getAll() {
		List<ShouEntity> ar = this.cserv.getAll();
		return ar;
	}

	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public ShouEntity getOneShou(int shouhouid) {
		ShouEntity shou = this.cserv.getOne(shouhouid);
		return shou;
	}

}
