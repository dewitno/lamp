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

/** Exercise for defining objects.
 *  This program contains methods for testing Lamp objects.
 *  It is all written for you, but you need to read it to see 
 *  what the Lamp class should do.
 */

public class ObjectsExercise {

    // the lamps: need to be in a field because two different methods need to access it.
    private Lamp myLamp; 
    private Lamp yrLamp;

    /** Makes several Lamp objects */
    public void createLamps() {
        UI.clearPanes();

        myLamp = new Lamp(100, 150);
        myLamp.draw();
        yrLamp = new Lamp(300, 250);
        yrLamp.draw();

        UI.println("Click on the lamps to turn them on and off and change their color");
    }	

    /** Manages the Lamp objects */
    public void manageLamps(String action, double x, double y) {
        if (action.equals("released")){
            if (myLamp==null || yrLamp==null) {
                UI.printMessage("Press Lamps button first to create some lamps");
                return;  // the lamps haven't been constructed yet.
            }
            if (myLamp.onBulb(x,y)){
                myLamp.changeColor();
                myLamp.draw();
            }
            else if (myLamp.onStem(x,y)){
                myLamp.turnOff();
                myLamp.draw();
            }
            else if (yrLamp.onBulb(x,y)){
                yrLamp.changeColor();
                yrLamp.draw();
            }
            else if (yrLamp.onStem(x,y)){
                yrLamp.turnOff();
                yrLamp.draw();
            }
        }
    }	


    public void clear() {
        UI.clearPanes();
        myLamp = null;
        yrLamp = null;
    }

    // Main
    /** Create a new ObjectExercise object and setup the interface */
    public static void main(String[] args) {
        ObjectsExercise oe = new ObjectsExercise();
        UI.setMouseListener(oe::manageLamps);   // the mouse will switch on/off the lamps
        UI.addButton("Clear", oe::clear );
        UI.addButton("Lamps", oe::createLamps );
        UI.addButton("Quit", UI::quit );        
    }

}
