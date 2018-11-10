package game;

import java.util.ArrayList;

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
		
		//Create sapceShip laser
		if(this.window.isSpaceKeyPressed() && !this.existsSpaceShipLaser(this.getLasers())) {
			this.createSpaceShipLaser(this.getSpaceShip());
		}
		
		this.generateEnemyLasers(this.getAllEnemies());
		
		this.enemyMoveComputer.move(this.getAllEnemies(), this.level.getSpeed());
		this.spaceShipMoveComputer.move(this.getSpaceShip(), this.window.isLeftKeyPressed(), this.window.isRightKeyPressed());
		this.laserMoveComputer.move(this.getLasers(), 3);
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
