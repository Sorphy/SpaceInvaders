package gameLogic;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import objects.EnemyShip;
import objects.IDrawable;
import objects.IMovable;
import objects.SpaceShip;
import utils.LevelInfo;

public class GameLoop extends AnimationTimer{

	private GameWindow window;
	private LevelInfo level;
	private ArrayList<IDrawable> objects;
	private double direction;
	private final double offsetX = 20;
	private final double offsetY = 10;
	
	
	public GameLoop(GameWindow window) {
		this.window = window;
		this.level = new LevelInfo();
		this.objects = this.generateObjects();
		this.direction = this.level.getSpeed();
		
	}
	
	@Override
	public void handle(long arg0) {
		
		this.clearSpace();
		
		//Changing directions of enemy ships
		if(!this.verifyDirection()){
			this.direction = -this.direction;
			this.move(this.direction, 10);	
		}
		else {
			this.move(this.direction, 0);
		}
	}
	
	
	private void clearSpace() {
		this.window.getGraphicsContext().fillRect(0, 0, this.window.getWindowWidth(), this.window.getWindowHeight());
	}
	
	
	//If any enemy is on the border, it return false
	private boolean verifyDirection() {
		boolean border = true;
		for(IDrawable object : this.objects) {
			if(object instanceof EnemyShip) {
				border = (((EnemyShip) object).checkBorders(this.window.getWindowWidth(), 
						this.window.getWindowHeight(), this.offsetX, this.offsetY));
				if(!border) { break; }
				
			}
		}
		return border;
	}
	
	//
	private void move(double direction, int y) {
		for(IDrawable object : this.objects) {
			if(object instanceof EnemyShip) {
				EnemyShip ship = (EnemyShip)object;
				ship.setPosition(ship.getPosX() + direction, ship.getPosY() + y);
				//ship.draw(this.window.getGraphicsContext());
			}
			if(object instanceof SpaceShip) {
				SpaceShip ship = (SpaceShip)object;
				if(window.isLeftKeyPressed()) {
					if(ship.checkBorders(this.window.getWindowWidth(), this.window.getWindowHeight(), this.offsetX, this.offsetY)) {
						ship.setPosition(ship.getPosX() - 1, ship.getPosY()); 
					}
					else {
						ship.setPosition(ship.getPosX() + 1, ship.getPosY());
					}
				}
				else if (window.isRightKeyPressed()) { 
					if(ship.checkBorders(this.window.getWindowWidth(), this.window.getWindowHeight(), this.offsetX, this.offsetY)) {
						ship.setPosition(ship.getPosX() + 1, ship.getPosY()); 
					}
					else {
						ship.setPosition(ship.getPosX() - 1, ship.getPosY());
					}
				}
			}
			
			object.draw(this.window.getGraphicsContext());
			
		}
	}

	private ArrayList<IDrawable> generateObjects(){

		ArrayList<IDrawable> tmp = new ArrayList<IDrawable>();
		
		double posX = 180;	//offest
		double posY = 100;
		
		double gapX = ((window.getWindowWidth() - (2 * posX)) - (6 * 30)) / 5;
		double gapY = 20;
		
		int x = this.level.getEnemyCount() / this.level.getCountInLine();
		
		for(int i = 0; i < x; i++) {
			EnemyShip enemy = null;
			for(int y = 0; y < 6; y++) {
				enemy = new EnemyShip();
				enemy.setPosX(posX);
				enemy.setPosY(posY);

				tmp.add(enemy);
				
				posX += enemy.getWidth() + gapX;
			}	
			posX = 180;
			posY += enemy.getHeight() + gapY; 
		}
		
		SpaceShip spaceShip = new SpaceShip();
		spaceShip.setPosition(this.window.getWindowWidth() / 2 - spaceShip.getWidth() / 2, this.window.getWindowHeight() - 100);
		tmp.add(spaceShip);
		return tmp;
	}
	
	
}
