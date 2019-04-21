package com.svse.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.ActionsEntity;
import com.svse.entity.CustomEntity;
import com.svse.entity.MasterEntity;
import com.svse.service.CustomService;
import com.svse.util.MyPages;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("custom.do")
public class CustomControl {

	@Autowired
	private CustomService cserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addcustom(CustomEntity custom, HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		custom.setMid(m.getMid());
		this.cserv.addCustom(custom);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.cserv.count();
		// 分页查询
		List<CustomEntity> ar = this.cserv.getAll(offset, limit);

		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);

		return obj;
	}

	// 全查询
	@RequestMapping(params = "method=limit1")
	@ResponseBody
	public JSONObject limit1(int limit, int offset, int pid) {
		// 共有多少条
		int count = this.cserv.count1(pid);
		// 分页查询
		List<CustomEntity> ar = this.cserv.getLimit1(offset, limit, pid);

		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);

		return obj;
	}

	// 全查询
	@RequestMapping(params = "method=limit2")
	@ResponseBody
	public JSONObject limit2(int limit, int offset, int mid) {
		// 共有多少条
		int count = this.cserv.count2(mid);
		// 分页查询
		List<CustomEntity> ar = this.cserv.getLimit2(offset, limit, mid);

		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);

		return obj;
	}

	@RequestMapping(params = "method=allcustom")
	@ResponseBody
	public List<CustomEntity> getAll(HttpSession session,int gid) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		List<CustomEntity> ar;
		if(gid==1){
			ar = this.cserv.getAll();
		}else{
			ar = this.cserv.getAlls(m.getMid());
		}
		return ar;
	}
	
	@RequestMapping(params = "method=limitcustom")
	@ResponseBody
	public List<CustomEntity> getAll(int mid) {
		List<CustomEntity> ar = this.cserv.getAll(mid);
		return ar;
	}

	// 判断重复
	@RequestMapping(params = "method=repeat")
	@ResponseBody
	public int repeat(String customtel) {
		CustomEntity custom = new CustomEntity();
		custom.setCustomtel(customtel);
		int t = this.cserv.repeat(custom);
		if (t > 0) {
			// 重复
			return 1;
		} else {
			return 2;
		}
	}

}
