/**
 * 
 * @author oryagour
 *@version 5/26/2020
 */

public interface ScreenSwitcher {
	public static final int SCREEN1 = 0;
	public static final int SCREEN2 = 1;
	public static final int SCREEN3 = 2;
	

	/**Switches to a different screen when called 
	 * 
	 * @param i the number of screen that will be projected
	 */
	public void switchScreen(int i);
}
