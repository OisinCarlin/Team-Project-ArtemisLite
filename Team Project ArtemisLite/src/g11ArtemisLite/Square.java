/**
 * 
 */
package g11ArtemisLite;

/**
 * Square is one part of a board. Each Square has a name and sets the players
 * location as they pass or land on it.
 * 
 * @author maeve
 *
 */
public class Square {

	private String name;

	/**
	 * 
	 */
	public Square(String name) {
		this.name = name;
	}

	/**
	 * Sets the players location to this square and outputs the name of the square
	 * they land on
	 * 
	 * @param player
	 */
	public void onLand(Player player) {
		player.setCurrentSquare(this);
		System.out.println(player.getName() + " has landed on " + this.name);
	}

	/**
	 * Sets the players location to this square as they pass it. Updated with each
	 * square passed until player lands on a square.
	 * 
	 * @param player
	 */
	public void onPass(Player player) {
		player.setCurrentSquare(this);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}