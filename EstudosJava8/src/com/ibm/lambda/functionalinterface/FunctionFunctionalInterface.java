package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.function.Function;

public class FunctionFunctionalInterface {

	Function<String, DummyClassForTest> createDummy = dummy ->  new DummyClassForTest(dummy);
	
	private void testFunction(String nomeDummy) {
		DummyClassForTest dummy = createDummy.apply(nomeDummy);
		System.out.println("Dummy: " + dummy);
	}
	
//	public static void main(String[] args) throws IOException {
//
//		new FunctionFunctionalInterface().testFunction("testin");;
//	}
}
