package com.my.app.common.util;

public class Constants {

	interface CODE_I {
		final String CODE1 = "1";
		final String CODE2 = "2";
	}

	enum CODE_E {
		CODE1("1"), CODE2("2");
		private String code;

		CODE_E(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}

}
