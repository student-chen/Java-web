package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.CardetailDAOI;
import com.svse.entity.CardetailEntity;
import com.svse.service.CardetailService;

@Service
public class CardetailImpl implements CardetailService{
	
	@Autowired
	private CardetailDAOI daoi;
	@Override
	public void addCardetail(CardetailEntity cardetail) {
		
		this.daoi.add(cardetail);
	}

	@Override
	public void uppCardetail(CardetailEntity cardetail) {
		
		this.daoi.upp(cardetail);
	}


	@Override
	public List<CardetailEntity> getAllCardetail(int begin, int pages) {
		List<CardetailEntity> ar=this.daoi.alldetail(begin, pages);
		for (CardetailEntity d : ar) {
			if(d.getDetailflag()==1){
				d.setFlag("Õý³£");
			}else{
				d.setFlag("Í£²ú");
			}
		}
		return ar;
	}

	@Override
	public CardetailEntity getOneCardetail(int detailid) {
		
		return this.daoi.one(detailid);
	}


	@Override
	public int Count() {
		
		return this.daoi.count();
	}

	@Override
	public List<CardetailEntity> getAllCardetail() {

		return this.daoi.all();
	}

	@Override
	public List<CardetailEntity> getAllBySort(int sortid) {

		return this.daoi.allbysort(sortid);
	}

	
}
