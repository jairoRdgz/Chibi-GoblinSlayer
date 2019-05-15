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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Game;

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
	private ImageView fondo;
	
	private Game game;

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
	
	public void moveGround(int movement) {
		if(movement == 1) {
			ground.setTranslateY(ground.getTranslateY()-10);
		}else if(movement == 2) {
			ground.setTranslateY(ground.getTranslateY()+10);
		}else  if(movement == 3) {
			ground.setTranslateX(ground.getTranslateX()-10);
		}else if (movement == 4) {
			ground.setTranslateX(ground.getTranslateX()+10);;
		}
	}

	public void movePlayer(int movement) {
		if(movement == 1) {
			//Up
			player.setY(player.getY() - 10);
			atackBox.setY(atackBox.getY() - 10);
			Image img1 = new Image("images/player2.jpg");
			player.setFill(new ImagePattern(img1));
		}else if(movement == 2) {
			//Down
			player.setY(player.getY() + 10);
			atackBox.setY(atackBox.getY() + 10);
			Image img1 = new Image("images/player1.jpg");
			player.setFill(new ImagePattern(img1));
		}else  if(movement == 3) {
			//Left
			player.setX(player.getX() - 10);
			atackBox.setX(atackBox.getX() - 10);
			Image img1 = new Image("images/player3.jpg");
			player.setFill(new ImagePattern(img1));
		}else {
			//Rigth
			player.setX(player.getX() + 10);
			atackBox.setX(atackBox.getX() + 10);
			Image img1 = new Image("images/player4.jpg");
			player.setFill(new ImagePattern(img1));
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
	
	public GameController getController() {
		return this;
	}

	@FXML
	void initialize() {
		assert ground != null : "fx:id=\"ground\" was not injected: check your FXML file 'Game.fxml'.";
		assert player != null : "fx:id=\"player\" was not injected: check your FXML file 'Game.fxml'.";

		Image img = new Image("images/player1.jpg");
		player.setFill(new ImagePattern(img));
		Image img1 = new Image("images/map2.jpg");
		fondo.setImage(img1);
	}
}
