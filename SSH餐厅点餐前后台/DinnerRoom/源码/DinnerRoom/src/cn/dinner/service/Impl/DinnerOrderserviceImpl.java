package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.DinnerOrderDao;
import cn.dinner.entity.DinnerOrder;
import cn.dinner.service.DinnerOrderservice;
import cn.dinner.util.DinnerOrderCond;
import cn.dinner.util.Page;
@Service
@Transactional
public class DinnerOrderserviceImpl implements DinnerOrderservice {

	
	@Autowired
	private DinnerOrderDao dinnerOrderDao;
	
	public DinnerOrderDao getDinnerOrderDao() {
		return dinnerOrderDao;
	}

	public void setDinnerOrderDao(DinnerOrderDao dinnerOrderDao) {
		this.dinnerOrderDao = dinnerOrderDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DinnerOrder> getAllDinnerOrder(Page page, DinnerOrderCond cond) {
		return dinnerOrderDao.getAllDinnerOrder(page, cond);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delOrderInfo(Integer id) {
		return dinnerOrderDao.delOrderInfo(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DinnerOrder> getAllDinnerOrderByhouchu(Page page) {
		return dinnerOrderDao.getAllDinnerOrderByhouchu(page);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateisFull(Integer id) {
		return dinnerOrderDao.UpdateisFull(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int addOrder(DinnerOrder order) {
		return dinnerOrderDao.addOrder(order);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DinnerOrder> getAllDinnerOrderByQT(Page page,
			DinnerOrderCond cond) {
		return dinnerOrderDao.getAllDinnerOrderByQT(page, cond);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int updateOrder(Integer oid, Double price) {
		return dinnerOrderDao.updateOrder(oid, price);
	}

	@Override
	@Transactional(readOnly = true)
	public String homeInfo() {
		return dinnerOrderDao.homeInfo();
	}

}
