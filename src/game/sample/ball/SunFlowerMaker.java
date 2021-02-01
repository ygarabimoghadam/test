package game.sample.ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class SunFlowerMaker {
    public static int X, Y;
    private boolean mousePress;
    private ImageIcon imageIcon ;
    private Image sunFlowerCard;
    private Image mainImage ;
    private Image mainImage2 ;
    private Image sunFlower;
    private Image  imageGif;
    private Image  sunFlowerCardDead;
    private SunFlowerMaker.MouseHandler mouseHandler;
    public static boolean newCard = false ;
    private Long startTime;
    private  boolean StopWorking = false ;
    private  boolean done = false ;
    public ArrayList<Integer> MyX ;
    public ArrayList<Integer> MyY;
    Sun suns = new Sun();

    public SunFlowerMaker() {
            X = 110;
            Y = 35;
            //
            mousePress = false;
            //
            mouseHandler = new SunFlowerMaker.MouseHandler();
            //
            imageIcon = new ImageIcon("card_sunflower.png");
            sunFlowerCard = imageIcon.getImage();
            mainImage = sunFlowerCard;
            imageIcon = new ImageIcon("Sunflower.png");
            sunFlower = imageIcon.getImage();
            imageIcon = new ImageIcon("sun_flower.gif");
            imageGif = imageIcon.getImage();
            imageIcon = new ImageIcon("inactive_sunflower.png");
            sunFlowerCardDead = imageIcon.getImage();
            startTime = System.currentTimeMillis();
            MyX = new ArrayList<>();
            MyY = new ArrayList<>();
    }

    public Image getImage() {
        return mainImage;
    }

    public Image getImage2() {
        return mainImage2;
    }

    public Image getImage3() {
        return imageGif;
    }

    /**
     * The method which updates the game state.
     */
    public void update() {
        if(mousePress){

        suns.update();
        X = Math.max(X, 0);
        X = Math.min(X, GameFrame.GAME_WIDTH);
        Y = Math.max(Y, 0);
        Y = Math.min(Y, GameFrame.GAME_HEIGHT);}
        gettingActive();

    }

    public void gettingActive(){
        if(newCard){
            if((System.currentTimeMillis() - startTime) / 1000 > 7.5) {
            mainImage2 = sunFlowerCard;
            startTime = System.currentTimeMillis();
            StopWorking = false;
            }
        }
    }

    public MouseListener getMouseListener() {
        return mouseHandler;
    }

    public MouseMotionListener getMouseMotionListener() {
        return mouseHandler;
    }

    /**
     * The mouse handler.
     */
     class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if ((e.getX() >= 115 && e.getX() <= 205) && (e.getY() >= 35 && e.getY() <= 115)) {
                done = true;
                System.out.println(done);}
            System.out.println(e.getX());
            System.out.println(e.getY());
        }
        /*  @Override
        public void mousePressed(MouseEvent e) {
           /* if(NumberOfSuns.amount>0 && StopWorking==false) {
                if((e.getX()>80 && e.getX()<800)&&(e.getY()>80&& e.getY()<590)) {
                    locX = e.getX();
                    locY = e.getY();
                    mousePress = true;
                }
            } }*/

        @Override
        public void mouseReleased(MouseEvent e) {
            if (done) {
                int x = 0;
                int y = 0;
                if (NumberOfSuns.amount > 0 && StopWorking == false) {

                    if ((e.getX() > 80 && e.getX() < 800) && (e.getY() > 80 && e.getY() < 590)) {
                        mousePress = false;
                        NumberOfSuns num = new NumberOfSuns();
                        num.decrement(50);
                        newCard = true;
                        StopWorking = true;
                        x = e.getX();
                        y = e.getY();
                    /*if(e.getX()>135 && e.getX()<180){
                        x = 135;}
                     if(e.getX()>218 && e.getX()<256){
                        x = 215;}
                    if(e.getX()>314 && e.getX()<340){
                        x = 300;}
                    if(e.getX()>385 && e.getX()<435){
                        x = 320;}
                    if(e.getX()>475 && e.getX()<515){
                        x = 470;}
                    if(e.getX()>560 && e.getX()<605){
                        x = 560;}
                    if(e.getX()>640 && e.getX()<685){
                        x = 640;}
                    if(e.getX()>720 && e.getX()<770){
                        x = 720;}
                    if(e.getY()>145 && e.getY()<180){
                        y = 140;}
                    if(e.getY()>230 && e.getY()<270){
                        y = 220;}
                    if(e.getY()>365 && e.getY()<400){
                        y = 360;}
                    if(e.getY()>460 && e.getY()<510){
                        y = 450;}*/
                        MyX.add(x);
                        MyY.add(y);
                        mainImage2 = sunFlowerCardDead;
                        mainImage = null;
                    } else {
                        mainImage = null;
                    }
                }
                done = false;
           }
        }

        @Override
        public void mouseDragged(MouseEvent e) {

            if (done) {
                mousePress = true;
                if (NumberOfSuns.amount > 0 && StopWorking == false) {
                    if ((e.getX() > 80 && e.getX() < 800) && (e.getY() > 80 && e.getY() < 590)) {
                        X = e.getX();
                        Y = e.getY();
                        mainImage = sunFlower;
                    }
                }
            }
        }
     }
}
