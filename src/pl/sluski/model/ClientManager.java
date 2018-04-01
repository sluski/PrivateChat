package pl.sluski.model;

/**
 *
 * @author Sluski
 */
public class ClientManager {
    private final ConnectionProvider connectionProvider;
    
    public ClientManager(){
        connectionProvider = new ConnectionProvider();
    }
    
    public void createConnection(String address, int port){
        connectionProvider.createConnection(address, port);
    }
    
    public void send(String message){
        connectionProvider.send(message);
    }
}
