package com.ibm.lambda.doublecolon.methodreference;

public class StringParser {

	public String StringConvert(String str) {
		if (str.length() <= 3) {
			str = str.toUpperCase();
		} else {
			str = str.toLowerCase();
		}

		return str;
	}
}
