/**
 * 
 * @author oryagour
 *@version 5/26/2020
 */
public class ExerciseCards {
	int  newLocation;
	double amount;
	String label;
	boolean relocation;	

	public ExerciseCards(String cardname) {
		label = cardname;
	}
/**
 * 
 * @return String which contains the instructions on the card
 */
	public String getName() {
		return label;
	}
	
}

