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

	private int resources;

	/**
	 * @param name
	 */
	public StartSquare(String name, int resources) {
		super(name);
		this.setResources(resources);
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
