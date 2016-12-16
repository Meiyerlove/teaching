package org.yeeku;

import java.util.Date;

import org.yeeku.util.DateTimeUtil;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeUtil dtu = new DateTimeUtil();
		Date todayStart = dtu.getTodayStartDate();
		System.out.println(todayStart);

	}

}
