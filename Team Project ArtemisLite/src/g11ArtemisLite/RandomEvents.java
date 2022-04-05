/**
 * 
 */
package g11ArtemisLite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author crclarke
 *
 */
public class RandomEvents implements java.io.Serializable {
	
	private static final long serialVersionUID = 2938313309603492644L;
	private static final String BADEVENT1 = "You fastened the rockets the wrong way round!";
	private static final String BADEVENT2 = "Someone spilt Mountain Dew on the circuit boards!";
	private static final String BADEVENT3 = "One of your astronauts got sick on the flight simulator!";
	private static final String BADEVENT4 = "Someone switched Orion's oxygen supply for NO2!";
	private static final String BADEVENT5 = "The Russians have ceased co-operation!";
	private static final String BADEVENT6 = "They found out your Harvard degree was faked!";
	private static final String BADEVENT7 = "You tried to bribe your way out of a DUI en route to work, now you're really in trouble!";
	private static final String BADEVENT8 = "The spacesuit was harder to design than you thought!";
	private static final String BADEVENT9 = "Elon Musk just tweeted defamatory comments about the way you're running this operation!";
	private static final String BADEVENT10 = "Neon shortages from the Ukraine conflict has pushed up microprocessor cost!";
	private static final String BADEVENT11 = "Trump is running for President again!";
	private static final String BADEVENT12 = "Incontroverible evidence that the first Moon landings were faked got leaked to the press!";
	private static final String BADEVENT13 = "The astonauts have declared a strike over low-quality space-food!";
	private static final String BADEVENT14 = "General Relativity has been disproved, all your calculations need recalculating!";
	private static final String BADEVENT15 = "Your chief engineer decided he/she wants to make sourdough for a living instead!";
	private static final String BADEVENT16 = "Someone spiked the water-fountain!";
	private static final String BADEVENT17 = "Trump is President again!";
	private static final String BADEVENT18 = "You've made promises you can't keep, your deadline slipped!";
	private static final String BADEVENT19 = "Your spouse eloped with the gardener, you can no longer focus on your work!";
	private static final String BADEVENT20 = "You stayed up late watching Armageddon and missed your alarm!";
	private static final String GOODEVENT1 = "You fastened the rockets the right way round!";
	private static final String GOODEVENT2 = "No-one spilt anything on the circuit boards... yet!";
	private static final String GOODEVENT3 = "Your astronauts are killing it on the flight simulator!";
	private static final String GOODEVENT4 = "Orion's oxygen supply is more reliable than ever!";
	private static final String GOODEVENT5 = "The Russians have restated their commitment to co-operation!";
	private static final String GOODEVENT6 = "Your Harvard degree classification got upgraded!";
	private static final String GOODEVENT7 = "You made excellent time on the commute to work!";
	private static final String GOODEVENT8 = "The spacesuit was easier to design than you thought!";
	private static final String GOODEVENT9 = "Elon Musk just tweeted highly flattering comments about the way you're running this operation!";
	private static final String GOODEVENT10 = "Cheap but high-quality Chinese imports have decreased microprocessor cost!";
	private static final String GOODEVENT11 = "Trump is NOT running for President again!";
	private static final String GOODEVENT12 = "Incontroverible evidence that the first Moon landings were real got leaked to the press!";
	private static final String GOODEVENT13 = "The astonauts have declared their satisfaction regarding the quality of the space-food!";
	private static final String GOODEVENT14 = "General Relativity has been proved beyond all doubt, all your calculations are solid!";
	private static final String GOODEVENT15 = "Your chief engineer decided he/she wants nothing more than to serve NASA!";
	private static final String GOODEVENT16 = "Someone spiked the water-fountain with Adderall, productivity increases!";
	private static final String GOODEVENT17 = "Trump is not and will never be President again!";
	private static final String GOODEVENT18 = "You've made promises, and you kept them... your ahead of your deadline!";
	private static final String GOODEVENT19 = "Your spouse eloped with the gardener, you can now focus fully on your work!";
	private static final String GOODEVENT20 = "You stayed up late watching Armageddon and got a great idea for Artemis!";
	private List<String> goodList;
	private List<String> badList;
	private static final int SMALLFEE = 20;
	private static final int MEDIUMFEE = 20;
	private static final int LARGEFEE = 20;
	private List<Integer> fees;
	
	public RandomEvents() {
		goodList = new ArrayList<String>();
		badList = new ArrayList<String>();
		fees = new ArrayList<Integer>();
		goodList.add(GOODEVENT1);
		goodList.add(GOODEVENT2);
		goodList.add(GOODEVENT3);
		goodList.add(GOODEVENT4);
		goodList.add(GOODEVENT5);
		goodList.add(GOODEVENT6);
		goodList.add(GOODEVENT7);
		goodList.add(GOODEVENT8);
		goodList.add(GOODEVENT9);
		goodList.add(GOODEVENT10);
		goodList.add(GOODEVENT11);
		goodList.add(GOODEVENT12);
		goodList.add(GOODEVENT13);
		goodList.add(GOODEVENT14);
		goodList.add(GOODEVENT15);
		goodList.add(GOODEVENT16);
		goodList.add(GOODEVENT17);
		goodList.add(GOODEVENT18);
		goodList.add(GOODEVENT19);
		goodList.add(GOODEVENT20);
		badList.add(BADEVENT1);
		badList.add(BADEVENT2);
		badList.add(BADEVENT3);
		badList.add(BADEVENT4);
		badList.add(BADEVENT5);
		badList.add(BADEVENT6);
		badList.add(BADEVENT7);
		badList.add(BADEVENT8);
		badList.add(BADEVENT9);
		badList.add(BADEVENT10);
		badList.add(BADEVENT11);
		badList.add(BADEVENT12);
		badList.add(BADEVENT13);
		badList.add(BADEVENT14);
		badList.add(BADEVENT15);
		badList.add(BADEVENT16);
		badList.add(BADEVENT17);
		badList.add(BADEVENT18);
		badList.add(BADEVENT19);
		badList.add(BADEVENT20);
		fees.add(SMALLFEE);
		fees.add(MEDIUMFEE);
		fees.add(LARGEFEE);
	}
	
	public void generateRandomEvent(List<Player> players) {
		int playerNum = 0;
		int goodOrBad = 0;
		int goodEventNum = 0;
		int badEventNum = 0;
		int fineNum = 0;
		Random ran = new Random();
		playerNum = ran.nextInt(players.size());
		goodOrBad = ran.nextInt(2);
		goodEventNum = ran.nextInt(goodList.size());
		badEventNum = ran.nextInt(badList.size());
		fineNum = ran.nextInt(fees.size());
		System.out.println("********** EVENT **********");
		if (goodOrBad==0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(badList.get(badEventNum));
			System.out.println(players.get(playerNum).getName()+", pay up! Fine: "+fees.get(fineNum) + Message.resources);
			
			players.get(playerNum).removeResources(fees.get(fineNum));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(UserInput.isSpeak()) {
				new Speech(badList.get(badEventNum) + players.get(playerNum).getName()+", pay up! Fine: "+fees.get(fineNum) + Message.resources);
			}
		} else {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(goodList.get(goodEventNum));
			System.out.println(players.get(playerNum).getName()+", Congratulations! You receive: "+fees.get(fineNum) + Message.resources);
			players.get(playerNum).addResources(fees.get(fineNum));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(UserInput.isSpeak()) {
				new Speech(goodList.get(goodEventNum) + players.get(playerNum).getName()+", Congratulations! You receive: "+fees.get(fineNum) + Message.resources);
			}
		}
		System.out.println("******* END OF EVENT *******");
	}

}
