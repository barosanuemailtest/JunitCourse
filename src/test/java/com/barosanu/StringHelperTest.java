package com.barosanu;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {

	private StringHelper stringHelper; // Class under test

	@Before
	public void setUp() {
		stringHelper = new StringHelper();
	}

	@Test
	public void testUpperCase() {
		assertEquals("ABC", stringHelper.toUpperCase("Abc"));
	} 

	@Test
	public void testisAllUpperCase() {
		assertTrue(stringHelper.isAllUpperCase("ABC"));
	}
	
	@Test
	public void testArraySort() {
		int[] someArray = {1,2,4,3};
		int[] expected = {1,2,3,4};
		Arrays.sort(someArray);
		assertArrayEquals(someArray, expected);
	}

	@Test(expected = NullPointerException.class)
	public void testException() {
		stringHelper.isAllUpperCase(null);
	}

}
