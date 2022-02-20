/**
 * 
 */
package artemis;

import java.util.Random;

/**
 * 
 * @author crclarke
 *
 */
public class Dice {

	public static final int NUM_SIDES = 6;
	public static final int NUM_DICE = 2;

	private int numSides;
	private int numDice;
	private int diceRoll;

	/**
	 * @param numSides
	 */
	public Dice() {
		this.numSides = NUM_SIDES;
		this.numDice = NUM_DICE;
	}

	/**
	 * @return the numSides
	 */
	public int getNumSides() {
		return numSides;
	}

	/**
	 * @param numSides the numSides to set
	 */
	public void setNumSides(int numSides) {
		this.numSides = NUM_SIDES;
	}

	/**
	 * @return the numDice
	 */
	public int getNumDice() {
		return numDice;
	}

	/**
	 * @param numDice the numDice to set
	 */
	public void setNumDice(int numDice) {
		this.numDice = NUM_DICE;
	}

	/**
	 * @return the diceRoll
	 */
	public int getDiceRoll() {
		Random random = new Random();
		int total = 0;
		for (int loop = 1; loop <= this.numDice; loop++) {
			total += (random.nextInt(this.numSides) + 1);
		}
		this.diceRoll = total;
		return diceRoll;
	}

}
