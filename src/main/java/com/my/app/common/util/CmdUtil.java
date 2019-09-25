package com.my.app.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class CmdUtil {

	public static void main(String[] args) throws Exception {
		String[] commonds = { "C:\\Users\\sooin\\Desktop\\hello.cmd", "parameter 1", "parameter 2" };
		Process process = Runtime.getRuntime().exec(commonds);

		String line = null;

		// 표준출력
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
		while ((line = br.readLine()) != null) {
			System.out.println("OUTPUT: " + line);
		}
		br.close();

		// 표준에러
		BufferedReader er = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
		while ((line = er.readLine()) != null) {
			System.out.println("ERROR: " + line);
		}
		er.close();

		boolean waitFor = process.waitFor(15, TimeUnit.SECONDS); // true면 정상종료. false면 timeout으로 인한 종료.
		int exitValue = process.exitValue(); // 0이면 정상. 그 외는 에러.
		System.out.println("waitFor: " + waitFor + ", exitValue: " + exitValue);
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
//
//exit 0(default)