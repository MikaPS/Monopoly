import java.util.ArrayList;
/**
 * @author Mika Peer, Or Yagour
 * @version 5/26/2020
 * 
 * represents a player object
 */

public class Player {

	//FIELDS
	private ArrayList<Property> myProperty;
	private ArrayList<String> myHouse;
	private int totalCash;
	private int spaceNum;
	private int playerNum;
	private boolean isTurn = false;
	private String name;
	private int numOfTrainStations;
	private int numOfUtilities;
	private int numOfHouses;
	private boolean canBuyHouses;
	private int inJail;
	private boolean hasGetOutOfJailCard;
	
	//CONSTRUCTOR
	public Player(int initCash, String name) {
		myProperty = new ArrayList<Property>();
		myHouse = new ArrayList<String>();
		totalCash = initCash;
		this.name = name;
		spaceNum = 0;
		numOfTrainStations = 0;
		numOfHouses = 0;
	}
	
	
	//METHODS
	/**
	 * 
	 * @return the total cash of the player
	 */
	public int getCash() {
		return totalCash;
	}
	
	/**
	 * look at the total cash of the person and check if it's greater than zero
	 * @return int 1 if the player loses, int 2 if they can keep playing.
	 */
	public int stateOfGame() {
		   if(totalCash <= 0) {
		       return 1;
		   }
		   return 2;
		}
	
	/**
	 * set the turn of the player
	 * @param turn boolean true if it is the player turn, false if isn't
	 */
	public void setTurn(boolean turn) {
		isTurn = turn;
	}
	
	/**
	 * 
	 * @return if it is the turn of the player
	 */
	public boolean isTurn() {
		return isTurn;
	}

	public int getSpaceNum() {
		return spaceNum;
	}

	public void setSpaceNum(int spaceNum) {
		this.spaceNum = spaceNum;
	}

	/**
	 * 
	 * @return the player number
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	/**
	 * 
	 * @return String, the name of the player
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * change the total cash the player has based on the param
	 * @param change int amount of money
	 */
	public void calculateMoney(int change) {
		totalCash += change;
	}
	
	/**
	 * 
	 * @return list of properties the player owns
	 */
	public ArrayList<Property> getProperty() {
		return myProperty;
	}
	
	/**
	 * add a new property to the list of owned properties
	 * @param p new property
	 */
	public void addProperty(Property p) {
		int count=0;
		
		for (Property other : myProperty) {
			if (other.getName().equals(p.getName()) || p.getOwner()!=playerNum) {
				count++;
				break;
			}
		}
		
		if (count==0)
			myProperty.add(p);
	}
	
	/**
	 * increase the number of train stations that the player own by 1
	 * @param p property the user wants to add
	 */
	public void setNumOfTrainStations(Property p) {
		int count=0;
		
		for (Property other : myProperty) {
			if (other.getName().equals(p.getName()) || p.getOwner()!=playerNum) {
				count++;
				break;
			}
		}
		
		if (count==0)
			numOfTrainStations++;
	}
	
	/**
	 * 
	 * @return number of train stations that the player owns
	 */
	public int getNumOfTrainStations() {
		return numOfTrainStations;
	}
	
	/**
	 * increase the number of utilities that the player own by 1
	 * @param p property the user wants to add
	 */
	public void setNumOfUtilities(Property p) {
		int count=0;
		
		for (Property other : myProperty) {
			if (other.getName().equals(p.getName()) || p.getOwner()!=playerNum) {
				count++;
				break;
			}
		}
		
		if (count==0)
			numOfUtilities++;
	}
	
	/**
	 * 
	 * @return the number of utilities that the player owns
	 */
	public int getNumOfUtilities() {
		return numOfUtilities;
	}
	
	/**
	 * check if the player owns all of the properties with the same color 
	 * @param p the property the user wants to buy house on
	 * @return true if the player can buy houses on this property, false otherwise
	 */
	public boolean canBuyHouse(Property p) {
		String color = p.getColor();
		int count=0;
		for (Property other : myProperty) {
			if (other.getColor().equalsIgnoreCase(color)) {
				count++;
			}
		}
		
		if (count==2) {
			if (color.equalsIgnoreCase("blue") || color.equalsIgnoreCase("brown")) {
				canBuyHouses = true;
			}
		}
		else if (count==3) {
			canBuyHouses = true;
		}
		
		return canBuyHouses;
	}
	
	/**
	 * 
	 * @return true if the player owns all of the properties with the same color, false otherwise
	 */
	public boolean getCanBuyHouse() {
		return canBuyHouses;
	}
	
	/**
	 * check of the player can buy house, and if they can add house at property p
	 * @param p the property the player wants to add a house at
	 */
	public void buyHouse(Property p) {
		int count=0;
		if (canBuyHouse(p)) {
			if (myHouse.size()>0) {
				for (String h : myHouse) {
					if (h.equalsIgnoreCase(p.getName())) {
						count++;
						break;
					}
				}
			}
			
			if (count==0) {
				calculateMoney(-p.getCostPerHouse());
				p.setRent(p.getRentWithHouse());
				myHouse.add(p.getName());
				numOfHouses++;
			}
		}
	}
	
	/**
	 * 
	 * @return the total amount of houses the player has
	 */
	public int getNumOfHouses() {
		return numOfHouses;
	}
	
	
	/**
	 * 
	 * @return integer between 0-3.
	 * 0 means the player is not at jail, 1-3 means the number of turns the player needs to wait before leaving jail
	 */
	public int getInJail() {
		return inJail;
	}
	
	/**
	 * set the number of turns the player needs to wait before leaving jail
	 * @param num int number of turns
	 */
	public void setInJail(int num) {
		inJail = num;
	}
	
	public boolean getGetOutOfJailCard() {
		return hasGetOutOfJailCard;
	}
	
	public void setGetOutOfJailCard(int n) {
		if (n==1)
			hasGetOutOfJailCard=false;
		else
			hasGetOutOfJailCard=true;
	}
	
	
	/**
	 * convert the list of properties to a list
	 */
	public String toString() {
		String result = "";		
		for (Property p : myProperty) {
			result = result + "\n" + p.toString();
		}
		return result;
	}
}

