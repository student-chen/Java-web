package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.FujianEntity;
import com.svse.entity.InCarEntity;
import com.svse.entity.InCarmxEntity;
import com.svse.entity.InhandoutEntity;
import com.svse.service.FujianService;
import com.svse.service.IncarService;
import com.svse.service.InhandoutService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("fujian.do")
public class FujianControl {

	@Autowired
	private FujianService fserv;

	@Autowired
	private InhandoutService hserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addFujian(FujianEntity fujian) {
		fujian.setZscount(1);
		this.fserv.addFuijian(fujian);
		// 修改数量
		InhandoutEntity inhandout = this.hserv.getOne(fujian.getInhandoutid());
		inhandout.setInhandoutcount(inhandout.getInhandoutcount() - 1);
		this.hserv.upp(inhandout);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject alls(int limit, int offset, int inhandoutid) {
		// 共有多少条
		int count = this.fserv.counts(inhandoutid);
		List<FujianEntity> ar = this.fserv.getAll(offset, limit, inhandoutid);
		JSONObject obj = new JSONObject();
		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}

	// 全查询
	@RequestMapping(params = "method=all1")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.fserv.count();
		List<FujianEntity> ar = this.fserv.getAll(offset, limit);
		JSONObject obj = new JSONObject();
		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}

	// 全查询
	@RequestMapping(params = "method=allfujian")
	@ResponseBody
	public List<FujianEntity> getAll() {
		List<FujianEntity> ar = this.fserv.getAll();
		return ar;
	}

	// 全查询 同一订单下的赠品
	@RequestMapping(params = "method=alls")
	@ResponseBody
	public List<FujianEntity> getAlls(int incarmxid) {
		List<FujianEntity> ar = this.fserv.getAll(incarmxid);
		return ar;
	}

	// 查询
	@RequestMapping(params = "method=one")
	@ResponseBody
	public FujianEntity getOne(int fujianid) {
		FujianEntity ar = this.fserv.getOne(fujianid);
		return ar;
	}

}
