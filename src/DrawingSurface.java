import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
/**
 * 
 * @author oryagour
 *@version 5/26
 *
 *this class is to be used by the current screen to call its methods 
 *and contains an array of all the screens
 *
 */
public class DrawingSurface extends PApplet implements ScreenSwitcher {

	public float ratioX, ratioY;
	
	private ArrayList<Integer> keys;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;

	
	public DrawingSurface() {
		
		
		screens = new ArrayList<Screen>();
		
		keys = new ArrayList<Integer>();
		
		
		OpeningScreen screen1 = new OpeningScreen(this);
		screens.add(screen1);
		
		GameScreen screen2 = new GameScreen(this);
		screens.add(screen2);
		
		RulesPage screen3 = new RulesPage(this);
		screens.add(screen3);
		
		activeScreen = screens.get(0);
		
	}
	/**
	 * sets the size of the window and screen
	 */
	public void settings() {
		// size(DRAWING_WIDTH, DRAWING_HEIGHT, P2D);
		size(activeScreen.DRAWING_WIDTH, activeScreen.DRAWING_HEIGHT);
	}
	/**
	 * calls the screens setup method to set up all that is required to run it
	 */
	public void setup() {
		surface.setResizable(true);
		for (Screen s : screens)
			s.setup();
	}
	/**
	 * calls the draw method of the screen and draws the actual screen
	 */
	public void draw() {
		ratioX = (float)width/activeScreen.DRAWING_WIDTH;
		ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

		pushMatrix();
		
		scale(ratioX, ratioY);
		
		activeScreen.draw();
		
		popMatrix();
	}
	


/**
 * checks if the mouse has been pressed down
 */
	public void mousePressed() {
		activeScreen.mouseClicked();
	}

	/**
	 * checks if the mouse has been released after being pressed
	 */
	public void mouseReleased() {
		activeScreen.mouseReleased();
	}
	
	/** 
	 * 
	 * @param assumed the point the mouse is in
	 * @return point which reprsents the point the mouse is assumed to be in 
	 */
	public Point assumedCoordinatesToActual(Point assumed) {
		return new Point((int)(assumed.getX()*ratioX), (int)(assumed.getY()*ratioY));
	}
	/** 
	 * 
	 * @param actual the point the mouse is in
	 * @return point which reprsents the point the mouse is actualy in 
	 */
	public Point actualCoordinatesToAssumed(Point actual) {
		return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
	}

	@Override
	/**
	 * switches to a different screen
	 * @param i represents the number of the screen in the screen array
	 */
	public void switchScreen(int i) {
		activeScreen = screens.get(i);
	}

}
