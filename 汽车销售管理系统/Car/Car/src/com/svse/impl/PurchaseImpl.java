package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.PurchaseDAOI;
import com.svse.entity.PurchaseEntity;
import com.svse.service.PurchaseService;
@Service
public class PurchaseImpl implements PurchaseService {
	
	@Autowired
	private PurchaseDAOI daoi;
	
	public void addPurchase(PurchaseEntity purchase) {
		
		this.daoi.add(purchase);
	}

	
	public void uppPurchase(PurchaseEntity purchase) {
		
		this.daoi.upp(purchase);
	}

	
	public List<PurchaseEntity> getAllPurchase(int begin, int pages, int mid) {
		List<PurchaseEntity> ar=this.daoi.allpurchase(begin, pages,mid);
		for (PurchaseEntity p : ar) {
			int ff=p.getPurchaseflag();
			if(ff==0){
				p.setFlag("审批未发送");
			}else if(ff==1){
				p.setFlag("审批之中");
			}else if(ff==2){
				p.setFlag("审批未通过");
			}else if(ff==3){
				p.setFlag("审批已通过");
			}else if(ff==4){
				p.setFlag("审批未通过");
			}
		}
		return ar;
	}

	
	public List<PurchaseEntity> getAllPurchase() {
		
		return this.daoi.all();
	}

	
	public PurchaseEntity getOnePurchase(int purchaseid) {
		
		return this.daoi.one(purchaseid);
	}

	


	@Override
	public List<PurchaseEntity> getAll(int offset, int limit, int purchaseflag,int mid) {
		List<PurchaseEntity> ar=this.daoi.all2(offset, limit, purchaseflag,mid);
		for (PurchaseEntity p : ar) {
			int ff=p.getPurchaseflag();
			if(ff==0){
				p.setFlag("审批未发送");
			}else if(ff==1){
				p.setFlag("审批之中");
			}else if(ff==2){
				p.setFlag("审批未通过");
			}else if(ff==3){
				p.setFlag("审批已通过");
			}else if(ff==4){
				p.setFlag("审批未通过");
			}
		}
		return ar;
	}


	@Override
	public List<PurchaseEntity> getAll(int offset, int limit, int mid) {
		List<PurchaseEntity> ar=this.daoi.all1(offset, limit,mid);
		for (PurchaseEntity p : ar) {
			int ff=p.getPurchaseflag();
			if(ff==0){
				p.setFlag("审批未发送");
			}else if(ff==1){
				p.setFlag("审批之中");
			}else if(ff==2){
				p.setFlag("审批未通过");
			}else if(ff==3){
				p.setFlag("审批已通过");
			}else if(ff==4){
				p.setFlag("审批未通过");
			}
		}
		return ar;
	}


	@Override
	public int getOnePurchase() {

		return this.daoi.last();
	}


	@Override
	public int getCount(int mid) {

		return this.daoi.getcount(mid);
	}


	@Override
	public List<PurchaseEntity> getAlls(int offset, int limit, int mid) {

		List<PurchaseEntity> ar=this.daoi.all3(offset, limit,mid);
		for (PurchaseEntity p : ar) {
			int ff=p.getPurchaseflag();
			if(ff==0){
				p.setFlag("审批未发送");
			}else if(ff==1){
				p.setFlag("审批之中");
			}else if(ff==2){
				p.setFlag("审批未通过");
			}else if(ff==3){
				p.setFlag("审批已通过");
			}else if(ff==4){
				p.setFlag("审批未通过");
			}
		}
		return ar;
	}


	@Override
	public int Count(int mid) {
		
		return this.daoi.count(mid);
	}


	@Override
	public int Count1(int mid) {
		
		return this.daoi.count1(mid);
	}


	@Override
	public int Count2(int purchaseflag, int mid) {
		
		return this.daoi.count2(purchaseflag, mid);
	}


	@Override
	public int Count3(int mid) {
		
		return this.daoi.count3(mid);
	}

}
