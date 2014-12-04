/*
 * Created by JFormDesigner on Thu Apr 03 09:45:03 CEST 2014
 */

package screens;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import org.jdesktop.swingx.*;

import profile.Matching;
import dare2date.Main1;

/**
 * @author don gourdet
 */
public class MatchesScreen extends JPanel {
	public MatchesScreen() {
		initComponents();
		
		//Setting buttons
		radioButton_location.setSelected(true);
		radioButton_3to5.setSelected(true);
		
		//Switching through radio buttons
		Thread basicMatchRadio = new Thread(){
			
			public void run(){
				while(true){
					
					if(	radioButton_location.isSelected()){
						radioButton_Age.setSelected(false);
						radioButton_Age.repaint();
					}

					if(	radioButton_Age.isSelected()){
						radioButton_location.setSelected(false);
						radioButton_location.repaint();
					}

				}
			}
		};
		basicMatchRadio.start();
		
		//Switching through radio buttons
		Thread advMatchRadio = new Thread(){
			public void run(){
				while(true){
					if(radioButton_3to5.isSelected()){
						radioButton_fullmatch.setSelected(false);
						radioButton_fullmatch.repaint();
						textField_FirstName.disable();
						textField_LastName.disable();
						textField_Country.disable();
						textField_PhoneNo.disable();
					}

					if(radioButton_fullmatch.isSelected()){
						radioButton_3to5.setSelected(false);
						radioButton_3to5.repaint();
						textField_FirstName.enable();
						textField_LastName.enable();
						textField_Country.enable();
						textField_PhoneNo.enable();
					}

				}
			}
		};
		advMatchRadio.start();
		Matching matching = new Matching();
		
	}

	private void button_showProfileActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.profileScreen();
	}

	private void button_ChatActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.chatScreen();
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

	private void button_adv_userInfoActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.myDetailsScreen();
	}

	private void button_signOutActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.signOut();
	}

	private void button_signInActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void button_Matches2ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void button_FindMatchBscActionPerformed(ActionEvent e) {
		// TODO add your code here
		//Basic Match
		if( !(textField_BasicMatch.getText().isEmpty()) ){
			
			
			Matching matching = new Matching();
			String matchfield = textField_BasicMatch.getText();
			ArrayList<String> matchingResults = matching.basicMatch(matchfield);
			for(int i=0;i<matchingResults.size();i++){
				if( (matchingResults.get(i).compareTo(StartScreen.member.email + ".txt") == 0) ){
					matchingResults.remove(i);
				}
			}
			MatchesResultsScreen.results = matchingResults;
			System.out.println("Match Results: " + MatchesResultsScreen.results.toString());
			Main1.matchesResultsScreen();
		
		}
	}

	@SuppressWarnings("static-access")
	private void button_FindMatchAdvActionPerformed(ActionEvent e) {
		// TODO add your code here
		
		
		if( !(textField_BasicMatch.getText().isEmpty()) ){
			
			ArrayList<String> matchingResults = new ArrayList<String>();
			
			String[] pref_array = textField_Preferences.getText().split(" ");
			ArrayList<String> preferences = new ArrayList<String>();
			for(int i=0;i<pref_array.length;i++)
			{
				preferences.add(pref_array[i]);
			}

			String[] hobb_array = textField_Hobbies.getText().split(" ");
			ArrayList<String> hobbies = new ArrayList<String>();
			for(int i=0;i<hobb_array.length;i++){
				hobbies.add(pref_array[i]);
			}
			Matching matching = new Matching();
			if(radioButton_3to5.isSelected()){

				
				
				matchingResults = 
						matching.AdvMatching35(
								textField_DOB.getText(),
								textField_Gender.getText(),
								textField_City.getText(),
								preferences,
								hobbies
								);
				
			}else{
				matchingResults = 
						matching.AdvanceMatchingFull(
								textField_FirstName.getText(),
								textField_LastName.getText(),
								textField_DOB.getText(), 
								textField_Gender.getText(),
								textField_City.getText(),
								textField_Country.getText(),
								textField_PhoneNo.getText(),
								preferences,
								hobbies
								);
			}
			
			
			for(int i=0;i<matchingResults.size();i++){
				if( (matchingResults.get(i).compareTo(StartScreen.member.email + ".txt") == 0) ){
					matchingResults.remove(i);
				}
			}
			
			MatchesResultsScreen.results = matchingResults;
			System.out.println("Match Results: " + MatchesResultsScreen.results.toString());
			Main1.matchesResultsScreen();

		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		button_signOut = new JButton();
		textField_BasicMatch = new HintTextField("Enter match critiria");
		label_Icon = new JLabel();
		label1 = new JLabel();
		panel_Screen = new JPanel();
		button_showProfile2 = new JButton();
		button_Inbox2 = new JButton();
		button_Search2 = new JButton();
		button_Matches2 = new JButton();
		button_Chat2 = new JButton();
		button_adv_userInfo2 = new JButton();
		button_FindMatchBsc = new JButton();
		radioButton_location = new JRadioButton();
		radioButton_Age = new JRadioButton();
		radioButton_3to5 = new JRadioButton();
		textField_FirstName = new HintTextField("Enter first name");
		textField_LastName = new HintTextField("Enter last name");
		textField_DOB = new HintTextField("Enter date of birth YYYY-MM-DD");
		textField_Gender = new HintTextField("Enter gender MALE or FEMALE");
		textField_Preferences = new HintTextField("Enter preferences separated by space");
		textField_PhoneNo = new HintTextField("Enter phone number");
		textField_Country = new HintTextField("Enter country");
		textField_City = new HintTextField("Enter city");
		textField_Hobbies = new HintTextField("Enter hobbies separated by space");
		radioButton_fullmatch = new JRadioButton();
		button_FindMatchAdv = new JButton();
		label2 = new JLabel();
		label3 = new JLabel();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- button_signOut ----
		button_signOut.setText("Sign Out");
		button_signOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_signInActionPerformed(e);
				button_signOutActionPerformed(e);
			}
		});

		//---- label_Icon ----
		label_Icon.setIcon(new ImageIcon(getClass().getResource("/resources/dare2date_logo.png")));
		label_Icon.setHorizontalAlignment(SwingConstants.CENTER);

		//---- label1 ----
		label1.setText("Find Your Match");
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
					button_Matches2ActionPerformed(e);
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

		//---- button_FindMatchBsc ----
		button_FindMatchBsc.setText("Find match");
		button_FindMatchBsc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_FindMatchBscActionPerformed(e);
				button_FindMatchBscActionPerformed(e);
			}
		});

		//---- radioButton_location ----
		radioButton_location.setText("Location");

		//---- radioButton_Age ----
		radioButton_Age.setText("Age");

		//---- radioButton_3to5 ----
		radioButton_3to5.setText("3-5 critiria match");

		//---- radioButton_fullmatch ----
		radioButton_fullmatch.setText("Full match");

		//---- button_FindMatchAdv ----
		button_FindMatchAdv.setText("Find match");
		button_FindMatchAdv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_FindMatchAdvActionPerformed(e);
			}
		});

		//---- label2 ----
		label2.setText("Advanced match");
		label2.setFont(new Font("Lucida Grande", Font.PLAIN, 28));

		//---- label3 ----
		label3.setText("Basic match");
		label3.setFont(new Font("Lucida Grande", Font.PLAIN, 28));

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup()
								.addComponent(label3)
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup()
										.addGroup(layout.createSequentialGroup()
											.addGap(5, 5, 5)
											.addComponent(label2))
										.addComponent(textField_City, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_DOB, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_LastName, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_FirstName, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Gender, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
									.addGap(18, 18, 18)
									.addGroup(layout.createParallelGroup()
										.addComponent(textField_Country, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_PhoneNo, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addComponent(radioButton_fullmatch)
										.addComponent(radioButton_3to5)
										.addComponent(button_FindMatchAdv)
										.addComponent(textField_Hobbies, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_Preferences, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup()
										.addComponent(textField_BasicMatch, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
											.addGap(245, 245, 245)
											.addComponent(radioButton_location)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(radioButton_Age)))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(button_FindMatchBsc))))
						.addComponent(label_Icon, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addGap(298, 298, 298)
							.addComponent(button_signOut)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(label_Icon)
					.addGap(2, 2, 2)
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(button_signOut))
						.addGroup(layout.createSequentialGroup()
							.addComponent(label3)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textField_BasicMatch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton_Age)
								.addComponent(radioButton_location)
								.addComponent(button_FindMatchBsc))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(label2)
									.addGap(36, 36, 36)
									.addComponent(textField_FirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addComponent(radioButton_3to5)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(radioButton_fullmatch)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(button_FindMatchAdv)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textField_Country, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_LastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textField_PhoneNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_DOB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup()
								.addComponent(textField_Gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Preferences, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup()
								.addComponent(textField_City, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Hobbies, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(0, 55, Short.MAX_VALUE)))
					.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JButton button_signOut;
	private JTextField textField_BasicMatch;
	private JLabel label_Icon;
	private JLabel label1;
	private JPanel panel_Screen;
	private JButton button_showProfile2;
	private JButton button_Inbox2;
	private JButton button_Search2;
	private JButton button_Matches2;
	private JButton button_Chat2;
	private JButton button_adv_userInfo2;
	private JButton button_FindMatchBsc;
	private JRadioButton radioButton_location;
	private JRadioButton radioButton_Age;
	private JRadioButton radioButton_3to5;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_DOB;
	private JTextField textField_Gender;
	private JTextField textField_Preferences;
	private JTextField textField_PhoneNo;
	private JTextField textField_Country;
	private JTextField textField_City;
	private JTextField textField_Hobbies;
	private JRadioButton radioButton_fullmatch;
	private JButton button_FindMatchAdv;
	private JLabel label2;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
