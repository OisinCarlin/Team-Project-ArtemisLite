/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oisin Carlin and Maeve Higgins
 *
 */
public class Board implements java.io.Serializable{
	
	private static final long serialVersionUID = 2938313309603492644L;
	
	//List to store Squares on board
	private List<Square> squares;
	
	public Board() {
		squares = new ArrayList<>();
	}
	
	public List<Square> getSquares(){
		return squares;
	}

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

	//********************** Move Player Method ***********************************
	
	/**
	 * Method to move a player along the board.
	 * 
	 * @param player - the current player whose turn it is
	 * @param squaresToMove - the roll of the dice by the player: how many squares along the board they move
	 */
	public void move(List<Player> players, Player player, int squaresToMove) {
		Square currentSquare = player.getCurrentSquare();
		int startingSquareIndex = squares.indexOf(currentSquare);
		
		for(int square = 0; square < squaresToMove; square++) {
			int nextSquareIndex = (startingSquareIndex + square) % squares.size();
			Square nextSquare = squares.get(nextSquareIndex);
			nextSquare.onPass(player);
		}
		player.getCurrentSquare().onLand(players, player);
	}
	
	public void displayElementDetails() {
		for (Square square : squares) {
			if (square instanceof Element) {
				Element element = (Element) square;
				System.out.println("***********************************");
				element.displayDetails();
			}
		}
		System.out.println("***********************************");
	}
}
