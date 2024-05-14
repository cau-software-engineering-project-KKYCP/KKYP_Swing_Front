package com.domain.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;



public class LoginPanel extends JPanel{
	private MainFrame frame;
	
	private JTextField id_TextField;
	private JPasswordField pw_TextField;
	
	public LoginPanel(MainFrame frame) {
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
		
		JButton loginBTN = new JButton("로그인");
		loginBTN.setBackground(UIManager.getColor("ToggleButton.light"));
		loginBTN.setBounds(440, 300, 95, 25);
		add(loginBTN);
		
		JButton signUpBTN = new JButton("회원가입");
		signUpBTN.setBackground(UIManager.getColor("ToggleButton.light"));
		signUpBTN.setBounds(550, 300, 95, 25);
		add(signUpBTN);
		
		loginBTN.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                    String userID = id_TextField.getText();
                    String password = new String(pw_TextField.getPassword());
                    String encoding = Base64.getEncoder().encodeToString((userID + ":" + password).getBytes("UTF-8")); 
                    /* HTTP Basic Authentication
                     * 사용자 아이디와 비밀번호를 콜론(:)으로 구분하여 하나의 문자열 encoding에 저장 -> UTF-8로 인코딩 변환 -> Base.64로 인코딩 변환
                     */
                    
                    URL url = new URL("http://localhost:8080/test");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //연결할 서버 URL로 연결
                    connection.setRequestMethod("GET"); //HTTP 요청방식 "Get"
                    connection.setRequestProperty("Authorization", "Basic " + encoding);  //HTTP 요청에 Authorization 헤더 추가함. (Base64로 인코딩 된 것 인증 수행)

                    int responseCode = connection.getResponseCode(); // connection으로 부터 response 코드 받아옴
                    System.out.println("Response Code : " + responseCode);

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //응답 내용을 읽기 위한 BufferReader (설명 추가 필요)
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) { // 서버로 부터 받은 응답을 한 줄씩 읽어 response 변수에 추가
                        response.append(inputLine);
                    }
                    in.close(); //응답 모두 읽으면 BufferReader 닫음.

                    // 서버로부터 받은 응답을 출력
                    System.out.println(response.toString());
                    
                    if(responseCode == HttpURLConnection.HTTP_OK) { //200 == HTTP_OK
    					frame.showPanel("HomePanel");
    				}

                } 
				catch (Exception ex) {
                    ex.printStackTrace();
                }
			}	
		});
		
		signUpBTN.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.showPanel("SignUpPanel");
				}
		});

		
	}
	
}
