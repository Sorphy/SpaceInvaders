package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall implements IDrawable{

	private double posX;
	private double posY;
	private double width;
	private double height;
	
	public Wall(double x, double y) {
		this.posX = x;
		this.posY = y;
		this.width = 10;
		this.height = 10;
	}
	
	
	@Override
	public void draw(GraphicsContext context) {
		context.setFill(Color.DARKORANGE);
		context.fillRect(this.posX, this.posY, this.width, this.height);
	}

	@Override
	public double getPosX() {
		return this.posX;
	}

	@Override
	public double getPosY() {
		return this.posY;
	}

	@Override
	public double getWidth() {
		return this.height;
	}

	@Override
	public double getHeight() {
		return this.width;
	}

}
