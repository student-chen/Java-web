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

import com.svse.entity.InhandoutEntity;
import com.svse.entity.InhandoutmxEntity;
import com.svse.entity.MasterEntity;
import com.svse.entity.StorehouseEntity;
import com.svse.service.InhandoutService;
import com.svse.service.InhandoutmxService;
import com.svse.service.StorehouseService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("inhandoutmx.do")
public class InhandoutmxControl {

	@Autowired
	private InhandoutmxService ihmserv;

	@Autowired
	private InhandoutService hserv;

	@Autowired
	private StorehouseService sserv;

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
	@RequestMapping(params = "method=ww")
	@ResponseBody
	public int addInhandout(InhandoutmxEntity Inhandoutmx, HttpServletRequest request, HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		Inhandoutmx.setPid(m.getPid());
		Inhandoutmx.setMid(m.getMid());
		Date d = new Date();
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = ff.format(d);
		Inhandoutmx.setHandouttime(time);
		if (Inhandoutmx.getImg() != null) {
			String imgname = Inhandoutmx.getImg().getOriginalFilename();
			String newname = this.getNewname(imgname);
			String path = request.getSession().getServletContext().getRealPath("/upload/" + newname);
			File f = new File(path);
			try {
				// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
				FileUtils.copyInputStreamToFile(Inhandoutmx.getImg().getInputStream(), f);// 复制临时文件到指定目录下
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 存数据库
			Inhandoutmx.setHandoutimg(newname);
			this.ihmserv.add(Inhandoutmx);
			List<InhandoutmxEntity> ar = this.ihmserv.getAll(Inhandoutmx.getInhandoutid());
			int num = 0;
			for (InhandoutmxEntity ih : ar) {
				num += ih.getInhandoutnum();
			}
			Integer buy=this.ihmserv.getBuy(Inhandoutmx.getInhandoutid());
			Integer fui=this.ihmserv.getfui(Inhandoutmx.getInhandoutid());
			if(fui==null){
				fui=0;
			}
			if(buy==null){
				buy=0;
			}
			num=num-buy-fui;
			if(num<0){
				num=0;
			}
			InhandoutEntity h = this.hserv.getOne(Inhandoutmx.getInhandoutid());
			h.setInhandoutcount(num);
			if (num == 0) {
				h.setInhandoutflag(0);
			} else {
				h.setInhandoutflag(1);
			}
			this.hserv.upp(h);
			return 1;
		} else {
			return 0;
		}
	}

	// 修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppInhandout(InhandoutmxEntity Inhandout, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/upload");
		String newpath = path.replace("\\", "/");
		InhandoutmxEntity hh = new InhandoutmxEntity();
		hh = this.ihmserv.getOne(Inhandout.getInhandoutmxid());
		if (!Inhandout.getImg().getOriginalFilename().equals("")) {
			String newname = this.getNewname(Inhandout.getImg().getOriginalFilename());
			File ff = new File(newpath, "/" + hh.getHandoutimg());
			ff.delete();
			File f = new File(newpath, newname);
			try {
				FileUtils.copyInputStreamToFile(Inhandout.getImg().getInputStream(), f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Inhandout.setHandoutimg(newname);
			Inhandout.setHandouttime(hh.getHandouttime());
			Inhandout.setPid(hh.getPid());
			Inhandout.setMid(hh.getMid());
			this.ihmserv.upp(Inhandout);
			int num = 0;
			List<InhandoutmxEntity> ar = this.ihmserv.getAll(Inhandout.getInhandoutid());
			for (InhandoutmxEntity ih : ar) {
				num += ih.getInhandoutnum();
			}
			Integer buy=this.ihmserv.getBuy(hh.getInhandoutid());
			Integer fui=this.ihmserv.getfui(hh.getInhandoutid());
			num=num-buy-fui;
			if(num<0){
				num=0;
			}
			InhandoutEntity h = this.hserv.getOne(Inhandout.getInhandoutid());
			h.setInhandoutcount(num);
			if (num == 0) {
				h.setInhandoutflag(0);
			} else {
				h.setInhandoutflag(1);
			}
			this.hserv.upp(h);
			return 1;
		} else {
			Inhandout.setHandoutimg(hh.getHandoutimg());
			Inhandout.setHandouttime(hh.getHandouttime());
			Inhandout.setPid(hh.getPid());
			Inhandout.setMid(hh.getMid());
			this.ihmserv.upp(Inhandout);
			List<InhandoutmxEntity> ar = this.ihmserv.getAll(Inhandout.getInhandoutid());
			int num = 0;
			for (InhandoutmxEntity ih : ar) {
				num += ih.getInhandoutnum();
			}
			Integer buy=this.ihmserv.getBuy(hh.getInhandoutid());
			Integer fui=this.ihmserv.getfui(hh.getInhandoutid());
			if(fui==null){
				fui=0;
			}
			if(buy==null){
				buy=0;
			}
			num=num-buy-fui;
			if(num<0){
				num=0;
			}
			InhandoutEntity h = this.hserv.getOne(Inhandout.getInhandoutid());
			h.setInhandoutcount(num);
			if (num == 0) {
				h.setInhandoutflag(0);
			} else {
				h.setInhandoutflag(1);
			}
			this.hserv.upp(h);
			return 1;
		}
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public JSONObject all(int limit, int offset, int inhandoutid) {
		// 共有多少条
		int count = this.ihmserv.count(inhandoutid);
		List<InhandoutmxEntity> ar = this.ihmserv.getAll(offset, limit, inhandoutid);
		JSONObject obj = new JSONObject();
		obj.put("rows", ar);
		obj.put("total", count);
		return obj;
	}

	@RequestMapping(params = "method=allinhandoutmx")
	@ResponseBody
	public List<InhandoutmxEntity> getAll() {
		List<InhandoutmxEntity> ar = this.ihmserv.getAll();
		return ar;
	}

	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public List getOneInhandout(int inhandoutmxid) {
		List ar = new ArrayList();
		InhandoutmxEntity Inhandout = this.ihmserv.getOne(inhandoutmxid);
		List<StorehouseEntity> ars = this.sserv.getAllStorehouse();
		ar.add(Inhandout);
		for (StorehouseEntity h : ars) {
			ar.add(h);
		}
		return ar;
	}

	// 查询单个
	@RequestMapping(params = "method=getCount")
	@ResponseBody
	public InhandoutmxEntity getCount(int inhandoutid) {
		Integer zong=this.ihmserv.getzong(inhandoutid);
		Integer now=this.ihmserv.getnow(inhandoutid);
		Integer fui=this.ihmserv.getfui(inhandoutid);
		Integer buy=this.ihmserv.getBuy(inhandoutid);
		InhandoutmxEntity h=new InhandoutmxEntity();
		if(zong==null){
			zong=0;
		}
		if(fui==null){
			fui=0;
		}
		if(now==null){
			now=0;
		}
		if(buy==null){
			buy=0;
		}
		h.setFui(fui);
		h.setNow(now);
		Integer zz=now+fui+buy;
		if(zong<zz){
			zong=zz;
		}
		h.setZong(zong);
		h.setBuy(buy);
		return h;
	}

}
