package com.my.app.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
	
	private static String betweenDate;

	public static void main(String[] args) throws Exception {
		String[] betweenDates = {
				"2007.08.06 ~ 2010.01.31",
				"2010.05.01 ~ 2011.11.30",
				"2011.12.01 ~ 2011.12.31",
				"2011.01.12 ~ 2011.03.30",
				"2012.05.16 ~ 2013.06.28",
				"2013.09.02 ~ 2013.12.06",
				"2014.01.13 ~ 2014.07.25",
				"2014.08.04 ~ 2014.10.31",
				"2014.11.13 ~ 2015.03.27",
				"2015.04.29 ~ 2016.04.30",
				"2016.05.30 ~ 2016.08.29",
				"2016.09.19 ~ 2016.09.30",
				"2016.10.04 ~ 2017.02.03",
				"2017.02.20 ~ 2019.06.30",
				"2019.08.01 ~ 2019.12.15",
				"2020.01.15 ~ 2020.08.07",
		};
		
		long sum = 0;
		for (String s : betweenDates) {
			betweenDate = s;
			sum += getBetweenTwoDate(s);
		}
		
		betweenDate = "총";
		printDays(sum);
	}
	
	private static long getBetweenTwoDate(String betweenDate) throws Exception {
		if (betweenDate == null || betweenDate.trim().isEmpty()) {
			return 0;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		Date startDate = format.parse(betweenDate.split(" ~ ")[0]);
		Date endDate = format.parse(betweenDate.split(" ~ ")[1]);
		
		long diffInMillies = endDate.getTime() - startDate.getTime();
		long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		printDays(days);
		
		return days;
	}
	
	private static void printDays(long days) throws Exception {
//		System.out.println(betweenDate + " => " + (days + 1) + "일");
//		System.out.println(betweenDate + " => " + (days + 1) / 30 + "개월 " + (days + 1) % 30 + "일");
		System.out.println(betweenDate + " => " + (days + 1) / 30 / 12 + "년 " + (days + 1) / 30 % 12 + "개월 " + (days + 1) % 30 % 12 + "일");
	}
	
}
