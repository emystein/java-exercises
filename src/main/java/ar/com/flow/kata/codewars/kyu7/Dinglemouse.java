package ar.com.flow.kata.codewars.kyu7;

/**
 * http://www.codewars.com/kata/fixme-get-full-name/train/java
 */
public class Dinglemouse {
	private String fullName;

	public Dinglemouse(String firstName, String lastName) {
		fullName = (firstName + " " + lastName).trim();
	}

	public String getFullName() {
		return fullName;
	}
}