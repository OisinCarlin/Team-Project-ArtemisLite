/**
 * 
 */
package artemis;

/**
 * @author crclarke
 *
 */
public class Element extends Square {

	private Sys systemName;
	private int purchasePrice;
	private int basicRentPrice;
	private Player owner;
	private DevelopmentLevel currentLevel;
	private DevelopmentInfo none;
	private DevelopmentInfo minor1;
	private DevelopmentInfo minor2;
	private DevelopmentInfo minor3;
	private DevelopmentInfo major;

	public Element() {

	}

	/**
	 * @param systemName
	 * @param purchasePrice
	 * @param owner
	 * @param none
	 * @param minor1
	 * @param minor2
	 * @param minor3
	 * @param major
	 */
	public Element(String squareName, Sys systemName, int purchasePrice, int basicRentprice, DevelopmentInfo none, DevelopmentInfo minor1,
			DevelopmentInfo minor2, DevelopmentInfo minor3, DevelopmentInfo major) {
		super(squareName);
		this.systemName = systemName;
		this.purchasePrice = purchasePrice;
		this.basicRentPrice = basicRentprice;
		this.owner = null;
		// initialises development level at 0 - none
		this.currentLevel = DevelopmentLevel.NONE;
		this.none = none;
		this.minor1 = minor1;
		this.minor2 = minor2;
		this.minor3 = minor3;
		this.major = major;
	}

	/**
	 * @return the systemName
	 */
	public Sys getSystemName() {
		return systemName;
	}

	/**
	 * @param systemName the systemName to set
	 */
	public void setSystemName(Sys systemName) {
		this.systemName = systemName;
	}

	/**
	 * @return the purchasePrice
	 */
	public int getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	
	

	/**
	 * @return the basicRentPrice
	 */
	public int getBasicRentPrice() {
		return basicRentPrice;
	}

	/**
	 * @param basicRentPrice the basicRentPrice to set
	 */
	public void setBasicRentPrice(int basicRentPrice) {
		this.basicRentPrice = basicRentPrice;
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
	 * @return the currentLevel
	 */
	public DevelopmentLevel getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * @param currentLevel the currentLevel to set
	 */
	public void setCurrentLevel(DevelopmentLevel currentLevel) {
		this.currentLevel = currentLevel;
	}

	/**
	 * @return the none
	 */
	public DevelopmentInfo getNone() {
		return none;
	}

	/**
	 * @param none the none to set
	 */
	public void setNone(DevelopmentInfo none) {
		this.none = none;
	}

	/**
	 * @return the minor1
	 */
	public DevelopmentInfo getMinor1() {
		return minor1;
	}

	/**
	 * @param minor1 the minor1 to set
	 */
	public void setMinor1(DevelopmentInfo minor1) {
		this.minor1 = minor1;
	}

	/**
	 * @return the minor2
	 */
	public DevelopmentInfo getMinor2() {
		return minor2;
	}

	/**
	 * @param minor2 the minor2 to set
	 */
	public void setMinor2(DevelopmentInfo minor2) {
		this.minor2 = minor2;
	}

	/**
	 * @return the minor3
	 */
	public DevelopmentInfo getMinor3() {
		return minor3;
	}

	/**
	 * @param minor3 the minor3 to set
	 */
	public void setMinor3(DevelopmentInfo minor3) {
		this.minor3 = minor3;
	}

	/**
	 * @return the major
	 */
	public DevelopmentInfo getMajor() {
		return major;
	}

	/**
	 * @param major the major to set
	 */
	public void setMajor(DevelopmentInfo major) {
		this.major = major;
	}

	/**
	 * increases the development level of an element - to be used in the process of developElement
	 * in the Player class
	 */
	public void increaseDevelopmentLevel() {
		switch (this.currentLevel.getLevelNum()) {
		case 0:
			this.currentLevel = DevelopmentLevel.MINOR1;
			break;
		case 1:
			this.currentLevel = DevelopmentLevel.MINOR2;
			break;
		case 2:
			this.currentLevel = DevelopmentLevel.MINOR3;
			break;
		case 3:
			this.currentLevel = DevelopmentLevel.MAJOR;
			break;
		case 4:
			System.out.println("Max development level reached");
			break;
		}

	}
	
	/**
	 * gets the development price for an element by comparing the current development level enum
	 * against the stored developmentInfo development prices, using a switch to match against the 
	 * correct development level
	 * @return
	 */
	public int getCurrentPriceToDevelop() {
		int currentLevelPriceToDevelop = 0;
		switch (this.currentLevel.getLevelNum()) {
		case 0:
			currentLevelPriceToDevelop = this.none.getDevelopmentPrice();
			break;
		case 1:
			currentLevelPriceToDevelop = this.minor1.getDevelopmentPrice();
			break;
		case 2:
			currentLevelPriceToDevelop = this.minor2.getDevelopmentPrice();
			break;
		case 3:
			currentLevelPriceToDevelop = this.minor3.getDevelopmentPrice();
			break;
		case 4:
			System.out.println("Cannot develop further");
		}
		return currentLevelPriceToDevelop;
	}
	
	/**
	 * gets the rent price for an element by comparing the current development level enum
	 * against the stored developmentInfo rental prices, using a switch to match against the 
	 * correct development level
	 * @return
	 */
	public int getTotalRentPrice() {
		int rentPrice = 0;
		switch (this.currentLevel.getLevelNum()) {
		case 0:
			rentPrice = (int) this.none.getRentMultiplier()*this.getBasicRentPrice();
			break;
		case 1:
			rentPrice = (int) this.minor1.getRentMultiplier()*this.getBasicRentPrice();
			break;
		case 2:
			rentPrice = (int) this.minor2.getRentMultiplier()*this.getBasicRentPrice();
			break;
		case 3:
			rentPrice = (int) this.minor3.getRentMultiplier()*this.getBasicRentPrice();
			break;
		case 4:
			rentPrice = (int) (this.major.getRentMultiplier()*this.getBasicRentPrice());
			break;
		}
		return rentPrice;
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		System.out.println("*************************");
		super.displayAll();
		System.out.println("Purchase price:\t\t"+this.purchasePrice);
		if (this.owner==null) {
			System.out.println("Owner:\t\t\tUnowned");
		} else {
			System.out.println("Owner:\t\t\t"+this.owner.getPlayerName());
		}
		System.out.println("Development Level:\t"+this.currentLevel);
		System.out.println("Price to develop:\t"+this.getCurrentPriceToDevelop());
	}
	
	public void displayDevelopmentInfo() {
		System.out.println(this.getSquareName());
		System.out.println("Development Level:\t"+this.currentLevel);
		System.out.println("Price to develop:\t"+this.getCurrentPriceToDevelop());
	}
	
	public void displayDevelopmentUpgradeInfo() {
		switch (this.currentLevel.getLevelNum()) {
		case 0:
			System.out.println(this.none.getDevelopmentLevelName());
			System.out.println(this.none.getDevelopmentLevelDesc());
			break;
		case 1:
			System.out.println(this.minor1.getDevelopmentLevelName());
			System.out.println(this.minor1.getDevelopmentLevelDesc());
			break;
		case 2:
			System.out.println(this.minor2.getDevelopmentLevelName());
			System.out.println(this.minor2.getDevelopmentLevelDesc());
			break;
		case 3:
			System.out.println(this.minor3.getDevelopmentLevelName());
			System.out.println(this.minor3.getDevelopmentLevelDesc());
			break;
		case 4:
			System.out.println(this.major.getDevelopmentLevelName());
			System.out.println(this.major.getDevelopmentLevelDesc());
			break;
		}
	}
	
	

}
