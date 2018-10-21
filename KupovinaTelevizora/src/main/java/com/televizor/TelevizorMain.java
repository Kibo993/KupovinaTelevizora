package com.televizor;

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
	// VIDI KAKO DA JDBC DRIVER MOZE I DA SE POZOVE KAD SE SKINE SA GIT HUBA!!!!
private JPanel contentPane;
	
	private static TelevizorThread tv;
	private static TelevizorMain frame;

	private static final long serialVersionUID = 1L;

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
		this.setResizable(false);
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
