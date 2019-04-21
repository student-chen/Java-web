package com.svse.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.CardetailEntity;
import com.svse.entity.CarsortEntity;
import com.svse.service.CardetailService;
import com.svse.service.CarsortService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("cardetail.do")
public class CardetailControl {

	@Autowired
	private CardetailService cdserv;
	@Autowired
	private CarsortService sserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addsort(CardetailEntity detail) {
		this.cdserv.addCardetail(detail);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppsort(CardetailEntity detail) {
		this.cdserv.uppCardetail(detail);
		return 1;
	}


	// 全查询
	@RequestMapping(params="method=all")
	@ResponseBody
	public JSONObject all(int limit,int offset)
	{
		//共有多少条
		int count=this.cdserv.Count();
		//分页查询
		List<CardetailEntity> ar=this.cdserv.getAllCardetail(offset, limit);
		
		JSONObject obj=new JSONObject();
		
		obj.put("rows", ar);
		obj.put("total", count);
		
		return obj;
	}
	//全查询
	@RequestMapping(params="method=alls")
	@ResponseBody
	public List<CardetailEntity> all()
	{
		List<CardetailEntity> ar=this.cdserv.getAllCardetail();
		return ar;
	}
	
	//根据品牌查询系列
	@RequestMapping(params="method=allsort")
	@ResponseBody
	public List<CardetailEntity> all(int sortid)
	{
		List<CardetailEntity> ar=this.cdserv.getAllBySort(sortid);
//		if(ar.size()==0){
//			CardetailEntity car=new CardetailEntity();
//			car.setDetailid(0);
//			car.setDetailname("--该品牌下无产品--");
//			car.setDetailguige("");
//			ar.add(car);
//		}
		return ar;
	}
	
	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public List getOnesort(int detailid) {
		List ar = new ArrayList();
		CardetailEntity detail = this.cdserv.getOneCardetail(detailid);
		detail.setSortid(detail.getSort().getSortid());
		List<CarsortEntity> ars=this.sserv.getAllCarsort();
		ar.add(detail);
		for (CarsortEntity c : ars) {
			ar.add(c);
		}
		return ar;
	}


}
