package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnemyShip extends Ship{

	private Image image;
	private int point;
	
	public EnemyShip() {
		super();
		this.width = 30;
		this.height = 23;
		try {
			FileInputStream img = new FileInputStream(".\\images\\space.png");

			this.image = new Image(img, this.width, this.height, false, false);
		}catch(IllegalArgumentException e) {
			System.out.println("Error occured: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Error occured: " + e.getMessage());
	}
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
