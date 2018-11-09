package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnemyShip extends Ship{

	private Image image;
	private int point;
	
	public EnemyShip() {
		super();
		this.image = new Image("space.png", 30, 23, false, false);
		this.point = 100;
	}	
	
	@Override
	public void draw(GraphicsContext context) {
		context.drawImage(this.image, this.getPosX(), this.getPosY());
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public int getPoint() {
		return this.point;
	}

}
