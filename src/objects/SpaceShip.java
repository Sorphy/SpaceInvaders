package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceShip extends Ship{

	private Image image;
	
	public SpaceShip() {
		super();
		this.width = 38;
		this.height = 30;
		this.image = new Image("spaceship.png", this.width, this.height, false, false);
	}
	
	public void draw(GraphicsContext context) {
		context.drawImage(image, this.getPosX(), this.getPosY());
	}

}
