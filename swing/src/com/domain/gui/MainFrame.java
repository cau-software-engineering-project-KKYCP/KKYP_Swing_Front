package com.domain.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id_TextField;
	private JTextField pw_Textfield;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel main_Panel = new JPanel();
		main_Panel.setBounds(0, 0, 800, 580);
		contentPane.add(main_Panel);
		main_Panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("메인 페이지 예정");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel_1.setBounds(291, 214, 202, 83);
		main_Panel.add(lblNewLabel_1);
		
		JButton back_to_login_BTN = new JButton("←");
		back_to_login_BTN.setFont(new Font("굴림", Font.BOLD, 20));
		back_to_login_BTN.setBackground(UIManager.getColor("ToggleButton.light"));
		back_to_login_BTN.setBounds(12, 10, 60, 30);
		main_Panel.add(back_to_login_BTN);
		
		JPanel login_Panel = new JPanel();
		login_Panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		login_Panel.setBounds(500, 200, 264, 179);
		contentPane.add(login_Panel);
		login_Panel.setLayout(null);
		
		JLabel id_Label = new JLabel("ID : ");
		id_Label.setBounds(12, 32, 80, 40);
		id_Label.setHorizontalAlignment(SwingConstants.CENTER);
		id_Label.setFont(new Font("굴림", Font.BOLD, 16));
		login_Panel.add(id_Label);
		
		JLabel pw_Label = new JLabel("PW : ");
		pw_Label.setHorizontalAlignment(SwingConstants.CENTER);
		pw_Label.setFont(new Font("굴림", Font.BOLD, 16));
		pw_Label.setBounds(12, 75, 80, 40);
		login_Panel.add(pw_Label);
		
		id_TextField = new JTextField();
		id_TextField.setColumns(10);
		id_TextField.setBounds(104, 43, 106, 21);
		login_Panel.add(id_TextField);
		
		pw_Textfield = new JTextField();
		pw_Textfield.setColumns(10);
		pw_Textfield.setBounds(104, 86, 106, 21);
		login_Panel.add(pw_Textfield);
		
		JButton loginBTN = new JButton("로그인");
		loginBTN.setBackground(UIManager.getColor("ToggleButton.light"));
		loginBTN.setBounds(22, 125, 95, 23);
		login_Panel.add(loginBTN);
		
		main_Panel.setVisible(false);
		
		loginBTN.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					main_Panel.setVisible(true);
					login_Panel.setVisible(false);
				}
		});
		
		back_to_login_BTN.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					login_Panel.setVisible(true);	
					main_Panel.setVisible(false);
				}
		});
		
		JButton SignUpBTN = new JButton("회원가입");
		SignUpBTN.setBackground(UIManager.getColor("ToggleButton.light"));
		SignUpBTN.setBounds(129, 125, 95, 23);
		login_Panel.add(SignUpBTN);
	}
}
