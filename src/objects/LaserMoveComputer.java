package objects;

import java.util.ArrayList;


public class LaserMoveComputer {

	public void move(ArrayList<IMovable> lasers, double speed) {
		for(IMovable laser : lasers) {
			Laser l = (Laser) laser;
			if(l.getType() == "enemy") {
				this.enemyLaserMove(l, speed);
			}
			else {
				this.spaceShipLaserMove(l, speed);
			}
		}
	}
	
	private void enemyLaserMove(Laser l, double speed) {
		l.setPosition(l.getPosX(), l.getPosY() + speed);
	}
	
	private void spaceShipLaserMove(Laser l, double speed) {
		l.setPosition(l.getPosX(), l.getPosY() - speed);
	}
}
