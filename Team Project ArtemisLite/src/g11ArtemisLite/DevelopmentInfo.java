/**
 * 
 */
package g11ArtemisLite;



/**
 * @author crclarke
 *
 */
public class DevelopmentInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;

	private String developmentLevel1Name;
	private String developmentLevel1Desc;
	private String developmentLevel2Name;
	private String developmentLevel2Desc;
	private String developmentLevel3Name;
	private String developmentLevel3Desc;
	private String developmentLevel4Name;
	private String developmentLevel4Desc;

	/**
	 * Constructor with args. Sets all strings
	 * @param developmentLevel1Name
	 * @param developmentLevel1Desc
	 * @param developmentLevel2Name
	 * @param developmentLevel2Desc
	 * @param developmentLevel3Name
	 * @param developmentLevel3Desc
	 * @param developmentLevel4Name
	 * @param developmentLevel4Desc
	 */
	public DevelopmentInfo(String developmentLevel1Name, String developmentLevel1Desc,
			String developmentLevel2Name, String developmentLevel2Desc, String developmentLevel3Name,
			String developmentLevel3Desc, String developmentLevel4Name, String developmentLevel4Desc) {
		
		this.developmentLevel1Name = developmentLevel1Name;
		this.developmentLevel1Desc = developmentLevel1Desc;
		this.developmentLevel2Name = developmentLevel2Name;
		this.developmentLevel2Desc = developmentLevel2Desc;
		this.developmentLevel3Name = developmentLevel3Name;
		this.developmentLevel3Desc = developmentLevel3Desc;
		this.developmentLevel4Name = developmentLevel4Name;
		this.developmentLevel4Desc = developmentLevel4Desc;
	}

	/**
	 * @return the developmentLevel1Name
	 */
	public String getDevelopmentLevel1Name() {
		return developmentLevel1Name;
	}

	/**
	 * @return the developmentLevel1Desc
	 */
	public String getDevelopmentLevel1Desc() {
		return developmentLevel1Desc;
	}

	/**
	 * @return the developmentLevel2Name
	 */
	public String getDevelopmentLevel2Name() {
		return developmentLevel2Name;
	}

	/**
	 * @return the developmentLevel2Desc
	 */
	public String getDevelopmentLevel2Desc() {
		return developmentLevel2Desc;
	}

	/**
	 * @return the developmentLevel3Name
	 */
	public String getDevelopmentLevel3Name() {
		return developmentLevel3Name;
	}

	/**
	 * @return the developmentLevel3Desc
	 */
	public String getDevelopmentLevel3Desc() {
		return developmentLevel3Desc;
	}

	/**
	 * @return the developmentLevel4Name
	 */
	public String getDevelopmentLevel4Name() {
		return developmentLevel4Name;
	}

	/**
	 * @return the developmentLevel4Desc
	 */
	public String getDevelopmentLevel4Desc() {
		return developmentLevel4Desc;
	}
	
	/**
	 * Takes input int dev level and displays appropriate info dependant on level
	 * @param devLevel
	 */
	public void displayCurrentDevInfo(int devLevel) {
		switch (devLevel) {
		case 1:
			System.out.println("Dev level: "+this.developmentLevel1Name);
			System.out.println("Description: "+this.developmentLevel1Desc);
			if(UserInput.isSpeak()) {
				new Speech("Development level " + this.developmentLevel1Name + this.developmentLevel1Desc);
			}
			break;
		case 2:
			System.out.println("Dev level: "+this.developmentLevel2Name);
			System.out.println("Description: "+this.developmentLevel2Desc);
			if(UserInput.isSpeak()) {
				new Speech("Development level " + this.developmentLevel2Name + this.developmentLevel2Desc);
			}
			break;
		case 3:
			System.out.println("Dev level: "+this.developmentLevel3Name);
			System.out.println("Description: "+this.developmentLevel3Desc);
			if(UserInput.isSpeak()) {
				new Speech("Development level " + this.developmentLevel3Name + this.developmentLevel3Desc);
			}
			break;
		case 4:
			System.out.println("Dev level: "+this.developmentLevel4Name);
			System.out.println("Description: "+this.developmentLevel4Desc);
			if(UserInput.isSpeak()) {
				new Speech("Development level " + this.developmentLevel4Name + this.developmentLevel4Desc);
			}
			break;
		default:
			System.out.println("incorrect selection");
		}
	}
	
}
