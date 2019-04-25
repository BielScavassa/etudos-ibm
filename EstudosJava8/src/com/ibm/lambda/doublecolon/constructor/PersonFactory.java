package com.ibm.lambda.doublecolon.constructor;

public interface PersonFactory<person extends Person> {

	person create(String firstName, String lastName);
}
