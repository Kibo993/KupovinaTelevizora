package com.televizor;

import java.awt.EventQueue;

import com.televizor.Televizor;
import com.televizor.Enums.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class FrmKupovinaTelevizora extends JFrame{

	private JPanel contentPane;
	private static Televizor tv;
	private JPanel questionsPanel;
	private String primarniPrijemPrograma;
	private boolean sekPrijemSelected = false;
	private boolean dodMogucnostiSelected = false;
	private String nazadSaInterneta;
	private boolean closed = false;

	private static final long serialVersionUID = 1L;
	
	final static String CENATELEVIZORA = "Cena televizora";
    final static String PRIMARNIPRIJEM = "Primarni prijem programa";
    final static String PRIJEMKABLOVSKA = "Na\u010Din prijema kablovske";
    final static String PRIJEMSATELITSKA = "Na\u010Din prijema satelitske";
    final static String MESTOSTANOVANJA = "Mesto stanovanja";
    final static String UPOTREBA = "Za \u0161ta se televizor koristi";
    final static String SEKUNDARNIPRIJEM = "Sekundarni prijem programa";
    final static String DODATNEMOGUCNOSTI = "Dodatne mogu\u0107nosti";
    final static String INTERNET = "Internet";
    final static String POZICIJATV = "Pozicija tv-a u prostoriji";
    final static String UDALJENOSTTV = "Udaljenost od ekrana";
    final static String UREDJAJI = "Dodatni ure\u0111aji";
    
    private int maxCena = 100000;
    private int udaljenostOdEkrana = 300;
    private String dodatniUredjaji = "";
    private String neklasican = "";
    
    private JRadioButton rdbtnKablovska;
    private JRadioButton rdbtnSatelitska;
    private JRadioButton rdbtnZemaljska;
    private JRadioButton rdbtnNeKlasican;
    
    private JRadioButton rdbtnAnalogna;
    private JRadioButton rdbtnSetTop;
    private JRadioButton rdbtnCAM;
    
    private JRadioButton rdbtnPrekoProvajdera;
    private JRadioButton rdbtnSlobodno;
    
    private JRadioButton rdbtnGradsko;
    private JRadioButton rdbtnPrigradsko;
    private JRadioButton rdbtnSeosko;
    
    private JCheckBox chckbxGledanjeFilmova;
    private JCheckBox chckbxCitanjeVesti;
    private JCheckBox chckbxIgranjeIgrica;
    private JCheckBox chckbxStrimovanjeZabavnogSadrzaja;
    
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
    private JCheckBox chckbxKonzolaZaIgre;

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
	
	@SuppressWarnings("static-access")
	public FrmKupovinaTelevizora(Televizor tv) {
        this.tv = tv;
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(FrmKupovinaTelevizora.class.getResource("/image/iconfinder_television_286690.png")));
        this.setTitle("Kupovina televizora");
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				closed = true;
				dispose();
				TelevizorMain.zaustavi();
				TelevizorMain.showYourself();
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		questionsPanel = new JPanel();
		questionsPanel.setBounds(10, 38, 414, 198);
		contentPane.add(questionsPanel);
		questionsPanel.setLayout(new CardLayout(0, 0));

		CardLayout cl = (CardLayout)(questionsPanel.getLayout());
		
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
        
        JPanel mestoZemaljska = new JPanel();
        mestoZemaljska.setLayout(null);
        questionsPanel.add(mestoZemaljska, MESTOSTANOVANJA);
        
        JPanel neKlasican = new JPanel();
        neKlasican.setLayout(null);
        questionsPanel.add(neKlasican, UPOTREBA);
        
        JPanel sekundarPrijemTV = new JPanel();
        sekundarPrijemTV.setLayout(null);
        questionsPanel.add(sekundarPrijemTV, SEKUNDARNIPRIJEM);
        
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
        
        JPanel dodMogucnostiTV = new JPanel();
        dodMogucnostiTV.setLayout(null);
        questionsPanel.add(dodMogucnostiTV, DODATNEMOGUCNOSTI);
        
        JLabel lblIspisCene = new JLabel("100000 RSD");
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
        		lblIspisCene.setText(String.valueOf(cena.getValue()) + " RSD");
            	String value = String.valueOf(cena.getValue());
        		maxCena = Integer.parseInt(value);
        	}
        });
        cena.setBounds(58, 37, 307, 45);
        maxCenaTV.add(cena);
        
        JLabel lblOdaberiteNajviuCenu = new JLabel("Odaberite najvi\u0161u cenu koju ste spremni da platite:");
        lblOdaberiteNajviuCenu.setBounds(58, 11, 330, 14);
        maxCenaTV.add(lblOdaberiteNajviuCenu);

        lblIspisCene.setBounds(167, 93, 79, 14);
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
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
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
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
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
        				cl.show(questionsPanel, INTERNET);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
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
        
        JLabel lblDaLiBiste = new JLabel("Da li \u017Eelite nove mogu\u0107nosti?");
        lblDaLiBiste.setBounds(69, 11, 335, 14);
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
        
        JButton btnKraj = new JButton("Prika\u017Ei odgovor");
        btnKraj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setNoveMogucnosti(noveMogucnostiSelected());
        		if(dodMogucnostiSelected){
        			dispose();
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnKraj.setBounds(237, 150, 141, 23);
        dodMogucnostiTV.add(btnKraj);
        
        JButton btnNazadKraj = new JButton("Nazad");
        btnNazadKraj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setNoveMogucnosti(null);
        		cl.show(questionsPanel, UREDJAJI);
        	}
        });
        btnNazadKraj.setBounds(36, 150, 89, 23);
        dodMogucnostiTV.add(btnNazadKraj);
        
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
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_5.setBounds(273, 150, 89, 23);
        internetTV.add(btnDalje_5);
        
        JButton btnNazad_4 = new JButton("Nazad");
        btnNazad_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        				cl.show(questionsPanel, nazadSaInterneta);
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
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
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
        
        chckbxKonzolaZaIgre = new JCheckBox("Konzola za video igrice");
        chckbxKonzolaZaIgre.setBounds(77, 112, 263, 23);
        uredjajiTV.add(chckbxKonzolaZaIgre);
        
        JButton btnDalje_4 = new JButton("Dalje");
        btnDalje_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setDodatniUredjaji(uredjajiSelected());
        		dodatniUredjaji = "";
        		cl.show(questionsPanel, DODATNEMOGUCNOSTI);
        	}
        });
        btnDalje_4.setBounds(273, 150, 89, 23);
        uredjajiTV.add(btnDalje_4);
        
        JButton btnNazad_3 = new JButton("Nazad");
        btnNazad_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setDodatniUredjaji(null);
        		dodatniUredjaji = "";
        		cl.show(questionsPanel, UDALJENOSTTV);
        	}
        });
        btnNazad_3.setBounds(36, 150, 89, 23);
        uredjajiTV.add(btnNazad_3);
        
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
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
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
        
        JLabel lblNaKakvomPodruju = new JLabel("Na kakvom podru\u010Dju \u017Eivite?");
        lblNaKakvomPodruju.setBounds(67, 11, 311, 14);
        mestoZemaljska.add(lblNaKakvomPodruju);
        
        rdbtnGradsko = new JRadioButton("Gradsko");
        rdbtnGradsko.setBounds(77, 32, 200, 23);
        mestoZemaljska.add(rdbtnGradsko);
        
        rdbtnPrigradsko = new JRadioButton("Prigradsko");
        rdbtnPrigradsko.setBounds(77, 60, 200, 23);
        mestoZemaljska.add(rdbtnPrigradsko);
        
        rdbtnSeosko = new JRadioButton("Seosko");
        rdbtnSeosko.setBounds(77, 86, 200, 23);
        mestoZemaljska.add(rdbtnSeosko);
        
        ButtonGroup mestoStanovanja = new ButtonGroup();
        mestoStanovanja.add(rdbtnGradsko);
        mestoStanovanja.add(rdbtnPrigradsko);
        mestoStanovanja.add(rdbtnSeosko);
        
        JButton btnDalje_9 = new JButton("Dalje");
        btnDalje_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setMestoStanovanja(mestoStanovanjaSelected());
        		if(tv.getMestoStanovanja()!=null){
        				cl.show(questionsPanel, INTERNET);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju!", "Gre\u0161ka", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        btnDalje_9.setBounds(273, 150, 89, 23);
        mestoZemaljska.add(btnDalje_9);
        
        JButton btnNazad_8 = new JButton("Nazad");
        btnNazad_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setMestoStanovanja(null);
        		cl.show(questionsPanel, PRIMARNIPRIJEM);
        	}
        });
        btnNazad_8.setBounds(36, 150, 89, 23);
        mestoZemaljska.add(btnNazad_8);
               
        JLabel lblZaKojiSadraj = new JLabel("Za koji sadr\u017Eaj naj\u010De\u0161\u0107e koristite televizor?");
        lblZaKojiSadraj.setBounds(67, 11, 311, 14);
        neKlasican.add(lblZaKojiSadraj);
        
        chckbxGledanjeFilmova = new JCheckBox("Gledanje filmova");
        chckbxGledanjeFilmova.setBounds(77, 34, 169, 23);
        neKlasican.add(chckbxGledanjeFilmova);
        
        chckbxCitanjeVesti = new JCheckBox("\u010Citanje vesti");
        chckbxCitanjeVesti.setBounds(77, 60, 97, 23);
        neKlasican.add(chckbxCitanjeVesti);
        
        chckbxIgranjeIgrica = new JCheckBox("Igranje igrica");
        chckbxIgranjeIgrica.setBounds(77, 86, 149, 23);
        neKlasican.add(chckbxIgranjeIgrica);
        
        chckbxStrimovanjeZabavnogSadrzaja = new JCheckBox("Strimovanje zabavnog sadr\u017Eaja");
        chckbxStrimovanjeZabavnogSadrzaja.setBounds(77, 112, 263, 23);
        neKlasican.add(chckbxStrimovanjeZabavnogSadrzaja);
        
        JButton btnDalje_10 = new JButton("Dalje");
        btnDalje_10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setNeklasicanSadrzaj(neklasicanSelected());
        				cl.show(questionsPanel, INTERNET);
        				neklasican = "";
        	}
        });
        btnDalje_10.setBounds(273, 150, 89, 23);
        neKlasican.add(btnDalje_10);
        
        JButton btnNazad_9 = new JButton("Nazad");
        btnNazad_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setNeklasicanSadrzaj(null);
        		neklasican = "";
        		cl.show(questionsPanel, PRIMARNIPRIJEM);
        	}
        });
        btnNazad_9.setBounds(36, 150, 89, 23);
        neKlasican.add(btnNazad_9);
    }
	
	private NacinPrijema nacinPrijemaSelected(){
		if(rdbtnKablovska.isSelected()){
			primarniPrijemPrograma = PRIJEMKABLOVSKA;
			nazadSaInterneta = SEKUNDARNIPRIJEM;
			return NacinPrijema.KABLOVSKA;
		}
		if(rdbtnSatelitska.isSelected()){
			primarniPrijemPrograma = PRIJEMSATELITSKA;
			nazadSaInterneta = SEKUNDARNIPRIJEM;
			return NacinPrijema.SATELITSKA;
		}
		if(rdbtnZemaljska.isSelected()){
			primarniPrijemPrograma = MESTOSTANOVANJA;
			nazadSaInterneta = MESTOSTANOVANJA;
			return NacinPrijema.ZEMALJSKA;
		}
		if(rdbtnNeKlasican.isSelected()){
			primarniPrijemPrograma = UPOTREBA;
			nazadSaInterneta = UPOTREBA;
			return NacinPrijema.NEPRATIKLASICAN;
		}
		return null;
	}
	
	private PrijemKablovska prijemKablovskaSelected(){
		if(rdbtnAnalogna.isSelected()){
			return PrijemKablovska.ANALOGNA;
		}
		if(rdbtnSetTop.isSelected()){
			return PrijemKablovska.SETTOPBOX;
		}
		if(rdbtnCAM.isSelected()){
			return PrijemKablovska.CAMMODUL;
		}
		return null;
	}
	
	private PrijemSatelitska prijemSatelitskaSelected(){
		if(rdbtnPrekoProvajdera.isSelected()){
			return PrijemSatelitska.PROVAJDER;
		}
		if(rdbtnSlobodno.isSelected()){
			return PrijemSatelitska.SLOBODNO;
		}
		return null;
	}
	
	private MestoStanovanja mestoStanovanjaSelected(){
		if(rdbtnGradsko.isSelected()){
			return MestoStanovanja.GRADSKO;
		}
		if(rdbtnPrigradsko.isSelected()){
			return MestoStanovanja.PRIGRADSKO;
		}
		if(rdbtnSeosko.isSelected()){
			return MestoStanovanja.SEOSKO;
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
			dodatniUredjaji+= " Racunar ";
		}
		if(chckbxDvd.isSelected()){
			dodatniUredjaji+= " DVD ";
		}
		if(chckbxSmartTvBox.isSelected()){
			dodatniUredjaji+= " SmartTVBox ";
		}
		if(chckbxKonzolaZaIgre.isSelected()){
			dodatniUredjaji+= " VideoIgre ";
		}
		return dodatniUredjaji;
	}
	
	private String neklasicanSelected(){
		if(chckbxGledanjeFilmova.isSelected()){
			neklasican+= " Film ";
		}
		if(chckbxCitanjeVesti.isSelected()){
			neklasican+= " Vesti ";
		}
		if(chckbxIgranjeIgrica.isSelected()){
			neklasican+= " Igrice ";
		}
		if(chckbxStrimovanjeZabavnogSadrzaja.isSelected()){
			neklasican+= " Strim ";
		}
		return neklasican;
	}
	
	public boolean isClosed(){
		return closed;
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
