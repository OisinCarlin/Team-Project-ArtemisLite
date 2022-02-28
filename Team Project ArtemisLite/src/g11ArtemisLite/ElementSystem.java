/**
 * 
 */
package g11ArtemisLite;

import java.util.Set;

/**
 * @author oisincarlin
 *
 */
public class ElementSystem {
	
	// Instance Variables
	private String name;
	private Player owner;
	
	// Set to store Elements
	private Set<Element> elements;
	
	//**************************Getters and Setters******************************
	
	/**
	 * Gets the name on the ElementSystem
	 * @return the name to get
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name on the ElementSystem
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the owner on the ElementSystem
	 * @return the owner to get
	 */
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * Sets the owner on the ElementSystem
	 * @param the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	//***************************************************************************
	
	//**********Methods to add and remove Elements to Elements Set***************
	
	public void addElement(Element elementToAdd) {
		elements.add(elementToAdd);
	}
	
	public void removeElement(Element elementToRemove) {
		elements.remove(elementToRemove);
	}
	
	//***************************************************************************
	

}
