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
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Enemy;
import model.Player;
import threads.EnemyThread;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane ground;

    @FXML
    private ImageView fondo;

    @FXML
    private Rectangle atackBox;

    @FXML
    private Rectangle player;

    @FXML
    private Circle newLevel;

    @FXML
    private Rectangle enemy;
    
    private Player slayer;
    
    private Enemy goblins;

    @FXML
    void backToMenu(ActionEvent event) throws IOException {
    	Alert confirmation = new Alert(AlertType.NONE);
		confirmation.setTitle("Goblin Slayer");
		confirmation.setContentText("Are you sure you want to leave the game \nyour progress wont be saved");

		ButtonType buttonTypeYes = new ButtonType("Yes");
		ButtonType buttonTypeCancel = new ButtonType("Cancel");

		confirmation.getButtonTypes().setAll(buttonTypeYes, buttonTypeCancel);

		Optional<ButtonType> result = confirmation.showAndWait();

		if (result.get() == buttonTypeYes) {
			Parent game = FXMLLoader.load(getClass().getResource("Menu.fxml"));

			Scene scene = new Scene(game);

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setTitle("Goblin Slayer");
			stage.setScene(scene);
			stage.getIcons().add(new Image("icon.png"));
			stage.show();
		}
    }
    
    public void movePlayer(int movement) {
    	if(true) {
    		if(movement == 1) {
    			//Up
    			if(player.getY()>=-238) {
    				player.setY(slayer.moveY(movement));
        			atackBox.setY(player.getY());
        			Image img1 = new Image("images/player2.jpg");
        			player.setFill(new ImagePattern(img1));
    			}
    		}else if(movement == 2) {
    			//Down
    			if(player.getY()<=50) {
    				player.setY(slayer.moveY(movement));
        			atackBox.setY(player.getY());
        			Image img1 = new Image("images/player1.jpg");
        			player.setFill(new ImagePattern(img1));
    			}
    			
    		}else  if(movement == 3) {
    			//Left
    			if(player.getX()>= -240) {
    				player.setX(slayer.moveX(movement));
        			atackBox.setX(player.getX());
        			Image img1 = new Image("images/player3.jpg");
        			player.setFill(new ImagePattern(img1));
    			}
    			
    		}else {
    			//Rigth
    			if(player.getX()<= 300) {
    				player.setX(slayer.moveX(movement));
        			atackBox.setX(player.getX());
        			Image img1 = new Image("images/player4.jpg");
        			player.setFill(new ImagePattern(img1));
    			}
    		}
    	}
	}
    
    public void atack(int atack) {
		if(atack == 1) {
			atackBox.setHeight(atackBox.getHeight()+20);
			atackBox.setWidth(atackBox.getWidth()+20);
			atackBox.setLayoutX(atackBox.getLayoutX()-10);
			atackBox.setLayoutY(atackBox.getLayoutY()-10);
		}else if(atack == 2){
			atackBox.setHeight(atackBox.getHeight()-20);
			atackBox.setWidth(atackBox.getWidth()-20);
			atackBox.setLayoutX(atackBox.getLayoutX()+10);
			atackBox.setLayoutY(atackBox.getLayoutY()+10);
		}
	}
    
    public void moveGoblin(int movement) {
		if(movement == 1) {
			//Up
			enemy.setY(goblins.moveY(movement));
			Image img1 = new Image("images/goblin2.jpg");
			player.setFill(new ImagePattern(img1));
		}else if(movement == 2) {
			//Down
			player.setY(slayer.moveY(movement));
			Image img1 = new Image("images/goblin.jpg");
			player.setFill(new ImagePattern(img1));
		}else  if(movement == 3) {
			//Left
			player.setX(slayer.moveX(movement));
			Image img1 = new Image("images/goblin3.jpg");
			player.setFill(new ImagePattern(img1));
		}else {
			//Right
			player.setX(slayer.moveX(movement));
			Image img1 = new Image("images/goblin4.jpg");
			player.setFill(new ImagePattern(img1));
		}
    }
    
    public GameController getController() {
		return this;
	}

    @FXML
    void initialize() {
    	EnemyThread t = new EnemyThread(this, true);
    	t.start();
    	
    	Image imgEnemy = new Image("images/goblin1.jpg");
    	enemy.setFill(new ImagePattern(imgEnemy));
    	
    	goblins = new Enemy(1, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
    	slayer = new Player(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    	
		
		Image img = new Image("images/player1.jpg");
		player.setFill(new ImagePattern(img));
		Image img1 = new Image("images/map2.jpg");
		fondo.setImage(img1);

    }
}
