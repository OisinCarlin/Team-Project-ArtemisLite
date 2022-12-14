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
		Message.delay(500);
		player.addResources(getResources());
		System.out.println(player.getName() + " passed GO");
		System.out.println(player.getName() + " " + this.getResources() + Message.resources + " has been added to your resources");
		if(UserInput.isSpeak()) {
			new Speech(player.getName() + " passed GO " + this.getResources() + Message.resources + "has been added to your resources");
		}
	}
}
