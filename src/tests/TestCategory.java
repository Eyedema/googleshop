package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.categories.Category;
import core.categories.Phone;
import core.categories.Tablet;
import core.categories.Wearable;

public class TestCategory {

	Category category1;
	Category category2;
	Category category3;

	@Before
	public void setUp() {
		category1 = new Phone();
		category2 = new Tablet();
		category3 = new Wearable();
	}

	@Test
	public void testGetDesc() {
		assertEquals("Phone", category1.getDesc());
	}

	@Test
	public void testPhone() {
		assertEquals("Category: Phone", category1.toString());
	}

	@Test
	public void testTablet() {
		assertEquals("Category: Tablet", category2.toString());
	}

	@Test
	public void testWearable() {
		assertEquals("Category: Wearable", category3.toString());
	}

}
