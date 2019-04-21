package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.MemberTypeDao;
import cn.dinner.entity.MemberType;
import cn.dinner.service.MemberTypeservice;
import cn.dinner.util.Page;
@Service
@Transactional
public class MemberTypeserviceImpl implements MemberTypeservice {
	
	@Autowired
	private MemberTypeDao memberTypeDao;
	
	public MemberTypeDao getMemberTypeDao() {
		return memberTypeDao;
	}
	public void setMemberTypeDao(MemberTypeDao memberTypeDao) {
		this.memberTypeDao = memberTypeDao;
	}
	@Override
	@Transactional(readOnly = true)
	public List<MemberType> getAllMemberType() {
		return memberTypeDao.getAllMemberType();
	}
	@Override
	@Transactional(readOnly = true)
	public MemberType getOneMemberType(Integer id) {
		return memberTypeDao.getOneMemberType(id);
	}
	@Override
	@Transactional(readOnly = true)
	public List<MemberType> getAllMemberTypeByPage(Page page) {
		return memberTypeDao.getAllMemberTypeByPage(page);
	}
	@Override
	@Transactional(readOnly = true)
	public int flagMemberType(String typename) {
		return memberTypeDao.flagMemberType(typename);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int addMemberType(MemberType mt) {
		return memberTypeDao.addMemberType(mt);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delMemberType(Integer id) {
		return memberTypeDao.delMemberType(id);
	}


}
