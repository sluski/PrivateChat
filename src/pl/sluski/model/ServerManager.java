package pl.sluski.model;

import pl.sluski.services.ConnectionProvider;

/**
 *
 * @author Sluski
 */
public class ServerManager {
    
    private final ConnectionProvider connectionProvider;
    
    public ServerManager(){
        connectionProvider = new ConnectionProvider();
    }
    
    public void startServer(int port){
        connectionProvider.startServer(port);
    }
}
