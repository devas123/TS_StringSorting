package com.example;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class StringSortingTest {

	String strNull;
	StringSorting stringSortingNull;
	StringSorting stringSortingEmpty;
	StringSorting stringSortingThreeSpace;

	Comparator<String> arrayComparator;
	Comparator<Character> keyComparator;

	@Before
	public void setUp() throws Exception {
		arrayComparator = new DefaultComparator();
		keyComparator = new CharComparator();
		stringSortingNull = new StringSorting();
		stringSortingEmpty = new StringSorting("", arrayComparator, keyComparator);
		stringSortingThreeSpace = new StringSorting("   ", arrayComparator, keyComparator);
	}

	@Test
	public void testParseStringNull() {
		Assert.assertTrue(stringSortingNull.getMap().isEmpty());
	}

	@Test
	public void testParseStringEmpty() {
		Assert.assertTrue(stringSortingEmpty.getMap().isEmpty());
	}
	
	@Test
	public void testParseStringhreeSpace() {
		Assert.assertTrue(stringSortingThreeSpace.getMap().isEmpty());
	}

}
