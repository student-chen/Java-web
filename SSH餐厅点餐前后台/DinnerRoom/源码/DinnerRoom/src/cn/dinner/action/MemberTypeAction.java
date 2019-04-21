package cn.dinner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.entity.Member;
import cn.dinner.entity.MemberType;
import cn.dinner.service.MemberTypeservice;
import cn.dinner.service.Memberservice;
import cn.dinner.util.Page;

public class MemberTypeAction {

	@Autowired
	private MemberTypeservice memberTypeservice;
	private List<MemberType> membertypelist;
	/**
	 * 获取所有会员类型
	 * @return
	 */
	public String getAllMemberType(){
		membertypelist = memberTypeservice.getAllMemberType();
		return "success";
	}
	//分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject membertypejson;
	/**
	 * 分页获取会员类型数据
	 * @return
	 */
	public String getAllMemberTypeByPage(){
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<MemberType> mList = memberTypeservice.getAllMemberTypeByPage(pageUtil);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data", mList);
		membertypejson = JSONObject.fromObject(map);
		return "success";
	}
	//添加会员类型条件
	private String typename;
	/**
	 * 添加会员类型
	 * @return
	 * @throws IOException 
	 */
	public void addMemberType() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = memberTypeservice.flagMemberType(typename);
		if(res==0){
			MemberType mt = new MemberType(typename);
			int result = memberTypeservice.addMemberType(mt);
			out.print(result);
		}else{
			out.print(-1);
		}
	}
	//删除条件
	private Memberservice memberservice;
	private Integer delID;
	/**
	 * 删除会员类型
	 * @return
	 * @throws IOException 
	 */
	public void delMemberType() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		List<Member> memberList = memberservice.getAllByMemberTypeId(delID);
		if(memberList.size()==0){
			int res = memberTypeservice.delMemberType(delID);
			out.print(res);
		}else{
			out.print(-1);
		}
		
	}
	
	//封装
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

	public JSONObject getMembertypejson() {
		return membertypejson;
	}

	public void setMembertypejson(JSONObject membertypejson) {
		this.membertypejson = membertypejson;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Memberservice getMemberservice() {
		return memberservice;
	}

	public void setMemberservice(Memberservice memberservice) {
		this.memberservice = memberservice;
	}

	public Integer getDelID() {
		return delID;
	}

	public void setDelID(Integer delID) {
		this.delID = delID;
	}
	
}
