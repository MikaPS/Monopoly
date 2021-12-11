/**
 * 
 * @author oryagour
 *@version 5/26/2020
 *
 *will represent a Ice breaker card object and its structure
 */
public class IceBreakerCards {


	String label;
	
	
	public IceBreakerCards( String cardname) {

		label = cardname;

	}

/**
 * 
 * @return String which represents the instruction on the card 
 */
	public String getName() {
		
		return label;
		
	}

}
