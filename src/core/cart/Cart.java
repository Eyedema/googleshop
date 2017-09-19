package core.cart;

import java.util.ArrayList;

import core.products.Item;

public abstract class Cart {

	private ArrayList<Item> cart;
	private double price;

	public Cart() {
		cart = new ArrayList<Item>();
	}

	public void add(Item i) {
		cart.add(i);
		price += i.getPrice();
	}

	public void remove(Item i) {
		cart.remove(i);
		price -= i.getPrice();
	}

	public void removeAll() { 
		cart = new ArrayList<Item>();
		price = 0;
	}

	public ArrayList<Item> getCart() {
		return cart;
	}

	public double getPrice() {
		return price;
	}

}
