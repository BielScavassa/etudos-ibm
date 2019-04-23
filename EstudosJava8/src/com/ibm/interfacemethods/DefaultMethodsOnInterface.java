package com.ibm.interfacemethods;

public interface DefaultMethodsOnInterface {
	
	default double mult(double a, double b) {
		return a*b;
	}
	
	default double squareRoot(double a) {
		return Math.sqrt(a);
	}
	
								//Main
//	DefaultMethodsOnInterface defaultMethod = new DefaultMethodsOnInterface() {
//	};
	
//	System.out.println(defaultMethod.squareRoot(12.5)); 	
}
