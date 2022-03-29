/**
 * 
 */
package g11ArtemisLite;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author oisincarlin
 *
 */
class BoardTest {

	//=============================================
	// Test Data
	//=============================================

	// Board class data
	Board board;
	List<Square> squares;

	// Declare player, square and element objects
	Player player1, player2, player3;
	Square square1, square2, square3;
	Element element1, element2, element3;
	
	// Player List;
	List<Player> players;
	
	// Starting square indicies
	int startingSquareIndexPlayer2;
	
	// Player's current Square and next Square
	Square currentSquarePlayer2;


	// Player class data
	String playerName1, playerName2, playerName3;

	// Square class data
	String squareName1, squareName2, squareName3;


	// Element class data
	String elementName1, elementName2, elementName3; 
	int elementNum1, elementNum2, elementNum3;
	int purchasePrice1, purchasePrice2, purchasePrice3; 
	int rentPrice1, rentPrice2, rentPrice3; 
	int developmentPrice1, developmentPrice2, developmentPrice3;
	
	// Dice roller
	List<Dice> dice;
	Roller diceRoller;
	int squaresToMove;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		// Name of a Player
		playerName1 = "John";
		playerName2 = "Sanmi";
		playerName3 = "Aidan";

		// Names of Squares
		squareName1 = "Square 1";
		squareName2 = "Square 2";
		squareName3 = "Square 3";

		// Names of Elements
		elementName1 = "Element 1";
		elementName2 = "Element 2";
		elementName3 = "Element 3";
		
		// Numbers of Elements
		elementNum1 = 1;
		elementNum2 = 2;
		elementNum3 = 3;

		// Purchase prices for Elements
		purchasePrice1 = 500;
		purchasePrice2 = 1000;
		purchasePrice3 = 1200;

		// Rent Prices for Elements 
		rentPrice1 = 50;
		rentPrice2 = 100;
		rentPrice3 = 200;

		//Development prices for Elements
		developmentPrice1 = 300;
		developmentPrice2 = 500;
		developmentPrice3 = 800;

		// Instantiate Player
		player1 = new Player(playerName1);
		player2 = new Player(playerName2);
		player3 = new Player(playerName3);

		// Instantiate Elements	
		element1 = new Element(elementName1, elementNum1, purchasePrice1, rentPrice1, developmentPrice1);
		element2 = new Element(elementName2, elementNum2, purchasePrice2, rentPrice2, developmentPrice2);
		element3 = new Element(elementName3, elementNum3, purchasePrice3, rentPrice3, developmentPrice3);

		// Instantiate Squares
		square1 = new Square(squareName1);
		square2 = new Square(squareName2);
		square3 = new Square(squareName3);
		
		// Instantiate and populate players List
		players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		
		// Dice roll
		dice = new ArrayList<>();
		dice.add(new Dice(6));
		dice.add(new Dice(6));
		diceRoller = new Roller(dice);
		squaresToMove = diceRoller.roll();
		
		
		
	}

	/**
	 *  Testing constructor with arguments
	 *  Ensures Board object "b" is created and not null.
	 *  Ensures an empty List<Square> is created within the Board object
	 */
	@Test
	void testConstructorWithArgs() {
		Board b = new Board();
		assertNotNull(b);

		List<Square> squares = b.getSquares();
		assertTrue(squares.size()==0);

	}

	/**
	 *  Testing AddSquareToBoard to add Squares to the Board List
	 *  Implements getSquares method which retrieves Squares in Board
	 *  Adds Squares to List, checks if all 3 are added.
	 */
	@Test
	void testAddSquareToBoard() {
		board = new Board();

		board.addSquareToBoard(square1);
		board.addSquareToBoard(square2);
		board.addSquareToBoard(square3);

		if(board.getSquares().contains(square1)) {
			if(board.getSquares().contains(square2)) {
				if(board.getSquares().contains(square3)) {
					assertTrue(true); 
				} else {
					assertTrue(false);
				}
			} else {
				assertTrue(false);
			}
		} else {
			assertTrue(false);
		}	
	}

	/**
	 * 	Testing removeSquares to remove an Square from the squares List
	 *  Implements addSquareToBoard to add a Square to the Squares List
	 *  Implements getSquares method which retrieves Squares in List
	 *  Adds three Squares then removes one, so checks that 2 remain
	 */
	@Test
	void testRemoveSquareFromBoard() {
		board = new Board();
		board.addSquareToBoard(square1);
		board.addSquareToBoard(square2);
		board.addSquareToBoard(square3);

		board.removeSquareFromBoard(square2);

		if(board.getSquares().contains(square2)) {
			assertTrue(false);
		} else {
			if(board.getSquares().size()==2) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
	}
	
	/**
	 *  Testing move method to move players along board
	 *  Adding squares to List on board object
	 *  Separately adding Squares to a new ArrayList
	 *  Moving player1 using board.move() method
	 *  Moving player2 using hard code
	 *  Players start at first square on each board and roll the same dice values.
	 *  Assert players end up on same Square on same Boards.
	 */
	@Test
	void testMove() {
		board = new Board();
		board.addSquareToBoard(square1);
		board.addSquareToBoard(square2);
		board.addSquareToBoard(square3);
		
		List<Square> squares = new ArrayList<>();
		
		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		
		player1.setCurrentSquare(square1);
		player2.setCurrentSquare(square1);
		
		currentSquarePlayer2 = player2.getCurrentSquare();
		startingSquareIndexPlayer2 = squares.indexOf(currentSquarePlayer2);
		
		board.move(players, player1, squaresToMove);
		
		for(int square = 0; square < squaresToMove; square++) {
			int nextSquareIndex = (startingSquareIndexPlayer2 + square) % squares.size();
			Square nextSquare = squares.get(nextSquareIndex);
			nextSquare.onPass(player2);
		}
		player2.getCurrentSquare().onLand(players, player2);
		
		Square expected = player1.getCurrentSquare(); 
		Square actual = player2.getCurrentSquare();
		
		assertEquals(expected, actual);
	}	
}







