/*
 * Created by JFormDesigner on Wed Mar 26 20:35:51 CET 2014
 */

package screens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import dare2date.Main1;
import org.jdesktop.swingx.*;

/**
 * @author don gourdet
 */
public class InboxScreen extends JPanel {
	public InboxScreen() {
		initComponents();
		
		textArea_messageText.setText(StartScreen.member.getMessages());
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

	private void button_signOutActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.signOut();
	}

	private void button_newMessageActionPerformed(ActionEvent e) {
		// TODO add your code here
		Main1.newMessageScreen();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		button_signOut = new JButton();
		scrollPane1 = new JScrollPane();
		textArea_messageText = new JTextArea();
		scrollPane2 = new JScrollPane();
		panel1 = new JPanel();
		label_messageName = new JLabel();
		label1 = new JLabel();
		label_Icon = new JLabel();
		panel_Screen = new JPanel();
		button_showProfile2 = new JButton();
		button_Inbox2 = new JButton();
		button_Search2 = new JButton();
		button_Matches2 = new JButton();
		button_Chat2 = new JButton();
		button_adv_userInfo2 = new JButton();
		button_newMessage = new JButton();

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
				button_signInActionPerformed(e);
				button_signOutActionPerformed(e);
			}
		});

		//======== scrollPane1 ========
		{

			//---- textArea_messageText ----
			textArea_messageText.setEditable(false);
			textArea_messageText.setBackground(SystemColor.window);
			scrollPane1.setViewportView(textArea_messageText);
		}

		//======== scrollPane2 ========
		{
			scrollPane2.setBackground(SystemColor.window);

			//======== panel1 ========
			{
				panel1.setLayout(new GridLayout(50, 0));

				//---- label_messageName ----
				label_messageName.setText("text");
				panel1.add(label_messageName);
			}
			scrollPane2.setViewportView(panel1);
		}

		//---- label1 ----
		label1.setText("Inbox");
		label1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		label1.setHorizontalAlignment(SwingConstants.CENTER);

		//---- label_Icon ----
		label_Icon.setIcon(new ImageIcon(getClass().getResource("/resources/dare2date_logo.png")));
		label_Icon.setHorizontalAlignment(SwingConstants.CENTER);

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
				}
			});
			panel_Screen.add(button_adv_userInfo2);
		}

		//---- button_newMessage ----
		button_newMessage.setText("New Message");
		button_newMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_newMessageActionPerformed(e);
			}
		});

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup()
						.addComponent(label_Icon, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(button_newMessage)
								.addGroup(layout.createSequentialGroup()
									.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))))
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)))
				.addGroup(layout.createSequentialGroup()
					.addGap(301, 301, 301)
					.addComponent(button_signOut)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(label_Icon)
					.addGap(2, 2, 2)
					.addComponent(label1)
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addGap(27, 27, 27)
							.addComponent(button_newMessage)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addComponent(button_signOut))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addGap(0, 50, Short.MAX_VALUE)))
					.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JButton button_signOut;
	private JScrollPane scrollPane1;
	private JTextArea textArea_messageText;
	private JScrollPane scrollPane2;
	private JPanel panel1;
	private JLabel label_messageName;
	private JLabel label1;
	private JLabel label_Icon;
	private JPanel panel_Screen;
	private JButton button_showProfile2;
	private JButton button_Inbox2;
	private JButton button_Search2;
	private JButton button_Matches2;
	private JButton button_Chat2;
	private JButton button_adv_userInfo2;
	private JButton button_newMessage;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
