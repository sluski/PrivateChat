package pl.sluski.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;
import java.net.Socket;
import java.util.Scanner;
import pl.sluski.model.ServerManager;

/**
 *
 * @author Sluski
 */
public class ConnectionManager {

    private static Socket connection;
    private static Scanner input;
    private static PrintWriter output;
    
    public void createConnection(String address, int port) {
        try {
            if (connection == null) {
                connection = new Socket(address, port);
            }
            createStreams();
        } catch (IOException ex){ }
    }

    public void startServer(int port) throws InterruptedException {
        if(ServerManager.getThread() != null && ServerManager.getThread().isAlive()){
            ServerManager.getThread().stop();
        }else{
            ServerManager.getInstance(8189);
        }
    }

    public void createStreams() {
        try{
        input = new Scanner(connection.getInputStream());
        output = new PrintWriter(connection.getOutputStream(), true);
        output.print("Hello World");
        }catch(IOException ex) { }
    }

    public void send(String message) {
        output.println(message);
    }
    
    public static void setConnection(Socket connection) {
        ConnectionManager.connection = connection;
    }
    
    public void inputStream(){
        while(true){
            if(input.hasNextLine()){
                
            }
        }
    }
}
