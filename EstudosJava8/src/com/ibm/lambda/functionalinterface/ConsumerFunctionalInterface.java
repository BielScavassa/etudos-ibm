package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.function.Consumer;

public class ConsumerFunctionalInterface {

	Consumer<DummyClassForTest> printNome = dummy -> System.out.println("Nome: " + dummy.getNome());
	Consumer<DummyClassForTest> persistDummy = dummy -> persist(dummy);
	
	private void testConsumer(DummyClassForTest dummy) {
		printNome.accept(dummy); 
		persistDummy.accept(dummy);
	}

	private void persist(DummyClassForTest dummy) {
		System.out.println("Persisting dummy: " + dummy.toString());
	}
	
	private void testAndThen(DummyClassForTest dummy) {
		Consumer<DummyClassForTest> printAndPersistDummy = printNome.andThen(persistDummy);
		printAndPersistDummy.accept(dummy);
	}
	
	//Main
//	public static void main(String[] args) throws IOException {
//
//		DummyClassForTest dummy = new DummyClassForTest("00", 12, "Dummy", true, true);
//		new ConsumerFunctionalInterface().testConsumer(dummy);
//		new ConsumerFunctionalInterface().testAndThen(dummy);
//	}
}
