package org.main.app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.main.app.ui.RequestHome;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RequestHome home = new RequestHome();
		JFrame frame = new JFrame("Basic Components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        CardLayout cards = new CardLayout();
//
//        //Login Screen
//        JPanel login = new JPanel();
//		login.setLayout(new BorderLayout());
//        JLabel loginLabel = new JLabel("Login to the System");
//        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
//        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        login.add(loginLabel, BorderLayout.NORTH);
//		cards.addLayoutComponent(login, "Login");
//      
//		//Home Screen
//
//        frame.getContentPane().setLayout(cards);
//        

		JPanel homePanel = home.renderUi(frame);
		frame.setVisible(true);
	
//		cards.show(frame.getContentPane(), "login");
	}

}
