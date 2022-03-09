package g11ArtemisLite;

import java.util.List;

public class Roller implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;

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
