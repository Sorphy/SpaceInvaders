package objects;

import javafx.scene.canvas.GraphicsContext;

public interface IDrawable {
	public void draw(GraphicsContext context);
	
	public double getPosX();
	public double getPosY();
	public double getWidth();
	public double getHeight();
}
