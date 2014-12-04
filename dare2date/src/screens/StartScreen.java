/*
 * Created by JFormDesigner on Fri Mar 14 15:33:56 CET 2014
 */

package screens;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import profile.Member;
import profile.NonMember;
import dare2date.Main1;

/**
 * @author don gourdet
 */
public class StartScreen extends JPanel {
	
	public static Member member;
	public boolean login = false;
	public StartScreen() {
		initComponents();
		
	}

	
	private void button_signInActionPerformed(ActionEvent e) {
		// TODO add your code here
		member = new Member(textField_userName.getText().toString(),
							passwordField_userPassword.getText().toString());
		System.out.println(member);

		login = member.logIn();
		System.out.println("login is: " + login);
		
		if(login){
			Main1.gui.getContentPane().removeAll();
			Main1.gui.getContentPane().add(new ProfileScreen());
			Main1.gui.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "Username and Password is incorrect or does not exist! ",
						"Invalid username/Password", JOptionPane.ERROR_MESSAGE);	
		}
		

		
	}
			
		
		
		
		
		
		

	private void label_SignUpMouseClicked(MouseEvent e) {
		// TODO add your code here
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new SignUpScreen());
		Main1.gui.setVisible(true);
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		textField_userName = new JTextField();
		passwordField_userPassword = new JPasswordField();
		button_signIn = new JButton();
		label_SignUp = new JLabel();
		label_Icon = new JLabel();
		label_ForgotPassword = new JLabel();
		label_Email = new JLabel();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- button_signIn ----
		button_signIn.setText("Sign in");
		button_signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_signInActionPerformed(e);
			}
		});

		//---- label_SignUp ----
		label_SignUp.setText("Sign up");
		label_SignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label_SignUpMouseClicked(e);
			}
		});

		//---- label_Icon ----
		label_Icon.setIcon(new ImageIcon(getClass().getResource("/resources/dare2date_logo.png")));
		label_Icon.setHorizontalAlignment(SwingConstants.CENTER);

		//---- label_ForgotPassword ----
		label_ForgotPassword.setText("Forgot password? :(");

		//---- label_Email ----
		label_Email.setText("Email");

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(label_Icon, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
					.addGap(191, 191, 191)
					.addGroup(layout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
							.addGroup(layout.createSequentialGroup()
								.addComponent(label_ForgotPassword)
								.addGap(141, 141, 141)
								.addComponent(label_SignUp, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, GroupLayout.PREFERRED_SIZE))
							.addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup()
								.addComponent(label_Email)
								.addComponent(passwordField_userPassword, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_userName, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addGap(114, 114, 114)
							.addComponent(button_signIn)
							.addGap(117, 117, 117)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(8, 8, 8)
					.addComponent(label_Icon)
					.addGap(113, 113, 113)
					.addComponent(textField_userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(label_Email)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(passwordField_userPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label_ForgotPassword)
						.addComponent(label_SignUp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18, 18, 18)
					.addComponent(button_signIn)
					.addGap(150, 150, 150))
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JTextField textField_userName;
	private JPasswordField passwordField_userPassword;
	private JButton button_signIn;
	private JLabel label_SignUp;
	private JLabel label_Icon;
	private JLabel label_ForgotPassword;
	private JLabel label_Email;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
