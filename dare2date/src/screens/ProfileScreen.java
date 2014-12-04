/*
 * Created by JFormDesigner on Wed Mar 26 12:48:26 CET 2014
 */

package screens;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import dare2date.Main1;
import org.jdesktop.swingx.*;
import profile.Member;

/**
 * @author don gourdet
 */
public class ProfileScreen extends JPanel {
	public ProfileScreen() {
		initComponents();
		
		try {
			StartScreen.member.retriveData();
			System.out.println("Data Retrived ");
			System.out.println(StartScreen.member);
			label_profilePic.setText(StartScreen.member.getFirstName() + " " 
							+ StartScreen.member.getLastName() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String profileText = StartScreen.member.getProfileInfo();
		
		textArea_profileInfo.setText("\n" + profileText);
		System.out.println(profileText);
	}
	public ProfileScreen(Member member){
		initComponents();
		try {
			member.retriveData();
			System.out.println("Data Retrived ");
			System.out.println(member);
			label_profilePic.setText(member.getFirstName() + " " 
							+ member.getLastName() );
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}
		
		String profileText = member.getProfileInfo();
		textArea_profileInfo.setText("\n" + profileText);
		System.out.println(profileText);
	}

	private void button_signOutActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.signOut();
	}

	private void button_signInActionPerformed(ActionEvent e) {
		// TODO add your code here
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


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		button_signOut = new JButton();
		label_Icon = new JLabel();
		scrollPane2 = new JScrollPane();
		panel_profile = new JPanel();
		label_profilePic = new JLabel();
		scrollPane1 = new JScrollPane();
		textArea_profileInfo = new JTextArea();
		label1 = new JLabel();
		panel_Screen = new JPanel();
		button_showProfile2 = new JButton();
		button_Inbox2 = new JButton();
		button_Search2 = new JButton();
		button_Matches2 = new JButton();
		button_Chat2 = new JButton();
		button_adv_userInfo2 = new JButton();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- button_signOut ----
		button_signOut.setText("Sign Out");
		button_signOut.setActionCommand("Sign Out");
		button_signOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				button_signOutActionPerformed(e);
			}
		});

		//---- label_Icon ----
		label_Icon.setIcon(new ImageIcon(getClass().getResource("/resources/dare2date_logo.png")));
		label_Icon.setHorizontalAlignment(SwingConstants.CENTER);

		//======== scrollPane2 ========
		{

			//======== panel_profile ========
			{

				//---- label_profilePic ----
				label_profilePic.setIcon(new ImageIcon(getClass().getResource("/resources/default_profilepic1.jpg")));
				label_profilePic.setText("First Last Name");

				//======== scrollPane1 ========
				{

					//---- textArea_profileInfo ----
					textArea_profileInfo.setEditable(false);
					textArea_profileInfo.setBackground(SystemColor.window);
					scrollPane1.setViewportView(textArea_profileInfo);
				}

				GroupLayout panel_profileLayout = new GroupLayout(panel_profile);
				panel_profile.setLayout(panel_profileLayout);
				panel_profileLayout.setHorizontalGroup(
					panel_profileLayout.createParallelGroup()
						.addGroup(panel_profileLayout.createSequentialGroup()
							.addGroup(panel_profileLayout.createParallelGroup()
								.addComponent(label_profilePic)
								.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE))
							.addGap(0, 465, Short.MAX_VALUE))
				);
				panel_profileLayout.setVerticalGroup(
					panel_profileLayout.createParallelGroup()
						.addGroup(panel_profileLayout.createSequentialGroup()
							.addComponent(label_profilePic)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(20, Short.MAX_VALUE))
				);
			}
			scrollPane2.setViewportView(panel_profile);
		}

		//---- label1 ----
		label1.setText("Profile");
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
				}
			});
			panel_Screen.add(button_adv_userInfo2);
		}

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addComponent(label_Icon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addComponent(button_signOut)
					.addGap(252, 252, 252))
				.addGroup(layout.createSequentialGroup()
					.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(30, 30, 30)
					.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
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
							.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button_signOut))
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 50, Short.MAX_VALUE)))
					.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JButton button_signOut;
	private JLabel label_Icon;
	private JScrollPane scrollPane2;
	private JPanel panel_profile;
	private JLabel label_profilePic;
	private JScrollPane scrollPane1;
	private JTextArea textArea_profileInfo;
	private JLabel label1;
	private JPanel panel_Screen;
	private JButton button_showProfile2;
	private JButton button_Inbox2;
	private JButton button_Search2;
	private JButton button_Matches2;
	private JButton button_Chat2;
	private JButton button_adv_userInfo2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
