package com.my.app.common.util;

import java.security.SecureRandom;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoUtil {

	public static void main(String[] args) throws Exception {
		SecureRandom random = new SecureRandom();
		
		LocalDate ld = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(ld.getDayOfYear()));
		}
		
		List<List<String>> lottoList = new ArrayList<>();
		
		for (Integer i : list) {
			int index = 0;
			List<String> lottoSubList = new ArrayList<>();

			while (true) {
				if (index++ != i) {
					continue;
				}
				
				for (int j = 0; j < 6; j++) {
					String nextInt = Integer.toString(random.nextInt(45) + 1);
					
					if (!lottoSubList.contains(nextInt)) {
						lottoSubList.add(nextInt);
					} else {
						j--;
					}
				}
				
				lottoSubList.sort(new Comparator<String>() {
					@Override
					public int compare(String s1, String s2) {
						return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
					}
				});
				
				lottoList.add(lottoSubList);
				
				break;
			}
		}
		
		for (List<String> lottoSubList : lottoList) {
			System.out.println(String.join(", ", lottoSubList));
		}
	}
	
}
