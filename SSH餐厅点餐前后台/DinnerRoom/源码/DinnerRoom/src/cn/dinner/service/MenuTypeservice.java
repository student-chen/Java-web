package cn.dinner.service;

import java.util.List;

import cn.dinner.entity.MenuType;
import cn.dinner.util.Page;

public interface MenuTypeservice {
	// 获取全部数据
	List<MenuType> getAllMenuType();

	// 根据id获取对象
	MenuType getOne(Integer id);

	// 分页获取数据
	List<MenuType> getAllMenuTypeBypage(Page page);

	// 添加菜肴类型
	int addMenuType(MenuType menuType);

	// 根据菜肴类型名称判断数据表中是否存在
	int getOneByname(String name);

	// 删除
	int delMenuType(Integer id);
}
