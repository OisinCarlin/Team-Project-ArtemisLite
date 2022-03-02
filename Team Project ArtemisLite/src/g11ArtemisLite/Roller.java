package g11ArtemisLite;

import java.util.List;

public class Roller {

	private List<Dice> dice;

	public Roller(List<Dice> dice) {
		this.dice = dice;
	}

	public int roll() {
		int rollTotal = 0;
		
		for (Dice die : dice) {
			rollTotal += die.roll();
		}
		return rollTotal;
	}
}
