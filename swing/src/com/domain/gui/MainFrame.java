package com.domain.gui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	CardLayout cardLayout = new CardLayout();
	private static final long serialVersionUID = 1L;
	JPanel contentPane = new JPanel(cardLayout);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		LoginPanel loginPanel = new LoginPanel(this);
		loginPanel.setLayout(null);
		
		contentPane.add(loginPanel, "LoginPanel");
		
		HomePanel homePanel = new HomePanel(this);
		homePanel.setLayout(null);
		contentPane.add(homePanel, "HomePanel");
		
		SignUpPanel signUpPanel = new SignUpPanel(this);
		signUpPanel.setLayout(null);
		contentPane.add(signUpPanel, "SignUpPanel");
		
		add(contentPane);
	}
	
	public void showPanel(String panelname) {
		cardLayout.show(contentPane, panelname);
	}
	

}
