package g11ArtemisLite;

/**
 * Dice class, one dice which returns a random number between 1-6
 * 
 * @author Robbie
 *
 */


import java.util.Random;

public class Dice {
	
	private int numOfSides;

	/**
	 * @param numOfSides
	 */
	public Dice(int numOfSides) {
		this.numOfSides = numOfSides;
	}

	public int roll() {
		return (int) (Math.random() * numOfSides + 1);
	}

}

