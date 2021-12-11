
import processing.core.PApplet;
import processing.core.PImage;


public class GameScreen extends Screen {
	private PImage img, player1, player2, property1, property2, property3, property4, property5, property6, property7,
			property8, property9, property10, property11, property12, property13, property14, property15, property16,
			property17, property18, property19, property20, property21, property22, kingsCrossStation,
			maryleboneStation, fenchurchStStation, liverpoolStreetStation, electricCompany, waterWorks, freeParking, 
			incomeTax, superTax, house;
	private Die die1, die2;
	private int total1, total2, rollCount = 0, iceBreakerCount, exerciseCount;
	public static int i = 0;
	public static int turn = 0;
	public int Turn = 0;
	public int totalP = 0;
	public static int Pos = 0;
	public static int[] Players = { 1, 2, 3, 4 };
	public static int Money = 400;
	public static int[] pPos = { 200, 0, 0, 0, -200, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static int[] pMoney = { 0, 0, 0, 0 };
	public static int x = 0;
	public static int mFlag = 0;

	private Player dog, thimble;
	private Property oldKentRoad, whitechapelRoad, theAngelIslington, eustonRoad, pentonvilleRoad, pallMall, whiteHall,
			NorthumberlandAvenue, bowStreet, MarlboroughStreet, vineStreet, strand, fleetStreet, trafalgarSquare,
			leicesterSquare, coventryStreet, piccadilly, regentStreet, oxfordStreet, bondStreet, parkLane, mayfair,
			station1, station2, station3, station4, electric, water;
	private IceBreakerCards funnyJoke, backStory ,makeLaugh,favoriteFood,dreamDestination,story,personality,favoriteHobby,
	advice,foodDebate;
	
	private ExerciseCards pushups, plank,jumpingJacks, crunches, pushups2,squats, mountainClimbers, chairDips,ankleRaises,burpees;
	
	private boolean kentHouse1 = false, whitechapelHouse1 = false, angelHouse1 = false, eustonHouse1 = false, pentonvilleHouse1 = false,
			pallMallHouse1 = false, whitehallHouse1 = false, northHouse1 = false, bowHouse1 = false, malborughHouse1 = false,
			vineHouse1 = false, strandHouse1 = false, fleetHouse1 = false, trafalgarHouse1 = false, leiceHouse1 = false,
			coventryHouse1 = false, piccadillyHouse1 = false, regentHouse1 = false, oxfordHouse1 = false, bondHouse1 = false,
			parkHouse1 = false, mayHouse1 = false;

	private boolean isInJail1 = false, isInJail2 = false;
	private int countDaysInJail1=0, countDaysInJail2=0;
	
	private DrawingSurface surface;
	
	// COORDINATES OF EVERY SPACE FOR PATH 1
	final int[] path1BoardXCoordinates = { 686, 605, 544, 483, 422, 361, 300, 239, 178, 117, 56, 56, 56, 56, 56, 56, 56,
			56, 56, 56, 56, 117, 178, 239, 300, 361, 422, 483, 544, 605, 671, 671, 671, 671, 671, 671, 671, 671, 671,
			671 };
	final int[] path1BoardYCoordinates = { 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 650, 582, 524, 466, 408,
			350, 292, 234, 176, 118, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 118, 176, 234, 292, 350, 408, 466, 524,
			582 };

	// COORDINATES OF EVERY SPACE FOR PATH 2
	final int[] path2BoardXCoordinates = { 686, 605, 544, 483, 422, 361, 300, 239, 178, 117, 15, 15, 15, 15, 15, 15, 15,
			15, 15, 15, 15, 117, 178, 239, 300, 361, 422, 483, 544, 605, 711, 711, 711, 711, 711, 711, 711, 711, 711,
			711 };
	final int[] path2BoardYCoordinates = { 690, 690, 690, 690, 690, 690, 690, 690, 690, 690, 690, 582, 524, 466, 408,
			350, 292, 234, 176, 118, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 118, 176, 234, 292, 350, 408, 466, 524,
			582 };

	public GameScreen(DrawingSurface surface) {
		super(1200,650);
		this.surface = surface;
		
		die1 = new Die();
		die2 = new Die();

		dog = new Player(400, "dog"); // player 1
		thimble = new Player(400, "thimble"); // player 2
		dog.setPlayerNum(1);
		thimble.setPlayerNum(2);

		// 0-9 blocks
		oldKentRoad = new Property("Old Kent Road", 60, 0, false, 0, "brown", 30, 10);
		whitechapelRoad = new Property("Whitechapel Road", 60, 0, false, 0, "brown", 30, 20);
		theAngelIslington = new Property("The Angel Is lington", 100, 0, false, 0, "light blue", 50, 30);
		eustonRoad = new Property("Euston Road", 100, 0, false, 0, "light blue", 50, 30);
		pentonvilleRoad = new Property("Pentonville Road", 120, 0, false, 0, "light blue", 50, 40);
		// 10-19
		pallMall = new Property("Pall Mall", 140, 0, false, 0, "pink", 100, 50);
		whiteHall = new Property("White Hall", 140, 0, false, 0, "pink", 100, 50);
		NorthumberlandAvenue = new Property("Northumberand Avenue", 160, 0, false, 0, "pink", 100, 60);
		bowStreet = new Property("Bow Street", 180, 0, false, 0, "orange", 100, 70);
		MarlboroughStreet = new Property("Marlborough Street", 180, 0, false, 0, "orange", 100, 70);
		vineStreet = new Property("Vine Street", 200, 0, false, 0, "orange", 100, 80);
		// 20-29
		strand = new Property("strand", 220, 0, false, 0, "red", 150, 90);
		fleetStreet = new Property("Fleet Street", 220, 0, false, 0, "red", 150, 90);
		trafalgarSquare = new Property("Trafalgar Square", 240, 0, false, 0, "red", 150, 100);
		leicesterSquare = new Property("Leicester Square", 260, 0, false, 0, "yellow", 150, 110);
		coventryStreet = new Property("Coventry Street", 260, 0, false, 0, "yellow", 150, 110);
		piccadilly = new Property("Piccadilly", 280, 0, false, 0, "yellow", 140, 120);
		// 30-39
		regentStreet = new Property("Regent Street", 300, 0, false, 0, "green", 150, 130);
		oxfordStreet = new Property("Oxford Street", 300, 0, false, 0, "green", 150, 130);
		bondStreet = new Property("Bond Street", 320, 0, false, 0, "green", 160, 150);
		parkLane = new Property("Park Lane", 350, 0, false, 0, "blue", 200, 175);
		mayfair = new Property("May Fair", 400, 0, false, 0, "blue", 200, 200);
		// special
		station1 = new Property("Kings Cross Station", 200, 0, false, 0, "train", 0, 0);
		station2 = new Property("Marylebone Station", 200, 0, false, 0, "train", 0, 0);
		station3 = new Property("Fenchurch StStation", 200, 0, false, 0, "train", 0, 0);
		station4 = new Property("Liverpool Street Station", 200, 0, false, 0, "train", 0, 0);
		water = new Property("Water Works", 150, 0, false, 0, "utility", 0, 0);
		electric = new Property("Electric Company", 150, 0, false, 0, "utility", 0, 0);

			// Ice breaker cards
		funnyJoke = new IceBreakerCards("Tell a funny joke and earn $100 for it");
		backStory = new IceBreakerCards("make up a backstory for your player and receive $50");
		makeLaugh = new IceBreakerCards("the other player needs to make you laugh for $100");
		favoriteFood = new IceBreakerCards("Tell what is your favorite food for $30");
		dreamDestination = new IceBreakerCards("Tell about your dream destination for $75");
		story = new IceBreakerCards("Make up a story of your choice for $50");
		personality = new IceBreakerCards("the other player needs to tell you something\n"+"you didnt know about them for $25");
		favoriteHobby = new IceBreakerCards("Tell the other player about your favorite new hobby for $30");
		advice = new IceBreakerCards("Give the other player a piece of advice/qoute you go by for $35");
		foodDebate = new IceBreakerCards(" Have a short debate on your favorite foods \n"+"and why they're the best for $50 each");
		
		// exercise cards
		
		pushups = new ExerciseCards("Do ten pushups for $100");
		plank = new ExerciseCards("Do a 30 second plank for $50");
		jumpingJacks = new ExerciseCards("Do ten jumping jacks for $25");
		crunches = new ExerciseCards("Do 20 crunches for $60 ");
		pushups2 = new ExerciseCards("Do as many pushups as you can for $150");
		squats = new ExerciseCards("Do 20 squats for $40");
		mountainClimbers = new ExerciseCards("Do 30 mountain climbers for $50");
		chairDips = new ExerciseCards("Do 10 chair dips for $35");
		ankleRaises = new ExerciseCards("Do 25 ankle raises for $40");
		burpees = new ExerciseCards("Do 5 burpees for $100");


	}
/**
 * initializes each image variable to the appropriate image
 */
	public void setup() {
		// size(640, 360);
		img = surface.loadImage("MonopolyBoard2.jpg"); // Load thesurfaec.surface.image into the program
		player1 = surface.loadImage("DogToken.gif");
		player2 = surface.loadImage("ThimbleToken.gif");

		property1 = surface.loadImage("OldKentRoad.png");
		property2 = surface.loadImage("WhitechapelRoad.png");
		property3 = surface.loadImage("TheAngelIslington.png");
		property4 = surface.loadImage("EustonRoad.png");
		property5 = surface.loadImage("PentonvilleRoad.png");
		property6 = surface.loadImage("PallMall.png");
		property7 = surface.loadImage("Whitehall.png");
		property8 = surface.loadImage("NorthumberlandAvenue.png");
		property9 = surface.loadImage("BowStreet.png");
		property10 = surface.loadImage("MarlboroughStreet.png");
		property11 = surface.loadImage("VineStreet.png");
		property12 = surface.loadImage("Strand.png");
		property13 = surface.loadImage("FleetStreet.png");
		property14 = surface.loadImage("TrafalgarSquare.png");
		property15 = surface.loadImage("LeicesterSquare.png");
		property16 = surface.loadImage("CoventryStreet.png");
		property17 = surface.loadImage("Piccadilly.png");
		property18 = surface.loadImage("RegentStreet.png");
		property19 = surface.loadImage("OxfordStreet.png");
		property20 = surface.loadImage("BondStreet.png");
		property21 = surface.loadImage("ParkLane.png");
		property22 = surface.loadImage("Mayfair.png");
		kingsCrossStation = surface.loadImage("KingsCrossStation.png");
		maryleboneStation = surface.loadImage("MaryleboneStation.png");
		fenchurchStStation = surface.loadImage("FenchurchStStation.png");
		liverpoolStreetStation = surface.loadImage("LiverpoolStreetStation.png");
		electricCompany = surface.loadImage("ElectricCompany.png");
		waterWorks = surface.loadImage("WaterWorks.png");

		freeParking = surface.loadImage("freeParking.png");
		incomeTax = surface.loadImage("incomeTax.png");
		superTax = surface.loadImage("superTax.png");

		house = surface.loadImage("house.png");
	}
/**
 * draws the board the players and the rest of the graphics
 */
	public void draw() {
		float xRatio = surface.width / 1200f;
		float yRatio = surface.height / 750f;
		surface.scale(xRatio, yRatio);
		surface.background(255);

		// players info
		surface.stroke(200);
		surface.fill(200);
		surface.rect(1000, 10, 170, 240);
		surface.fill(0);
		surface.text("PLAYER 1 INFO", 1010, 26);
		if (dog.stateOfGame() == 1) {
			surface.text("You have run the bank Dry!", 1005, 40);
			surface.stroke(300);
			surface.fill(200);
			surface.rect(995, 585, 90, 30);
			surface.fill(0);
			surface.text("GAME OVER!!", 1000, 600);
			return;
		} else {
			surface.text("Money left in bank: $" + dog.getCash(), 1005, 40);
			surface.text(dog.toString(), 1005, 50);
		}

		surface.stroke(180);
		surface.fill(180);
		surface.rect(1000, 260, 170, 240);
		surface.fill(0);
		surface.text("PLAYER 2 INFO", 1010, 276);
		if (thimble.stateOfGame() == 1) {
			surface.text("You have run the bank Dry!", 1005, 290);
			surface.stroke(300);
			surface.fill(200);
			surface.rect(995, 585, 90, 30);
			surface.fill(0);
			surface.text("GAME OVER!!", 1000, 600);
			return;
		} else {
			surface.text("Money left in bank: $" + thimble.getCash(), 1005, 290);
			surface.text(thimble.toString(), 1005, 300);
		}

		// Displays the board at point
		surface.image(img, 0, 0, 750, 720);

		// ROLL DICE
		surface.image(player1, path1BoardXCoordinates[total1], path1BoardYCoordinates[total1], 30, 30);
		surface.image(player2, path2BoardXCoordinates[total2], path2BoardYCoordinates[total2], 30, 30);

		surface.stroke(200);
		surface.fill(200);
		surface.rect(800, 10, 100, 40);
		surface.fill(0);
		surface.text("CLICK TO \n ROLL DICE", 810, 27);

		die1.drawStopped(surface, 800, 60);
		die2.drawStopped(surface, 865, 60);

		
		// DISPLAY PROPERTIES - PLAYER 1
		if (rollCount % 2 != 0) {
			if (total1 == 1) {
				surface.image(property1, 760, 140, 230, 400);
			} else if (total1 == 2) { //chest
				getExercise();
			} else if (total1 == 3) {
				surface.image(property2, 760, 140, 230, 400);
			} else if (total1 == 4) {
				surface.image(incomeTax, 760, 140, 230, 400);
			} else if (total1 == 5) {
				surface.image(kingsCrossStation, 760, 140, 230, 400);
			} else if (total1 == 6) {
				surface.image(property3, 760, 140, 230, 400);
			} else if (total1 == 7) { //chance
				getIceBreaker();
			} else if (total1 == 8) {
				surface.image(property4, 760, 140, 230, 400);
			} else if (total1 == 9) {
				surface.image(property5, 760, 140, 230, 400);
			} else if (total1 == 11) {
				surface.image(property6, 760, 140, 230, 400);
			} else if (total1 == 12) {
				surface.image(electricCompany, 760, 140, 230, 400);
			} else if (total1 == 13) {
				surface.image(property7, 760, 140, 230, 400);
			} else if (total1 == 14) {
				surface.image(property8, 760, 140, 230, 400);
			} else if (total1 == 15) {
				surface.image(maryleboneStation, 760, 140, 230, 400);
			} else if (total1 == 16) {
				surface.image(property9, 760, 140, 230, 400);
			} else if (total1 == 17) { //chest
				getExercise();
			} else if (total1 == 18) {
				surface.image(property10, 760, 140, 230, 400);
			} else if (total1 == 19) {
				surface.image(property11, 760, 140, 230, 400);
			}  else if (total1 == 20) {
				surface.image(freeParking, 760, 140, 230, 400);
			} else if (total1 == 21) {
				surface.image(property12, 760, 140, 230, 400);
			} else if (total1 == 22) { //chance
				getIceBreaker();
			} else if (total1 == 23) {
				surface.image(property13, 760, 140, 230, 400);
			} else if (total1 == 24) {
				surface.image(property14, 760, 140, 230, 400);
			} else if (total1 == 25) {
				surface.image(fenchurchStStation, 760, 140, 230, 400);
			} else if (total1 == 26) {
				surface.image(property15, 760, 140, 230, 400);
			} else if (total1 == 27) {
				surface.image(property16, 760, 140, 230, 400);
			} else if (total1 == 28) {
				surface.image(waterWorks, 760, 140, 230, 400);
			} else if (total1 == 29) {
				surface.image(property17, 760, 140, 230, 400);
			} else if (total1 == 30) {
				surface.fill(0);
				surface.text("You got into jail! you have \n" + dog.getInJail() + " turns left", 760, 140);
				if (isInJail1 == false) {
					isInJail1 = true;
					dog.setInJail(3);
				}
				isInJail1 = true;
			} else if (total1 == 31) {
				surface.image(property18, 760, 140, 230, 400);
			} else if (total1 == 32) {
				surface.image(property19, 760, 140, 230, 400);
			} else if (total1 == 33) { //chest
				getExercise();
			} else if (total1 == 34) {
				surface.image(property20, 760, 140, 230, 400);
			} else if (total1 == 35) {
				surface.image(liverpoolStreetStation, 760, 140, 230, 400);
			} else if (total1 == 36) { //chance
				getIceBreaker();
			} else if (total1 == 37) {
				surface.image(property21, 760, 140, 230, 400);
			} else if (total1 == 38) {
				surface.image(superTax, 760, 140, 230, 400);
			} else if (total1 == 39) {
				surface.image(property22, 760, 140, 230, 400);
			}
		}

		// DISPLAY PROPERTIES - PLAYER 2
		else {
			 
			if (total2 == 1) {
				surface.image(property1, 760, 140, 230, 400);
			} else if (total2 == 2) { // chest
				getExercise();
			} else if (total2 == 3) {
				surface.image(property2, 760, 140, 230, 400);
			} else if (total2 == 4) {
				surface.image(incomeTax, 760, 140, 230, 400);
			}  else if (total2 == 5) {
				surface.image(kingsCrossStation, 760, 140, 230, 400);
			} else if (total2 == 6) {
				surface.image(property3, 760, 140, 230, 400);
			} else if (total2 == 7) { //chance
				getIceBreaker();
			} else if (total2 == 8) {
				surface.image(property4, 760, 140, 230, 400);
			} else if (total2 == 9) {
				surface.image(property5, 760, 140, 230, 400);
			} else if (total2 == 11) {
				surface.image(property6, 760, 140, 230, 400);
			} else if (total2 == 12) {
				surface.image(electricCompany, 760, 140, 230, 400);
			} else if (total2 == 13) {
				surface.image(property7, 760, 140, 230, 400);
			} else if (total2 == 14) {
				surface.image(property8, 760, 140, 230, 400);
			} else if (total2 == 15) {
				surface.image(maryleboneStation, 760, 140, 230, 400);
			} else if (total2 == 16) {
				surface.image(property9, 760, 140, 230, 400);
			} else if (total2 == 17) { // chest
				getExercise();
			} else if (total2 == 18) {
				surface.image(property10, 760, 140, 230, 400);
			} else if (total2 == 19) {
				surface.image(property11, 760, 140, 230, 400);
			} else if (total2 == 20) {
				surface.image(freeParking, 760, 140, 230, 400);
			} else if (total2 == 21) {
				surface.image(property12, 760, 140, 230, 400);
			} else if (total2 == 22) { //chance
				getIceBreaker();
			} else if (total2 == 23) {
				surface.image(property13, 760, 140, 230, 400);
			} else if (total2 == 24) {
				surface.image(property14, 760, 140, 230, 400);
			} else if (total2 == 25) {
				surface.image(fenchurchStStation, 760, 140, 230, 400);
			} else if (total2 == 26) {
				surface.image(property15, 760, 140, 230, 400);
			} else if (total2 == 27) {
				surface.image(property16, 760, 140, 230, 400);
			} else if (total2 == 28) {
				surface.image(waterWorks, 760, 140, 230, 400);
			} else if (total2 == 29) {
				surface.image(property17, 760, 140, 230, 400);
			} else if (total2 == 30) {
				surface.fill(0);
				surface.text("You got into jail! you have \n" + thimble.getInJail() + " turns left", 760, 140);
				if (isInJail2 == false) {
					isInJail2 = true;
					thimble.setInJail(3);
				}
				isInJail2 = true;
			} else if (total2 == 31) {
				surface.image(property18, 760, 140, 230, 400);
			} else if (total2 == 32) {
				surface.image(property19, 760, 140, 230, 400);
			} else if (total2 == 33) { // chest
				getExercise();
			} else if (total2 == 34) {
				surface.image(property20, 760, 140, 230, 400);
			} else if (total2 == 35) {
				surface.image(liverpoolStreetStation, 760, 140, 230, 400);
			} else if (total2 == 36) { //chance
				getIceBreaker();
			} else if (total2 == 37) {
				surface.image(property21, 760, 140, 230, 400);
			} else if (total2 == 38) {
				surface.image(superTax, 760, 140, 230, 400);
			} else if (total2 == 39) {
				surface.image(property22, 760, 140, 230, 400);
			}
		}

		//DISPLAY HOUSES
		//0-9 BLOCKS
		if (kentHouse1) {
			surface.image(house, 605, 620, 20, 20);
		} if (whitechapelHouse1) {
			surface.image(house, 483, 620, 20, 20);
		} if (angelHouse1) {
			surface.image(house, 300, 620, 20, 20);
		} if (eustonHouse1) {
			surface.image(house, 178, 620, 20, 20);
		} if (pentonvilleHouse1) {
			surface.image(house, 117, 620, 20, 20);
		}
		//10-19 
		if (pallMallHouse1) {
			surface.image(house, 100, 582, 20, 20);
		} if (whitehallHouse1) {
			surface.image(house, 100, 466, 20, 20);
		} if (northHouse1) {
			surface.image(house, 100, 408, 20, 20);
		} if (bowHouse1) {
			surface.image(house, 100, 292, 20, 20);
		} if (malborughHouse1) {
			surface.image(house, 100, 176, 20, 20);
		} if (vineHouse1) {
			surface.image(house, 100, 118, 20, 20);
		}
		//20-29
		if (strandHouse1) {
			surface.image(house, 117, 95, 20, 20);
		} if (fleetHouse1) {
			surface.image(house, 239, 95, 20, 20);
		} if (trafalgarHouse1) {
			surface.image(house, 300, 95, 20, 20);
		} if (leiceHouse1) {
			surface.image(house, 422, 95, 20, 20);
		} if (coventryHouse1) {
			surface.image(house, 544, 95, 20, 20);
		} if (piccadillyHouse1) {
			surface.image(house, 605, 95, 20, 20);
		}
		//30-39
		if (regentHouse1) {
			surface.image(house, 630, 118, 20, 20);
		} if (oxfordHouse1) {
			surface.image(house, 630, 176, 20, 20);
		} if (bondHouse1) {
			surface.image(house, 630, 292, 20, 20);
		} if (parkHouse1) {
			surface.image(house, 630, 466, 20, 20);
		} if (mayHouse1) {
			surface.image(house, 630, 582, 20, 20);
		}
		
		// BUY PROPERTY & HOUSE & HOTEL
		surface.stroke(200);
		surface.fill(200);
		surface.rect(760, 680, 60, 40);
		surface.rect(830, 680, 60, 40);
		surface.rect(900, 680, 60, 40);
		surface.fill(0);
		surface.text("buy \n property", 767, 690);
		surface.text("buy \n house", 837, 690);
		surface.text("buy \n hotel", 907, 690);

	}
/**
 * starts the game and runs what should happen when each turn is played
 */
		public void mouseClicked() {
		if ((surface.mouseX >= 800 && surface.mouseX <= 880 && surface.mouseY >= 10 && surface.mouseY <= 50)/*&&(surface.mouseX >= 767 && surface.mouseX <= 907 && surface.mouseY >= 600 && surface.mouseY <= 700)*/) {
			// MOVE PLAYERS
			rollCount++;
			die1.roll();
			die2.roll();

			if (die1.getNumDots() == die2.getNumDots()) {
				rollCount--;
			}

			if (rollCount % 2 != 0) {
				if (dog.getInJail() == 0) {
					if (countDaysInJail1>=3) {
						dog.calculateMoney(-50);
						countDaysInJail1=0;
					}
					isInJail1 = false;
					total1 += die1.getNumDots() + die2.getNumDots();
					if (total1 >= 40) {
						total1 = total1 % 40;
						dog.calculateMoney(200);
					}
				} else {
					if (die1.getNumDots() == die2.getNumDots()) {
						dog.setInJail(0);
					} else {
						dog.setInJail(dog.getInJail() - 1);
						isInJail1 = true;
						countDaysInJail1++;
					}
				}

			} else {
				if (thimble.getInJail() == 0) {
					if (countDaysInJail2>=3) {
						thimble.calculateMoney(-50);
						countDaysInJail2=0;
					}
					isInJail2 = false;
					total2 += die1.getNumDots() + die2.getNumDots();
					if (total2 >= 40) {
						total2 = total2 % 40;
						thimble.calculateMoney(200);
					}
				} else {
					if (die1.getNumDots() == die2.getNumDots()) {
						thimble.setInJail(0);
					} else {
						thimble.setInJail(thimble.getInJail() - 1);
						isInJail2 = true;
						countDaysInJail2++;
					}
				}
			}
		}
		
		// PLAYER 1 PROPERTIES
		
		if (rollCount % 2 != 0) {
			if (total1 == 1) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && oldKentRoad.getOwner() == 0) {
					
					dog.calculateMoney(-60);
					oldKentRoad.setOwner(1);
					oldKentRoad.setRent(2);
					dog.addProperty(oldKentRoad);
				}
				if (oldKentRoad.getOwner() == 2) {
					dog.calculateMoney(-oldKentRoad.getRent());
					thimble.calculateMoney(oldKentRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && oldKentRoad.getOwner()==1) {
					dog.buyHouse(oldKentRoad);
					if (dog.getCanBuyHouse())
						kentHouse1 = true;
				}
			} else if (total1 == 2) {
				setExercise();
			} else if (total1 == 3) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && whitechapelRoad.getOwner() == 0) {
					dog.calculateMoney(-60);
					whitechapelRoad.setOwner(1);
					whitechapelRoad.setRent(4);
					dog.addProperty(whitechapelRoad);
				}
				if (whitechapelRoad.getOwner() == 2) {
					dog.calculateMoney(-whitechapelRoad.getRent());
					thimble.calculateMoney(whitechapelRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && whitechapelRoad.getOwner()==1) {
					dog.buyHouse(whitechapelRoad);
					if (dog.getCanBuyHouse())
						whitechapelHouse1 = true;
				}
			} else if (total1 == 4) {
				dog.calculateMoney(-200);
			} else if (total1 == 5) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && station1.getOwner() == 0) {
					dog.calculateMoney(-station1.getIntialCost());
					dog.setNumOfTrainStations(station1);
					station1.setOwner(1);
					station1.setTraionStationRent(dog.getNumOfTrainStations());
					dog.addProperty(station1);
				}
				if (station1.getOwner() == 2) {
					dog.calculateMoney(-station1.getRent());
					thimble.calculateMoney(station1.getRent());
				}
			} else if (total1 == 6) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && theAngelIslington.getOwner() == 0) {
					dog.calculateMoney(-100);
					theAngelIslington.setOwner(1);
					theAngelIslington.setRent(6);
					dog.addProperty(theAngelIslington);
				}
				if (theAngelIslington.getOwner() == 2) {
					dog.calculateMoney(-theAngelIslington.getRent());
					thimble.calculateMoney(theAngelIslington.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && theAngelIslington.getOwner()==1) {
					dog.buyHouse(theAngelIslington);
					if (dog.getCanBuyHouse())
						angelHouse1 = true;
				}
			} else if (total1 == 7) { //chance
				setIceBreaker();
			} else if (total1 == 8) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && eustonRoad.getOwner() == 0) {
					dog.calculateMoney(-100);
					eustonRoad.setOwner(1);
					eustonRoad.setRent(6);
					dog.addProperty(eustonRoad);
				}
				if (eustonRoad.getOwner() == 2) {
					dog.calculateMoney(-eustonRoad.getRent());
					thimble.calculateMoney(eustonRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && eustonRoad.getOwner()==1) {
					dog.buyHouse(eustonRoad);
					if (dog.getCanBuyHouse())
						eustonHouse1 = true;
				}
			} else if (total1 == 9) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && pentonvilleRoad.getOwner() == 0) {
					dog.calculateMoney(-120);
					pentonvilleRoad.setOwner(1);
					pentonvilleRoad.setRent(8);
					dog.addProperty(pentonvilleRoad);
				}
				if (pentonvilleRoad.getOwner() == 2) {
					dog.calculateMoney(-pentonvilleRoad.getRent());
					thimble.calculateMoney(pentonvilleRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && pentonvilleRoad.getOwner()==1) {
					dog.buyHouse(pentonvilleRoad);
					if (dog.getCanBuyHouse())
						pentonvilleHouse1 = true;
				}
			} else if (total1 == 11) {
				surface.image(property6, 760, 140, 230, 400);
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && pallMall.getOwner() == 0) {
					
					dog.calculateMoney(-pallMall.getIntialCost());
					pallMall.setOwner(1);
					pallMall.setRent(10);
					dog.addProperty(pallMall);
				}
				if (oldKentRoad.getOwner() == 2) {
					dog.calculateMoney(-pallMall.getRent());
					thimble.calculateMoney(pallMall.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && pallMall.getOwner()==1) {
					dog.buyHouse(pallMall);
					if (dog.getCanBuyHouse())
						pallMallHouse1 = true;
				}
			} else if (total1 == 12) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && electric.getOwner() == 0) {
					dog.calculateMoney(-electric.getIntialCost());
					dog.setNumOfUtilities(electric);
					electric.setOwner(1);
					electric.setUtilitiesRent(total1, dog.getNumOfUtilities());
					dog.addProperty(electric);
				}
				if (electric.getOwner() == 2) {
					dog.calculateMoney(-electric.getRent());
					thimble.calculateMoney(electric.getRent());
				}
			} else if (total1 == 13) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && whiteHall.getOwner() == 0) {
					dog.calculateMoney(-whiteHall.getIntialCost());
					whiteHall.setOwner(1);
					whiteHall.setRent(10);
					dog.addProperty(whiteHall);
				}
				if (whiteHall.getOwner() == 2) {
					dog.calculateMoney(-whiteHall.getRent());
					thimble.calculateMoney(whiteHall.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && whiteHall.getOwner()==1) {
					dog.buyHouse(whiteHall);
					if (dog.getCanBuyHouse())
						whitehallHouse1 = true;
				}
			} else if (total1 == 14) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && NorthumberlandAvenue.getOwner() == 0) {
					dog.calculateMoney(-NorthumberlandAvenue.getIntialCost());
					NorthumberlandAvenue.setOwner(1);
					NorthumberlandAvenue.setRent(12);
					dog.addProperty(NorthumberlandAvenue);
				}
				if (NorthumberlandAvenue.getOwner() == 2) {
					dog.calculateMoney(-NorthumberlandAvenue.getRent());
					thimble.calculateMoney(NorthumberlandAvenue.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && NorthumberlandAvenue.getOwner()==1) {
					dog.buyHouse(NorthumberlandAvenue);
					if (dog.getCanBuyHouse())
						northHouse1 = true;
				}
			} else if (total1 == 15) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && station2.getOwner() == 0) {
					dog.calculateMoney(-station2.getIntialCost());
					dog.setNumOfTrainStations(station2);
					station2.setOwner(1);
					station2.setTraionStationRent(dog.getNumOfTrainStations());
					dog.addProperty(station2);
				}
				if (station2.getOwner() == 2) {
					dog.calculateMoney(-station2.getRent());
					thimble.calculateMoney(station2.getRent());
				}
			} else if (total1 == 16) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && bowStreet.getOwner() == 0) {
					dog.calculateMoney(-bowStreet.getIntialCost());
					bowStreet.setOwner(1);
					bowStreet.setRent(14);
					dog.addProperty(bowStreet);
				}
				if (bowStreet.getOwner() == 2) {
					dog.calculateMoney(-bowStreet.getRent());
					thimble.calculateMoney(bowStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && bowStreet.getOwner()==1) {
					dog.buyHouse(bowStreet);
					if (dog.getCanBuyHouse())
						bowHouse1 = true;
				}
			} else if (total1 == 17) {
				setExercise();
			} else if (total1 == 18) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && MarlboroughStreet.getOwner() == 0) {
					dog.calculateMoney(-MarlboroughStreet.getIntialCost());
					MarlboroughStreet.setOwner(1);
					MarlboroughStreet.setRent(8);
					dog.addProperty(MarlboroughStreet);
				}
				if (MarlboroughStreet.getOwner() == 2) {
					dog.calculateMoney(-MarlboroughStreet.getRent());
					thimble.calculateMoney(MarlboroughStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && MarlboroughStreet.getOwner()==1) {
					dog.buyHouse(MarlboroughStreet);
					if (dog.getCanBuyHouse())
						malborughHouse1 = true;
				}
			} else if (total1 == 19) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && vineStreet.getOwner() == 0) {
					dog.calculateMoney(-vineStreet.getIntialCost());
					vineStreet.setOwner(1);
					vineStreet.setRent(16);
					dog.addProperty(vineStreet);
				}
				if (vineStreet.getOwner() == 2) {
					dog.calculateMoney(-vineStreet.getRent());
					thimble.calculateMoney(vineStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && vineStreet.getOwner()==1) {
					dog.buyHouse(vineStreet);
					if (dog.getCanBuyHouse())
						vineHouse1 = true;
				}
			} else if (total1 == 21) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && strand.getOwner() == 0) {
					dog.calculateMoney(-strand.getIntialCost());
					strand.setOwner(1);
					strand.setRent(18);
					dog.addProperty(strand);
				}
				if (strand.getOwner() == 2) {
					dog.calculateMoney(-strand.getRent());
					thimble.calculateMoney(strand.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && strand.getOwner()==1) {
					dog.buyHouse(strand);
					if (dog.getCanBuyHouse())
						strandHouse1 = true;
				}
			}
			else if (total1 == 22) { //chance
				setIceBreaker();
			} else if (total1 == 23) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 &&fleetStreet.getOwner() == 0) {
					dog.calculateMoney(-fleetStreet.getIntialCost());
					fleetStreet.setOwner(1);
					fleetStreet.setRent(18);
					dog.addProperty(fleetStreet);
				}
				if (fleetStreet.getOwner() == 2) {
					dog.calculateMoney(-fleetStreet.getRent());
					thimble.calculateMoney(fleetStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && fleetStreet.getOwner()==1) {
					dog.buyHouse(fleetStreet);
					if (dog.getCanBuyHouse())
						fleetHouse1 = true;
				}
			} else if (total1 == 24) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && trafalgarSquare.getOwner() == 0) {		
					dog.calculateMoney(-trafalgarSquare.getIntialCost());
					trafalgarSquare.setOwner(1);
					trafalgarSquare.setRent(20);
					dog.addProperty(trafalgarSquare);
				}
				if (trafalgarSquare.getOwner() == 2) {
					dog.calculateMoney(-trafalgarSquare.getRent());
					thimble.calculateMoney(trafalgarSquare.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && trafalgarSquare.getOwner()==1) {
					dog.buyHouse(trafalgarSquare);
					if (dog.getCanBuyHouse())
						trafalgarHouse1 = true;
				}
			} else if (total1 == 25) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && station3.getOwner() == 0) {
					dog.calculateMoney(-station3.getIntialCost());
					dog.setNumOfTrainStations(station3);
					station3.setOwner(1);
					station3.setTraionStationRent(dog.getNumOfTrainStations());
					dog.addProperty(station3);
				}
				if (station3.getOwner() == 2) {
					dog.calculateMoney(-station3.getRent());
					thimble.calculateMoney(station3.getRent());
				}
			} else if (total1 == 26) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && leicesterSquare.getOwner() == 0) {
					dog.calculateMoney(-leicesterSquare.getIntialCost());
					leicesterSquare.setOwner(1);
					leicesterSquare.setRent(22);
					dog.addProperty(leicesterSquare);
				}
				if (leicesterSquare.getOwner() == 2) {
					dog.calculateMoney(-leicesterSquare.getRent());
					thimble.calculateMoney(leicesterSquare.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && leicesterSquare.getOwner()==1) {
					dog.buyHouse(leicesterSquare);
					if (dog.getCanBuyHouse())
						leiceHouse1 = true;
				}
			} else if (total1 == 27) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && coventryStreet.getOwner() == 0) {
					dog.calculateMoney(-coventryStreet.getIntialCost());
					coventryStreet.setOwner(1);
					coventryStreet.setRent(22);
					dog.addProperty(coventryStreet);
				}
				if (coventryStreet.getOwner() == 2) {
					dog.calculateMoney(-coventryStreet.getRent());
					thimble.calculateMoney(coventryStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && coventryStreet.getOwner()==1) {
					dog.buyHouse(coventryStreet);
					if (dog.getCanBuyHouse())
						coventryHouse1 = true;
				}
			} else if (total1 == 28) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && water.getOwner() == 0) {
					dog.calculateMoney(-water.getIntialCost());
					dog.setNumOfUtilities(water);
					water.setOwner(1);
					water.setUtilitiesRent(total1, dog.getNumOfUtilities());
					dog.addProperty(water);
				}
				if (water.getOwner() == 2) {
					dog.calculateMoney(-strand.getRent());
					thimble.calculateMoney(strand.getRent());
				}
			} else if (total1 == 29) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && piccadilly.getOwner() == 0) {
					dog.calculateMoney(-piccadilly.getIntialCost());
					piccadilly.setOwner(1);
					piccadilly.setRent(22);
					dog.addProperty(piccadilly);
				}
				if (piccadilly.getOwner() == 2) {
					dog.calculateMoney(-piccadilly.getRent());
					thimble.calculateMoney(piccadilly.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && piccadilly.getOwner()==1) {
					dog.buyHouse(piccadilly);
					if (dog.getCanBuyHouse())
						piccadillyHouse1 = true;
				}
			} else if (total1 == 30) {
			
			} else if (total1 == 31) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && regentStreet.getOwner() == 0) {	
					dog.calculateMoney(-regentStreet.getIntialCost());
					regentStreet.setOwner(1);
					regentStreet.setRent(26);
					dog.addProperty(regentStreet);
				}
				if (regentStreet.getOwner() == 2) {
					dog.calculateMoney(-regentStreet.getRent());
					thimble.calculateMoney(regentStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && regentStreet.getOwner()==1) {
					dog.buyHouse(regentStreet);
					if (dog.getCanBuyHouse())
						regentHouse1 = true;
				}
			} else if (total1 == 32) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && oxfordStreet.getOwner() == 0) {
					dog.calculateMoney(-oxfordStreet.getIntialCost());
					oxfordStreet.setOwner(1);
					oxfordStreet.setRent(26);
					dog.addProperty(oxfordStreet);
				}
				if (oxfordStreet.getOwner() == 2) {
					dog.calculateMoney(-oxfordStreet.getRent());
					thimble.calculateMoney(oxfordStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && oxfordStreet.getOwner()==1) {
					dog.buyHouse(oxfordStreet);
					if (dog.getCanBuyHouse())
						oxfordHouse1 = true;
				}
			} else if (total1 == 33) {
				setExercise();
			} else if (total1 == 34) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && bondStreet.getOwner() == 0) {
					dog.calculateMoney(-bondStreet.getIntialCost());
					bondStreet.setOwner(1);
					bondStreet.setRent(28);
					dog.addProperty(bondStreet);
				}
				if (bondStreet.getOwner() == 2) {
					dog.calculateMoney(-bondStreet.getRent());
					thimble.calculateMoney(bondStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && bondStreet.getOwner()==1) {
					dog.buyHouse(bondStreet);
					if (dog.getCanBuyHouse())
						bondHouse1 = true;
				}
			} else if (total1 == 35) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && station4.getOwner() == 0) {
					dog.calculateMoney(-station4.getIntialCost());
					dog.setNumOfTrainStations(station4);
					station4.setOwner(1);
					station4.setTraionStationRent(dog.getNumOfTrainStations());
					dog.addProperty(station4);
				}
				if (station4.getOwner() == 2) {
					dog.calculateMoney(-station4.getRent());
					thimble.calculateMoney(station4.getRent());
				}
			} else if (total1 == 36) { //chance
				setIceBreaker();
			} else if (total1 == 37) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && parkLane.getOwner() == 0) {
					dog.calculateMoney(-parkLane.getIntialCost());
					parkLane.setOwner(1);
					parkLane.setRent(35);
					dog.addProperty(parkLane);
				}
				if (parkLane.getOwner() == 2) {
					dog.calculateMoney(-parkLane.getRent());
					thimble.calculateMoney(parkLane.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && parkLane.getOwner()==1) {
					dog.buyHouse(parkLane);
					if (dog.getCanBuyHouse())
						parkHouse1 = true;
				}
			} else if (total1 == 38) {
				dog.calculateMoney(-100);
			} else if (total1 == 39) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && mayfair.getOwner() == 0) {
					dog.calculateMoney(-mayfair.getIntialCost());
					mayfair.setOwner(1);
					mayfair.setRent(50);
					dog.addProperty(mayfair);
				}
				if (mayfair.getOwner() == 2) {
					dog.calculateMoney(-mayfair.getRent());
					thimble.calculateMoney(mayfair.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && mayfair.getOwner()==1) {
					dog.buyHouse(mayfair);
					if (dog.getCanBuyHouse())
						mayHouse1 = true;
				}
			}
		}

		// PLAYER 2 PROPERTIES
		else {
			if (total2 == 1) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && oldKentRoad.getOwner() == 0) {
					thimble.calculateMoney(-60);
					oldKentRoad.setOwner(2);
					oldKentRoad.setRent(2);
					thimble.addProperty(oldKentRoad);
				}
				if (oldKentRoad.getOwner() == 1) {
					thimble.calculateMoney(-oldKentRoad.getRent());
					dog.calculateMoney(oldKentRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && oldKentRoad.getOwner()==2) {
					thimble.buyHouse(oldKentRoad);
					if (thimble.getCanBuyHouse())
						kentHouse1 = true;
				}
			} else if (total2 == 2) { // chest
				setExercise();
			} else if (total2 == 3) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && whitechapelRoad.getOwner() == 0) {	
					thimble.calculateMoney(-60);
					whitechapelRoad.setOwner(2);
					whitechapelRoad.setRent(4);
					thimble.addProperty(whitechapelRoad);
				}
				if (whitechapelRoad.getOwner() == 1) {
					thimble.calculateMoney(-whitechapelRoad.getRent());
					dog.calculateMoney(whitechapelRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && whitechapelRoad.getOwner()==2) {
					thimble.buyHouse(whitechapelRoad);
					if (thimble.getCanBuyHouse())
						whitechapelHouse1 = true;
				}
			} else if (total2 == 4) {
				thimble.calculateMoney(-200);
			} else if (total2 == 5) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && station1.getOwner() == 0) {
					thimble.calculateMoney(-station1.getIntialCost());
					thimble.setNumOfTrainStations(station1);
					station1.setOwner(2);
					station1.setTraionStationRent(thimble.getNumOfTrainStations());
					thimble.addProperty(station1);
				}
				if (station1.getOwner() == 1) {
					thimble.calculateMoney(-station1.getRent());
					dog.calculateMoney(station1.getRent());
				}
			} else if (total2 == 6) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && theAngelIslington.getOwner() == 0) {
					thimble.calculateMoney(-100);
					theAngelIslington.setOwner(2);
					theAngelIslington.setRent(6);
					thimble.addProperty(theAngelIslington);
				}
				if (theAngelIslington.getOwner() == 1) {
					thimble.calculateMoney(-theAngelIslington.getRent());
					dog.calculateMoney(theAngelIslington.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && theAngelIslington.getOwner()==2) {
					thimble.buyHouse(theAngelIslington);
					if (thimble.getCanBuyHouse())
						angelHouse1 = true;
				}
			} else if (total2 == 7) { //chance
				setIceBreaker();
			} else if (total2 == 8) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && eustonRoad.getOwner() == 0) {	
					thimble.calculateMoney(-100);
					eustonRoad.setOwner(2);
					eustonRoad.setRent(6);
					thimble.addProperty(eustonRoad);
				}
				if (eustonRoad.getOwner() == 1) {
					thimble.calculateMoney(-eustonRoad.getRent());
					dog.calculateMoney(eustonRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && eustonRoad.getOwner()==2) {
					thimble.buyHouse(eustonRoad);
					if (thimble.getCanBuyHouse())
						eustonHouse1 = true;
				}
			} else if (total2 == 9) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && pentonvilleRoad.getOwner() == 0) {
					thimble.calculateMoney(-120);
					pentonvilleRoad.setOwner(2);
					pentonvilleRoad.setRent(8);
					thimble.addProperty(pentonvilleRoad);
				}
				if (pentonvilleRoad.getOwner() == 1) {
					thimble.calculateMoney(-pentonvilleRoad.getRent());
					dog.calculateMoney(pentonvilleRoad.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && pentonvilleRoad.getOwner()==2) {
					thimble.buyHouse(pentonvilleRoad);
					if (thimble.getCanBuyHouse())
						pentonvilleHouse1 = true;
				}
			} else if (total2 == 11) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && pallMall.getOwner() == 0) {
					thimble.calculateMoney(-pallMall.getIntialCost());
					pallMall.setOwner(2);
					pallMall.setRent(10);
					thimble.addProperty(pallMall);
				}
				if (pallMall.getOwner() == 1) {
					thimble.calculateMoney(-pallMall.getRent());
					dog.calculateMoney(pallMall.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && pallMall.getOwner()==2) {
					thimble.buyHouse(pallMall);
					if (thimble.getCanBuyHouse())
						pallMallHouse1 = true;
				}
			} else if (total2 == 12) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && electric.getOwner() == 0) {
					thimble.calculateMoney(-electric.getIntialCost());
					thimble.setNumOfUtilities(electric);
					electric.setOwner(2);
					electric.setUtilitiesRent(total2, thimble.getNumOfUtilities());
					thimble.addProperty(electric);
				}
				if (electric.getOwner() == 1) {
					thimble.calculateMoney(-electric.getRent());
					dog.calculateMoney(electric.getRent());
				}
			} else if (total2 == 13) {
				surface.image(property7, 760, 140, 230, 400);
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && whiteHall.getOwner() == 0) {
					thimble.calculateMoney(-whiteHall.getIntialCost());
					whiteHall.setOwner(2);
					whiteHall.setRent(10);
					thimble.addProperty(whiteHall);
				}
				if (whiteHall.getOwner() == 1) {
					thimble.calculateMoney(-whiteHall.getRent());
					dog.calculateMoney(whiteHall.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && whiteHall.getOwner()==2) {
					thimble.buyHouse(whiteHall);
					if (thimble.getCanBuyHouse())
						whitehallHouse1 = true;
				}
			} else if (total2 == 14) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && NorthumberlandAvenue.getOwner()==0) {
					thimble.calculateMoney(-NorthumberlandAvenue.getIntialCost());
					NorthumberlandAvenue.setOwner(2);
					NorthumberlandAvenue.setRent(12);
					thimble.addProperty(NorthumberlandAvenue);
				}
				if (NorthumberlandAvenue.getOwner() == 1) {
					thimble.calculateMoney(-NorthumberlandAvenue.getRent());
					dog.calculateMoney(NorthumberlandAvenue.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && NorthumberlandAvenue.getOwner()==2) {
					thimble.buyHouse(NorthumberlandAvenue);
					if (thimble.getCanBuyHouse())
						northHouse1 = true;
				}
			} else if (total2 == 15) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && station2.getOwner() == 0) {
					thimble.calculateMoney(-station2.getIntialCost());
					thimble.setNumOfTrainStations(station2);
					station2.setOwner(2);
					station2.setTraionStationRent(thimble.getNumOfTrainStations());
					thimble.addProperty(station2);
				}
				if (station2.getOwner() == 1) {
					thimble.calculateMoney(-station2.getRent());
					dog.calculateMoney(station2.getRent());
				}
			} else if (total2 == 16) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && bowStreet.getOwner() == 0) {
					thimble.calculateMoney(-bowStreet.getIntialCost());
					bowStreet.setOwner(2);
					bowStreet.setRent(14);
					thimble.addProperty(bowStreet);
				}
				if (bowStreet.getOwner() == 1) {
					thimble.calculateMoney(-bowStreet.getRent());
					dog.calculateMoney(bowStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && bowStreet.getOwner()==2) {
					thimble.buyHouse(bowStreet);
					if (thimble.getCanBuyHouse())
						bowHouse1 = true;
				}
			} else if (total2 == 17) { // chest
				setExercise();
			} else if (total2 == 18) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && MarlboroughStreet.getOwner() == 0) {
					thimble.calculateMoney(-MarlboroughStreet.getIntialCost());
					MarlboroughStreet.setOwner(2);
					MarlboroughStreet.setRent(8);
					thimble.addProperty(MarlboroughStreet);
				}
				if (MarlboroughStreet.getOwner() == 1) {
					thimble.calculateMoney(-MarlboroughStreet.getRent());
					dog.calculateMoney(MarlboroughStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && MarlboroughStreet.getOwner()==2) {
					thimble.buyHouse(MarlboroughStreet);
					if (thimble.getCanBuyHouse())
						malborughHouse1 = true;
				}
			} else if (total2 == 19) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && vineStreet.getOwner() == 0) {
					thimble.calculateMoney(-vineStreet.getIntialCost());
					vineStreet.setOwner(2);
					vineStreet.setRent(16);
					thimble.addProperty(vineStreet);
				}
				if (vineStreet.getOwner() == 1) {
					thimble.calculateMoney(-vineStreet.getRent());
					dog.calculateMoney(vineStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && vineStreet.getOwner()==2) {
					thimble.buyHouse(vineStreet);
					if (thimble.getCanBuyHouse())
						vineHouse1 = true;
				}
			} else if (total2 == 21) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && strand.getOwner() == 0) {
					thimble.calculateMoney(-strand.getIntialCost());
					strand.setOwner(2);
					strand.setRent(18);
					thimble.addProperty(strand);
				}
				if (strand.getOwner() == 1) {
					thimble.calculateMoney(-strand.getRent());
					dog.calculateMoney(strand.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && strand.getOwner()==2) {
					thimble.buyHouse(strand);
					if (thimble.getCanBuyHouse())
						strandHouse1 = true;
				}
			} else if (total2 == 22) { //chance
				setIceBreaker();
			} else if (total2 == 23) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && fleetStreet.getOwner() == 0) {
					thimble.calculateMoney(-fleetStreet.getIntialCost());
					fleetStreet.setOwner(2);
					fleetStreet.setRent(18);
					thimble.addProperty(fleetStreet);
				}
				if (fleetStreet.getOwner() == 1) {
					thimble.calculateMoney(-fleetStreet.getRent());
					dog.calculateMoney(fleetStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && fleetStreet.getOwner()==2) {
					thimble.buyHouse(fleetStreet);
					if (thimble.getCanBuyHouse())
						fleetHouse1 = true;
				}
			} else if (total2 == 24) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && trafalgarSquare.getOwner() == 0) {
					thimble.calculateMoney(-trafalgarSquare.getIntialCost());
					trafalgarSquare.setOwner(2);
					trafalgarSquare.setRent(20);
					thimble.addProperty(trafalgarSquare);
				}
				if (trafalgarSquare.getOwner() == 1) {
					thimble.calculateMoney(-trafalgarSquare.getRent());
					dog.calculateMoney(trafalgarSquare.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && trafalgarSquare.getOwner()==2) {
					thimble.buyHouse(trafalgarSquare);
					if (thimble.getCanBuyHouse())
						trafalgarHouse1 = true;
				}
			} else if (total2 == 25) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && station3.getOwner() == 0) {
					thimble.calculateMoney(-station3.getIntialCost());
					thimble.setNumOfTrainStations(station3);
					station3.setOwner(2);
					station3.setTraionStationRent(thimble.getNumOfTrainStations());
					thimble.addProperty(station3);
				}
				if (station3.getOwner() == 1) {
					thimble.calculateMoney(-station3.getRent());
					dog.calculateMoney(station3.getRent());
				}
			} else if (total2 == 26) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && leicesterSquare.getOwner() == 0) {
					thimble.calculateMoney(-leicesterSquare.getIntialCost());
					leicesterSquare.setOwner(2);
					leicesterSquare.setRent(22);
					thimble.addProperty(leicesterSquare);
				}
				if (leicesterSquare.getOwner() == 1) {
					thimble.calculateMoney(-leicesterSquare.getRent());
					dog.calculateMoney(leicesterSquare.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && leicesterSquare.getOwner()==2) {
					thimble.buyHouse(leicesterSquare);
					if (thimble.getCanBuyHouse())
						leiceHouse1 = true;
				}
			} else if (total2 == 27) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && coventryStreet.getOwner() == 0) {
					thimble.calculateMoney(-coventryStreet.getIntialCost());
					coventryStreet.setOwner(2);
					coventryStreet.setRent(22);
					thimble.addProperty(coventryStreet);
				}
				if (coventryStreet.getOwner() == 1) {
					thimble.calculateMoney(-coventryStreet.getRent());
					dog.calculateMoney(coventryStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && coventryStreet.getOwner()==2) {
					thimble.buyHouse(coventryStreet);
					if (thimble.getCanBuyHouse())
						coventryHouse1 = true;
				}
			} else if (total2 == 28) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820 && surface.mouseY>=500 && water.getOwner() == 0) {
					thimble.calculateMoney(-water.getIntialCost());
					thimble.setNumOfUtilities(water);
					water.setOwner(2);
					water.setUtilitiesRent(total2, thimble.getNumOfUtilities());
					thimble.addProperty(water);
				}
				if (water.getOwner() == 1) {
					thimble.calculateMoney(-water.getRent());
					dog.calculateMoney(water.getRent());
				}
			} else if (total2 == 29) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && piccadilly.getOwner() == 0) {
					thimble.calculateMoney(-piccadilly.getIntialCost());
					piccadilly.setOwner(2);
					piccadilly.setRent(22);
					thimble.addProperty(piccadilly);
				}
				if (piccadilly.getOwner() == 1) {
					thimble.calculateMoney(-piccadilly.getRent());
					dog.calculateMoney(piccadilly.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && piccadilly.getOwner()==2) {
					thimble.buyHouse(piccadilly);
					if (thimble.getCanBuyHouse())
						piccadillyHouse1 = true;
				}
			} else if (total2 == 30) {
				
			} else if (total2 == 31) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && regentStreet.getOwner() == 0) {	
					thimble.calculateMoney(-regentStreet.getIntialCost());
					regentStreet.setOwner(2);
					regentStreet.setRent(26);
					thimble.addProperty(regentStreet);
				}
				if (regentStreet.getOwner() == 1) {
					thimble.calculateMoney(-regentStreet.getRent());
					dog.calculateMoney(regentStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && regentStreet.getOwner()==2) {
					thimble.buyHouse(regentStreet);
					if (thimble.getCanBuyHouse())
						regentHouse1 = true;
				}
			} else if (total2 == 32) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && oxfordStreet.getOwner() == 0) {
					thimble.calculateMoney(-oxfordStreet.getIntialCost());
					oxfordStreet.setOwner(2);
					oxfordStreet.setRent(26);
					thimble.addProperty(oxfordStreet);
				}
				if (oxfordStreet.getOwner() == 1) {
					thimble.calculateMoney(-oxfordStreet.getRent());
					dog.calculateMoney(oxfordStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && oxfordStreet.getOwner()==2) {
					thimble.buyHouse(oxfordStreet);
					if (thimble.getCanBuyHouse())
						oxfordHouse1 = true;
				}
			} else if (total2 == 33) { // chest
				setExercise();
			} else if (total2 == 34) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && bondStreet.getOwner() == 0) {
					thimble.calculateMoney(-bondStreet.getIntialCost());
					bondStreet.setOwner(2);
					bondStreet.setRent(28);
					thimble.addProperty(bondStreet);
				}
				if (bondStreet.getOwner() == 1) {
					thimble.calculateMoney(-bondStreet.getRent());
					dog.calculateMoney(bondStreet.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && bondStreet.getOwner()==2) {
					thimble.buyHouse(bondStreet);
					if (thimble.getCanBuyHouse())
						bondHouse1 = true;
				}
			} else if (total2 == 35) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && station4.getOwner() == 0) {
					thimble.calculateMoney(-station4.getIntialCost());
					thimble.setNumOfTrainStations(station4);
					station4.setOwner(2);
					station4.setTraionStationRent(thimble.getNumOfTrainStations());
					thimble.addProperty(station4);
				}
				if (station4.getOwner() == 1) {
					thimble.calculateMoney(-station4.getRent());
					dog.calculateMoney(station4.getRent());
				}
			} else if (total2 == 36) { //chance
				setIceBreaker();
			} else if (total2 == 37) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && parkLane.getOwner() == 0) {
					thimble.calculateMoney(-parkLane.getIntialCost());
					parkLane.setOwner(2);
					parkLane.setRent(35);
					thimble.addProperty(parkLane);
				}
				if (parkLane.getOwner() == 1) {
					thimble.calculateMoney(-parkLane.getRent());
					dog.calculateMoney(parkLane.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && parkLane.getOwner()==2) {
					thimble.buyHouse(parkLane);
					if (thimble.getCanBuyHouse())
						parkHouse1 = true;
				}
			} else if (total2 == 38) {
				thimble.calculateMoney(-100);
			} else if (total2 == 39) {
				if (surface.mouseX >= 760 && surface.mouseX <= 820  && surface.mouseY>=500 && mayfair.getOwner() == 0) {
					thimble.calculateMoney(-mayfair.getIntialCost());
					mayfair.setOwner(2);
					mayfair.setRent(50);
					thimble.addProperty(mayfair);
				}
				if (mayfair.getOwner() == 1) {
					thimble.calculateMoney(-mayfair.getRent());
					dog.calculateMoney(mayfair.getRent());
				}
				if (surface.mouseX >= 830 && surface.mouseX <= 890 && surface.mouseY>=500 && mayfair.getOwner()==2) {
					thimble.buyHouse(mayfair);
					if (thimble.getCanBuyHouse())
						mayHouse1 = true;
				}
			}
		}
		
		//CHECK OF A PLAYER OWNS ALL THE PROPERTIES FROM THE SAME COLOR
		
		if (dog.getNumOfHouses()==0 && thimble.getNumOfHouses()==0) {
			//BROWN PROPERTIES
			if (dog.canBuyHouse(oldKentRoad) || thimble.canBuyHouse(oldKentRoad)) {
				oldKentRoad.setRent(6);
				whitechapelRoad.setRent(12);
			}
			//LIGHT BLUE PROPERTIES
			if (dog.canBuyHouse(eustonRoad)|| thimble.canBuyHouse(eustonRoad)) {
				theAngelIslington.setRent(15);
				eustonRoad.setRent(15);
				pentonvilleRoad.setRent(22);
			}
			//PINK PROPERTIES
			if (dog.canBuyHouse(pallMall)|| thimble.canBuyHouse(pallMall)) {
				pallMall.setRent(35);
				whiteHall.setRent(35);
				NorthumberlandAvenue.setRent(45);
			}
			//ORAANGE PROPERTIES
			if (dog.canBuyHouse(bowStreet)|| thimble.canBuyHouse(bowStreet)) {
				bowStreet.setRent(50);
				MarlboroughStreet.setRent(50);
				vineStreet.setRent(55);
			}
			//RED PROPERTIES
			if (dog.canBuyHouse(strand)|| thimble.canBuyHouse(strand)) {
				strand.setRent(72);
				fleetStreet.setRent(72);
				trafalgarSquare.setRent(80);
			}
			//YELLOW PROPERTIES
			if (dog.canBuyHouse(piccadilly)|| thimble.canBuyHouse(piccadilly)) {
				leicesterSquare.setRent(97);
				coventryStreet.setRent(97);
				piccadilly.setRent(105);
			}
			//GREEN PROPERTIES
			if (dog.canBuyHouse(bondStreet)|| thimble.canBuyHouse(bondStreet)) {
				regentStreet.setRent(110);
				oxfordStreet.setRent(110);
				bondStreet.setRent(122);
			}
			//BLUE PROPERTIES
			if (dog.canBuyHouse(parkLane)|| thimble.canBuyHouse(parkLane)) {
				parkLane.setRent(150);
				mayfair.setRent(180);
			}
		}
	}	
	
	
	/**
	 * sets the current iceBrakerCount so that an ice breaker card can be presented
	 */
		private void setIceBreaker() {
			iceBreakerCount++;
			//for player 1
			if (rollCount %2 != 0) {
				if (iceBreakerCount==1) {
					dog.calculateMoney(100);
				}else if(iceBreakerCount==2) {
					dog.calculateMoney(50);
				}else if(iceBreakerCount==3) {
					thimble.calculateMoney(100);
				}else if(iceBreakerCount==4) {
					dog.calculateMoney(30);
				}else if(iceBreakerCount==5) {
					dog.calculateMoney(75);
				}else if(iceBreakerCount==6) {
					dog.calculateMoney(50);
				}else if(iceBreakerCount==7) {
					thimble.calculateMoney(25);
				}else if(iceBreakerCount==8) {
					dog.calculateMoney(30);
				}else if(iceBreakerCount==9) {
					dog.calculateMoney(35);
				}else if(iceBreakerCount==10) {
					dog.calculateMoney(50);
					thimble.calculateMoney(50);
					iceBreakerCount = 0;
				}
			}
			//for player 2
			else {
				if (iceBreakerCount==1) {
					thimble.calculateMoney(100);
				}else if(iceBreakerCount==2) {
					thimble.calculateMoney(50);
				}else if(iceBreakerCount==3) {
					dog.calculateMoney(100);
				}else if(iceBreakerCount==4) {
					thimble.calculateMoney(30);
				}else if(iceBreakerCount==5) {
					thimble.calculateMoney(75);
				}else if(iceBreakerCount==6) {
					thimble.calculateMoney(50);
				}else if(iceBreakerCount==7) {
					dog.calculateMoney(25);
				}else if(iceBreakerCount==8) {
					thimble.calculateMoney(30);
				}else if(iceBreakerCount==9) {
					thimble.calculateMoney(35);
				}else if(iceBreakerCount==10) {
					dog.calculateMoney(50);
					thimble.calculateMoney(50);
					iceBreakerCount = 0;
				}
			}
		}
		
	
		/**
		 * gets the current iceBrakerCount so that the text on the card 
		 * can be printed out to the player
		 */
		public String getIceBreaker() {
			surface.fill(0);
			String a="";
			if (iceBreakerCount == 1) {
				a = funnyJoke.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 2) {
				a = backStory.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 3) {
				a = makeLaugh.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 4) {
				a = favoriteFood.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 5) {
				a = dreamDestination.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 6) {
				a = story.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 7) {
				a = personality.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 8) {
				a = favoriteHobby.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 9) {
				a = advice.getName();
				surface.text(a, 760, 140);
			} else if (iceBreakerCount == 10) {
				a = foodDebate.getName();
				surface.text(a, 760, 140);
				iceBreakerCount = 0;
			}
			return a;
		}
		/**
		 * sets the current exerciseCount so that an exercise card can be presented
		 */
		public void setExercise(){
		exerciseCount++;
		//for player 1
		if (rollCount %2 != 0) {
				if (exerciseCount == 1) {
					dog.calculateMoney(100);
				} else if (exerciseCount == 2) {
					dog.calculateMoney(50);
				} else if (exerciseCount == 3) {
					dog.calculateMoney(25);
				} else if (exerciseCount == 4) {
					dog.calculateMoney(60);
				} else if (exerciseCount == 5) {
					dog.calculateMoney(150);
				} else if (exerciseCount == 6) {
					dog.calculateMoney(40);
				} else if (exerciseCount == 7) {
					dog.calculateMoney(50);
				} else if (exerciseCount == 8) {
					dog.calculateMoney(35);
				} else if (exerciseCount == 9) {
					dog.calculateMoney(40);
				} else if (exerciseCount == 10) {
					dog.calculateMoney(100);
					exerciseCount = 0;
				}
			}
			//for player 2
			else {
				if (exerciseCount == 1) {
					thimble.calculateMoney(100);
				} else if (exerciseCount == 2) {
					thimble.calculateMoney(50);
				} else if (exerciseCount == 3) {
					thimble.calculateMoney(25);
				} else if (exerciseCount == 4) {
					thimble.calculateMoney(60);
				} else if (exerciseCount == 5) {
					thimble.calculateMoney(150);
				} else if (exerciseCount == 6) {
					thimble.calculateMoney(40);
				} else if (exerciseCount == 7) {
					thimble.calculateMoney(50);
				} else if (exerciseCount == 8) {
					thimble.calculateMoney(35);
				} else if (exerciseCount == 9) {
					thimble.calculateMoney(40);
				} else if (exerciseCount == 10) {
					thimble.calculateMoney(100);
					exerciseCount = 0;
				}
			}
		}


		/**
		 * gets the current exerciseCount so that the text on the card 
		 * can be printed out to the player
		 */
		private String getExercise() {
			surface.fill(0);
			String a="";
			if (exerciseCount == 1) {
				a = pushups.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 2) {
				a = plank.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 3) {
				a = jumpingJacks.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 4) {
				a = crunches.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 5) {
				a = pushups2.getName(); 
				surface.text(a, 760, 140);
			} else if (exerciseCount == 6) {
				a = squats.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 7) {
				a = mountainClimbers.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 8) {
				a = chairDips.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 9) {
				a = ankleRaises.getName();
				surface.text(a, 760, 140);
			} else if (exerciseCount == 10) {
				a = burpees.getName();
				surface.text(a, 760, 140);
				exerciseCount=0;
			}
			return a;

		}
}
