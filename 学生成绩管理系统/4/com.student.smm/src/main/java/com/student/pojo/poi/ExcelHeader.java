/**
 * Copyright (c) 2008-2013 by DHCC
 * All rights reserved.
 */

package com.student.pojo.poi;

/**
 * 用来存储Excel标题的对象，通过该对象可以获取标题和方法的对应关系
 * @author <a href="mailto:zhangyanyu@dhcc.com.cn">zhangyanyu</a>
 * @date 2013-7-18
 */
public class ExcelHeader implements Comparable<ExcelHeader>{
    /**
     * 标题的名称
     */
    private String title;
    /**
     * 每一个标题的顺序
     */
    private int order;
    /**
     * 所对应的的方法名称
     */
    private String methodName;
    
    public ExcelHeader(String title, int order, String methodName) {
        this.title = title;
        this.order = order;
        this.methodName = methodName;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public int compareTo(ExcelHeader o) {
        return order>o.order?1:(order<o.order?-1:0);
    }

    public String toString() {
        return "ExcelHeader [title=" + title + ", order=" + order + ", methodName=" + methodName + "]";
    }
    
}
