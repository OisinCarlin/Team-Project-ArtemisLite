package g11ArtemisLite;
/**
 * 
 * @author Robbie, Maeve and Richard
 *
 */
public class Message implements java.io.Serializable {
	private static final long serialVersionUID = 2938313309603492644L;
	
	public static String welcome = "Welcome to ArtemisLite!\n";
	
	public static String menuOpRules = "[1]:\tDisplay Rules";
	public static String menuOpNewGame = "[2]:\tStart New Game";
	public static String menuOpRestoreGame = "[3]:\tRestore Saved Game";
	public static String menuOpEnableSpeech = "[4]:\tEnable speech";
	public static String menuOpDisableSpeech = "[4]:\tDisable speech";
	
	public static String startingMessage = "Every story needs heroes, "
			+ "\nand the story of mankind's glorious return to the Moon is no exception. "
			+ "\nNow is the time to make your mark in the annals of history...\n";

	public static String intro = "will lead an innovative and sustainable program of exploration with commercial and international partners "
			+ "\nto enable human expansion across the solar system and to bring back to earth new knowledge and opportunities. "
			+ "\nBeginning with missions beyond low-earth orbit, "
			+ "\nthe US will lead the return of humans to the Moon for long-term exploration and utilisation, "
			+ "\nfollowed by human missions to Mars and other destinations\n";

	public static String rules = "RULES\n"
			+ "Please read the following instructions carefully to ensure your mission is a success. \n" + "\n"
			+ "MISSION OBJECTIVE\n"
			+ "Your objective is to to launch the Artemis rocket, and enable human expansion across the solar system. "
			+ "\nArtemis can only launch once all elements have been fully developed, "
			+ "\nso you must work as a team to fully develop the element systems and ensure a successful mission.\n"
			+ "\n" + "PLAYERS\n"
			+ "At the beginning of each game you must enter the number of players that are undertaking the mission. Your team may compose of up to four players.\n"
			+ "\n" + "WHO STARTS?\n" + "Players will take turns, in the order names were entered. \n" + "\n"
			+ "HOW TO WIN\n"
			+ "The game finishes once there has been a successful launch of Artemis. "
			+ "\nArtemis is launched when all four element systems (Space Launch, Orion Spacecraft, Gateway and Lunar Base Camp) have been fully developed.\n"
			+ "\n" + "HOW TO LOSE\n"
			+ "If one player runs out of resources, or forfeits before mission launch, Artemis will not be able to launch and the mission has failed.\n"
			+ "\n" + "PLAYING A ROUND\n"
			+ "Rolling and Moving: At the start of each turn players roll two dice. "
			+ "\nThe player then moves on the board based on the value of the dice roll. "
			+ "\nInformation will be displayed telling the current player what square they landed on and all relevant data about that square.\n"
			+ "\n" + "Passing Go: Every time a player has passes GO they will receive **200** additional resources.\n"
			+ "\n"
			+ "Purchasing Element: If a player lands on an element not owned by another player, they will have the option to purchase \n"
			+ "\n"
			+ "Developing Element: If the player owns all elements within a system, they will be given the option to develop that system, and the cost of development will be displayed to them.\n"
			+ "\n"
			+ "If a square is already owned: If a player lands on an element already owned by another player, that player has the option to charge them rent.\n"
			+ "\n"
			+ "Trading Elements: Players will also be given the option to To trade an Element the current player owns to another player.\n"
			+ "\n" + "It is advised to wear the correct safety gear when venturing into space.";
	
	public static String boardLayout = "|***********************|***********************|***********************|***********************|\n"+
			"|      Artemis HQ       |        Orion 1        |        Orion 2        |        Orion 3        |\n"+
			"|***********************|***********************|***********************|***********************|\n"+
			"|         PRESS         |     CREW MODULE       | LAUNCH ABORT SYSTEMS  |    SERVICE MODULE     |\n"+
			"|       CONFERENCE      |      Dev Levels       |      Dev Levels       |      Dev Levels       |\n"+
			"|                       |    Power Generators   |    Fairing Assembly   |   Spacecraft Adapter  |\n"+
			"|      Nothing else     |     Crew Quarters     |    Attitude Control   |    Power & Thermal    |\n"+
			"|      happens here     |  Guidance Nav Control |    Jettison Motor     |  Water & Air Support  |\n"+
			"|                       |        ECLSS          |      Abort Motor      |   Orbital Transfer    |\n"+
			"|                       |                       |                       |                       |\n"+
			"|***********************|***********************|***********************|***********************|\n"+
			"| Space Launch System 3 |                                               |   Lunar Base Camp 1   |\n"+
			"|***********************|                 ------------>                 |***********************|\n"+
			"|         ICPS          |                                               | HUMAN LANDING SYSTEM  |\n"+
			"|      Dev Levels       |                                               |      Dev Levels       |\n"+
			"|  Orion Stage Adapter  |                                               |  Super Heavy Booster  |\n"+
			"|  Liquid Oxygen Tank   |                                               |   Surface Transport   |\n"+
			"| Liquid Hydrogen Tank  |  Ʌ                                         |  |    Payload Storage    |\n"+
			"|   Rocketdyne Engine   |  |                                         |  |   Reaction Control    |\n"+
			"|                       |  |                                         |  |                       |\n"+
			"|***********************|  |                                         |  |***********************|\n"+
			"| Space Launch System 2 |  |                                         |  |   Lunar Base Camp 2   |\n"+
			"|***********************|  |                                         |  |***********************|\n"+
			"|   CORE & PROPULSION   |  |                                         |  |    xEMU SPACESUIT     |\n"+
			"|      Dev Levels       |  |                                         V  |      Dev Levels       |\n"+
			"|      Fuel Tanks       |                                               | Portable Life Support |\n"+
			"|      Propellant       |                                               | High-Speed Data Comms |\n"+
			"|    4 RS-25 Engines    |                                               |   Membrane Cooling    |\n"+
			"|    Rocket Boosters    |                 <------------                 |    Mobility System    |\n"+
			"|                       |                                               |                       |\n"+
			"|***********************|***********************|***********************|***********************|\n"+
			"| Space Launch System 1 |       Gateway 2       |       Gateway 1       |      Artemis HQ       |\n"+
			"|***********************|***********************|***********************|***********************|\n"+
			"|       AVIONICS        | HABITATION LOGISTICS  |   POWER & PROPULSION  |    MISSION CONTROL    |\n"+
			"|      Dev Levels       |      Dev Levels       |      Dev Levels       |      All players      |\n"+
			"|    Rocket Sensors     |    CAPSTONE Cubesat   |     Solar Arrays      |       start here      |\n"+
			"| Controllers & Cabling |    Pressure Control   |     S-band Comms      |                       |\n"+
			"|         VLE           |     Comms to Luna     |    Science Payload    |      PASS MISSION     |\n"+
			"|   Flight Computers    |     Docking Ports     |     Ion Thrusters     |  CONTROL GAIN 200 IQ  |\n"+
			"|                       |                       |                       |                       |\n"+
			"|***********************|***********************|***********************|***********************|\n";

	public static String toEnableSpeech = "To enable speech ";
	
	public static String toDisableSpeech = "To disable speech ";
	
	public static String speechEnabled = "Speech Enabled";
	
	public static String speechDisabled = "Speech Disabled";
	
	public static String inputOptionRequest = "Input a number and press [Enter]"; 
	
	public static String invalidOption = "Invalid option selected, try again...";

	public static String invalidInput = "Invalid input try again. ";
	
	public static String tooFewPlayers = "Too few players. Min players is ";
	
	public static String tooManyPlayers = "Too many players. Max players is ";
	
	public static String oneVisibleChar = "Please enter at least one visible character. ";
	
	public static String usedName = "Name already used. Please enter a different name.";
	
	public static String enterYN = "Enter Y / N";
	
	public static String resources = " IQ points";
	
	public static String ownElement = "You own this element";
	
	public static String offerPurchase = " Do you want to purchase ";
	
	public static String congratsPurchase = "Congratulations! You now own ";
	
	public static String notEnoughRes = " Sorry not enough resources.\n";
	
	public static String declinePurchase = "Sorry you don't want to purchase \n";
	
	public static String offer = "Do you want to offer ";
	public static String otherPlayer = " to another player?";
	
	public static String charge = " Do you want to charge ";
	
	public static String charged = " you have been charged ";
	
	public static String rent = " rent?\n";
	
	public static String enterNumPlayers = "Enter number of players ";
	
	public static String select = "To select ";
	
	public static String develop = "To develop ";
	
	public static String trade = "To trade ";
	
	public static String cancel = "To cancel ";
	
	public static String enter = " enter ";
	
	public static String with = "with ";
	
	public static String toCancel = "To cancel enter "; 
	
	public static String enterNum1 = "Enter number 1 - ";
	
	public static String cancelling = "Cancelling";
	
	public static String ownAllElements = "You need to own all elements in a system before you can develop!";
	
	public static String noDevToMake = "You don't have any developments to make!";
	
	public static String maxDev = " Max development reached ";
	
	public static String upgradeLevel = "Upgraded to level ";
	
	public static String developedIt = "You've developed it!";
	
	public static String dontDevMore = "Don't want to develop any more? ";
	
	public static String dontTradeMore = "Don't want to trade any more? ";
	
	public static String noElementsTrade = "You have no elements to trade";
	
	public static String whoTrade = "Who would you like to trade with?";
	
	public static String likeToBuy = " would you like to buy ";
	
	public static String noToTrade = " doesn't want to trade, hard luck!";
	
	public static String likeTo = "Would you like to...";
	public static String moveMenuOpShowSystems = "1. Display All Systems";
	public static String moveMenuOpShowRes = "2. Display your Resources & Properties Owned";
	public static String moveMenuOpDevelop = "3. Develop an element";
	public static String moveMenuOpTrade = "4. Trade an Element";
	public static String moveMenuOpEnd = "5. End your Turn";
	public static String moveMenuOpSave = "6. Save Game";
	public static String moveMenuOpQuit = "7. Quit the Game";
	public static String moveMenuOpBoard = "8. Display Board Layout";
	
	public static String gameOver = "Game Over";
	
	public static String exitMenu = "Exiting menu";
	
	public static String finalSOP = "This is the final state of play...";
	
	public static String openDevMenu = "Opening development menu";
	
	public static String openTradeMenu = "Opening trade menu";
	
	public static String endingTurn = "Ending your turn";
	
	public static String saveGame = "Saving game";
	
	public static String returnToMenu = "To return to the main menu press [Enter]";

	public static String encouragement = "Good for you, you're a real trouper!";

	public static String missionFailure = "Your mission is a failure, you are all failures!";
	
	public static String restoringGame = "Restoring game...";
	
	public static String randomEventBankrupt = "Oh dear, events have conspired against you, you're bankrupt! Game Over!";
	
	public static String rentBankrupt = "You did not have sufficient resources! You're bankrupt! Game Over!";
	
	public static String userQuitFail = "You've quit the game, which means Game Over for all players!";
	
	public static String epilogue1 = "\nEPILOGUE\n\nArtemis: twin sister of Apollo, Goddess of the Moon... Humanity will once again unite to push beyond the boundaries of space exploration, \n"
			+ "science and technology. Thanks to your hard work and dedication, NASA, along with its partners in industry, nations and academia, is ready \n"
			+ "to begin a new era of sustainable travel to the Moon and beyond!\n\n";
	
	public static String epilogue2 = "Beginning in 2021, the first Commercial Lunar Payload Services deliveries began delivering instruments to the lunar surface that paved \n"
			+ "the way for human explorers. The golf-cart-sized VIPER rover was the first to investigate lunar polar soil samples to characterize the \n"
			+ "distribution and concentration of volatiles, including water, across a large region of the Moon.\n\n";
	
	public static String epilogue3 = "With the completion Space Launch System rocket and its accompanying Orion spacecraft, the first main Artemis mission, Artemis I, completed \n"
			+ "its successful uncrewed launch. This allowed for verification of the spacecrafts performance and testing of Orion's heat shield during its \n"
			+ "high-speed reentry at nearly 5000 degress Farenheit.\n\n";
	
	public static String epilogue4 = "The first pieces of the Gateway, the Power and Propulsion Element (PPE) and the Habitation and Logistics Outpost (HALO), were then \n"
			+ "successfully launched and installed at the lunar NRHO. On-board science investigations from NASA and the European Space Agency conducted \n"
			+ "early characterization of the deep space environment.\n\n";
	
	public static String epilogue5 = "The overwhelming success of the first Artemis launch was followed by Artemis II, the 10-day crewed test flight. NASA astronauts set the \n"
			+ "record for the for the farthest human travel from Earth to date. They successfully validated deep space communication and navigation systems, \n"
			+ "with the innovative new life support systems keeping them healthy and safe throughout.\n\n";
	
	public static String epilogue6 = "With the confidence gained through Artemis I and Artemis II, Orion and its crew were ready to once again travel to the Moon, this time \n"
			+ "boarding the completed Human Landing System designed to deliver the first woman and next man to the lunar surface!\n\n";
	
	public static String epilogue7 = "T-minus 60 seconds and counting\n";
	
	public static String epilogue8 = "Give me a go/no go for launch\n";
	
	public static String epilogueBooster = "BOOSTER...";
	public static String epilogueRetro = "RETRO...";
	public static String epilogueFIDO = "FIDO...";
	public static String epilogueGuidance = "GUIDANCE...";
	public static String epilogueSurgeon = "SURGEON...";
	public static String epilogueEECOM = "EECOM...";
	public static String epilogueControl = "CONTROL...";
	public static String epilogueProcedures = "PROCEDURES...";
	public static String epilogueINCO = "INCO...";
	public static String epilogueNetwork = "NETWORK...";
	public static String epilogueRecovery = "RECOVERY...";
	public static String epilogueCAPCOM = "CAPCOM...";
	public static String epilogueGO = "GO!\n";
	
	public static String epilogue9 = "Launch Control this is Houston we are go for launch!\n"
			+ "Coming up on a go for Auto Sequence start\n";
	
	public static String epilogue10 = "booster ignition and liftoff of Artemis III! \n"
			+ "...Paving the way for a new era of mans exploration of the Moon and beyond!\n";
	
	public static void epilogueCountdown() {
		for (int countdown = 10; countdown >= 1; countdown--) {
			System.out.println(countdown);
			if (countdown == 5) {
				System.out.println("Ignition sequence start!");
			}
			delay(1000);
		}
	}
	
	public static void delay(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
