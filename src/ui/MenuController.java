package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void createMap(ActionEvent event) {

    }

    @FXML
    void helpWindow(ActionEvent event) {
    	Alert score = new Alert(AlertType.INFORMATION);
    	score.setTitle("Goblin Slayer");
    	score.setHeaderText("INSTRUCCIONS");
    	score.initStyle(StageStyle.DECORATED);
    	score.setContentText("Press Start Game to start \n"
    			+ "use the arrows to move \n"
    			+ "there are three levels pass them all in order to win \n"
    			+ "if you want real challenge create your own map and play it in hardcore mode \n\n"
    			+ "good luck and kill all those bastards goblins");
    	
    	score.show();
    }

    @FXML
    void startGame(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
