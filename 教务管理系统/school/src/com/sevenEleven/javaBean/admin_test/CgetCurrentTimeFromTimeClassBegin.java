package com.sevenEleven.javaBean.admin_test;

public class CgetCurrentTimeFromTimeClassBegin {

	String timeClassNow = null; //

	public CgetCurrentTimeFromTimeClassBegin(String timeClassBegin,
			String timeClassUnit) {
		getCurrentTimeFromTimeClassBegin(timeClassBegin, timeClassUnit);
	}

	/**
	 * @auther Tim
	 * @exception 没有运用到日历类........只是简单的得到绝对时间,可读性不强,有待改进
	 * @function: 由开学时间和课程的时间片断得到课程的 精确时间.
	 * @return: timeClassNow (String) eg: A011420070101
	 * @from : timeClassUnit (String)eg:A0114 timeClassBegin (String)20060101
	 */
	public void getCurrentTimeFromTimeClassBegin(String timeClassBegin,
			String timeClassUnit) {

		timeClassNow = new String(); // 要返回的当前时间片断的绝对时间
		boolean isLeapYear = checkYearIsLeapYear(Integer.valueOf(
				timeClassBegin.substring(0, 4)).intValue()); // 是否闰年
		int sumDay = getSumDay(timeClassBegin, timeClassUnit, isLeapYear);// 两个时间的天数相加的总数
		int year = Integer.valueOf(timeClassBegin.substring(0, 4)).intValue(); // 当前的绝对的年
		year = year += isLeapYear ? sumDay / 366 : sumDay / 365;// 当前的绝对的年
		int month = this.getMonthFromSumDay(sumDay, isLeapYear); // 当前绝对的月
		int day = this.getDayFromSumDay(sumDay, isLeapYear); // 当前绝对的日
		String month1 = month>9 ? String.valueOf(month) : "0"+String.valueOf(month);//转String型
		String day1 = day>9 ? String.valueOf(day) : "0"+String.valueOf(day);
		timeClassNow = timeClassUnit + year + month1 + day1;                          //赋值
	}

	/**
	 * @auther Tim function: 是否是闰年,是返回true,否返回false name: check return:
	 *         boolean(trun/false)
	 */
	public boolean checkYearIsLeapYear(int year) {
		return ((0 == year % 4) && (0 != (year % 100))) || (0 == year % 400) ? true
				: false;
	}

	/**
	 * @auther Tim function: 当月有多少天,返回天数 name: dayOfTheMonth return: int how
	 *         many days of this month from month
	 */
	public int dayOfTheMonth(int month, boolean isLeapYear) {
		if (month == 2) {
			return isLeapYear ? 29 : 28;
		} else if (month == 4 || month == 6 || month == 10 || month == 12) {
			return 30;
		} else {
			return 31;
		}
	}

	/**
	 * @auther Tim
	 * @function: 开学时的天数 + 天数到现在经过的天数
	 * @name: dayOfTheMonth
	 * @return: int how many days of this month from month
	 */
	public int getSumDay(String timeClassBegin, String timeClassUnit,
			boolean isLeapYear) {
		int dayOfUnit = ((Integer.valueOf(timeClassUnit.substring(1, 3))
				.intValue() - 1) * 7 + Integer.valueOf(
				timeClassUnit.substring(3,4)).intValue()); // 例如timeClassUnit为A0214
		// 返回值为(2-1)*7+1
		int sumDay = 0;
		for (int i = 1; i < Integer.valueOf(timeClassBegin.substring(4, 6))
				.intValue(); i++) {// 遍历每个月得到总天数 20060301
			sumDay += dayOfTheMonth(i, isLeapYear); // 1月的31 + 2月的28
		}
		sumDay = sumDay + Integer.valueOf(timeClassBegin.substring(6, 8)) + dayOfUnit;
		return sumDay;
	}

	/**
	 * @auther Tim
	 * @function: 得到绝对的月份
	 * @name: getMonthFromSumDay
	 * @return: 得到绝对的月份
	 */
	public int getMonthFromSumDay(int sumDay, boolean isLeapYear) {
		int day = isLeapYear ? sumDay % 366 : sumDay % 365;
		int month;
		for (month = 1; day > dayOfTheMonth(month, isLeapYear); month++) {

		}
		return month;
	}

	/**
	 * @auther Tim
	 * @function: 得到绝对的日
	 * @name: getMonthFromSumDay
	 * @return: 得到绝对的日
	 */
	public int getDayFromSumDay(int sumDay, boolean isLeapYear) {
		int day = isLeapYear ? sumDay % 366 : sumDay % 365;
		int month;
		for (month = 1; day > dayOfTheMonth(month, isLeapYear); month++) {
			day -= dayOfTheMonth(month, isLeapYear);
		}
		return day;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getTimeClassNow() {
		return timeClassNow;
	}

	public void setTimeClassNow(String timeClassNow) {
		this.timeClassNow = timeClassNow;
	}

}
