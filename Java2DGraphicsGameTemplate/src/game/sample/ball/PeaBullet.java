package game.sample.ball;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class of bullets which PeaShooters shoot
 *
 * @author Tahmine
 */
public class PeaBullet extends Bullet{

    /**
     * Initialize location and base image of a PeaBullet
     *
     * @param xLoc X location of a PeaBullet on the screen
     * @param yLoc Y location of a PeaBullet on the screen
     */
    public PeaBullet(int xLoc, int yLoc) {
        super(xLoc, yLoc);
        try {
            img = ImageIO.read(new File("bullet.png"));
        } catch (IOException e) {
        }
    }

    @Override
    public BufferedImage getImg() {
        return img;
    }

}
