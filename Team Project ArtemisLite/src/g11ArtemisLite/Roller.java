package g11ArtemisLite;

import java.util.ArrayList;

public class Roller {

	private ArrayList<Dice> dice;

	public Roller() {
		this.dice = dice;
	}

	public int Roll(ArrayList<Dice> dice) {
		int rollTotal = 0;
		for (Dice roll : dice) {
			rollTotal += roll.roll();
		}
		return rollTotal;
	}

}