package com.televizor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class FrmTelevizorOdgovor extends JFrame {

	private JPanel contentPane;

	private static Televizor tv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTelevizorOdgovor frame = new FrmTelevizorOdgovor();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTelevizorOdgovor(Televizor tv) {
        this.tv = tv;
        this.setTitle("Kupovina televizora - ponuðeno rešenje");
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOdgovor = new JLabel("New label");
		lblOdgovor.setBounds(23, 11, 354, 397);
		contentPane.add(lblOdgovor);
		//lblOdgovor.setText(tv.toString());
		lblOdgovor.setText("<html>" + tv.ispisNaFormi().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		
		JLabel lblKomentar = new JLabel("");
		lblKomentar.setBounds(23, 435, 354, 112);
		contentPane.add(lblKomentar);
		lblKomentar.setText("<html>" + tv.ispisKomentara().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		System.out.println(tv);
	}
	
	public FrmTelevizorOdgovor() {
		new FrmTelevizorOdgovor(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
