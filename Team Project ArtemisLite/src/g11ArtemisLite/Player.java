/**
 * 
 */
package g11ArtemisLite;

import java.util.Set;

/**
 * The class contains addSquare, removeSquare, addResources, removeResources, ownFullSystem and displayAll methods.
 * @author jamielarkin
 *
 */
public class Player {
	
	private String name;
	private Set<Element> squaresOwned;
	private int resources;
	private Square currentSquare;

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Set the starting number of resources the player owns at the start of the game.
	 * @param name
	 * @param squaresOwned
	 * @param resources
	 * @param currentSquare
	 */
	public Player(String name, Set<Element> squaresOwned, int resources, Square currentSquare) {
		super();
		this.name = name;
		this.squaresOwned = squaresOwned;
		this.resources = 1;
		this.currentSquare = currentSquare;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the squaresOwned
	 */
	public Set<Element> getSquaresOwned() {
		return squaresOwned;
	}

	/**
	 * @param squaresOwned the squaresOwned to set
	 */
	public void setSquaresOwned(Set<Element> squaresOwned) {
		this.squaresOwned = squaresOwned;
	}

	/**
	 * @return the resources
	 */
	public int getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(int resources) {
		this.resources = resources;
	}

	/**
	 * @return the currentSquare
	 */
	public Square getCurrentSquare() {
		return currentSquare;
	}

	/**
	 * @param currentSquare the currentSquare to set
	 */
	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}
	
	
	
	/**
	 * Add element to the squaresOwned ArrayList of the player 
	 * @param element
	 */
	public void addSquare(Element element) {
		squaresOwned.add(element);
	}
	
	/**
	 * Remove element from the squaresOwned ArrayList of the player 
	 * @param element
	 */
	public void removeSquare(Element element) {
		squaresOwned.remove(element);
	}
	
	/**
	 * Add resources from StartSquare to Player resources
	 */
	public void addResources() {
		resources += resources;
	}
	
	/**
	 * Remove resources from Player resources
	 */
	public void removeResources() {
		resources -= resources;
	}
	
	/**
	 * If player owns all required elements and are developed, player owns full system
	 * @param elements
	 * @param developmentLevel
	 * @return
	 */
	public boolean ownFullSystem(ElementSystem elements, Element developmentLevel) {
		
		if (elements == squaresOwned) {
			if (squaresOwned == developmentLevel) {
				return true;
				
			} else {
				return false;
				
			}	
	}
		return false;
}
	/**
	 * Prints out the squares and resources the player owns
	 */
	public void displayAll() {
		System.out.println(name+" owns "+squaresOwned+".");
		System.out.println(name+" has "+resources+" resources.");
	}

}
