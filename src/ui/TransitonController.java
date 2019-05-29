package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Game;

/**
 *This class is in charge of controlling the GUI of the transition between levels screen
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 */
public class TransitonController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lives;
    
    @FXML
    private Pane change;
    
    private Game game;

    /**
     * This methos is n charge of the logic to change the scene between levels
     * @throws IOException
     */
    public void transitionBetweenLevels() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
    	Scene scene = lives.getScene();
    	
    	root.translateXProperty().set(scene.getHeight());
    	change.getChildren().add(root);
    	
    	Timeline timeline = new Timeline();
    	KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
    	KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
    	timeline.getKeyFrames().add(kf);
    	timeline.setOnFinished(event -> {
    		change.getChildren().remove(change);
    	});
    	timeline.play();
    }

    /**
     * initialize method to set the lives of the player between levels
     */
    @FXML
    void initialize() {
    	lives.setText(game.getLevel().getPlayer().getLives()+"");
    	
    }
}
