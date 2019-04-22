package com.ibm.lambda;

public interface InterfaceFunctional {

	//Functional interface sempre irão ter apenas 1 unico método abstrato, mas quantos Default e Static methods desejar.
	
//	public void apply();
	
//	public void applyWithOneParam(String firstParam);
	
//	public void applyWithTwoParams(String firstParam, String secondParam);
	
	public String applyWithReturn(String firstParam, String secondParam);
	
	
								//Main
	//Void without params
//	InterfaceFunctional myInterface = () -> {System.out.println("teste");	}; ou
//	InterfaceFunctional myInterface = () -> System.out.println("teste"); pq está em uma unica linha e n possui retorno.
	
//	myInterface.apply();
	
	//Void with one param
//	InterfaceFunctional myInterface = text -> System.out.println(text);
	
//	myInterface.applyWithOneParam("param1");
	
	//Void with two params
//	InterfaceFunctional myInterface = (text1, text2) -> System.out.println(text1 + "+" + text2);
	
//	myInterface.applyWithTwoParams("param1", "param2");
	
	//Return String with two params
//	InterfaceFunctional myInterface = (text1, text2) -> {return (text1 + "+" + text2); };
	
//	String result = myInterface.applyWithReturn("param1", "param2");
//	System.out.println(result);
	

}
