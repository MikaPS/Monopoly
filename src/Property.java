import java.util.ArrayList;
import java.util.Random;

import processing.core.PImage;
/**
 * @author Mika Peer, Nitzan Shachar
 * @version 5/26/2020
 * 
 * represents a property object
 */

public class Property {

	private String name;
	private int rent;
	private int owner;
	private int numOfHouses;
	private int intialCost;
	private boolean hasHotel;
	private String color;
	private int costPerHouse;
	private int rentWithHouse;
	
	public Property(String name, int intialCost, int numOfHouses, boolean hasHotel, int owner, String color, int costPerHouse, int rentWithHouse) {
		this.name = name;
		this.intialCost = intialCost;
		this.numOfHouses = numOfHouses;
		this.hasHotel = hasHotel;
		this.owner = owner;
		this.color = color;
		this.costPerHouse = costPerHouse;
		this.rentWithHouse = rentWithHouse;
	}
	
	/**
	 * 
	 * @return the initial cost of a property
	 */
	public int getIntialCost() {
		return intialCost;
	}
	
	/**
	 * sets the owner of a property
	 * @param o int that represent the player that owns the property
	 */
	public void setOwner(int o) {
		if (owner==0)
			owner = o;
	}
	
	/**
	 * 
	 * @return int that represent the player that owns the property
	 */
	public int getOwner() {
		return owner;
	}
	
	/**
	 * set number of houses on a property
	 * @param num int that represents the amount of houses
	 */
	public void setNumOfHouses(int num) {
		numOfHouses = num;
	}
	
	/**
	 * set the rent of a property 
	 * @param rent int that represents the rent
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	/**
	 * check how many train stations a player owns and set the rent based on that
	 * @param numOfTrains the number of train stations a player has
	 */
	public void setTraionStationRent(int numOfTrains) {
		if (numOfTrains==1) {
			rent=25;
		}
		else if (numOfTrains==2) {
			rent=50;
		}
		else if (numOfTrains==3) {
			rent=100;
		}
		else if (numOfTrains==4) {
			rent=200;
		}
	}
	
	/**
	 * check how many utilities a player owns and set the rent based on that
	 * @param diceTotal the number that was given from the last roll of dice
	 * @param numOfUtilities the number of utilities a player has
	 */
	public void setUtilitiesRent(int diceTotal, int numOfUtilities) {
		if (numOfUtilities==1) {
			rent = diceTotal*4;
		}
		else if (numOfUtilities==2) {
			rent = diceTotal*10;
		}
	}
	
	/**
	 * 
	 * @return int rent of a property
	 */
	public int getRent() {
		return rent;
	}
	
	public int getRentWithHouse() {
		return rentWithHouse;
	}
	
	/**
	 * 
	 * @return String name of the property
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return the color of the property
	 */
	public String getColor() {
		return color;
	}
	
	public String toString() {
		return name;
	}
	
	/**
	 * 
	 * @return int cost per house
	 */
	public int getCostPerHouse() {
		return costPerHouse;
	}
}

//	ArrayList<ChanceCard> cards;
//	ArrayList<ChanceCard> discards;
//
//	public Property() {
//	cards = new ArrayList<ChanceCard>();
//	discards = new ArrayList<ChanceCard>();
//	
//		discards.add(new ChanceCard(0,"get out of jail free"));
//		discards.add(new ChanceCard(0,"pay tax of “$20 off of each property you own"));
//		discards.add(new ChanceCard(0,"bank pays you $20"));
//		discards.add(new ChanceCard(0,"collect $150 from each player"));
//		discards.add(new ChanceCard(1,"GO TO JAIL"));
//		discards.add(new ChanceCard(5,"advance to nearest utility"));
//		discards.add(new ChanceCard(8,"go back 3 spaces"));
//		discards.add(new ChanceCard(9,"advance to nearest train"));
//		
//		shuffle();
//	
//		return;
//	}	
//	
//	public void shuffle() {
//		System.out.println("shuffling chance cards");
//
//		Random random = new Random();
//		while(discards.size()>0) {
//			int index = Math.abs(random.nextInt()) % discards.size();
//			cards.add(discards.get(index));
//			discards.remove(index);
//		}
//	}
//
//}
	
	
	

