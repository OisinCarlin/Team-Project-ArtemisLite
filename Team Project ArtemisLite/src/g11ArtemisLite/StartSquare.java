/**
 * 
 */
package g11ArtemisLite;

/**
 * StartSquare extends Square and has a set amount of resources that is added to
 * a player when they pass the square
 * 
 * @author Maeve
 *
 */
public class StartSquare extends Square {
	private static final long serialVersionUID = 2938313309603492644L;
	private int resources;

	/**
	 * @param name
	 */
	public StartSquare(String name, int resources) {
		super(name);
		this.resources = resources;
	}

	/**
	 * @return the resources
	 */
	public int getResources() {
		return resources;
	}

	@Override
	public void onPass(Player player) {
		super.onPass(player);
		player.addResources(getResources());
	}
}
