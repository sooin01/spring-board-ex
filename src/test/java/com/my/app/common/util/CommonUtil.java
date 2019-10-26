package com.my.app.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CommonUtil {

	@Test
	public void testCheckValidPassword() {
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{10,}$";
		String input = "12345qwert!23";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		System.out.println(matcher.matches());
	}

}
