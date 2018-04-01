package pl.sluski.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.sluski.model.ClientManager;
import pl.sluski.model.ServerManager;

/**
 * FXML Controller class
 *
 * @author Sluski
 */
public class SettingsController implements Initializable {

    private final ServerManager serverManager;
    private final ClientManager clientManager;

    @FXML
    private TextField addressFiled;

    @FXML
    private TextField portField;

    public SettingsController() {
        serverManager = new ServerManager();
        clientManager = new ClientManager();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void startServer() {
        serverManager.startServer(8189);
    }

    @FXML
    public void connect(ActionEvent event) throws IOException {
        String address = addressFiled.getText();
        int port = Integer.parseInt(portField.getText());

        clientManager.createConnection(address, port);

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Chat.fxml"));
        Pane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Connected with " + address);
        stage.show();
    }

}
