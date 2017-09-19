package core.cart;

public class CartDecorated extends CartDecorator {

	public CartDecorated(Cart cart) {
		super(cart);
	}

	@Override
	public double getPrice() {
		double price = super.getPrice();
		price = this.sale(price);
		return price;
	}

	private double sale(double price) {
		return price - (price * 0.1);
	}

}
