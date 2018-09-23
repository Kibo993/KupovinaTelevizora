package com.sample;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class FrmKupovinaTelevizora extends JFrame {

	private JPanel contentPane;
	private static Televizor tv;
	
	final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKupovinaTelevizora frame = new FrmKupovinaTelevizora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrmKupovinaTelevizora(Televizor tv) {
        this.tv = tv;
        //initComponents();
        this.setTitle("Kupovina televizora");
    }

	/**
	 * Create the frame.
	 */
	public FrmKupovinaTelevizora() {
		new FrmKupovinaTelevizora(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 38, 327, 198);
		contentPane.add(panel);
		
		String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
		
		JComboBox comboBox = new JComboBox(comboBoxItems);
		comboBox.setBounds(141, 7, 161, 20);
		contentPane.add(comboBox);
	}
}
