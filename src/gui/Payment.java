package gui;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import core.cart.Cart;
import core.cart.CartDecorated;
import core.products.Item;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

@SuppressWarnings("serial")
public class Payment extends JDialog implements ActionListener {
	private GregorianCalendar date = new GregorianCalendar();
	private Cart cart;
	private JTextField nome;
	private JTextField carta;
	private JTextField data;
	private JTextField textField_3;
	private JTextField citta;
	private JButton btnPay;

	public Payment(Cart carrello) {
		if (carrello.getPrice() > 1000.0) {
			this.cart = new CartDecorated(carrello);
		} else {
			this.cart = carrello;
		}
		setResizable(false);
		setTitle("Payment");
		setModal(true);
		setBounds(150, 50, 400, 250);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FormLayout( 
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(lblName, "2, 4, right, default");

		nome = new JTextField();
		panel.add(nome, "6, 4, fill, default");
		nome.setColumns(10);

		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(lblCardNumber, "2, 8, right, default");

		carta = new JTextField();
		carta.setColumns(10);
		panel.add(carta, "6, 8, fill, default");

		JLabel lblValidDate = new JLabel("Valid date:");
		lblValidDate.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(lblValidDate, "2, 12, right, default");

		data = new JTextField();
		data.setColumns(10);
		panel.add(data, "6, 12, left, default");

		JLabel lblAddress = new JLabel("Address:");
		lblValidDate.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(lblAddress, "2, 16, right, default");

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel.add(textField_3, "6, 16, fill, default");

		JLabel lblCity = new JLabel("City:");
		lblValidDate.setFont(new Font("Roboto", Font.PLAIN, 14));
		panel.add(lblCity, "2, 20, right, default");

		citta = new JTextField();
		citta.setColumns(10);
		panel.add(citta, "6, 20, fill, default");

		btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnPay.addActionListener(this);
		panel.add(btnPay, "6, 22, center, default");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String error = "";
		if (e.getSource().equals(btnPay)) {
			System.out.println("did");
			if (nome.getText().trim().equals("")) {
				error += "Wrong name\n";
			}
			if (carta.getText().trim().length() != 16) {
				error += "Wrong card number format (16 numbers)\n";
			}
			if (data.getText().trim().length() != 5) {
				error += "Wrong date format (mm/aa)\n";
			}
			if (citta.getText().trim().equals("")) {
				error += "Wrong city\n";
			}
			if (error.equals("")) {
				try {
					Invoice invoice = new Invoice(
							"invoice-" + date.get(5) + "-" + date.get(2) + "-" + date.get(1) + ".txt");
					invoice.write("******************** INVOICE ********************");
					invoice.write(date.get(5) + "-" + date.get(2) + "-" + date.get(1));
					Iterator<Item> it = cart.getCart().iterator();
					while (it.hasNext()) {
						Item current = it.next();
						invoice.write(current.toString());
					}
					invoice.write("Shipping to: " + nome.getText() + ". " + textField_3.getText() + ", "
							+ citta.getText().toUpperCase());
					invoice.write("Total price: " + cart.getPrice() + "$");
					invoice.write("*************************************************");
					invoice.close();
					Desktop d = Desktop.getDesktop();
					d.open(invoice.getFile());

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this.getContentPane(), error, "Error", 0);
			}
		}

	}
}
