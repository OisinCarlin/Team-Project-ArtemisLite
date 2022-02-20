/**
 * 
 */
package artemis;

/**
 * @author crclarke
 *
 */
public class DevelopmentInfo {
	
	public static final int DEVELOPMENT_PRICE = 100;
	public static final double NO_DEV_MULTIPLIER = 1;
	public static final double MINOR1_DEV_MULTIPLIER = 1.2;
	public static final double MINOR2_DEV_MULTIPLIER = 1.5;
	public static final double MINOR3_DEV_MULTIPLIER = 1.8;
	public static final double MAJOR_DEV_MULTIPLIER = 2.5;

	private DevelopmentLevel level;
	private String developmentLevelName;
	private String developmentLevelDesc;
	private double rentMultiplier;
	private int developmentPrice;

	/**
	 * 
	 */
	public DevelopmentInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param level
	 * @param rentMultiplier
	 */
	public DevelopmentInfo(DevelopmentLevel level, String developmentLevelName, String developmentLevelDesc) {
		
		this.level = level;
		this.developmentLevelName = developmentLevelName;
		this.developmentLevelDesc = developmentLevelDesc;
		this.setRentMultiplier();
		this.setDevelopmentPrice();
	}

	/**
	 * @return the levelNum
	 */
	public DevelopmentLevel getLevel() {
		return level;
	}

	/**
	 * @param levelNum the levelNum to set
	 */
	public void setLevel(DevelopmentLevel level) {
		this.level = level;
	}

	/**
	 * @return the developmentLevelName
	 */
	public String getDevelopmentLevelName() {
		return developmentLevelName;
	}

	/**
	 * @param developmentLevelName the developmentLevelName to set
	 */
	public void setDevelopmentLevelName(String developmentLevelName) {
		this.developmentLevelName = developmentLevelName;
	}

	/**
	 * @return the developmentLevelDesc
	 */
	public String getDevelopmentLevelDesc() {
		return developmentLevelDesc;
	}

	/**
	 * @param developmentLevelDesc the developmentLevelDesc to set
	 */
	public void setDevelopmentLevelDesc(String developmentLevelDesc) {
		this.developmentLevelDesc = developmentLevelDesc;
	}

	/**
	 * @return the rentMultiplier
	 */
	public double getRentMultiplier() {
		return rentMultiplier;
	}

	/**
	 * sets the rent multiplier based on the DevelopmentLevel enum
	 * @param rentMultiplier the rentMultiplier to set
	 */
	public void setRentMultiplier() {
		if (this.level == DevelopmentLevel.NONE) {
			this.rentMultiplier = NO_DEV_MULTIPLIER;
		} else if (this.level == DevelopmentLevel.MINOR1) {
			this.rentMultiplier = MINOR1_DEV_MULTIPLIER;
		} else if (this.level == DevelopmentLevel.MINOR2) {
			this.rentMultiplier = MINOR2_DEV_MULTIPLIER;
		} else if (this.level == DevelopmentLevel.MINOR3) {
			this.rentMultiplier = MINOR3_DEV_MULTIPLIER;
		} else if (this.level == DevelopmentLevel.MAJOR) {
			this.rentMultiplier = MAJOR_DEV_MULTIPLIER;
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getDevelopmentPrice() {
		return developmentPrice;
	}

	/**
	 * sets the price to develop the element based on constant DEVELOPMENT_PRICE
	 */
	public void setDevelopmentPrice() {
		this.developmentPrice = DEVELOPMENT_PRICE;
	}
	
	

}
