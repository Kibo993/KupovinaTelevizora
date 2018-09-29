package com.sample;

import java.awt.EventQueue;

import com.sample.Televizor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;

public class FrmKupovinaTelevizora extends JFrame{

	private JPanel contentPane;
	private static Televizor tv;
	private JPanel questionsPanel;
	private String primarniPrijemPrograma;
	private String nacinPrijemaKablovske;
	
	final static String CENATELEVIZORA = "Cena televizora";
    final static String PRIMARNIPRIJEM = "Primarni prijem programa";
    final static String PRIJEMKABLOVSKA = "Naèin prijema kablovske";
    final static String SEKUNDARNIPRIJEM = "Sekundarni prijem programa";
    
    private int maxCena = 100000;
    
    private JRadioButton rdbtnKablovska;
    private JRadioButton rdbtnSatelitska;
    private JRadioButton rdbtnZemaljska;
    private JRadioButton rdbtnNeKlasican;
    
    private JRadioButton rdbtnAnalogna;
    private JRadioButton rdbtnSetTop;
    private JRadioButton rdbtnCAM;
    
    JRadioButton rdbtnSekPrijemDa;
    JRadioButton rdbtnSekPrijemNe;

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
		String comboBoxItems[] = { CENATELEVIZORA, PRIMARNIPRIJEM };
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
		
		JPanel card1 = new JPanel();
		card1.setLayout(null);
		questionsPanel.add(card1, CENATELEVIZORA);
        
        JPanel card2 = new JPanel();
        card2.setLayout(null);
        questionsPanel.add(card2, PRIMARNIPRIJEM);
        
        JPanel card3cable = new JPanel();
        card3cable.setLayout(null);
        questionsPanel.add(card3cable, PRIJEMKABLOVSKA);
        
        JPanel card4cable = new JPanel();
        card4cable.setLayout(null);
        questionsPanel.add(card4cable, SEKUNDARNIPRIJEM);
        
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
        card1.add(cena);
        
        JLabel lblOdaberiteNajviuCenu = new JLabel("Odaberite najvi\u0161u cenu koju ste spremni da platite:");
        lblOdaberiteNajviuCenu.setBounds(58, 11, 330, 14);
        card1.add(lblOdaberiteNajviuCenu);
        
        //JLabel lblIspisCene = new JLabel("New label");
        lblIspisCene.setBounds(182, 93, 46, 14);
        card1.add(lblIspisCene);
        
        JButton btnDalje = new JButton("Dalje");
        btnDalje.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setCena(maxCena);
        		cl.next(questionsPanel);
        	}
        });
        btnDalje.setBounds(299, 149, 89, 23);
        card1.add(btnDalje);
        
        JLabel lblNacin = new JLabel("Na koji na\u010Din primarno primate televizijski program?");
        lblNacin.setBounds(67, 11, 311, 14);
        card2.add(lblNacin);
        
        rdbtnKablovska = new JRadioButton("Kablovska");
        rdbtnKablovska.setBounds(77, 32, 200, 23);
        card2.add(rdbtnKablovska);
        
        rdbtnSatelitska = new JRadioButton("Satelitska");
        rdbtnSatelitska.setBounds(77, 60, 200, 23);
        card2.add(rdbtnSatelitska);
        
        rdbtnZemaljska = new JRadioButton("Zemaljska (antenska)");
        rdbtnZemaljska.setBounds(77, 86, 200, 23);
        card2.add(rdbtnZemaljska);
        
        rdbtnNeKlasican = new JRadioButton("Ne pratim klasi\u010Dan tv program");
        rdbtnNeKlasican.setBounds(77, 112, 200, 23);
        card2.add(rdbtnNeKlasican);
        
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
        card2.add(btnDalje_1);
        
        JButton btnNazad = new JButton("Nazad");
        btnNazad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tv.setNacinPrijema(null);
        		cl.previous(questionsPanel);
        	}
        });
        btnNazad.setBounds(36, 150, 89, 23);
        card2.add(btnNazad);
        
        
        
        JLabel lblNaKojiNain = new JLabel("Na koji na\u010Din primate signal sa kablovske?");
        lblNaKojiNain.setBounds(67, 11, 311, 14);
        card3cable.add(lblNaKojiNain);
        
        rdbtnAnalogna = new JRadioButton("Direktno (analogna)");
        rdbtnAnalogna.setBounds(77, 32, 200, 23);
        card3cable.add(rdbtnAnalogna);
        
        rdbtnSetTop = new JRadioButton("Preko set-top boksa");
        rdbtnSetTop.setBounds(77, 60, 200, 23);
        card3cable.add(rdbtnSetTop);
        
        rdbtnCAM = new JRadioButton("Preko CAM modula");
        rdbtnCAM.setBounds(77, 86, 200, 23);
        card3cable.add(rdbtnCAM);
        
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
        card3cable.add(btnDalje_2);
        
        JButton btnNazad_1 = new JButton("Nazad");
        btnNazad_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setPrijemKablovska(null);
        		cl.show(questionsPanel, PRIMARNIPRIJEM);
        	}
        });
        btnNazad_1.setBounds(36, 150, 89, 23);
        card3cable.add(btnNazad_1);
        
        JLabel lblDaLiImate = new JLabel("Da li imate jo\u0161 neki na\u010Din za prijem tv signala?");
        lblDaLiImate.setBounds(67, 11, 311, 14);
        card4cable.add(lblDaLiImate);
        
        rdbtnSekPrijemDa = new JRadioButton("Zemaljska (preko antene)");
        rdbtnSekPrijemDa.setBounds(77, 32, 200, 23);
        card4cable.add(rdbtnSekPrijemDa);
        
        rdbtnSekPrijemNe = new JRadioButton("Nemam");
        rdbtnSekPrijemNe.setBounds(77, 60, 200, 23);
        card4cable.add(rdbtnSekPrijemNe);
        
        ButtonGroup sekundarniPrijem = new ButtonGroup();
        sekundarniPrijem.add(rdbtnSekPrijemDa);
        sekundarniPrijem.add(rdbtnSekPrijemNe);
        
        JButton btnDalje_3 = new JButton("Dalje");
        btnDalje_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setSekundarniPrijem(sekundarniPrijemSelected());
        		/*if(tv.getPrijemKablovska()!=null){
        			cl.show(questionsPanel, SEKUNDARNIPRIJEM);
        		}else{
        			JOptionPane.showMessageDialog(contentPane, "Morate odabrati opciju", "Greška", JOptionPane.ERROR_MESSAGE);
        		}*/
        		/*System.out.println(tv.getCena());
        		System.out.println(tv.getNacinPrijema());
        		System.out.println(tv.getPrijemKablovska());
        		System.out.println(tv.getSekundarniPrijem());*/
        	}
        });
        btnDalje_3.setBounds(273, 150, 89, 23);
        card4cable.add(btnDalje_3);
        
        JButton btnNazad_2 = new JButton("Nazad");
        btnNazad_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tv.setSekundarniPrijem(null);
        		cl.show(questionsPanel, PRIJEMKABLOVSKA);
        	}
        });
        btnNazad_2.setBounds(36, 150, 89, 23);
        card4cable.add(btnNazad_2);
		
    }
	
	private NacinPrijema nacinPrijemaSelected(){
		if(rdbtnKablovska.isSelected()){
			primarniPrijemPrograma = PRIJEMKABLOVSKA;
			return NacinPrijema.KABLOVSKA;
		}
		if(rdbtnSatelitska.isSelected()){
			primarniPrijemPrograma = null;
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
	
	private boolean sekundarniPrijemSelected(){
		if(rdbtnSekPrijemDa.isSelected()){
			return true;
		}
		if(rdbtnSekPrijemNe.isSelected()){
			return false;
		}
		return false;
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
