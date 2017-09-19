package core.visitors;

import core.products.Item;
import core.products.Package;
import core.products.Product;

public interface Visitor {
	
	void visit(Product p);
	void visit(Package p);
	Item getResult();

}
