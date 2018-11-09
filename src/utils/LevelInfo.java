package utils;

public class LevelInfo {
	public enum status{
		WON, LOST, PAUSE
	}
	
	private int fireRate;
	private double speed;
	private int enemyCount;
	private int countInLine;
	
	public LevelInfo() {
		this.fireRate = 100;
		this.speed = 2;
		this.enemyCount = 12;
		this.countInLine = 6;
	}

	public int getFireRate() {
		return fireRate;
	}

	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getEnemyCount() {
		return enemyCount;
	}

	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}
	
	public void addEnemyCount() {
		if(this.enemyCount < 30){
			this.enemyCount += 6;
		}
	}

	public int getCountInLine() {
		return countInLine;
	}

	
	
	
	
}
