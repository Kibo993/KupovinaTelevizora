package com.televizor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.televizor.Enums.Smart;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FrmTelevizorOdgovor extends JFrame {

	private JPanel contentPane;
	private JLabel lblImage;

	private static Televizor tv;
	private static Televizor televizor;
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
televizor = new Televizor();
            try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Greška nije pronaðen drajver");
				e.printStackTrace();
			}
            try {
				connection = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/televizorexpert?useUnicode=true&characterEncoding=utf-8&useSSL=false", "bokidukic2fon", "BokiDukic-993");
				connection.setAutoCommit(false);
            } catch (SQLException e) {
            	System.out.println("Greška u povezivanju");
				e.printStackTrace();
			}
            
            String sql = "SELECT * FROM `Televizor` WHERE `internet` = '"+tv.getInternet()+"' AND `tuner` LIKE '%"+tv.getTuner()+"%'";
            //String sql = "SELECT * FROM `TelevizorExpert`";
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
				//rs.next();
				if(rs.next()){
					System.out.println(rs.getString("smart"));
					//televizor.setSmart(Smart.valueOf("SMART"));
					televizor.setSmart(Smart.valueOf(rs.getString("smart")));
					System.out.println(televizor);
				test = rs.getString("model");
	            byte image[];
				image = rs.getBytes("slika");
				ImageIcon icon = new ImageIcon(image);
				Image im = icon.getImage();
				Image imm = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon myImg = new ImageIcon(imm);
				lblImage.setIcon(myImg);
				}
			} catch (SQLException e) {
				System.out.println("Greška u upisivanju");
				e.printStackTrace();
			}
            System.out.println(test);
            try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Greška u zatvaranju");
				e.printStackTrace();
			}

	}
	/**
	 * Create the frame.
	 */
	public FrmTelevizorOdgovor(Televizor tv) {
        this.tv = tv;
        this.setTitle("Kupovina televizora - ponuðeno rešenje");
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOdgovor = new JLabel("New label");
		lblOdgovor.setBounds(23, 11, 354, 268);
		contentPane.add(lblOdgovor);
		//lblOdgovor.setText(tv.toString());
		lblOdgovor.setText("<html>" + tv.ispisNaFormi().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		
		JLabel lblKomentar = new JLabel("");
		lblKomentar.setBounds(23, 290, 354, 208);
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
		
		lblImage = new JLabel("New label");
		lblImage.setBounds(485, 24, 264, 230);
		contentPane.add(lblImage);
		baza();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				dispose();
				TelevizorMain.showYourself();
			}
		});
	}

	
	public FrmTelevizorOdgovor() {

		new FrmTelevizorOdgovor(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
