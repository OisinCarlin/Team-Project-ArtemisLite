/**
 * 
 */
package g11ArtemisLite;

import java.util.List;
import java.util.Map;

/**
 * Element extends Square and has prices for purchase, rent and development and
 * a development level and an owner. The override method for onLand incorporates
 * private methods for purchasing an element and enforcing rent. Methods for
 * developing and trading elements are NOT a part of this class.
 * 
 * @author Maeve Higgins
 *
 */
public class Element extends Square {

	private int purchasePrice;
	private int rentPrice;
	private int developmentPrice;
	private int devLevel;
	private Player owner;
	private PlayerManager playerManager;

	/**
	 * Allows name, purchasePrice, rentPrice and developmentPrice to be set.
	 * Development level is set to 0 and new userInput and playerManager instances
	 * created.
	 * 
	 * @param name
	 */
	public Element(String name, int purchasePrice, int rentPrice, int developmentPrice) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.rentPrice = rentPrice;
		this.developmentPrice = developmentPrice;
		this.devLevel = 0;
		this.playerManager = new PlayerManager();
	}

	/**
	 * @return the purchasePrice
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @return the rentPrice
	 */
	public int getRentPrice() {
		return rentPrice;
	}

	/**
	 * @param rentPrice the rentPrice to set
	 */
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	/**
	 * @return the developmentPrice
	 */
	public int getDevelopmentPrice() {
		return developmentPrice;
	}

	/**
	 * @return the devLevel
	 */
	public int getDevLevel() {
		return devLevel;
	}

	/**
	 * Increments the development level by 1 and calls adjustRent()
	 * 
	 * @param startingDevLevel the devLevel to set
	 */
	public void increaseDevLevel() {
		this.devLevel++;
		adjustRent();
	}

	/**
	 * If the development level is > 0 the rent price is multiplied by the
	 * development level
	 */
	private void adjustRent() {
		if (devLevel > 0) {
			setRentPrice(getRentPrice() * getDevLevel());
		}
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * If this element has no owner attempPurchaseElement is called. If they already
	 * own it they are told this. If it is owned by another player requestRent is
	 * called.
	 * 
	 * @param players - the list of players in the game - enables offering purchase
	 *                to other players
	 * @param player  - the current player
	 */
	@Override
	public void onLand(List<Player> players, Player player) {
		super.onLand(players, player);

		if (this.owner == null) {
			attemptPurchaseElement(players, player);
		} else if (this.owner.equals(player)) {
			System.out.println("You own this element");
		} else {
			requestRent(player);
		}
	}

	/**
	 * Asks the current player if the want to purchase this element. If yes and they
	 * have enough resources - current player is set to owner of this element. This
	 * element is added to the players squaresOwned and the purchase price is
	 * removed from players resources. If no the player is given the option to offer
	 * it to another player, if yes offerAltPlayerPurchase() is called
	 * 
	 * @param players - the list of players in the game - enables offering to other
	 *                players
	 * @param player  - the current player
	 */
	private void attemptPurchaseElement(List<Player> players, Player player) {
		System.out.printf("\n%s Do you want to purchase %s\n", player.getName(), this.getName());
		boolean attemptPurchase = UserInput.yesOrNo();
		boolean altPlayerPurchase;

		if (attemptPurchase) {
			// Checks player has enough resources
			if (player.getResources() >= purchasePrice) {
				this.setOwner(player);
				player.removeResources(getPurchasePrice());
				player.addSquare(this);
				System.out.printf("Congratulations! You now own %s\n", this.getName());
			} else {
				System.err.println("Sorry not enough resources to purchase.\n");
			}
		} else {
			System.err.println("Sorry you don't want to purchase :(\n");
			System.out.printf("Do you want to offer %s to another player?\n", this.getName());
			altPlayerPurchase = UserInput.yesOrNo();
			if (altPlayerPurchase) {
				offerAltPlayerPurchase(players, player);
			} else {
				System.err.println("Sorry you don't want to share the purchase :(\n");
			}

		}
	}

	/**
	 * Calls mapPlayer() and choosePlayer() for the player to select the player the
	 * want to offer the purchase to. If the player is not null
	 * attemptPurchaseElement() is called. Else a cancelled message is displayed
	 * 
	 * @param players - the list of players in the game - enables offering to other
	 *                players
	 * @param player  - the current player
	 */
	private void offerAltPlayerPurchase(List<Player> players, Player player) {
		Map<Integer, Player> playerMap = playerManager.mapPlayers(players, player);
		Player chosenPlayer = playerManager.choosePlayer(playerMap);
		if (chosenPlayer != null) {
			attemptPurchaseElement(players, chosenPlayer);
		} else {
			System.err.println("Cancelled");
		}
	}

	/**
	 * Asks the owner of the square if they want to charge the current player rent.
	 * If yes - rent is removed from current player and added to the owner
	 * 
	 * @param player
	 */
	private void requestRent(Player player) {
		System.out.println("\n" + this.owner.getName() + " Do you want to charge " + player.getName() + " rent?\n");
		boolean enforceRent = UserInput.yesOrNo();

		if (enforceRent) {
			player.removeResources(rentPrice);
			owner.addResources(rentPrice);
			System.err.println(player.getName() + " you have been charged " + this.rentPrice + " in rent");
		}
	}

	public void displayDetails() {
		System.out.println(this.getName());
		if (this.owner != null) {
			System.out.println("Owner: " + this.owner.getName());
		} else {
			System.out.println("Owner: Unowned");
		}

		System.out.println("Dev level: " + this.devLevel);
	}

}
