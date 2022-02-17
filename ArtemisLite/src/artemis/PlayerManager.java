/**
 * 
 */
package artemis;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author crclarke
 *
 */
public class PlayerManager {

	private static final Scanner sc = new Scanner(System.in);
	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 4;

	private ArrayList<Player> players;

	/**
	 * 
	 */
	public PlayerManager() {
		this.setPlayers();
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		Player player;
		String playerName = "";
		boolean playerAdded = false;
		String anotherPlayer = "";

		for (int loop = 1; loop <= MAX_PLAYERS; loop++) {

			while (!playerAdded) {
				System.out.println("Enter player " + loop + " name and press [Enter]");
				playerName = sc.nextLine();
				if (playerName.length() >= 1) {
					if (players.isEmpty()) {
						player = new Player(playerName, null);
						players.add(player);
						playerAdded = true;
					} else {
						for (int looper = 0; looper < players.size(); looper++) {
							if (!players.get(looper).getPlayerName().equalsIgnoreCase(playerName)) {
								player = new Player(playerName, null);
								players.add(player);
								playerAdded = true;
								break;
							}
							if (!playerAdded) {
								System.out.println("That name already exists, try again...");
							}
						}
					}
				} else {
					System.out.println("Cannot have a blank name, try again...");
				}
			}
			playerAdded = false;
			if (loop >= MIN_PLAYERS && loop < MAX_PLAYERS) {
				do {
					System.out.println("Would you like to add another player? [Y/N]");
					anotherPlayer = sc.nextLine();
					if (anotherPlayer.equalsIgnoreCase("N")) {
						loop=MAX_PLAYERS-1;
						playerAdded = true;
						break;
					} else if (anotherPlayer.equalsIgnoreCase("Y")) {
						break;
					} else {
						System.out.println("Incorrect input please try again...");
					}
				} while (!anotherPlayer.equalsIgnoreCase("Y") || !anotherPlayer.equalsIgnoreCase("N"));
			}
		}

		this.players = players;
	}

}
