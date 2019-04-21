package com.svse.control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.svse.entity.InCarEntity;
import com.svse.entity.InCarmxEntity;
import com.svse.entity.MasterEntity;
import com.svse.service.IncarService;
import com.svse.service.IncarmxService;
import com.svse.service.StorehouseService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("incarmx.do")
public class IncarmxControl {

	@Autowired
	private IncarmxService icserv;

	@Autowired
	private IncarService cserv;

	// 改名字
	public String getNewname(String name) {
		String lastname = name.substring(name.lastIndexOf("."), name.length());
		Date d = new Date();
		SimpleDateFormat ff = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = ff.format(d);
		Random r = new Random();
		int num = r.nextInt(9999999);
		return time + num + lastname;
	}

	// 添加
	@RequestMapping(params = "method=add")
	@ResponseBody
	public int addincarmx(InCarmxEntity InCarmx, HttpServletRequest request, HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		InCarmx.setPid(m.getPid());
		InCarmx.setMid(m.getMid());
		Date d = new Date();
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = ff.format(d);
		InCarmx.setCarrukutime(time);
		InCarmx.setCarkucunflag(0);
		InCarmx.setCarrukucount(1);
		InCarmx.setNewstoreid(InCarmx.getStoreid());
		if (InCarmx.getImg() != null) {
			String imgname = InCarmx.getImg().getOriginalFilename();
			String newname = this.getNewname(imgname);
			String path = request.getSession().getServletContext().getRealPath("/upload/" + newname);
			File f = new File(path);
			try {
				// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
				FileUtils.copyInputStreamToFile(InCarmx.getImg().getInputStream(), f);// 复制临时文件到指定目录下
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 存数据库
			InCarmx.setCarimg(newname);
			this.icserv.add(InCarmx);
			//修改数量
			List<InCarmxEntity> ar = this.icserv.getAll(InCarmx.getIncarid());
			int num = 0;
			for (InCarmxEntity ih : ar) {
				num += ih.getCarrukucount();
			}
			InCarEntity h = this.cserv.getOne(InCarmx.getIncarid());
			h.setIncarcount(num);
			if (num == 0) {
				h.setIncarflag(0);
			} else {
				h.setIncarflag(1);
			}
			this.cserv.upp(h);
			return 1;
		} else {
			return 0;
		}
	}


	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset, int incarid) {
		// 共有多少条
		int count = this.icserv.count(incarid);
		List<InCarmxEntity> ar = this.icserv.getAll(offset, limit, incarid);
		JSONObject obj = new JSONObject();
		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}

	// 全查询
	@RequestMapping(params = "method=allInCarmx")
	@ResponseBody
	public List<InCarmxEntity> getAll() {
		List<InCarmxEntity> ar = this.icserv.getAll();
		return ar;
	}
	
	//条件查询
	@RequestMapping(params = "method=alllimit")
	@ResponseBody
	public JSONObject getAlllimit(int limit, int offset,int detailid,int flag){
		JSONObject obj = new JSONObject();
		//状态
		if(detailid==0 && flag!=2){
			int count = this.icserv.counts1(flag);
			List<InCarmxEntity> ar= this.icserv.getAllLimit1(flag,offset, limit);
			obj.put("rows", ar);
			obj.put("total", count);
		}
		//系列
		if(flag==2 && detailid!=0){
			int count = this.icserv.counts2(detailid);
			List<InCarmxEntity> ar= this.icserv.getAllLimit2(detailid,offset, limit);
			obj.put("rows", ar);
			obj.put("total", count);
		}
		//系列和状态
		if(flag!=2 && detailid!=0){
			int count = this.icserv.counts(detailid,flag);
			List<InCarmxEntity> ar= this.icserv.getAllLimit(detailid,flag,offset, limit);
			obj.put("rows", ar);
			obj.put("total", count);
		}
		//全查询
		if(flag==2 && detailid==0){
			int count = this.icserv.allcount();
			List<InCarmxEntity> ar= this.icserv.getAll(offset, limit);
			obj.put("rows", ar);
			obj.put("total", count);
		}
		return obj;
	}
	
	

	// 查询
	@RequestMapping(params = "method=one")
	@ResponseBody
	public InCarmxEntity getOne(int incarmxid) {
		InCarmxEntity ar = this.icserv.getOne(incarmxid);
		return ar;
	}

	// 判断重复
	@RequestMapping(params = "method=rea")
	@ResponseBody
	public int getRea(InCarmxEntity incarmx) {
		int t = this.icserv.Rea(incarmx);
		return t;
	}
}
