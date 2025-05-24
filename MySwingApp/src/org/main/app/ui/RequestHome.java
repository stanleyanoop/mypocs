package org.main.app.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RequestHome {

	public JPanel renderUi (JFrame frame) {
		System.out.println("Going to render UI");
		JPanel home = (JPanel) frame.getContentPane();
		System.out.println("checkign the component from the frame ::" + home.getName());
		home.setLayout(new BorderLayout());
		
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new GridLayout(1,2));
		JLabel userLabel = new JLabel("User Name");
		JTextField userTextField = new JTextField(20);
		userPanel.add(userLabel);
		userPanel.add(userTextField);

		JPanel passPanel = new JPanel();
		passPanel.setLayout(new GridLayout(1,2));
		JLabel passLabel = new JLabel("Password");
		JPasswordField passwordField = new JPasswordField(20);
        passwordField.setText(""); // Set text to an empty string
        passPanel.add(passLabel);
        passPanel.add(passwordField);

		JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
        	System.out.println(">>>>>>>" + userPanel.getComponentCount());
        	System.out.println(userTextField.getText());
        	System.out.println(passwordField.getPassword());
        });
//        loginButton.setSize(60, 40);
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new FlowLayout());
        formPanel.add(userPanel);
        formPanel.add(passPanel);
        
		JLabel loginLabel = new JLabel("Login to the System");
		loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        home.add(loginLabel, BorderLayout.NORTH);
        
//        frame.getContentPane().add(homePanel);
        home.add(formPanel, BorderLayout.CENTER);
        home.add(loginButton, BorderLayout.SOUTH);
        frame.setSize(600, 400);
//        frame.setVisible(true);
        
        return home;
		
		
	}

	private JPanel getPanel(String panelName) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		JLabel label = new JLabel(panelName);
		panel.add(label);
		
		if (panelName != null && panelName.equalsIgnoreCase("Password")) {
			JPasswordField passwordField = new JPasswordField(20);
	        passwordField.setText(""); // Set text to an empty string
	        panel.add(passwordField);
		} else {
			JTextField textField = new JTextField(20);
			panel.add(textField);

		}
		return panel;
	}
}
