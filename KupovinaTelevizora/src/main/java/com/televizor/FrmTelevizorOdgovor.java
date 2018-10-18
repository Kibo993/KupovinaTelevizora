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

import com.televizor.Enums.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class FrmTelevizorOdgovor extends JFrame {

	private JPanel contentPane;
	private JLabel lblImage;
	private JLabel lblOdgovor;
	private JLabel lblIzabrani;

	private static Televizor tv;
	private static Televizor televizor;
	private Connection connection;
	private ResultSet rs = null;
	private JLabel lblNeophodneKarakteristikeZa;
	private JLabel lblPreporueniTelevizor;
	JButton btnPrethodni;	
	JButton btnSledeci;
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
            
            //String sql = "SELECT * FROM `Televizor` WHERE `internet` = '"+tv.getInternet()+"' AND `tuner` LIKE '%"+tv.getTuner()+"%'";
            String sql = "SELECT * FROM `Televizor` WHERE `dijagonala` = 55";
            //String sql = "SELECT * FROM `Televizor` WHERE `maxCena` = 12749";
            System.out.println(sql);
            Statement sqlStatement = null;
			try {
				sqlStatement = connection.createStatement();
			} catch (SQLException e) {
				System.out.println("Greška u kreiranju stejtmenta");
				e.printStackTrace();
			}
			try {
				rs = sqlStatement.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println("Greška u izvršenju");
				e.printStackTrace();
			}
			try {
				if(rs.next()){
					televizor.setIme(rs.getString("model"));
					televizor.setCena(rs.getInt("maxCena"));
					televizor.setInternet(Internet.valueOf(rs.getString("internet")));
					televizor.setTuner(tv.getTuner());
					televizor.setDijagonala(rs.getInt("dijagonala"));
					televizor.setTipEkrana(TipEkrana.valueOf(rs.getString("tipEkrana")));
					televizor.setSmart(Smart.valueOf(rs.getString("smart")));
					televizor.setBrojPortova(rs.getInt("brojPortova"));
					televizor.setRezolucija(Rezolucija.valueOf(rs.getString("rezolucija")));
					System.out.println(televizor);
	            byte image[];
				image = rs.getBytes("slika");
				ImageIcon icon = new ImageIcon(image);
				Image im = icon.getImage();
				Image imm = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon myImg = new ImageIcon(imm);
				lblImage.setIcon(myImg);
				lblIzabrani.setText("<html>" + televizor.ispisOdabranogTelevizora().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				}
				if(!rs.next()){
					btnSledeci.setEnabled(false);
				}else{
					rs.previous();
				}
			} catch (SQLException e) {
				System.out.println("Greška u upisivanju");
				e.printStackTrace();
			}
            /*try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Greška u zatvaranju");
				e.printStackTrace();
			}*/

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
		
		lblOdgovor = new JLabel("New label");
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
		
		lblIzabrani = new JLabel("New label");
		lblIzabrani.setBounds(485, 265, 349, 230);
		contentPane.add(lblIzabrani);
		
		btnPrethodni = new JButton("<html><h1>&#x21E6;</h1></html>");
		btnPrethodni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(rs.previous()){
						btnSledeci.setEnabled(true);
					}
				} catch (SQLException e1) {
					System.out.println("Greška kod odabira prethodnog");
					e1.printStackTrace();
				}
				promena();
			}
		});
		btnPrethodni.setBounds(558, 503, 49, 29);
		contentPane.add(btnPrethodni);
		btnPrethodni.setEnabled(false);
		
		btnSledeci = new JButton("<html><h1>&#x21E8;</h1></html>");
		btnSledeci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rs.next()){
						btnPrethodni.setEnabled(true);
					}
				} catch (SQLException e1) {
					System.out.println("Greška kod odabira sledeæeg");
					e1.printStackTrace();
				}
				promena();
			}
		});
		btnSledeci.setBounds(629, 503, 49, 29);
		contentPane.add(btnSledeci);
		
		lblNeophodneKarakteristikeZa = new JLabel("Neophodne karakteristike za va\u0161 televizor:");
		lblNeophodneKarakteristikeZa.setBounds(23, 11, 354, 14);
		contentPane.add(lblNeophodneKarakteristikeZa);
		
		lblPreporueniTelevizor = new JLabel("Preporu\u010Deni televizor:");
		lblPreporueniTelevizor.setBounds(482, 11, 322, 14);
		contentPane.add(lblPreporueniTelevizor);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(410, 11, 11, 487);
		contentPane.add(separator);
		baza();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				dispose();
				TelevizorMain.showYourself();
			}
		});
	}
	
	private void promena(){
		try {
		televizor.setIme(rs.getString("model"));
		televizor.setCena(rs.getInt("maxCena"));
		televizor.setInternet(Internet.valueOf(rs.getString("internet")));
		televizor.setTuner(tv.getTuner());
		televizor.setDijagonala(rs.getInt("dijagonala"));
		televizor.setTipEkrana(TipEkrana.valueOf(rs.getString("tipEkrana")));
		televizor.setSmart(Smart.valueOf(rs.getString("smart")));
		televizor.setBrojPortova(rs.getInt("brojPortova"));
		televizor.setRezolucija(Rezolucija.valueOf(rs.getString("rezolucija")));
    byte image[];
	image = rs.getBytes("slika");
	ImageIcon icon = new ImageIcon(image);
	Image im = icon.getImage();
	Image imm = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon myImg = new ImageIcon(imm);
	lblImage.setIcon(myImg);
	lblIzabrani.setText("<html>" + televizor.ispisOdabranogTelevizora().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
	if(!rs.next()){
		rs.previous();
		btnSledeci.setEnabled(false);
	}else{
		rs.previous();
	}
	if(!rs.previous()){
		rs.next();
		btnPrethodni.setEnabled(false);
	}else{
		rs.next();
	}
		} catch (SQLException e) {
			System.out.println("Greška kod prikazivanja odabranog");
			e.printStackTrace();
		}

	}

	
	public FrmTelevizorOdgovor() {

		new FrmTelevizorOdgovor(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
