package com.tsinghuait.st0717.hospitalsystem.common;

import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultSetToBean {

	/**
	 * 将结果集中的数据拷贝到DTO对象中去
	 * 
	 * @param rs
	 *            数据库结果集对象
	 * @param dto
	 *            dto对象
	 */
	public static Collection convertResultSet2DTOCollection(ResultSet rs,
			Class cls,int rsBeginIndex,int size) {
		Logger log = Logger.getLogger(ResultSetToBean.class.getName());
		Collection col = null; // 存放DTO对象的集合
		Method[] methods = cls.getMethods(); // DTO对象中所有的方法
		String currentMethodName = null;
		Method currentMethod = null;
		String currentColumnName = null;
		try {
			// 用于从数据库中取数据的列名对应要调用的set方法
			Map<String, Method> dataMap = new HashMap<String, Method>();
			// 获取数据的列名对应要调用的set方法的map对象
			for (int i = 0; i < methods.length; i++) {
				currentMethodName = methods[i].getName();
				if ("set".equals(currentMethodName.subSequence(0, 3))) {
					dataMap.put(currentMethodName.substring(3), methods[i]);
				}
			}
			Set<String> columns = dataMap.keySet();
			if (rs != null && rs.absolute(rsBeginIndex)) {
				col = new ArrayList(); // 实例化集合对象，用于存放DTO
				int count = 0;
				do {
					Object obj = cls.newInstance(); // 实例化dto对象
					Iterator<String> colIterator = columns.iterator();
					while (colIterator.hasNext()) {
						currentColumnName = colIterator.next();
						currentMethod = dataMap.get(currentColumnName);
						if (currentMethod.getParameterTypes()[0] == String.class) {
							currentMethod.invoke(obj, rs
									.getString(currentColumnName));
						} else if (currentMethod.getParameterTypes()[0] == Integer.class) {
							currentMethod.invoke(obj, rs
									.getInt(currentColumnName));
						} else if (currentMethod.getParameterTypes()[0] == Date.class) {
							currentMethod.invoke(obj, rs
									.getDate(currentColumnName));
						} else {
							log.log(Level.WARNING, "有部分数据转换失败");
							//throw new Exception("数据转换失败！");
						}
					}
					count++;
					col.add(obj);
				} while (rs.next() && count<size);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return col;
	}

}
