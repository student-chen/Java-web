package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.HandoutEntity;
import com.svse.service.HandoutService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("handout.do")
public class HandoutControl {

	@Autowired
	private HandoutService hserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addsort(HandoutEntity handout) {
		this.hserv.addHandout(handout);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppsort(HandoutEntity handout) {
		this.hserv.uppHandout(handout);
		return 1;
	}


	// 全查询
	@RequestMapping(params="method=all")
	@ResponseBody
	public JSONObject all(int limit,int offset)
	{
		//共有多少条
		int count=this.hserv.Count();
		//分页查询
		List<HandoutEntity> ar=this.hserv.getAllHandout(offset, limit);
		
		JSONObject obj=new JSONObject();
		
		obj.put("rows", ar);
		obj.put("total", count);
		
		return obj;
	}


	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public HandoutEntity getOnesort(int handoutid) {
		HandoutEntity handout = this.hserv.getOneHandout(handoutid);
		return handout;
	}

	// 判断重复
	@RequestMapping(params = "method=repeat")
	@ResponseBody
	public int repeat(String name,String old) {
		HandoutEntity handout = new HandoutEntity();
		handout.setHandoutname(name);
		int t = this.hserv.repeat(handout);
		if (t > 0) {
			if(old!=null && old.equalsIgnoreCase(name)){
				return 2;
			}else{
				// 重复
				return 1;
			}
		} else {
			return 2;
		}
	}

}
