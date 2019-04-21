package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.CarsortDAOI;
import com.svse.entity.CarsortEntity;
import com.svse.service.CarsortService;

@Service
public class CarsortImpl implements CarsortService{
	
	@Autowired
	private CarsortDAOI daoi;
	@Override
	public void addCarsort(CarsortEntity carsort) {
		
		this.daoi.add(carsort);
	}

	@Override
	public void uppCarsort(CarsortEntity carsort) {
		
		this.daoi.upp(carsort);
	}

	@Override
	public List<CarsortEntity> getAllCarsort() {
		
		return this.daoi.all();
	}

	@Override
	public List<CarsortEntity> getAllCarsort(int begin, int pages) {
		List<CarsortEntity> ar=this.daoi.allsort(begin, pages);
				for (CarsortEntity c : ar) {
					if(c.getSortflag()==1){
						c.setFlag("Õý³£");
					}else{
						c.setFlag("Í£²ú");
					}
				}
		return ar;
	}

	@Override
	public CarsortEntity getOneCarsort(int sortid) {
		
		return this.daoi.one(sortid);
	}

	@Override
	public int repeat(CarsortEntity carsort) {
		
		return this.daoi.repeat(carsort);
	}

	@Override
	public int Count() {
		
		return this.daoi.count();
	}

	
}
