package ar.com.flow.lambdas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. If the last word does not exist, return 0.
 */
public class LastWordTest {
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"Abcd", "Abcd"},
				{"Abcd abc", "Abcd"},
				{"Abcd abcd", "abcd"},
				{"Abcd abcde", "abcde"}
		});
	}

	@ParameterizedTest
	@MethodSource("data")
	public void testSingleWordWithoutSpaces(String input, String output) {
		LastWordFunction function = new LastWordFunction();
		assertThat(function.apply(input)).isEqualTo(output);
	}
}
