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
import cn.dinner.util.MemberCond;
import cn.dinner.util.Page;

public class MemberAction {
	@Autowired
	private Memberservice memberservice;

	// 分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject memberjson;
	// 查询条件
	private String phone;
	private Integer mtype;
	/**
	 * 分页查询所有会员
	 * @return
	 */
	public String getAllMember(){
		MemberCond cond = new MemberCond();
		if(phone!=null && !phone.equals("")){
			cond.setPhone("%"+phone+"%");
		}
		if(mtype!=null && mtype!=-1){
			cond.setMembertypeid(mtype);
		}
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<Member> memberList = memberservice.getAllByPage(pageUtil, cond);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data", memberList);
		memberjson = JSONObject.fromObject(map);
		return "success";
	}
	//显示修改信息条件
	private Integer upid;
	private MemberTypeservice memberTypeservice;
	private List<MemberType> membertypelist;
	private Member memberInfo;
	/**
	 * 显示修改信息
	 * @return
	 */
	public String ShowUpMemberInfo(){
		membertypelist = memberTypeservice.getAllMemberType();
		memberInfo = memberservice.getMemberByid(upid);
		return "success";
	}
	//修改条件
	private Integer id;
	private Integer uptypeId;
	private String upname;
	private String upphone;
	private Integer upmcode;
	/**
	 * 修改会员信息
	 * @return
	 * @throws IOException 
	 */
	public void UpdateMemberInfo() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		MemberType mt = memberTypeservice.getOneMemberType(uptypeId);
		Member member = new Member(id,mt,upname,upphone,upmcode);
		int res = memberservice.UpdateMember(member);
		if(res>0){
			out.print("<script>alert('修改成功');location.href='showMember';</script>");
		}else{
			out.print("<script>alert('修改失败');location.href='showUpMember?upid="+id+"';</script>");
		}
	}
	//删除条件
	private Integer delid;
	/**
	 * 删除会员信息
	 * @return
	 * @throws IOException 
	 */
	public void delMember() throws IOException{
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = memberservice.delMember(delid);
		out.print(res);
	}

	// 封装
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

	public JSONObject getMemberjson() {
		return memberjson;
	}

	public void setMemberjson(JSONObject memberjson) {
		this.memberjson = memberjson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getMtype() {
		return mtype;
	}

	public MemberTypeservice getMemberTypeservice() {
		return memberTypeservice;
	}


	public void setMemberTypeservice(MemberTypeservice memberTypeservice) {
		this.memberTypeservice = memberTypeservice;
	}


	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}

	public Integer getUpid() {
		return upid;
	}

	public void setUpid(Integer upid) {
		this.upid = upid;
	}


	public List<MemberType> getMembertypelist() {
		return membertypelist;
	}


	public void setMembertypelist(List<MemberType> membertypelist) {
		this.membertypelist = membertypelist;
	}


	public Member getMemberInfo() {
		return memberInfo;
	}


	public void setMemberInfo(Member memberInfo) {
		this.memberInfo = memberInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUptypeId() {
		return uptypeId;
	}

	public void setUptypeId(Integer uptypeId) {
		this.uptypeId = uptypeId;
	}

	public String getUpname() {
		return upname;
	}

	public void setUpname(String upname) {
		this.upname = upname;
	}

	public String getUpphone() {
		return upphone;
	}

	public void setUpphone(String upphone) {
		this.upphone = upphone;
	}

	public Integer getUpmcode() {
		return upmcode;
	}

	public void setUpmcode(Integer upmcode) {
		this.upmcode = upmcode;
	}

	public Integer getDelid() {
		return delid;
	}

	public void setDelid(Integer delid) {
		this.delid = delid;
	}

}
