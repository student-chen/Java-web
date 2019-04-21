/**
 * Copyright (c) 2008-2013 by DHCC
 * All rights reserved.
 */

package com.student.pojo.poi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 用来在对象的get方法上加入的annotation，通过该annotation说明某个属性所对应的标题
 * 
 * @author <a href="mailto:zhangyanyu@dhcc.com.cn">zhangyanyu</a>
 * @date 2013-7-18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExcelResources {
    /**
     * 属性的标题名称
     */
    String title();
    /**
     * 在Excel中的顺序
     */
    int order() default 9999;
}
