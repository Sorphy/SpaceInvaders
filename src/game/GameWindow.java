package game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameWindow extends Application{

	private String titleText = "Space Invaders";
	private final int defaultSizeX = 600;
	private final int defaultSizeY = 500;
	private final Color defaultBackgroudColor = Color.DARKGRAY;
	
	private GraphicsContext context;
	private Canvas canvas;
	
	private boolean leftKeyPressed;
	private boolean rightKeyPressed;
	private boolean spaceKeyPressed;
	
	private final double offsetX = 20;
	private final double offsetY = 10;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(this.titleText);
		primaryStage.setResizable(false);
		primaryStage.setWidth(defaultSizeX);
		primaryStage.setHeight(defaultSizeY);
		
		this.canvas = new Canvas(this.defaultSizeX, this.defaultSizeY);
		this.context = canvas.getGraphicsContext2D();
		
		Group root = new Group();
		root.getChildren().add(canvas);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent e){
				if(e.getCode() == KeyCode.RIGHT) {
					rightKeyPressed = true;
					System.out.println("Right key pressed");
				}
				if(e.getCode() == KeyCode.LEFT) {
					leftKeyPressed = true;
					System.out.println("Left key pressed");
				}
				if(e.getCode() == KeyCode.SPACE) {
					spaceKeyPressed = true;
					System.out.println("Space key pressed");	
				}
			}
		});
     
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
        	public void handle(KeyEvent e){
        		if(e.getCode() == KeyCode.RIGHT) {
        				rightKeyPressed = false;
        		}
        		if(e.getCode() == KeyCode.LEFT) {
        				leftKeyPressed = false;
        		}
				if(e.getCode() == KeyCode.SPACE) {
					spaceKeyPressed = false;
				}
        	}
        });
		
		
		
		
		
		//GameLoop
		
		GameLoop loop = new GameLoop(this);
		loop.start();
		
		//GameLoop
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public double getWindowWidth() {
		return this.canvas.getWidth();
	}
	
	public double getWindowHeight() {
		return this.canvas.getHeight();
	}
	
	public GraphicsContext getGraphicsContext() {
		return this.context;
	}
	
	public boolean isLeftKeyPressed() {
		return this.leftKeyPressed;
	}
	
	public boolean isRightKeyPressed() {
		return this.rightKeyPressed;
	}

	public double getOffsetX() {
		return offsetX;
	}

	public double getOffsetY() {
		return offsetY;
	}

	public Color getDefaultBackgroudColor() {
		return defaultBackgroudColor;
	}

	public boolean isSpaceKeyPressed() {
		return spaceKeyPressed;
	}
	
	
	
}
