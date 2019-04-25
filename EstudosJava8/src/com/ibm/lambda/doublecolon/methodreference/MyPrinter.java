package com.ibm.lambda.doublecolon.methodreference;

public class MyPrinter {

	public void printString(String str, Parser parser) {
		str = parser.stringParser(str);
		System.out.println(str);
	}
}

//			Main
//	StringParser sp = new StringParser();
//	MyPrinter mp = new MyPrinter();
//	String str = "ty";

// mp.printString(str, (sp :: StringConvert));
