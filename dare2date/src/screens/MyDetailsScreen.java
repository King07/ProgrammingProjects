/*
 * Created by JFormDesigner on Fri Mar 21 10:07:48 CET 2014
 */

package screens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import org.jdesktop.swingx.*;

import profile.Gender;
import dare2date.Main1;

/**
 * @author don gourdet
 */
public class MyDetailsScreen extends JPanel {
	
	public MyDetailsScreen() {
		initComponents();
		
		
		
		
	}

	private void button_signOutActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.signOut();
	}

	private void button_showProfileActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.profileScreen();
	}

	private void button_InboxActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.inboxScreen();
	}

	private void button_SearchActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.searchScreen();
	}

	private void button_MatchesActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.matchesScreen();
	}

	private void button_ChatActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.chatScreen();
	}

	private void button_adv_userInfoActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.myDetailsScreen();
	}

	private void button_SaveChangesActionPerformed(ActionEvent e) {
		// TODO add your code here
		StartScreen.member.setFirstName(textField_FirstName.getText().toString());
		StartScreen.member.setLastName(textField_LastName.getText().toString());
		StartScreen.member.setDOB(textField_DateOFBirth_DDMMYY.getText().toString());
		
		if(radioButton_Male.isSelected())
			StartScreen.member.setGender( Gender.MALE );
		if(radioButton_Male2.isSelected())
			StartScreen.member.setGender( Gender.FEMALE );
		StartScreen.member.setCity(textField_City.getText().toString());
		StartScreen.member.setCountry(textField_Country.getText().toString());
		StartScreen.member.setPhoneNumber(textField_PhoneNum.getText().toString());
		StartScreen.member.setCardExpDate(textField_CreditCardExpDate_DDMMYY.getText().toString());
		StartScreen.member.setCardNumber(Integer.parseInt(textField_CreditCardNum.getText().toString()));
		
		StartScreen.member.fillAdvanceUserDataP(StartScreen.member);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		label_Icon = new JLabel();
		label1 = new JLabel();
		panel_Screen = new JPanel();
		button_showProfile2 = new JButton();
		button_Inbox2 = new JButton();
		button_Search2 = new JButton();
		button_Matches2 = new JButton();
		button_Chat2 = new JButton();
		button_adv_userInfo2 = new JButton();
		button_SaveChanges = new JButton();
		textField_CreditCardExpDate_DDMMYY = new HintTextField("Enter credit card expire date DDMMYY ");
		textField_CreditCardNum = new HintTextField("Enter credit card number");
		textField_FirstName = new HintTextField("Enter first name");
		textField_LastName = new HintTextField("Enter last name ");
		textField_DateOFBirth_DDMMYY = new HintTextField("Enter date of birth YYYY-MM-DD");
		textField_City = new HintTextField("Enter city");
		radioButton_Male = new JRadioButton();
		radioButton_Male2 = new JRadioButton();
		textField_Country = new HintTextField("Enter country");
		textField_PhoneNum = new HintTextField("Enter phone number ");

		//======== this ========
		setPreferredSize(new Dimension(700, 500));

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- label_Icon ----
		label_Icon.setIcon(new ImageIcon(getClass().getResource("/resources/dare2date_logo.png")));
		label_Icon.setHorizontalAlignment(SwingConstants.CENTER);

		//---- label1 ----
		label1.setText("Enter Advance Details");
		label1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		label1.setHorizontalAlignment(SwingConstants.CENTER);

		//======== panel_Screen ========
		{
			panel_Screen.setLayout(new VerticalLayout());

			//---- button_showProfile2 ----
			button_showProfile2.setText("Profile");
			button_showProfile2.setBackground(new Color(204, 0, 0));
			button_showProfile2.setActionCommand("Profile");
			button_showProfile2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button_showProfileActionPerformed(e);
					button_showProfileActionPerformed(e);
					button_ChatActionPerformed(e);
					button_showProfileActionPerformed(e);
					button_showProfileActionPerformed(e);
					button_showProfileActionPerformed(e);
				}
			});
			panel_Screen.add(button_showProfile2);

			//---- button_Inbox2 ----
			button_Inbox2.setText("Inbox");
			button_Inbox2.setBackground(new Color(204, 0, 0));
			button_Inbox2.setActionCommand("Inbox");
			button_Inbox2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button_InboxActionPerformed(e);
					button_InboxActionPerformed(e);
					button_InboxActionPerformed(e);
					button_InboxActionPerformed(e);
				}
			});
			panel_Screen.add(button_Inbox2);

			//---- button_Search2 ----
			button_Search2.setText("Search");
			button_Search2.setBackground(new Color(204, 0, 0));
			button_Search2.setActionCommand("Search");
			button_Search2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button_SearchActionPerformed(e);
					button_SearchActionPerformed(e);
					button_SearchActionPerformed(e);
					button_SearchActionPerformed(e);
				}
			});
			panel_Screen.add(button_Search2);

			//---- button_Matches2 ----
			button_Matches2.setText("Matches");
			button_Matches2.setBackground(new Color(204, 0, 0));
			button_Matches2.setActionCommand("Matches");
			button_Matches2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button_MatchesActionPerformed(e);
					button_MatchesActionPerformed(e);
					button_MatchesActionPerformed(e);
					button_MatchesActionPerformed(e);
				}
			});
			panel_Screen.add(button_Matches2);

			//---- button_Chat2 ----
			button_Chat2.setText("Chat");
			button_Chat2.setBackground(new Color(204, 0, 0));
			button_Chat2.setActionCommand("Chat");
			button_Chat2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button_ChatActionPerformed(e);
					button_ChatActionPerformed(e);
					button_ChatActionPerformed(e);
					button_ChatActionPerformed(e);
				}
			});
			panel_Screen.add(button_Chat2);

			//---- button_adv_userInfo2 ----
			button_adv_userInfo2.setText("My Details");
			button_adv_userInfo2.setBackground(new Color(204, 0, 0));
			button_adv_userInfo2.setActionCommand("Profile");
			button_adv_userInfo2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					button_adv_userInfoActionPerformed(e);
					button_adv_userInfoActionPerformed(e);
					button_adv_userInfoActionPerformed(e);
					button_adv_userInfoActionPerformed(e);
				}
			});
			panel_Screen.add(button_adv_userInfo2);
		}

		//---- button_SaveChanges ----
		button_SaveChanges.setText("Save Changes");
		button_SaveChanges.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				button_SaveChangesActionPerformed(e);
			}
		});

		//---- textField_CreditCardExpDate_DDMMYY ----
		textField_CreditCardExpDate_DDMMYY.setName("Country");

		//---- textField_CreditCardNum ----
		textField_CreditCardNum.setName("Country");

		//---- textField_FirstName ----
		textField_FirstName.setName("Country");

		//---- textField_LastName ----
		textField_LastName.setName("Country");

		//---- textField_DateOFBirth_DDMMYY ----
		textField_DateOFBirth_DDMMYY.setName("Country");

		//---- textField_City ----
		textField_City.setName("Country");

		//---- radioButton_Male ----
		radioButton_Male.setText("Male");

		//---- radioButton_Male2 ----
		radioButton_Male2.setText("Female");

		//---- textField_Country ----
		textField_Country.setName("Country");

		//---- textField_PhoneNum ----
		textField_PhoneNum.setName("Country");

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addComponent(label_Icon, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addGroup(layout.createParallelGroup()
								.addComponent(textField_FirstName, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_LastName, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_DateOFBirth_DDMMYY, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
									.addComponent(radioButton_Male)
									.addGap(31, 31, 31)
									.addComponent(radioButton_Male2))
								.addComponent(textField_City, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Country, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_PhoneNum, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_CreditCardExpDate_DDMMYY, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_CreditCardNum, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
					.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(button_SaveChanges)
					.addGap(9, 9, 9))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(label_Icon)
					.addGap(2, 2, 2)
					.addComponent(label1)
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
							.addComponent(button_SaveChanges))
						.addGroup(layout.createSequentialGroup()
							.addGap(28, 28, 28)
							.addComponent(textField_FirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8, 8, 8)
							.addComponent(textField_LastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8, 8, 8)
							.addComponent(textField_DateOFBirth_DDMMYY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4, 4, 4)
							.addGroup(layout.createParallelGroup()
								.addComponent(radioButton_Male)
								.addComponent(radioButton_Male2))
							.addGap(11, 11, 11)
							.addComponent(textField_City, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8, 8, 8)
							.addComponent(textField_Country, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8, 8, 8)
							.addComponent(textField_PhoneNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8, 8, 8)
							.addComponent(textField_CreditCardExpDate_DDMMYY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(8, 8, 8)
							.addComponent(textField_CreditCardNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 39, Short.MAX_VALUE)))
					.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JLabel label_Icon;
	private JLabel label1;
	private JPanel panel_Screen;
	private JButton button_showProfile2;
	private JButton button_Inbox2;
	private JButton button_Search2;
	private JButton button_Matches2;
	private JButton button_Chat2;
	private JButton button_adv_userInfo2;
	private JButton button_SaveChanges;
	private JTextField textField_CreditCardExpDate_DDMMYY;
	private JTextField textField_CreditCardNum;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_DateOFBirth_DDMMYY;
	private JTextField textField_City;
	private JRadioButton radioButton_Male;
	private JRadioButton radioButton_Male2;
	private JTextField textField_Country;
	private JTextField textField_PhoneNum;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

