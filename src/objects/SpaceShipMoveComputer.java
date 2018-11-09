package objects;

import game.GameWindow;

public class SpaceShipMoveComputer {

	private IMovable spaceShip;
	private GameWindow window;
	
	public SpaceShipMoveComputer(IMovable spaceShip, GameWindow window) {
		this.spaceShip = spaceShip;
		this.window = window;
	}
	
	public void move(boolean left, boolean right) {
		if(left) {
			if(!spaceShip.checkLeftBorder(this.window.getOffsetX())) {
				this.spaceShip.setPosition(this.spaceShip.getPosX() - 2, this.spaceShip.getPosY());
			}
		}
		else if(right) {
			if(!spaceShip.checkRightBorder(this.window.getWindowWidth(), this.window.getOffsetX())) {
				this.spaceShip.setPosition(this.spaceShip.getPosX() + 2, this.spaceShip.getPosY());
			}
		}
	}
}
