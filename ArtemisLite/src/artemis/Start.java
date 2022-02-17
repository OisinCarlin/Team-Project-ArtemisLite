/**
 * 
 */
package artemis;

/**
 * @author crclarke
 *
 */
public class Start extends Square {
	
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
	public Start(String squareName, int resourcesToAdd) {
		super(squareName);
		this.resourcesToAdd = resourcesToAdd;
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
	public void setResourcesToAdd(int resourcesToAdd) {
		this.resourcesToAdd = resourcesToAdd;
	}



	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		super.displayAll();
	}
	
	
	
	

}
