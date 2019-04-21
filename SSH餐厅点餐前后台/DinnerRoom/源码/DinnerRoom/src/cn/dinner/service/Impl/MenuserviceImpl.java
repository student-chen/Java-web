package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.MenuDao;
import cn.dinner.entity.Menu;
import cn.dinner.service.Menuservice;
import cn.dinner.util.MenuCond;
import cn.dinner.util.Page;
@Service
@Transactional
public class MenuserviceImpl implements Menuservice {

	@Autowired
	private MenuDao menuDao;
	
	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Menu> menuList(Page page, MenuCond cond) {
		return menuDao.menuList(page, cond);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int AddMenu(Menu menu) {
		return menuDao.AddMenu(menu);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delMenu(Integer id) {
		return menuDao.delMenu(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Menu> getMenuByTypeId(Integer id) {
		return menuDao.getMenuByTypeId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Menu getMenuByid(Integer id) {
		return menuDao.getMenuByid(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int updateMenu(Menu menu) {
		return menuDao.updateMenu(menu);
	}

}
