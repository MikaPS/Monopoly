import java.util.Timer;
import java.util.TimerTask;

import processing.core.PApplet;

/**
 * 
 * @author mika peer
 * @version 5/26/2020
 * 
 * represnts a die object
 */
public class Die {
	private int up;
	private int dieSize = 35;
	
	/**
	 * gets a random number between 1-6
	 */
	public void roll() {
		up = (int)(Math.random() * 6 + 1);
	}
	
	/**
	 * gets number of dots on the side of the die that faces up
	 * @return number between 1-6
	 */
	public int getNumDots() {
		//System.out.println(up);
		return up;
	}
	
/* i tried to do it this way, but it caused an error
	public void move(PApplet marker, int xCenter, int yCenter) {	
		int savedTime = marker.second(); //current time in ms
		int totalTime = 3; //1 second
		int passedTime = marker.second() - savedTime;
//		System.out.println(savedTime);
//		System.out.println(passedTime);

		if (passedTime > totalTime) {
			System.out.println("check");
			drawRolling(marker, xCenter, yCenter);
			savedTime = marker.second(); // save the current time to restart the timer
		}
		drawStopped(marker, xCenter, yCenter);
	}
*/
	/**
	 * draws a rolling dice
	 * @param marker PApplet parameter which is used to draw the die
	 * @param xCenter int parameter that located the x coordinate of top left corner of the die
	 * @param yCenter int parameter that located the y coordinate of top left corner of the die
	 */
	 public void drawRolling(PApplet marker, int xCenter, int yCenter) {
	    int x = xCenter;
	    int y = yCenter;
	   
	    marker.fill(255,0,0);
	    marker.stroke(255,0,0);
	    marker.rect(x, y, dieSize, dieSize, dieSize/4);

	    Die die = new Die();
	    die.roll();
	    drawDots(marker, x, y, die.getNumDots());
	 }
	 
	 /**
	  * a die with one side up
	  * @param marker marker PApplet parameter which is used to draw the die
	  * @param xCenter int parameter that located the x coordinate of top left corner of the die
	  * @param yCenter int parameter that located the y coordinate of top left corner of the die
	  */
	public void drawStopped(PApplet marker, int xCenter, int yCenter) {
	    int x = xCenter;
	    int y = yCenter;
	    marker.fill(255,0,0);
	    marker.stroke(255,0,0);
	    marker.rect(x, y, dieSize, dieSize, dieSize/4);
	    drawDots(marker, x, y, getNumDots());
	}
	 
	/**
	 * draw number of dots on a die based on the parameter numDots
	 *  @param marker marker PApplet parameter which is used to draw the die
	 * @param xCenter int parameter that located the x coordinate of top left corner of the die
	 * @param yCenter int parameter that located the y coordinate of top left corner of the die
	 * @param numDots int number of dots you want on the die
	 */
	private void drawDots(PApplet marker, int x, int y, int numDots) {
		marker.fill(255);
	    marker.stroke(255);
		 
	    int dotSize = dieSize/5;
	    int step = dieSize/8;
	    int x1 = x + 2*step; 
	    int x2 = x + dieSize/2;  
	    int x3 = x + dieSize - 2*step; 
	    int y1 = y + 2*step; 
	    int y2 = y + dieSize/2; 
	    int y3 = y + dieSize - 2*step; 

	    switch (numDots) {
	      case 1:
	        marker.circle(x2, y2, dotSize);
	        break;
	        
	      case 2:
	        marker.circle(x1, y3, dotSize);
	        marker.circle(x3, y1, dotSize);
	    	break;
	    	
	      case 3:
	        marker.circle(x1, y3, dotSize);
	      	marker.circle(x2, y2, dotSize);
	    	marker.circle(x3, y1, dotSize);
	    	break;
	    	
	      case 4:
	        marker.circle(x1, y1, dotSize);
	        marker.circle(x1, y3, dotSize);
	      	marker.circle(x3, y1, dotSize);
	    	marker.circle(x3, y3, dotSize);
	    	break;
	    	
	      case 5:
	          marker.circle(x1, y1, dotSize);
	          marker.circle(x1, y3, dotSize);
	          marker.circle(x2, y2, dotSize);
	          marker.circle(x3, y1, dotSize);
	          marker.circle(x3, y3, dotSize);
	    	break;
	    	
	      case 6:
	        marker.circle(x1, y1, dotSize);
	        marker.circle(x1, y2, dotSize);
	        marker.circle(x1, y3, dotSize);
	        marker.circle(x3, y1, dotSize);
	      	marker.circle(x3, y2, dotSize);
	    	marker.circle(x3, y3, dotSize);
	    	break;
	    }
	}
}
