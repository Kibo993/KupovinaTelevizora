package com.sample;

import java.awt.EventQueue;

import com.sample.Televizor;
import com.sample.Enums.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.Box;

public class FrmKupovinaTelevizora extends JFrame{

	private JPanel contentPane;
	private static Televizor tv;
	private JPanel questionsPanel;
	private String primarniPrijemPrograma;
	private boolean sekPrijemSelected = false;
	private boolean dodMogucnostiSelected = false;
	
	final static String CENATELEVIZORA = "Cena televizora";
    final static String PRIMARNIPRIJEM = "Primarni prijem programa";
    final static String PRIJEMKABLOVSKA = "Naèin prijema kablovske";
    final static String PRIJEMSATELITSKA = "Naèin prijema satelitske";
    final static String SEKUNDARNIPRIJEM = "Sekundarni prijem programa";
    final static String DODATNEMOGUCNOSTI = "Dodatne moguænosti";
    final static String INTERNET = "Internet";
    final static String POZICIJATV = "Pozicija tv-a u prostoriji";
    final static String UDALJENOSTTV = "Udaljenost od ekrana";
    final static String UREDJAJI = "Dodatni ureðaji";
    
    private int maxCena = 100000;
    private int udaljenostOdEkrana = 300;
    private String dodatniUredjaji = "";
    
    private JRadioButton rdbtnKablovska;
    private JRadioButton rdbtnSatelitska;
    private JRadioButton rdbtnZemaljska;
    private JRadioButton rdbtnNeKlasican;
    
    private JRadioButton rdbtnAnalogna;
    private JRadioButton rdbtnSetTop;
    private JRadioButton rdbtnCAM;
    
    private JRadioButton rdbtnPrekoProvajdera;
    private JRadioButton rdbtnSlobodno;
    
    private JRadioButton rdbtnSekPrijemDa;
    private JRadioButton rdbtnSekPrijemNe;
    
    private JRadioButton rdbtnDodMogDa;
    private JRadioButton rdbtnDodMogNe;
    
    private JRadioButton rdbtnDaSaWifijem;
    private JRadioButton rdbtnDaBezWifija;
    private JRadioButton rdbtnInternetNe;
    
    private JRadioButton rdbtnNaspramProzora;
    private JRadioButton rdbtnIspredProzora;
    private JRadioButton rdbtnProzorSaStrane;
    
    private JCheckBox chckbxRacunar;
    private JCheckBox chckbxDvd;
    private JCheckBox chckbxSmartTvBox;
    private JCheckBox chckbxKameraZaVideo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKupovinaTelevizora frame = new FrmKupovinaTelevizora();
					frame.setVisible(false);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		questionsPanel = new JPanel();
		questionsPanel.setBounds(10, 38, 414, 198);
		contentPane.add(questionsPanel);
		questionsPanel.setLayout(new CardLayout(0, 0));
		
		//Container pane = new Container(frame.getContentPane());
		
		//ArrayList<String> comboBoxItems = new ArrayList<>();
		//comboBoxItems.add(CENATELEVIZORA);
		String comboBoxItems[] = { CENATELEVIZORA, PRIMARNIPRIJEM, UDALJENOSTTV , UREDJAJI};
		CardLayout cl = (CardLayout)(questionsPanel.getLayout());
		JComboBox comboBox = new JComboBox(comboBoxItems);
		comboBox.setBounds(141, 7, 161, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CardLayout cl = (CardLayout)(questionsPanel.getLayout());
		        cl.show(questionsPanel, (String)comboBox.getSelectedItem());
			}
		});
		contentPane.add(comboBox);
		
		JPanel maxCenaTV = new JPanel();
		maxCenaTV.setLayout(null);
		questionsPanel.add(maxCenaTV, CENATELEVIZORA);
        
        JPanel primarPrijemTV = new JPanel();
        primarPrijemTV.setLayout(null);
        questionsPanel.add(primarPrijemTV, PRIMARNIPRIJEM);
        
        JPanel prijemKablovskeTV = new JPanel();
        prijemKablovskeTV.setLayout(null);
        questionsPanel.add(prijemKablovskeTV, PRIJEMKABLOVSKA);
        
        JPanel prijemSatelitska = new JPanel();
        prijemSatelitska.setLayout(null);
        questionsPanel.add(prijemSatelitska, PRIJEMSATELITSKA);
        
        JPanel sekundarPrijemTV = new JPanel();
        sekundarPrijemTV.setLayout(null);
        questionsPanel.add(sekundarPrijemTV, SEKUNDARNIPRIJEM);
        
        JPanel dodMogucnostiTV = new JPanel();
        dodMogucnostiTV.setLayout(null);
        questionsPanel.add(dodMogucnostiTV, DODATNEMOGUCNOSTI);
        
        JPanel internetTV = new JPanel();
        internetTV.setLayout(null);
        questionsPanel.add(internetTV, INTERNET);
        
        JPanel pozicijaTV = new JPanel();
        pozicijaTV.setLayout(null);
        questionsPanel.add(pozicijaTV, POZICIJATV);
        
        JPanel udaljenostTV = new JPanel();
        udaljenostTV.setLayout(null);
        questionsPanel.add(udaljenostTV, UDALJENOSTTV);
        
        JPanel uredjajiTV = new JPanel();
        uredjajiTV.setLayout(null);
        questionsPanel.add(uredjajiTV, UREDJAJI);
        
        JLabel lblIspisCene = new JLabel("100000");
        lblIspisCene.setHorizontalAlignment(SwingConstants.RIGHT);
        JSlider cena = new JSlider(10000,200000,100000);
        cena.setMajorTickSpacing(10000);
        cena.setMinorTickSpacing(5000);
        cena.setPaintTicks(true);
        
        Hashtable<Integer, JLabel> ispisCena = new Hashtable<Integer, JLabel>();
        ispisCena.put(new Integer( 10000 ),new JLabel("10000") );
        ispisCena.put(new Integer( 50000 ),new JLabel("50000") );
        ispisCena.put(new Integer( 100000 ),new JLabel("100000") );
        ispisCena.put(new Integer( 150000 ),new JLabel("150000") );
        ispisCena.put(new Integer( 200000 ),new JLabel("200000") );
        cena.setLabelTable(ispisCena);
        cena.setPaintLabels(true);
        cena.setSnapToTicks(true);
        
        cena.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		lblIspisCene.setText(String.valueOf(cena.getValue()));
            	String value = String.valueOf(cena.getValue());
        		maxCena = Integer.parseInt(value);
        	}
        });
        cena.setBounds(58, 37, 307, 45);
        maxCenaTV.add(cena);
        
        JLabel lblOdaberiteNajviuCenu = new JLabel("Odaberite najvi\u0161u cenu koju ste spremni da platite:");
        lblOdaberiteNajviuCenu.setBounds(58, 11, 330, 14);
        maxCenaTV.add(lblOdaberiteNajviuCenu);
        
        //JLabel lblIspisCene = new JLabel("New label");
        lblIspisCene.setBounds(182, 93, 46, 14);
        maxCenaTV.add(lblIspisCene);
        
        JButton btnDalje = new JButton("Dalje");
        btnDalje.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setCena(maxCena);
        		cl.next(questionsPanel);
        	}
        });
        btnDalje.setBounds(273, 150, 89, 23);
        maxCenaTV.add(btnDalje);
        
        JLabel lblNacin = new JLabel("Na koji na\u010Din primarno primate televizijski program?");
        lblNacin.setBounds(67, 11, 311, 14);
        primarPrijemTV.add(lblNacin);
        
        rdbtnKablovska = new JRadioButton("Kablovska");
        rdbtnKablovska.setBounds(77, 32, 200, 23);
        primarPrijemTV.add(rdbtnKablovska);
        
        rdbtnSatelitska = new JRadioButton("Satelitska");
        rdbtnSatelitska.setBounds(77, 60, 200, 23);
        primarPrijemTV.add(rdbtnSatelitska);
        
        rdbtnZemaljska = new JRadioButton("Zemaljska (antenska)");
        rdbtnZemaljska.setBounds(77, 86, 200, 23);
        primarPrijemTV.add(rdbtnZemaljska);
        
        rdbtnNeKlasican = new JRadioButton("Ne pratim klasi\u010Dan tv program");
        rdbtnNeKlasican.setBounds(77, 112, 200, 23);
        primarPrijemTV.add(rdbtnNeKlasican);
        
        ButtonGroup nacinPrijema = new ButtonGroup();
        nacinPrijema.add(rdbtnKablovska);
        nacinPrijema.add(rdbtnSatelitska);
        nacinPrijema.add(rdbtnZemaljska);
        nacinPrijema.add(rdbtnNeKlasican);
        
        
        
        JButton btnDalje_1 = new JButton("Dalje");
        btnDalje_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setNacinPrijema(nacinPrijemaSelected());
        		if(tv.getNacinPrijema()!=null){
        			cl.show(questionsPanel, primarniPrijemPrograma);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Greška", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_1.setBounds(273, 150, 89, 23);
        primarPrijemTV.add(btnDalje_1);
        
        JButton btnNazad = new JButton("Nazad");
        btnNazad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setNacinPrijema(null);
        		cl.previous(questionsPanel);
        	}
        });
        btnNazad.setBounds(36, 150, 89, 23);
        primarPrijemTV.add(btnNazad);
        
        
        
        JLabel lblNaKojiNain = new JLabel("Na koji na\u010Din primate signal sa kablovske?");
        lblNaKojiNain.setBounds(67, 11, 311, 14);
        prijemKablovskeTV.add(lblNaKojiNain);
        
        rdbtnAnalogna = new JRadioButton("Direktno (analogna)");
        rdbtnAnalogna.setBounds(77, 32, 200, 23);
        prijemKablovskeTV.add(rdbtnAnalogna);
        
        rdbtnSetTop = new JRadioButton("Preko set-top boksa");
        rdbtnSetTop.setBounds(77, 60, 200, 23);
        prijemKablovskeTV.add(rdbtnSetTop);
        
        rdbtnCAM = new JRadioButton("Preko CAM modula");
        rdbtnCAM.setBounds(77, 86, 200, 23);
        prijemKablovskeTV.add(rdbtnCAM);
        
        ButtonGroup prijemKablovska = new ButtonGroup();
        prijemKablovska.add(rdbtnAnalogna);
        prijemKablovska.add(rdbtnSetTop);
        prijemKablovska.add(rdbtnCAM);
        
        JButton btnDalje_2 = new JButton("Dalje");
        btnDalje_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setPrijemKablovska(prijemKablovskaSelected());
        		if(tv.getPrijemKablovska()!=null){
        			cl.show(questionsPanel, SEKUNDARNIPRIJEM);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Greška", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_2.setBounds(273, 150, 89, 23);
        prijemKablovskeTV.add(btnDalje_2);
        
        JButton btnNazad_1 = new JButton("Nazad");
        btnNazad_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setPrijemKablovska(null);
        		cl.show(questionsPanel, PRIMARNIPRIJEM);
        	}
        });
        btnNazad_1.setBounds(36, 150, 89, 23);
        prijemKablovskeTV.add(btnNazad_1);
        
        JLabel lblDaLiImate = new JLabel("Da li imate jo\u0161 neki na\u010Din za prijem tv signala?");
        lblDaLiImate.setBounds(67, 11, 311, 14);
        sekundarPrijemTV.add(lblDaLiImate);
        
        rdbtnSekPrijemDa = new JRadioButton("Zemaljska (preko antene)");
        rdbtnSekPrijemDa.setBounds(77, 32, 200, 23);
        sekundarPrijemTV.add(rdbtnSekPrijemDa);
        
        rdbtnSekPrijemNe = new JRadioButton("Nemam");
        rdbtnSekPrijemNe.setBounds(77, 60, 200, 23);
        sekundarPrijemTV.add(rdbtnSekPrijemNe);
        
        ButtonGroup sekundarniPrijem = new ButtonGroup();
        sekundarniPrijem.add(rdbtnSekPrijemDa);
        sekundarniPrijem.add(rdbtnSekPrijemNe);
        
        JButton btnDalje_3 = new JButton("Dalje");
        btnDalje_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setSekundarniPrijem(sekundarniPrijemSelected());
        		if(sekPrijemSelected){
        			if(tv.getPrijemKablovska()==NacinPrijemaKablovska.ANALOGNA){
        				cl.show(questionsPanel, DODATNEMOGUCNOSTI);
        			}else{
        				cl.show(questionsPanel, INTERNET);
        			}
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Greška", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_3.setBounds(273, 150, 89, 23);
        sekundarPrijemTV.add(btnDalje_3);
        
        JButton btnNazad_2 = new JButton("Nazad");
        btnNazad_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setSekundarniPrijem(null);
        		if(tv.getNacinPrijema()==NacinPrijema.KABLOVSKA){
    				cl.show(questionsPanel, PRIJEMKABLOVSKA);
    			}else{
    				cl.show(questionsPanel, PRIJEMSATELITSKA);
    			}
        	}
        });
        btnNazad_2.setBounds(36, 150, 89, 23);
        sekundarPrijemTV.add(btnNazad_2);
        
        JLabel lblDaLiBiste = new JLabel("Da li biste uzeli dodatne mogu\u0107nosti koje nudi provajder?");
        lblDaLiBiste.setBounds(36, 11, 368, 14);
        dodMogucnostiTV.add(lblDaLiBiste);
        
        rdbtnDodMogDa = new JRadioButton("Da");
        rdbtnDodMogDa.setBounds(77, 32, 200, 23);
        dodMogucnostiTV.add(rdbtnDodMogDa);
        
        rdbtnDodMogNe = new JRadioButton("Ne");
        rdbtnDodMogNe.setBounds(77, 60, 200, 23);
        dodMogucnostiTV.add(rdbtnDodMogNe);
        
        ButtonGroup dodatneMogucnosti = new ButtonGroup();
        dodatneMogucnosti.add(rdbtnDodMogDa);
        dodatneMogucnosti.add(rdbtnDodMogNe);
        
        JButton btnDalje_4 = new JButton("Dalje");
        btnDalje_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setNoveMogucnosti(noveMogucnostiSelected());
        		if(dodMogucnostiSelected){
        				cl.show(questionsPanel, INTERNET);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Greška", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_4.setBounds(273, 150, 89, 23);
        dodMogucnostiTV.add(btnDalje_4);
        
        JButton btnNazad_3 = new JButton("Nazad");
        btnNazad_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setNoveMogucnosti(null);
        		cl.show(questionsPanel, SEKUNDARNIPRIJEM);
        	}
        });
        btnNazad_3.setBounds(36, 150, 89, 23);
        dodMogucnostiTV.add(btnNazad_3);
        
        JLabel lblDaLiImate_1 = new JLabel("Da li imate internet?");
        lblDaLiImate_1.setBounds(67, 11, 311, 14);
        internetTV.add(lblDaLiImate_1);
        
        rdbtnDaSaWifijem = new JRadioButton("Da sa Wi-Fi-jem");
        rdbtnDaSaWifijem.setBounds(77, 32, 200, 23);
        internetTV.add(rdbtnDaSaWifijem);
        
        rdbtnDaBezWifija = new JRadioButton("Da bez Wi-Fi-ja");
        rdbtnDaBezWifija.setBounds(77, 60, 200, 23);
        internetTV.add(rdbtnDaBezWifija);
        
        rdbtnInternetNe = new JRadioButton("Ne");
        rdbtnInternetNe.setBounds(77, 86, 200, 23);
        internetTV.add(rdbtnInternetNe);
        
        ButtonGroup internet = new ButtonGroup();
        internet.add(rdbtnDaSaWifijem);
        internet.add(rdbtnDaBezWifija);
        internet.add(rdbtnInternetNe);
        
        JButton btnDalje_5 = new JButton("Dalje");
        btnDalje_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setInternet(internetSelected());
        		if(tv.getInternet()!=null){
        				cl.show(questionsPanel, POZICIJATV);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Greška", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_5.setBounds(273, 150, 89, 23);
        internetTV.add(btnDalje_5);
        
        JButton btnNazad_4 = new JButton("Nazad");
        btnNazad_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			if(tv.getPrijemKablovska()==NacinPrijemaKablovska.ANALOGNA){
        				cl.show(questionsPanel, DODATNEMOGUCNOSTI);
        			}else{
        				cl.show(questionsPanel, SEKUNDARNIPRIJEM);
        			}
        	}
        });
        btnNazad_4.setBounds(36, 150, 89, 23);
        internetTV.add(btnNazad_4);
        
        JLabel lblKakoJePozicioniran = new JLabel("Kako je pozicioniran televizor u prostoriji?");
        lblKakoJePozicioniran.setBounds(67, 11, 311, 14);
        pozicijaTV.add(lblKakoJePozicioniran);
        
        rdbtnNaspramProzora = new JRadioButton("Naspram prozora");
        rdbtnNaspramProzora.setBounds(77, 32, 200, 23);
        pozicijaTV.add(rdbtnNaspramProzora);
        
        rdbtnIspredProzora = new JRadioButton("Ispred prozora");
        rdbtnIspredProzora.setBounds(77, 60, 200, 23);
        pozicijaTV.add(rdbtnIspredProzora);
        
        rdbtnProzorSaStrane = new JRadioButton("Prozor je sa strane");
        rdbtnProzorSaStrane.setBounds(77, 86, 200, 23);
        pozicijaTV.add(rdbtnProzorSaStrane);
        
        ButtonGroup pozicija = new ButtonGroup();
        pozicija.add(rdbtnNaspramProzora);
        pozicija.add(rdbtnIspredProzora);
        pozicija.add(rdbtnProzorSaStrane);
        
        JButton btnDalje_6 = new JButton("Dalje");
        btnDalje_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setPozicija(pozicijaSelected());
        		if(tv.getPozicija()!=null){
        				cl.show(questionsPanel, UDALJENOSTTV);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Greška", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_6.setBounds(273, 150, 89, 23);
        pozicijaTV.add(btnDalje_6);
        
        JButton btnNazad_5 = new JButton("Nazad");
        btnNazad_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(true){
    				cl.show(questionsPanel, INTERNET);
    			}/*else{
    				cl.show(questionsPanel, );
    			}*/
        	}
        });
        btnNazad_5.setBounds(36, 150, 89, 23);
        pozicijaTV.add(btnNazad_5);
        
        JLabel lblispisUdaljenosti = new JLabel("3.00m");
        lblispisUdaljenosti.setHorizontalAlignment(SwingConstants.RIGHT);
        lblispisUdaljenosti.setBounds(173, 93, 46, 14);
        udaljenostTV.add(lblispisUdaljenosti);
        JSlider udaljenost = new JSlider(50, 500, 300);
        udaljenost.setPaintTicks(true);
        udaljenost.setMinorTickSpacing(25);
        udaljenost.setMajorTickSpacing(100);
        udaljenost.setBounds(58, 37, 307, 45);
        udaljenostTV.add(udaljenost);
        
        Hashtable<Integer, JLabel> ispisUdaljenosti = new Hashtable<Integer, JLabel>();
        ispisUdaljenosti.put(new Integer( 50 ),new JLabel("0.5m") );
        ispisUdaljenosti.put(new Integer( 100 ),new JLabel("1m") );
        ispisUdaljenosti.put(new Integer( 150 ),new JLabel("1.5m") );
        ispisUdaljenosti.put(new Integer( 200 ),new JLabel("2m") );
        ispisUdaljenosti.put(new Integer( 250 ),new JLabel("2.5m") );
        ispisUdaljenosti.put(new Integer( 300 ),new JLabel("3m") );
        ispisUdaljenosti.put(new Integer( 350 ),new JLabel("3.5m") );
        ispisUdaljenosti.put(new Integer( 400 ),new JLabel("4m") );
        ispisUdaljenosti.put(new Integer( 450 ),new JLabel("4.5m") );
        ispisUdaljenosti.put(new Integer( 500 ),new JLabel("5m") );
        udaljenost.setLabelTable(ispisUdaljenosti);
        udaljenost.setPaintLabels(true);
        udaljenost.setSnapToTicks(true);
        
        udaljenost.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		String udaljenostOdTV = "";
        		if(String.valueOf(udaljenost.getValue()).length()==3){
        			udaljenostOdTV = String.valueOf(udaljenost.getValue()).substring(0,1) + "." + String.valueOf(udaljenost.getValue()).substring(1, 3) + "m";
        			}else{
        			udaljenostOdTV = "0." + String.valueOf(udaljenost.getValue()) + "m";
        			}
        		lblispisUdaljenosti.setText(udaljenostOdTV);
        		udaljenostOdEkrana = udaljenost.getValue();
        		//System.out.println(udaljenostOdEkrana);
        	}
        });
        
        JLabel lblKolikoJeTelevizor = new JLabel("Koliko je televizor udaljen od vas?");
        lblKolikoJeTelevizor.setBounds(58, 11, 330, 14);
        udaljenostTV.add(lblKolikoJeTelevizor);
        
        JButton btnDalje_7 = new JButton("Dalje");
        btnDalje_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setUdaljenostOdTV(((double) udaljenostOdEkrana)/100);
        		cl.show(questionsPanel, UREDJAJI);
        	}
        });
        btnDalje_7.setBounds(273, 150, 89, 23);
        udaljenostTV.add(btnDalje_7);
        
        JButton btnNazad_6 = new JButton("Nazad");
        btnNazad_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setUdaljenostOdTV(null);
        		cl.show(questionsPanel, POZICIJATV);
        	}
        });
        btnNazad_6.setBounds(36, 150, 89, 23);
        udaljenostTV.add(btnNazad_6);
        
        JLabel lblKojiUreajiSu = new JLabel("Koji ure\u0111aji su povezani na televizor?");
        lblKojiUreajiSu.setBounds(67, 11, 311, 14);
        uredjajiTV.add(lblKojiUreajiSu);
        
        chckbxRacunar = new JCheckBox("Ra\u010Dunar");
        chckbxRacunar.setBounds(77, 34, 97, 23);
        uredjajiTV.add(chckbxRacunar);
        
        chckbxDvd = new JCheckBox("DVD");
        chckbxDvd.setBounds(77, 60, 97, 23);
        uredjajiTV.add(chckbxDvd);
        
        chckbxSmartTvBox = new JCheckBox("Smart TV Box");
        chckbxSmartTvBox.setBounds(77, 86, 149, 23);
        uredjajiTV.add(chckbxSmartTvBox);
        
        chckbxKameraZaVideo = new JCheckBox("Kamera i DVR za video nadzor");
        chckbxKameraZaVideo.setBounds(77, 112, 263, 23);
        uredjajiTV.add(chckbxKameraZaVideo);
        
        JButton btnKraj = new JButton("Prika\u017Ei odgovor");
        btnKraj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setDodatniUredjaji(uredjajiSelected());
        		dispose();
        	}
        });
        btnKraj.setBounds(237, 150, 141, 23);
        uredjajiTV.add(btnKraj);
        
        JButton btnNazadKraj = new JButton("Nazad");
        btnNazadKraj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setDodatniUredjaji(null);
        		dodatniUredjaji = " ";
        		cl.show(questionsPanel, UDALJENOSTTV);
        	}
        });
        btnNazadKraj.setBounds(36, 150, 89, 23);
        uredjajiTV.add(btnNazadKraj);
        
        JLabel lblDaLiProgram = new JLabel("Da li program pratite preko provajdera ili slobodno?");
        lblDaLiProgram.setBounds(67, 11, 311, 14);
        prijemSatelitska.add(lblDaLiProgram);
        
        rdbtnPrekoProvajdera = new JRadioButton("Preko provajdera");
        rdbtnPrekoProvajdera.setBounds(77, 32, 200, 23);
        prijemSatelitska.add(rdbtnPrekoProvajdera);
        
        rdbtnSlobodno = new JRadioButton("Slobodno");
        rdbtnSlobodno.setBounds(77, 60, 200, 23);
        prijemSatelitska.add(rdbtnSlobodno);
        
        ButtonGroup prijemSatelita = new ButtonGroup();
        prijemSatelita.add(rdbtnPrekoProvajdera);
        prijemSatelita.add(rdbtnSlobodno);
        
        JButton btnDalje_8 = new JButton("Dalje");
        btnDalje_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setPrijemSatelitska(prijemSatelitskaSelected());
        		if(tv.getPrijemSatelitska()!=null){
        				cl.show(questionsPanel, SEKUNDARNIPRIJEM);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Greška", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_8.setBounds(273, 150, 89, 23);
        prijemSatelitska.add(btnDalje_8);
        
        JButton btnNazad_7 = new JButton("Nazad");
        btnNazad_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setPrijemSatelitska(null);
        		cl.show(questionsPanel, PRIMARNIPRIJEM);
        	}
        });
        btnNazad_7.setBounds(36, 150, 89, 23);
        prijemSatelitska.add(btnNazad_7);
    }
	
	private NacinPrijema nacinPrijemaSelected(){
		if(rdbtnKablovska.isSelected()){
			primarniPrijemPrograma = PRIJEMKABLOVSKA;
			return NacinPrijema.KABLOVSKA;
		}
		if(rdbtnSatelitska.isSelected()){
			primarniPrijemPrograma = PRIJEMSATELITSKA;
			return NacinPrijema.SATELITSKA;
		}
		if(rdbtnZemaljska.isSelected()){
			return NacinPrijema.ZEMALJSKA;
		}
		if(rdbtnNeKlasican.isSelected()){
			return NacinPrijema.NEPRATIKLASICAN;
		}
		return null;
	}
	
	private NacinPrijemaKablovska prijemKablovskaSelected(){
		if(rdbtnAnalogna.isSelected()){
			return NacinPrijemaKablovska.ANALOGNA;
		}
		if(rdbtnSetTop.isSelected()){
			return NacinPrijemaKablovska.SETTOPBOX;
		}
		if(rdbtnCAM.isSelected()){
			return NacinPrijemaKablovska.CAMMODUL;
		}
		return null;
	}
	
	private NacinPrijemaSatelitska prijemSatelitskaSelected(){
		if(rdbtnPrekoProvajdera.isSelected()){
			return NacinPrijemaSatelitska.PROVAJDER;
		}
		if(rdbtnSlobodno.isSelected()){
			return NacinPrijemaSatelitska.SLOBODNO;
		}
		return null;
	}
	
	private boolean sekundarniPrijemSelected(){
		if(rdbtnSekPrijemDa.isSelected()){
			sekPrijemSelected = true;
			return true;
		}
		if(rdbtnSekPrijemNe.isSelected()){
			sekPrijemSelected = true;
			return false;
		}
		return false;
	}
	
	private boolean noveMogucnostiSelected(){
		if(rdbtnDodMogDa.isSelected()){
			dodMogucnostiSelected = true;
			return true;
		}
		if(rdbtnDodMogNe.isSelected()){
			dodMogucnostiSelected = true;
			return false;
		}
		return false;
	}
	
	private Internet internetSelected(){
		if(rdbtnDaSaWifijem.isSelected()){
			return Internet.WIFI;
		}
		if(rdbtnDaBezWifija.isSelected()){
			return Internet.BEZWIFIJA;
		}
		if(rdbtnInternetNe.isSelected()){
			return Internet.NE;
		}
		return null;
	}
	
	private Pozicija pozicijaSelected(){
		if(rdbtnNaspramProzora.isSelected()){
			return Pozicija.NASPRAM;
		}
		if(rdbtnIspredProzora.isSelected()){
			return Pozicija.ISPRED;
		}
		if(rdbtnProzorSaStrane.isSelected()){
			return Pozicija.PORED;
		}
		return null;
	}
	
	private String uredjajiSelected(){
		if(chckbxRacunar.isSelected()){
			dodatniUredjaji+= " Raèunar ";
		}
		if(chckbxDvd.isSelected()){
			dodatniUredjaji+= " DVD ";
		}
		if(chckbxSmartTvBox.isSelected()){
			dodatniUredjaji+= " SmartTVBox ";
		}
		if(chckbxKameraZaVideo.isSelected()){
			dodatniUredjaji+= " VideoNadzor ";
		}
		return dodatniUredjaji;
	}
	/*
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<JRadioButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
        	JRadioButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
*/
	/**
	 * Create the frame.
	 */
	public FrmKupovinaTelevizora() {
		new FrmKupovinaTelevizora(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
