package com.domain.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class HomePanel extends JPanel{
	private MainFrame frame;
	
	public HomePanel(MainFrame frame) {
		this.frame = frame;
		
		JLabel lblNewLabel_1 = new JLabel("메인 페이지 예정");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(291, 214, 202, 83);
		add(lblNewLabel_1);
		
		JButton back_to_login_BTN = new JButton("←");
		back_to_login_BTN.setFont(new Font("굴림", Font.BOLD, 20));
		back_to_login_BTN.setBackground(UIManager.getColor("ToggleButton.light"));
		back_to_login_BTN.setBounds(12, 10, 60, 30);
		add(back_to_login_BTN);
		
		back_to_login_BTN.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.showPanel("LoginPanel");
				}
		});
	}
}
