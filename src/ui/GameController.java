package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Enemy;
import model.Game;
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
    private Ellipse newLevel;

    @FXML
    private Rectangle enemy;
    
    @FXML
    private ImageView heart;
    
    @FXML
    private HBox lifeBar;
    
    @FXML
    private BorderPane everyThing;
    
    private Game game;
    
    private Player slayer;
    
    private Enemy goblins;
    
    private long points;

    //read to know what this does
    @FXML
    void backToMenu(ActionEvent event) throws IOException {
    	game = new Game();
    	newScore();
    	
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
    
    public void transitionBetweenLevels() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("transition.fxml"));
    	Scene scene = newLevel.getScene();
    	
    	root.translateXProperty().set(scene.getHeight());
    	everyThing.getChildren().add(root);
    	
    	Timeline timeline = new Timeline();
    	KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
    	KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
    	timeline.getKeyFrames().add(kf);
    	timeline.setOnFinished(event -> {
    		everyThing.getChildren().remove(ground);
    	});
    	timeline.play();
    }

    public void newScore() {
    	points = System.currentTimeMillis()-points;
    	TextInputDialog end = new TextInputDialog();
    	end.setTitle("Goblin Slayer");
    	end.setHeaderText("Add your score to our list");
    	end.setContentText("Your score is: "+points+"\nPlease enter your NickName: ");
    	
    	Optional<String> nick = end.showAndWait();
    	if(nick.isPresent()) {
    		game.addScore(points, nick.get());
    	}
    	
    }
    
    //just read 
    public void movePlayer(int movement) throws IOException {
		if(movement == 1) {
			//Up
			if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				//it will bounce the opposite direction so we now it hits
				player.setY(slayer.bounceBackY(movement));
				atackBox.setY(player.getY());
			}else{
				if(player.getY()>=-238) {
					player.setY(slayer.moveY(movement));
	    			atackBox.setY(player.getY());
	    			Image img1 = new Image("images/player2.jpg");
	    			player.setFill(new ImagePattern(img1));
				}
			}
			if(newLevel.isVisible()) {
				if(player.getBoundsInParent().intersects(newLevel.getBoundsInParent())) {
					System.out.println("Cambiar de nivel");
					transitionBetweenLevels();
				}
			}
		}else if(movement == 2) {
			//Down
			if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				//it will bounce the opposite direction so we now it hits
				player.setY(slayer.bounceBackY(movement));
				atackBox.setY(player.getY());
			}else{
				if(player.getY()<=20) {
					player.setY(slayer.moveY(movement));
	    			atackBox.setY(player.getY());
	    			Image img1 = new Image("images/player1.jpg");
	    			player.setFill(new ImagePattern(img1));
				}
			}
			if(newLevel.isVisible()) {
				if(player.getBoundsInParent().intersects(newLevel.getBoundsInParent())) {
					System.out.println("Cambiar de nivel");
				}
			}
		}else  if(movement == 3) {
			//Left
			if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				//it will bounce the opposite direction so we now it hits
				player.setX(slayer.bounceBackX(movement));
				atackBox.setX(player.getX());
			}else{
				if(player.getX()>= -240) {
					player.setX(slayer.moveX(movement));
	    			atackBox.setX(player.getX());
	    			Image img1 = new Image("images/player3.jpg");
	    			player.setFill(new ImagePattern(img1));
				}
			}
			if(newLevel.isVisible()) {
				if(player.getBoundsInParent().intersects(newLevel.getBoundsInParent())) {
					System.out.println("Cambiar de nivel");
				}
			}
		}else {
			//Rigth
			if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				//it will bounce the opposite direction so we now it hits
				player.setX(slayer.bounceBackX(movement));
				atackBox.setX(player.getX());
			}else {
				if(player.getX()<= 300) {
					player.setX(slayer.moveX(movement));
	    			atackBox.setX(player.getX());
	    			Image img1 = new Image("images/player4.jpg");
	    			player.setFill(new ImagePattern(img1));
				}
			}
			if(newLevel.isVisible()) {
				if(player.getBoundsInParent().intersects(newLevel.getBoundsInParent())) {
					System.out.println("Cambiar de nivel");
				}
			}
		}
	}
    
    //Read you lazy mf
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
		
		if(atackBox.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
			goblins.setLives(goblins.getLives()-1);
			if(goblins.getLives()<=0) {
				enemy.setVisible(false);
				newLevel.setVisible(true);
			}
		}
	}
    
    //read you lazy mf
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
    
    //not sure what is this DO NOT DELETE
    public GameController getController() {
		return this;
	}

    @FXML
    void initialize() {
    	//The anti-NullPointers :v
    	goblins = new Enemy(1, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
    	slayer = new Player(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    	
    	//The thread that is supposed to move the enemies #help
    	EnemyThread t = new EnemyThread(this, true);
    	t.start();
    	
    	//The enemy test its only to test it
    	Image imgEnemy = new Image("images/goblin1.jpg");
    	enemy.setFill(new ImagePattern(imgEnemy));
    	
    	
		//The player image
		Image img = new Image("images/player1.jpg");
		player.setFill(new ImagePattern(img));
		
		points = System.currentTimeMillis();
		
		Image portal = new Image("images/portal.png");
		newLevel.setFill(new ImagePattern(portal));
		newLevel.setVisible(false);
		
    }
}
