package gameLogic;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import objects.EnemyMoveComputer;
import objects.EnemyShip;
import objects.IDrawable;
import objects.IMovable;
import objects.SpaceShip;
import objects.SpaceShipMoveComputer;
import utils.LevelInfo;

public class GameLoop extends AnimationTimer{

	private GameWindow window;
	private LevelInfo level;
	private ArrayList<IDrawable> objects;
	
	private EnemyMoveComputer enemyMoveComputer;
	private SpaceShipMoveComputer spaceShipMoveComputer;
	
	
	public GameLoop(GameWindow window) {
		this.window = window;
		this.level = new LevelInfo();
		this.objects = this.generateObjects();
		this.enemyMoveComputer = new EnemyMoveComputer(this.getAllEnemies(), this.window, this.level.getSpeed());
		this.spaceShipMoveComputer = new SpaceShipMoveComputer(this.getSpaceShip(), this.window);
	}
	
	@Override
	public void handle(long arg0) {
		
		this.clearSpace();
		this.enemyMoveComputer.move();
		this.spaceShipMoveComputer.move(this.window.isLeftKeyPressed(), this.window.isRightKeyPressed());
		this.draw();
	}
	
	
	private void clearSpace() {
		this.window.getGraphicsContext().fillRect(0, 0, this.window.getWindowWidth(), this.window.getWindowHeight());
	}
	
	private void draw() {
		for(IDrawable object : objects) {
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
	
}
