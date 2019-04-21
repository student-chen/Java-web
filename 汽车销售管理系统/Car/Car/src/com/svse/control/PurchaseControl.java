package com.svse.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.MasterEntity;
import com.svse.entity.PurchaseEntity;
import com.svse.service.MasterService;
import com.svse.service.PurchaseService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("purchase.do")
public class PurchaseControl {

	@Autowired
	private MasterService mserv;
	@Autowired
	private PurchaseService pserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addPurchase(PurchaseEntity purchase, HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		purchase.setMid(m.getMid());
		purchase.setPmoney(0);
		Date d = new Date();
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = ff.format(d);
		purchase.setPtime(time);
		purchase.setPurchaseflag(0);
		MasterEntity ms = this.mserv.getOneByPid();
		purchase.setSugid(ms.getMid());
		purchase.setSuggestion("--");
		this.pserv.addPurchase(purchase);
		return 1;
	}

	// 修改
	@RequestMapping(params = "method=examine")
	@ResponseBody
	public int check(HttpSession session) {
		MasterEntity ms = this.mserv.getOneByPid();
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		if (m.getMid() == ms.getMid()) {
			return 1;
		} else {
			return 0;
		}
	}

	// 修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppPurchase(PurchaseEntity purchase) {
		PurchaseEntity p = this.pserv.getOnePurchase(purchase.getPurchaseid());
		p.setPmoney(purchase.getPmoney());
		this.pserv.uppPurchase(p);
		return 1;
	}

	// 修改
	@RequestMapping(params = "method=upps")
	@ResponseBody
	public int uppPurchases(PurchaseEntity purchase) {
		PurchaseEntity p = this.pserv.getOnePurchase(purchase.getPurchaseid());
		p.setPurchaseflag(purchase.getPurchaseflag());
		this.pserv.uppPurchase(p);
		return 1;
	}

	// 修改
	@RequestMapping(params = "method=uppss")
	@ResponseBody
	public int uppPurchasess(PurchaseEntity purchase) {
		PurchaseEntity p = this.pserv.getOnePurchase(purchase.getPurchaseid());
		p.setPurchaseflag(purchase.getPurchaseflag());
		p.setSuggestion(purchase.getSuggestion());
		this.pserv.uppPurchase(p);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset, int purchaseflag, int mid) {
		// 共有多少条
		int count = 0;
		List<PurchaseEntity> ar = new ArrayList<PurchaseEntity>();
		if (purchaseflag == 5) {
			MasterEntity ms = this.mserv.getOneByPid();
			if(ms.getMid()==mid){
				ar = this.pserv.getAlls(offset, limit, mid);
				count=this.pserv.Count3(mid);
			}else{
				ar = this.pserv.getAllPurchase(offset, limit, mid);
				count=this.pserv.Count(mid);
			}
		} else {
			if (purchaseflag == 2) {
				ar = this.pserv.getAll(offset, limit, mid);
				count=this.pserv.Count1(mid);
			} else {
				ar = this.pserv.getAll(offset, limit, purchaseflag, mid);
				count=this.pserv.Count2(purchaseflag,mid);
			}
		}
		JSONObject obj = new JSONObject();

		obj.put("rows", ar);
		obj.put("total", count);

		return obj;
	}

	@RequestMapping(params = "method=allPurchase")
	@ResponseBody
	public List<PurchaseEntity> getAll() {
		List<PurchaseEntity> ar = this.pserv.getAllPurchase();
		return ar;
	}

	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public PurchaseEntity getOnePurchase(int purchaseid) {
		PurchaseEntity Purchase = this.pserv.getOnePurchase(purchaseid);
		return Purchase;
	}

	// 查询最后一个
	@RequestMapping(params = "method=last")
	@ResponseBody
	public int getOnePurchase() {
		int a = this.pserv.getOnePurchase();
		return a;
	}

	// 查询消息
	@RequestMapping(params = "method=allcount")
	@ResponseBody
	public int getCount(HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		int a = this.pserv.getCount(m.getMid());
		return a;
	}
}
