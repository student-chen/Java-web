package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.GroupDAOI;
import com.svse.entity.GroupEntity;
import com.svse.service.GroupService;
@Service
public class GroupImpl implements GroupService {

	@Autowired
	private GroupDAOI daoi;
	@Override
	public List<GroupEntity> getAllGroup() {
		
		return this.daoi.all();
	}

	@Override
	public List<GroupEntity> getAllGroup(int begin, int pages) {
		
		return this.daoi.allgroup(begin, pages);
	}

	@Override
	public void addGroup(GroupEntity group) {
		
		this.daoi.add(group);
	}

	@Override
	public void uppGroup(GroupEntity group) {
		
		this.daoi.upp(group);
	}

	@Override
	public GroupEntity getOneGroup(int groupid) {
		
		return this.daoi.one(groupid);
	}

	@Override
	public int Count() {
		
		return this.daoi.count();
	}

	@Override
	public int repeat(GroupEntity group) {
		
		return this.daoi.repeat(group);
	}

}
