package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import core.cart.ConcreteCart;
import core.categories.Phone;
import core.products.ConcreteProduct;
import core.products.Item;
import core.products.Product;

public class TestConcreteCart {

	private ConcreteCart cart;
	private ArrayList<Item> cartList = new ArrayList<Item>();

	@Before
	public void setUp() {
		cart = new ConcreteCart();
		Product product1 = new ConcreteProduct(100, "test1", new Phone());
		Product product2 = new ConcreteProduct(100, "test2", new Phone());
		Product product3 = new ConcreteProduct(100, "test3", new Phone());
		cart.add(product1);
		cart.add(product2);
		cart.add(product3);
		cart.remove(product3);
		cartList.add(product1);
		cartList.add(product2);
	}

	@Test
	public void testGetCart() {
		assertArrayEquals(cartList.toArray(), cart.getCart().toArray());
	}

	@Test
	public void testGetPrice() {
		assertEquals(200.0, cart.getPrice(), 0.0);
	}

}
