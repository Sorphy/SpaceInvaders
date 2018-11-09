package objects;

public interface IMovable {
	public void moveTo(double x, double y);
	public boolean checkBorders(double sizeX, double sizeY, double offsetX, double offsetY);
}
