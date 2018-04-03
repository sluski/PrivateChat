package pl.sluski.services;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Sluski
 */
public class ServerCreator implements Runnable{

    private final ConnectionProvider connectionProvider;
    
    public ServerCreator(){
        connectionProvider = new ConnectionProvider();
    }
    
    @Override
    public void run() {
        ServerSocket server = ConnectionProvider.getServer();
        try{
        Socket connection = server.accept();
        ConnectionProvider.setConnection(connection);
        }catch(IOException ex){ }
    }
    
    
    
}
