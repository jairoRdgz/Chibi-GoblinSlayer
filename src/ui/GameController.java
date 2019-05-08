package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void backToMenu(ActionEvent event) throws IOException {
    	Alert confirmation = new Alert(AlertType.NONE);
    	confirmation.setTitle("Goblin Slayer");
    	confirmation.setContentText("Are you sure you want to leave the game \nyour progress wont be saved");
    	
    	
    	ButtonType buttonTypeYes = new ButtonType("Yes");
    	ButtonType buttonTypeCancel = new ButtonType("Cancel");

    	confirmation.getButtonTypes().setAll(buttonTypeYes, buttonTypeCancel);

    	Optional<ButtonType> result = confirmation.showAndWait();
    	
    	if (result.get()==buttonTypeYes) {
    		Parent game = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            
            Scene scene = new Scene(game);
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setTitle("Goblin Slayer");
    		stage.setScene(scene);
    		stage.getIcons().add(new Image("icon.png"));
    		stage.show();
    	}
    }

    @FXML
    void initialize() {

    }
}

