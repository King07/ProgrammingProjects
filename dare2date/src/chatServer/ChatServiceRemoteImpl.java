package chatServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatServiceRemoteImpl extends UnicastRemoteObject implements ChatServiceRemoteInterface {
    public String message;
    public ChatServiceRemoteImpl() throws RemoteException {    
    }

    public String sendMessage(String newMessage) throws RemoteException {
    	this.message = newMessage;
   
    
        return this.message;
    }

	@Override
	public String getMessage(String message) throws RemoteException {
		
		return message;
	}
    


	@Override
	public String getMessage() throws RemoteException {
		// TODO Auto-generated method stub
		
		return this.message;
	}

}
