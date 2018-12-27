package game;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameScene extends Scene{

	private GameWindow window; 
	private Canvas canvas;
	private GraphicsContext context;
	
	public GameScene(Parent root, double width, double height, GameWindow window) {
		super(root, width, height);
	}

	public GraphicsContext getContext() {
		return context;
	}
	
	
}