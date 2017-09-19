package core.products;

import core.visitors.Visitor;

public interface Item {
	
	void add(Item i) throws Exception;
	void remove(Item i) throws Exception;
	double getPrice();
	void accept(Visitor v);
	String getCategory();
	String getDesc();

}
