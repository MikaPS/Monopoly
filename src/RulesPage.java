import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * @author oryagour
 *@version 5/26
 *
 *This screen will represent the rules and instructions page after the menu
 */
public class RulesPage extends Screen {

	private DrawingSurface surface;
	
	private Rectangle rules, button1;

	public RulesPage(DrawingSurface surface) {
		super(1200,650);
		this.surface = surface;

		rules = new Rectangle(1200/2-300,650/2-200,600,300);
		button1 = new Rectangle(50,50,50,20);
	}

	/**
	 * draws the screen and adds the buttons and rules/instructions
	 */
	public void draw() {

		surface.pushStyle();
		
		surface.background(255,255,255);
		
		surface.rect(rules.x, rules.y, rules.width, rules.height, 10, 10, 10, 10);
		surface.fill(0);
		String str1 = "The game begins with each of the players on the space that says, \"Go\". \n" + 
				"\n"+
				"Each turn, one player will toss the dice and move accordingly\n" + 
				"\n"+
				"Whenever you land on property that no one owns, you can buy it from the bank.\n"+
				"\n"+
				"Once you own a place, players must pay rent if they are waiting on your land.\n" +
				"\n"+
				"Once you own all of the land of one color, you can start building houses.\n"+
				"\n"+
				"Houses make the land more costly, by adding to the rent price\n"+
				"\n"+
				"Once there are three houses on each land you can place a hotel.\n" +
				"\n"+
				"When you pass go, you collect $200 from the bank \n" + 
				"";
		float w = surface.textWidth(str1);
		surface.text(str1, 320 , 150);
		
		surface.fill(255);
		surface.rect(button1.x, button1.y, button1.width, button1.height, 10, 10, 10, 10);
		surface.fill(0);
		String str2 = "Back";
		float w2 = surface.textWidth(str2);
		surface.text(str2, button1.x+button1.width/2-w2/2, button1.y+button1.height/2+5);
		
		surface.popStyle();
	}



	/**
	 * When the mouse is clicked the method checks if it was in the area of the button
	 * if the click was inside the button it redirects the user to the menu screen
	 */
	public void mouseClicked() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (button1.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		
	
	}
	

}

