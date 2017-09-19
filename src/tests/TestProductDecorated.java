package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import core.categories.Wearable;
import core.products.ConcreteProduct;
import core.products.Product;
import core.products.ProductDecorated;
import core.visitors.ConcreteVisitor;
import core.visitors.Visitor;

public class TestProductDecorated {

	private Product product;

	@Before
	public void setUp() {
		product = new ProductDecorated(new ConcreteProduct(100, "test decorato", new Wearable()));
	}

	@Test
	public void testGetPrice() {
		assertEquals(90, product.getPrice(), 0);
	}

	@Test(expected=java.lang.Exception.class)
	public void testAdd() throws Exception {
		product.add(product);
	}

	@Test(expected=java.lang.Exception.class)
	public void testRemove() throws Exception {
		product.remove(product);
	}

	@Test
	public void testAccept() {
		Visitor v = new ConcreteVisitor();
		product.accept(v);
		assertEquals(90, v.getResult().getPrice(), 0);
	}

	@Test
	public void testGetCategory() {
		String category = new Wearable().getDesc();
		assertEquals(category, product.getCategory());
	}

	@Test
	public void testGetDesc() {
		assertEquals("test decorato", product.getDesc());
	}

	@Test
	public void testToString() {
		assertEquals("Product: Wearable - test decorato - 90.0$", product.toString());
	}

}
