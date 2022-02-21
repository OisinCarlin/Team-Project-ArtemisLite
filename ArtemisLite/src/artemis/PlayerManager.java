/**
 * 
 */
package artemis;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
	public PlayerManager(ArrayList<Square> boardLayout) {
		this.setPlayers(boardLayout);
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
	public void setPlayers(ArrayList<Square> boardLayout) {
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
						player = new Player(playerName, boardLayout);
						players.add(player);
						playerAdded = true;
					} else {
						for (int looper = 0; looper < players.size(); looper++) {
							if (!players.get(looper).getPlayerName().equalsIgnoreCase(playerName)) {
								player = new Player(playerName, boardLayout);
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
						loop = MAX_PLAYERS - 1;
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

	public void offerElementToOtherPlayers(Player player, ArrayList<Square> boardLayout) {
		String userInput = "";
		int intUserInput = 0;
		String ynInput = "";
		System.out.println("Would anyone like to buy " + player.getLocation().getSquareName());
		Map<Integer, Player> playerMap = new TreeMap<Integer, Player>();
		int counter = 1;
		for (Player p : players) {
			if (!p.equals(player)) {
				playerMap.put(counter, p);
				counter++;
			} else {
				System.out.println("Missed player check");
			}

		}
		

		do {
			for (Integer key : playerMap.keySet()) {
				System.out.println("If " + playerMap.get(key).getPlayerName() + " would like to purchase "
						+ player.getLocation().getSquareName() + ", press [" + key + "]");
			}
			System.out.println("If No-one wants to purchase press [" + (playerMap.size() + 1) + "]");
			userInput = sc.nextLine();
			intUserInput = parseWithDefault(userInput, 0);

			if (intUserInput == 0 || intUserInput > playerMap.size() + 1) {
				System.out.println("Incorrect selection");
			} else if (intUserInput == playerMap.size() + 1) {
				System.out.println("No one wants to purchase, exiting menu...");
				break;
			} else if (intUserInput > 0 && intUserInput <= playerMap.size()) {
				System.out.println(playerMap.get(intUserInput).getPlayerName() + ", would you like to purchase "
						+ player.getLocation().getSquareName() + " ? [Y/N]");
			}
		} while (intUserInput == 0 || intUserInput > playerMap.size() + 1);

		do {
			if (intUserInput == playerMap.size() + 1) {
				break;
			}
			ynInput = sc.nextLine();
			if (ynInput.equalsIgnoreCase("Y")) {
				playerMap.get(intUserInput).purchaseElement((Element) player.getLocation(),
						playerMap.get(intUserInput));

			} else if (ynInput.equalsIgnoreCase("N")) {
				System.out.println(playerMap.get(intUserInput).getPlayerName()
						+ " doesn't want to buy, so why did you say you did?!");
			} else {
				System.out.println("Incorrect input try again");
			}
		} while (!ynInput.equalsIgnoreCase("Y") && !ynInput.equalsIgnoreCase("N"));
	}

	/**
	 * Returns a default value if an integer cannot be parsed from a string
	 * 
	 * @param number
	 * @param defaultVal
	 * @return
	 */
	public static int parseWithDefault(String number, int defaultVal) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}

}
