/*
 * Created by JFormDesigner on Wed Mar 26 14:37:13 CET 2014
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
public class NewMessageScreen extends JPanel {
	public NewMessageScreen() {
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

	private void button_signInActionPerformed(ActionEvent e) {
		// TODO add your code here
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

	private void button_SendMessageActionPerformed(ActionEvent e) {
		// TODO add your code here
		if( !(textField_receiver.getText().isEmpty() && textField_subject.getText().isEmpty()) ){
			
			String message = textArea_messageText.getText().toString();
			String receiver =  textField_receiver.getText().toString();
			String subject = textField_subject.getText().toString();
			StartScreen.member.sendMessage(receiver, subject, message);
			JOptionPane.showMessageDialog(null, "Message has been sent successfully! ",
					"Send Successfull", JOptionPane.INFORMATION_MESSAGE);
			textArea_messageText.setText("");
			textField_receiver.setText("");
			textField_subject.setText("");
			
			
		}else{
			JOptionPane.showMessageDialog(null, "All fields must be feilds must be filled! ",
					"Empty Fields", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		label1 = new JLabel();
		label_Icon = new JLabel();
		panel_Screen = new JPanel();
		button_showProfile2 = new JButton();
		button_Inbox2 = new JButton();
		button_Search2 = new JButton();
		button_Matches2 = new JButton();
		button_Chat2 = new JButton();
		button_adv_userInfo2 = new JButton();
		button_signIn = new JButton();
		textField_receiver = new HintTextField("Reveiver Email");
		textField_subject = new HintTextField("Subject");
		scrollPane1 = new JScrollPane();
		textArea_messageText = new JTextArea();
		button_SendMessage = new JButton();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- label1 ----
		label1.setText("New Message");
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

		//---- button_signIn ----
		button_signIn.setText("Sign Out");
		button_signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_signInActionPerformed(e);
			}
		});

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(textArea_messageText);
		}

		//---- button_SendMessage ----
		button_SendMessage.setText("Send");
		button_SendMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_SendMessageActionPerformed(e);
			}
		});

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(0, 0, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup()
						.addComponent(label_Icon, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGroup(layout.createParallelGroup()
								.addGroup(layout.createSequentialGroup()
									.addGap(351, 351, 351)
									.addComponent(button_SendMessage, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addGroup(layout.createParallelGroup()
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
											.addGap(3, 3, 3)
											.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
											.addComponent(textField_subject)
											.addComponent(textField_receiver, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))))))))
				.addGroup(layout.createSequentialGroup()
					.addGap(301, 301, 301)
					.addComponent(button_signIn)
					.addContainerGap())
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
							.addGap(9, 9, 9)
							.addComponent(textField_receiver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField_subject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(button_SendMessage)
							.addGap(47, 47, 47)
							.addComponent(button_signIn))
						.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JLabel label1;
	private JLabel label_Icon;
	private JPanel panel_Screen;
	private JButton button_showProfile2;
	private JButton button_Inbox2;
	private JButton button_Search2;
	private JButton button_Matches2;
	private JButton button_Chat2;
	private JButton button_adv_userInfo2;
	private JButton button_signIn;
	private JTextField textField_receiver;
	private JTextField textField_subject;
	private JScrollPane scrollPane1;
	private JTextArea textArea_messageText;
	private JButton button_SendMessage;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
