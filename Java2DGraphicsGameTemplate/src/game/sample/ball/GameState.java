/*** In The Name of Allah ***/
package game.sample.ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * This class holds the state of game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class
GameState {
	SunFlowerMaker sun;
	Sun suns ;
	Shooter shooter;
	public static yard mainYard;

	public GameState() {
	sun	= new SunFlowerMaker();
	suns = new Sun();
	shooter = new Shooter();
	mainYard=new yard();
	}

	public void update() {
		sun.update();
		suns.update();
		shooter.update();

	}

}

