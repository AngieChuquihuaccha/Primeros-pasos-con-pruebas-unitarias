/*
 * Copyright 2015-2022 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Antes de la clase");
	}

	@BeforeEach
	static void beforeEach() {
		System.out.println("Antes de cada método");
	}

	@Test
	@DisplayName("2 + 1 = 3")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(2, 1), "2 + 1 should equal 3");
	}
	@Disabled("Se deshabilitó hasta que se arregle el bug 543")
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

	@AfterEach
	static void afterEach() {
		System.out.println("Después de cada método");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Después de todos los métodos de la clase");
	}
}
