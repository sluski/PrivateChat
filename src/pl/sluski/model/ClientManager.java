package pl.sluski.model;

import pl.sluski.services.ConnectionManager;

/**
 *
 * @author Sluski
 */
public class ClientManager {
    private final ConnectionManager connectionProvider;
    private String adress;
    private int port;
    
    public ClientManager(){
        connectionProvider = new ConnectionManager();
        adress = "";
        port = 0;
    }
    
    public void createConnection(String address, int port){
        this.adress = address;
        this.port = port;
        connectionProvider.createConnection(adress, port);
    }
    
    public void send(String message){
        connectionProvider.send(message);
    }

    public String getAdress() {
        return adress;
    }

    public int getPort() {
        return port;
    }
}
