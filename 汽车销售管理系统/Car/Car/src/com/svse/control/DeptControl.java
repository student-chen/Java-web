package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.DeptEntity;
import com.svse.service.DeptService;

@Controller
@RequestMapping("part.do")
public class DeptControl {

	@Autowired
	private DeptService dserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addDept(DeptEntity dept) {
		this.dserv.addDept(dept);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppDept(DeptEntity dept) {
		this.dserv.uppDept(dept);
		return 1;
	}

	// 树修改
	@RequestMapping(params = "method=upps")
	@ResponseBody
	public int uppDepts(DeptEntity dept) {
		int zjid = dept.getZjid();
		DeptEntity d = this.dserv.getOneDepts(zjid);
		d.setZjmc(dept.getZjmc());
		this.dserv.uppDept(d);
		return 1;
	}

	// 拖拉修改
	@RequestMapping(params = "method=uppss")
	@ResponseBody
	public int uppDeptss(DeptEntity dept) {
		int zjid = dept.getZjid();
		DeptEntity d = this.dserv.getOneDepts(zjid);
		d.setSjid(dept.getSjid());
		this.dserv.uppDept(d);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public List<DeptEntity> getAllDept() {
		List<DeptEntity> ar = this.dserv.getAllDept();
		return ar;
	}

	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public DeptEntity getOneDept(int pid) {
		DeptEntity dept = this.dserv.getOneDept(pid);
		return dept;
	}
	// 查询单个
	@RequestMapping(params = "method=deptone")
	@ResponseBody
	public DeptEntity getOneDepts(int zjid) {
		DeptEntity dept = this.dserv.getOneDepts(zjid);
		return dept;
	}

	// 判断重复
	@RequestMapping(params = "method=repeat")
	@ResponseBody
	public int repeat(String zjmc,String old,int sjid) {
		DeptEntity dept = new DeptEntity();
		dept.setZjmc(zjmc);
		dept.setSjid(sjid);
		int t = this.dserv.repeat(dept);
		if (t > 0) {
			if(old!=null && old.equalsIgnoreCase(zjmc)){
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
