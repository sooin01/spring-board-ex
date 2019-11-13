package com.my.app.common.util;

import com.my.app.common.util.Constants.CODE_I;

public class CallConst {

	public static void main(String[] args) {

		System.out.println(CODE_I.CODE1);
		System.out.println(Constants.CODE_E.CODE1);
		System.out.println(Constants.CODE_E.CODE1.getCode());

		switch ("2") {
		case CODE_I.CODE1:
			System.out.println("a");
			break;
		case CODE_I.CODE2:
			System.out.println("b");
			break;
		}
	}

}
