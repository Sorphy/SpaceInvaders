package objects;

import java.util.ArrayList;

import game.GameWindow;

public class EnemyMoveComputer {
	
	private double direction = 0.0;
	private GameWindow window;	
	
	public EnemyMoveComputer(GameWindow window) {
		this.window = window;
	}
	
	private boolean verifyDirection(ArrayList<IMovable> objects) {
		for(IMovable object : objects) {
				if(!(((EnemyShip) object).checkBorders(this.window.getWindowWidth(), 
						this.window.getWindowHeight(), this.window.getOffsetX(), this.window.getOffsetY()))) {
					return false;
				}
		}
		return true;
	}

	private void internalMove(ArrayList<IMovable> objects, double direction, double y) {
		for(IMovable object : objects) {
			object.setPosition(object.getPosX() + direction, object.getPosY() + y);
		}
	}

	public void move(ArrayList<IMovable> objects, double speed) {
		if(this.direction == 0.0) {
			this.direction = speed;
		}
		if(!this.verifyDirection(objects)){
			this.direction = -this.direction;
			this.internalMove(objects, this.direction, 10);	
		}
		else {
			this.internalMove(objects, this.direction, 0);
		}
	}
}
