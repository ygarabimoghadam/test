package game.sample.ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Sun {
    private ImageIcon imageIcon;
    private Image suns , mainImage;
    private Sun.MouseHandler mouseHandler;
    public static  boolean isClicked = false ;
    public static long start ;
    public static boolean nowRun = false  ;

    public Sun() {
        imageIcon = new ImageIcon("sun.png");
        suns = imageIcon.getImage();
        mouseHandler = new Sun.MouseHandler();
        start = System.currentTimeMillis() ;
    }

    private  void gettingActive() {
        if(isClicked) {
            if ((System.currentTimeMillis() - start) / 1000 > 5) {
                mainImage = null;
                start = System.currentTimeMillis();
            }
        }
    }
    public void active() {

        if ((System.currentTimeMillis() - start) / 1000 > 10) {
            nowRun = true ;
            System.out.println(nowRun);
            start = System.currentTimeMillis();
        }
    }

    public Image getSuns() {
        return suns;
    }

    public void update(){
       // nowRun = true ;
     //  active();
       // nowRun = false ;
      //  if(nowRun==false){
      //  gettingActive();
      //  if(mainImage!=null && !isClicked){
       //     mainImage = null;
     //   }
    //    isClicked = false ;
    }

    public MouseListener getMouseListener() {
        return mouseHandler;
    }
    public MouseMotionListener getMouseMotionListener() {
        return mouseHandler;
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            isClicked = true;
        }
    }
}
