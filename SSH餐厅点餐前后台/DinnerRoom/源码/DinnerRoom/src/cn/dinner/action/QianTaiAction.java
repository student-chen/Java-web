package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.dinner.entity.DiningTable;
import cn.dinner.entity.DinnerOrder;
import cn.dinner.entity.Member;
import cn.dinner.entity.MemberType;
import cn.dinner.service.DiningTableservice;
import cn.dinner.service.DinnerOrderservice;
import cn.dinner.service.MemberTypeservice;
import cn.dinner.service.Memberservice;
import cn.dinner.util.DinnerOrderCond;
import cn.dinner.util.Page;

public class QianTaiAction {

	private DiningTableservice diningTableservice;
	private DinnerOrderservice dinnerOrderservice;
	private List<DiningTable> dtableList;

	/**
	 * 登陆后台主页
	 */
	public String goQTIndex() {
		return "success";
	}
	// 餐桌使用情况
	public String czsyqk() {
		dtableList = diningTableservice.getAlldiningTable();
		return "success";
	}

	// 餐桌Id
	private Integer tabid;

	public void jiuZuo() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = diningTableservice.updateTableIsNo(tabid);
		if (res > 0) {
			out.print(1);
		} else {
			out.print(-1);
		}
	}

	// 前台订单页面获取
	// 条件
	// 分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject qtorderjson;
	// 查询条件
	private Integer ispay;
	private Date startTime;
	private Date endTime;

	public String getAllOrderInfo() {
		DinnerOrderCond cond = new DinnerOrderCond();
		if (ispay != null && ispay != -1) {
			cond.setIspay(ispay);
		}
		if (startTime != null && !startTime.equals("")) {
			cond.setStartTime(startTime);
		}
		if (endTime != null && !endTime.equals("")) {
			cond.setEndTime(endTime);
		}
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<DinnerOrder> orderlist = dinnerOrderservice.getAllDinnerOrderByQT(
				pageUtil, cond);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data", orderlist);
		qtorderjson = JSONObject.fromObject(map);
		return "success";
	}

	private MemberTypeservice memberTypeservice;
	private List<MemberType> membertypelist;

	public void getAllMemberType() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		membertypelist = memberTypeservice.getAllMemberType();
		JSONArray jsonObject = JSONArray.fromObject(membertypelist);
		out.print(jsonObject.toString());
	}

	// 前台修改会员资料
	// 条件
	private Memberservice memberservice;
	private Integer mid;
	private Integer memberType;
	private String name;
	private String mphone;
	private Integer mcode;

	public void updateMember() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		MemberType mt = memberTypeservice.getOneMemberType(memberType);
		Member member = new Member(mid, mt, name, mphone, mcode);
		int res = memberservice.UpdateMember(member);
		if (res > 0) {
			out.print(1);
		} else {
			out.print(-1);
		}
	}

	// 添加
	public void AddMember() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int flag = memberservice.flagMemberByphone(mphone);
		if (flag == 0) {
			int tmp = memberType / 1 * 1000;// 按照会员等级分配不同积分
			MemberType mt = memberTypeservice.getOneMemberType(memberType);
			Member member = new Member(mid, mt, name, mphone, tmp);
			int res = memberservice.AddMember(member);
			if (res > 0) {
				out.print(1);
			} else {
				out.print(-2);
			}
		} else {
			out.print(-1);
		}
	}

	// 结算订单
	// 条件
	private Integer oid;
	private Double sumPrice;
	private String tabnum;

	public void jieSuanOrder() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		if(!mphone.equals("") && mphone!=null){
			int flagMember = memberservice.flagMemberByphone(mphone);
			if(flagMember==1){
				BigDecimal bd=new BigDecimal(sumPrice).setScale(0, BigDecimal.ROUND_HALF_UP);
				int updateMembercode = memberservice.UpdateMemberByphone(mphone, Integer.parseInt(bd.toString()));
			}else{
				out.print(-2);
			}
		}else{
			int orderres = dinnerOrderservice.updateOrder(oid, sumPrice);
			if (orderres > 0) {
				DiningTable dt = diningTableservice.getOneTableBytabNum(tabnum);
				int tres = diningTableservice.updateTableIsOff(dt.getId());
				if (tres > 0) {
					out.print(1);
				} else {
					out.print(-1);
				}
			} else {
				out.print(-1);
			}
		}
	}

	// 封装属性
	public DiningTableservice getDiningTableservice() {
		return diningTableservice;
	}

	public void setDiningTableservice(DiningTableservice diningTableservice) {
		this.diningTableservice = diningTableservice;
	}

	public List<DiningTable> getDtableList() {
		return dtableList;
	}

	public void setDtableList(List<DiningTable> dtableList) {
		this.dtableList = dtableList;
	}

	public Integer getTabid() {
		return tabid;
	}

	public void setTabid(Integer tabid) {
		this.tabid = tabid;
	}

	public String getTabnum() {
		return tabnum;
	}

	public void setTabnum(String tabnum) {
		this.tabnum = tabnum;
	}

	public DinnerOrderservice getDinnerOrderservice() {
		return dinnerOrderservice;
	}

	public void setDinnerOrderservice(DinnerOrderservice dinnerOrderservice) {
		this.dinnerOrderservice = dinnerOrderservice;
	}

	public Memberservice getMemberservice() {
		return memberservice;
	}

	public void setMemberservice(Memberservice memberservice) {
		this.memberservice = memberservice;
	}

	public Page getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(Page pageUtil) {
		this.pageUtil = pageUtil;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public JSONObject getQtorderjson() {
		return qtorderjson;
	}

	public void setQtorderjson(JSONObject qtorderjson) {
		this.qtorderjson = qtorderjson;
	}

	public Integer getIspay() {
		return ispay;
	}

	public void setIspay(Integer ispay) {
		this.ispay = ispay;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public MemberTypeservice getMemberTypeservice() {
		return memberTypeservice;
	}

	public void setMemberTypeservice(MemberTypeservice memberTypeservice) {
		this.memberTypeservice = memberTypeservice;
	}

	public List<MemberType> getMembertypelist() {
		return membertypelist;
	}

	public void setMembertypelist(List<MemberType> membertypelist) {
		this.membertypelist = membertypelist;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public Integer getMcode() {
		return mcode;
	}

	public void setMcode(Integer mcode) {
		this.mcode = mcode;
	}

}
