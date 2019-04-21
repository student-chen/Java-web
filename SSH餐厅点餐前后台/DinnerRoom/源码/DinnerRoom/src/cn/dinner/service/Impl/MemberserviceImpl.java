package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.MemberDao;
import cn.dinner.entity.Member;
import cn.dinner.service.Memberservice;
import cn.dinner.util.MemberCond;
import cn.dinner.util.Page;

@Service
@Transactional
public class MemberserviceImpl implements Memberservice {
	@Autowired
	private MemberDao memberDao;
	
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Member> getAllByPage(Page page, MemberCond cond) {
		return memberDao.getAllByPage(page, cond);
	}

	@Override
	@Transactional(readOnly = true)
	public Member getMemberByid(Integer id) {
		return memberDao.getMemberByid(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateMember(Member member) {
		return memberDao.UpdateMember(member);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delMember(Integer id) {
		return memberDao.delMember(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Member> getAllByMemberTypeId(Integer id) {
		return memberDao.getAllByMemberTypeId(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int AddMember(Member member) {
		return memberDao.AddMember(member);
	}

	@Override
	@Transactional(readOnly = true)
	public int flagMemberByphone(String phone) {
		return memberDao.flagMemberByphone(phone);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int UpdateMemberByphone(String phone, Integer code) {
		return memberDao.UpdateMemberByphone(phone, code);
	}

}
