package dare2date;

import javax.swing.JFrame;

import profile.Member;
import screens.ChatScreen;
import screens.InboxScreen;
import screens.MatchesResultsScreen;
import screens.MatchesScreen;
import screens.MyDetailsScreen;
import screens.NewMessageScreen;
import screens.ProfileScreen;
import screens.SearchScreen;
import screens.StartScreen;

public class Main1 {
	//public static Member member;
	public static JFrame gui = new JFrame();
	
	public static void main(String[] args) {
		
		StartScreen startScreen = new StartScreen();
		
		
		gui.setName("Dare2date");
		gui.setSize(700, 500);
		gui.getContentPane().add(startScreen);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void signOut() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new StartScreen());
		Main1.gui.setVisible(true);
		ChatScreen.setChatEnabled(false);
		StartScreen.member = new Member();
		System.out.println("MEMBER SIGNED OUT!!!");
	}
	
	public static void inboxScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new InboxScreen());
		Main1.gui.setVisible(true);
		
	}
	public static void searchScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new SearchScreen());
		Main1.gui.setVisible(true);
		
	}
	public static void matchesScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new MatchesScreen());
		Main1.gui.setVisible(true);
		
	}
	public static void chatScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new ChatScreen());
		Main1.gui.setVisible(true);
		
	}
	public static void myDetailsScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new MyDetailsScreen());
		Main1.gui.setVisible(true);
		
	}
	public static void profileScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new ProfileScreen());
		Main1.gui.setVisible(true);
		
	}
	public static void newMessageScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new NewMessageScreen());
		Main1.gui.setVisible(true);
		
	}
	public static void matchesResultsScreen() {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new MatchesResultsScreen());
		Main1.gui.setVisible(true);
	}
	public static void profileScreen(Member member) {
		// TODO Auto-generated method stub
		Main1.gui.getContentPane().removeAll();
		Main1.gui.getContentPane().add(new ProfileScreen(member));
		Main1.gui.setVisible(true);
	}


}
