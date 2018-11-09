package objects;

import java.util.ArrayList;

import gameLogic.GameWindow;

public class EnemyMoveComputer {
	
	private double direction;
	
	private ArrayList<IMovable> objects;
	private GameWindow window;	
	
	public EnemyMoveComputer(ArrayList<IMovable> objects, GameWindow window, double speed) {
		this.objects = objects;
		this.window = window;
		this.direction = speed;
	}
	
	private boolean verifyDirection() {
		for(IMovable object : this.objects) {
				if(!(((EnemyShip) object).checkBorders(this.window.getWindowWidth(), 
						this.window.getWindowHeight(), this.window.getOffsetX(), this.window.getOffsetY()))) {
					return false;
				}
		}
		return true;
	}

	private void internalMove(double direction, double y) {
		for(IMovable object : this.objects) {
			EnemyShip ship = (EnemyShip)object;
			ship.setPosition(ship.getPosX() + direction, ship.getPosY() + y);
			ship.draw(this.window.getGraphicsContext());
		}
	}

	public void move() {
		if(!this.verifyDirection()){
			this.direction = -this.direction;
			this.internalMove(this.direction, 10);	
		}
		else {
			this.internalMove(this.direction, 0);
		}
	}
}
