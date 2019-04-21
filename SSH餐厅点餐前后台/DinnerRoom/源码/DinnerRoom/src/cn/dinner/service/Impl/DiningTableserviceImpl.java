package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.DiningTableDao;
import cn.dinner.entity.DiningTable;
import cn.dinner.service.DiningTableservice;
import cn.dinner.util.Page;
@Service
@Transactional
public class DiningTableserviceImpl implements DiningTableservice {
	@Autowired
	private DiningTableDao diningTableDao;
	
	public DiningTableDao getDiningTableDao() {
		return diningTableDao;
	}

	public void setDiningTableDao(DiningTableDao diningTableDao) {
		this.diningTableDao = diningTableDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DiningTable> getdiningTableByPage(Page page) {
		return diningTableDao.getdiningTableByPage(page);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateDiningTable(DiningTable dt) {
		return diningTableDao.UpdateDiningTable(dt);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delDiningTable(Integer id) {
		return diningTableDao.delDiningTable(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int addDiningTable(DiningTable dt) {
		return diningTableDao.addDiningTable(dt);
	}

	@Override
	@Transactional(readOnly = true)
	public DiningTable getOneTable(Integer id) {
		return diningTableDao.getOneTable(id);
	}

	@Override
	@Transactional(readOnly = true)
	public int flagTableNum(String tableNum) {
		return diningTableDao.flagTableNum(tableNum);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DiningTable> getAlldiningTable() {
		return diningTableDao.getAlldiningTable();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int updateTableIsNo(Integer tabId) {
		return diningTableDao.updateTableIsNo(tabId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int updateTableIsOff(Integer tabId) {
		return diningTableDao.updateTableIsOff(tabId);
	}

	@Override
	@Transactional(readOnly = true)
	public DiningTable getOneTableBytabNum(String tabNum) {
		return diningTableDao.getOneTableBytabNum(tabNum);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DiningTable> getdiningTable() {
		return diningTableDao.getdiningTable();
	}

}
