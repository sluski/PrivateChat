package pl.sluski.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.sluski.model.ClientManager;

/**
 *
 * @author Sluski
 */
public class ChatController {
    
    private final ClientManager clientManager; 
    
    @FXML
    private TextField messageField;
    
    @FXML
    private TextArea output;
    
    public ChatController(){
        clientManager = new ClientManager();
    }
    
    public void send(ActionEvent event){
        if(!messageField.getText().isEmpty()){
        String message = messageField.getText();
        messageField.clear();
        clientManager.send(message);
        }
    }
}
