package pages;

import java.net.URL;
import java.util.ResourceBundle;

import game.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class WelcomePageController implements Initializable{

	private GameWindow window;
	private Canvas canvas;
	
	public WelcomePageController(GameWindow window, Canvas canvas){
		this.window = window;
		this.canvas = canvas;
	}
	
	@FXML
	private void startGame(ActionEvent event) {
		GamePageController controller = new GamePageController(window, canvas);
		controller.startGameController();
		
	}
	
	@FXML
	private void topScore(ActionEvent event) {
		this.window.initTopScorePage();
	}
	
	@FXML
	private void end(ActionEvent event) {
		this.window.primaryStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		return;
		
	}
	
}
