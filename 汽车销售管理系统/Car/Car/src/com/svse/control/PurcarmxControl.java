package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.PurcarmxEntity;
import com.svse.service.PurcarmxService;
import com.svse.service.PurchaseService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("purcarmx.do")
public class PurcarmxControl {

	@Autowired
	private PurchaseService pserv;
	@Autowired
	private PurcarmxService pcserv;
 
	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addPurcarmx(PurcarmxEntity purcarmx) {
		this.pcserv.addPurcarmx(purcarmx);
		return 1;
	}


	// 删除
	@RequestMapping(params = "method=del")
	@ResponseBody
	public int delPurcarmx(int purchaseid) {
		this.pcserv.delPurcarmx(purchaseid);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public List<PurcarmxEntity> all(int purchaseid) {
		List<PurcarmxEntity> ar = this.pcserv.getAllPurcarmx(purchaseid);
		return ar;
	}


	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public List<PurcarmxEntity> getOnePurcarmx(int purchaseid) {
		List<PurcarmxEntity> ar = this.pcserv.getOnePurcarmx(purchaseid);
		return ar;
	}

}
