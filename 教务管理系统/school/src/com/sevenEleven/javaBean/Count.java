package com.sevenEleven.javaBean;

public class Count {
	private static long count = 0;

	public static long getOnline() {
		return count;
	}

	public static void raise() {
		count++;
	}

	public static void reduce() {
		count--;
	}
}
