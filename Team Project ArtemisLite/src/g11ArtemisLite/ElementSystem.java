/**
 * 
 */
package g11ArtemisLite;

import java.util.HashSet;
import java.util.Set;

/**
 * @author oisincarlin and Maeve
 *
 */
public class ElementSystem implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;
	
	// Instance Variables
	private String name;
	private Player owner;
	
	// Set to store Elements
	private Set<Element> elements;
	
	public ElementSystem(String name) {
		this.name = name;
		elements = new HashSet<>();
	}
	
	//**************************Getters and Setters******************************
	
	/**
	 * Gets the name on the ElementSystem
	 * @return the name to get
	 */
	public String getName() {
		return name;
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
	
	//**********Methods to add and remove Elements to Elements Set***************
	
	public void addElement(Element elementToAdd) {
		elements.add(elementToAdd);
	}
	
	public void removeElement(Element elementToRemove) {
		elements.remove(elementToRemove);
	}
	
	public Set<Element> getElements(){
		return elements;
	}
	
	/**
	 * Displays system name and names of elements within the system
	 */
	public void displayAll() {
		System.out.println("System Name : " + this.getName());
		for(Element element : elements) {
			System.out.println(element.getName());
		}
		System.out.println();
	}
	
}
