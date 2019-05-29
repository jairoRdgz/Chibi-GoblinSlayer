package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Game;
import model.Score;
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
    
    private Game game;

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
     * Shows a list with the scores of each person that had played the game
     * @return
     */
    public String showScoresList() {
    	String scores = "";
    	List<Score> l = game.inOrderScores();
    	for (int i = 0; i < l.size(); i++) {
			scores += l.get(i).getNick() + "\t" + l.get(i).getScore()+"\n";
		}
    	return scores;
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
    	score.setContentText("NickName \t\t Game Time \n"+showScoresList());
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
				if(e.getCode().equals(KeyCode.W)||e.getCode().equals(KeyCode.UP)) {
					try {
						gc.movePlayer(1);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.S)||e.getCode().equals(KeyCode.DOWN)) {
					try {
						gc.movePlayer(2);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.A)||e.getCode().equals(KeyCode.LEFT)) {
					try {
						gc.movePlayer(3);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.D)||e.getCode().equals(KeyCode.RIGHT)) {
					try {
						gc.movePlayer(4);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else if(e.getCode().equals(KeyCode.L)||e.getCode().equals(KeyCode.Q)) {
					atack = new AtackThread(gc);
					atack.start();
				}
					
			}
		});
		stage.setTitle("Goblin Slayer");
		stage.setScene(scene);
		stage.getIcons().add(new Image("icon.png"));
		stage.show();
		
        
    }

    @FXML
    void initialize() {
    	game = new Game();
    	
    	Image img = new Image("images/btn1.png");
    	gameStarter.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
    }
}
