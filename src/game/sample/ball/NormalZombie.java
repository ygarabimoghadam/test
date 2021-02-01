package game.sample.ball;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NormalZombie{
    private ImageIcon imageIcon;
    private Image nZombie;
    private int random = 0 ;
    public int [] zY ;
    public int  [] zx ;
    public boolean speed = false ;
    public boolean done = false ;
    private long start ;
    int i  = 0 ;
    public static int  counter = -1 ;

    public NormalZombie(){
        imageIcon = new ImageIcon("zombie_normal.gif");
        zx = new int [35];
        zY = new int[ 35 ] ;
        nZombie = imageIcon.getImage();
        start = System.currentTimeMillis();

    }

    public Image getnZombie() {
        return nZombie;
    }

    public void update(){
        active();
        activeNew();

    }

    private  void active(){
        for(int i =  0 ; i < zx.length ; i++){
            zx[i] = (int) (zx[i] - 0.75);
        }
    }

    private void activeNew(){
        if(counter<3) {
            if ((System.currentTimeMillis() - start) / 1000 > 30) {
                done = true;
                speed = true;
                choice();
                counter++;
                System.out.println(random);
                start = System.currentTimeMillis();
                System.out.println("counter: " +counter);
            }
        }
        else if(counter>=3 && counter<10){
            if ((System.currentTimeMillis() - start) / 1000 > 30) {
                done = true;
                speed = true;
                choice();
                System.out.println("1"+random);
                counter++;
                choice();
                counter++;
                System.out.println("2"+random);
                System.out.println("counter+: "+counter);
                start = System.currentTimeMillis();
            }
        }
    }

    public void randomGenerator(){
        Random r = new Random();
         random = r.nextInt(5) + 1;

    }

    public void choice() {
        randomGenerator();
        if (done) {
            if (i < 35) {

                randomGenerator();

                if (random == 1) {
                    zY[i] = 185;
                    zx[i] = 920;
                }
                if (random == 2) {
                    zY[i]= 280;
                    zx[i] = 920;
                }
                if (random == 3) {
                    zY[i] = 384;
                    zx[i] = 920;
                }
                if (random == 4) {
                    zY[i] = 500;
                    zx[i] = 920;
                }
                if (random == 5) {
                    zY[i] = 597;
                    zx[i] = 920;
                }
            }
        }
        done = false ;

        i++ ;
    }
}
