package com.sevenEleven.javaBean.admin_test;

import java.util.ArrayList;
import java.util.List;

public class Cautomakescheme {

	/**
	 * 自动排课第三步: 给每个班时间片断加上教室和(老师-课程), 自动排课分为排周,排天,到排每一节课.层层递进的关系.
	 * 
	 * 1.如果取出的教室不为空,则给班分配一个随机的教室. 如果为空,这节课就不上了.
	 * 2.如果取出的(老师-课程)在前6堂课内上过就查看下一个(老师-课程)链表.
	 * 
	 * @return
	 * 
	 */
	public void Catomakescheme(String className, String phase) {
		@SuppressWarnings("unused") List timeClassUnitList = initTimeClassUnitList(phase);
	}

	/**
	 * @auther Tim
	 * @return List function: 由阶段A得到这个阶段 十周的时间片断序列,用List存放
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List initTimeClassUnitList(String phase) {
		List timeClassUnitList = new ArrayList();
		for (int i = 1; i <= 10; i++) { // 10周
			for (int j = 1; j <= 5; j++) { // 1个星期的前5天
				for (int k = 1; k <= 4; k++) {// 每天的4节课
					CTimeClassUnit timeClassUnit = new CTimeClassUnit();
					if (i < 10) { // 一位数时得到的时间
						timeClassUnit.setTime(phase + "0" + String.valueOf(i)
								+ String.valueOf(j) + String.valueOf(k));
					} else { // 二位数时得到的时间
						timeClassUnit.setTime(phase + String.valueOf(i)
								+ String.valueOf(j) + String.valueOf(k));
					}
					timeClassUnitList.add(timeClassUnit);
				}
			}
		}
		return timeClassUnitList;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * @auther Tim
		 * @exception 没有运用到日历类........只是简单的得到绝对时间,可读性不强,有待改进
		 * @function: 由开学时间和课程的时间片断得到课程的 精确时间.
		 * @return: timeClassNow (String) eg: A011420070101
		 * @from : timeClassUnit (String)eg:A0114 timeClassBegin (String)20060101
		 */
		CgetCurrentTimeFromTimeClassBegin gctftc = new CgetCurrentTimeFromTimeClassBegin("20060105","A0124");
		String timeClassNow = gctftc.getTimeClassNow();
		System.out.print(timeClassNow);
	}

}
