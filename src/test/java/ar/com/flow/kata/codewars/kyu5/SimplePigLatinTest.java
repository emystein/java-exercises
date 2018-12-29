package ar.com.flow.kata.codewars.kyu5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SimplePigLatinTest {
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"Pig latin is cool", "igPay atinlay siay oolcay"},
				{"Hello world !", "elloHay orldway !"},
				{"This is my string", "hisTay siay ymay tringsay"},
				{"V mKniL", "Vay KniLmay"},
				{"V mKniL ", "Vay KniLmay "}
		});
	}

	@Parameterized.Parameter(0)
	public String input;
	@Parameterized.Parameter(1)
	public String output;

	@Test
	public void test() {
		assertThat(PigLatin.pigIt(input)).isEqualTo(output);
	}
}
