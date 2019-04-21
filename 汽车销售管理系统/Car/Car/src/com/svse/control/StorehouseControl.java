package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.StorehouseEntity;
import com.svse.service.StorehouseService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("storehouse.do")
public class StorehouseControl {

	@Autowired
	private StorehouseService shserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addsort(StorehouseEntity storehouse) {
		this.shserv.addStorehouse(storehouse);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppsort(StorehouseEntity store) {
		this.shserv.uppStorehouse(store);
		return 1;
	}


	// 全查询
	@RequestMapping(params="method=all")
	@ResponseBody
	public JSONObject all(int limit,int offset)
	{	
		//共有多少条
		int count=this.shserv.Count();
		//分页查询
		List<StorehouseEntity> ar=this.shserv.getAllStorehouse(offset, limit);
		
		JSONObject obj=new JSONObject();
		
		obj.put("rows", ar);
		obj.put("total", count);
		
		return obj;
	}
	
	@RequestMapping(params="method=alls")
	@ResponseBody
	public List<StorehouseEntity> all()
	{	
		List<StorehouseEntity> ar=this.shserv.getAllStorehouse();
		
		
		return ar;
	}

	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public StorehouseEntity getOnesort(int storeid) {
		StorehouseEntity store = this.shserv.getOneStorehouse(storeid);
		return store;
	}

	// 判断重复
	@RequestMapping(params = "method=repeat")
	@ResponseBody
	public int repeat(String name,String old) {
		StorehouseEntity store = new StorehouseEntity();
		store.setStorename(name);
		int t = this.shserv.repeat(store);
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
