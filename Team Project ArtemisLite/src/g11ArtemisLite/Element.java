/**
 * 
 */
package g11ArtemisLite;

/**
 * Element extends Square and has prices for purchase, rent and development and
 * a development level and an owner. The override method for onLand incorporates
 * private methods for purchasing an element and enforcing rent. Methods for
 * developing and trading elements are NOT a part of this class.
 * 
 * @author Maeve
 *
 */
public class Element extends Square {

	private int purchasePrice;
	private int rentPrice;
	private int developmentPrice;
	private int devLevel;
	private Player owner;
	private UserInput userInput;

	/**
	 * Allows name, purchasePrice, rentPrice and developmentPrice to be set.
	 * Development level is set to 0 and a new userInput instance created.
	 * 
	 * @param name
	 */
	public Element(String name, int purchasePrice, int rentPrice, int developmentPrice) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.rentPrice = rentPrice;
		this.developmentPrice = developmentPrice;
		this.devLevel = 0;
		this.userInput = new UserInput();
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
	 * @param developmentPrice the developmentPrice to set
	 */
	public void setDevelopmentPrice(int developmentPrice) {
		this.developmentPrice = developmentPrice;
	}

	/**
	 * @return the devLevel
	 */
	public int getDevLevel() {
		return devLevel;
	}

	/**
	 * @param devLevel the devLevel to set
	 */
	public void increaseDevLevel() {
		this.devLevel++;
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
	 * @param player
	 */
	@Override
	public void onLand(Player player) {
		super.onLand(player);

		if (this.owner == null) {
			attemptPurchaseElement(player);
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
	 * removed from players resources
	 * 
	 * @param player
	 */
	private void attemptPurchaseElement(Player player) {
		System.out.println("\nDo you want to purchase " + this.getName());
		boolean attemptPurchase = userInput.yesOrNo();

		if (attemptPurchase) {
			if (player.getResources() >= purchasePrice) {
				this.setOwner(player);
				player.removeResources(getPurchasePrice());
				player.addSquare(this);
				System.out.println("Congratulations! You now own " + this.getName());
			} else {
				System.err.println("Sorry not enough resources to purchase.");
			}
		} else {
			System.err.println("Sorry you don't want to purchase :(");
		}
	}

	/**
	 * Asks the owner of the square if they want to charge the current player rent.
	 * If yes - rent is removed from current player and added to the owner
	 * 
	 * @param player
	 */
	private void requestRent(Player player) {
		System.out.println("\n" + this.owner.getName() + " Do you want to charge " + player.getName() + " rent?");
		boolean enforceRent = userInput.yesOrNo();

		if (enforceRent) {
			player.removeResources(rentPrice);
			owner.addResources(rentPrice);
			System.err.println(player.getName() + " you have been charged " + this.rentPrice + " in rent");
		}
	}

}
