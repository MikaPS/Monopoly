import java.awt.Point;
import java.awt.Rectangle;

import processing.core.PImage;

/**
 * 
 * @author oryagour
 * @version 5/26
 * 
 * This screen will represent the menu page which the user reaches when starting the game
 */
public class OpeningScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle button1, button2;

	
	public OpeningScreen(DrawingSurface surface) {
		super(1200,650);
		this.surface = surface;

		button1 = new Rectangle(1200/2-100,650/2-75,200,100);
		button2 = new Rectangle(1200/2-100,650/2+75,200,100);
	}

/**
 * draws the screen and adds the buttons which will redirect the user to a different screen
 */
	public void draw() {

		surface.pushStyle();
		
		surface.background(255,255,255);
		
		surface.rect(button1.x, button1.y, button1.width, button1.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Start Game!";
		float w = surface.textWidth(str);
		surface.text(str, button1.x+button1.width/2-w/2, button1.y+button1.height/2);
		
		surface.fill(255);
		surface.rect(button2.x, button2.y, button2.width, button2.height, 10, 10, 10, 10);
		surface.fill(0);
		String str2 = "Rules";
		float w2 = surface.textWidth(str2);
		surface.text(str2, button2.x+button2.width/2-w2/2, button2.y+button2.height/2);
		
		surface.popStyle();
	}



/**
 * when the mouse is clicked the method checks if the click was within one of the buttons
 * if it was in button one is starts the game and if it was in number two it sends the user to
 * the rules and instructions page
 */
	public void mouseClicked() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button1.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN2);
		
		if(button2.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN3);
		}
	}
	

}

