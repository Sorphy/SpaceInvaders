package objects;

import javafx.scene.canvas.GraphicsContext;

public abstract class Ship implements IMovable, IDrawable{

	private double posX;
	private double posY;
	protected double width;
	protected double height;
	
	public Ship() {
		this.posX = 0;
		this.posY = 0;
		this.width = 30;
		this.height = 23;
	};

	@Override
	public abstract void draw(GraphicsContext context);

	/*@Override
	public void moveTo(double x, double y) {
		this.setPosition(x, y);
		
	}*/

	@Override
	public boolean checkBorders(double sizeX, double sizeY, double offsetX, double offsetY) {
		if(this.getPosX() + this.getWidth() >= sizeX - offsetX || this.posX <= offsetX) { return false; }
		
		if(this.getPosY() + this.getHeight() >= sizeY - offsetY || this.posY <= offsetY){ return false; }
		
		return true;
	}
	
	public boolean checkLeftBorder(double offset) {
		return this.posX <= offset;
	}
	
	public boolean checkRightBorder(double sizeX, double offset) {
		return this.posX + this.width >= sizeX - offset;
	}
	
	public void setPosX(double x) {
		this.posX = x;
	}
	
	public void setPosY(double y) {
		this.posY = y;
	}
	
	public void setPosition(double x, double y) {
		this.posX = x;
		this.posY = y;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getPosX() {
		return this.posX;
	}
	
	public double getPosY() {
		return this.posY;
	}
}
