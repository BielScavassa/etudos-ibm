package com.ibm.lambda.functionalinterface;

import java.io.IOException;
import java.util.function.Supplier;

public class SupplierFunctionalInterface {

	Supplier<String[]> supplierDeFrutas = () -> new String[] {"Maca", "Laranja", "Uva"};
	
	private void testeSuplier() {
		String[] frutas = supplierDeFrutas.get();
		
		for(String fruta : frutas) {
			System.out.println("Fruta: " + fruta);
		}
	}
	
//	public static void main(String[] args) throws IOException {
//
//		new SupplierFunctionalInterface().testeSuplier();
//	}
}
