package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.CaroutmxDAOI;
import com.svse.entity.CaroutmxEntity;
import com.svse.service.CaroutmxService;
@Service
public class CaroutmxImpl implements CaroutmxService {
	@Autowired
	private CaroutmxDAOI daoi;
	
	
	@Override
	public void addCarout(CaroutmxEntity carout) {
		
		this.daoi.add(carout);
	}

	@Override
	public void uppCarout(CaroutmxEntity carout) {
		
		this.daoi.upp(carout);
	}

	@Override
	public List<CaroutmxEntity> getAll() {
		
		return this.daoi.allcarout();
	}

	@Override
	public List<CaroutmxEntity> getAll(int offset, int limit) {
		
		return this.daoi.all(offset, limit);
	}

	@Override
	public CaroutmxEntity getOne(int incarmxid) {
		
		return this.daoi.one(incarmxid);
	}

	@Override
	public int count() {
		
		return this.daoi.count();
	}

	@Override
	public int last() {

		return this.daoi.last();
	}

	@Override
	public List<CaroutmxEntity> getBySort(int sortid) {
		
		return this.daoi.getBySort(sortid);
	}

}
