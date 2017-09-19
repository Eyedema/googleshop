package core.products;

import core.categories.Category;

public class ConcreteProduct extends Product{
	
	public ConcreteProduct(double price, String desc, Category category) {
		super.setPrice(price);
		super.setDesc(desc);
		super.setCategory(category);
	}

}
