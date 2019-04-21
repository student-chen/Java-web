package com.svse.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.DeptEntity;
import com.svse.entity.GwEntity;
import com.svse.service.DeptService;
import com.svse.service.GwService;

@Controller
@RequestMapping("gw.do")
public class GwControl {

	@Autowired
	private GwService gserv;
	@Autowired
	private DeptService dserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addGw(GwEntity gw) {
		this.gserv.addGw(gw);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppGw(GwEntity gw) {
		this.gserv.uppGw(gw);
		return 1;
	}

	// 树修改
	@RequestMapping(params = "method=upps")
	@ResponseBody
	public int uppGws(GwEntity gw) {
		this.gserv.uppGw(gw);
		return 1;
	}

	// 拖拉修改
	@RequestMapping(params = "method=uppss")
	@ResponseBody
	public int uppGwss(GwEntity gw) {
		int gid = gw.getGid();
		GwEntity d = this.gserv.getOneGw(gid);
		d.setPid(gw.getPid());
		this.gserv.uppGw(d);
		return 1;
	}
	
	@RequestMapping(params="method=allgw")
	@ResponseBody
	public List<GwEntity> getAllGw(int pid){
		List<GwEntity> ar=this.gserv.getGwbyPid(pid);
		if(ar.size()==0){
			GwEntity g=new GwEntity();
			g.setGid(0);
			g.setGname("---该部门无岗位---");
			ar.add(g);
		}
		return ar;
	}
	
	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public List<DeptEntity> getAllGw() {
		List<DeptEntity> ars = this.dserv.getAllDept();
		List<DeptEntity> ar=new ArrayList<DeptEntity>();
		List<GwEntity> arg=this.gserv.getAllGw();
		for (GwEntity g : arg) {
			DeptEntity dept=new DeptEntity();
			dept.setZjid(g.getGid()*10);
			dept.setSjid(g.getDept().getZjid());
			dept.setZjmc(g.getGname());
			dept.setGid(g.getGid());
			dept.setGremark(g.getGremark());
			ar.add(dept);
		}
		for (DeptEntity dd : ars) {
			ar.add(dd);
		}
		return ar;
	}
	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public List getOneGw(int gid) {
		List ar=new ArrayList();
		GwEntity gw = this.gserv.getOneGw(gid);
		gw.setPid(gw.getDept().getPid());
		List<DeptEntity> arp=this.dserv.getAllDept();
		ar.add(gw);
		for (DeptEntity d : arp) {
			ar.add(d);
		}
		return ar;
	}
	

	// 判断重复
	@RequestMapping(params = "method=repeat")
	@ResponseBody
	public int repeat(String name,String old,int pid) {
		GwEntity gw = new GwEntity();
		gw.setGname(name);
		gw.setPid(pid);
		int t = this.gserv.repeat(gw);
		if (t > 0) {
			if(old!=null && old.equalsIgnoreCase(name)){
				return 2;
			}else{
				// 重复
				return 1;
			}
		} else {
			return 2;
		}
	}

}
