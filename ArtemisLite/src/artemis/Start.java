/**
 * 
 */
package artemis;

/**
 * @author crclarke
 *
 */
public class Start extends Square {
	
	private static final int RESOURCES_TO_ADD = 200;
	
	private int resourcesToAdd;

	/**
	 * 
	 */
	public Start() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @param resourcesToAdd
	 */
	public Start(String squareName) {
		super(squareName);
		this.resourcesToAdd = RESOURCES_TO_ADD;
	}



	/**
	 * @return the resourcesToAdd
	 */
	public int getResourcesToAdd() {
		return resourcesToAdd;
	}

	/**
	 * @param resourcesToAdd the resourcesToAdd to set
	 */
	public void setResourcesToAdd() {
		this.resourcesToAdd = RESOURCES_TO_ADD;
	}



	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		super.displayAll();
	}
	
	
	
	

}
