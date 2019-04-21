package cn.dinner.dao;

import java.text.ParseException;
import java.util.List;

import cn.dinner.entity.DinnerOrder;
import cn.dinner.util.DinnerOrderCond;
import cn.dinner.util.Page;

public interface DinnerOrderDao {
	//多条件分页查询数据
	List<DinnerOrder> getAllDinnerOrder(Page page,DinnerOrderCond cond);
	//删除
	int delOrderInfo(Integer id);
	//后厨查询菜单详情
	List<DinnerOrder> getAllDinnerOrderByhouchu(Page page);
	//后厨上菜已经齐全
	int UpdateisFull(Integer id);
	//添加订单
	int addOrder(DinnerOrder order);
	//前台结算订单页查询
	List<DinnerOrder> getAllDinnerOrderByQT(Page page,DinnerOrderCond cond);
	//订单结算
	int updateOrder(Integer oid,Double price);
	//计算报表信息
	String homeInfo();
}
