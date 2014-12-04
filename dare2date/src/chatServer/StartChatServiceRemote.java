package chatServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bartspiering
 */
public class StartChatServiceRemote {

	public static Registry registry;
	public static ChatServiceRemoteInterface service;

	public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(1099);
            ChatServiceRemoteInterface service = new ChatServiceRemoteImpl();
            Naming.rebind("ChatService", service);

            //service.sendMessage("this is a message from server");
            registry = LocateRegistry.getRegistry();
            service.getMessage("this getmessage");
            
            System.out.println("Chat server has started");
            //Registry Server = LocateRegistry.getRegistry();
            String message = " ";
            
            while(true ){
            	if (! ( service.getMessage() == null )){

            		if ( service.getMessage().compareTo(message) != 0 ){
            			System.out.println(service.getMessage());
            			message = service.getMessage();
            		}
            	}
            }

        } catch (RemoteException ex) {
            Logger.getLogger(StartChatServiceRemote.class.getName())
                                             .log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(StartChatServiceRemote.class.getName())
                                             .log(Level.SEVERE, null, ex);
        }
    }
	public static ChatServiceRemoteInterface getService(){
		return service;
	}

}
