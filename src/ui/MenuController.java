package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import threads.AtackThread;

/**
 *This class is in charge of controlling the GUI of the Menu screen for this program
 *is in charge of creating and opening the game screen where the game is going to be played,
 * showing the top players and creating a new map you can play in.
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 */
public class MenuController{
	
	//---------------------------------------------------------------------------------------
	//ATRIBUTES, RELATIONS AND FXML OBJECTS
	//---------------------------------------------------------------------------------------
	@FXML
	private Button gameStarter;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    private AtackThread atack;

    //--------------------------------------------------------------------------------------
    //METHODS
    //--------------------------------------------------------------------------------------
    
    /**
     *Creates a map to play in hard mode 
     *@param event  is the click you do into the button so the program knows when you want to create and play your own level
     */
    @FXML
    void createMap(ActionEvent event) {

    }
    
    /**
     * Creates an alert the will pop up to show the top 10 players of the game sorting them by the
     * time they took to pass all the game
     * @param event is the click you do into the button so the program knows when you want to see the high scores
     */
    @FXML
    void showScores(ActionEvent event) {
    	Alert score = new Alert(AlertType.INFORMATION);
    	score.setTitle("Goblin Slayer");
    	score.setHeaderText("High Scores");
    	score.initStyle(StageStyle.DECORATED);
    	score.setContentText("NickName \t\t Game Time \n");
    	
    	score.show();
    }
    
    /**
     * Creates an alert that will pop up to show some of the basic information of how to play the game
     * also comes with some useful information about the program itself.
     * @param event is the click you do into the button so the program knows when you want to see the instructions
     */
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
    
    /**
     * Load the actual Game screen of the program, where the program is going to be played
     * @param event is the click you do into the button so the program knows when you want to do this action
     * @exception throws an IOException in case the method is unable to load the .fxml file
     * */
    @FXML
    void startGame(ActionEvent event) throws IOException {
    	
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
		Parent root = loader.load();
		GameController gc = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if(e.getCode().equals(KeyCode.W)) {
					gc.moveGround(1);
					gc.movePlayer(1);
				}else if(e.getCode().equals(KeyCode.S)) {
					gc.moveGround(2);
					gc.movePlayer(2);
				}else if(e.getCode().equals(KeyCode.A)) {
					gc.moveGround(3);
					gc.movePlayer(3);
				}else if(e.getCode().equals(KeyCode.D)) {
					gc.moveGround(4);
					gc.movePlayer(4);
				}else if(e.getCode().equals(KeyCode.SPACE)) {
					atack = new AtackThread(gc);
					atack.start();
				}
					
			}
		});
		
		stage.setTitle("Goblin Slayer");
		stage.setScene(scene);
		stage.getIcons().add(new Image("icon.png"));
		stage.setFullScreen(true);
		stage.show();
		
        
    }

    @FXML
    void initialize() {
    }
}
