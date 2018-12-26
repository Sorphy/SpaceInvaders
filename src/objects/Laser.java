package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Laser implements IMovable, IDrawable{
	
	private Image image;
	private double posX;
	private double posY;
	private double width;
	private double height;
	
	private String type;
	
	public Laser(String type) {
		this.width = 5;
		this.height = 10;
		// "../images/laser.png"
		try {
			FileInputStream img = new FileInputStream(".\\images\\laser.png");

			this.image = new Image(img, this.width, this.height, false, false);
		}catch(IllegalArgumentException e) {
			System.out.println("Error occured: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Error occured: " + e.getMessage());
	}
		
		
		this.type = type;
	}

	@Override
	public void draw(GraphicsContext context) {
		context.drawImage(this.image, this.getPosX(), this.getPosY());
	}

	@Override
	public boolean checkBorders(double sizeX, double sizeY, double offsetX, double offsetY) {
		return this.checkLeftBorder(offsetX) &&
			   this.checkRightBorder(sizeX, offsetX) && 
			   this.checkTopBorder(offsetY) && 
			   this.checkBottomBorder(sizeY, offsetY);
	}

	@Override
	public boolean checkLeftBorder(double offset) {
		return this.posX <= offset;
	}

	@Override
	public boolean checkRightBorder(double sizeX, double offset) {
		return this.posX + this.width >= sizeX - offset;
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
	public void setPosition(double x, double y) {
		this.posX = x;
		this.posY = y;
		
	}

	@Override
	public boolean checkTopBorder(double offset) {
		return this.posY <= offset;
	}

	@Override
	public boolean checkBottomBorder(double sizeY, double offset) {
		return this.posY + this.height >= sizeY - offset;
	}

	public String getType() {
		return type;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	
	
}
