package ar.com.flow.kata.codewars.kyu7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DinglemouseTest {

	@Test
	public void firstAndLastName() {
		assertThat(new Dinglemouse("Clint", "Eastwood").getFullName()).isEqualTo("Clint Eastwood");
	}

	@Test
	public void emptyFirstOrLastName() {
		assertThat(new Dinglemouse("", "").getFullName()).isEqualTo("");
	}

	@Test
	public void noLastName() {
		assertThat(new Dinglemouse("Clint", "").getFullName()).isEqualTo("Clint");
	}

	@Test
	public void noFirstName() {
		assertThat(new Dinglemouse("", "Eastwood").getFullName()).isEqualTo("Eastwood");
	}
}