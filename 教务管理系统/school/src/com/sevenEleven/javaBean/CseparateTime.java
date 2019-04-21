package com.sevenEleven.javaBean;

public class CseparateTime {
	private String year;         
	private String month;      
	private String timeUnit;        
	//private String timeClassUnit;      
	//private String timeClassNow;      
	private String time;          
	private char phase;
	private int week; 
	private int day; 
	private int course; 
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
			System.out.print("ʱ�䲻����");
			return;
		}
		int course = time.codePointAt(4) - 48;
		if (course > 4) { 
			System.out.print("ʱ�䲻����");
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
			System.out.print("ʱ�䲻����");
			return;
		}
		int day = time.codePointAt(3) - 48;//
		if (day > 7) {
			System.out.print("ʱ�䲻����");
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
			System.out.print("ʱ�䲻����");
			return;
		}
		char phase = time.charAt(0);
		if (phase > 'C' || phase < 'A') { 
			System.out.print("ʱ�䲻����");
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
			System.out.print("ʱ�䲻����");
			return;
		}
		int week = (time.codePointAt(1) - 48) * 10 + (time.codePointAt(2) - 48);
		if (week > 10) { 
			System.out.print("ʱ�䲻����");
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
		@SuppressWarnings("unused")
		StringBuffer sss = new StringBuffer();
		
	}



	
}
