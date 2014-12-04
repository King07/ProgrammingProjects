/*
 * Created by JFormDesigner on Wed Mar 26 14:52:22 CET 2014
 */

package screens;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import dare2date.Main1;

import org.jdesktop.swingx.*;

import profile.Matching;
import profile.Member;

/**
 * @author don gourdet
 */
public class SearchScreen extends JPanel {
	ArrayList<String> results = new ArrayList<String>();
	int i;
	Member member ;
	public SearchScreen() {
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

	private void button_signInActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void button_SearchForLoveActionPerformed(ActionEvent e) {
		// TODO add your code here
		panel1.removeAll();
		results = StartScreen.member.searchUsers(textField_Search.getText());
		
		for( i=0;i<results.size();i++){


			if(results.get(i).compareTo(StartScreen.member.email + ".txt") != 0){
				
				JLabel holder = new JLabel();
				member = new Member();
				member.setEmail(results.get(i));
				
				try {
					member.retriveData();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				holder.setText(results.get(i));
				
				holder.setIcon(new ImageIcon(getClass().getResource("/resources/default_profilepic1.jpg")));
				holder.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						//Show member profile
						Main1.profileScreen(member);
						
						
					}
				});
				panel1.add(holder);
			}


		}
		panel1.revalidate();
		panel1.repaint();

	}



	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		button_signOut = new JButton();
		textField_Search = new JTextField();
		label_Icon = new JLabel();
		label1 = new JLabel();
		panel_Screen = new JPanel();
		button_showProfile2 = new JButton();
		button_Inbox2 = new JButton();
		button_Search2 = new JButton();
		button_Matches2 = new JButton();
		button_Chat2 = new JButton();
		button_adv_userInfo2 = new JButton();
		scrollPane2 = new JScrollPane();
		panel1 = new JPanel();
		label_profilePic = new JLabel();
		button_SearchForLove = new JButton();

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
			}
		});

		//---- label_Icon ----
		label_Icon.setIcon(new ImageIcon(getClass().getResource("/resources/dare2date_logo.png")));
		label_Icon.setHorizontalAlignment(SwingConstants.CENTER);

		//---- label1 ----
		label1.setText("Search For Love");
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
				}
			});
			panel_Screen.add(button_adv_userInfo2);
		}

		//======== scrollPane2 ========
		{

			//======== panel1 ========
			{
				panel1.setLayout(new VerticalLayout());

				//---- label_profilePic ----
				label_profilePic.setIcon(new ImageIcon(getClass().getResource("/resources/default_profilepic1.jpg")));
				label_profilePic.setText("First Last Name");
				//panel1.add(label_profilePic);
			}
			scrollPane2.setViewportView(panel1);
		}

		//---- button_SearchForLove ----
		button_SearchForLove.setText("Search");
		button_SearchForLove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_SearchForLoveActionPerformed(e);
			}
		});

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addGroup(layout.createParallelGroup()
								.addGroup(layout.createSequentialGroup()
									.addComponent(textField_Search, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(button_SearchForLove))
								.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label_Icon, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addGap(298, 298, 298)
							.addComponent(button_signOut))
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(label_Icon)
					.addGap(2, 2, 2)
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textField_Search, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_SearchForLove))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(button_signOut)
					.addGap(17, 17, 17))
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JButton button_signOut;
	private JTextField textField_Search;
	private JLabel label_Icon;
	private JLabel label1;
	private JPanel panel_Screen;
	private JButton button_showProfile2;
	private JButton button_Inbox2;
	private JButton button_Search2;
	private JButton button_Matches2;
	private JButton button_Chat2;
	private JButton button_adv_userInfo2;
	private JScrollPane scrollPane2;
	private JPanel panel1;
	private JLabel label_profilePic;
	private JButton button_SearchForLove;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}