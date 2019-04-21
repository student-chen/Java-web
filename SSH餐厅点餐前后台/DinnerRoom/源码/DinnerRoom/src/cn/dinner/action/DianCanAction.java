package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.dinner.entity.DiningTable;
import cn.dinner.entity.DinnerNotice;
import cn.dinner.entity.DinnerOrder;
import cn.dinner.entity.Menu;
import cn.dinner.entity.MenuType;
import cn.dinner.service.DiningTableservice;
import cn.dinner.service.DinnerNoticeservice;
import cn.dinner.service.DinnerOrderservice;
import cn.dinner.service.MenuTypeservice;
import cn.dinner.service.Menuservice;

public class DianCanAction {

	private Menuservice menuservice;
	private DinnerOrderservice dinnerOrderservice;
	private DinnerNoticeservice dinnerNoticeservice;
	private MenuTypeservice menuTypeservice;
	private List<MenuType> mtlist;
	private DiningTableservice diningTableservice;
	private List<DiningTable> dtList;

	//进入点餐主页
	public String diancan(){
		return "success";
	}
	//分类获取菜谱
	public String OrderMenu(){
		mtlist = menuTypeservice.getAllMenuType();
		dtList = diningTableservice.getdiningTable();
		return "success";
	}
	//生成订单以及小票
	private String tableid;
	private String userCode;
	private Integer personNum;
	private String ids;
	private String counts;
	private String ranks;
	public void dianCan() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		DinnerOrder order = new DinnerOrder(tableid,new Date(),userCode,personNum,0,0.0,0);
		int orderid =  dinnerOrderservice.addOrder(order);
		String[] newids = ids.split(",");
		String[] newcounts = counts.split(",");
		String[] newranks = ranks.split(",");
		if(orderid>0){
			int res=0;
			for (int i = 0; i < newids.length; i++) {
				Menu menu = menuservice.getMenuByid(Integer.parseInt(newids[i]));
				DinnerNotice notice = new DinnerNotice(menu.getMName(),orderid,Integer.parseInt(newcounts[i]),newranks[i],menu.getMPrice());
				res = dinnerNoticeservice.addNotice(notice);
			}
			if(res>0){
				out.print(1);
			}else{
				out.print(-1);
			}
		}else{
			out.print(-1);
		}
	}
	
	//封装
	public Menuservice getMenuservice() {
		return menuservice;
	}

	public void setMenuservice(Menuservice menuservice) {
		this.menuservice = menuservice;
	}
	public MenuTypeservice getMenuTypeservice() {
		return menuTypeservice;
	}
	public void setMenuTypeservice(MenuTypeservice menuTypeservice) {
		this.menuTypeservice = menuTypeservice;
	}
	public List<MenuType> getMtlist() {
		return mtlist;
	}
	public void setMtlist(List<MenuType> mtlist) {
		this.mtlist = mtlist;
	}
	
	public String getTableid() {
		return tableid;
	}
	public void setTableid(String tableid) {
		this.tableid = tableid;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Integer getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getCounts() {
		return counts;
	}
	public void setCounts(String counts) {
		this.counts = counts;
	}
	public String getRanks() {
		return ranks;
	}
	public void setRanks(String ranks) {
		this.ranks = ranks;
	}
	public DinnerOrderservice getDinnerOrderservice() {
		return dinnerOrderservice;
	}
	public void setDinnerOrderservice(DinnerOrderservice dinnerOrderservice) {
		this.dinnerOrderservice = dinnerOrderservice;
	}
	public DinnerNoticeservice getDinnerNoticeservice() {
		return dinnerNoticeservice;
	}
	public void setDinnerNoticeservice(DinnerNoticeservice dinnerNoticeservice) {
		this.dinnerNoticeservice = dinnerNoticeservice;
	}
	public DiningTableservice getDiningTableservice() {
		return diningTableservice;
	}
	public void setDiningTableservice(DiningTableservice diningTableservice) {
		this.diningTableservice = diningTableservice;
	}
	public List<DiningTable> getDtList() {
		return dtList;
	}
	public void setDtList(List<DiningTable> dtList) {
		this.dtList = dtList;
	}
}
