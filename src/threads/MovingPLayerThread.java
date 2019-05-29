package threads;

import model.Player;
/**
 * This class helps to move the player
 * This class extends from Thread.
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class MovingPLayerThread extends Thread{
	private Player player;
	
	public MovingPLayerThread(Player play) {
		player = play;
	}
	
	@Override
	public void run() {
		
	}
}
