package ru.roman.task.devskiller.faker;


import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;


@Test
public class DefensiveVerificationTest {

	public void letterifyWithEmptyString() {
		//given
		Faker faker = new Faker();

		//when
		String result = faker.letterify("");

		//then
		assertThat(result).matches("");
	}

	public void letterifyWithNull() {
		//given
		Faker faker = new Faker();

		//when
		String result = faker.letterify(null);

		//then
		boolean nullOrEmpty = result == null || "".equals(result);
		assertTrue(nullOrEmpty);
	}

	public void numerifyWithEmptyString() {
		//given
		Faker faker = new Faker();

		//when
		String result = faker.numerify("");

		//then
		assertThat(result).matches("");
	}

	public void numerifyWithNull() {
		//given
		Faker faker = new Faker();

		//when
		String result = faker.numerify(null);

		//then
		boolean nullOrEmpty = result == null || "".equals(result);
		assertTrue(nullOrEmpty);
	}
}
