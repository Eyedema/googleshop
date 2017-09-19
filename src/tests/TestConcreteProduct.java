package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import core.categories.Category;
import core.categories.Tablet;
import core.products.ConcreteProduct;
import core.products.Product;
import core.visitors.ConcreteVisitor;
import core.visitors.Visitor;

public class TestConcreteProduct {

	private Product product;
	private Category category;

	@Before
	public void setUp() {
		category = new Tablet();
		product = new ConcreteProduct(100, "test product", category);
	}

	@Test(expected = java.lang.Exception.class)
	public void testAdd() throws Exception {
		product.add(product);
	}

	@Test(expected = java.lang.Exception.class)
	public void testRemove() throws Exception {
		product.remove(product);
	}

	@Test
	public void testGetPrice() {
		assertEquals(product.getPrice(), 100, 0.0);
	}

	@Test
	public void testAccept() {
		Visitor v = new ConcreteVisitor();
		product.accept(v);
		assertEquals(product, v.getResult());
	}

	@Test
	public void testGetCategory() {
		String categoryTmp = product.getCategory();
		assertEquals(categoryTmp, this.category.getDesc());
	}

	@Test
	public void testGetDesc() {
		assertEquals("test product", product.getDesc());
	}

	@Test
	public void testToString() {
		assertEquals("Product: Tablet - test product - 100.0$", product.toString());
	}

}
