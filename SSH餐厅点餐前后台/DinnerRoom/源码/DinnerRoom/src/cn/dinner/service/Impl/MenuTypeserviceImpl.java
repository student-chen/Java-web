package cn.dinner.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.dinner.dao.MenuTypeDao;
import cn.dinner.entity.MenuType;
import cn.dinner.service.MenuTypeservice;
import cn.dinner.util.Page;
@Service
@Transactional
public class MenuTypeserviceImpl implements MenuTypeservice {
	@Autowired
	private MenuTypeDao menuTypeDao;
	
	public MenuTypeDao getMenuTypeDao() {
		return menuTypeDao;
	}

	public void setMenuTypeDao(MenuTypeDao menuTypeDao) {
		this.menuTypeDao = menuTypeDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<MenuType> getAllMenuType() {
		return menuTypeDao.getAllMenuType();
	}

	@Override
	@Transactional(readOnly = true)
	public MenuType getOne(Integer id) {
		return menuTypeDao.getOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MenuType> getAllMenuTypeBypage(Page page) {
		return menuTypeDao.getAllMenuTypeBypage(page);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int addMenuType(MenuType menuType) {
		return menuTypeDao.addMenuType(menuType);
	}

	@Override
	@Transactional(readOnly = true)
	public int getOneByname(String name) {
		return menuTypeDao.getOneByname(name);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public int delMenuType(Integer id) {
		return menuTypeDao.delMenuType(id);
	}

}
