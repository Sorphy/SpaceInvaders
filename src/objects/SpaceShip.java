package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceShip extends Ship{

	private Image image;
	
	public SpaceShip() {
		super();
		this.image = new Image("spaceship.png", 30, 23, false, false);
	}
	
	public void draw(GraphicsContext context) {
		context.drawImage(image, this.getPosX(), this.getPosY());
	}

}
