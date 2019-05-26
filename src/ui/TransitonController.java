package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TransitonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lives;

    
    @FXML
    void initialize() {
        assert lives != null : "fx:id=\"lives\" was not injected: check your FXML file 'transition.fxml'.";

    }
}
