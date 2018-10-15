package com.televizor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FrmTelevizorOdgovor extends JFrame {

	private JPanel contentPane;

	private static Televizor tv;
	private Connection connection;
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

	private void baza(){

            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Greška nije pronaðen drajver");
				e.printStackTrace();
			}
            try {
				connection = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/televizorexpert?useUnicode=true&characterEncoding=utf-8", "bokidukic2fon", "BokiDukic-993");
				connection.setAutoCommit(false);
            } catch (SQLException e) {
            	System.out.println("Greška u povezivanju");
				e.printStackTrace();
			}
            
            String sql = "SELECT * FROM Televizor";
            System.out.println(sql);
            Statement sqlStatement = null;
			try {
				sqlStatement = connection.createStatement();
			} catch (SQLException e) {
				System.out.println("Greška u kreiranju stejtmenta");
				e.printStackTrace();
			}
            ResultSet rs = null;
			try {
				rs = sqlStatement.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println("Greška u izvršenju");
				e.printStackTrace();
			}
            String test = "";
			try {
				rs.next();
				test = rs.getString("model");
			} catch (SQLException e) {
				System.out.println("Greška u upisivanju");
				e.printStackTrace();
			}
            System.out.println(test);


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
		lblOdgovor.setBounds(23, 11, 354, 340);
		contentPane.add(lblOdgovor);
		//lblOdgovor.setText(tv.toString());
		lblOdgovor.setText("<html>" + tv.ispisNaFormi().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		
		JLabel lblKomentar = new JLabel("");
		lblKomentar.setBounds(23, 386, 354, 112);
		contentPane.add(lblKomentar);
		lblKomentar.setText("<html>" + tv.ispisKomentara().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		System.out.println(tv);
		JButton btnPocetak = new JButton("Nazad");
		btnPocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelevizorMain.showYourself();
			}
		});
		btnPocetak.setBounds(364, 509, 89, 23);
		contentPane.add(btnPocetak);
		baza();
	}
	
	public FrmTelevizorOdgovor() {
		new FrmTelevizorOdgovor(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
