package com.ibm.lambda.doublecolon.constructor;

public class Person {

	String firstName;
	String lastName;
	
	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}


//			Main
//PersonFactory<Person> personFactory = Person::new;
//Person person = personFactory.create("Jose", "Miolo");

//System.out.println(person);