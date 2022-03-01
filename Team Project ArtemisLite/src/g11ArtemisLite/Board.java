/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;

import artemis.Start;

/**
 * @author oisincarlin
 *
 */
public class Board {
	
	//List to store Squares on board
	private ArrayList<Square> squares;
	
	
	
	
	//************* Methods to add and remove Squares to Squares List *************
	
	/**
	 * Adds a a Square to the Board
	 * @param squareToAdd - the square to add to the board
	 */
	public void addSquareToBoard(Square squareToAdd) {
		squares.add(squareToAdd);
	}
	
	/**
	 * Removes a square from the board
	 * @param squareToRemove - the square to remove from the board
	 */
	public void removeSquareFromBoard(Square squareToRemove) {
		squares.remove(squareToRemove);
	}
	
	//***************************************************************************
	
	//********************** Move Player Method ***********************************
	
	/**
	 * Method to move a player along the board.
	 * Start square at index (0) of Squares ArrayList.
	 * Player resources updated upon passing Start square.
	 * @param player - the current player whose turn it is
	 * @param roll - the roll of the dice by the player: how many squares along the board they move
	 */
	public void move(Player player, int roll) {
		Player currentPlayer = player;
		Square playerPosition = player.getCurrentSquare(); 
		int movedIndex = squares.indexOf(playerPosition) + roll;
		
		if (movedIndex >= squares.size()) {
			movedIndex = movedIndex - squares.size();
			
			StartSquare start = (StartSquare) squares.get(0);
			System.out.println(player.getPlayerName() + " passed " + start.getName() + ", collect "
					+ start.getResources());
			player.setResources(player.getResources() + start.getResources());
		}
		
		player.setCurrentSquare(squares.get(movedIndex));
		System.out.println(player.getName() + " landed on " + player.getCurrentSquare().getName());
	}
	
	//***************************************************************************
}
