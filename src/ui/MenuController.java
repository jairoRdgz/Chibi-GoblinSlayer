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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {
	
	@FXML
	private Button gameStarter;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void createMap(ActionEvent event) {

    }
    
    @FXML
    void showScores(ActionEvent event) {
    	Alert score = new Alert(AlertType.INFORMATION);
    	score.setTitle("Goblin Slayer");
    	score.setHeaderText("High Scores");
    	score.initStyle(StageStyle.DECORATED);
    	score.setContentText("NickName \t\t Game Time \n");
    	
    	score.show();
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
    void startGame(ActionEvent event) throws IOException {
        Parent game = FXMLLoader.load(getClass().getResource("Game.fxml"));
        
        Scene scene = new Scene(game);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Goblin Slayer");
		stage.setScene(scene);
		stage.getIcons().add(new Image("icon.png"));
		stage.show();
    }

    @FXML
    void initialize() {

    }
}
