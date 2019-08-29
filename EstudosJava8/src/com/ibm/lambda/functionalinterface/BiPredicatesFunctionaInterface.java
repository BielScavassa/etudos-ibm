package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.function.BiPredicate;

import com.ibm.lambda.functionalinterface.models.DummyFuncionario;
import com.ibm.lambda.functionalinterface.models.DummyGerente;

public class BiPredicatesFunctionaInterface {

	BiPredicate<DummyFuncionario, DummyGerente> gerenteFuncionarioPredicate = 
			(func,ger) -> func.getGerente().equals(ger) ? true : false;
			
	public void testBiPredicate(DummyFuncionario funcionario, DummyGerente gerente) {
		Boolean isGerente = gerenteFuncionarioPredicate.test(funcionario, gerente);
		System.out.println("É Gerente ? " + isGerente);
	}
	
	
//	public static void main(String[] args) throws IOException {
//
//		DummyGerente dummyGerente = new DummyGerente("Gerente");
//		DummyFuncionario dummyFuncionario = new DummyFuncionario(10, "Funcionario", true, dummyGerente);
//		
//		new BiPredicatesFunctionaInterface().testBiPredicate(dummyFuncionario, dummyGerente);
//	}
}
