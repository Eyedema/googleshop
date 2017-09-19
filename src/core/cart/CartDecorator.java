package core.cart;

import java.util.ArrayList;

import core.products.Item;

public abstract class CartDecorator extends Cart {

	private Cart cart;

	public CartDecorator(Cart cart) {
		this.cart = cart;
	}

	@Override
	public void add(Item i) {
		cart.add(i);
	}

	@Override
	public void remove(Item i) {
		cart.remove(i);
	}

	@Override
	public ArrayList<Item> getCart() {
		return cart.getCart();
	}

	@Override
	public double getPrice() {
		return cart.getPrice();
	}

}
