package com.televizor;

import java.awt.EventQueue;
import java.awt.Image;

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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class FrmTelevizorOdgovor extends JFrame {

	private JPanel contentPane;
	private JLabel lblImage;
	private JLabel lblOdgovor;
	private JLabel lblIzabrani;
	private static final long serialVersionUID = 1L;

	private boolean imaVezu = false;
	private static Televizor tv;
	private static Televizor televizor;
	private TelevizorBaza tb;
	private ResultSet rs = null;
	private String tuner;
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

	private void odgovor(){
		televizor = new Televizor();
		tb = new TelevizorBaza();
		rs = tb.baza(tv);
			try {
				if(rs.next()){
					String tuners[] = rs.getString("tuner").split(" ");
					tuner = tuners[0];
					televizor.setIme(rs.getString("model"));
					televizor.setCena(rs.getInt("maxCena"));
					televizor.setInternet(Internet.valueOf(rs.getString("internet")));
					if(rs.getString("tuner").contains("DVB_T2_S2")){
						if(rs.getString("tuner").contains("DVB_T2_C")){
							televizor.setTuner(Tuner.DVB_T2_C_S2);
						}
					}else{
						televizor.setTuner(Tuner.valueOf(tuner));
					}
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
				System.out.println("Gre\u0161ka u upisivanju");
				e.printStackTrace();
			}

	}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public FrmTelevizorOdgovor(Televizor tv) {
        this.tv = tv;
        this.setTitle("Kupovina televizora - ponu\u0111eno re\u0161enje");
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
		lblOdgovor.setText("<html>" + tv.ispisNaFormi().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		
		JLabel lblKomentar = new JLabel("");
		lblKomentar.setBounds(23, 290, 354, 208);
		contentPane.add(lblKomentar);
		lblKomentar.setText("<html>" + tv.ispisKomentara().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		System.out.println(tv);
		JButton btnPocetak = new JButton("Nazad");
		btnPocetak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(imaVezu){
					tb.zatvoriKonekciju();
			    }
				dispose();
				TelevizorMain.showYourself();
			}
		});
		btnPocetak.setBounds(364, 509, 89, 23);
		contentPane.add(btnPocetak);
		
		lblImage = new JLabel("Nije pronađen odgovarajući televizor.");
		lblImage.setBounds(485, 24, 264, 230);
		contentPane.add(lblImage);
		
		lblIzabrani = new JLabel("");
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
					System.out.println("Gre\u0161ka kod odabira prethodnog");
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
					System.out.println("Gre\u0161ka kod odabira slede\u0107eg");
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
		
		 Process p1 = null;
		try {
			p1 = java.lang.Runtime.getRuntime().exec("ping -n 1 www.db4free.net");
		} catch (IOException e1) {
			System.out.println("Gre\u0161ka kod veze sa internetom");
			e1.printStackTrace();
		}
		    int returnVal = 0;
			try {
				returnVal = p1.waitFor();
			} catch (InterruptedException e1) {
				System.out.println("Gre\u0161ka kod ping-a");
				e1.printStackTrace();
			}
		    imaVezu = (returnVal==0);
		    if(imaVezu){
		    	odgovor();
		    }else{
		    	btnSledeci.setEnabled(false);
		    	lblImage.setText("Nema konekcije sa internetom!");
		    }
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				if(imaVezu){
					tb.zatvoriKonekciju();
			    }
				dispose();
				TelevizorMain.showYourself();
			}
		});
	}
	
	private void promena(){
		try {
		String tuners[] = rs.getString("tuner").split(" ");
		tuner = tuners[0];
		televizor.setIme(rs.getString("model"));
		televizor.setCena(rs.getInt("maxCena"));
		televizor.setInternet(Internet.valueOf(rs.getString("internet")));
		if(rs.getString("tuner").contains("DVB_T2_S2")){
			if(rs.getString("tuner").contains("DVB_T2_S2")){
				televizor.setTuner(Tuner.DVB_T2_C_S2);
			}
		}else{
			televizor.setTuner(Tuner.valueOf(tuner));
		}
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
			System.out.println("Gre\u0161ka kod prikazivanja odabranog");
			e.printStackTrace();
		}

	}
	
	public FrmTelevizorOdgovor() {

		new FrmTelevizorOdgovor(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
