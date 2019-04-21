package com.svse.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.CaroutmxEntity;
import com.svse.entity.InCarEntity;
import com.svse.entity.InCarmxEntity;
import com.svse.entity.MasterEntity;
import com.svse.entity.TzEntity;
import com.svse.service.CaroutmxService;
import com.svse.service.IncarService;
import com.svse.service.IncarmxService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("outcar.do")
public class OutcarmxControl {

	@Autowired
	private CaroutmxService coserv;

	@Autowired
	private IncarmxService cmserv;

	@Autowired
	private IncarService cserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addCaroutmx(CaroutmxEntity caroutmx, HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		Date d = new Date();
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = ff.format(d);
		caroutmx.setCarouttime(time);
		caroutmx.setMid(m.getMid());
		// 修改出售状态
		this.coserv.addCarout(caroutmx);
		InCarmxEntity incarmx = new InCarmxEntity();
		incarmx = this.cmserv.getOne(caroutmx.getIncarmxid());
		incarmx.setCarkucunflag(1);
		this.cmserv.upp(incarmx);
		// 修改数量
		List<InCarmxEntity> ar = this.cmserv.getAll(incarmx.getIncarid());
		int num = 0;
		for (InCarmxEntity ih : ar) {
			num += ih.getCarrukucount();
		}
		InCarEntity h = this.cserv.getOne(incarmx.getIncarid());
		h.setIncarcount(num);
		if (num == 0) {
			h.setIncarflag(0);
		} else {
			h.setIncarflag(1);
		}
		this.cserv.upp(h);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset) {
		// 共有多少条
		int count = this.coserv.count();
		List<CaroutmxEntity> ar = this.coserv.getAll(offset, limit);
		JSONObject obj = new JSONObject();
		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}

	// 报表
	@RequestMapping(params = "method=biao")
	@ResponseBody
	public List biao(String s1, String s2, int sid1, int sid2, String year) {
		//总
		List ar = new ArrayList<>();
		//存月份
		List ar1 = new ArrayList<>();
		
		//品牌1
		List<CaroutmxEntity> ar2 = this.coserv.getBySort(sid1);
		//品牌2
		List<CaroutmxEntity> ar3 = this.coserv.getBySort(sid2);

		// 月份
		for (CaroutmxEntity c : ar2) {
			String time = c.getCarouttime();
			String[] t = time.split("-");
			String mm = t[1];
			String yy = t[0];
			if (yy.equals(year)) {
				ar1.add(mm + "月");
			}
		}
		for (CaroutmxEntity c : ar3) {
			String time = c.getCarouttime();
			String[] t = time.split("-");
			String mm = t[1];
			String yy = t[0];
			if (yy.equals(year)) {
				if (!ar1.contains(mm + "月")) {
					ar1.add(mm + "月");
				}
			}
		}
		// （月份）去重
		List a = new ArrayList<>();
		for (int i = 0; i < ar1.size(); i++) {
			String mm = ar1.get(i).toString();
			if (!a.contains(mm)) {
				a.add(ar1.get(i));
			}
		}
		Collections.sort(a);
		ar1 = a;
		// 横坐标（月份）添加总List
		ar.add(ar1);

		// 生成表(品牌1)
		TzEntity tz1 = new TzEntity();
		tz1.setName(s1);
		List ars = new ArrayList();
		for (int i = 0; i < ar1.size(); i++) {
			String m = ar1.get(i).toString();
			int count = 0;
			for (CaroutmxEntity c : ar2) {
				String time = c.getCarouttime();
				String[] t = time.split("-");
				String mm = t[1];
				String yy = t[0];
				if (yy.equals(year)) {
					if (m.equals(mm + "月")) {
						count += 1;
					}
				}
			}
			ars.add(count);
		}
		tz1.setData(ars);

		// 生成表(品牌2)
		TzEntity tz2 = new TzEntity();
		tz2.setName(s2);
		List ars1 = new ArrayList();
		for (int i = 0; i < ar1.size(); i++) {
			String m = ar1.get(i).toString();
			int count = 0;
			for (CaroutmxEntity c : ar3) {
				String time = c.getCarouttime();
				String[] t = time.split("-");
				String mm = t[1];
				String yy = t[0];
				if (yy.equals(year)) {
					if (m.equals(mm + "月")) {
						count += 1;
					}
				}
			}
			ars1.add(count);
		}
		tz2.setData(ars1);
		//数据
		List arr = new ArrayList();
		arr.add(tz1);
		arr.add(tz2);
		//数据添加总List
		ar.add(arr);
		return ar;
	}

	// 全查询
	@RequestMapping(params = "method=allcaroutmx")
	@ResponseBody
	public List<CaroutmxEntity> getAll() {
		List<CaroutmxEntity> ar = this.coserv.getAll();
		return ar;
	}

	// 查询
	@RequestMapping(params = "method=one")
	@ResponseBody
	public CaroutmxEntity getOne(int incarmxid) {
		CaroutmxEntity ar = this.coserv.getOne(incarmxid);
		return ar;
	}

	// 查询最后一个
	@RequestMapping(params = "method=last")
	@ResponseBody
	public int getOnePurchase() {
		int a = this.coserv.last();
		return a;
	}
}
