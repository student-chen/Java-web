package cn.dinner.service;

import java.util.List;

import cn.dinner.entity.Menu;
import cn.dinner.util.MenuCond;
import cn.dinner.util.Page;

public interface Menuservice {
	// 查询菜谱所有
	List<Menu> menuList(Page page, MenuCond cond);

	// 添加菜谱
	int AddMenu(Menu menu);

	// 删除
	int delMenu(Integer id);

	// 根据菜谱类型id获取菜谱对象
	List<Menu> getMenuByTypeId(Integer id);

	// 根据id获取对象
	Menu getMenuByid(Integer id);

	// 修改
	int updateMenu(Menu menu);
}
