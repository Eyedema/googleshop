package core.products;

import core.visitors.Visitor;

public abstract class ProductDecorator extends Product {

	private Product product;

	public ProductDecorator(Product product) {
		this.product = product;
	}

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
		return product.getPrice();
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public String getCategory() {
		return product.getCategory();
	}

	@Override
	public String getDesc() {
		return product.getDesc();
	}

	@Override
	public void setPrice(double price) {
		product.setPrice(price);
	}

	@Override
	public void setDesc(String desc) {
		product.setDesc(desc);
	}

	@Override
	public String toString() {
		return "Product: " + getCategory() + " - " + getDesc() + " - " + getPrice() + "$";
	}

}
