package utils;

import java.util.Random;

public class RandomGenerator {
	
	private Random rand;
	
	public RandomGenerator() {
		this.rand = new Random();
	}
	
	public int getRandomNumber() {
		return this.rand.nextInt();
	}
	
	public int getRandomInRange(int min, int max) {
		return this.rand.nextInt((max - min) + 1) + min;
	}
	
	public boolean getChance(int coeficient) {
		return (this.getRandomNumber() % coeficient) / 2 == 0;
	}

}
