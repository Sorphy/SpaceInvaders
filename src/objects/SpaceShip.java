package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceShip extends Ship{

	private Image image;
	
	public SpaceShip() {
		super();
		this.width = 38;
		this.height = 30;
		try {
			FileInputStream img = new FileInputStream(".\\images\\spaceship.png");

			this.image = new Image(img, this.width, this.height, false, false);
		}catch(IllegalArgumentException e) {
			System.out.println("Error occured: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Error occured: " + e.getMessage());
	}
	}
	
	public void draw(GraphicsContext context) {
		context.drawImage(image, this.getPosX(), this.getPosY());
	}

}
