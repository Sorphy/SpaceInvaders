package objects;

import game.GameWindow;

public class SpaceShipMoveComputer {

	private GameWindow window;
	
	public SpaceShipMoveComputer(GameWindow window) {
		this.window = window;
	}
	
	public void move(IMovable spaceShip, boolean left, boolean right) {
		if(left) {
			if(!spaceShip.checkLeftBorder(this.window.getOffsetX())) {
				spaceShip.setPosition(spaceShip.getPosX() - 4, spaceShip.getPosY());
			}
		}
		else if(right) {
			if(!spaceShip.checkRightBorder(this.window.getWindowWidth(), this.window.getOffsetX())) {
				spaceShip.setPosition(spaceShip.getPosX() + 4, spaceShip.getPosY());
			}
		}
	}
}
