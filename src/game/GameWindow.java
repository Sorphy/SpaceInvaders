package game;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameWindow extends Application{

	private String titleText = "Space Invaders";
	private final int defaultSizeX = 600;
	private final int defaultSizeY = 700;
	private final Color defaultBackgroudColor = Color.DARKGRAY;
	
	private GraphicsContext context;
	private Canvas canvas;
	
	public Stage primaryStage;
	
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
		this.primaryStage = primaryStage;
		
		this.initWelcomePage();
		
	}
	
	
	public void initWelcomePage() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("welcomePage.fxml"));
            loader.setController(new WelcomePageController(this, this.canvas));
            VBox rootLayout = (VBox) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.setWidth(600);
            this.primaryStage.setHeight(500);
            this.primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void initEndGamePage(GameLoop loop) {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("endPage.fxml"));
            loader.setController(new EndPageController(this, loop));
            VBox rootLayout = (VBox) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.setWidth(600);
            this.primaryStage.setHeight(500);
            this.primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void initTopScorePage() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TopScorePage.fxml"));
            loader.setController(new TopScorePageController(this));
            VBox rootLayout = (VBox) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
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


	public void setLeftKeyPressed(boolean leftKeyPressed) {
		this.leftKeyPressed = leftKeyPressed;
	}


	public void setRightKeyPressed(boolean rightKeyPressed) {
		this.rightKeyPressed = rightKeyPressed;
	}


	public void setSpaceKeyPressed(boolean spaceKeyPressed) {
		this.spaceKeyPressed = spaceKeyPressed;
	}
	
	
	
}
