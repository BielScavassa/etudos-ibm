package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.ibm.lambda.functionalinterface.models.DummyGerente;

public class PredicateFunctionalInterface {

	static DummyGerente dummy = new DummyGerente("00", 12, "Dummy", true, true);
	static Predicate<DummyGerente> dummyAtivo = dummy -> dummy.getAtivo().equals(true);
	static Predicate<DummyGerente> dummyInativo = dummy -> dummy.getAtivo().equals(false);
	static Predicate<DummyGerente> dummyExecutivo = dummy -> dummy.getId().startsWith("EXE") ? true : false;

	// Logical And
	static Predicate<DummyGerente> dummyExecutivoAtivo = dummyExecutivo.and(dummyAtivo);

	// Logical Or
	static Predicate<DummyGerente> dummyExecutivoOrAtivo = dummyExecutivo.or(dummyAtivo);

	// Logical And e Or
	static Predicate<DummyGerente> dummyAtivoOrInativoExecutivo = dummyAtivo.or(dummyInativo).and(dummyExecutivo);

	// Logical Negate
	static Predicate<DummyGerente> dummyInativoNegate = dummyAtivo.negate();

	// Logical Equals
	static Predicate<DummyGerente> dummyExisteNalista = Predicate.isEqual(dummy);

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
