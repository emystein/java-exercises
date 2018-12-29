package ar.com.flow.kata.codewars.kyu5;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;

public class PigLatin {
	public static String pigIt(String input) {
		String piggedWords = Arrays.stream(input.split(" "))
									.map(word -> moveFirstLetterToEnd(word))
									.map(word -> addAy(word))
									.collect(joining(" "));

		return (input.endsWith(" ")) ? piggedWords + " " : piggedWords;
	}

	private static String moveFirstLetterToEnd(String word) {
		return (word.length() > 1) ? word.substring(1) + word.substring(0, 1) : word;
	}

	private static String addAy(String string) {
		return isWord(string) ? string + "ay" : string;
	}

	private static boolean isWord(String string) {
		return string.matches("\\b.*\\b");
	}
}
