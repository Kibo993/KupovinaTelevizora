package com.sample;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmKupovinaTelevizora extends JFrame{

	private JPanel contentPane;
	private static Televizor tv;
	private JPanel questionsPanel;
	
	final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKupovinaTelevizora frame = new FrmKupovinaTelevizora();
					frame.setVisible(true);
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
    }

	/**
	 * Create the frame.
	 */
	public FrmKupovinaTelevizora() {
		new FrmKupovinaTelevizora(tv).setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		questionsPanel = new JPanel();
		questionsPanel.setBounds(54, 38, 327, 198);
		contentPane.add(questionsPanel);
		questionsPanel.setLayout(new CardLayout(0, 0));
		
		//Container pane = new Container(frame.getContentPane());
		
		String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
		
		JComboBox comboBox = new JComboBox(comboBoxItems);
		comboBox.setBounds(141, 7, 161, 20);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(questionsPanel.getLayout());
		        cl.show(questionsPanel, (String)comboBox.getSelectedItem());
			}
		});
		contentPane.add(comboBox);
		
		JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
		
        questionsPanel.add(card1, BUTTONPANEL);
        questionsPanel.add(card2, TEXTPANEL);
		
        //pane.add(comboBoxPane, BorderLayout.PAGE_START);
        //pane.add(questionsPanel, BorderLayout.CENTER);
	}
	
}
