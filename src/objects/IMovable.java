package objects;

public interface IMovable {
	//public void moveTo(double x, double y);
	public boolean checkBorders(double sizeX, double sizeY, double offsetX, double offsetY);
	
	public boolean checkLeftBorder(double offset);
	public boolean checkRightBorder(double sizeX, double offset);
	
	public double getPosX();
	public double getPosY();
	public void setPosition(double x, double y);
}
