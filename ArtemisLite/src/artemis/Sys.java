/**
 * 
 */
package artemis;

/**
 * adds description for each system for future implementation
 * @author crclarke
 *
 */
public enum Sys {
	
	SYSTEM1 ("Gateway"), 
	SYSTEM2 ("Space Launch System"), 
	SYSTEM3 ("Orion Spacecraft"), 
	SYSTEM4 ("Lunar Base Camp");
	
	private final String systemDesc;

	Sys(String description) {
		this.systemDesc = description;
		// TODO Auto-generated constructor stub
	}

	public String getSystemDesc() {
		return systemDesc;
	}

}
