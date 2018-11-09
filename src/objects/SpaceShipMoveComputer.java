package objects;

import gameLogic.GameWindow;

public class SpaceShipMoveComputer {

	private IMovable spaceShip;
	private GameWindow window;
	
	public SpaceShipMoveComputer(IMovable spaceShip, GameWindow window) {
		this.spaceShip = spaceShip;
		this.window = window;
	}
	
	/*private boolean verifyBorder(){
		boolean border = spaceShip.checkBorders(window.getWindowWidth(), window.getWindowHeight(), window.getOffsetX(), window.getOffsetY());
		
	}*/
	
	public void move(boolean left, boolean right) {
		if(left) {
			this.spaceShip.setPosition(this.spaceShip.getPosX() - 1, this.spaceShip.getPosY());
		}
		else if(right) {
			this.spaceShip.setPosition(this.spaceShip.getPosX() + 1, this.spaceShip.getPosY());
		}
	}
}
