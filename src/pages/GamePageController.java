package pages;

import game.GameLoop;
import game.GameWindow;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;

public class GamePageController {
	
	private GameWindow window;
	private Canvas canvas;
	
	
	public GamePageController(GameWindow window, Canvas canvas){
		this.window = window;
		this.canvas = canvas;
	}
	
	public void startGameController() {
		Group root = new Group();
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
		loop.start();
	}

}
