package game.sample.ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class SunFlowerMaker extends yardBlocks{
    public static int X, Y;
    private boolean mousePress;
    private ImageIcon imageIcon ;
    private Image sunFlowerCard;
    private Image mainImage ;
    private Image mainImage2 ;
    private Image sunFlower;
    private Image imageGif;
    private Image sunFlowerCardDead;
    private Image sunImage ;
    private SunFlowerMaker.MouseHandler mouseHandler;
    public static boolean newCard = false ;
    private Long startTime;
    private  boolean StopWorking = false ;
    private  boolean done = false ;
    public ArrayList<Integer> MyX ;
    public ArrayList<Integer> MyY;
    public ArrayList<Integer> MySunX ;
    public ArrayList<Integer> MySunY;
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
            imageIcon=new ImageIcon("sun.png");
            sunImage=imageIcon.getImage();
            startTime = System.currentTimeMillis();
            MyX = new ArrayList<Integer>();
            MyY = new ArrayList<Integer>();
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

    public Image getImage4() {
        return sunImage;
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
    /*/public void sunBorn(){
        for (int z = 0; z < 5; z++) {
            for (int j = 0; j < 9; j++) {
                if (GameState.mainYard.getYard()[z][j].getName() == "flower") {
                    if ((System.currentTimeMillis() - GameState.mainYard.getYard()[z][j].getBornTime()) % 20000 == 0) {
                        MySunX.add(GameState.mainYard.getYard()[z][j].getLocy());
                        MySunY.add(GameState.mainYard.getYard()[z][j].getLocX());
                    }
                }
            }
        }
    }*/

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
            else if(!((e.getX() >= 100 && e.getX() <= 500) && (e.getY() >= 30 && e.getY() <= 130))){
                int x = 0;
                int y = 0;
                x = e.getX();
               y = e.getY();
               if(GameState.mainYard.getObject(y,x).getCount()>0){
                   GameState.mainYard.getObject(y,x).decreasCount();
                   NumberOfSuns num = new NumberOfSuns();
                   num.increment(50);

               }
            }
            //System.out.println(e.getX());
           // System.out.println(e.getY());
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
                if (NumberOfSuns.amount >= 50 && StopWorking == false ) {

                    if ((e.getX() > 80 && e.getX() < 880) && (e.getY() > 100 && e.getY() < 700)&& GameState.mainYard.isEmpty(e.getY(),e.getX() )) {
                        mousePress = false;
                        NumberOfSuns num = new NumberOfSuns();
                        num.decrement(50);
                        newCard = true;
                        StopWorking = true;

                        GameState.mainYard.addSunFlowerL1(e.getY(),e.getX());

                        x=GameState.mainYard.castLocy(e.getX());
                        y=GameState.mainYard.castLocx(e.getY());

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
                    if ((e.getX() > 80 && e.getX() < 880) && (e.getY() > 80 && e.getY() < 700)) {
                        X = e.getX();
                        Y = e.getY();
                        mainImage = sunFlower;
                    }
                }
            }
        }

     }
}
