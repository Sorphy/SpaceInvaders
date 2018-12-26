package game;

import java.net.URL;
import java.util.ResourceBundle;

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
	/*	Group root = new Group();
		root.getChildren().add(canvas);
		
		this.window.primaryStage.setWidth(this.window.getWindowWidth());
		this.window.primaryStage.setHeight(this.window.getWindowHeight());
		
		Scene scene = new Scene(root);
		this.window.primaryStage.setScene(scene);

		
		GameLoop loop = new GameLoop(this.window);
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				switch(e.getCode()) {
				case RIGHT:
					window.setRightKeyPressed(true);
					break;
				case LEFT:
					window.setLeftKeyPressed(true);
					break;
				case SPACE:
					window.setSpaceKeyPressed(true);
					break;
				case P:
					loop.stop();
					break;
				case C:
					loop.start();
					break;
				}
			}
		});
     
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
        	public void handle(KeyEvent e){
        		
        		switch(e.getCode()) {
        		case RIGHT:
        			window.setRightKeyPressed(false);
        			break;
        		case LEFT:
        			window.setLeftKeyPressed(false);
        			break;
        		case SPACE:
        			window.setSpaceKeyPressed(false);
        			break;
        		}
        	}
        });
		
		
		//GameLoop
		loop.start();*/
		
		GameController controller = new GameController(window, canvas);
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
