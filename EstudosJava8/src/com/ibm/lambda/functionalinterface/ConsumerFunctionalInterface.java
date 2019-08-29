package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.function.Consumer;

import com.ibm.lambda.functionalinterface.models.DummyGerente;

public class ConsumerFunctionalInterface {

	Consumer<DummyGerente> printNome = dummy -> System.out.println("Nome: " + dummy.getNome());
	Consumer<DummyGerente> persistDummy = dummy -> persist(dummy);
	
	private void testConsumer(DummyGerente dummy) {
		printNome.accept(dummy); 
		persistDummy.accept(dummy);
	}

	private void persist(DummyGerente dummy) {
		System.out.println("Persisting dummy: " + dummy.toString());
	}
	
	private void testAndThen(DummyGerente dummy) {
		Consumer<DummyGerente> printAndPersistDummy = printNome.andThen(persistDummy);
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
