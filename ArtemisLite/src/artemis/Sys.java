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
	
	SYSTEM1 ("desc1"), 
	SYSTEM2 ("desc2"), 
	SYSTEM3 ("desc3"), 
	SYSTEM4 ("desc4");
	
	private final String systemDesc;

	Sys(String description) {
		this.systemDesc = description;
		// TODO Auto-generated constructor stub
	}

	public String getSystemDesc() {
		return systemDesc;
	}

}
