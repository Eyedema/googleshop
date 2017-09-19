package core.visitors;

import java.util.Iterator;

import core.products.ConcreteProduct;
import core.products.Item;
import core.products.Package;
import core.products.Product;

public class ConcreteVisitor implements Visitor {

	private Item item;

	@Override
	public void visit(Product p) {
		item = p;
	}

	@Override
	public void visit(Package p) {
		Iterator<Item> it = p.getIterator();
		Item maxPricedItem = new ConcreteProduct(0.0, "", null);
		while (it.hasNext()) {
			Item current = it.next();
			if (current.getPrice() > maxPricedItem.getPrice()) {
				maxPricedItem = current;
			}
		}
		item = maxPricedItem;
	}

	@Override
	public Item getResult() {
		return item;
	}

}
