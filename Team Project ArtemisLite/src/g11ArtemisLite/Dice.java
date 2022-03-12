package g11ArtemisLite;

import java.util.Random;

/**
 * Dice class, one dice which returns a random number between 1-6
 * 
 * @author Robbie
 *
 */
public class Dice implements java.io.Serializable {
	private static final Random RANDOM = new Random();
	private static final long serialVersionUID = 2938313309603492644L;
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

	public int roll() {
		return RANDOM.nextInt(numOfSides) + 1;
	}
}

