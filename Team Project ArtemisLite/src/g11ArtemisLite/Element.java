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
	private static final long serialVersionUID = 2938313309603492644L;
	private int elementNumber;
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
	public Element(String name, int elementNumber, int purchasePrice, int rentPrice, int developmentPrice) {
		super(name);
		this.elementNumber = elementNumber;
		this.purchasePrice = purchasePrice;
		this.rentPrice = rentPrice;
		this.developmentPrice = developmentPrice;
		this.devLevel = 0;
		this.playerManager = new PlayerManager();
	}
	
	/**
	 * @return the elementNumber
	 */
	public int getElementNumber() {
		return elementNumber;
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
			System.out.println(Message.ownElement);
			if(UserInput.isSpeak()) {
				new Speech(Message.ownElement);
			}
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
		System.out.println("\n" + player.getName() + Message.offerPurchase + this.getName() + "\n");
		if(UserInput.isSpeak()) {
			new Speech(player.getName() + Message.offerPurchase + this.getName());
		}
		boolean attemptPurchase = UserInput.yesOrNo();
		boolean altPlayerPurchase;

		if (attemptPurchase) {
			// Checks player has enough resources
			if (player.getResources() >= purchasePrice) {
				this.setOwner(player);
				player.removeResources(getPurchasePrice());
				player.addSquare(this);
				System.out.printf("%s%s\n", Message.congratsPurchase,this.getName());
				if(UserInput.isSpeak()) {
					new Speech(Message.congratsPurchase + this.getName());
				}
			} else {
				System.out.println(Message.notEnoughRes);
				if(UserInput.isSpeak()) {
					new Speech(Message.notEnoughRes);
				}
			}
		} else {
			System.out.println(Message.declinePurchase);
			System.out.println(Message.offer + this.getName() + Message.otherPlayer);
			if(UserInput.isSpeak()) {
				new Speech(Message.declinePurchase 
						+ Message.offer + this.getName() + Message.otherPlayer);
			}
			altPlayerPurchase = UserInput.yesOrNo();
			if (altPlayerPurchase) {
				offerAltPlayerPurchase(players, player);
			} else {
				System.out.println(Message.declinePurchase);
				if(UserInput.isSpeak()) {
					new Speech(Message.declinePurchase);
				}
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
			System.out.println("Cancelled");
			if(UserInput.isSpeak()) {
				new Speech("Cancelled");
			}
		}
	}

	/**
	 * Asks the owner of the square if they want to charge the current player rent.
	 * If yes - rent is removed from current player and added to the owner
	 * 
	 * @param player
	 */
	private void requestRent(Player player) {
		System.out.println("\n" + this.owner.getName() + Message.charge + player.getName() + Message.rent);
		if(UserInput.isSpeak()) {
			new Speech(this.owner.getName() + Message.charge + player.getName() + Message.rent);
		}
		boolean enforceRent = UserInput.yesOrNo();

		if (enforceRent) {
			player.removeResources(rentPrice);
			owner.addResources(rentPrice);
			System.out.println(player.getName() + Message.charged + this.rentPrice + " in rent");
			if(UserInput.isSpeak()) {
				new Speech(player.getName() + Message.charged + this.rentPrice + " in rent");
			}
		}
	}

	public void displayDetails() {
		System.out.println(this.getName());
		if(UserInput.isSpeak()) {
			new Speech(this.getName());
		}
		if (this.owner != null) {
			System.out.println("Owner: " + this.owner.getName());
			if(UserInput.isSpeak()) {
				new Speech("Owner is " + this.owner.getName());
			}
		} else {
			System.out.println("Owner: Unowned");
			if(UserInput.isSpeak()) {
				new Speech("Unowned");
			}
		}
		System.out.println("Dev level: " + this.devLevel);
		if(UserInput.isSpeak()) {
			new Speech("Development level is" + this.devLevel);
		}
	}

}
