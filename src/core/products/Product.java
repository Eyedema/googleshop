package core.products;

import core.categories.Category;
import core.visitors.Visitor;

public abstract class Product implements Item {

	private String desc;
	private double price;
	private Category category;

	@Override
	public void add(Item i) throws Exception {
		throw new Exception("Can't add item.");
	}

	@Override
	public void remove(Item i) throws Exception {
		throw new Exception("Can't add item.");
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getCategory() {
		return category.getDesc();
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Product: " + getCategory() + " - " + getDesc() + " - " + getPrice() + "$";
	}

}
