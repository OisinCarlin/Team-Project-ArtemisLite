/**
 * 
 */
package artemis;

import java.util.Random;

/**
 * @author crclarke
 *
 */
public class Dice {

	private int numSides;

	/**
	 * @param numSides
	 */
	public Dice(int numSides) {
		this.numSides = numSides;
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
		this.numSides = numSides;
	}

	public int rollDice(int numDice) {
		Random random = new Random();
		int total = 0;
		for (int loop = 1; loop <= numDice; loop++) {
			total+=(random.nextInt(this.numSides) + 1);
		}
		return total;
	}

}
