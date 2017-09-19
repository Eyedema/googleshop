package core.products;

public class ProductDecorated extends ProductDecorator{
	
	public ProductDecorated(Product product) {
		super(product);
	}
	
	@Override
	public double getPrice(){
		double price = super.getPrice();
		price = this.sale(price);
		return price;
	}
	
	private double sale(double price){
		return price - (price*0.1);
	}

}
