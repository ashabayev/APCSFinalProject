import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class BookSearchWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSearchWindow window = new BookSearchWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookSearchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(127, 66, 380, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Title", "Author", "ISBN", "Year Published"}));
		comboBox.setBounds(10, 66, 115, 20);
		frame.getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 109, 497, 76);
		frame.getContentPane().add(textArea);
		
		JLabel lblAa = new JLabel("AA Memorial Library");
		lblAa.setFont(new Font("Mathematica6", Font.PLAIN, 15));
		lblAa.setBounds(10, 11, 145, 20);
		frame.getContentPane().add(lblAa);
		
		JLabel lblSearchForBook = new JLabel("Search for book");
		lblSearchForBook.setBounds(10, 42, 102, 14);
		frame.getContentPane().add(lblSearchForBook);
		frame.setBounds(100, 100, 533, 254);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
