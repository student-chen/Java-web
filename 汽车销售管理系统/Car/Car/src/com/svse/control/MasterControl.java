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

import com.svse.entity.ActionsEntity;
import com.svse.entity.DeptEntity;
import com.svse.entity.GwEntity;
import com.svse.entity.MasterAEntity;
import com.svse.entity.MasterEntity;
import com.svse.entity.ZcEntity;
import com.svse.service.DeptService;
import com.svse.service.GwService;
import com.svse.service.MasterService;
import com.svse.service.ZcService;

@Controller
@RequestMapping("master.do")
public class MasterControl {

	@Autowired
	private MasterService mserv;
	@Autowired
	private ZcService zserv;
	@Autowired
	private GwService gserv;
	@Autowired
	private DeptService dserv;

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
	public int addmaster(MasterEntity master,HttpServletRequest request) {
		if(master.getImg()!=null){
			String imgname=master.getImg().getOriginalFilename();
			String newname=this.getNewname(imgname);
			String path=request.getSession().getServletContext().getRealPath("/upload/"+newname);
			File f=new File(path);
			try {
				// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
				FileUtils.copyInputStreamToFile(master.getImg().getInputStream(), f);// 复制临时文件到指定目录下
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//存数据库
			master.setMimg(newname);
			this.mserv.addMaster(master);
			return 1;
		}else{
			return 0;
		}
	}

	// 弹窗修改
	@RequestMapping(params = "method=upp")
	@ResponseBody
	public int uppmaster(MasterEntity ms,HttpServletRequest request) {
		String path=request.getSession().getServletContext().getRealPath("/upload");
		String newpath=path.replace("\\", "/");
		MasterEntity mm=this.mserv.getOneMaster(ms.getMid());
		if(!ms.getImg().getOriginalFilename().equals("")){
			String newname=this.getNewname(ms.getImg().getOriginalFilename());
			File ff=new File(newpath,"/"+mm.getMimg());
			ff.delete();
			File f=new File(newpath,newname);
			try {
				FileUtils.copyInputStreamToFile(ms.getImg().getInputStream(), f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			ms.setMimg(newname);
			this.mserv.uppMaster(ms);
			return 1;
		}else{
			ms.setMimg(mm.getMimg());
			this.mserv.uppMaster(ms);
			return 1;
		}
	}

	// 树修改
	@RequestMapping(params = "method=upps")
	@ResponseBody
	public int uppmasters(MasterEntity master) {
		MasterEntity m = this.mserv.getOneMaster(master.getMid());
		m.setMrealname(master.getMrealname());
		m.setPid(m.getDept().getPid());
		m.setGid(m.getGw().getGid());
		m.setZid(m.getZc().getZid());
		this.mserv.uppMaster(m);
		return 1;
	}
	@RequestMapping(params = "method=psw")
	@ResponseBody
	public int psw(String psw,HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		m.setMpsw(psw);
		this.mserv.uppMaster(m);
		return 1;
	}
	
	@RequestMapping(params = "method=checkpsw")
	@ResponseBody
	public int cpsw(String psw,HttpSession session) {
		MasterEntity m = (MasterEntity) session.getAttribute("master");
		MasterEntity t =this.mserv.login(m.getMname(),psw);
		if(t!=null){
			return 1;
		}else{
			return 0;
		}
	}
	// 拖拉修改
	@RequestMapping(params = "method=uppss")
	@ResponseBody
	public int uppmasterss(MasterEntity master) {
		int mid = master.getMid();
		MasterEntity d = this.mserv.getOneMaster(mid);
		d.setPid(master.getDept().getPid());
		this.mserv.uppMaster(d);
		return 1;
	}

	// 全查询
	@RequestMapping(params = "method=all")
	@ResponseBody
	public List<DeptEntity> getAllmaster() {
		List<DeptEntity> ars = this.dserv.getAllDept();
		List<DeptEntity> ar = new ArrayList<DeptEntity>();
		List<MasterEntity> arm = this.mserv.getAllMaster();
		for (MasterEntity m : arm) {
			DeptEntity dept = new DeptEntity();
			dept.setZjid(m.getMid() * 10 + 9);
			dept.setSjid(m.getDept().getZjid());
			dept.setZjmc(m.getMrealname());
			dept.setMid(m.getMid());
			ar.add(dept);
		}
		for (DeptEntity dd : ars) {
			ar.add(dd);
		}
		return ar;
	}
	
	@RequestMapping(params = "method=find")
	@ResponseBody
	public int find(String mname){
		int t =this.mserv.find(mname);
		return t;
	}
	@RequestMapping(params = "method=exit")
	public String exit(HttpSession session){
		session.removeAttribute("actionids");
		session.removeAttribute("master");
		return "login";
	}
	
	@RequestMapping(params = "method=login")
	@ResponseBody
	public int login(String mname,String mpsw,HttpSession session){
		
		int m=this.mserv.find(mname);
		if(m==0){
			//账号不存在
			return 1;
		}else{
			MasterEntity t =this.mserv.login(mname,mpsw);
			if(t==null){
				//密码错误
				return 2;
			}else{
				session.setAttribute("master", t);
				List<ActionsEntity> arag=this.mserv.getLimit(t.getMid()); 
				List<MasterAEntity> arg=this.mserv.getLimit2(t.getMid()); 
				StringBuffer str=new StringBuffer();
				for (ActionsEntity ag : arag) {
					str.append(ag.getActionname()).append("、");
				}
				session.setAttribute("actionids", str);
				int s=0;
				if(arg!=null){
					s=arg.get(0).getGroupid();
				}
				session.setAttribute("groupid", s);
				return 0;
			}
		}
	}
	
	// 查询单个
	@RequestMapping(params = "method=one")
	@ResponseBody
	public List getOnemaster(int mid) {
		List ar = new ArrayList();
		// 获得自己信息
		MasterEntity master = this.mserv.getOneMaster(mid);
		master.setPid(master.getDept().getPid());
		master.setGid(master.getGw().getGid());
		master.setZid(master.getZc().getZid());
		// 获得部门
		List<DeptEntity> arp = this.dserv.getAllDept();
		// 获得岗位
		List<GwEntity> arg = this.gserv.getAllGw();
		// 获得职称O
		List<ZcEntity> arz = this.zserv.getAllZc();
		master.setPid(master.getDept().getPid());
		master.setGid(master.getGw().getGid());
		master.setZid(master.getZc().getZid());
		ar.add(master);
		for (DeptEntity d : arp) {
			ar.add(d);
		}
		for (ZcEntity z : arz) {
			ar.add(z);
		}
		for (GwEntity g : arg) {
			ar.add(g);
		}
		return ar;
	}

	// 判断重复
	@RequestMapping(params = "method=repeat")
	@ResponseBody
	public int repeat(MasterEntity master, String old,String oldtel) {
		String name=master.getMname();
		String mtel=master.getMtel();
		int t = this.mserv.repeat(master);
		if (t > 0) {
			if (old != null && old.equalsIgnoreCase(name)) {
				return 2;
			}else if(oldtel != null && oldtel.equalsIgnoreCase(mtel)){
				return 3;
			}else {
				// 重复
				return 1;
			}
		} else {
			return 2;
		}
	}

}
