package com.bjpowernode.system.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * easyui 的树形结构对象
 * @author Administrator
 *
 */
public class TreeNode {

	private String id;
	
	private String text;
	
	private boolean isLeaf;
	
	private String iconCls;
	
	private String state; //closed open
	
	private List<TreeNode> children;
	
	private Map<String,Object> attributes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public Map<String, Object> getAttributes() {
		
		if(attributes == null ){
			attributes = new HashMap<String, Object>();
		}
		attributes.put("isLeaf", isLeaf) ;
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
