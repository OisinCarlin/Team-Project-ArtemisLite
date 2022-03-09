/**
 * 
 */
package g11ArtemisLite;

import java.util.List;

/**
 * @author crclarke
 *
 */
public class StateOfPlay implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;
	private List<Player> players;
	private Board board;
	/**
	 * @return the players
	 */
	public List<Player> getPlayers() {
		return players;
	}
	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	/**
	 * @param players the players to set
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	

}
