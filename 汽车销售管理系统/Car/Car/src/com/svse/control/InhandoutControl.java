package com.svse.control;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.HandoutEntity;
import com.svse.entity.InhandoutEntity;
import com.svse.service.InhandoutService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("inhandout.do")
public class InhandoutControl {

	@Autowired
	private InhandoutService ihserv;
	

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addInhandout(InhandoutEntity Inhandout) {
		Inhandout.setInhandoutcount(0);
		Inhandout.setInhandoutflag(0);
		this.ihserv.add(Inhandout);
		return 1;
	}


	// 修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppInhandout(InhandoutEntity Inhandout) {
		InhandoutEntity ih = this.ihserv.getOne(Inhandout.getInhandoutid());
		ih.setInhandoutcount(Inhandout.getInhandoutcount());
		ih.setInhandoutflag(1);
		this.ihserv.upp(ih);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.ihserv.count();
		List<InhandoutEntity> ar = this.ihserv.getAll(offset, limit);
		JSONObject obj = new JSONObject();
		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}
	//查询所有入库的赠品
	@RequestMapping(params = "method=allinhandout")
	@ResponseBody
	public List<InhandoutEntity> getAll() {
		List<InhandoutEntity> ar = this.ihserv.getAll();
		return ar;
	}
	//查询有库存的赠品
	@RequestMapping(params = "method=alls")
	@ResponseBody
	public List<InhandoutEntity> getAlls() {
		List<InhandoutEntity> ar = this.ihserv.getAlls();
		return ar;
	}

	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public InhandoutEntity getOneInhandout(int inhandoutid) {
		InhandoutEntity Inhandout = this.ihserv.getOne(inhandoutid);
		return Inhandout;
	}
	
	//查询赠品
	@RequestMapping(params = "method=allh")
	@ResponseBody
	public List<HandoutEntity> getAllh() {
		List<HandoutEntity> ar=this.ihserv.allh();
		return ar;
	}
	
	//得到ID
	@RequestMapping(params = "method=last")
	@ResponseBody
	public int getId() {
		int a=this.ihserv.getID();
		return a;
	}
}
