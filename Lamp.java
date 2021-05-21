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
    private double stemX; 
    private double stemY;
    private double lampX;
    private double lampY;
    private String status = "on";
    Color col = Color.yellow;
    
    /** Constructor: passed the initial position.
     * Initialises the fields
     */
    public Lamp(double x, double y){
        this.lampX = x;
        this.lampY = y;
        this.stemY = this.lampY+this.SIZE;
        this.stemX = this.lampX+stemWidth+SIZE/8;
        UI.setColor(col);
    }

    /**
     * draws the lamp at its current position:
     * - the bulb of the right colour.
     * - the stem darkGray
     * The height of the stem is the same as the diameter of the bulb
     * The width of the stem is a quater of its height
     */
    public void draw(){
        UI.fillOval(this.lampX, this.lampY, this.SIZE, this.SIZE);
        UI.setColor(Color.darkGray);
        UI.fillRect(this.stemX,this.stemY,this.stemWidth,this.SIZE);
        

    }   

    /** 
     * Reports whether the point (x,y) is on the bulb.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onBulb(double x, double y){
        // an easy approximation is to pretend it is the enclosing rectangle.
        if ((x >= this.lampX) && (x <= this.lampX + this.SIZE) && (y >= this.lampY) && (y <= this.lampY + this.SIZE)) {
            return true;
        } else {
            return false;
        }
        // It is nicer to do a little bit of geometry and get it right       
    }   

    /**
     * Reports whether the point (x,y) is on the stem.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onStem(double x, double y){
        if ((x >= this.stemX) && (x <= this.stemX + this.stemWidth) && (y >= this.stemY) && (y <= this.stemY + this.SIZE)) {
            return true;
        } else {
            return false;
        }
    }   

    /**
     * Turns the light off.
     * Does not redraw
     */
    public void turnOff(){
        UI.setColor(Color.black);
        this.status = "off";
    }   

    /** changeColor method (no parameters):
     * Turns the light on (if it is off)
     * Changes its color to a random bright colour (if it is already on).
     * Does not redraw
     */
    public void changeColor(){
        if (this.status != "on") {
            UI.setColor(col);
            this.status = "on";
        } else {
            col = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
            UI.setColor(col);
        }
    }   
}
