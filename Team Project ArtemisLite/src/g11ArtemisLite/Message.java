package g11ArtemisLite;

public class Message implements java.io.Serializable {
	private static final long serialVersionUID = 2938313309603492644L;
	public String startingMessage = "Every story needs heroes, "
			+ "\nand the story of mankind's glorious return to the Moon is no exception. "
			+ "\nNow is the time to make your mark in the annals of history...\n";

	public String intro = "will lead an innovative and sustainable program of exploration with commercial and international partners "
			+ "\nto enable human expansion across the solar system and to bring back to earth new knowledge and opportunities. "
			+ "\nBeginning with missions beyond low-earth orbit, "
			+ "\nthe US will lead the return of humans to the Moon for long-term exploration and utilisation, "
			+ "\nfollowed by human missions to Mars and other destinations\n";

	public String rules = "RULES\n"
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

	public String inputOptionRequest = "Input a number and press [Enter]"; 
	
	public String invalidOption = "Invalid option selected, try again...";

	public String invalidInput = "Invalid input try again";
	
	public String returnToMenu = "To return to the main menu press [Enter]";

	public String encouragement = "Good for you, you're a real trouper!";

	public String missionFailure = "Your mission is a failure, you are all failures!";
	
	public String restoringGame = "Restoring game...";
	
	public String randomEventBankrupt = "Oh dear, events have conspired against you, you're bankrupt!";
	
	public String userQuitFail = "You've quit the game, which means Game Over for all players!";
	
	public String epilogue1 = "\nArtemis: twin sister of Apollo, Goddess of the Moon... Humanity will once again unite to push beyond the boundaries of space exploration, \n"
			+ "science and technology. Thanks to your hard work and dedication, NASA, along with its partners in industry, nations and academia, is ready \n"
			+ "to begin a new era of sustainable travel to the Moon and beyond!\n\n";
	
	public String epilogue2 = "Beginning in 2021, the first Commercial Lunar Payload Services deliveries began delivering instruments to the lunar surface that paved \n"
			+ "the way for human explorers. The golf-cart-sized VIPER rover was the first to investigate lunar polar soil samples to characterize the \n"
			+ "distribution and concentration of volatiles, including water, across a large region of the Moon.\n\n";
	
	public String epilogue3 = "With the completion Space Launch System rocket and its accompanying Orion spacecraft, the first main Artemis mission, Artemis I, completed \n"
			+ "its successful uncrewed launch. This allowed for verification of the spacecrafts performance and testing of Orion's heat shield during its \n"
			+ "high-speed reentry at nearly 5000 degress Farenheit.\n\n";
	
	public String epilogue4 = "The first pieces of the Gateway, the Power and Propulsion Element (PPE) and the Habitation and Logistics Outpost (HALO), were then \n"
			+ "successfully launched and installed at the lunar NRHO. On-board science investigations from NASA and the European Space Agency conducted \n"
			+ "early characterization of the deep space environment.\n\n";
	
	public String epilogue5 = "The overwhelming success of the first Artemis launch was followed by Artemis II, the 10-day crewed test flight. NASA astronauts set the \n"
			+ "record for the for the farthest human travel from Earth to date. They successfully validated deep space communication and navigation systems, \n"
			+ "with the innovative new life support systems keeping them healthy and safe throughout.\n\n";
	
	public String epilogue6 = "With the confidence gained through Artemis I and Artemis II, Orion and its crew were ready to once again travel to the Moon, this time \n"
			+ "boarding the completed Human Landing System designed to deliver the first woman and next man to the lunar surface!\n\n";
	
	public String epilogue7 = "T-minus 60 seconds and counting\n";
	
	public String epilogue8 = "Give me a go/no go for launch\n";
	
	public String epilogueBooster = "BOOSTER...";
	public String epilogueRetro = "RETRO...";
	public String epilogueFIDO = "FIDO...";
	public String epilogueGuidance = "GUIDANCE...";
	public String epilogueSurgeon = "SURGEON...";
	public String epilogueEECOM = "EECOM...";
	public String epilogueControl = "CONTROL...";
	public String epilogueProcedures = "PROCEDURES...";
	public String epilogueINCO = "INCO...";
	public String epilogueNetwork = "NETWORK...";
	public String epilogueRecovery = "RECOVERY...";
	public String epilogueCAPCOM = "CAPCOM...";
	public String epilogueGO = "GO!\n";
	
	public String epilogue9 = "Launch Control this is Houston we are go for launch!\n"
			+ "Coming up on a go for Auto Sequence start\n";
	
	public String epilogue10 = "booster ignition and liftoff of Artemis III! \n"
			+ "...Paving the way for a new era of mans exploration of the Moon and beyond!\n";
	
	public void epilogueCountdown() {
		for (int countdown = 10; countdown >= 1; countdown--) {
			System.out.println(countdown);
			if (countdown == 5) {
				System.out.println("Ignition sequence start!");
			}
			delay(1000);
		}
	}
	
	public void delay(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
