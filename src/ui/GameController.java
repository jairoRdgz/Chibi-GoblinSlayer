package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void backToMenu(ActionEvent event) throws IOException {
    	Parent game = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        
        Scene scene = new Scene(game);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Goblin Slayer");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void exit(MouseEvent event) {

    }

    @FXML
    void initialize() {

    }
}

