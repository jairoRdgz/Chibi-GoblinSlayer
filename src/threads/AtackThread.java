	package threads;

import ui.GameController;;
/**
 * This class is the thread that controls the attack of the player.
 * This class extends from Thread.
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class AtackThread extends Thread{
	
	private GameController game;
	
	public AtackThread(GameController gui) {
		game = gui;
	}
	
	public void run() {
		
		game.atack(1);
		try {
			sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.atack(2);
		
	}
	
}
