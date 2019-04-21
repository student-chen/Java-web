package cn.dinner.dao;

import java.util.List;

import cn.dinner.entity.DiningTable;
import cn.dinner.util.Page;

public interface DiningTableDao {
	// 分页查询所有餐桌
	List<DiningTable> getdiningTableByPage(Page page);

	// 查询所有餐桌
	List<DiningTable> getdiningTable();

	// 修改
	int UpdateDiningTable(DiningTable dt);

	// 删除
	int delDiningTable(Integer id);

	// 添加
	int addDiningTable(DiningTable dt);

	// 根据id获取餐桌对象
	DiningTable getOneTable(Integer id);

	// 根据餐桌号获取餐桌对象
	DiningTable getOneTableBytabNum(String tabNum);

	// 判断餐桌编号是否存在
	int flagTableNum(String tableNum);

	// 查询所有餐桌
	List<DiningTable> getAlldiningTable();

	// 修改餐桌有人就坐
	int updateTableIsNo(Integer tabId);

	// 修改餐桌为空
	int updateTableIsOff(Integer tabId);
}
