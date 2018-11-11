package game;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import objects.EnemyMoveComputer;
import objects.EnemyShip;
import objects.IDrawable;
import objects.IMovable;
import objects.Laser;
import objects.LaserMoveComputer;
import objects.SpaceShip;
import objects.SpaceShipMoveComputer;
import utils.LevelInfo;
import utils.RandomGenerator;

public class GameLoop extends AnimationTimer{

	private GameWindow window;
	private LevelInfo level;
	private ArrayList<IDrawable> objects;
	
	private EnemyMoveComputer enemyMoveComputer;
	private SpaceShipMoveComputer spaceShipMoveComputer;
	private LaserMoveComputer laserMoveComputer;
	
	
	public GameLoop(GameWindow window) {
		this.window = window;
		this.level = new LevelInfo();
		this.objects = this.generateObjects();
		
		this.enemyMoveComputer = new EnemyMoveComputer(this.window);
		this.spaceShipMoveComputer = new SpaceShipMoveComputer(this.window);
		this.laserMoveComputer = new LaserMoveComputer();
	}
	
	@Override
	public void handle(long arg0) {
		
		this.clearSpace();
		
		this.checkColision();
		
		ArrayList<IMovable> lasers = this.getLasers();
		IMovable spaceShip = this.getSpaceShip();
		ArrayList<IMovable> enemies = this.getAllEnemies();
		
		//Create sapceShip laser
		if(this.window.isSpaceKeyPressed() && !this.existsSpaceShipLaser(lasers)) {
			this.createSpaceShipLaser(spaceShip);
		}
		
		this.generateEnemyLasers(enemies);
		
		this.enemyMoveComputer.move(enemies, this.level.getSpeed());
		this.spaceShipMoveComputer.move(spaceShip, this.window.isLeftKeyPressed(), this.window.isRightKeyPressed());
		this.laserMoveComputer.move(lasers, 3);
		this.draw();
	}
	
	private void createSpaceShipLaser(IMovable s) {
		Laser laser = new Laser("spaceShip");
		SpaceShip ship = (SpaceShip) s;
		laser.setPosition(s.getPosX() + (ship.getWidth() / 2), ship.getPosY() - laser.getHeight() - 1);
		this.objects.add(laser);
	}
	
	//Return true if laser made by spaceship is still in space
	private boolean existsSpaceShipLaser(ArrayList<IMovable> objects) {
		for(IMovable object : objects) {
			if(object instanceof Laser && ((Laser) object).getType() == "spaceShip") {
				return true;
			}
		}
		return false;
	}
	
	private void generateEnemyLasers(ArrayList<IMovable> enemies) {
		RandomGenerator randomGenerator = new RandomGenerator();
		for(IMovable enemy : enemies) {
			if(randomGenerator.getChance(this.level.getFireRate())) {
				Laser l = new Laser("enemy");
				EnemyShip ship = (EnemyShip)enemy;
				l.setPosition(ship.getPosX() + (ship.getWidth() / 2), ship.getPosY() + ship.getHeight() + 1);
				this.objects.add(l);
			}
		}
	}
	
	private void clearSpace() {
		this.window.getGraphicsContext().setFill(this.window.getDefaultBackgroudColor());
		this.window.getGraphicsContext().fillRect(0, 0, this.window.getWindowWidth(), this.window.getWindowHeight());
	}
	
	private void draw() {
		for(IDrawable object : objects) {
			object.draw(this.window.getGraphicsContext());
		}
	}
	
	private ArrayList<IDrawable> generateObjects(){

		ArrayList<IDrawable> tmp = new ArrayList<IDrawable>();
		
		double posX = 100;	//offest
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
			posX = 100;
			posY += enemy.getHeight() + gapY; 
		}
		
		SpaceShip spaceShip = new SpaceShip();
		spaceShip.setPosition(this.window.getWindowWidth() / 2 - spaceShip.getWidth() / 2, this.window.getWindowHeight() - 100);
		tmp.add(spaceShip);
		
		return tmp;
	}
	
	private void checkColision() {
		ArrayList<IDrawable> del = new ArrayList<IDrawable>();
		
		Iterator<IDrawable> objectsIterator = this.objects.iterator();
		while(objectsIterator.hasNext()) {
			IDrawable object = objectsIterator.next();
			Iterator<IDrawable> objectsIterator2 = this.objects.iterator();
			 while(objectsIterator2.hasNext()) {
				IDrawable object2 = objectsIterator2.next();
				
				if(object == object2) { continue; }
				if(object2.getPosX() <= object.getPosX() + object.getWidth() && object2.getPosX() + object2.getWidth() >= object.getPosX()) {
					if(object2.getPosY() <= object.getPosY() + object.getHeight() && object2.getPosY() + object2.getHeight() >= object.getPosY()) {
						if(object instanceof Laser && object2 instanceof EnemyShip) {
							if(((Laser)object).getType() == "enemy") {
								continue;
							}
						}
						if(object2 instanceof Laser && object instanceof EnemyShip) {
							if(((Laser)object2).getType() == "enemy") {
								continue;
							}
						}
						
						del.add(object);
						del.add(object2);
						break;
					}
				}
			 }	
		}
		this.objects.removeAll(del);
	}
	
	public ArrayList<IMovable> getAllMovableObjects(){
		ArrayList<IMovable> output = new ArrayList<IMovable>();
		for(IDrawable object : objects) {
			if(object instanceof IMovable) {
				output.add(((IMovable) object));
			}
		}
		return output;
	}
	
	public ArrayList<IMovable> getAllEnemies(){
		ArrayList<IMovable> output = new ArrayList<IMovable>();
		for(IDrawable object : objects) {
			if(object instanceof EnemyShip) {
				output.add(((IMovable) object));
			}
		}
		return output;	
	}
	
	public IMovable getSpaceShip() {
		for(IDrawable object : objects) {
			if(object instanceof SpaceShip) {
				return (IMovable)object;
			}
		}
		return null;
	}
	
	public ArrayList<IMovable> getLasers(){
		ArrayList<IMovable> lasers = new ArrayList<IMovable>();
		for(IDrawable object : this.objects) {
			if(object instanceof IMovable) {
				if(object instanceof Laser) {
					IMovable o = (IMovable) object;
					lasers.add(o);
				}
			}
		}
		return lasers;
	}

	
}
