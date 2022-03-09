/**
 * 
 */
package g11ArtemisLite;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author crclarke
 *
 */
public class Serializaion {

	private static StateOfPlay lastSOP, restoredSOP;
	private static DataSaver dataSaver;

	public void SaveData(List<Player> players, Board board) {
		lastSOP = new StateOfPlay();
		dataSaver = new DataSaver();
		restoredSOP = null;

		lastSOP.setPlayers(players);
		lastSOP.setBoard(board);

		dataSaver.setSOP(lastSOP);
		dataSaver.setFileName("myData");

		try {
			dataSaver.saveData();
			//System.out.println("\nI've saved.");
		} catch (IOException e) {
			System.out.println("\nError (3) saving file " + e);
		}
	}

	public List<Player> RestorePlayers() {
		restoredSOP = null;

		try {
			restoredSOP = getData("myData");
			//System.out.println("\nI'm restoring.");
		} catch (IOException e) {
			System.out.println("\nError (1) reading file " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("\nError (2) reading file " + e);
		}

		if (restoredSOP != null) {
			System.out.println("Restored players...");
			for (Player player : restoredSOP.getPlayers()) {

				System.out.println("Restored player name: " + player.getName());
				System.out.println("Restored Amount: " + player.getResources());
			}
			for (Player player : restoredSOP.getPlayers()) {
				if (player.isCurrentTurn()) {
					System.out.println("It is currently " + player.getName() + "'s turn");
					if (player.hasMoved()) {
						System.out.println(
								player.getName() + " has rolled and moved, and can now choose how to proceed...");
					} else {
						System.out.println(player.getName() + " didn't conclude their roll. Rolling again!");
					}
				}
				System.out.println();
			}
		}

		return restoredSOP.getPlayers();
	}

	public Board RestoreBoard() {
		restoredSOP = null;

		try {
			restoredSOP = getData("myData");
			//System.out.println("\nI'm restoring.");
		} catch (IOException e) {
			System.out.println("\nError (1) reading file " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("\nError (2) reading file " + e);
		}

		if (restoredSOP != null) {
			System.out.println("Restored board state...");
			restoredSOP.getBoard().displayElementDetails();

		}

		return restoredSOP.getBoard();
	}

	private static StateOfPlay getData(String fileName) throws IOException, ClassNotFoundException {
		StateOfPlay stateOfPlay = null;
		FileInputStream f_in = new FileInputStream(fileName);
		ObjectInputStream obj_in = new ObjectInputStream(f_in);
		try {
			Object obj = obj_in.readObject();
			stateOfPlay = (StateOfPlay) obj;
		} catch (EOFException e) {
		}
		obj_in.close();
		f_in.close();
		return stateOfPlay;
	}

}
