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

    @FXML
    void initialize() {
    	lives.setText(game.getLevel().getPlayer().getLives()+"");
    	
    }
}
