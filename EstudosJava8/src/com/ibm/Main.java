package com.ibm;

import com.ibm.lambda.InterfaceFunctional;

public class Main {

	public static void main(String[] args) {
		
		InterfaceFunctional myInterface = (text1, text2) -> {return (text1 + "+" + text2); };
		
		String result = myInterface.applyWithReturn("param1", "param2");
		System.out.println(result);
		
	}
}
