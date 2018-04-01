package pl.sluski.model;

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
