package com.sevenEleven.javaBean;

/**
 *@auther Tim
 * 实现把一定规则的表示时间的字符串分解成特定的时间。
 *    如:A011420070101  A阶段1周星期1第4堂课,2007年1月1号  
 */
public class CseparateTime {
	private String year;         //每年   如2007年
	
	private String month;        //每月
	
	private String timeUnit;        //最小时间单位. 如 420070101   是2007年的1月1号的第4堂课
	
	//private String timeClassUnit;       //对于每个班来说的最小时间单位 如A0114  就是A阶段的第1周星期1的第4堂课
	
	//private String timeClassNow;       //由开班时间得到的时间  如20070101 + 1周后 = 20070108
	
	private String time;            //标准时间,存放在数据库上的时间   如:A011420070101  A阶段1周星期1第4堂课,2007年1月1号  
	
	private char phase; // 每阶段，如2030的A，B，C阶段(A,B,C)只能是大写。

	private int week; // 每星期，如2030的一个阶段的10个星期(1,2,3,4,5,6,7,8,9,10)

	private int day; // 每天，day=1表示星期一 day(1,2,3,4,5,6,7)

	private int course; // 每节课， course(1,2,3,4) 1代表1、2节课， 2代表3、4节课， 3代表5、6节课，

	// 4代表7、8节课

	public CseparateTime(String time) {
		this.setTime(time);
		this.setPhase(time);
		this.setWeek(time);
		this.setDay(time);
		this.setCourse(time);
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public void setCourse(String time) {
		if (time.length() != 13) {
			System.out.print("时间不规则");
			return;
		}
		int course = time.codePointAt(4) - 48;// 得到的是codePoint码的值
		if (course > 4) { // 每天的课程不能大于4
			System.out.print("时间不规则");
			return;
		}
		this.course = course;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setDay(String time) {
		if (time.length() != 13) {
			System.out.print("时间不规则");
			return;
		}
		int day = time.codePointAt(3) - 48;//
		if (day > 7) {// 天数不能大于7
			System.out.print("时间不规则");
			return;
		}
		this.day = day;
	}

	public char getPhase() {
		return phase;
	}

	public void setPhase(char phase) {
		this.phase = phase;
	}

	public void setPhase(String time) {
		if (time.length() != 13) {
			System.out.print("时间不规则");
			return;
		}
		char phase = time.charAt(0);// 得到的是codePoint码的值
		if (phase > 'C' || phase < 'A') { // 阶段只能是A、B、C
			System.out.print("时间不规则");
			return;
		}
		this.phase = phase;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public void setWeek(String time) {
		if (time.length() != 13) {
			System.out.print("时间不规则");
			return;
		}
		int week = (time.codePointAt(1) - 48) * 10 + (time.codePointAt(2) - 48);
		if (week > 10) { // 每阶段不超过10周
			System.out.print("时间不规则");
			return;
		}
		this.week = week;
	}


	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(String timeUnit) {
		this.timeUnit = timeUnit;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	

	public static void main(String[] args) {
		CseparateTime timeToString = new CseparateTime("B1034");
		int course = timeToString.getCourse();
		char Phase = timeToString.getPhase();
		int week = timeToString.getWeek();
		int day = timeToString.getDay();
		System.out.println(Phase);
		System.out.println(week);
		System.out.println(day);
		System.out.println(course);
		StringBuffer sss = new StringBuffer();
		
	}



	
}
