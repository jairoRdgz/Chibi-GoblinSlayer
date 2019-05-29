package threads;

import ui.GameController;
/**
 * This class updates the position of the enemies
 * This class extends from Thread.
 * @author Critian Camilo Lasso
 * @author Jairo E. Rodriguez
 * @author Santiago Valencia
 *
 */
public class GUIMovingEnemy extends Thread{
	private GameController gcGUI;

	public GUIMovingEnemy(GameController gc) {
		gcGUI = gc;
	}
	
	 @Override
	 public void run() {
		 gcGUI.update();
	 }
}
