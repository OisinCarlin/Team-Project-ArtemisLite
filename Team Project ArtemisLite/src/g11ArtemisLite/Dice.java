package g11ArtemisLite;

import java.util.Random;

public class Dice {

	private int numOfSides;
		
	/**
	 * @param numOfSides
	 */
	public Dice(int numOfSides) {
		this.numOfSides = numOfSides;
	}
	
	public int getNumOfSides() {
		return numOfSides;
	}

	public void setNumOfSides(int numOfSides) {
		this.numOfSides = numOfSides;
	}

	// generates random number+1 within specified "numOfSides" range

	public int roll() {
		Random ran = new Random();
		return ran.nextInt(numOfSides)+1;
	}

}
