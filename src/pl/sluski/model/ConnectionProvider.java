package pl.sluski.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Sluski
 */
public class ConnectionProvider {

    private static Socket connection;
    private static ServerSocket server;
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

    public void startServer(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException ex){ }
    }

    public void stopServer() {
        if (!server.isClosed()) {
            try {
                server.close();
            } catch (IOException ex){ }
        }
    }

    public void createStreams() throws IOException {
        input = new Scanner(connection.getInputStream());
        output = new PrintWriter(connection.getOutputStream(), true);
    }

    public void send(String message) {
        output.println(message);
    }

}
