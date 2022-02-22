package g11ArtemisLite;

/**
 * Dice class, one dice which returns a random number between 1-6
 * 
 * @author Robbie
 *
 */


import java.util.Random;

public class Dice {
	
	public static final int NUM_SIDES = 6;
	
	private int numOfSides;
	
	public Dice() {
	    numOfSides = NUM_SIDES;
	}

	public int getNumOfSides() {
		return numOfSides;
	}

	public void setNumOfSides(int numOfSides) {
		this.numOfSides = NUM_SIDES;
	}
	//generates random number+1 within specified "numOfSides" range
	public int roll() {  
	    return (int) (Math.random() * numOfSides + 1);
	}

}
