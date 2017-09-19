package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import core.cart.Cart;
import core.cart.ConcreteCart;
import core.categories.Phone;
import core.categories.Tablet;
import core.categories.Wearable;
import core.products.ConcreteProduct;
import core.products.Item;
import core.products.Package;
import core.products.ProductDecorated;
import core.visitors.ConcreteVisitor;
import core.visitors.Visitor;

@SuppressWarnings({ "serial" })
public class ShopWindow extends JFrame implements ActionListener {

	private SpinnerNumberModel snm5x = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
	private SpinnerNumberModel snm6p = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
	private SpinnerNumberModel snm6 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
	private SpinnerNumberModel snm9 = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
	private SpinnerNumberModel snmp = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
	private SpinnerNumberModel snma = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
	private SpinnerNumberModel snml = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
	private JSpinner nexus5xSP = new JSpinner(snm5x);
	private JSpinner nexus6pSP = new JSpinner(snm6p);
	private JSpinner nexus6SP = new JSpinner(snm6);
	private JSpinner nexus9xSP = new JSpinner(snm9);
	private JSpinner packxSP = new JSpinner(snmp);
	private JSpinner asusSP = new JSpinner(snma);
	private JSpinner lgSP = new JSpinner(snml);
	private Item nexus5x = new ConcreteProduct(479.0, "Nexus 5X", new Phone());
	private Item nexus6p = new ConcreteProduct(649.0, "Nexus 6P", new Phone());
	private Item nexus6 = new ProductDecorated(new ConcreteProduct(349.0, "Nexus 6", new Phone()));
	private Item nexus9 = (new ConcreteProduct(389.0, "Nexus 9", new Tablet()));
	private Item pack = new Package("Nexus 9 + Nexus 6P");
	private Item asuswatch = new ConcreteProduct(199.0, "Asus ZenWatch", new Wearable());
	private Item lgwatch = new ConcreteProduct(199.0, "Lg Watch", new Wearable());
	private Cart cartObj;
	private JButton categoryPhone;
	private JButton categoryTablet;
	private JButton categoryWearable;
	private JButton cartButton;
	private JPanel rightPanelPhone = createPhonePanel();
	private JPanel rightPanelTablet = createTabletPanel();
	private JPanel rightPanelWearable = createWearablePanel();
	private JPanel rightPanelCart;
	private JButton btnAddToCart;
	private JButton button;
	private JButton button_1;
	private JButton addPack;
	private JButton addNexus9;
	private JButton remove;
	private JButton infon5x;
	private JButton infon6p;
	private JButton infon6;
	private JButton infon9;
	private JButton infop;
	private JButton infoas;
	private JButton infolg;
	private boolean phone = false;
	private boolean tablet = false;
	private boolean wearable = false;
	private boolean cart = false;
	private JButton addAsus;
	private JButton addLg;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JButton clear;
	private JButton pay;
	private DefaultListModel<Item> listModel = new DefaultListModel<Item>();
	private JList<Item> list;
	private JScrollPane js;
	private Visitor v;

	public static void main(String[] args) throws Exception {
		ShopWindow shop = new ShopWindow();
		shop.setVisible(true);
	}

	public ShopWindow() throws Exception {
		setTitle("Google Store");
		setFont(new Font("Roboto Regular", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1024, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		init();
	}

	public void init() throws Exception {
		cartObj = new ConcreteCart();
		JPanel leftPanel = createLeftPanel();
		getContentPane().add(leftPanel);
		categoryPhone.doClick();
		rightPanelCart = createRightCartPanel();
		v = new ConcreteVisitor();
	}

	public Cart getCart() {
		return cartObj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(categoryPhone)) {
			if (tablet) {
				getContentPane().remove(rightPanelTablet);
				repaint();
				tablet = false;
			}
			if (cart) {
				getContentPane().remove(rightPanelCart);
				repaint();
				cart = false;
			}
			if (wearable) {
				getContentPane().remove(rightPanelWearable);
				repaint();
				wearable = false;
			}
			if (!phone) {
				phone = true;
				getContentPane().add(rightPanelPhone);
				repaint();
			}
		}
		if (e.getSource().equals(categoryTablet)) {
			if (phone) {
				getContentPane().remove(rightPanelPhone);
				repaint();
				phone = false;
			}
			if (cart) {
				getContentPane().remove(rightPanelCart);
				repaint();
				cart = false;
			}
			if (wearable) {
				getContentPane().remove(rightPanelWearable);
				repaint();
				wearable = false;
			}
			if (!tablet) {
				tablet = true;
				getContentPane().add(rightPanelTablet);
				revalidate();
				repaint();
			}
		}
		if (e.getSource().equals(categoryWearable)) {
			if (phone) {
				getContentPane().remove(rightPanelPhone);
				repaint();
				phone = false;
			}
			if (cart) {
				getContentPane().remove(rightPanelCart);
				repaint();
				cart = false;
			}
			if (tablet) {
				getContentPane().remove(rightPanelTablet);
				repaint();
				tablet = false;
			}
			if (!wearable) {
				wearable = true;
				getContentPane().add(rightPanelWearable);
				revalidate();
				repaint();
			}
		}
		if (e.getSource().equals(cartButton)) {
			if (phone) {
				getContentPane().remove(rightPanelPhone);
				repaint();
				phone = false;
			}
			if (tablet) {
				getContentPane().remove(rightPanelTablet);
				repaint();
				tablet = false;
			}
			if (wearable) {
				getContentPane().remove(rightPanelWearable);
				repaint();
				wearable = false;
			}
			if (!cart) {
				cart = true;
				getContentPane().add(rightPanelCart);
				revalidate();
				repaint();
			}
		}
		if (e.getSource().equals(infon5x)) {
			nexus5x.accept(v);
			JOptionPane.showMessageDialog(this.getContentPane(), nexus5x.toString(), "Info", 1);
		}
		if (e.getSource().equals(infon6p)) {
			nexus6p.accept(v);
			JOptionPane.showMessageDialog(this.getContentPane(), nexus6p.toString(), "Info", 1);
		}
		if (e.getSource().equals(infon6)) {
			nexus6.accept(v);
			JOptionPane.showMessageDialog(this.getContentPane(), nexus6.toString(), "Info", 1);
		}
		if (e.getSource().equals(infon9)) {
			nexus9.accept(v);
			JOptionPane.showMessageDialog(this.getContentPane(), nexus9.toString(), "Info", 1);
		}
		if (e.getSource().equals(infop)) {
			pack.accept(v);
			JOptionPane.showMessageDialog(this.getContentPane(),
					pack.toString() + "\n" + "The most expensive item in the package is:\n" + v.getResult().toString(),
					"Info", 1);
		}
		if (e.getSource().equals(infoas)) {
			asuswatch.accept(v);
			JOptionPane.showMessageDialog(this.getContentPane(), asuswatch.toString(), "Info", 1);
		}
		if (e.getSource().equals(infolg)) {
			lgwatch.accept(v);
			JOptionPane.showMessageDialog(this.getContentPane(), lgwatch.toString(), "Info", 1);
		}

		if (e.getSource().equals(btnAddToCart)) {// Nexus 5X
			add(nexus5x, (int) nexus5xSP.getValue());
		}
		if (e.getSource().equals(button)) {// Nexus 6P
			add(nexus6p, (int) nexus6pSP.getValue());
		}
		if (e.getSource().equals(button_1)) {// Nexus 6
			add(nexus6, (int) nexus6SP.getValue());
		}
		if (e.getSource().equals(addNexus9)) {// Nexus 9
			add(nexus9, (int) nexus9xSP.getValue());
		}
		if (e.getSource().equals(addPack)) {// package
			add(pack, (int) packxSP.getValue());
		}
		if (e.getSource().equals(addLg)) {// lg
			add(lgwatch, (int) lgSP.getValue());
		}
		if (e.getSource().equals(addAsus)) {// asus
			add(asuswatch, (int) asusSP.getValue());
		}
		if (e.getSource().equals(pay)) {// pay
			if (!cartObj.getCart().isEmpty()) {
				Payment p = new Payment(cartObj);
				p.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(this.getContentPane(), "The cart is empty", "Error", 0);
			}
		}
		if (e.getSource().equals(clear)) {// clear cart
			if (cartObj.getCart().isEmpty()) {
				JOptionPane.showMessageDialog(this.getContentPane(), "The cart is empty", "Error", 0);
			} else {
				cartObj.removeAll();
				listModel.removeAllElements();
				getContentPane().remove(rightPanelCart);
				repaint();
				rightPanelCart = createRightCartPanel();
				getContentPane().add(rightPanelCart);
				revalidate();
			}
		}
		if (e.getSource().equals(remove)) {
			int selected = list.getSelectedIndex();
			if (listModel.isEmpty()) {
				JOptionPane.showMessageDialog(this.getContentPane(), "The cart is empty", "Error", 0);
			}
			if (selected != -1 && !listModel.isEmpty()) {
				cartObj.remove(listModel.get(selected));
				listModel.remove(selected);
				getContentPane().remove(rightPanelCart);
				repaint();
				rightPanelCart = createRightCartPanel();
				getContentPane().add(rightPanelCart);
				revalidate();
			}
			if (selected == -1 && !listModel.isEmpty()) {
				JOptionPane.showMessageDialog(this.getContentPane(), "Please select an item", "Error", 0);
			}

		}

	}

	private void add(Item i, int quantity) {
		if (quantity != 0) {
			while (quantity > 0) {
				cartObj.add(i);
				listModel.addElement(i);
				quantity--;
			}
			JOptionPane.showMessageDialog(this.getContentPane(), "Added to cart", "Info", 1);
			repaint();
			rightPanelCart = createRightCartPanel();
		} else {
			JOptionPane.showMessageDialog(this.getContentPane(), "Please select one or more items", "Error", 0);
		}
	}

	public JPanel createLeftPanel() {
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.white);
		leftPanel.setBounds(10, 11, 216, 549);
		leftPanel.setLayout(null);

		JLabel picLabel = new JLabel(setImage("/store.png"));

		picLabel.setHorizontalAlignment(SwingConstants.LEFT);
		picLabel.setBounds(7, 10, 199, 74);
		leftPanel.add(picLabel);

		categoryPhone = createButton("Phones");
		categoryPhone.setBounds(47, 100, 110, 23);
		categoryPhone.setBorderPainted(false);
		leftPanel.add(categoryPhone);

		categoryTablet = createButton("Tablet");
		categoryTablet.setBounds(47, 222, 110, 23);
		categoryTablet.setBorderPainted(false);
		leftPanel.add(categoryTablet);

		categoryWearable = createButton("Wearables");
		categoryWearable.setBounds(47, 329, 110, 23);
		categoryWearable.setBorderPainted(false);
		leftPanel.add(categoryWearable);

		JLabel tabletIcon = new JLabel(setImage("/tablet1.png"));
		tabletIcon.setBounds(10, 197, 54, 63);
		leftPanel.add(tabletIcon);

		JLabel wearableIcon = new JLabel(setImage("/wear1.png"));
		wearableIcon.setBounds(10, 293, 54, 96);
		leftPanel.add(wearableIcon);

		JLabel iconPhone = new JLabel(setImage("/phone1.png"));
		iconPhone.setBounds(15, 79, 44, 65);
		leftPanel.add(iconPhone);

		JLabel lblNewLabel = new JLabel(setImage("/cart.png"));
		lblNewLabel.setBounds(0, 438, 79, 63);
		leftPanel.add(lblNewLabel);

		cartButton = createButton("Cart");
		cartButton.setBounds(47, 455, 110, 23);
		cartButton.setBorderPainted(false);
		leftPanel.add(cartButton);

		return leftPanel;

	}

	private ImageIcon setImage(String name) {
		return new ImageIcon(ShopWindow.class.getResource(name));
	}

	private JButton createButton(String name) {
		JButton button = new JButton(name);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setFont(new Font("Roboto", Font.BOLD, 12));
		button.addActionListener(this);
		return button;
	}

	public JPanel createPhonePanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBounds(227, 11, 781, 549);
		panel.setLayout(null);

		JLabel lblPhones = new JLabel("Phones");
		lblPhones.setFont(new Font("Roboto", Font.BOLD, 23));
		lblPhones.setBounds(10, 22, 153, 62);
		panel.add(lblPhones);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShopWindow.class.getResource("/5x.png")));
		lblNewLabel.setBounds(10, 122, 165, 192);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ShopWindow.class.getResource("/6p.png")));
		lblNewLabel_1.setBounds(311, 122, 102, 202);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ShopWindow.class.getResource("/6.png")));
		lblNewLabel_2.setBounds(482, 135, 204, 189);
		panel.add(lblNewLabel_2);

		JLabel lblNexusp = new JLabel(nexus5x.getDesc() + " " + nexus5x.getPrice() + "$");
		lblNexusp.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNexusp.setBounds(50, 325, 200, 32);
		panel.add(lblNexusp);

		JLabel lblNexusp_1 = new JLabel(nexus6p.getDesc() + " " + nexus6p.getPrice() + "$");
		lblNexusp_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNexusp_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNexusp_1.setBounds(260, 325, 200, 32);
		panel.add(lblNexusp_1);

		JLabel lblNexus = new JLabel(nexus6.getDesc() + " " + nexus6.getPrice() + "$");
		lblNexus.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNexus.setBounds(580, 325, 200, 32);
		panel.add(lblNexus);

		infon5x = createButton("Info");
		infon5x.setBounds(44, 432, 112, 23);
		panel.add(infon5x);

		nexus5xSP.setBounds(44, 400, 112, 23);
		nexus5xSP.setEditor(new JSpinner.DefaultEditor(nexus5xSP));
		panel.add(nexus5xSP);

		btnAddToCart = createButton("Add to cart");
		btnAddToCart.setBounds(44, 368, 112, 23);
		panel.add(btnAddToCart);

		nexus6pSP.setBounds(301, 400, 112, 23);
		nexus6pSP.setEditor(new JSpinner.DefaultEditor(nexus6pSP));
		panel.add(nexus6pSP);

		infon6p = createButton("Info");
		infon6p.setBounds(301, 432, 112, 23);
		panel.add(infon6p);

		button = createButton("Add to cart");
		button.setBounds(301, 368, 112, 23);
		panel.add(button);

		nexus6SP.setBounds(574, 400, 112, 23);
		nexus6SP.setEditor(new JSpinner.DefaultEditor(nexus6SP));
		panel.add(nexus6SP);

		infon6 = createButton("Info");
		infon6.setBounds(574, 432, 112, 23);
		panel.add(infon6);

		button_1 = createButton("Add to cart");
		button_1.setBounds(574, 368, 112, 23);
		panel.add(button_1);

		return panel;
	}

	public JPanel createTabletPanel() {
		try {
			pack.add(nexus6p);
			pack.add(nexus9);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(227, 11, 781, 549);
		panel.setLayout(null);

		JLabel lblTablet = new JLabel("Tablet");
		lblTablet.setFont(new Font("Roboto", Font.BOLD, 23));
		lblTablet.setBounds(10, 22, 153, 62);
		panel.add(lblTablet);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShopWindow.class.getResource("/nexus9.png")));
		lblNewLabel.setBounds(21, 122, 165, 192);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ShopWindow.class.getResource("/box-512.png")));
		lblNewLabel_1.setBounds(267, 122, 172, 202);
		panel.add(lblNewLabel_1);

		JLabel lblNexusp = new JLabel(nexus9.getDesc() + " " + nexus9.getPrice() + "$");
		lblNexusp.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNexusp.setBounds(50, 325, 200, 32);
		panel.add(lblNexusp);

		JLabel lblBundle = new JLabel(pack.getDesc() + " " + pack.getPrice() + "$");
		lblBundle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBundle.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblBundle.setBounds(237, 325, 250, 32);
		panel.add(lblBundle);

		addNexus9 = createButton("Add to cart");
		addNexus9.setBounds(37, 368, 112, 23);
		panel.add(addNexus9);

		infon9 = createButton("Info");
		infon9.setBounds(37, 432, 112, 23);
		panel.add(infon9);

		nexus9xSP.setBounds(37, 400, 112, 23);
		nexus9xSP.setEditor(new JSpinner.DefaultEditor(nexus9xSP));
		panel.add(nexus9xSP);

		addPack = createButton("Add to cart");
		addPack.setBounds(301, 368, 112, 23);
		panel.add(addPack);

		packxSP.setBounds(301, 400, 112, 23);
		packxSP.setEditor(new JSpinner.DefaultEditor(packxSP));
		panel.add(packxSP);

		infop = createButton("Info");
		infop.setBounds(301, 432, 112, 23);
		panel.add(infop);

		return panel;
	}

	public JPanel createWearablePanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(227, 11, 781, 549);
		panel.setLayout(null);

		JLabel lblTablet = new JLabel("Wearables");
		lblTablet.setFont(new Font("Roboto", Font.BOLD, 23));
		lblTablet.setBounds(10, 22, 153, 62);
		panel.add(lblTablet);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShopWindow.class.getResource("/watchasus.png")));
		lblNewLabel.setBounds(21, 122, 165, 192);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ShopWindow.class.getResource("/watchlg.png")));
		lblNewLabel_1.setBounds(275, 122, 172, 202);
		panel.add(lblNewLabel_1);

		JLabel lblNexusp = new JLabel(asuswatch.getDesc() + " " + asuswatch.getPrice() + "$");
		lblNexusp.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNexusp.setBounds(35, 325, 160, 32);
		panel.add(lblNexusp);

		JLabel lblBundle = new JLabel(lgwatch.getDesc() + " " + lgwatch.getPrice() + "$");
		lblBundle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBundle.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblBundle.setBounds(267, 325, 192, 32);
		panel.add(lblBundle);

		addAsus = createButton("Add to cart");
		addAsus.setBounds(45, 368, 112, 23);
		panel.add(addAsus);

		infoas = createButton("Info");
		infoas.setBounds(45, 432, 112, 23);
		panel.add(infoas);

		asusSP.setBounds(45, 400, 112, 23);
		asusSP.setEditor(new JSpinner.DefaultEditor(asusSP));
		panel.add(asusSP);

		addLg = createButton("Add to cart");
		addLg.setBounds(311, 368, 112, 23);
		panel.add(addLg);

		lgSP.setBounds(311, 400, 112, 23);
		lgSP.setEditor(new JSpinner.DefaultEditor(lgSP));
		panel.add(lgSP);

		infolg = createButton("Info");
		infolg.setBounds(311, 432, 112, 23);
		panel.add(infolg);

		return panel;
	}

	public JPanel createRightCartPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(228, 11, 780, 549);
		panel.setLayout(null);

		JLabel lblTablet = new JLabel("Cart");
		lblTablet.setFont(new Font("Roboto", Font.BOLD, 23));
		lblTablet.setBounds(10, 22, 153, 62);
		panel.add(lblTablet);

		lblNewLabel_2 = new JLabel("Total Price:");
		lblNewLabel_2.setBounds(100, 22, 153, 62);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel(cartObj.getPrice() + "$");
		lblNewLabel_3.setBounds(180, 22, 153, 62);
		panel.add(lblNewLabel_3);

		list = new JList<Item>(listModel);
		js = new JScrollPane(list);
		js.setViewportView(list);
		js.setBounds(70, 84, 328, 400);
		panel.add(js);

		remove = createButton("Remove Item");
		remove.setBounds(400, 84, 112, 23);
		panel.add(remove);

		clear = createButton("Clear cart");
		clear.setBounds(600, 470, 112, 23);
		panel.add(clear);

		pay = createButton("Pay");
		pay.setBounds(600, 500, 112, 23);
		panel.add(pay);

		return panel;
	}
}
