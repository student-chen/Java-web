package cn.dinner.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.entity.Menu;
import cn.dinner.entity.MenuType;
import cn.dinner.service.MenuTypeservice;
import cn.dinner.service.Menuservice;
import cn.dinner.util.MenuCond;
import cn.dinner.util.Page;

public class MenuAction {
	/**
	 * 所需属性
	 */
	@Autowired
	private Menuservice menuservice;
	// 分页条件
	private Page pageUtil;
	private Integer page;
	private Integer limit;
	private JSONObject menujson;
	// 查询条件
	private String m_name;
	private Integer m_type;

	/**
	 * 分页获取数据
	 * 
	 * @return success
	 */
	public String getAllMenu() {
		MenuCond cond = new MenuCond();
		if (m_name != null && !m_name.equals("")) {
			cond.setM_name("%" + m_name + "%");
		}
		if (m_type != null && m_type != -1) {
			cond.setM_type(m_type);
		}
		pageUtil = new Page();
		pageUtil.setPageIndex(page);
		pageUtil.setPageSize(limit);
		List<Menu> menuList = menuservice.menuList(pageUtil, cond);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageUtil.getCount());
		map.put("data", menuList);
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.setJsonPropertyFilter(new PropertyFilter() {
			                     @Override
			                     //第一个是Object类型的，是你要过滤的属性的类型；第二个参数是String类型，是你要过滤的属性的名称；第三个参数是Object类型的，是你要过滤的属性的值
			                     public boolean apply(Object obj, String name, Object val) {
			                         if (name.equals("menuList")) {
			                             return true;
			                        } else {
			                            return false;
			                        }
			                    }
			                });
		menujson = JSONObject.fromObject(map,config);
		System.out.println(menujson);
		return "success";
	}

	private MenuTypeservice menuTypeservice;
	// 添加条件
	private String mname;
	private Integer mprice;
	private Integer typeid;
	private String remark;
	// 上传的文件
	private File upload;
	// 文件类型
	private String uploadContentType;
	// 文件名
	private String uploadFileName;

	/**
	 * 添加菜谱
	 * 
	 * @throws IOException
	 */
	public void AddMenu() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		// 截取后缀名
		String ext = uploadFileName.substring(uploadFileName.lastIndexOf("."));
		// 重新定义图片名称
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		uploadFileName = sdf.format(new Date()).toString() + ext;
		MenuType mtype = menuTypeservice.getOne(typeid);
		Menu menu = new Menu(mtype, mname, mprice, uploadFileName, remark);
		int res = menuservice.AddMenu(menu);
		if (res > 0) {
			// 输入流
			FileInputStream fis = new FileInputStream(this.upload);
			// 真实路径
			String path = ServletActionContext.getServletContext().getRealPath(
					"/upload");
			// 输出流
			FileOutputStream fos = new FileOutputStream(path + "//"
					+ this.uploadFileName);
			IOUtils.copy(fis, fos);
			// 关闭
			fis.close();
			fos.close();
			out.print("<script>alert('添加成功');location.href='showcaipu';</script>");
		} else {
			out.print("<script>alert('添加失败');location.href='showAddcaipu';</script>");
		}
	}

	// 获取要修改的信息条件
	private Integer getUpMenuInfoid;
	private Menu updateMenuInfo;
	private List<MenuType> mtlist;

	/**
	 * 获取要修改的信息条件
	 */
	public String getgetUpMenuInfo() {
		updateMenuInfo = menuservice.getMenuByid(getUpMenuInfoid);
		mtlist = menuTypeservice.getAllMenuType();
		return "success";
	}

	// 修改信息条件
	private String oldimagePath;
	private Integer menuid;
	/**
	 * 修改菜谱信息
	 * 
	 * @throws IOException
	 */
	public void UpdateMenu() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		// 截取后缀名
		String ext = uploadFileName.substring(uploadFileName.lastIndexOf("."));
		// 重新定义图片名称
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		uploadFileName = sdf.format(new Date()).toString() + ext;
		System.out.println("原图片名字"+oldimagePath);
		MenuType mtype = menuTypeservice.getOne(typeid);
		Menu menu = new Menu(menuid,mtype, mname, mprice, uploadFileName, remark);
		int res = menuservice.updateMenu(menu);
		if (res > 0) {
			// 输入流
			FileInputStream fis = new FileInputStream(this.upload);
			// 真实路径
			String path = ServletActionContext.getServletContext().getRealPath(
					"/upload");
			// 输出流
			FileOutputStream fos = new FileOutputStream(path + "//"
					+ this.uploadFileName);
			IOUtils.copy(fis, fos);
			// 关闭
			fis.close();
			fos.close();
			new File(path +"\\"+ oldimagePath).delete();
			out.print("<script>alert('修改成功');location.href='showcaipu';</script>");
		} else {
			out.print("<script>alert('修改失败');location.href='getUpdateMenuInfo?getUpMenuInfoid="+menuid+"';</script>");
		}
	}

	// 删除条件
	private Integer delid;
	private String imgpath;

	/**
	 * 删除方法
	 * 
	 * @return
	 * @throws IOException
	 */
	public void delMenu() throws IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		int res = menuservice.delMenu(delid);
		if (res > 0) {
			if (imgpath != null || !imgpath.equals("") || !imgpath.equals("无")) {
				String path = ServletActionContext.getServletContext()
						.getRealPath("/upload");
				String delimgpath = path + "\\" + imgpath;
				new File(delimgpath).delete();
			}
		}
		out.print(res);
	}

	// 封装
	public Menuservice getMenuservice() {
		return menuservice;
	}

	public void setMenuservice(Menuservice menuservice) {
		this.menuservice = menuservice;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
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

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public Integer getM_type() {
		return m_type;
	}

	public void setM_type(Integer m_type) {
		this.m_type = m_type;
	}

	public JSONObject getMenujson() {
		return menujson;
	}

	public void setMenujson(JSONObject menujson) {
		this.menujson = menujson;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getMprice() {
		return mprice;
	}

	public String getOldimagePath() {
		return oldimagePath;
	}

	public void setOldimagePath(String oldimagePath) {
		this.oldimagePath = oldimagePath;
	}

	public void setMprice(Integer mprice) {
		this.mprice = mprice;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public MenuTypeservice getMenuTypeservice() {
		return menuTypeservice;
	}

	public void setMenuTypeservice(MenuTypeservice menuTypeservice) {
		this.menuTypeservice = menuTypeservice;
	}

	public Integer getDelid() {
		return delid;
	}

	public void setDelid(Integer delid) {
		this.delid = delid;
	}

	public Integer getGetUpMenuInfoid() {
		return getUpMenuInfoid;
	}

	public void setGetUpMenuInfoid(Integer getUpMenuInfoid) {
		this.getUpMenuInfoid = getUpMenuInfoid;
	}

	public Menu getUpdateMenuInfo() {
		return updateMenuInfo;
	}

	public void setUpdateMenuInfo(Menu updateMenuInfo) {
		this.updateMenuInfo = updateMenuInfo;
	}

	public List<MenuType> getMtlist() {
		return mtlist;
	}

	public void setMtlist(List<MenuType> mtlist) {
		this.mtlist = mtlist;
	}

}
