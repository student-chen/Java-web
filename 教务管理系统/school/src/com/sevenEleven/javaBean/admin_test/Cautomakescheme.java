package com.sevenEleven.javaBean.admin_test;

import java.util.ArrayList;
import java.util.List;

public class Cautomakescheme {
	@SuppressWarnings("unchecked")
	public void Catomakescheme(String className, String phase) {
		@SuppressWarnings("unused")
		List timeClassUnitList = initTimeClassUnitList(phase);
	}
	@SuppressWarnings("unchecked")
	public List initTimeClassUnitList(String phase) {
		List timeClassUnitList = new ArrayList();
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 5; j++) { 
				for (int k = 1; k <= 4; k++) {
					CTimeClassUnit timeClassUnit = new CTimeClassUnit();
					if (i < 10) { 
						timeClassUnit.setTime(phase + "0" + String.valueOf(i)
								+ String.valueOf(j) + String.valueOf(k));
					} else {
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
		CgetCurrentTimeFromTimeClassBegin gctftc = new CgetCurrentTimeFromTimeClassBegin("20060105","A0124");
		String timeClassNow = gctftc.getTimeClassNow();
		System.out.print(timeClassNow);
	}
}
