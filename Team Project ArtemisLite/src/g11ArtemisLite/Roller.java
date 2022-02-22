package g11ArtemisLite;

/**
 * Roller class, rolls two dice
 * 
 * @author Robbie
 *
 */

import java.util.ArrayList;

public class Roller {

	Dice dice1 = new Dice();
	Dice dice2 = new Dice();

	int roll1 = dice1.roll();
	int roll2 = dice2.roll();
	int rollTotal = (roll1 + roll2);

	public void roll() {
		System.out.println("first dice rolled " + roll1);
		System.out.println("second dice rolled " + roll2);
		System.out.println("the roll total is " + rollTotal);

	}
}
