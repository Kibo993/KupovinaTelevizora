package com.televizor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelevizorMain extends JFrame {
	//Sada�nji server sa bazom nepouzdan!!!!
	// VIDI KAKO DA JDBC DRIVER MO�E I DA SE POZOVE KAD SE SKINE SA GIT HUBA!!!!
	//PODESI SQL UPIT PRAVILNO I POPUNU ZA TUNER ZA ODABRANI TELEVIZOR (DAKLE KAKAV TUNER STVARNO IMA)
//televizori specifikacije:
//	-DVB - T/C/S analogni tjuneri
//	-rezolucija
//	-smart ili ne - android ili drugi
//	-veli�ina ekrana
//	-tip ekrana led, oled, plazma, katodni
//	-cena
//  -Wi-fi
//  -Broj portova
//  -Odnos kontrasta (contrast ratio) (pozicioniranje televizora)
//  -dodatne funkcionalnosti (dvd, 3D, usb (ako �e da gleda samo filmove i slike), ...)
// 
	// Ekspert je prose�an �ovek koji ve� poseduje televizor koji se pokvario ili �eli da ga zameni novijim i koji se donekle razume.
	// blizina tv to uti�e na veli�inu ekrana a mo�e posredno i na rezoluciju (�ta �e nam mali tv sa velikom rezolucijom)
	// veza sa internetom i mesto prijema signala i na�in prijema uti�u na tjuner i Wi-fi (neki nemaju wifi a mogu na net)
	// za �ta �e televizor biti kori��en - da se vidi da li treba smart ili obi�ni da li �e gledati filmove ili samo sa kompa
	// ako gleda sadr�aj sa kompjutera (tipa youtube, ili skype) mo�da je bolje da uzme smart
	// Ako gleda programe susednih zemalja, potreban mu je tv sa jakim tjunerom dakle skuplji
	// Da li postoje u prodaji �isto analogni televizori, da li ponuditi polovne, da li korigovati cene u prvom pitanju???
	// Za odabir cene i razdaljine staviti slider!!!
	// Kako je bolje, da budu enumi ili stringovi jer ako su stringovi, onda je dovoljna jedna metoda za odgovore???
	// Kad je bolje popuniti objekat televizor, da li redom posle svakog pitanja ili na kraju???
	// Smart TV nema analogni tjuner - vodi ra�una o tome!!!!
	// 
	//pitanja:
	//
	//- Koliko mo�ete da izdvojite za televizor: do 15000,do 40000,do 90000, do 150000, do 200000;
	//- Za kakav sadr�aj naj�e��e koristite televizor: gledanje filmova, gledanje vesti, igranje igrica, gledanje zabavnog sadr�aja, sport;
	//- Na koji na�in primarno primate televizijski program: Kablovska, Satelitska, Zemaljska(preko antene), ne pratim klasi�ni tv program;
	//- (Ako prima zemaljsku televiziju)Na kojem podru�ju �ivite: Gradsko, Prigradsko, Seosko;
	//- (Ako ima kablovsku)Na koji na�in primate signal sa kablovske: Direktno (analogna), set top box, CI kartica;
	//- (Nadovezuje se na prethodno)Da li biste uzeli dodatne mogu�nosti koje nudi provajder: Da, Ne;
	//- (Ako ima satelitsku)Da li program pratite preko provajdera ili gledate slobodne kanale: Preko provajdera, Slobodno;
	//- (ako je ozna�io kablovska ili satelitska)Da li imate jo� neki na�in za prijem tv signala: Zemaljska(preko antene), Nemam;
	//- Da li imate internet: Da sa WiFi-jem, Da bez WiFi-ja, Ne;
	//- (Ako gleda samo filmove)(ili ako ne prati klasi�an tv program onda takvo pitanje npr. sport-Sa kojeg ure�aja gledate sportske doga�aje?)Sa kojeg ure�aja gledate filmove: Sa dvd-ja, sa ra�unara, streaming-om, sa usb-a;
	//- Kako je pozicioniran televizor u prostoriji: Naspram prozora, pored prozora, prozor je sa strane;
	//- Sa koje razdaljine gledate televiziju: 1m, 2m, 3m, 4m;
	//- (Mo�da i razli�ita pitanja u zavisnosti od toga �ta ima a �ta nema)Da li �elite nove mogu�nosti (uvo�enje interneta, kablovske,...): Da, Ne;
	private JPanel contentPane;
	
	private static TelevizorThread tv;
	private static TelevizorMain frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelevizorMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelevizorMain() {
		setTitle("Kupovina televizora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPokreni = new JButton("Po\u010Dni");
		btnPokreni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pokreni();
				frame.setVisible(false);
			}
		});
		btnPokreni.setBounds(54, 112, 89, 23);
		contentPane.add(btnPokreni);
		
		JButton btnKraj = new JButton("Kraj");
		btnKraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKraj.setBounds(285, 112, 89, 23);
		contentPane.add(btnKraj);
		
		JLabel lblDobrodoliUAplikaciju = new JLabel("<html>Dobrodo\u0161li u aplikaciju za pomo\u0107 <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; pri kupovini televizora</html>");
		lblDobrodoliUAplikaciju.setHorizontalAlignment(SwingConstants.CENTER);
		lblDobrodoliUAplikaciju.setBounds(90, 28, 273, 42);
		contentPane.add(lblDobrodoliUAplikaciju);
	}
	
	 	public static void pokreni(){
	    	tv = new TelevizorThread();
	    	tv.pokreni();
	    	tv.start();
	    }
	    
	 	public static void zaustavi(){
	    	tv.interrupt();
	    }
	 	
	 	public static void showYourself(){
	    	frame.setVisible(true);
	    }
}
