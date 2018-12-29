package ar.com.flow.lambdas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string. If the last word does not exist, return 0.
 */
@RunWith(Parameterized.class)
public class LastWordTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"Abcd", "Abcd"},
				{"Abcd abc", "Abcd"},
				{"Abcd abcd", "abcd"},
				{"Abcd abcde", "abcde"}
		});
	}

	@Parameter(0)
	public String input;
	@Parameter(1)
	public String output;


	@Test
	public void testSingleWordWithoutSpaces() {
		LastWordFunction function = new LastWordFunction();
		assertThat(function.apply(input)).isEqualTo(output);
	}
}
