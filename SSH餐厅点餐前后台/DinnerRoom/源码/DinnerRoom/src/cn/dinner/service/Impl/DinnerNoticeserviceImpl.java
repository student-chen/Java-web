package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.DinnerNoticeDao;
import cn.dinner.entity.DinnerNotice;
import cn.dinner.service.DinnerNoticeservice;
@Service
@Transactional
public class DinnerNoticeserviceImpl implements DinnerNoticeservice {
	
	@Autowired
	private DinnerNoticeDao dinnerNoticeDao;
	
	public DinnerNoticeDao getDinnerNoticeDao() {
		return dinnerNoticeDao;
	}

	public void setDinnerNoticeDao(DinnerNoticeDao dinnerNoticeDao) {
		this.dinnerNoticeDao = dinnerNoticeDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DinnerNotice> getAllDinnerNoticeByID(Integer id) {
		return dinnerNoticeDao.getAllDinnerNoticeByID(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delNotice(Integer oid) {
		return dinnerNoticeDao.delNotice(oid);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int addNotice(DinnerNotice notice) {
		return dinnerNoticeDao.addNotice(notice);
	}

}
