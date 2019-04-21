package cn.dinner.service;

import java.util.List;

import cn.dinner.entity.MemberType;
import cn.dinner.util.Page;

public interface MemberTypeservice {
	// 查询所有会员类型
	List<MemberType> getAllMemberType();

	// 根据id获取会员类型对象
	MemberType getOneMemberType(Integer id);

	// 分页获取会员类型数据
	List<MemberType> getAllMemberTypeByPage(Page page);

	// 判断会员类型是否存在
	int flagMemberType(String typename);

	// 添加会员类型
	int addMemberType(MemberType mt);

	// 删除
	int delMemberType(Integer id);
}
