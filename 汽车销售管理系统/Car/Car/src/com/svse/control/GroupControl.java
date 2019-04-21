package com.svse.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.GroupEntity;
import com.svse.entity.MasterAEntity;
import com.svse.service.GroupService;
import com.svse.service.MasterAService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("group.do")
public class GroupControl {

	@Autowired
	private GroupService gserv;
	@Autowired
	private MasterAService maserv;

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addsort(GroupEntity group) {
		this.gserv.addGroup(group);
		return 1;
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppsort(GroupEntity group) {
		this.gserv.uppGroup(group);
		return 1;
	}
	
	@RequestMapping(params="method=alls")
	@ResponseBody
	public List<GroupEntity> getAll(int mid){
		  
		List<GroupEntity> ar=this.gserv.getAllGroup();
		for (GroupEntity g : ar) {
			String ns="<div class='inline-block vertical-top'></div>"
					+ "<div class='custom-checkbox'>"
					+ "<input type='checkbox' value='"+g.getGroupid()+"' id='inlineCheckbox"+g.getGroupid()+"' class='checkbox-grey'>"
					+ "<label for='inlineCheckbox"+g.getGroupid()+"' id='Checkbox"+g.getGroupid()+"'></label></div>";
			MasterAEntity m=this.maserv.getAllByMid(mid, g.getGroupid());
			if(m!=null){
				String nn="<div class='inline-block vertical-top'></div>"
						+ "<div class='custom-checkbox'>"
						+ "<input type='checkbox' value='"+g.getGroupid()+"' id='inlineCheckbox"+g.getGroupid()+"' class='checkbox-grey' checked>"
						+ "<label for='inlineCheckbox"+g.getGroupid()+"' id='Checkbox"+g.getGroupid()+"'></label></div>";  
				
				g.setName(nn);
			}else{
				g.setName(ns);
			}
		}
		
		
		return ar;
	}
	// 全查询
	@RequestMapping(params="method=all")
	@ResponseBody
	public JSONObject all(int limit,int offset)
	{
		//共有多少条
		int count=this.gserv.Count();
		//分页查询
		List<GroupEntity> ar=this.gserv.getAllGroup(offset, limit);
		
		JSONObject obj=new JSONObject();
		
		obj.put("rows", ar);
		obj.put("total", count);
		
		return obj;
	}


	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public GroupEntity getOneGroup(int groupid) {
		GroupEntity group = this.gserv.getOneGroup(groupid);
		return group;
	}

	// 判断重复
	@RequestMapping(params = "method=repeat")
	@ResponseBody
	public int repeat(String name,String old) {
		GroupEntity group = new GroupEntity();
		group.setGroupname(name);
		int t = this.gserv.repeat(group);
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
