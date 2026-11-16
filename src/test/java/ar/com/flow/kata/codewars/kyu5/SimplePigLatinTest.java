package ar.com.flow.kata.codewars.kyu5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SimplePigLatinTest {
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"Pig latin is cool", "igPay atinlay siay oolcay"},
				{"Hello world !", "elloHay orldway !"},
				{"This is my string", "hisTay siay ymay tringsay"},
				{"V mKniL", "Vay KniLmay"},
				{"V mKniL ", "Vay KniLmay "}
		});
	}

	@ParameterizedTest
	@MethodSource("data")
	public void test(String input, String output) {
		assertThat(PigLatin.pigIt(input)).isEqualTo(output);
	}
}
