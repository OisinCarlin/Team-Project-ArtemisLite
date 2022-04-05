/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The class contains addSquare, removeSquare, addResources, removeResources,
 * ownFullSystem and displayAll methods.
 * 
 * @author Jamie larkin, Maeve Higgins and Richard Clarke
 *
 */
public class Player implements java.io.Serializable {
	private static final long serialVersionUID = 2938313309603492644L;
	
	private static final int STARTING_RESOURCES = 5000;

	private String name;
	private Set<Element> squaresOwned;
	private int resources;
	private Square currentSquare;
	private boolean isCurrentTurn;
	private boolean hasMoved;

	/**
	 * Set the starting number of resources the player owns at the start of the
	 * game.
	 * 
	 * @param name
	 * @param squaresOwned
	 * @param resources
	 * @param currentSquare
	 */
	public Player(String name) {
		squaresOwned = new HashSet<>();
		this.name = name;
		this.resources = STARTING_RESOURCES;
	} 

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the squaresOwned
	 */
	public Set<Element> getSquaresOwned() {
		return squaresOwned;
	}

	/**
	 * @return the resources
	 */
	public int getResources() {
		return resources;
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
	 * @return the isCurrentTurn
	 */
	public boolean isCurrentTurn() {
		return isCurrentTurn;
	}

	/**
	 * @param isCurrentTurn the isCurrentTurn to set
	 */
	public void setCurrentTurn(boolean isCurrentTurn) {
		this.isCurrentTurn = isCurrentTurn;
	}
	
	/**
	 * @return the hasMoved
	 */
	public boolean hasMoved() {
		return hasMoved;
	}

	/**
	 * @param hasMoved the hasMoved to set
	 */
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	/**
	 * Add element to the squaresOwned ArrayList of the player
	 * 
	 * @param element
	 */
	public void addSquare(Element element) {
		squaresOwned.add(element);
	}

	/**
	 * Remove element from the squaresOwned ArrayList of the player
	 * 
	 * @param element
	 */
	public void removeSquare(Element element) {
		squaresOwned.remove(element);
	}

	/**
	 * Add resources from StartSquare to Player resources
	 */
	public void addResources(int resourcesToAdd) {
		resources += resourcesToAdd;
	}

	/**
	 * Remove resources from Player resources
	 */
	public void removeResources(int resourcesToRemove) {
		resources -= resourcesToRemove;
	}

	/**
	 * If player owns all required elements and are developed, player owns full
	 * system
	 * 
	 * @param elements
	 * @param developmentLevel
	 * @return
	 */
	public boolean ownsFullSystem(ElementSystem elementSystem) {
		boolean ownFullSystem = false;

		Set<Element> fullSystem = new HashSet<>(elementSystem.getElements());
		fullSystem.removeAll(squaresOwned);

		if (fullSystem.isEmpty()) {
			ownFullSystem = true;
			elementSystem.setOwner(this);
		}
		return ownFullSystem;
	}

	/**
	 * Checks if the player resources goes below 0. Returns true if -ive resources
	 * 
	 * @return boolean - true if -ive resources, +ive if >= 0
	 */
	public boolean bankruptCheck() {
		boolean bankrupt = false;

		if (this.getResources() < 0) {
			bankrupt = true;
		}
		return bankrupt;
	}

	/**
	 * Prints out the squares and resources the player owns
	 */
	public void displayAll() {
		System.out.println("Player Info");
		System.out.println("Player name :\t" + this.getName());
		System.out.println("Resources :\t" + this.getResources() + Message.resources);
		displayPropertyOwnedInfo();

	}

	/**
	 * Displays the properties owned by the player along with its price
	 */
	public void displayPropertyOwnedInfo() {
		if (this.squaresOwned.size() > 0) {
			List<Element> elementsOwned = new ArrayList<>();
			for (Element element : this.squaresOwned) {
				elementsOwned.add(element);
			}
			System.out.println("*************************");
			sortElements(elementsOwned);
			System.out.println(this.name + ": Properties Owned");
			System.out.println("-------------------------");
			for (Element element : elementsOwned) {
				System.out.println("Name: " + element.getName() + " Price: " + element.getPurchasePrice() + Message.resources);
				System.out.println("-------------------------");
			}
		}
	}

	/**
	 * Sorts an ArrayList of elements by Name
	 * 
	 * @param elements
	 */
	public void sortElements(List<Element> elements) {
		if (elements.size() > 0) {
			Collections.sort(elements, new Comparator<Element>() {
				@Override
				public int compare(final Element object1, final Element object2) {
					return object1.getElementNumber()-object2.getElementNumber();
				}
			});
		}
	}
}
