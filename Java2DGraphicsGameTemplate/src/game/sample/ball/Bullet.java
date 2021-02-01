package game.sample.ball;

import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * An abstract class which is superClass of two other classes
 *
 * @author Tahmine
 */
public abstract class Bullet {
    protected BufferedImage img;
    protected int locX;
    protected int locY;
    protected int x = -1, y = -1;

    /**
     * Initialize location of Bullet with the given parameters
     *
     * @param xLoc X location of a Bullet on the screen
     * @param yLoc Y location of a Bullet on the screen
     */
    public Bullet(int xLoc, int yLoc) {
        locX = xLoc;
        locY = yLoc;
    }

    public void move() {
        locX = locX + 1;
    }


    public abstract BufferedImage getImg();

}
