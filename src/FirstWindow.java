import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class FirstWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow window = new FirstWindow();
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
	public FirstWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 205));
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Include a book in the catalog");
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 80, 207, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCheckOutA = new JButton("Check Out A book");
		btnCheckOutA.setForeground(new Color(0, 0, 128));
		btnCheckOutA.setFont(new Font("Arial", Font.BOLD, 12));
		btnCheckOutA.setBackground(UIManager.getColor("Button.background"));
		btnCheckOutA.setBounds(227, 80, 197, 43);
		frame.getContentPane().add(btnCheckOutA);
		
		JButton btnNewButton_1 = new JButton("Return a book");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 161, 139, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnStatus = new JButton("Status");
		btnStatus.setForeground(new Color(0, 0, 128));
		btnStatus.setFont(new Font("Arial", Font.BOLD, 12));
		btnStatus.setBackground(UIManager.getColor("Button.background"));
		btnStatus.setBounds(159, 161, 125, 43);
		frame.getContentPane().add(btnStatus);
		
		JButton btnAddPatron = new JButton("Add Patron");
		btnAddPatron.setForeground(new Color(0, 0, 128));
		btnAddPatron.setFont(new Font("Arial", Font.BOLD, 12));
		btnAddPatron.setBackground(UIManager.getColor("Button.background"));
		btnAddPatron.setBounds(294, 161, 130, 43);
		frame.getContentPane().add(btnAddPatron);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setForeground(Color.RED);
		btnExit.setFont(new Font("Arial", Font.BOLD, 12));
		btnExit.setBounds(335, 228, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblAaMemorialLibrary = new JLabel("AA Memorial Library");
		lblAaMemorialLibrary.setForeground(new Color(0, 0, 0));
		lblAaMemorialLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblAaMemorialLibrary.setFont(new Font("Mathematica6", Font.BOLD, 32));
		lblAaMemorialLibrary.setBounds(24, 11, 386, 58);
		frame.getContentPane().add(lblAaMemorialLibrary);
	}
}
