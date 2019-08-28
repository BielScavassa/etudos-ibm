package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunctionalInterface {

	static DummyClassForTest dummy = new DummyClassForTest("00", 12, "Dummy", true, true);
	static Predicate<DummyClassForTest> dummyAtivo = dummy -> dummy.getAtivo().equals(true);
	static Predicate<DummyClassForTest> dummyInativo = dummy -> dummy.getAtivo().equals(false);
	static Predicate<DummyClassForTest> dummyExecutivo = dummy -> dummy.getId().startsWith("EXE") ? true : false;

	// Logical And
	static Predicate<DummyClassForTest> dummyExecutivoAtivo = dummyExecutivo.and(dummyAtivo);

	// Logical Or
	static Predicate<DummyClassForTest> dummyExecutivoOrAtivo = dummyExecutivo.or(dummyAtivo);

	// Logical And e Or
	static Predicate<DummyClassForTest> dummyAtivoOrInativoExecutivo = dummyAtivo.or(dummyInativo).and(dummyExecutivo);

	// Logical Negate
	static Predicate<DummyClassForTest> dummyInativoNegate = dummyAtivo.negate();

	// Logical Equals
	static Predicate<DummyClassForTest> dummyExisteNalista = Predicate.isEqual(dummy);

//	public static void main(String[] args) throws IOException {
//
//		List<DummyClassForTest> dummyes = new ArrayList<DummyClassForTest>();
//
//		dummyes.add(dummy);
//
//		for (DummyClassForTest dum : dummyes) {
//			if (dummyExisteNalista.test(dum))
//				System.out.println("Dummy Existente: " + dum);
//		}
//	}
}
