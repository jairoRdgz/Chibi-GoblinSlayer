package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import threads.ControlThread;
import threads.EnemyThread;
/**
 * This class is in charge of controlling the GUI of the game screen for this program.
 * Is in charge of the logic to move the player and the enemies in the screen.
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
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
    private ImageView heart1;

    @FXML
    private ImageView heart2;
    
    @FXML
    private BorderPane everyThing;
    
    @FXML
    private HBox vidas;
    
    private Game game;
    
    private Player slayer;
    
    private Enemy goblins;
    
    private ControlThread ct;
    
    private ArrayList<Enemy> enemys;
    private ArrayList<Rectangle> recEnemys;
    
    private long points;

    /**
     * This OnAction serves to return to the Menu from the game screen
     * @param event
     * @throws IOException
     */
    @FXML
    void backToMenu(ActionEvent event) throws IOException {
    	newScore();
    	
    	Alert confirmation = new Alert(AlertType.NONE);
		confirmation.setTitle("Goblin Slayer");
		confirmation.setContentText("Are you sure you want to leave the game \nyour progress wont be saved");

		ButtonType buttonTypeYes = new ButtonType("Yes");
		ButtonType buttonTypeCancel = new ButtonType("Cancel");

		confirmation.getButtonTypes().setAll(buttonTypeYes, buttonTypeCancel);

		Optional<ButtonType> result = confirmation.showAndWait();

		if (result.get() == buttonTypeYes) {
			endGame();
		}
    }
     /**
      * This method is in charge to end the game
      * it closes the game scene and goes back to the Menu
      * @throws IOException
      */
    public void endGame() throws IOException {
    	Parent game = FXMLLoader.load(getClass().getResource("Menu.fxml"));

		Scene scene = new Scene(game);

		Stage stage = (Stage) player.getScene().getWindow();
		stage.setTitle("Goblin Slayer");
		stage.setScene(scene);
		stage.getIcons().add(new Image("icon.png"));
		stage.show();
    }
    /**
     * This method is to make the transitions between the different scenes
     * @throws IOException
     */
    public void transitionBetweenLevels() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
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
    
    /**
     * this method is to add a new score to the game
     */
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
    
    /**
     * This method moves the player(slayer) on the screen.
     * It also know if the player intersects with the enemy.
     * and this change the level.
     * @param movement
     * @throws IOException
     */
    public void movePlayer(int movement) throws IOException {
		if(movement == 1) {
			//Up
			if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				//it will bounce the opposite direction so we now it hits
				player.setY(slayer.getHit());
				//player.setY(slayer.bounceBackY(movement));
				atackBox.setY(player.getY());
				loseLives();
			}else{
				if(player.getY()>=-238) {
					player.setY(slayer.moveY(movement));
	    			atackBox.setY(player.getY());
	    			Image img1 = new Image("images/player1.png");
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
				player.setY(slayer.getHit());
				//player.setY(slayer.bounceBackY(movement));
				atackBox.setY(player.getY());
				loseLives();
			}else{
				if(player.getY()<=20) {
					player.setY(slayer.moveY(movement));
	    			atackBox.setY(player.getY());
	    			Image img1 = new Image("images/player2.png");
	    			player.setFill(new ImagePattern(img1));
				}
			}
			if(newLevel.isVisible()) {
				if(player.getBoundsInParent().intersects(newLevel.getBoundsInParent())) {
					System.out.println("Cambiar de nivel");
					transitionBetweenLevels();
				}
			}
		}else  if(movement == 3) {
			//Left
			if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				//it will bounce the opposite direction so we now it hits
				player.setX(slayer.getHit());
				//player.setX(slayer.bounceBackX(movement));
				atackBox.setX(player.getX());
				loseLives();
			}else{
				if(player.getX()>= -240) {
					player.setX(slayer.moveX(movement));
	    			atackBox.setX(player.getX());
	    			Image img1 = new Image("images/player3.png");
	    			player.setFill(new ImagePattern(img1));
				}
			}
			if(newLevel.isVisible()) {
				if(player.getBoundsInParent().intersects(newLevel.getBoundsInParent())) {
					System.out.println("Cambiar de nivel");
					transitionBetweenLevels();
				}
			}
		}else {
			//Rigth
			if(player.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				//it will bounce the opposite direction so we now it hits
				player.setX(slayer.getHit());
				player.setX(slayer.bounceBackX(movement));
				atackBox.setX(player.getX());
				loseLives();
			}else {
				if(player.getX()<= 300) {
					player.setX(slayer.moveX(movement));
	    			atackBox.setX(player.getX());
	    			Image img1 = new Image("images/player4.png");
	    			player.setFill(new ImagePattern(img1));
				}
			}
			if(newLevel.isVisible()) {
				if(player.getBoundsInParent().intersects(newLevel.getBoundsInParent())) {
					System.out.println("Cambiar de nivel");
					transitionBetweenLevels();
				}
			}
		}
	}
    
    /**
     * This method is in charge of count and set the amount of lives of the player
     * @throws IOException
     */
    public void loseLives() throws IOException {
    	int hits =slayer.getLives();
    	slayer.setLives(slayer.getLives()-1);
    	if(hits==3) {
    		heart2.setVisible(false);
    	}else if(hits == 2) {
    		heart1.setVisible(false);
    	}else if (hits == 1) {
    		heart.setVisible(false);
    		newScore();
    		endGame();
    	}
    	
    }
    
    /**
     * This method is in charge of the slayer attack
     * @param atack
     */
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
		killEnemies();
	}
    
    /**
     * This method recognizes when an enemy is murdered
     */
    public void killEnemies() {
    	for (int i = 0; i < enemys.size(); i++) {
			if(atackBox.getBoundsInParent().intersects(recEnemys.get(i).getBoundsInParent())) {
				enemys.get(i).setLives(enemys.get(i).getLives()-1);
				if(enemys.get(i).getLives()<=0) {
					ground.getChildren().remove(recEnemys.get(i));
					enemys.remove(i);
					recEnemys.remove(i);
				}
			}
		}
    	if(enemys.size()<=0) {
    		newLevel.setVisible(true);
    	}
    }
    
    /**
     * This method moves the enemies(goblins) on the screen
     * @param movement
     */
    public void moveGoblin(int movement) {
		if(movement == 1) {
			//Up
			enemy.setY(goblins.moveY(movement));
			Image img1 = new Image("images/goblin2.png");
			player.setFill(new ImagePattern(img1));
		}else if(movement == 2) {
			//Down
			player.setY(slayer.moveY(movement));
			Image img1 = new Image("images/goblin.png");
			player.setFill(new ImagePattern(img1));
		}else  if(movement == 3) {
			//Left
			player.setX(slayer.moveX(movement));
			Image img1 = new Image("images/goblin3.png");
			player.setFill(new ImagePattern(img1));
		}else {
			//Right
			player.setX(slayer.moveX(movement));
			Image img1 = new Image("images/goblin4.png");
			player.setFill(new ImagePattern(img1));
		}
    }
    
    /**
     * not sure what is this DO NOT DELETE
     * @return
     */
    public GameController getController() {
		return this;
	}
    /**
     * This method is in charge to load the level to start the game
     * @param path
     */
    public void loadLevel(String path) {
    	int layoutX = 0;
    	int layoutY = 0;
    	
    	try {
    		
    		File f = new File(path);
    		FileReader fr = new FileReader(f);
    		BufferedReader br = new BufferedReader(fr);
		
    		String line = br.readLine();
    		line = br.readLine();
    		line = br.readLine();
    		line = br.readLine();
    		
    		while(line != null) {
    			
				String[] variables = line.split("-");
				layoutX = Integer.parseInt(variables[0]);
				layoutY = Integer.parseInt(variables[1]);
				
				Enemy ene = new Enemy(1, layoutX, layoutY, 10, 10);
				enemys.add(ene);
				line = br.readLine();
				//System.out.println("enemy creado");
			}
    		
			br.close();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	for(int i = 0 ; i < enemys.size() ; i++) {
    		Rectangle rEne = new Rectangle(enemys.get(i).getPosx(), enemys.get(i).getPosy(), 50, 50);
    		Image imgEnemy = new Image("images/goblin1.png");
        	rEne.setFill(new ImagePattern(imgEnemy));
        	rEne.setVisible(true);
        	recEnemys.add(rEne);
        	ground.getChildren().add(rEne);
    		System.out.println("enemy rectangulo creado");
    		EnemyThread bt = new EnemyThread(this, true, enemys.get(i));
        	bt.setDaemon(true);
        	bt.start();
    	}
    	
    	
    }
    /**
     * This method update the enemies status
     */
    public void update() {
    	for (int id = 0; id < recEnemys.size(); id++) {
    		recEnemys.get(id).setLayoutX(enemys.get(id).getPosx());
    		recEnemys.get(id).setLayoutY(enemys.get(id).getPosy());
    		enemy.setLayoutX(enemys.get(id).getPosx());
    		//System.out.println("enemys actualizados");
    	}
    }
    /**
     * This method gets the width
     * @return
     */
    public double getWith() {
		return ground.getWidth();
	}
    /**
     * This method gets the height
     * @return
     */
    public double getHeigth() {
		return ground.getHeight();
	}

    /**
     * This method initializes the scene 
     * The slayer
     * The enemies
     * The map
     */
    @FXML
    void initialize() {
    	//The anti-NullPointers :v
    	//goblins = new Enemy(1, enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
    	slayer = new Player(player.getX(), player.getY(), player.getWidth(), player.getHeight());
    	game = new Game();
    	
    	//The thread that is supposed to move the enemies #help
    	
    	//The enemy test its only to test it
    	Image imgEnemy = new Image("images/goblin1.png");
    	enemy.setFill(new ImagePattern(imgEnemy));
    	enemy.setVisible(false);
    	
    	enemys = new ArrayList<Enemy>();
    	recEnemys = new ArrayList<Rectangle>();
    	loadLevel("Data/level0.txt");
    	ct = new ControlThread(this);
    	ct.setDaemon(true);
    	ct.start();
    	
    	
		//The player image
		Image img = new Image("images/player1.png");
		player.setFill(new ImagePattern(img));
		
		points = System.currentTimeMillis();
		
		Image portal = new Image("images/portal.png");
		newLevel.setFill(new ImagePattern(portal));
		newLevel.setVisible(false);
    }
}
