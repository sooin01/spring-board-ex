package com.my.app.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class CmdUtil {

	public static void main(String[] args) throws Exception {
		String[] commonds = { "C:\\Users\\sooin\\Desktop\\hello.cmd", "parameter 1", "parameter 2" };
		Process process = Runtime.getRuntime().exec(commonds);
//		InputStream is = process.getErrorStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();

		boolean waitFor = process.waitFor(15, TimeUnit.SECONDS);
		System.out.println("waitFor: " + waitFor);
	}

}

//@echo off
//echo Parameter #1 %1
//echo Parameter #2 %2
//echo Parameter #X %*
//rem start java -jar "C:\Program Files\Java\jdk1.8.0_221\lib\jconsole.jar"
//
//cd C:\Users\sooin\Desktop
//"C:\Program Files\Java\jdk1.8.0_221\bin\java" Test