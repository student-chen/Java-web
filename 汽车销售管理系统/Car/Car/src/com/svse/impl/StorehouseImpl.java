package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.StorehouseDAOI;
import com.svse.entity.CarsortEntity;
import com.svse.entity.StorehouseEntity;
import com.svse.service.StorehouseService;

@Service
public class StorehouseImpl implements StorehouseService{
	
	@Autowired
	private StorehouseDAOI daoi;
	@Override
	public void addStorehouse(StorehouseEntity storehouse) {
		
		this.daoi.add(storehouse);
	}

	@Override
	public void uppStorehouse(StorehouseEntity storehouse) {
		
		this.daoi.upp(storehouse);
	}

	@Override
	public List<StorehouseEntity> getAllStorehouse() {
		
		return this.daoi.all();
	}

	@Override
	public List<StorehouseEntity> getAllStorehouse(int begin, int pages) {
		List<StorehouseEntity> ar=this.daoi.allstore(begin, pages);
		for (StorehouseEntity c : ar) {
			if(c.getStoreflag()==1){
				c.setFlag("Õý³£");
			}else{
				c.setFlag("Í£²ú");
			}
		}
		return ar;
	}

	@Override
	public StorehouseEntity getOneStorehouse(int detailid) {
		
		return this.daoi.one(detailid);
	}

	@Override
	public int repeat(StorehouseEntity Storehouse) {
		
		return this.daoi.repeat(Storehouse);
	}

	@Override
	public int Count() {
		
		return this.daoi.count();
	}

	
}
