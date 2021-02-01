/*** In The Name of Allah ***/
package game.sample.ball;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * The window on which the rendering is performed.
 * This example uses the modern BufferStrategy approach for double-buffering, 
 * actually it performs triple-buffering!
 * For more information on BufferStrategy check out:
 *    http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 *    http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameFrame extends JFrame {
	
	public static final int GAME_HEIGHT = 720;                  // 720p game resolution
	public static final int GAME_WIDTH = 12 * GAME_HEIGHT /9;  // wide aspect ratio
	private ImageIcon imageIcon;
	private Image backGroundImage, planetBarImage, starImage,suns,test;
    private Font font ;
    private  long start ;
   // int z = 1 ;


	//uncomment all /*...*/ in the class for using Tank icon instead of a simple circle
	/*private BufferedImage image;*/ 

	private long lastRender;
	private ArrayList<Float> fpsHistory;
	private BufferStrategy bufferStrategy;
	
	public GameFrame(String title) {
		super(title);
		setResizable(false);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		imageIcon = new ImageIcon("backGround.jpg");
		backGroundImage = imageIcon.getImage();
		imageIcon = new ImageIcon("planetBar.gif");
		planetBarImage = imageIcon.getImage();
		imageIcon = new ImageIcon("star.png");
		starImage = imageIcon.getImage();
		font = new Font("", Font.BOLD, 30);
		imageIcon = new ImageIcon("sun.png");
		suns = imageIcon.getImage();
		imageIcon = new ImageIcon("sun_flower.gif");
		test = imageIcon.getImage();
		start = System.currentTimeMillis();



		lastRender = -1;
		fpsHistory = new ArrayList<>(100);

	/*	try{
			image = ImageIO.read(new File("Icon.png"));
		}
		catch(IOException e){
			System.out.println(e);
		}*/
	}
	
	/**
	 * This must be called once after the JFrame is shown:
	 *    frame.setVisible(true);
	 * and before any rendering is started.
	 */
	public void initBufferStrategy() {
		// Triple-buffering
		createBufferStrategy(3);
		bufferStrategy = getBufferStrategy();
	}

	
	/**
	 * Game rendering with triple-buffering using BufferStrategy.
	 */
	public void render(GameState state) {
		// Render single frame
		do {
			// The following loop ensures that the contents of the drawing buffer
			// are consistent in case the underlying surface was recreated
			do {
				// Get a new graphics context every time through the loop
				// to make sure the strategy is validated
				Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
				try {
					doRendering(graphics, state);
				} finally {
					// Dispose the graphics
					graphics.dispose();
				}
				// Repeat the rendering if the drawing buffer contents were restored
			} while (bufferStrategy.contentsRestored());

			// Display the buffer
			bufferStrategy.show();
			// Tell the system to do the drawing NOW;
			// otherwise it can take a few extra ms and will feel jerky!
			Toolkit.getDefaultToolkit().sync();

		// Repeat the rendering if the drawing buffer was lost
		} while (bufferStrategy.contentsLost());
	}
	
	/**
	 * Rendering all game elements based on the game state.
	 */
	private void doRendering(Graphics2D g2d, GameState state) {
		// Draw background
		/* g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		// Draw ball
		g2d.setColor(Color.BLACK);
		g2d.fillOval(state.locX, state.locY, state.diam, state.diam);*/

		/*		g2d.drawImage(image,state.locX,state.locY,null);*/

		g2d.drawImage(backGroundImage, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
		g2d.drawImage(starImage, 10, 30, 100, 100, null);
		g2d.drawImage(planetBarImage, 100, 30, 400, 100, null);
		NumberOfSuns n = new NumberOfSuns();
		String s = Integer.toString(n.amount);
		g2d.setColor(Color.BLACK);
		g2d.setFont(font);
		g2d.drawString(s, 30, 125);

		g2d.drawImage(state.sun.getImage(), state.sun.X, state.sun.Y, 100, 80, null);

		g2d.drawImage(state.shooter.getImage(), state.shooter.locX, state.shooter.locY, 100, 80, null);

		if (state.sun.newCard) {
			g2d.drawImage(state.sun.getImage2(), 120, 35, 100, 80, null);
		}
        if (state.shooter.nCard) {
            g2d.drawImage(state.shooter.getImage2(), 220, 35, 100, 80, null);
        }

		for (int i = 0; i < state.sun.MyX.size(); i++) {

          g2d.drawImage(state.sun.getImage3(), state.sun.MyX.get(i), state.sun.MyY.get(i), 80, 80, null);
          long x =state.mainYard.getObject(state.sun.MyY.get(i),state.sun.MyX.get(i)).getBornTime();

         if(( System.currentTimeMillis()-x)/( state.mainYard.getObject(state.sun.MyY.get(i),state.sun.MyX.get(i)).getMakeTime()*1000)>0){
          state.mainYard.getObject(state.sun.MyY.get(i),state.sun.MyX.get(i)).setBornTime(System.currentTimeMillis());
             state.mainYard.getObject(state.sun.MyY.get(i),state.sun.MyX.get(i)).increasCount();
         }
           for (int j=0;j<state.mainYard.getObject(state.sun.MyY.get(i),state.sun.MyX.get(i)).getCount();j++){
                g2d.drawImage(state.sun.getImage4(), state.sun.MyX.get(i) + (j*15), state.sun.MyY.get(i)+60, 40, 40, null);
           }

          /*/*  for (int z = 0; z < 5; z++) {
                for (int p = 0; p < 9; p++) {
                    for (int j=0;j<state.mainYard.getObject(0,j).getCount();j++){
                        g2d.drawImage(state.sun.getImage4(),  state.mainYard.getObject(z,p).getLocy()+ (p*15), state.mainYard.getObject(z,p).getLocX()+60, 40, 40, null);
                    }
                }}//////////*/
          }



		/*for (int j = 0; j < state.sun.MyY.size(); j++) {

			if (System.currentTimeMillis()> start + 10*z) {
			//if (state.suns.nowRun) {
				g2d.drawImage(state.suns.getSuns(), state.sun.MyX.get(j) + 60, state.sun.MyY.get(j) + 30, 60, 60, null);
				z++;
			}
		}*/

		//g2d.drawImage(state.shooter.getImage(), state.shooter.locX, state.shooter.locY, 100, 80, null);


		for (int i = 0; i < state.shooter.availableX.size(); i++) {

			g2d.drawImage(state.shooter.getImage3(), state.shooter.availableX.get(i), state.shooter.availableY.get(i), 80, 80, null);

		}






		//}
			/*for (int i = 0; i < state.sun.availableX.size(); i++) {

				 if ((System.currentTimeMillis() - start) / 1000 > 10) {
					 System.out.println(start);
					 g2d.drawImage(suns, state.sun.availableX.get(i) + 60, state.sun.availableY.get(i) + 30, 60, 60, null);

				 }*/

			//	start = System.currentTimeMillis();







	//	g2d.drawImage(test,110,45,80,100,null);

		//g2d.drawString(s,30,125);


		// Print FPS info
		/*long currentRender = System.currentTimeMillis();
		if (lastRender > 0) {
			fpsHistory.add(1000.0f / (currentRender - lastRender));
			if (fpsHistory.size() > 100) {
				fpsHistory.remove(0); // remove oldest
			}
			float avg = 0.0f;
			for (float fps : fpsHistory) {
				avg += fps;
			}
			avg /= fpsHistory.size();
			String str = String.format("Average FPS = %.1f , Last Interval = %d ms",
					avg, (currentRender - lastRender));
			g2d.setColor(Color.CYAN);
			g2d.setFont(g2d.getFont().deriveFont(18.0f));
			int strWidth = g2d.getFontMetrics().stringWidth(str);
			int strHeight = g2d.getFontMetrics().getHeight();
			g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, strHeight+50);
		}
		lastRender = currentRender;
		// Print user guide
		String userGuide
				= "Use the MOUSE or ARROW KEYS to move the BALL. "
				+ "Press ESCAPE to end the game.";
		g2d.setFont(g2d.getFont().deriveFont(18.0f));
		g2d.drawString(userGuide, 10, GAME_HEIGHT - 10);
		// Draw GAME OVER
		if (state.gameOver) {
			String str = "GAME OVER";
			g2d.setColor(Color.WHITE);
			g2d.setFont(g2d.getFont().deriveFont(Font.BOLD).deriveFont(64.0f));
			int strWidth = g2d.getFontMetrics().stringWidth(str);
			g2d.drawString(str, (GAME_WIDTH - strWidth) / 2, GAME_HEIGHT / 2);
		}*/
	}
	
}
