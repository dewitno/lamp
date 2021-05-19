    // This program is copyright VUW.
// You are granted permission to use it to construct your answer to a Onslow College 13DTC assignment.
// You may not distribute it in any other way without permission.

/* Exercise for Onslow College 13DTC
 * Name:
 * Email:
 * Date:
 */

import ecs100.*;
import java.awt.Color;

/** A Lamp object represents a table lamp on the graphics pane. A lamp consists of a colored bulb and a stem.
 *   It remembers its current position, its color and whether it is on or off.
 *   Its initial position and its color are set when it is constructed.
 *   The diameter of a bulb should be 80.
 *   The height of the stem should be 80.
 *   The width of the stem should be 20.
 *   It has three methods:
 *     draw(),        which draws the lamp at its current position.
 *     onBulb(x,y),   which reports whether the point(x,y) is on the bulb.
 *     onStem(x,y),   which reports whether the point(x,y) is on the stem.
 *     turnOff(),     which turns the light off.
 *     changeColor(), which turns the light on if it is off; changes its color to a random bright colour if it is already on. 
 */

public class Lamp{

    public static final double SIZE = 80;  // diameter of the bulb and height of the stem
    // width of the stem is SIZE/4
    private double stemWidth = SIZE/4;
    //fields
    private double stemAddX = stemWidth+SIZE/8; 
    private double lampX;
    private double lampY;

    /** Constructor: passed the initial position.
     * Initialises the fields
     */
    public Lamp(double x, double y){
        this.lampX = x;
        this.lampY = y;
    }

    /**
     * draws the lamp at its current position:
     * - the bulb of the right colour.
     * - the stem darkGray
     * The height of the stem is the same as the diameter of the bulb
     * The width of the stem is a quater of its height
     */
    public void draw(){
        UI.setColor(Color.gray);
        UI.fillRect(this.lampX+this.stemAddX,this.lampY+this.SIZE,this.stemWidth,this.SIZE);
        UI.setColor(Color.yellow);
        UI.fillOval(this.lampX, this.lampY, this.SIZE, this.SIZE);
        

    }   

    /** 
     * Reports whether the point (x,y) is on the bulb.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onBulb(double x, double y){
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        
        return true;
    }   

    /**
     * Reports whether the point (x,y) is on the stem.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onStem(double x, double y){
        
        return true;
    }   

    /**
     * Turns the light off.
     * Does not redraw
     */
    public void turnOff(){
        

    }   

    /** changeColor method (no parameters):
     * Turns the light on (if it is off)
     * Changes its color to a random bright colour (if it is already on).
     * Does not redraw
     */
    public void changeColor(){
        

    }   
}
