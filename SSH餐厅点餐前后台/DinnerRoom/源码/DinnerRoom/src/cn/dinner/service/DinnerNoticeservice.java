package cn.dinner.service;

import java.util.List;

import cn.dinner.entity.DinnerNotice;

public interface DinnerNoticeservice {
	// 根据id查询所有小票信息
	List<DinnerNotice> getAllDinnerNoticeByID(Integer id);

	// 删除订单编号下的小票
	int delNotice(Integer oid);

	// 添加小票
	int addNotice(DinnerNotice notice);
}
