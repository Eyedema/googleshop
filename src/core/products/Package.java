package core.products;

import java.util.ArrayList;
import java.util.Iterator;

import core.visitors.Visitor;

public class Package implements Item {

	private ArrayList<Item> pack;
	private double price;
	private String desc;

	public Package(String desc) {
		pack = new ArrayList<Item>();
		this.desc = desc;
	}

	@Override
	public void add(Item i) throws Exception {
		pack.add(i);
		price += i.getPrice(); 
	}

	@Override
	public void remove(Item i) throws Exception {
		pack.remove(i);
		price -= i.getPrice();
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getCategory() {
		return "Package";
	}

	@Override
	public String getDesc() {
		return desc;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	public Iterator<Item> getIterator() {
		return pack.iterator();
	}

	@Override
	public String toString() {
		return "Package: " + desc + " - " + price + "$";
	}

}
