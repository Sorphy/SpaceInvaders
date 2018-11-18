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
	
	WelcomePageController(GameWindow window, Canvas canvas){
		this.window = window;
		this.canvas = canvas;
	}
	
	@FXML
	private void startGame(ActionEvent event) {
		Group root = new Group();
		root.getChildren().add(canvas);
		
		Scene scene = new Scene(root);
		this.window.primaryStage.setScene(scene);

		
		GameLoop loop = new GameLoop(this.window);
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				if(e.getCode() == KeyCode.RIGHT) {
    				window.setRightKeyPressed(true);
	    		}
	    		if(e.getCode() == KeyCode.LEFT) {
	    				window.setLeftKeyPressed(true);
	    		}
				if(e.getCode() == KeyCode.SPACE) {
					window.setSpaceKeyPressed(true);
				}
				if(e.getCode() == KeyCode.P) {
					loop.stop();
				}
				if(e.getCode() == KeyCode.C) {
					loop.start();
				}
			}
		});
     
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
        	public void handle(KeyEvent e){
        		if(e.getCode() == KeyCode.RIGHT) {
        				window.setRightKeyPressed(false);
        		}
        		if(e.getCode() == KeyCode.LEFT) {
        				window.setLeftKeyPressed(false);
        		}
				if(e.getCode() == KeyCode.SPACE) {
					window.setSpaceKeyPressed(false);
				}
        	}
        });
		
		
		//GameLoop
		loop.start();
		
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
		// TODO Auto-generated method stub
		
	}
	
}
