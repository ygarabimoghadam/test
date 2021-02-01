package game.sample.ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Shooter {
    public static int locX, locY;
    private boolean mousePress;
    protected ArrayList<Bullet> bulletArr;
    private ImageIcon imageIcon ;
    private Image shooterCard;
    private Image mainImage ;
    private Image mainImage2 ;
    private Image shooterFlower;
    private Image  imageGif;
    private Image shooterFlowerCardDead;
    private ShooterMouseHandler mouseHandler;
    public static boolean nCard = false ;
    private Long startTime;
    private   boolean StopWorking = false ;
    private   boolean done = false ;
    public ArrayList<Integer> availableX ;
    public ArrayList<Integer> availableY;

    public Shooter(){
        locX = 220;
        locY = 35;
        //
        mousePress = false;
        //
        mouseHandler = new Shooter.ShooterMouseHandler();
        //
        imageIcon = new ImageIcon("card_peashooter.png");
        shooterCard = imageIcon.getImage();
        mainImage = shooterCard;
        imageIcon = new ImageIcon("PeaShooter.png");
        shooterFlower = imageIcon.getImage();
        imageIcon = new ImageIcon("pea_shooter.gif");
        imageGif = imageIcon.getImage();
        imageIcon = new ImageIcon("inactive_peashooter.png");
        shooterFlowerCardDead = imageIcon.getImage();
        startTime = System.currentTimeMillis();
        availableX = new ArrayList<Integer>();
        availableY = new ArrayList<Integer>();
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

    public void update() {
        if(mousePress){

            locX = Math.max(locX, 0);
            locX = Math.min(locX, GameFrame.GAME_WIDTH);
            locY = Math.max(locY, 0);
            locY = Math.min(locY, GameFrame.GAME_HEIGHT);
        }

        gettingActive();
    }


    public void gettingActive(){
        if(nCard){
            if((System.currentTimeMillis() - startTime) / 1000 > 7.5) {
                mainImage2 = shooterCard;
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
    class ShooterMouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
                if ((e.getX() >= 220 && e.getX() <= 312) && (e.getY() >= 35 && e.getY() <= 115)) {
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
                if (NumberOfSuns.amount >= 100 && StopWorking == false) {

                    if ((e.getX() > 80 && e.getX() < 880) && (e.getY() > 80 && e.getY() < 700)&&GameState.mainYard.isEmpty(e.getY(),e.getX() )) {
                        mousePress = false;
                        NumberOfSuns num = new NumberOfSuns();
                        num.decrement(100);
                        nCard = true;
                        StopWorking = true;
                        GameState.mainYard.addShooter(e.getY(),e.getX());
                        x=GameState.mainYard.castLocy(e.getX());
                        y=GameState.mainYard.castLocx(e.getY());

                        availableX.add(x);
                        availableY.add(y);
                        mainImage2 = shooterFlowerCardDead;
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
          if(done){
                mousePress = true;
                if (NumberOfSuns.amount > 0 && StopWorking == false) {
                    if ((e.getX() > 80 && e.getX() < 800) && (e.getY() > 80 && e.getY() < 590)) {
                        locX = e.getX();
                        locY = e.getY();
                        mainImage = shooterFlower;
                    }

                }
            }
        }
    }
}

