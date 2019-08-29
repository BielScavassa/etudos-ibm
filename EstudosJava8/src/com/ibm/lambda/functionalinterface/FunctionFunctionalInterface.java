package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.function.Function;

import com.ibm.lambda.functionalinterface.models.DummyGerente;

public class FunctionFunctionalInterface {

	Function<String, DummyGerente> createDummy = dummy ->  new DummyGerente(dummy);
	
	private void testFunction(String nomeDummy) {
		DummyGerente dummy = createDummy.apply(nomeDummy);
		System.out.println("Dummy: " + dummy);
	}
	
//	public static void main(String[] args) throws IOException {
//
//		new FunctionFunctionalInterface().testFunction("testin");;
//	}
}
