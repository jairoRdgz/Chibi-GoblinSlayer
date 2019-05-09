package ui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane ground;

    @FXML
    private Rectangle player;
    
    @FXML
    private Rectangle atackBox;
    
    @FXML
    private Circle endGame;

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
    void moveUp(ActionEvent event) {
    	player.setY(player.getY()-6);
    	atackBox.setY(atackBox.getY()-6);
    }
    
    @FXML
    void moveDown(ActionEvent event) {
    	player.setY(player.getY()+6);
    	atackBox.setY(atackBox.getY()+6);
    }
    
    @FXML
    void moveLeft(ActionEvent event) {
    	player.setX(player.getX()-6);
    	atackBox.setX(atackBox.getX()-6);
    }
    
    @FXML
    void moveRight(ActionEvent event) {
    	player.setX(player.getX()+6);
    	atackBox.setX(atackBox.getX()+6);
    }
    
    @FXML
    void atack(ActionEvent event) {
    	if(atackBox.getLayoutX()>= 240.0) {
    		atackBox.setLayoutX(atackBox.getLayoutX()-10);
        	atackBox.setLayoutY(atackBox.getLayoutY()-10);
        	atackBox.setWidth(atackBox.getWidth()+20);
        	atackBox.setHeight(atackBox.getHeight()+20);
    	}else {
    		atackBox.setLayoutX(atackBox.getLayoutX()+10);
        	atackBox.setLayoutY(atackBox.getLayoutY()+10);
        	atackBox.setWidth(atackBox.getWidth()-20);
        	atackBox.setHeight(atackBox.getHeight()-20);
    	}
    }

    //public void movePlayer() {
    //	System.out.println("asdfghjk");
    //	player.setY(player.getY()-6);
    //}
    
    
    @FXML
    void initialize() {
        assert ground != null : "fx:id=\"ground\" was not injected: check your FXML file 'Game.fxml'.";
        assert player != null : "fx:id=\"player\" was not injected: check your FXML file 'Game.fxml'.";
        
        Image img = new Image("icon.png");
    	player.setFill(new ImagePattern(img));
    	Random rnd = new Random();
    	
    	for(int i = 0; i<5;i++) {
    		Rectangle enemy = new Rectangle(rnd.nextDouble(),rnd.nextDouble(),rnd.nextDouble(),rnd.nextDouble());
    		ground.getChildren().add(enemy);
    	}

    }
}

