package com.sample;

import java.awt.EventQueue;
import com.sample.Televizor;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	
	final static String CENATELEVIZORA = "Cena televizora";
    final static String TEXTPANEL = "Card with JTextField";
    
    private int maxCena = 100000;
    private JTextField textField;
    private JTextField textField_1;
    
    private JRadioButton rdbtnKablovska;
    private JRadioButton rdbtnSatelitska;
    private JRadioButton rdbtnZemaljska;
    private JRadioButton rdbtnNeKlasican;

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
		
		String comboBoxItems[] = { CENATELEVIZORA, TEXTPANEL };
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
        
        JPanel card2 = new JPanel();
		
        questionsPanel.add(card1, CENATELEVIZORA);
        card1.setLayout(null);
        
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
        questionsPanel.add(card2, TEXTPANEL);
        card2.setLayout(null);
        
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
        		//System.out.println(tv.getCena());
        		//System.out.println(tv.getNacinPrijema());
        	}
        });
        btnDalje_1.setBounds(273, 150, 89, 23);
        card2.add(btnDalje_1);
        
        JButton btnNazad = new JButton("Nazad");
        btnNazad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		cl.previous(questionsPanel);
        	}
        });
        btnNazad.setBounds(36, 150, 89, 23);
        card2.add(btnNazad);
        
        
        JPanel panel = new JPanel();
        questionsPanel.add(panel, "name_677571976094");
        
        textField = new JTextField("TextField", 20);
        panel.add(textField);
        
        JPanel panel_1 = new JPanel();
        questionsPanel.add(panel_1, "name_697106602720");
        
        textField_1 = new JTextField("TextField", 20);
        panel_1.add(textField_1);
		
		
		
    }
	
	private NacinPrijema nacinPrijemaSelected(){
		if(rdbtnKablovska.isSelected()){
			return NacinPrijema.KABLOVSKA;
		}
		if(rdbtnSatelitska.isSelected()){
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
