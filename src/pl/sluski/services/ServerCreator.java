package pl.sluski.services;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sluski
 */
public class ServerCreator implements Runnable {

    private final ConnectionManager connectionProvider;
    private int port;
    private Thread thread;

    public ServerCreator() {
        connectionProvider = new ConnectionManager();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            Socket connection = server.accept();
            ConnectionManager.setConnection(connection);
        } catch (IOException ex) { }
    }
    
    public void startServer(int port){
        this.port = port;
        
        thread = new Thread(this, "Server Thread");
        thread.start();
    }
    
    public void stopServer(){
        try {
            thread.wait();
        } catch (InterruptedException ex) { }
    }
    
    public void resumeServer(){
        thread.notify();
    }
}
