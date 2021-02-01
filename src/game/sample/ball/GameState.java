package game.sample.ball;

/**
 * This class holds the state of game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {
	SunFlowerMaker sun;
	Sun suns ;
	Shooter shooter;
	NormalZombie nz ;

	public GameState() {
	sun	= new SunFlowerMaker();
	suns = new Sun();
	shooter = new Shooter();
	nz = new NormalZombie();
	}

	public void update() {
		sun.update();
		suns.update();
		shooter.update();
		nz.update();
	}
}

