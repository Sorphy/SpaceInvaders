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
		
		GameLoop loop = new GameLoop(this.window);
		loop.start();
	}
	
	@FXML
	private void topScore(ActionEvent event) {
		System.out.println("TOP");
	}
	
	@FXML
	private void end(ActionEvent event) {
		System.out.println("End");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
