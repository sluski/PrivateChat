package pl.sluski.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import pl.sluski.services.ConnectionManager;

/**
 *
 * @author Sluski
 */
public class ServerManager implements Runnable {
    
    private static ServerSocket server;
    private static ServerManager instance;
    private static Thread thread;
    private static int port;
    private Socket connection;
    
    private ServerManager(int port){
        ServerManager.port = port;
        
    }
    
    public static ServerManager getInstance(int port){
        if(instance == null){
            instance = new ServerManager(port);
        }
        thread = new Thread(instance);
        thread.start();
        return instance;
    }
    
    @Override
    public void run() {
        try{
        server = new ServerSocket(port);
        connection = server.accept();
        ConnectionManager.setConnection(connection);
        }catch(IOException ex) { }
        
    }

    public Socket getConnection() {
        return connection;
    }
    
    public static Thread getThread(){
        return thread;
    }
    
    
}
