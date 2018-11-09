package game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameScene extends Scene{

	private GameWindow window; 
	private Canvas canvas;
	private GraphicsContext context;
	
	public GameScene(Parent root, double width, double height, GameWindow window) {
		super(root, width, height);
		
		/*//root.getChildren().add(canvas);
		
		this.window = window;
		
		//this.canvas = new Canvas(this.window.getDefaultSizeX(), this.window.getDefaultSizeY());
		this.context = canvas.getGraphicsContext2D();


		
		this.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				if(e.getCode() == KeyCode.RIGHT) {
					window.setRightKeyPressed(true);
				}
				if(e.getCode() == KeyCode.LEFT) {
					window.setLeftKeyPressed(true);
				}
			}
		});
	 
	    this.setOnKeyReleased(new EventHandler<KeyEvent>(){
	    	public void handle(KeyEvent e){
	    		if(e.getCode() == KeyCode.RIGHT) {
	    				window.setRightKeyPressed(false);
	    		}
	    		if(e.getCode() == KeyCode.LEFT) {
	    				window.setLeftKeyPressed(false);
	    		}
	    	}
	    });*/
	}

	public GraphicsContext getContext() {
		return context;
	}
	
	
}