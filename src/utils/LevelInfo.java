package utils;

public class LevelInfo {
	
	private int fireRate;
	private double speed;
	private int enemyCount;
	private int countInLine;
	
	public LevelInfo() {
		this.fireRate = 2000;
		this.speed = 2;
		this.enemyCount = 12;
		this.countInLine = 6;
	}

	public int getFireRate() {
		return fireRate;
	}

	public void setFireRate(int fireRate) {
		if(this.fireRate > 1000) {
			this.fireRate = fireRate;
		}
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		if(this.speed < 5) {
			this.speed = speed;
		}
	}

	public int getEnemyCount() {
		return enemyCount;
	}
	
	public void addEnemyCount() {
		if(this.enemyCount < 30){
			this.enemyCount += 6;
		}
	}

	public int getCountInLine() {
		return countInLine;
	}

	public void levelUP() {
		this.addEnemyCount();
		this.setSpeed(this.getSpeed() + 0.5);
		this.setFireRate(this.getFireRate() - 100);
	}
	
	
	
}
