package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.categories.*;
import core.products.*;
import core.products.Package;
import core.visitors.ConcreteVisitor;
import core.visitors.Visitor;

public class TestPackage {
	
	private Package pack1;
	
	@Before
	public void setUp() throws Exception{
		pack1 = new Package("pack test1");
		Product product1 = new ConcreteProduct(100, "test item1", new Phone());
		Product product2 = new ConcreteProduct(100, "test item2", new Tablet());
		Product product3 = new ConcreteProduct(100, "test item3", new Wearable());
		pack1.add(product1);
		pack1.add(product2);
		pack1.add(product3);
		Package pack2 = new Package("pack test2");
		pack2.add(product1);
		pack1.add(pack2);
	}

	@Test
	public void testGetPrice() {
		assertEquals(400, pack1.getPrice(), 0.0);
	}

	@Test
	public void testGetCategory() {
		assertEquals("Package", pack1.getCategory());
	}

	@Test
	public void testGetDesc() {
		assertEquals("pack test1", pack1.getDesc());
	}

	@Test
	public void testAccept() {
		Visitor v = new ConcreteVisitor();
		pack1.accept(v);
		assertEquals(100, v.getResult().getPrice(), 0.0);
	}

	@Test
	public void testToString() {
		assertEquals("Package: pack test1 - 400.0$", pack1.toString());
	}

}
