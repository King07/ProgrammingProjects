package chatClient;

import chatServer.ChatServiceRemoteInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bartspiering
 */
public class ChatClientUI{
    public static String USERNAME = "";
    ChatServiceRemoteInterface remoteService;
    
    
    public ChatClientUI(String username){
		USERNAME = username + ": ";
		connect();
	
    
    }
	
    
    
    
    public void sendMessage(String message) {
		try {
			
			
			remoteService.sendMessage(USERNAME + message);
			System.out.println("Sent: " + USERNAME + message);
		
		
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}
	public String getMessage(){
		String message = "Failed to return messsage";
		try {
			
			message = remoteService.getMessage();
			
		
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
		
	}
    public void connect(){
        
    	
    	try {
        	
            remoteService = (ChatServiceRemoteInterface)
                      Naming.lookup("rmi://127.0.0.1/ChatService");
            
            remoteService.sendMessage(USERNAME + " is now online");
            System.out.println("Chat Client has Started \n");
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ChatClientUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChatClientUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatClientUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}