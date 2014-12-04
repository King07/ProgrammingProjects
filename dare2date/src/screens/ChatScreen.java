/*
 * Created by JFormDesigner on Wed Mar 26 20:13:24 CET 2014
 */

package screens;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import dare2date.Main1;

import org.jdesktop.swingx.*;

import chatClient.ChatClientUI;

/**
 * @author don gourdet
 */
public class ChatScreen extends JPanel {
	public static boolean chatEnabled = false;
	String lastmessage = "lastmessage";
	String currentmessage = "";
	ChatClientUI chatClient;
	public ChatScreen() {
		initComponents();
		chatClient = new ChatClientUI(StartScreen.member.getEmail());
		if (chatClient != null) setChatEnabled(true);
		
		
		Thread reloadMessages = new Thread()
        {
            public void run() {
                while(chatEnabled){
                	currentmessage = chatClient.getMessage();
                	
                	if( !(currentmessage.compareTo(lastmessage) == 0) ) {
                	textArea_chatLog.setText(textArea_chatLog.getText() + System.lineSeparator() 
                							+ currentmessage + System.lineSeparator()
                							);
                	textArea_chatLog.repaint();
                	textArea_chatLog.revalidate();
                	System.out.println("Recieved: " + currentmessage);
                	lastmessage = currentmessage;
                	
                	
                	}
                }
            }
        };
        reloadMessages.start();
        		
	}
	
	public static boolean isChatEnabled() {
		return chatEnabled;
	}

	public static void setChatEnabled(boolean chatEnabled) {
		ChatScreen.chatEnabled = chatEnabled;
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


	private void button_sendMessageActionPerformed(ActionEvent e) {
		// TODO add your code here
		if ( !(textField_message.getText().isEmpty()) ){
			
			chatClient.sendMessage(textField_message.getText());
			textField_message.setText("");
		}
	}



	private void textField_messageKeyPressed(KeyEvent e) {
		// TODO add your code here
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			if ( !(textField_message.getText().isEmpty()) ){
				chatClient.sendMessage( textField_message.getText().trim() );
				textField_message.setText("");
			}
			
		}
	}

	private void textField_messageActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void button_signInActionPerformed(ActionEvent e) {
		// TODO add your code here
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - don gourdet
		label1 = new JLabel();
		label_Icon = new JLabel();
		panel_Screen = new JPanel();
		button_Inbox2 = new JButton();
		button_showProfile2 = new JButton();
		button_Search2 = new JButton();
		button_Matches2 = new JButton();
		button_Chat2 = new JButton();
		button_adv_userInfo2 = new JButton();
		button_signOut = new JButton();
		scrollPane1 = new JScrollPane();
		textArea_chatLog = new JTextArea();
		textField_message = new JTextField();
		button_sendMessage = new JButton();

		//======== this ========

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


		//---- label1 ----
		label1.setText("Chat");
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

			//---- textArea_chatLog ----
			textArea_chatLog.setEditable(false);
			textArea_chatLog.setBackground(SystemColor.window);
			scrollPane1.setViewportView(textArea_chatLog);
		}

		//---- textField_message ----
		textField_message.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_messageActionPerformed(e);
				textField_messageActionPerformed(e);
				textField_messageActionPerformed(e);
			}
		});
		textField_message.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textField_messageKeyPressed(e);
			}
		});

		//---- button_sendMessage ----
		button_sendMessage.setText("Send");
		button_sendMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button_sendMessageActionPerformed(e);
			}
		});

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addComponent(label_Icon, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE))
					.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup()
								.addGroup(layout.createSequentialGroup()
									.addComponent(textField_message, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
									.addGap(18, 18, 18)
									.addComponent(button_sendMessage))
								.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addGap(301, 301, 301)
							.addComponent(button_signOut)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addComponent(label_Icon)
					.addGap(2, 2, 2)
					.addComponent(label1)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(panel_Screen, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
							.addComponent(scrollPane1)
							.addGap(18, 18, 18)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textField_message, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_sendMessage))))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(button_signOut)
					.addContainerGap())
		);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - don gourdet
	private JLabel label1;
	private JLabel label_Icon;
	private JPanel panel_Screen;
	private JButton button_Inbox2;
	private JButton button_showProfile2;
	private JButton button_Search2;
	private JButton button_Matches2;
	private JButton button_Chat2;
	private JButton button_adv_userInfo2;
	private JButton button_signOut;
	private JScrollPane scrollPane1;
	private JTextArea textArea_chatLog;
	private JTextField textField_message;
	private JButton button_sendMessage;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
