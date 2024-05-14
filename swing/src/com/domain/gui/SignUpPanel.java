package com.domain.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class SignUpPanel extends JPanel{
	private MainFrame frame;
	
	private JTextField id_TextField;
	private JPasswordField pw_TextField;
	
	public SignUpPanel(MainFrame frame) {
		this.frame = frame;
		
		JLabel id_Label = new JLabel("ID : ");
		id_Label.setBounds(440, 198, 80, 30);
		id_Label.setHorizontalAlignment(SwingConstants.CENTER);
		id_Label.setFont(new Font("굴림", Font.BOLD, 16));
		add(id_Label);
		
		JLabel pw_Label = new JLabel("PW : ");
		pw_Label.setHorizontalAlignment(SwingConstants.CENTER);
		pw_Label.setFont(new Font("굴림", Font.BOLD, 16));
		pw_Label.setBounds(440, 248, 80, 30);
		add(pw_Label);
		
		id_TextField = new JTextField();
		id_TextField.setColumns(20);
		id_TextField.setBounds(500, 200, 110, 25);
		add(id_TextField);
		
		pw_TextField = new JPasswordField();
		pw_TextField.setColumns(20);
		pw_TextField.setBounds(500, 250, 110, 25);
		add(pw_TextField);
		
		JButton back_to_login_BTN = new JButton("←");
		back_to_login_BTN.setFont(new Font("굴림", Font.BOLD, 20));
		back_to_login_BTN.setBackground(UIManager.getColor("ToggleButton.light"));
		back_to_login_BTN.setBounds(12, 10, 60, 30);
		add(back_to_login_BTN);
		
		JButton signUpBTN = new JButton("회원가입");
		signUpBTN.setBackground(UIManager.getColor("ToggleButton.light"));
		signUpBTN.setBounds(450, 300, 170, 25);
		add(signUpBTN);
		
		back_to_login_BTN.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.showPanel("LoginPanel");
				}
		});
		
		signUpBTN.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
	                // 서버로 보낼 데이터 준비
	                String username = id_TextField.getText();
	                String password = new String(pw_TextField.getPassword());
	                String parameters = "username=" + username + "&password=" + password;

	                // HTTP 연결 설정
	                URL url = new URL("http://localhost:8080/signup");
	                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	                connection.setRequestMethod("POST");
	                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	                connection.setDoOutput(true);

	                // 데이터 전송
	                try (OutputStream os = connection.getOutputStream()) {
	                    byte[] input = parameters.getBytes(StandardCharsets.UTF_8);
	                    os.write(input, 0, input.length);
	                }

	                // 응답 코드 확인
	                int responseCode = connection.getResponseCode();
	                System.out.println("Response Code : " + responseCode);
	                
	                if(responseCode == HttpURLConnection.HTTP_CREATED) { //201 == HTTP_CREATED
	                	frame.showPanel("LoginPanel");
    				}

	            } 
				catch (Exception ex) {
	                ex.printStackTrace();
	            }
				
				
			}
		});
	}
}
